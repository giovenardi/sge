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
import br.com.lummi.sge.exceptions.SgeValidationException;
import br.com.lummi.sge.models.Curso;
import br.com.lummi.sge.models.transiente.RetornoJson;
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
	@Path({ "/", "" })
	public List<Curso> index() {
		List<Curso> lista = service.all("nome");
		if (lista.isEmpty()) {
			result.include("warning", Mensagens.MSG_NENHUM_REGISTRO);
		}
		return lista;
	}

	@Post
	@Path("/salvar")
	@Transactional
	public void salvar(Curso curso) {
		RetornoJson<Curso> retornoJson = new RetornoJson<Curso>();
		try {
			if (curso.getId() == null) {
				service.novo(curso);
				retornoJson.setSuccess(Mensagens.MSG_INCLUSAO_OK);
			} else {
				service.alterar(curso);
				retornoJson.setSuccess(Mensagens.MSG_EDICAO_OK);
			}
			retornoJson.setObj(curso);
			result.use(Results.json()).from(retornoJson).include("?obj").serialize();
		} catch (SgeValidationException e) {
			retornoJson.setWarning(e.getMessage());
		}
	}

	@Get
	@Path("/buscar")
	public void buscar(Curso curso) {
		RetornoJson<Curso> retornoJson = new RetornoJson<Curso>();
		curso = service.getById(curso.getId());
		if (curso == null) {
			retornoJson.setError(Mensagens.MSG_NENHUM_REGISTRO);
		} else {
			retornoJson.setObj(curso);
		}
		result.use(Results.json()).from(retornoJson).include("?obj").serialize();
	}

}