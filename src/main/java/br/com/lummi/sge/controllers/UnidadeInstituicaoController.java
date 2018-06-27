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
import br.com.lummi.sge.models.Instituicao;
import br.com.lummi.sge.models.UnidadeInstituicao;
import br.com.lummi.sge.models.transiente.RetornoJson;
import br.com.lummi.sge.service.UnidadeInstituicaoService;
import br.com.lummi.sge.utils.Mensagens;

@Path("/unidadeInstituicao")
@Controller
public class UnidadeInstituicaoController {

	@Inject
	private UnidadeInstituicaoService service;

	@Inject
	private Result result;

	@Post
	@Path("/buscarPorInstituicao")
	public void buscarPorInstituicao(Instituicao instituicao) {
		List<UnidadeInstituicao> unidades = service.findByInstituicao(instituicao);
		result.use(Results.json()).from(unidades).serialize();
	}

	@Get
	@Path("/editar")
	public void editar(UnidadeInstituicao unidadeInstituicao) {
		RetornoJson<UnidadeInstituicao> retornoJson = new RetornoJson<UnidadeInstituicao>();
		unidadeInstituicao = service.getById(unidadeInstituicao.getId());
		if (unidadeInstituicao == null) {
			retornoJson.setError(Mensagens.MSG_NENHUM_REGISTRO);
		} else {
			retornoJson.setObj(unidadeInstituicao);
		}
		result.use(Results.json()).from(retornoJson).include("?obj", "?obj.instituicao").serialize();
		;
	}

	@Post
	@Path("/incluir")
	@Transactional
	public void incluir(UnidadeInstituicao unidadeInstituicao) {
		RetornoJson<UnidadeInstituicao> retornoJson = new RetornoJson<UnidadeInstituicao>();
		try {
			validarUnidadeInstituicao(unidadeInstituicao);
			if (unidadeInstituicao.getId() == null) {
				unidadeInstituicao = service.create(unidadeInstituicao);
				retornoJson.setSuccess(Mensagens.MSG_INCLUSAO_OK);
			} else {
				unidadeInstituicao = service.update(unidadeInstituicao);
				retornoJson.setSuccess(Mensagens.MSG_EDICAO_OK);
			}
			retornoJson.setObj(unidadeInstituicao);
		} catch (SgeValidationException e) {
			retornoJson.setWarning(e.getMessage());
		}
		result.use(Results.json()).from(retornoJson).include("?obj", "?obj.instituicao").serialize();
		;
	}

	private void validarUnidadeInstituicao(UnidadeInstituicao unidadeInstituicao) throws SgeValidationException {
		if (unidadeInstituicao == null || unidadeInstituicao.getInstituicao() == null
				|| unidadeInstituicao.getInstituicao().getId() == null || unidadeInstituicao.getNome() == null
				|| unidadeInstituicao.getNome().length() == 0) {
			throw new SgeValidationException(Mensagens.MSG_CAMPOS_OBRIGATORIOS);
		}
	}
}
