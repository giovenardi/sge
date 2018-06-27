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
import br.com.lummi.sge.models.ProjetoFormatura;
import br.com.lummi.sge.models.Turma;
import br.com.lummi.sge.models.transiente.RetornoJson;
import br.com.lummi.sge.service.TurmaService;
import br.com.lummi.sge.utils.Mensagens;

@Controller
@Path("/turma")
public class TurmaController {

	@Inject
	private TurmaService service;

	@Inject
	private Result result;

	@Post
	@Path("/listar/{idProjeto}")
	public List<Turma> listar(Integer idProjeto) {
		List<Turma> turmas = null;
		try {
			turmas = service.findByIdProjeto(idProjeto);
		} catch (SgeException e) {
			result.include("error", e.getMessage());
		}
		return turmas;
	}

	@Post
	@Path("/incluir")
	@Transactional
	public void incluir(Turma turma) {
		RetornoJson<Turma> retornoJson = new RetornoJson<Turma>();
		try {
			validarTurma(turma);
			turma = service.create(turma);
			retornoJson.setSuccess(Mensagens.MSG_INCLUSAO_OK);
			retornoJson.setObj(turma);
		} catch (SgeValidationException e) {
			retornoJson.setWarning(e.getMessage());
		}
		result.use(Results.json()).from(retornoJson).include("?obj", "?obj.projeto").serialize();
		;
	}

	@Post
	@Path("/excluir")
	@Transactional
	public void excluir(Turma turma) {
		RetornoJson<Turma> retornoJson = new RetornoJson<Turma>();
		try {
			turma = service.getById(turma.getId());
			if (turma.getFormandos() != null && turma.getFormandos().size() > 0) {
				retornoJson.setError("Impossível excluir. Turma já possui formandos!");
			} else {
				ProjetoFormatura projeto = (ProjetoFormatura) turma.getProjeto();
				if (projeto.getTurmas().size() < 2) {
					retornoJson.setError("Impossível excluir. O projeto deve conter pelo menos uma turma.");
				} else {
					service.delete(turma);
					projeto.setNome(projeto.getNome().replaceAll(turma.getNome(), ""));
					retornoJson.setObj(turma);
					retornoJson.setSuccess(Mensagens.MSG_EXCLUSAO_OK);
				}
			}
		} catch (Exception e) {
			retornoJson.setError(e.getMessage());
		}
		result.use(Results.json()).from(retornoJson).include("obj", "?obj.projeto").serialize();
	}

	private void validarTurma(Turma turma) throws SgeValidationException {
		if (turma == null
				|| turma.getProjeto() == null || turma.getProjeto().getId() == null
				|| turma.getAno() == null
				// || turma.getCurso() == null || turma.getCurso().getId() == null
				|| turma.getProjeto() == null || turma.getProjeto().getId() == null
				// || turma.getSemestre() == null
				|| turma.getTurno() == null || turma.getTurno().getId() == null
				|| turma.getUnidadeInstituicao() == null || turma.getUnidadeInstituicao().getId() == null) {
			throw new SgeValidationException(Mensagens.MSG_CAMPOS_OBRIGATORIOS);
		}
	}

}