package br.com.lummi.sge.controllers;

import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.lummi.sge.enums.EstadoCivilEnum;
import br.com.lummi.sge.enums.FormaParcelamentoEnum;
import br.com.lummi.sge.enums.MeioPagamentoEnum;
import br.com.lummi.sge.enums.ResponsabilidadeFinanceiraEnum;
import br.com.lummi.sge.enums.SemestreEnum;
import br.com.lummi.sge.enums.SexoEnum;
import br.com.lummi.sge.enums.StatusProjetoEnum;
import br.com.lummi.sge.enums.TipoIndicacaoEnum;
import br.com.lummi.sge.enums.TipoProjetoEnum;
import br.com.lummi.sge.models.PaginatedList;
import br.com.lummi.sge.models.Projeto;
import br.com.lummi.sge.models.ProjetoFormatura;
import br.com.lummi.sge.models.ProjetoFormaturaSuperior;
import br.com.lummi.sge.models.transiente.RetornoJson;
import br.com.lummi.sge.service.BancoService;
import br.com.lummi.sge.service.CaptadorExternoService;
import br.com.lummi.sge.service.CursoService;
import br.com.lummi.sge.service.EventoService;
import br.com.lummi.sge.service.FormaCaptacaoService;
import br.com.lummi.sge.service.FormandoService;
import br.com.lummi.sge.service.FuncaoComissaoService;
import br.com.lummi.sge.service.FuncionarioService;
import br.com.lummi.sge.service.InstituicaoService;
import br.com.lummi.sge.service.ProjetoFormaturaSuperiorService;
import br.com.lummi.sge.service.ProjetoService;
import br.com.lummi.sge.service.TurnoService;
import br.com.lummi.sge.service.UfService;
import br.com.lummi.sge.utils.Mensagens;

@Controller
@Path("/projeto")
public class ProjetoController {

	@Inject
	private FormaCaptacaoService formaCaptacaoService;

	@Inject
	private InstituicaoService instituicaoService;

	@Inject
	private CursoService cursoService;

	@Inject
	private ProjetoService service;

	@Inject
	private ProjetoFormaturaSuperiorService fsService;

	@Inject
	private FuncionarioService funcionarioService;

	@Inject
	private CaptadorExternoService captadorExternoService;

	@Inject
	private Result result;

	@Inject
	private TurnoService turnoService;

	@Inject
	private UfService ufService;

	@Inject
	private BancoService bancoService;

	@Inject
	private FormandoService formandosService;

	@Inject
	private EventoService eventoService;

	@Inject
	private FuncaoComissaoService funcaoComissaoService;

	@Get
	@Path("/alterar/{id}")
	public Projeto alterar(Integer id) {
		Projeto projeto = service.getById(id);
		montarCombos(projeto);
		return projeto;
	}

	@Post
	@Path("/salvarFS")
	@Transactional
	public Projeto salvarFS(ProjetoFormaturaSuperior projeto) {
		ProjetoFormaturaSuperior projetoBD = fsService.getById(projeto.getId());
		RetornoJson<ProjetoFormaturaSuperior> retornoJson = new RetornoJson<ProjetoFormaturaSuperior>();
		projetoBD.setNumeroConvitesLuxo(projeto.getNumeroConvitesLuxo());
		projetoBD.setNumeroConvitesOnline(projeto.getNumeroConvitesOnline());
		projetoBD.setNumeroConvitesSemiluxo(projeto.getNumeroConvitesSemiluxo());
		projetoBD.setNumeroConvitesSimples(projeto.getNumeroConvitesSimples());
		projetoBD.setValorIngressoExtra(projeto.getValorIngressoExtra());
		projetoBD.setTaxaAdministrativa(projeto.getTaxaAdministrativa());
		projetoBD.setMetaFormandos(projeto.getMetaFormandos());
		projeto = fsService.update(projetoBD);
		retornoJson.setSuccess(Mensagens.MSG_INCLUSAO_OK);
		retornoJson.setObj(projeto);
		result.use(Results.json()).from(retornoJson).include("obj").serialize();

		return projeto;
	}

	@Get
	@Path({ "/", "" })
	public PaginatedList index(int page) {
		Projeto projeto = (Projeto) result.included().get("projeto");
		return index(projeto, page, 10, true);
	}

	@Post
	@Path({ "/", "" })
	public PaginatedList index(Projeto projeto, int page, int tamanho, boolean get) {
		result.include("projeto", projeto);
		if (tamanho == 0) {
			tamanho = 10;
		}
		PaginatedList lista = service.findByFiltro(projeto, page, tamanho);

		if (lista.getCount() == 0) {
			result.include("warning", Mensagens.MSG_NENHUM_REGISTRO);
		}

		return lista;
	}

	private void montarCombos(Projeto projeto) {

		switch (projeto.getTipo()) {
		case FORMATURA_INFANTIL:
		case FORMATURA_FUNDAMENTAL_MEDIO:
		case FORMATURA_FUNDAMENTAL:
		case FORMATURA_MEDIO:
		case FORMATURA_SUPERIOR:
			((ProjetoFormatura) projeto).setFormandos(formandosService.listarPorProjetoId(projeto.getId()));
			result.include("formasCaptacao", formaCaptacaoService.all());
			result.include("meiosPagamento", MeioPagamentoEnum.values());
			result.include("tiposIndicacao", TipoIndicacaoEnum.values());
			result.include("sexos", SexoEnum.values());
			result.include("bancos", bancoService.all());
			result.include("ufs", ufService.all());
			result.include("estadosCivis", EstadoCivilEnum.values());
			result.include("listaInstituicoes",
					instituicaoService.listarPorTipo(projeto.getContatoEvento().getTipoProjeto()));
			result.include("listaFuncoesComissao",
					funcaoComissaoService.all("nome"));
			result.include("listaTurnos", turnoService.all());
			result.include("listaCursos", cursoService.all());
			result.include("listaResponsabilidades", ResponsabilidadeFinanceiraEnum.values());
			result.include("statuses", StatusProjetoEnum.values());
			result.include("listaSemestres", SemestreEnum.values());
			result.include("listaFormasParcelamento", FormaParcelamentoEnum.values());
			break;
		default:
		}
		result.include("listaEventos", eventoService.all());
		result.include("tiposProjeto", TipoProjetoEnum.values());
		result.include("vendedores", funcionarioService.getVendedores());
		result.include("gerentes", funcionarioService.getGerentes());
		result.include("funcionariosComissao", funcionarioService.getCaptadores());
		result.include("funcionariosBonificacao", funcionarioService.all());
		result.include("projetosBonificacao", service.all());
		result.include("captadoresBonificacao", captadorExternoService.all());

	}

}