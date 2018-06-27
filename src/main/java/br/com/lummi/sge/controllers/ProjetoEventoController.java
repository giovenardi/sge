package br.com.lummi.sge.controllers;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.lummi.sge.exceptions.SgeException;
import br.com.lummi.sge.exceptions.SgeValidationException;
import br.com.lummi.sge.models.Projeto;
import br.com.lummi.sge.models.ProjetoEvento;
import br.com.lummi.sge.models.transiente.RetornoJson;
import br.com.lummi.sge.service.ProjetoEventoService;
import br.com.lummi.sge.utils.Mensagens;

@Controller
@Path("/projetoEvento")
public class ProjetoEventoController {

	@Inject
	private ProjetoEventoService service;

	@Inject
	private Result result;

	@Post
	@Path("/listar/{idProjeto}")
	public List<ProjetoEvento> listar(Integer idProjeto) {
		List<ProjetoEvento> eventos = null;
		try {
			eventos = service.findByIdProjeto(idProjeto);
		} catch (SgeException e) {
			result.include("error", e.getMessage());
		}
		return eventos;
	}

	@Post
	@Path("/incluir")
	@Transactional
	public void incluir(ProjetoEvento projetoEvento) {
		RetornoJson<ProjetoEvento> retornoJson = new RetornoJson<ProjetoEvento>();
		try {
			validarProjetoEvento(projetoEvento);
			projetoEvento = service.create(projetoEvento);
			retornoJson.setSuccess(Mensagens.MSG_INCLUSAO_OK);
			retornoJson.setObj(projetoEvento);
		} catch (SgeValidationException e) {
			retornoJson.setWarning(e.getMessage());
		}
		result.use(Results.json()).from(retornoJson).include("?obj", "?obj.projeto", "?obj.evento").serialize();
		;
	}

	@Post
	@Path("/excluir")
	@Transactional
	public void excluir(ProjetoEvento projetoEvento) {
		RetornoJson<ProjetoEvento> retornoJson = new RetornoJson<ProjetoEvento>();
		try {
			projetoEvento = service.getById(projetoEvento.getId());
			Projeto projeto = projetoEvento.getProjeto();
			if (projeto.getEventos().size() < 2) {
				retornoJson.setError("Impossível excluir. O projeto deve conter pelo menos um evento.");
			} else {
				service.delete(projetoEvento);
				retornoJson.setObj(projetoEvento);
				retornoJson.setSuccess(Mensagens.MSG_EXCLUSAO_OK);
			}
		} catch (Exception e) {
			retornoJson.setError(e.getMessage());
		}
		result.use(Results.json()).from(retornoJson).include("obj", "?obj.projeto", "?obj.evento").serialize();
	}

	private void validarProjetoEvento(ProjetoEvento projetoEvento) throws SgeValidationException {
		if (projetoEvento == null
				|| projetoEvento.getProjeto() == null || projetoEvento.getProjeto().getId() == null
				|| projetoEvento.getEvento() == null || projetoEvento.getEvento().getId() == null
				|| projetoEvento.getInicio() == null
				|| projetoEvento.getFim() == null) {
			throw new SgeValidationException(Mensagens.MSG_CAMPOS_OBRIGATORIOS);
		}
	}

}