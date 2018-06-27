package br.com.lummi.sge.controllers;

import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.lummi.sge.models.Curso;
import br.com.lummi.sge.models.PaginatedList;
import br.com.lummi.sge.service.CursoService;
import br.com.lummi.sge.utils.Mensagens;

@Path("/curso")
@Controller
public class CursoController {

	@Inject
	private Result result;
	@Inject
	private CursoService service;
	
	@Get
    @Path({"/", ""})
    public PaginatedList index(int page) {
		Curso curso = new Curso();
		return index(curso, page, 10, true);
    }
	
	@Post
	@Path({"/", ""})
	public PaginatedList index(Curso curso, int page, int tamanho, boolean get) {
		result.include("curso", curso);
		if (tamanho == 0) {
			tamanho = 10;
		}
		PaginatedList lista = service.findByFiltro(curso, page, tamanho);

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
    public void novo(Curso curso) {
		service.create(curso);
		result.redirectTo(this).index(0);
    }

	@Get
	@Path("/alterar/{id}")
	public Curso alterar(Integer id) {
		return service.getById(id);
	}
	
	@Get
	@Path("/mostrar/{id}")
	public Curso mostrar(Integer id) {
		return service.getById(id);
	}
	
	@Post
    @Path("/alterar")
	@Transactional
    public void alterar(Curso curso) {
		if (curso.getId() == null) {
			service.create(curso);
			result.include("success", Mensagens.MSG_INCLUSAO_OK);
		} else {
			service.update(curso);
			result.include("success", Mensagens.MSG_EDICAO_OK);
		}
		result.redirectTo(this).index(0);
    }

}