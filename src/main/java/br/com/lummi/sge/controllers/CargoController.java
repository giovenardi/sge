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
import br.com.lummi.sge.models.Cargo;
import br.com.lummi.sge.models.transiente.RetornoJson;
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
	@Path({ "/", "" })
	public List<Cargo> index() {
		List<Cargo> lista = service.all("nome");
		if (lista.isEmpty()) {
			result.include("warning", Mensagens.MSG_NENHUM_REGISTRO);
		}
		return lista;
	}

	@Post
	@Path("/salvar")
	@Transactional
	public void salvar(Cargo cargo) {
		RetornoJson<Cargo> retornoJson = new RetornoJson<Cargo>();
		try {
			if (cargo.getId() == null) {
				service.novo(cargo);
				retornoJson.setSuccess(Mensagens.MSG_INCLUSAO_OK);
			} else {
				service.alterar(cargo);
				retornoJson.setSuccess(Mensagens.MSG_EDICAO_OK);
			}
			retornoJson.setObj(cargo);
			result.use(Results.json()).from(retornoJson).include("?obj").serialize();
		} catch (SgeValidationException e) {
			retornoJson.setWarning(e.getMessage());
		}
	}

	@Get
	@Path("/buscar")
	public void buscar(Cargo cargo) {
		RetornoJson<Cargo> retornoJson = new RetornoJson<Cargo>();
		cargo = service.getById(cargo.getId());
		if (cargo == null) {
			retornoJson.setError(Mensagens.MSG_NENHUM_REGISTRO);
		} else {
			retornoJson.setObj(cargo);
		}
		result.use(Results.json()).from(retornoJson).include("?obj").serialize();
	}

}