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
import br.com.lummi.sge.models.Evento;
import br.com.lummi.sge.models.transiente.RetornoJson;
import br.com.lummi.sge.service.EventoService;
import br.com.lummi.sge.utils.Mensagens;

@Path("/evento")
@Controller
public class EventoController {

	@Inject
	private Result result;
	@Inject
	private EventoService service;

	@Get
	@Path({ "/", "" })
	public List<Evento> index() {
		List<Evento> lista = service.all("nome");
		if (lista.isEmpty()) {
			result.include("warning", Mensagens.MSG_NENHUM_REGISTRO);
		}
		return lista;
	}

	@Post
	@Path("/salvar")
	@Transactional
	public void salvar(Evento evento) {
		RetornoJson<Evento> retornoJson = new RetornoJson<Evento>();
		try {
			if (evento.getId() == null) {
				service.novo(evento);
				retornoJson.setSuccess(Mensagens.MSG_INCLUSAO_OK);
			} else {
				service.alterar(evento);
				retornoJson.setSuccess(Mensagens.MSG_EDICAO_OK);
			}
			retornoJson.setObj(evento);
			result.use(Results.json()).from(retornoJson).include("?obj").serialize();
		} catch (SgeValidationException e) {
			retornoJson.setWarning(e.getMessage());
		}
	}

	@Get
	@Path("/buscar")
	public void buscar(Evento evento) {
		RetornoJson<Evento> retornoJson = new RetornoJson<Evento>();
		evento = service.getById(evento.getId());
		if (evento == null) {
			retornoJson.setError(Mensagens.MSG_NENHUM_REGISTRO);
		} else {
			retornoJson.setObj(evento);
		}
		result.use(Results.json()).from(retornoJson).include("?obj").serialize();
	}

}