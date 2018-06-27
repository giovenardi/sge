package br.com.lummi.sge.controllers;

import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.lummi.sge.enums.EstadoCivilEnum;
import br.com.lummi.sge.enums.SexoEnum;
import br.com.lummi.sge.exceptions.SgeException;
import br.com.lummi.sge.models.Fornecedor;
import br.com.lummi.sge.models.PaginatedList;
import br.com.lummi.sge.models.PessoaFisica;
import br.com.lummi.sge.models.PessoaJuridica;
import br.com.lummi.sge.models.transiente.RetornoJson;
import br.com.lummi.sge.service.FornecedorService;
import br.com.lummi.sge.service.PessoaFisicaService;
import br.com.lummi.sge.service.PessoaJuridicaService;
import br.com.lummi.sge.service.PessoaService;
import br.com.lummi.sge.service.UfService;
import br.com.lummi.sge.utils.Mensagens;

@Path("/fornecedor")
@Controller
public class FornecedorController {

	@Inject
	private Result result;
	@Inject
	private FornecedorService service;
	@Inject
	private UfService ufService;
	@Inject
	private PessoaFisicaService pessoaFisicaService;
	@Inject
	private PessoaService pessoaService;
	@Inject
	private PessoaJuridicaService pessoaJuridicaService;

	@Get
	@Path({ "/", "" })
	public PaginatedList index(int page) {
		Fornecedor fornecedor = (Fornecedor) result.included().get("fornecedor");
		if (fornecedor == null) {
			fornecedor = new Fornecedor();
		}
		return index(fornecedor, page, 10, true);
	}

	@Post
	@Path({ "/", "" })
	public PaginatedList index(Fornecedor fornecedor, int page, int tamanho, boolean get) {
		result.include("fornecedor", fornecedor);
		if (tamanho == 0) {
			tamanho = 10;
		}
		PaginatedList lista = service.findByFiltro(fornecedor, page, tamanho);

		if (lista.getCount() == 0) {
			result.include("warning", Mensagens.MSG_NENHUM_REGISTRO);
		}
		montarCombos(null);
		return lista;
	}

	@Get
	@Path("/buscarPorCPF/{cpf}")
	public void novo(String cpf) throws SgeException {
		PessoaFisica pessoa = pessoaFisicaService.getByCpf(cpf);
		if (pessoa == null) {
			pessoa = new PessoaFisica();
			pessoa.setCpf(cpf);
		}
		if (pessoa.getFornecedor() != null) {
			result.include("error", "Fornecedor já cadastrado!");
			result.include("fornecedor", pessoa.getFornecedor());
			result.redirectTo(this).index(0);
		} else {
			Fornecedor fornecedor = new Fornecedor();
			fornecedor.setPessoa(pessoa);
			montarCombos(fornecedor);
		}
	}

	@Get
	@Path("/buscarPorCNPJ/{cnpj}")
	public void novoPJ(String cnpj) throws SgeException {
		PessoaJuridica pessoa = pessoaJuridicaService.getByCnpj(cnpj);
		if (pessoa == null) {
			pessoa = new PessoaJuridica();
			pessoa.setCnpj(cnpj);
		}
		if (pessoa.getFornecedor() != null) {
			result.include("error", "Fornecedor já cadastrado!");
			result.include("fornecedor", pessoa.getFornecedor());
			result.redirectTo(this).index(0);
		} else {
			Fornecedor fornecedor = new Fornecedor();
			fornecedor.setPessoa(pessoa);
			montarCombos(fornecedor);
		}
	}

	@Get
	@Path({ "/novo", "/novo/" })
	public void novo() {
		montarCombos(new Fornecedor());
	}

	@Post
	@Path("/salvar")
	@Transactional
	public void salvar(Fornecedor fornecedor) {
		RetornoJson<Fornecedor> retornoJson = new RetornoJson<Fornecedor>();
		if (fornecedor.getId() == null && service.buscarPorIdPessoa(fornecedor.getPessoa().getId()) > 0) {
			retornoJson.setError("Fornecedor já cadastrado!");
		} else {
			fornecedor.setPessoa(pessoaService.getById(fornecedor.getPessoa().getId()));
			if (fornecedor.getId() == null) {
				fornecedor = service.create(fornecedor);
				retornoJson.setSuccess(Mensagens.MSG_INCLUSAO_OK);
			} else {
				fornecedor = service.update(fornecedor);
				retornoJson.setSuccess(Mensagens.MSG_EDICAO_OK);
			}
		}
		retornoJson.setObj(fornecedor);
		result.use(Results.json()).from(retornoJson).include("?obj", "?obj.pessoa", "?obj.cargo", "?obj.setor")
				.serialize();
		;
	}

	@Get
	@Path("/editar")
	public void editar(Fornecedor fornecedor) {
		RetornoJson<Fornecedor> retornoJson = new RetornoJson<Fornecedor>();
		fornecedor = service.getById(fornecedor.getId());
		if (fornecedor == null) {
			retornoJson.setError(Mensagens.MSG_NENHUM_REGISTRO);
		} else {
			retornoJson.setObj(fornecedor);
		}
		result.use(Results.json()).from(retornoJson).include("?obj", "?obj.cargo", "?obj.setor", "?obj.pessoa")
				.serialize();
	}

	@Post
	@Path("/novo")
	@Transactional
	public void novo(Fornecedor fornecedor) {
		try {
			service.create(fornecedor);
			result.redirectTo(this).index(0);
		} catch (Exception e) {
			montarCombos(fornecedor);
			result.include("error", e.getMessage());
		}
	}

	@Get
	@Path("/show/{id}")
	public Fornecedor show(Integer id) {
		Fornecedor fornecedor = null;
		try {
			fornecedor = service.getById(id);
			montarCombos(fornecedor);
		} catch (Exception e) {
			result.include("error", e.getMessage());
			result.redirectTo(this).index(0);
		}
		return fornecedor;
	}

	@Get
	@Path("/alterar/{id}")
	public Fornecedor alterar(Integer id) {
		Fornecedor fornecedor = null;
		try {
			fornecedor = service.getById(id);
			montarCombos(fornecedor);
		} catch (Exception e) {
			result.include("error", e.getMessage());
			result.redirectTo(this).index(0);
		}
		return fornecedor;
	}

	@Post
	@Path("/alterar")
	@Transactional
	public void alterar(Fornecedor fornecedor) {
		try {
			service.update(fornecedor);
			result.redirectTo(this).index(0);
		} catch (Exception e) {
			montarCombos(fornecedor);
			result.include("error", e.getMessage());
		}
	}

	private void montarCombos(Fornecedor fornecedor) {
		try {
			result.include("fornecedor", fornecedor);
			result.include("sexos", SexoEnum.values());
			result.include("estadosCivis", EstadoCivilEnum.values());
			result.include("ufs", ufService.all());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}