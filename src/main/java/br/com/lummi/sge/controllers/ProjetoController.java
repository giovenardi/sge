package br.com.lummi.sge.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.JDBCType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import br.com.lummi.sge.enums.EstadoCivilEnum;
import br.com.lummi.sge.enums.FormaParcelamentoEnum;
import br.com.lummi.sge.enums.MeioPagamentoEnum;
import br.com.lummi.sge.enums.ResponsabilidadeFinanceiraEnum;
import br.com.lummi.sge.enums.SemestreEnum;
import br.com.lummi.sge.enums.SexoEnum;
import br.com.lummi.sge.enums.StatusProjetoEnum;
import br.com.lummi.sge.enums.TipoIndicacaoEnum;
import br.com.lummi.sge.enums.TipoProjetoEnum;
import br.com.lummi.sge.models.CaptadorExterno;
import br.com.lummi.sge.models.PaginatedList;
import br.com.lummi.sge.models.Projeto;
import br.com.lummi.sge.models.ProjetoFormatura;
import br.com.lummi.sge.models.ProjetoFormaturaSuperior;
import br.com.lummi.sge.models.antigo.XBairro;
import br.com.lummi.sge.models.antigo.XCidade;
import br.com.lummi.sge.models.antigo.XCursoAluno;
import br.com.lummi.sge.models.antigo.XCursoAlunoProgramacao;
import br.com.lummi.sge.models.antigo.XPessoa;
import br.com.lummi.sge.models.transiente.RetornoJson;
import br.com.lummi.sge.service.BancoService;
import br.com.lummi.sge.service.CaptadorExternoService;
import br.com.lummi.sge.service.CursoService;
import br.com.lummi.sge.service.FormaCaptacaoService;
import br.com.lummi.sge.service.FuncionarioService;
import br.com.lummi.sge.service.GenericCRUDService;
import br.com.lummi.sge.service.InstituicaoService;
import br.com.lummi.sge.service.ProjetoFormaturaSuperiorService;
import br.com.lummi.sge.service.ProjetoService;
import br.com.lummi.sge.service.TurnoService;
import br.com.lummi.sge.service.UfService;
import br.com.lummi.sge.utils.Mensagens;
import br.com.lummi.sge.utils.Util;

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
	
	private static final String URL1 = "jdbc:firebirdsql://localhost:3050/c:\\Users\\luizfernando\\Desktop\\BBCBR.BBD";
	
	private static final String URL2 = "jdbc:postgresql://localhost:5433/sce";
	
	private static Connection con2;

	private static Connection con1;
	
	
	public static void main(String[] args) {

		try {
			Class.forName("org.firebirdsql.jdbc.FBDriver");
			Class.forName("org.postgresql.Driver");
			ResultSet projetos = obterConexaoPG().createStatement().executeQuery("select * from mprojeto where codigolummi is not null");
			while (projetos.next()) {
				System.out.println(projetos.getString("nome"));
			}
		
			
			ResultSet rs = obterConexao().createStatement().executeQuery(
					"select distinct pss.*, e1.* "
					+ "from pss "
					+ "left join ende as e1 on e1.NR_IDFR_PSS = pss.NR_IDFR_PSS and e1.IN_END_CBR = 1 "
					+ "inner join gr_sac_cdt on gr_sac_cdt.NR_IDFR_PSS = pss.NR_IDFR_PSS "
					+ "where pss.cd_tip_pss = 1 "
					+ "and gr_sac_cdt.nr_idfr_cvnt = 1 "
					+ "and pss.in_vrs_atl = 'S' "
					+ "order by pss.NR_IDFR_PSS");
			
			List<XCursoAluno> alunos = new ArrayList<XCursoAluno>();
			
			while (rs.next()) {
			
				XPessoa pessoa = new XPessoa();

				String nome = rs.getString("NM_PSS");
				
				int indexOf = nome.indexOf(" - ");
				
				if (indexOf > -1) {
				
					pessoa.setCodTurma(nome.substring(0, indexOf));
					pessoa.setNome(nome.substring(indexOf + 3));
				
				} else {
				
					pessoa.setNome(nome);
				
				}
				
				pessoa.setTipo(1);
				pessoa.setEhaluno(true);
				pessoa.setEhcliente(true);
				pessoa.setDatanascimento(rs.getDate("DT_NSC"));
				pessoa.setCpf(Util.formataCpf(rs.getString("NR_ISCR_PSS")));
				pessoa.setCep(rs.getString("CEP"));
				pessoa.setCepCob(pessoa.getCep());
				
				String uf = rs.getString("SG_UF");
				String cidade = rs.getString("TX_CID");
				
				if (uf != null && cidade != null) {
				
					XCidade xCidade = obterCidade(uf.trim(), cidade.trim());
					pessoa.setCidade(xCidade);
					pessoa.setCidadeCobranca(xCidade);
				
				}
				
				String bairro = rs.getString("TX_BAI");
				
				if (bairro != null) {
				
					XBairro xBairro = obterBairro(bairro.trim());
					pessoa.setBairro(xBairro);
					pessoa.setBairroCobranca(xBairro);
				
				}
				
				pessoa.setCodBB(rs.getInt("NR_IDFR_PSS"));
				pessoa.setEndereco(rs.getString("TX_END"));
				pessoa.setEnderecoCob(pessoa.getEndereco());
				
				XCursoAluno aluno = new XCursoAluno();
				aluno.setPessoa(pessoa);
				alunos.add(aluno);
			
			}
			
			for (XCursoAluno aluno : alunos) {
			
				buscarProgramacao(aluno);
			
			}
			
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		
		} catch (SQLException e) {

			e.printStackTrace();
		
		}
	
	}

	private static void buscarProgramacao(XCursoAluno aluno) throws SQLException {

		Integer alunoId = salvarPessoa(aluno.getPessoa());
		Integer idPrj = obterProjeto(aluno.getPessoa().getCodTurma());
		
		if (alunoId != null && idPrj != null) {
			
			PreparedStatement psConsulta = obterConexaoPG().prepareStatement("select id from mcursoaluno where alunoid = ? and projetoid = ?");
			psConsulta.setInt(1, alunoId);
			psConsulta.setInt(2, idPrj);
		
			ResultSet rsConsulta = psConsulta.executeQuery();
			
			Integer acId = null;
			
			if (rsConsulta.next()) {
			
				acId = rsConsulta.getInt("id");
			
			}
			
			if (acId == null) {
			
				PreparedStatement psTIT = obterConexao().prepareStatement("select * from tit left join dado_lqdc dl on dl.NR_IDFR_TIT = tit.NR_IDFR_TIT where tit.NR_IDFR_SAC = ? order by DT_VNCT");
				psTIT.setInt(1, aluno.getPessoa().getCodBB());
				
				ResultSet rsTIT = psTIT.executeQuery();
				
				List<XCursoAlunoProgramacao> lista = new ArrayList<XCursoAlunoProgramacao>();
				aluno.setCursosAlunoProgramacao(lista);
				
				int parcela = 1;
				
				while (rsTIT.next()) {
				
					XCursoAlunoProgramacao prog = new XCursoAlunoProgramacao();
					prog.setParcela(parcela++);
					prog.setStatus("em aberto");
					prog.setData(rsTIT.getDate("DT_VNCT"));
					prog.setValor(rsTIT.getBigDecimal("VL_TIT"));
					
					lista.add(prog);
				
				}
				
				PreparedStatement ps2Inclusao = obterConexaoPG().prepareStatement("insert into mcursoaluno(cursoid, sequencial, numero, alunoid, status, datahoracadastro, usuariocadastroid, projetoid, qtdparcelas) values(7, ?, ?, ?, 'em aberto', now(), 1, ?, ?)");
				ps2Inclusao.setString(1, ""+(idPrj*1000000+alunoId));
				ps2Inclusao.setString(2, "AD"+(idPrj*1000000+alunoId));
				ps2Inclusao.setInt(3, alunoId);
				ps2Inclusao.setInt(4, idPrj);
				ps2Inclusao.setInt(5, parcela - 1);
				ps2Inclusao.executeUpdate();
				
				ResultSet rsIdAtual = obterConexaoPG().createStatement().executeQuery("select max(id) as numero from mcursoaluno");
				rsIdAtual.next();
				acId = rsIdAtual.getInt("numero");
				
				for (XCursoAlunoProgramacao prog : lista) {
				
					PreparedStatement ps3 = obterConexaoPG().prepareStatement("insert into mcursoalunoprogramacao(alunocursoid, parcela, data, valor) values(?, ?, ?, ?)");
					ps3.setInt(1, acId);
					ps3.setInt(2, prog.getParcela());
					ps3.setDate(3, new java.sql.Date(prog.getData().getTime()));
					ps3.setBigDecimal(4, prog.getValor());
					ps3.executeUpdate();
				
				}
				
			}
			
		}
		
	}


	private static Integer salvarPessoa(XPessoa pessoa) throws SQLException {
		
		PreparedStatement psExistente = obterConexaoPG().prepareStatement("select id from cpessoa where cpf = ?");
		psExistente.setString(1, pessoa.getCpf());

		ResultSet rsExistente = psExistente.executeQuery();
		
		if (rsExistente.next()) {
		
			return rsExistente.getInt("id");
		
		}
		
		PreparedStatement psNovo = obterConexaoPG().prepareStatement("insert into cpessoa(cpf, nome, datanascimento, endereco, bairroid, cidadeid, cep, endereco_cob, bairroid_cob, cidadeid_cob, cep_cob, ehcliente, ehaluno, codigo, tipo) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 1)");
		psNovo.setString(1, pessoa.getCpf());
		psNovo.setString(2, pessoa.getNome());
		
		if (pessoa.getDatanascimento() != null) {
		
			psNovo.setDate(3, new java.sql.Date(pessoa.getDatanascimento().getTime()));
		
		} else {
		
			psNovo.setDate(3, null);
		
		}
		
		psNovo.setString(4, pessoa.getEndereco());
		
		if (pessoa.getBairro() != null) {
		
			psNovo.setInt(5, pessoa.getBairro().getId());
		
		} else {
		
			psNovo.setNull(5, JDBCType.INTEGER.ordinal());
		
		}
		
		if (pessoa.getCidade() != null) {
		
			psNovo.setInt(6, pessoa.getCidade().getId());
		
		} else {
		
			psNovo.setNull(6, JDBCType.INTEGER.ordinal());
		
		}
		
		psNovo.setString(7, pessoa.getCep());
		psNovo.setString(8, pessoa.getEndereco());
		
		if (pessoa.getBairro() != null) {
		
			psNovo.setInt(9, pessoa.getBairro().getId());
		
		} else {
		
			psNovo.setNull(9, JDBCType.INTEGER.ordinal());
		
		}
		
		if (pessoa.getCidade() != null) {
		
			psNovo.setInt(10, pessoa.getCidade().getId());
		
		} else {
		
			psNovo.setNull(10, JDBCType.INTEGER.ordinal());
		
		}
		
		psNovo.setString(11, pessoa.getCep());
		psNovo.setBoolean(12, Boolean.TRUE);
		psNovo.setBoolean(13, Boolean.TRUE);
		psNovo.setString(14, pessoa.getCodBB() + "");
		psNovo.executeUpdate();
		
		ResultSet rsNovo = psExistente.executeQuery();
		
		if (rsNovo.next()) {
		
			return rsNovo.getInt("id");
		
		}
		
		return null;
	
	}


	private static Integer obterProjeto(String codigo) throws SQLException {

		Integer cdg = null;
		
		PreparedStatement ps = obterConexaoPG().prepareStatement("select id from mprojeto where codigolummi like '%("+codigo+")%'");
		
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()) {
		
			cdg = rs.getInt("id");
		
		}
		
		return cdg;
	
	}


	private static XBairro obterBairro(String bairro) {
	
		XBairro bai = null;
		
		try {
		
			PreparedStatement ps = obterConexaoPG().prepareStatement("select * from cbairro where nome = ?");
			ps.setString(1, bairro);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
			
				bai = new XBairro();
				bai.setId(rs.getInt("id"));
				bai.setNome(rs.getString("nome"));
			
			} else {
			
				PreparedStatement ps2 = obterConexaoPG().prepareStatement("insert into cbairro(nome) values(?)");
				ps2.setString(1, bairro);
				ps2.executeUpdate();
				
				rs = ps.executeQuery();
				
				if (rs.next()) {
					
					bai = new XBairro();
					bai.setId(rs.getInt("id"));
					bai.setNome(rs.getString("nome"));
				
				}
			
			}
		
		} catch (SQLException e) {
		
			e.printStackTrace();
		
		}
		
		return bai;
	
	}


	private static XCidade obterCidade(String uf, String cidade) {
	
		XCidade cid = null;
		
		try {
		
			PreparedStatement ps = obterConexaoPG().prepareStatement("select * from ccidade where nome = ? and estado = ?");
			ps.setString(1, cidade);
			ps.setString(2, uf);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
			
				cid = new XCidade();
				cid.setId(rs.getInt("id"));
				cid.setNome(rs.getString("nome"));
				cid.setEstado(rs.getString("estado"));
			
			} else {
			
				PreparedStatement ps2 = obterConexaoPG().prepareStatement("insert into ccidade(nome,estado) values(?,?)");
				ps2.setString(1, cidade);
				ps2.setString(2, uf);
				ps2.executeUpdate();
				
				rs = ps.executeQuery();
				
				if (rs.next()) {
				
					cid = new XCidade();
					cid.setId(rs.getInt("id"));
					cid.setNome(rs.getString("nome"));
					cid.setEstado(rs.getString("estado"));
				
				}
			
			}
		
		} catch (SQLException e) {
		
			e.printStackTrace();
		
		}
		
		return cid;
	
	}


	private static Connection obterConexao() throws SQLException {
	
		if (con1 == null) {
		
			con1 = DriverManager.getConnection(URL1, "SYSDBA", "masterkey");
		
		}
		
		return con1;
	
	}
	
	private static Connection obterConexaoPG() throws SQLException {
	
		if (con2 == null) {
		
			con2 = DriverManager.getConnection(URL2, "postgres", "db@lummi!22");
		
		}
		
		return con2;
	
	}
	
	
	@Get
    @Path("/alterar/{id}")
    public Projeto alterar(Integer id) {
		Projeto projeto = service.getById(id);
		montarCombos(new ProjetoFormaturaSuperior());
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
		projetoBD.setMetaFormandos(projeto.getMetaFormandos());
		projeto = fsService.update(projetoBD);
		retornoJson.setSuccess(Mensagens.MSG_INCLUSAO_OK);
		retornoJson.setObj(projeto);
		result.use(Results.json()).from(retornoJson).include("obj").serialize();

		return projeto;
	}

	@Get
    @Path("/teste1")
    public void teste1() {
	
		montarCombos(new ProjetoFormaturaSuperior());
    
	}

	@Get
    @Path({"/", ""})
    public PaginatedList index(int page) {
		Projeto projeto = (Projeto) result.included().get("projeto");
		return index(projeto, page, 10, true);
    }
	
	@Post
	@Path({"/", ""})
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

	private void montarCombos(ProjetoFormatura projeto) {
	
		result.include("projeto", projeto);
		result.include("tiposProjeto", TipoProjetoEnum.values());
		result.include("formasCaptacao", formaCaptacaoService.all());
		result.include("meiosPagamento", MeioPagamentoEnum.values());
		result.include("tiposIndicacao", TipoIndicacaoEnum.values());
		result.include("sexos", SexoEnum.values());
		result.include("bancos", bancoService.all());
		result.include("ufs", ufService.all());
		result.include("estadosCivis", EstadoCivilEnum.values());
		result.include("listaInstituicoes", instituicaoService.all());
		result.include("listaTurnos", turnoService.all());
		result.include("listaCursos", cursoService.all());
		result.include("listaResponsabilidades", ResponsabilidadeFinanceiraEnum.values());
		result.include("statuses", StatusProjetoEnum.values());
		result.include("listaSemestres", SemestreEnum.values());
		result.include("listaFormasParcelamento", FormaParcelamentoEnum.values());
		result.include("vendedores", funcionarioService.getVendedores());
		result.include("gerentes", funcionarioService.getGerentes());
		result.include("funcionariosComissao", funcionarioService.getCaptadores());
		result.include("funcionariosBonificacao", funcionarioService.all());
		result.include("projetosBonificacao", service.all());
		result.include("captadoresBonificacao", captadorExternoService.all());

	}

}