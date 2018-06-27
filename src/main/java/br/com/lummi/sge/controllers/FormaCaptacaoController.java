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
import br.com.lummi.sge.models.FormaCaptacao;
import br.com.lummi.sge.models.transiente.RetornoJson;
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
	@Path({ "/", "" })
	public List<FormaCaptacao> index() {
		List<FormaCaptacao> lista = service.all("nome");
		if (lista.isEmpty()) {
			result.include("warning", Mensagens.MSG_NENHUM_REGISTRO);
		}
		return lista;
	}

	@Post
	@Path("/salvar")
	@Transactional
	public void salvar(FormaCaptacao formaCaptacao) {
		RetornoJson<FormaCaptacao> retornoJson = new RetornoJson<FormaCaptacao>();
		try {
			if (formaCaptacao.getId() == null) {
				service.novo(formaCaptacao);
				retornoJson.setSuccess(Mensagens.MSG_INCLUSAO_OK);
			} else {
				service.alterar(formaCaptacao);
				retornoJson.setSuccess(Mensagens.MSG_EDICAO_OK);
			}
			retornoJson.setObj(formaCaptacao);
			result.use(Results.json()).from(retornoJson).include("?obj").serialize();
		} catch (SgeValidationException e) {
			retornoJson.setWarning(e.getMessage());
		}
	}

	@Get
	@Path("/buscar")
	public void buscar(FormaCaptacao formaCaptacao) {
		RetornoJson<FormaCaptacao> retornoJson = new RetornoJson<FormaCaptacao>();
		formaCaptacao = service.getById(formaCaptacao.getId());
		if (formaCaptacao == null) {
			retornoJson.setError(Mensagens.MSG_NENHUM_REGISTRO);
		} else {
			retornoJson.setObj(formaCaptacao);
		}
		result.use(Results.json()).from(retornoJson).include("?obj").serialize();
	}

}