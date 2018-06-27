package br.com.lummi.sge.controllers;

import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.lummi.sge.enums.StatusFormandoEnum;
import br.com.lummi.sge.models.Formando;
import br.com.lummi.sge.models.transiente.RetornoJson;
import br.com.lummi.sge.service.FormaPagamentoService;
import br.com.lummi.sge.service.FormandoService;
import br.com.lummi.sge.service.PessoaFisicaService;
import br.com.lummi.sge.service.TurmaService;
import br.com.lummi.sge.utils.Mensagens;

@Controller
@Path("/formando")
public class FormandoController {

	@Inject
	private FormandoService service;
	
	@Inject
	private PessoaFisicaService pessoaService;
	
	@Inject
	private TurmaService turmaService;
	
	@Inject
	private Result result;

	private FormaPagamentoService formaPagamentoService;

	@Post
    @Path("/salvar")
	@Transactional
    public void salvar(Formando formando) {
		RetornoJson<Formando> retornoJson = new RetornoJson<Formando>();
		if (formando.getId() == null) {
			formando.setStatus(StatusFormandoEnum.EM_ABERTO);
			formando = service.create(formando);
		} else {
			formando = service.update(formando);
		}
		formando.setPessoa(pessoaService.getById(formando.getPessoa().getId()));
		formando.setTurma(turmaService.getById(formando.getTurma().getId()));
		if (formando.getFormaPagamento() != null && formando.getFormaPagamento().getId() != null) {
			formando.setFormaPagamento(formaPagamentoService.getById(formando.getFormaPagamento().getId()));
		}
		retornoJson.setSuccess(Mensagens.MSG_EDICAO_OK);
		retornoJson.setObj(formando);
		result.use(Results.json()).from(retornoJson).include("?obj", "?obj.pessoa", "?obj.turma", "?obj.formaPagamento").serialize();;
	}

}