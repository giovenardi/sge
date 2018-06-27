package br.com.lummi.sge.controllers;

import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.lummi.sge.models.FormaCaptacao;
import br.com.lummi.sge.models.PaginatedList;
import br.com.lummi.sge.service.FormaCaptacaoService;
import br.com.lummi.sge.utils.Mensagens;

@Path("/formaCaptacao")
@Controller
public class FormaCaptacaoController {

	@Inject
	private Result result;
	@Inject
	private FormaCaptacaoService service;
	
	@Get
    @Path({"/", ""})
    public PaginatedList index(int page) {
		FormaCaptacao formaCaptacao = new FormaCaptacao();
		return index(formaCaptacao, page, 10, true);
    }
	
	@Post
	@Path({"/", ""})
	public PaginatedList index(FormaCaptacao formaCaptacao, int page, int tamanho, boolean get) {
		result.include("formaCaptacao", formaCaptacao);
		if (tamanho == 0) {
			tamanho = 10;
		}
		PaginatedList lista = service.findByFiltro(formaCaptacao, page, tamanho);

		if (lista.getCount() == 0) {
			result.include("warning", Mensagens.MSG_NENHUM_REGISTRO);
		}
		
		return lista;
	}

	@Get
	@Path({"/nova","/nova/"})
	public void nova() {
	}
	
	@Post
    @Path("/novo")
	@Transactional
    public void novo(FormaCaptacao formaCaptacao) {
		service.create(formaCaptacao);
		result.redirectTo(this).index(0);
    }

	@Get
	@Path("/alterar/{id}")
	public FormaCaptacao alterar(Integer id) {
		return service.getById(id);
	}
	
	@Post
    @Path("/alterar")
	@Transactional
    public void alterar(FormaCaptacao formaCaptacao) {
		service.update(formaCaptacao);
		result.redirectTo(this).index(0);
    }

}