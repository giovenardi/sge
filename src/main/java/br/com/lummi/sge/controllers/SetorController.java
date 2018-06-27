package br.com.lummi.sge.controllers;

import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.lummi.sge.models.Setor;
import br.com.lummi.sge.exceptions.SgeValidationException;
import br.com.lummi.sge.models.PaginatedList;
import br.com.lummi.sge.service.SetorService;
import br.com.lummi.sge.utils.Mensagens;

@Path("/setor")
@Controller
public class SetorController {

	@Inject
	private Result result;
	@Inject
	private SetorService service;
	
	@Get
    @Path({"/", ""})
    public PaginatedList index(int page) {
		Setor setor = new Setor();
		return index(setor, page, 10, true);
    }
	
	@Post
	@Path({"/", ""})
	public PaginatedList index(Setor setor, int page, int tamanho, boolean get) {
		result.include("setor", setor);
		if (tamanho == 0) {
			tamanho = 10;
		}
		PaginatedList lista = service.findByFiltro(setor, page, tamanho);

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
    public void novo(Setor setor) {
		try {
			service.novo(setor);
			result.redirectTo(this).index(0);
		} catch (SgeValidationException e) {
			result.include("warning", Mensagens.MSG_INCLUSAO_OK);
		}
    }

	@Get
	@Path("/alterar/{id}")
	public Setor alterar(Integer id) {
		return service.getById(id);
	}
	
	@Post
    @Path("/alterar")
	@Transactional
    public void alterar(Setor setor) {
		try {
			service.alterar(setor);
			result.redirectTo(this).index(0);
		} catch (SgeValidationException e) {
			result.include("warning", Mensagens.MSG_EDICAO_OK);
		}
    }

}