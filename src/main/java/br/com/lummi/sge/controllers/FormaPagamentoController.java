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
import br.com.lummi.sge.models.FormaPagamento;
import br.com.lummi.sge.models.PlanoPagamento;
import br.com.lummi.sge.models.transiente.RetornoJson;
import br.com.lummi.sge.service.FormaPagamentoService;
import br.com.lummi.sge.utils.Mensagens;

@Controller
@Path("/formaPagamento")
public class FormaPagamentoController {

	@Inject
	private FormaPagamentoService service;
	
	@Inject
	private Result result;
	
	
	
	@Post
    @Path("/listar/{idProjeto}")
    public List<FormaPagamento> listar(Integer idPlano) {
		List<FormaPagamento> formasPagamento = null;
		try {
			formasPagamento = service.findByIdPlano(idPlano);
		} catch (SgeException e) {
			result.include("error", e.getMessage());
		}
		return formasPagamento;
	}

	@Post
    @Path("/incluir")
	@Transactional
    public void incluir(FormaPagamento formaPagamento) {
		RetornoJson<FormaPagamento> retornoJson = new RetornoJson<FormaPagamento>();
		try {
			validar(formaPagamento);
			if (formaPagamento.getId() == null) {
				formaPagamento = service.create(formaPagamento);
			} else {
				formaPagamento = service.update(formaPagamento);
			}
			retornoJson.setSuccess(Mensagens.MSG_INCLUSAO_OK);
			retornoJson.setObj(formaPagamento);
		} catch (SgeValidationException e) {
			retornoJson.setWarning(e.getMessage());
		}
		result.use(Results.json()).from(retornoJson).include("?obj", "?obj.projeto").serialize();;
	}

	@Post
    @Path("/excluir")
	@Transactional
    public void excluir(FormaPagamento formaPagamento) {
		RetornoJson<FormaPagamento> retornoJson = new RetornoJson<FormaPagamento>();
		try {
			formaPagamento = service.getById(formaPagamento.getId());
			PlanoPagamento plano = (PlanoPagamento) formaPagamento.getPlanoPagamento();
			if (plano.getFormasPagamento().size() < 2) {
				retornoJson.setError("Impossível excluir. O Plano de Pagamento deve conter pelo menos uma Forma de Pagamento.");
			} else {
				service.delete(formaPagamento);
				retornoJson.setObj(formaPagamento);
				retornoJson.setSuccess(Mensagens.MSG_EXCLUSAO_OK);
			}
		} catch (Exception e) {
			retornoJson.setError(e.getMessage());
		}
		result.use(Results.json()).from(retornoJson).include("obj", "?obj.projeto").serialize();
	}

	private void validar(FormaPagamento formaPagamento) throws SgeValidationException {
		if (formaPagamento == null 
				|| ((formaPagamento.getPlanoPagamento() == null || formaPagamento.getPlanoPagamento().getId() == null)
					&& (formaPagamento.getCerimonial() == null || formaPagamento.getCerimonial().getId() == null))
				|| formaPagamento.getParcelas() == null
				|| formaPagamento.getTitulo() == null 
				|| formaPagamento.getFormaParcelamento() == null) {
			throw new SgeValidationException(Mensagens.MSG_CAMPOS_OBRIGATORIOS);
		}
	}

}