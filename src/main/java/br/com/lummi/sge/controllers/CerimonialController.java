package br.com.lummi.sge.controllers;

import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.lummi.sge.models.Cerimonial;
import br.com.lummi.sge.models.transiente.RetornoJson;
import br.com.lummi.sge.service.CerimonialService;
import br.com.lummi.sge.utils.Mensagens;

@Controller
@Path("/cerimonial")
public class CerimonialController {

	@Inject
	private CerimonialService service;
	
	@Inject
	private Result result;
	
	@Post
    @Path("/salvar")
	@Transactional
    public void salvar(Cerimonial cerimonial) {
		RetornoJson<Cerimonial> retornoJson = new RetornoJson<Cerimonial>();
		if (cerimonial.getId() == null) {
			cerimonial = service.create(cerimonial);
		} else {
			cerimonial = service.update(cerimonial);
		}
		retornoJson.setSuccess(Mensagens.MSG_EDICAO_OK);
		retornoJson.setObj(cerimonial);
		result.use(Results.json()).from(retornoJson).include("?obj", "?obj.projeto").serialize();;
	}

}