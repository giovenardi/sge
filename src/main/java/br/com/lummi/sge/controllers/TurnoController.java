package br.com.lummi.sge.controllers;

import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.lummi.sge.models.Turno;
import br.com.lummi.sge.models.PaginatedList;
import br.com.lummi.sge.service.TurnoService;
import br.com.lummi.sge.utils.Mensagens;

@Path("/turno")
@Controller
public class TurnoController {

	@Inject
	private Result result;
	@Inject
	private TurnoService service;
	
	@Get
    @Path({"/", ""})
    public PaginatedList index(int page) {
		Turno turno = new Turno();
		return index(turno, page, 10, true);
    }
	
	@Post
	@Path({"/", ""})
	public PaginatedList index(Turno turno, int page, int tamanho, boolean get) {
		result.include("turno", turno);
		if (tamanho == 0) {
			tamanho = 10;
		}
		PaginatedList lista = service.findByFiltro(turno, page, tamanho);

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
    public void novo(Turno turno) {
		service.create(turno);
		result.redirectTo(this).index(0);
    }

	@Get
	@Path("/alterar/{id}")
	public Turno alterar(Integer id) {
		return service.getById(id);
	}
	
	@Get
	@Path("/mostrar/{id}")
	public Turno mostrar(Integer id) {
		return service.getById(id);
	}
	
	@Post
    @Path("/alterar")
	@Transactional
    public void alterar(Turno turno) {
		service.update(turno);
		result.redirectTo(this).index(0);
    }

}