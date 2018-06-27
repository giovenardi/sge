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
import br.com.lummi.sge.models.CaptadorExterno;
import br.com.lummi.sge.models.PaginatedList;
import br.com.lummi.sge.models.PessoaFisica;
import br.com.lummi.sge.service.CaptadorExternoService;
import br.com.lummi.sge.service.PessoaFisicaService;
import br.com.lummi.sge.service.UfService;
import br.com.lummi.sge.utils.Mensagens;

@Path("/captadorExterno")
@Controller
public class CaptadorExternoController {

	@Inject
	private Result result;
	@Inject
	private CaptadorExternoService service;
	@Inject
	private UfService ufService;
	@Inject
	private PessoaFisicaService pessoaFisicaService;
	
	@Get
    @Path({"/", ""})
    public PaginatedList index(int page) {
		CaptadorExterno captadorExterno = (CaptadorExterno) result.included().get("captadorExterno");
		if (captadorExterno == null) {
			captadorExterno = new CaptadorExterno();
		}
		return index(captadorExterno, page, 10, true);
    }
	
	@Post
	@Path({"/", ""})
	public PaginatedList index(CaptadorExterno captadorExterno, int page, int tamanho, boolean get) {
		result.include("captadorExterno", captadorExterno);
		if (tamanho == 0) {
			tamanho = 10;
		}
		PaginatedList lista = service.findByFiltro(captadorExterno, page, tamanho);

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
		if (pessoa.getCaptadorExterno() != null) {
			result.include("error", "Captador Externo já cadastrado!");
			result.include("captadorExterno", pessoa.getCaptadorExterno());
			result.redirectTo(this).index(0);
		} else {
			CaptadorExterno captadorExterno = new CaptadorExterno();
			captadorExterno.setPessoa(pessoa);
			montarCombos(captadorExterno);
		}
    }

	@Get
	@Path({"/novo","/novo/"})
	public void novo() {
		montarCombos(new CaptadorExterno());
	}
	
	@Post
    @Path("/novo")
	@Transactional
    public void novo(CaptadorExterno captadorExterno) {
		try {
			service.create(captadorExterno);
			result.redirectTo(this).index(0);
		} catch (Exception e) {
			montarCombos(captadorExterno);
			result.include("error", e.getMessage());
		}
    }

	@Get
	@Path("/show/{id}")
	public CaptadorExterno show(Integer id) {
		CaptadorExterno captadorExterno = null;
		try {
			captadorExterno = service.getById(id);
			montarCombos(captadorExterno);
		} catch (Exception e) {
			result.include("error", e.getMessage());
			result.redirectTo(this).index(0);
		}
		return captadorExterno;
	}
	
	@Get
	@Path("/alterar/{id}")
	public CaptadorExterno alterar(Integer id) {
		CaptadorExterno captadorExterno = null;
		try {
			captadorExterno = service.getById(id);
			montarCombos(captadorExterno);
		} catch (Exception e) {
			result.include("error", e.getMessage());
			result.redirectTo(this).index(0);
		}
		return captadorExterno;
	}
	
	@Post
    @Path("/alterar")
	@Transactional
    public void alterar(CaptadorExterno captadorExterno) {
		try {
			service.update(captadorExterno);
			result.redirectTo(this).index(0);
		} catch (Exception e) {
			montarCombos(captadorExterno);
			result.include("error", e.getMessage());
		}
    }

	private void montarCombos(CaptadorExterno captadorExterno) {
		try {
			result.include("captadorExterno", captadorExterno);
			result.include("sexos", SexoEnum.values());
			result.include("estadosCivis", EstadoCivilEnum.values());
			result.include("ufs", ufService.all());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}