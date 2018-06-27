package br.com.lummi.sge.controllers;

import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.lummi.sge.models.Instituicao;
import br.com.lummi.sge.models.PaginatedList;
import br.com.lummi.sge.models.ProjetoFormaturaSuperior;
import br.com.lummi.sge.models.Turma;
import br.com.lummi.sge.models.UnidadeInstituicao;
import br.com.lummi.sge.models.transiente.RetornoJson;
import br.com.lummi.sge.service.InstituicaoService;
import br.com.lummi.sge.service.UnidadeInstituicaoService;
import br.com.lummi.sge.utils.Mensagens;

@Path("/instituicao")
@Controller
public class InstituicaoController {

	@Inject
	private Result result;
	@Inject
	private InstituicaoService service;
	@Inject
	private UnidadeInstituicaoService unidadeService;
	
	@Get
    @Path({"/", ""})
    public PaginatedList index(int page) {
		Instituicao instituicao = new Instituicao();
		return index(instituicao, page, 10, true);
    }
	
	@Post
	@Path({"/", ""})
	public PaginatedList index(Instituicao instituicao, int page, int tamanho, boolean get) {
		result.include("instituicao", instituicao);
		if (tamanho == 0) {
			tamanho = 10;
		}
		PaginatedList lista = service.findByFiltro(instituicao, page, tamanho);

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
    @Path("/nova")
	@Transactional
    public void nova(Instituicao instituicao) {
		service.create(instituicao);
		result.redirectTo(this).index(0);
    }

	@Get
	@Path("/alterar/{id}")
	public Instituicao alterar(Integer id) {
		return service.getById(id);
	}
	
	@Get
	@Path("/mostrar/{id}")
	public Instituicao mostrar(Integer id) {
		return service.getById(id);
	}
	
	@Post
    @Path("/alterar")
	@Transactional
    public void alterar(Instituicao instituicao) {
		service.update(instituicao);
		result.redirectTo(this).index(0);
    }

	@Post
    @Path("/excluirUnidade")
	@Transactional
    public void excluirUnidade(UnidadeInstituicao unidade) {
		RetornoJson<UnidadeInstituicao> retornoJson = new RetornoJson<UnidadeInstituicao>();
		try {
			unidade = unidadeService.getById(unidade.getId());
			Instituicao instituicao = (Instituicao) unidade.getInstituicao();
			if (instituicao.getUnidades().size() < 2) {
				retornoJson.setError("Impossível excluir. Uma instituição deve conter pelo menos uma unidade.");
			} else {
				unidadeService.delete(unidade);
				retornoJson.setObj(unidade);
				retornoJson.setSuccess(Mensagens.MSG_EXCLUSAO_OK);
			}
		} catch (NullPointerException e) {
			retornoJson.setError("Unidade inexistente");
		} catch (Exception e) {
			retornoJson.setError(e.getMessage());
		}
		result.use(Results.json()).from(retornoJson).include("?obj").serialize();
	}

}