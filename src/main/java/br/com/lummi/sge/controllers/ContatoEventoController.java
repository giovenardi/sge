package br.com.lummi.sge.controllers;

import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.lummi.sge.autenticacao.Permissao;
import br.com.lummi.sge.autenticacao.PermissoesEnum;
import br.com.lummi.sge.enums.SemestreEnum;
import br.com.lummi.sge.enums.StatusEventoEnum;
import br.com.lummi.sge.enums.StatusProjetoEnum;
import br.com.lummi.sge.enums.TipoIndicacaoEnum;
import br.com.lummi.sge.enums.TipoProjetoEnum;
import br.com.lummi.sge.exceptions.SgeException;
import br.com.lummi.sge.models.ComissaoFormatura;
import br.com.lummi.sge.models.ContatoEvento;
import br.com.lummi.sge.models.Funcionario;
import br.com.lummi.sge.models.PaginatedList;
import br.com.lummi.sge.models.Projeto;
import br.com.lummi.sge.models.ProjetoCorporativo;
import br.com.lummi.sge.models.ProjetoFormatura;
import br.com.lummi.sge.models.ProjetoFormaturaEducaoInfantil;
import br.com.lummi.sge.models.ProjetoFormaturaFundamentalMedio;
import br.com.lummi.sge.models.ProjetoFormaturaSuperior;
import br.com.lummi.sge.models.ProjetoMarketing;
import br.com.lummi.sge.models.ProjetoSocial;
import br.com.lummi.sge.models.Turma;
import br.com.lummi.sge.models.transiente.RetornoJson;
import br.com.lummi.sge.service.CaptadorExternoService;
import br.com.lummi.sge.service.ComissaoFormaturaService;
import br.com.lummi.sge.service.ContatoEventoService;
import br.com.lummi.sge.service.CursoService;
import br.com.lummi.sge.service.FormaCaptacaoService;
import br.com.lummi.sge.service.FuncionarioService;
import br.com.lummi.sge.service.InstituicaoService;
import br.com.lummi.sge.service.ProjetoService;
import br.com.lummi.sge.service.TurmaService;
import br.com.lummi.sge.service.TurnoService;
import br.com.lummi.sge.service.UnidadeInstituicaoService;
import br.com.lummi.sge.utils.Mensagens;

@Path("/contatoEvento")
@Controller
public class ContatoEventoController {

	@Inject
	private Result result;
	@Inject
	private ContatoEventoService service;
	@Inject
	private FormaCaptacaoService formaCaptacaoService;
	@Inject
	private InstituicaoService instituicaoService;
	@Inject
	private CursoService cursoService;
	@Inject
	private ProjetoService projetoService;
	@Inject
	private FuncionarioService funcionarioService;
	@Inject
	private CaptadorExternoService captadorExternoService;
	@Inject
	private TurmaService turmaService;
	@Inject
	private TurnoService turnoService;
	@Inject
	private UnidadeInstituicaoService unidadeInstituicaoService;
	@Inject
	private ComissaoFormaturaService comissaoFormaturaService;

	@Get
	@Path("/")
	@Permissao(PermissoesEnum.NULO)
	public void index() {
	}

	@Get
	@Path({ "/primeiroContato", "/primeiroContato/" })
	public PaginatedList primeiroContato(int page) {
		ContatoEvento contatoEvento = new ContatoEvento();
		contatoEvento.setStatus(StatusEventoEnum.PRIMEIRO_CONTATO);
		result.include("get", true);
		result.include("tiposProjeto", TipoProjetoEnum.values());
		PaginatedList lista = service.findByFiltro(contatoEvento, page, 999999);

		if (lista.getCount() == 0) {
			result.include("warning", Mensagens.MSG_NENHUM_REGISTRO);
		}

		return lista;
	}

	@Get
	@Path({ "/confirmacaoAtendimento", "/confirmacaoAtendimento/" })
	public PaginatedList confirmacaoAtendimento(int page) {
		ContatoEvento contatoEvento = new ContatoEvento();
		contatoEvento.setStatus(StatusEventoEnum.CONFIRMAR_ATENDIMENTO);
		result.include("get", true);
		result.include("tiposProjeto", TipoProjetoEnum.values());
		result.include("vendedores", funcionarioService.getVendedores());
		PaginatedList lista = service.findByFiltro(contatoEvento, page, 99999);

		if (lista.getCount() == 0) {
			result.include("warning", Mensagens.MSG_NENHUM_REGISTRO);
		}

		return lista;
	}

