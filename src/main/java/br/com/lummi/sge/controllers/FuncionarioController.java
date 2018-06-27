package br.com.lummi.sge.controllers;

import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.lummi.sge.enums.EstadoCivilEnum;
import br.com.lummi.sge.enums.SexoEnum;
import br.com.lummi.sge.exceptions.SgeException;
import br.com.lummi.sge.models.Funcionario;
import br.com.lummi.sge.models.PaginatedList;
import br.com.lummi.sge.models.PessoaFisica;
import br.com.lummi.sge.service.CargoService;
import br.com.lummi.sge.service.FuncionarioService;
import br.com.lummi.sge.service.PessoaFisicaService;
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
	private UfService ufService;
	@Inject
	private PessoaFisicaService pessoaFisicaService;
	
	@Get
    @Path({"/", ""})
    public PaginatedList index(int page) {
		Funcionario funcionario = (Funcionario) result.included().get("funcionario");
		if (funcionario == null) {
			funcionario = new Funcionario();
		}
		return index(funcionario, page, 10, true);
    }
	
	@Post
	@Path({"/", ""})
	public PaginatedList index(Funcionario funcionario, int page, int tamanho, boolean get) {
		result.include("funcionario", funcionario);
		if (tamanho == 0) {
			tamanho = 10;
		}
		PaginatedList lista = service.findByFiltro(funcionario, page, tamanho);

		if (lista.getCount() == 0) {
			result.include("warning", Mensagens.MSG_NENHUM_REGISTRO);
		}
		
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
		if (pessoa.getFuncionario() != null) {
			result.include("error", "Funcionário já cadastrado!");
			result.include("funcionario", pessoa.getFuncionario());
			result.redirectTo(this).index(0);
		} else {
			Funcionario funcionario = new Funcionario();
			funcionario.setPessoa(pessoa);
			montarCombos(funcionario);
		}
    }

	@Get
	@Path({"/novo","/novo/"})
	public void novo() {
		montarCombos(new Funcionario());
	}
	
	@Post
    @Path("/novo")
	@Transactional
    public void novo(Funcionario funcionario) {
		try {
			service.create(funcionario);
			result.redirectTo(this).index(0);
		} catch (Exception e) {
			montarCombos(funcionario);
			result.include("error", e.getMessage());
		}
    }

	@Get
	@Path("/show/{id}")
	public Funcionario show(Integer id) {
		Funcionario funcionario = null;
		try {
			funcionario = service.getById(id);
			montarCombos(funcionario);
		} catch (Exception e) {
			result.include("error", e.getMessage());
			result.redirectTo(this).index(0);
		}
		return funcionario;
	}
	
	@Get
	@Path("/alterar/{id}")
	public Funcionario alterar(Integer id) {
		Funcionario funcionario = null;
		try {
			funcionario = service.getById(id);
			montarCombos(funcionario);
		} catch (Exception e) {
			result.include("error", e.getMessage());
			result.redirectTo(this).index(0);
		}
		return funcionario;
	}
	
	@Post
    @Path("/alterar")
	@Transactional
    public void alterar(Funcionario funcionario) {
		try {
			service.update(funcionario);
			result.redirectTo(this).index(0);
		} catch (Exception e) {
			montarCombos(funcionario);
			result.include("error", e.getMessage());
		}
    }

	private void montarCombos(Funcionario funcionario) {
		try {
			result.include("funcionario", funcionario);
			result.include("sexos", SexoEnum.values());
			result.include("estadosCivis", EstadoCivilEnum.values());
			result.include("cargos", cargoService.all());
			result.include("ufs", ufService.all());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}