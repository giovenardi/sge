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
import br.com.lummi.sge.exceptions.SgeException;
import br.com.lummi.sge.exceptions.SgeValidationException;
import br.com.lummi.sge.models.PlanoPagamento;
import br.com.lummi.sge.models.ProjetoFormaturaSuperior;
import br.com.lummi.sge.models.transiente.RetornoJson;
import br.com.lummi.sge.service.PlanoPagamentoService;
import br.com.lummi.sge.utils.Mensagens;

@Controller
@Path("/planoPagamento")
public class PlanoPagamentoController {

	@Inject
	private PlanoPagamentoService service;
	
	@Inject
	private Result result;
	
	
	
	@Post
    @Path("/listar/{idProjeto}")
    public List<PlanoPagamento> listar(Integer idProjeto) {
		List<PlanoPagamento> planos = null;
		try {
			planos = service.findByIdProjeto(idProjeto);
		} catch (SgeException e) {
			result.include("error", e.getMessage());
		}
		return planos;
	}

	@Post
    @Path("/incluir")
	@Transactional
    public void incluir(PlanoPagamento plano) {
		RetornoJson<PlanoPagamento> retornoJson = new RetornoJson<PlanoPagamento>();
		try {
			validarPlano(plano);
			if (plano.getId() == null) {
				plano = service.create(plano);
				retornoJson.setSuccess(Mensagens.MSG_INCLUSAO_OK);
			} else {
				plano = service.update(plano);
				retornoJson.setSuccess(Mensagens.MSG_EDICAO_OK);
			}
			retornoJson.setObj(plano);
		} catch (SgeValidationException e) {
			retornoJson.setWarning(e.getMessage());
		}
		result.use(Results.json()).from(retornoJson).include("?obj", "?obj.projeto").serialize();;
	}

	@Get
    @Path("/editar")
    public void editar(PlanoPagamento plano) {
		RetornoJson<PlanoPagamento> retornoJson = new RetornoJson<PlanoPagamento>();
		plano = service.getById(plano.getId());
		if (plano == null) {
			retornoJson.setError(Mensagens.MSG_NENHUM_REGISTRO);
		} else {
			retornoJson.setObj(plano);
		}
		result.use(Results.json()).from(retornoJson).include("?obj", "?obj.projeto", "?obj.formasPagamento").serialize();;
	}

	@Post
    @Path("/excluir")
	@Transactional
    public void excluir(PlanoPagamento plano) {
		RetornoJson<PlanoPagamento> retornoJson = new RetornoJson<PlanoPagamento>();
		try {
			plano = service.getById(plano.getId());
			ProjetoFormaturaSuperior projeto = (ProjetoFormaturaSuperior) plano.getProjeto();
			if (projeto.getPlanosPagamento().size() < 2) {
				retornoJson.setError("Impossível excluir. O projeto deve conter pelo menos um plano de pagamento.");
			} else {
				service.delete(plano);
				projeto.setNome(projeto.getNome().replaceAll(plano.getNome(), ""));
				retornoJson.setObj(plano);
				retornoJson.setSuccess(Mensagens.MSG_EXCLUSAO_OK);
			}
		} catch (Exception e) {
			retornoJson.setError(e.getMessage());
		}
		result.use(Results.json()).from(retornoJson).include("obj", "?obj.projeto").serialize();
	}

	private void validarPlano(PlanoPagamento plano) throws SgeValidationException {
		if (plano == null 
				|| plano.getProjeto() == null || plano.getProjeto().getId() == null
				|| plano.getNome() == null || plano.getNome().length() == 0 
				|| plano.getValor() == null 
				|| plano.getConvidados() == null 
				|| plano.getConvitesLuxo() == null 
				|| plano.getConvitesSemiLuxo() == null 
				|| plano.getConvitesSimples() == null) {
			throw new SgeValidationException(Mensagens.MSG_CAMPOS_OBRIGATORIOS);
		}
	}

}