	@Get
	@Path({ "/emAtendimento", "/emAtendimento/" })
	public PaginatedList emAtendimento(int page) {
		ContatoEvento contatoEvento = new ContatoEvento();
		contatoEvento.setStatus(StatusEventoEnum.EM_ATENDIMENTO);
		result.include("get", true);
		result.include("tiposProjeto", TipoProjetoEnum.values());
		result.include("vendedores", funcionarioService.getVendedores());
		PaginatedList lista = service.findByFiltro(contatoEvento, page, 999999);

		if (lista.getCount() == 0) {
			result.include("warning", Mensagens.MSG_NENHUM_REGISTRO);
		}

		return lista;
	}

	@Get
	@Path({ "/confirmacaoAtivacao", "/confirmacaoAtivacao/" })
	public PaginatedList confirmacaoAtivacao(int page) {
		ContatoEvento contatoEvento = new ContatoEvento();
		contatoEvento.setStatus(StatusEventoEnum.CONFIRMAR_ATIVACAO);
		result.include("get", true);
		result.include("tiposProjeto", TipoProjetoEnum.values());
		result.include("vendedores", funcionarioService.getVendedores());
		result.include("gerentes", funcionarioService.getGerentes());
		PaginatedList lista = service.findByFiltro(contatoEvento, page, 999999);

		if (lista.getCount() == 0) {
			result.include("warning", Mensagens.MSG_NENHUM_REGISTRO);
		}

		return lista;
	}

	@Get
	@Path({ "/ativos", "/ativos/" })
	public PaginatedList ativos(int page) {
		ContatoEvento contatoEvento = new ContatoEvento();
		contatoEvento.setStatus(StatusEventoEnum.ATIVO);
		result.include("get", true);
		result.include("tipos", TipoProjetoEnum.values());
		result.include("contatoEvento", contatoEvento);
		PaginatedList lista = service.findByFiltro(contatoEvento, page, 999999);

		if (lista.getCount() == 0) {
			result.include("warning", Mensagens.MSG_NENHUM_REGISTRO);
		}

		return lista;
	}

	@Get
	@Path({ "/novo", "/novo/" })
	public void novo(String func) {
		result.include("tiposProjeto", TipoProjetoEnum.values());
		montarCombos(new ContatoEvento());
	}

	@Post
	@Path("/novo")
	@Transactional
	public void novo(ContatoEvento contatoEvento) {
		try {
			limparRegistro(contatoEvento);
			service.create(contatoEvento);
			result.redirectTo(this).primeiroContato(0);
		} catch (Exception e) {
			montarCombos(contatoEvento);
			result.include("error", e.getMessage());
		}
	}

	@Get
	@Path("/alterar/{id}")
	public void alterar(Integer id) {
		try {
			ContatoEvento contatoEvento = service.getById(id);
			montarCombos(contatoEvento);
		} catch (Exception e) {
			result.include("error", e.getMessage());
		}
	}

	@Post
	@Path("/alterar")
	@Transactional
	public void alterar(ContatoEvento contatoEvento) {
		try {
			service.update(contatoEvento);
			result.redirectTo(this).primeiroContato(0);
		} catch (Exception e) {
			montarCombos(contatoEvento);
			result.include("error", e.getMessage());
		}
	}

	@Get
	@Path("/buscar")
	public void buscar(ContatoEvento contatoEvento) {
		RetornoJson<ContatoEvento> retornoJson = new RetornoJson<ContatoEvento>();
		contatoEvento = service.getById(contatoEvento.getId());
		if (contatoEvento == null) {
			retornoJson.setError(Mensagens.MSG_NENHUM_REGISTRO);
		} else {
			retornoJson.setObj(contatoEvento);
		}
		result.use(Results.json()).from(retornoJson).include("?obj", "?obj.vendedor")
				.serialize();
	}

