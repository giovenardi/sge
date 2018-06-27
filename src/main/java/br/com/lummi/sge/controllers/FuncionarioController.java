package br.com.lummi.sge.controllers;

import java.util.List;

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
import br.com.lummi.sge.models.Funcionario;
import br.com.lummi.sge.models.transiente.RetornoJson;
import br.com.lummi.sge.service.CargoService;
import br.com.lummi.sge.service.FuncionarioService;
import br.com.lummi.sge.service.PessoaFisicaService;
import br.com.lummi.sge.service.SetorService;
import br.com.lummi.sge.service.UfService;
import br.com.lummi.sge.utils.Mensagens;

@Path("/funcionario")
@Controller
public class FuncionarioController {

	@Inject
	private Result result;
	@Inject
	private FuncionarioService service;
	@Inject
	private CargoService cargoService;
	@Inject
	private SetorService setorService;
	@Inject
	private UfService ufService;
	@Inject
	private PessoaFisicaService pessoaFisicaService;

	@Get
	@Path({ "/", "" })
	public List<Funcionario> index() {
		List<Funcionario> lista = service.all("pessoa.nome");
		if (lista.isEmpty()) {
			result.include("warning", Mensagens.MSG_NENHUM_REGISTRO);
		}
		montarCombos(null);
		return lista;
	}

//	@Get
//	@Path({ "/", "" })
//	public PaginatedList index(int page) {
//		Funcionario funcionario = (Funcionario) result.included().get("funcionario");
//		if (funcionario == null) {
//			funcionario = new Funcionario();
//		}
//		return index(funcionario, page, 10, true);
//	}
//
//	@Post
//	@Path({ "/", "" })
//	public PaginatedList index(Funcionario funcionario, int page, int tamanho, boolean get) {
//		result.include("funcionario", funcionario);
//		if (tamanho == 0) {
//			tamanho = 10;
//		}
//		PaginatedList lista = service.findByFiltro(funcionario, page, tamanho);
//
//		if (lista.getCount() == 0) {
//			result.include("warning", Mensagens.MSG_NENHUM_REGISTRO);
//		}
//		montarCombos(null);
//		return lista;
//	}
//
//	@Get
//	@Path("/buscarPorCPF/{cpf}")
//	public void novo(String cpf) throws SgeException {
//		PessoaFisica pessoa = pessoaFisicaService.getByCpf(cpf);
//		if (pessoa == null) {
//			pessoa = new PessoaFisica();
//			pessoa.setCpf(cpf);
//		}
//		if (pessoa.getFuncionario() != null) {
//			result.include("error", "Funcionário já cadastrado!");
//			result.include("funcionario", pessoa.getFuncionario());
//			result.redirectTo(this).index(0);
//		} else {
//			Funcionario funcionario = new Funcionario();
//			funcionario.setPessoa(pessoa);
//			montarCombos(funcionario);
//		}
//	}
//
//	@Get
//	@Path({ "/novo", "/novo/" })
//	public void novo() {
//		montarCombos(new Funcionario());
//	}

	@Post
	@Path("/salvar")
	@Transactional
	public void salvar(Funcionario funcionario) {
		RetornoJson<Funcionario> retornoJson = new RetornoJson<Funcionario>();
		if (funcionario.getId() == null && service.buscarPorIdPessoa(funcionario.getPessoa().getId()) > 0) {
			retornoJson.setError("Funcionário já cadastrado!");
		} else {
			funcionario.setPessoa(pessoaFisicaService.getById(funcionario.getPessoa().getId()));
			if (funcionario.getCargo() != null && funcionario.getCargo().getId() != null) {
				funcionario.setCargo(cargoService.getById(funcionario.getCargo().getId()));
			}
			if (funcionario.getSetor() != null && funcionario.getSetor().getId() != null) {
				funcionario.setSetor(setorService.getById(funcionario.getSetor().getId()));
			}
			if (funcionario.getId() == null) {
				funcionario = service.create(funcionario);
				retornoJson.setSuccess(Mensagens.MSG_INCLUSAO_OK);
			} else {
				funcionario = service.update(funcionario);
				retornoJson.setSuccess(Mensagens.MSG_EDICAO_OK);
			}
		}
		retornoJson.setObj(funcionario);
		result.use(Results.json()).from(retornoJson).include("?obj", "?obj.pessoa", "?obj.cargo", "?obj.setor")
				.serialize();
		;
	}

	@Get
	@Path("/editar")
	public void editar(Funcionario funcionario) {
		RetornoJson<Funcionario> retornoJson = new RetornoJson<Funcionario>();
		funcionario = service.getById(funcionario.getId());
		if (funcionario == null) {
			retornoJson.setError(Mensagens.MSG_NENHUM_REGISTRO);
		} else {
			retornoJson.setObj(funcionario);
		}
		result.use(Results.json()).from(retornoJson).include("?obj", "?obj.cargo", "?obj.setor", "?obj.pessoa")
				.serialize();
	}

//	@Post
//	@Path("/novo")
//	@Transactional
//	public void novo(Funcionario funcionario) {
//		try {
//			service.create(funcionario);
//			result.redirectTo(this).index(0);
//		} catch (Exception e) {
//			montarCombos(funcionario);
//			result.include("error", e.getMessage());
//		}
//	}
//
//	@Get
//	@Path("/show/{id}")
//	public Funcionario show(Integer id) {
//		Funcionario funcionario = null;
//		try {
//			funcionario = service.getById(id);
//			montarCombos(funcionario);
//		} catch (Exception e) {
//			result.include("error", e.getMessage());
//			result.redirectTo(this).index(0);
//		}
//		return funcionario;
//	}
//
//	@Get
//	@Path("/alterar/{id}")
//	public Funcionario alterar(Integer id) {
//		Funcionario funcionario = null;
//		try {
//			funcionario = service.getById(id);
//			montarCombos(funcionario);
//		} catch (Exception e) {
//			result.include("error", e.getMessage());
//			result.redirectTo(this).index(0);
//		}
//		return funcionario;
//	}
//
//	@Post
//	@Path("/alterar")
//	@Transactional
//	public void alterar(Funcionario funcionario) {
//		try {
//			service.update(funcionario);
//			result.redirectTo(this).index(0);
//		} catch (Exception e) {
//			montarCombos(funcionario);
//			result.include("error", e.getMessage());
//		}
//	}

	private void montarCombos(Funcionario funcionario) {
		try {
			result.include("funcionario", funcionario);
			result.include("sexos", SexoEnum.values());
			result.include("estadosCivis", EstadoCivilEnum.values());
			result.include("cargos", cargoService.all());
			result.include("setores", setorService.all());
			result.include("ufs", ufService.all());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}