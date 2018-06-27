package br.com.lummi.sge.controllers;

import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.lummi.sge.exceptions.SgeException;
import br.com.lummi.sge.exceptions.SgeValidationException;
import br.com.lummi.sge.models.Cargo;
import br.com.lummi.sge.models.Curso;
import br.com.lummi.sge.models.PaginatedList;
import br.com.lummi.sge.service.CargoService;
import br.com.lummi.sge.utils.Mensagens;

@Path("/cargo")
@Controller
public class CargoController {

	@Inject
	private Result result;
	@Inject
	private CargoService service;
	
	@Get
    @Path({"/", ""})
    public PaginatedList index(int page) {
		Cargo cargo = new Cargo();
		return index(cargo, page, 10, true);
    }
	
	@Post
	@Path({"/", ""})
	public PaginatedList index(Cargo cargo, int page, int tamanho, boolean get) {
		result.include("cargo", cargo);
		if (tamanho == 0) {
			tamanho = 10;
		}
		PaginatedList lista = service.findByFiltro(cargo, page, tamanho);

		if (lista.getCount() == 0) {
			result.include("warning", Mensagens.MSG_NENHUM_REGISTRO);
		}
		
		return lista;
	}

	@Get
	@Path({"/novo","/novo/"})
	public void novo() {
	}
	
	@Post
    @Path("/novo")
	@Transactional
    public void novo(Cargo cargo) {
		service.create(cargo);
		result.redirectTo(this).index(0);
    }

	@Get
	@Path("/alterar/{id}")
	public Cargo alterar(Integer id) {
		return service.getById(id);
	}
	
	@Post
    @Path("/alterar")
	@Transactional
    public void alterar(Cargo cargo) {
		try {
			service.alterar(cargo);
			result.redirectTo(this).index(0);
		} catch (SgeValidationException e) {
		} catch (SgeException e) {
		}
    }
	
	@Get
	@Path("/mostrar/{id}")
	public Cargo mostrar(Integer id) {
		return service.getById(id);
	}
	

}