	@Post
	@Path("/solicitarAprovacao")
	@Transactional
	public void solicitarAprovacao(ContatoEvento contatoEvento) {
		RetornoJson<ContatoEvento> retornoJson = new RetornoJson<ContatoEvento>();
		service.solicitarAprovacao(contatoEvento);
		contatoEvento = service.getById(contatoEvento.getId());
		if (contatoEvento == null) {
			retornoJson.setError(Mensagens.MSG_NENHUM_REGISTRO);
		} else {
			retornoJson.setObj(contatoEvento);
		}
		result.use(Results.json()).from(retornoJson).include("?obj")
				.serialize();
	}

	@Post
	@Path("/solicitarAtivacao")
	@Transactional
	public void solicitarAtivacao(ContatoEvento contatoEvento) {
		RetornoJson<ContatoEvento> retornoJson = new RetornoJson<ContatoEvento>();
		service.solicitarAtivacao(contatoEvento);
		contatoEvento = service.getById(contatoEvento.getId());
		if (contatoEvento == null) {
			retornoJson.setError(Mensagens.MSG_NENHUM_REGISTRO);
		} else {
			retornoJson.setObj(contatoEvento);
		}
		result.use(Results.json()).from(retornoJson).include("?obj")
				.serialize();
	}

	@Post
	@Path("/aprovar")
	@Transactional
	public void aprovar(ContatoEvento contatoEvento) {
		RetornoJson<ContatoEvento> retornoJson = new RetornoJson<ContatoEvento>();
		service.aprovar(contatoEvento);
		contatoEvento = service.getById(contatoEvento.getId());
		if (contatoEvento == null) {
			retornoJson.setError(Mensagens.MSG_NENHUM_REGISTRO);
		} else {
			retornoJson.setObj(contatoEvento);
		}
		result.use(Results.json()).from(retornoJson).include("?obj")
				.serialize();
	}

	@Post
	@Path("/ativar")
	@Transactional
	public void ativar(ContatoEvento contatoEvento) {
		RetornoJson<Projeto> retornoJson = new RetornoJson<Projeto>();
		Projeto projeto;
		try {
			Funcionario gerente = service.ativar(contatoEvento);
			projeto = criarProjeto(contatoEvento, gerente);
			if (contatoEvento == null) {
				retornoJson.setError(Mensagens.MSG_NENHUM_REGISTRO);
			} else {
				retornoJson.setObj(projeto);
			}
			result.use(Results.json()).from(retornoJson).include("?obj")
					.serialize();
		} catch (SgeException e) {
			retornoJson.setError(e.getMessage());
		}
	}

