package br.com.lummi.sge.controllers;

import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.lummi.sge.autenticacao.Permissao;
import br.com.lummi.sge.autenticacao.PermissoesEnum;
import br.com.lummi.sge.enums.SemestreEnum;
import br.com.lummi.sge.enums.StatusEventoEnum;
import br.com.lummi.sge.enums.TipoIndicacaoEnum;
import br.com.lummi.sge.enums.TipoProjetoEnum;
import br.com.lummi.sge.exceptions.SgeException;
import br.com.lummi.sge.models.ContatoEvento;
import br.com.lummi.sge.models.PaginatedList;
import br.com.lummi.sge.models.Projeto;
import br.com.lummi.sge.models.ProjetoCorporativo;
import br.com.lummi.sge.models.ProjetoFormaturaEducaoInfantil;
import br.com.lummi.sge.models.ProjetoFormaturaEnsinoMedio;
import br.com.lummi.sge.models.ProjetoFormaturaSuperior;
import br.com.lummi.sge.models.ProjetoMarketing;
import br.com.lummi.sge.models.ProjetoSocial;
import br.com.lummi.sge.service.CaptadorExternoService;
import br.com.lummi.sge.service.ContatoEventoService;
import br.com.lummi.sge.service.CursoService;
import br.com.lummi.sge.service.FormaCaptacaoService;
import br.com.lummi.sge.service.FuncionarioService;
import br.com.lummi.sge.service.InstituicaoService;
import br.com.lummi.sge.service.ProjetoService;
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

	
	@Get
    @Path("/")
    @Permissao(PermissoesEnum.NULO)
    public void index() {
    }

	@Get
	@Path({"/aatribuir", "/aatribuir/"})
	public PaginatedList aAtribuir(int page) {
		ContatoEvento contatoEvento = new ContatoEvento();
		return aAtribuir(contatoEvento, page, 10, true);
	}

	@Post
	@Path({"/aatribuir", "/aatribuir/"})
	public PaginatedList aAtribuir(ContatoEvento contatoEvento, int page, int tamanho, boolean get) {
		contatoEvento.setStatus(StatusEventoEnum.A_ATRIBUIR);
		result.include("get", get);
		result.include("tipos", TipoProjetoEnum.values());
		result.include("contatoEvento", contatoEvento);
		if (tamanho == 0) {
			tamanho = 10;
		}
		PaginatedList lista = service.findByFiltro(contatoEvento, page, tamanho);

		if (lista.getCount() == 0) {
			result.include("warning", Mensagens.MSG_NENHUM_REGISTRO);
		}
		
		return lista;
	}

	@Get
	@Path({"/novo","/novo/"})
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
			result.redirectTo(this).aAtribuir(0);
		} catch (Exception e) {
			montarCombos(contatoEvento);
			result.include("error", e.getMessage());
		}
    }

	@Get
    @Path("/complementar/{id}")
	@Transactional
    public void complementar(Integer idContato) {
		try {
			ContatoEvento contatoEvento = service.getById(idContato);
			montarCombos(contatoEvento);
		} catch (Exception e) {
			result.include("error", e.getMessage());
		}
    }

	@Post
    @Path("/complementar")
	@Transactional
    public void complementar(ContatoEvento contatoEvento) {
		try {
			contatoEvento.setStatus(StatusEventoEnum.EM_COMPLEMENTACAO);
			service.update(contatoEvento);
		} catch (Exception e) {
			montarCombos(contatoEvento);
			result.include("error", e.getMessage());
		}
    }

	@Get
    @Path("/showaatribuir/{id}")
	@Transactional
    public void showAAtribuir(Integer id) {
		try {
			ContatoEvento contatoEvento = service.getById(id);
			montarCombos(contatoEvento);
		} catch (Exception e) {
			result.include("error", e.getMessage());
		}
    }

	@Get
    @Path("/atribuir")
	@Transactional
    public void completarContato(Integer id) {
		try {
			ContatoEvento contatoEvento = service.getById(id);
			montarCombos(contatoEvento);
		} catch (Exception e) {
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
			result.redirectTo(this).aAtribuir(0);
		} catch (Exception e) {
			montarCombos(contatoEvento);
			result.include("error", e.getMessage());
		}
    }

	@Post
    @Path("/atribuir")
	@Transactional
    public void completarContato(ContatoEvento contatoEvento) {
		try {
			contatoEvento.setStatus(StatusEventoEnum.ATRIBUIDO);
			service.update(contatoEvento);
			projetoService.create(criarProjeto(contatoEvento));
		} catch (SgeException e) {
			montarCombos(contatoEvento);
			result.include("error", e.getMessage());
		}
    }

	private Projeto criarProjeto(ContatoEvento contatoEvento) throws SgeException {
		Projeto projeto = null;
		switch (contatoEvento.getTipoProjeto()) {
		case FORMATURA_SUPERIOR:
			projeto = new ProjetoFormaturaSuperior();
			projeto.setContatoEvento(contatoEvento);
			projeto = projetoService.create(projeto, ProjetoFormaturaSuperior.class);
			return projeto;
		case FORMATURA_MEDIO:
			projeto = new ProjetoFormaturaEnsinoMedio();
			projeto.setContatoEvento(contatoEvento);
			projeto = projetoService.create(projeto, ProjetoFormaturaEnsinoMedio.class);
			return projeto;
		case FORMATURA_INFANTIL:
			projeto = new ProjetoFormaturaEducaoInfantil();
			projeto.setContatoEvento(contatoEvento);
			projeto = projetoService.create(projeto, ProjetoFormaturaEducaoInfantil.class);
			return projeto;
		case CORPORATIVO:
			projeto = new ProjetoCorporativo();
			projeto.setContatoEvento(contatoEvento);
			projeto = projetoService.create(projeto, ProjetoCorporativo.class);
			return projeto;
		case MARKETING:
			projeto = new ProjetoMarketing();
			projeto.setContatoEvento(contatoEvento);
			projeto = projetoService.create(projeto, ProjetoMarketing.class);
			return projeto;
		case SOCIAL:
			projeto = new ProjetoSocial();
			projeto.setContatoEvento(contatoEvento);
			projeto = projetoService.create(projeto, ProjetoSocial.class);
			return projeto;
		default:
			return null;
		}
	}

	private void limparRegistro(ContatoEvento contatoEvento) {
		if (contatoEvento.getCurso() != null && contatoEvento.getCurso().getId() == null) {
			contatoEvento.setCurso(null);
		}
		if (contatoEvento.getInstituicao() != null && contatoEvento.getInstituicao().getId() == null) {
			contatoEvento.setInstituicao(null);
		}
		if (contatoEvento.getFormaCaptacao() != null && contatoEvento.getFormaCaptacao().getId() == null) {
			contatoEvento.setFormaCaptacao(null);
		}
	}
    
	private void montarCombos(ContatoEvento contatoEvento) {
		result.include("contatoEvento", contatoEvento);
		result.include("tiposProjeto", TipoProjetoEnum.values());
		result.include("formasCaptacao", formaCaptacaoService.all());
		result.include("tiposIndicacao", TipoIndicacaoEnum.values());
		result.include("listaInstituicoes", instituicaoService.all());
		result.include("listaCursos", cursoService.all());
		result.include("listaSemestres", SemestreEnum.values());
		result.include("funcionariosComissao", funcionarioService.getCaptadores());
		result.include("funcionariosBonificacao", funcionarioService.all());
		result.include("projetosBonificacao", projetoService.all());
		result.include("captadoresBonificacao", captadorExternoService.all());
	}

	
}