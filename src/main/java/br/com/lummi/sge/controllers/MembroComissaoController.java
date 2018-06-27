package br.com.lummi.sge.controllers;

import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.lummi.sge.models.MembroComissao;
import br.com.lummi.sge.models.Turma;
import br.com.lummi.sge.models.transiente.RetornoJson;
import br.com.lummi.sge.service.ComissaoFormaturaService;
import br.com.lummi.sge.service.FuncaoComissaoService;
import br.com.lummi.sge.service.MembroComissaoService;
import br.com.lummi.sge.service.PessoaFisicaService;
import br.com.lummi.sge.utils.Mensagens;

@Controller
@Path("/membroComissao")
public class MembroComissaoController {

	@Inject
	private MembroComissaoService service;

	@Inject
	private PessoaFisicaService pessoaService;

	@Inject
	private Result result;

	@Inject
	private ComissaoFormaturaService comissaoFormaturaService;

	@Inject
	private FuncaoComissaoService funcaoComissaoService;

	@Post
	@Path("/salvar")
	@Transactional
	public void salvar(MembroComissao membroComissao) {
		RetornoJson<MembroComissao> retornoJson = new RetornoJson<MembroComissao>();
		if (membroComissao.getId() == null) {
			membroComissao = service.create(membroComissao);
			retornoJson.setSuccess(Mensagens.MSG_INCLUSAO_OK);
		} else {
			membroComissao = service.update(membroComissao);
			retornoJson.setSuccess(Mensagens.MSG_EDICAO_OK);
		}

		retornoJson.setObj(membroComissao);
		result.use(Results.json()).from(retornoJson)
				.include("?obj", "?obj.pessoa", "?obj.funcao", "?obj.comissaoFormatura").serialize();

	}

	@Get
	@Path("/editar")
	public void editar(MembroComissao membroComissao) {
		RetornoJson<MembroComissao> retornoJson = new RetornoJson<MembroComissao>();
		membroComissao = service.getById(membroComissao.getId());
		if (membroComissao == null) {
			retornoJson.setError(Mensagens.MSG_NENHUM_REGISTRO);
		} else {
			retornoJson.setObj(membroComissao);
		}
		result.use(Results.json()).from(retornoJson)
				.include("?obj", "?obj.pessoa", "?obj.funcao", "?obj.comissaoFormatura").serialize();
	}

	@Post
	@Path("/excluir")
	@Transactional
	public void excluir(MembroComissao membroComissao) {
		RetornoJson<Turma> retornoJson = new RetornoJson<Turma>();
		try {
			membroComissao = service.getById(membroComissao.getId());
			service.delete(membroComissao);
			retornoJson.setSuccess(Mensagens.MSG_EXCLUSAO_OK);
		} catch (Exception e) {
			retornoJson.setError(e.getMessage());
		}
		result.use(Results.json()).from(retornoJson)
				.include("obj", "?obj.pessoa", "?obj.funcao", "?obj.comissaoFormatura").serialize();
	}

}