	private Projeto criarProjeto(ContatoEvento contatoEvento, Funcionario gerente) throws SgeException {
		Projeto projeto = null;
		Turma turma = new Turma();
		ContatoEvento contatoEventoBD = service.getById(contatoEvento.getId());
		switch (contatoEvento.getTipoProjeto()) {
		case FORMATURA_SUPERIOR:
			projeto = new ProjetoFormaturaSuperior();
			turma.setAno(contatoEventoBD.getAno());
			turma.setCurso(contatoEventoBD.getCurso());
			turma.setNome(contatoEventoBD.getNome());
			turma.setNumero(contatoEventoBD.getNumeroTurma());
			turma.setSemestre(contatoEventoBD.getSemestre());
			turma.setTurno(contatoEventoBD.getTurno());
			turma.setUnidadeInstituicao(contatoEventoBD.getUnidadeInstituicao());
			projeto.setStatus(StatusProjetoEnum.EM_ATENDIMENTO);
			projeto.setContatoEvento(contatoEvento);
			projeto.setGerente(gerente);
			((ProjetoFormatura) projeto).setComissaoFormatura(comissaoFormaturaService.create(new ComissaoFormatura()));
			projeto = projetoService.create(projeto, projeto.getClass());
			turma.setProjeto((ProjetoFormaturaSuperior) projeto);
			turmaService.create(turma);
			return projeto;
		case FORMATURA_FUNDAMENTAL_MEDIO:
		case FORMATURA_FUNDAMENTAL:
		case FORMATURA_MEDIO:
			projeto = new ProjetoFormaturaFundamentalMedio();
			turma.setAno(contatoEventoBD.getAno());
			turma.setNivel(contatoEventoBD.getNivel());
			turma.setNome(contatoEventoBD.getNome());
			turma.setNumero(contatoEventoBD.getNumeroTurma());
			turma.setTurno(contatoEventoBD.getTurno());
			turma.setUnidadeInstituicao(contatoEventoBD.getUnidadeInstituicao());
			projeto.setStatus(StatusProjetoEnum.EM_ATENDIMENTO);
			projeto.setContatoEvento(contatoEvento);
			projeto.setGerente(gerente);
			((ProjetoFormatura) projeto).setComissaoFormatura(comissaoFormaturaService.create(new ComissaoFormatura()));
			projeto = projetoService.create(projeto, projeto.getClass());
			turma.setProjeto(projeto);
			turmaService.create(turma);
			return projeto;
		case FORMATURA_INFANTIL:
			projeto = new ProjetoFormaturaEducaoInfantil();
			turma.setAno(contatoEventoBD.getAno());
			turma.setNivel(contatoEventoBD.getNivel());
			turma.setNome(contatoEventoBD.getNome());
			turma.setNumero(contatoEventoBD.getNumeroTurma());
			turma.setTurno(contatoEventoBD.getTurno());
			turma.setUnidadeInstituicao(contatoEventoBD.getUnidadeInstituicao());
			projeto.setStatus(StatusProjetoEnum.EM_ATENDIMENTO);
			projeto.setContatoEvento(contatoEvento);
			projeto.setGerente(gerente);
			((ProjetoFormatura) projeto).setComissaoFormatura(comissaoFormaturaService.create(new ComissaoFormatura()));
			projeto = projetoService.create(projeto, projeto.getClass());
			turma.setProjeto(projeto);
			turmaService.create(turma);
			return projeto;
		case CORPORATIVO:
			projeto = new ProjetoCorporativo();
			break;
		case MARKETING:
			projeto = new ProjetoMarketing();
			break;
		case SOCIAL:
			projeto = new ProjetoSocial();
			break;
		default:
			return null;
		}

		projeto.setStatus(StatusProjetoEnum.EM_ATENDIMENTO);
		projeto.setContatoEvento(contatoEvento);
		projeto.setGerente(gerente);
		projeto = projetoService.create(projeto, projeto.getClass());

		return projeto;

	}

	private void limparRegistro(ContatoEvento contatoEvento) {
		if (contatoEvento.getCurso() != null && contatoEvento.getCurso().getId() == null) {
			contatoEvento.setCurso(null);
		}
		if (contatoEvento.getUnidadeInstituicao() != null && contatoEvento.getUnidadeInstituicao().getId() == null) {
			contatoEvento.setUnidadeInstituicao(null);
		}
		if (contatoEvento.getFormaCaptacao() != null && contatoEvento.getFormaCaptacao().getId() == null) {
			contatoEvento.setFormaCaptacao(null);
		}
	}

	private void montarCombos(ContatoEvento contatoEvento) {
		if (contatoEvento.getTipoProjeto() != null) {
			result.include("listaInstituicoes", instituicaoService.listarPorTipo(contatoEvento.getTipoProjeto()));
		}
		result.include("contatoEvento", contatoEvento);
		result.include("tiposProjeto", TipoProjetoEnum.values());
		result.include("formasCaptacao", formaCaptacaoService.all());
		result.include("tiposIndicacao", TipoIndicacaoEnum.values());
		if (contatoEvento.getUnidadeInstituicao() != null) {
			result.include("listaUnidades", unidadeInstituicaoService
					.findByInstituicao(contatoEvento.getUnidadeInstituicao().getInstituicao()));
		}
		result.include("listaTurnos", turnoService.all());
		result.include("listaCursos", cursoService.all());
		result.include("listaSemestres", SemestreEnum.values());
		result.include("funcionariosComissao", funcionarioService.getCaptadores());
		result.include("funcionariosBonificacao", funcionarioService.all());
		result.include("projetosBonificacao", projetoService.all());
		result.include("captadoresBonificacao", captadorExternoService.all());
	}

}