package br.com.lummi.sge.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.lummi.sge.enums.NivelEnum;
import br.com.lummi.sge.enums.TipoProjetoEnum;
import br.com.lummi.sge.exceptions.SgeValidationException;
import br.com.lummi.sge.models.Instituicao;
import br.com.lummi.sge.models.UnidadeInstituicao;
import br.com.lummi.sge.models.transiente.Item;
import br.com.lummi.sge.models.transiente.RetornoJson;
import br.com.lummi.sge.service.InstituicaoService;
import br.com.lummi.sge.service.UnidadeInstituicaoService;
import br.com.lummi.sge.utils.Mensagens;

@Path("/instituicao")
@Controller
public class InstituicaoController {

	@Inject
	private Result result;
	@Inject
	private InstituicaoService service;
	@Inject
	private UnidadeInstituicaoService unidadeService;

	@Get
	@Path({ "/", "" })
	public List<Instituicao> index() {
		List<Instituicao> lista = service.all("nome");
		if (lista.isEmpty()) {
			result.include("warning", Mensagens.MSG_NENHUM_REGISTRO);
		}
		return lista;
	}

	@Post
	@Path("/buscarNiveis")
	public void buscarNiveis(Instituicao instituicao, TipoProjetoEnum tipo) {
		List<Item> niveis = new ArrayList<>();
		switch (tipo) {
		case FORMATURA_FUNDAMENTAL:
			niveis.add(new Item(NivelEnum.FUNDAMENTAL.name(), NivelEnum.FUNDAMENTAL.getDescricao()));
			break;
		case FORMATURA_INFANTIL:
			niveis.add(new Item(NivelEnum.INFANTIL.name(), NivelEnum.INFANTIL.getDescricao()));
			break;
		case FORMATURA_MEDIO:
			niveis.add(new Item(NivelEnum.MEDIO.name(), NivelEnum.MEDIO.getDescricao()));
			break;
		case FORMATURA_FUNDAMENTAL_MEDIO:
			instituicao = service.getById(instituicao.getId());
			if (instituicao.isEnsinoFundamental()) {
				niveis.add(new Item(NivelEnum.FUNDAMENTAL.name(), NivelEnum.FUNDAMENTAL.getDescricao()));
			}
			if (instituicao.isEnsinoMedio()) {
				niveis.add(new Item(NivelEnum.MEDIO.name(), NivelEnum.MEDIO.getDescricao()));
			}
			break;
		}
		result.use(Results.json()).from(niveis).serialize();
	}

	@Post
	@Path("/salvar")
	@Transactional
	public void salvar(Instituicao instituicao) {
		RetornoJson<Instituicao> retornoJson = new RetornoJson<Instituicao>();
		try {
			if (instituicao.getId() == null) {
				service.novo(instituicao);
				retornoJson.setSuccess(Mensagens.MSG_INCLUSAO_OK);
			} else {
				service.alterar(instituicao);
				retornoJson.setSuccess(Mensagens.MSG_EDICAO_OK);
			}
			retornoJson.setObj(instituicao);
			result.use(Results.json()).from(retornoJson).include("?obj").serialize();
		} catch (SgeValidationException e) {
			retornoJson.setWarning(e.getMessage());
		}
	}

	@Get
	@Path("/buscar")
	public void buscar(Instituicao instituicao) {
		RetornoJson<Instituicao> retornoJson = new RetornoJson<Instituicao>();
		instituicao = service.getById(instituicao.getId());
		if (instituicao == null) {
			retornoJson.setError(Mensagens.MSG_NENHUM_REGISTRO);
		} else {
			retornoJson.setObj(instituicao);
		}
		result.use(Results.json()).from(retornoJson).include("?obj", "?obj.unidades").serialize();
	}

	@Post
	@Path("/buscarPorTipoProjeto")
	public void buscarPorTipoProjeto(TipoProjetoEnum tipoProjeto) {
		List<Instituicao> instituicoes = service.listarPorTipo(tipoProjeto);
		result.use(Results.json()).from(instituicoes).serialize();
	}

	@Post
	@Path("/excluirUnidade")
	@Transactional
	public void excluirUnidade(UnidadeInstituicao unidade) {
		RetornoJson<UnidadeInstituicao> retornoJson = new RetornoJson<UnidadeInstituicao>();
		try {
			unidade = unidadeService.getById(unidade.getId());
			validarExclusaoUnidade(unidade, retornoJson);
			unidadeService.delete(unidade);
			retornoJson.setObj(unidade);
			retornoJson.setSuccess(Mensagens.MSG_EXCLUSAO_OK);
		} catch (NullPointerException e) {
			retornoJson.setError("Unidade inexistente");
		} catch (Exception e) {
			retornoJson.setError(e.getMessage());
		}
		result.use(Results.json()).from(retornoJson).include("?obj").serialize();
	}

	@Post
	@Path("/excluir")
	@Transactional
	public void excluir(Instituicao instituicao) {
		RetornoJson<Instituicao> retornoJson = new RetornoJson<Instituicao>();
		try {
			instituicao = service.getById(instituicao.getId());
			if (validarExclusao(instituicao)) {
				service.delete(instituicao);
				retornoJson.setObj(instituicao);
				retornoJson.setSuccess(Mensagens.MSG_EXCLUSAO_OK);
			} else {
				retornoJson.setError("Impossível excluir. Instituição já está associada a uma turma!");
			}
		} catch (Exception e) {
			retornoJson.setError(e.getMessage());
		}
		result.use(Results.json()).from(retornoJson).include("obj").serialize();
	}

	/**
	 * @return
	 */
	private boolean validarExclusao(Instituicao instituicao) {
		if (instituicao.getUnidades() != null) {
			for (UnidadeInstituicao unidade : instituicao.getUnidades()) {
				if ((unidade.getContatos() != null && !unidade.getContatos().isEmpty())
						|| (unidade.getTurmas() != null && !unidade.getTurmas().isEmpty())) {
					return false;
				}
			}
		}
		return true;
	}

	private void validarExclusaoUnidade(UnidadeInstituicao unidade, RetornoJson<UnidadeInstituicao> retornoJson)
			throws SgeValidationException {
		if (unidade.getTurmas() != null && unidade.getTurmas().size() > 0) {
			throw new SgeValidationException("Impossível excluir. Unidade possui turmas cadastradas.");
		} else if (unidade.getContatos() != null && unidade.getContatos().size() > 0) {
			throw new SgeValidationException("Impossível excluir. Unidade possui contatos cadastrados.");
		} else if (unidade.getInstituicao().getUnidades().size() < 2) {
			throw new SgeValidationException("Impossível excluir. Uma instituição deve conter pelo menos uma unidade.");
		}
	}

}