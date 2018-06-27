package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cusuario database table.
 * 
 */
@Entity
@Table(name="cusuario")
public class XUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String apelido;

	private byte[] assinatura;

	private String codigo;

	private String email;

	private String logon;

	private String nome;

	private byte[] rubrica;

	private String senha;

	private Integer setorid;

	private String smtphost;

	private String smtpmailfrom;

	private String smtppassword;

	private Integer smtpport;

	private String smtpusername;

	private String tipo;

	private Boolean usosocket;

	@OneToMany(mappedBy="usuario")
	private List<XLocalAmbiente> localAmbientes;

	@OneToMany(mappedBy="usuarioResponsavel")
	private List<XLocalHistoricoVisita> localHistoricoVisitas1;

	@OneToMany(mappedBy="usuarioUltimaAlteracao")
	private List<XLocalHistoricoVisita> localHistoricoVisitas2;

	@OneToMany(mappedBy="usuario")
	private List<XPessoaAdiantamento> pessoaAdiantamentos;

	@OneToMany(mappedBy="usuario")
	private List<XPessoaCargo> pessoaCargos;

	@OneToMany(mappedBy="usuario")
	private List<XPessoaDependente> pessoaDependentes;

	@OneToMany(mappedBy="usuario")
	private List<XPessoaExame> pessoaExames;

	@OneToMany(mappedBy="usuario")
	private List<XPessoaOcorrencia> pessoaOcorrencias;

	@OneToMany(mappedBy="usuario")
	private List<XPessoaSalario> pessoaSalarios;

	@ManyToOne
	@JoinColumn(name="pessoaid")
	private XPessoa pessoa;

	@ManyToOne
	@JoinColumn(name="tipoid")
	private XTipoUsuario tipoUsuario1;

	@ManyToOne
	@JoinColumn(name="tipousuarioid")
	private XTipoUsuario tipoUsuario2;

	@OneToMany(mappedBy="usuario")
	private List<XUsuarioGerenteComissao> usuarioGerenteComissaos;

	@OneToMany(mappedBy="usuario")
	private List<XUsuarioOperacao> usuariosOperacao;

	@OneToMany(mappedBy="usuarioAgendamento")
	private List<XAgenda> agendas;

	@OneToMany(mappedBy="usuarioConfirmacao")
	private List<XAgenda> agendas2;

	@OneToMany(mappedBy="usuarioEfetivacao")
	private List<XAgenda> agendas3;

	@OneToMany(mappedBy="usuarioNaoOcorrencia")
	private List<XAgenda> agendas4;

	@OneToMany(mappedBy="usuarioAlteracao")
	private List<XAgendaParticipante> agendasParticipantesAlteradas;

	@OneToMany(mappedBy="participante")
	private List<XAgendaParticipante> agendaParticipantes;

	@OneToMany(mappedBy="usuarioAgendamento")
	private List<XAtaReuniao> atasReuniaoAgendamento;

	@OneToMany(mappedBy="usuarioCadastro")
	private List<XAtaReuniao> atasReuniaoCadastro;

	@OneToMany(mappedBy="usuarioraRealizacao")
	private List<XAtaReuniao> atasReuniaoRealizacao;

	@OneToMany(mappedBy="usuarioNaoRealizacao")
	private List<XAtaReuniao> atasReuniaoNaoRealizacao;

	@OneToMany(mappedBy="usuarioAprovado")
	private List<XBriefing> briefingsAprovado;

	@OneToMany(mappedBy="usuarioCadastro")
	private List<XBriefing> briefingsCadastro;

	@OneToMany(mappedBy="usuarioCancelado")
	private List<XBriefing> mbriefingsCancelado;

	@OneToMany(mappedBy="usuarioDevolvidoAtendimento")
	private List<XBriefing> mbriefingsDevolvidoAtendimento;

	@OneToMany(mappedBy="usuarioEmAlteracao")
	private List<XBriefing> mbriefingsEmAlteracao;

	@OneToMany(mappedBy="usuarioEmCriacao")
	private List<XBriefing> mbriefingsEmCriacao;

	@OneToMany(mappedBy="usuarioEmFinalizacao")
	private List<XBriefing> mbriefingsEmFinalizacao;

	@OneToMany(mappedBy="usuarioEncerrado")
	private List<XBriefing> mbriefingsEncerrado;

	@OneToMany(mappedBy="usuarioEnvioCriacao")
	private List<XBriefing> mbriefingsEnvioCriacao;

	@OneToMany(mappedBy="usuarioNoCliente")
	private List<XBriefing> mbriefingsNoCliente;

	@OneToMany(mappedBy="usuario")
	private List<XCheque> cheques;

	@OneToMany(mappedBy="usuario")
	private List<XContaCorrenteFinanceira> contaCorrenteFinanceiras;

	@OneToMany(mappedBy="usuarioBaixa")
	private List<XContaPagar> contasPagarBaixa;

	@OneToMany(mappedBy="usuarioCadastro")
	private List<XContaPagar> contasPagarCadastro;

	@OneToMany(mappedBy="usuarioBaixa")
	private List<XContaReceber> contasReceberBaixa;

	@OneToMany(mappedBy="usuarioCadastro")
	private List<XContaReceber> contasReceberCadastro;

	@OneToMany(mappedBy="usuarioCadastro")
	private List<XCursoAluno> cursosAlunosCadastro;

	@OneToMany(mappedBy="usuarioConfoirmacao")
	private List<XCursoAluno> cursosAlunosConfirmacao;

	@OneToMany(mappedBy="usuarioFaturamento")
	private List<XCursoAluno> cursosAlunosFaturamento;

	@OneToMany(mappedBy="usuarioCadastro")
	private List<XFaturaComissao> faturasComissaoCadastro;

	@OneToMany(mappedBy="usuarioFechamento")
	private List<XFaturaComissao> faturasComissaoFechamento;

	@OneToMany(mappedBy="usuario")
	private List<XGerenciamentoPerformance> gerenciamentoPerformances;

	@OneToMany(mappedBy="usuario")
	private List<XJob> jobs;

	@OneToMany(mappedBy="usuario1")
	private List<XJobHistoricoAlteracao> jobsHistoricoAlteracoes1;

	@OneToMany(mappedBy="usuario2")
	private List<XJobHistoricoAlteracao> jobsHistoricoAlteracoes2;

	@OneToMany(mappedBy="usuario")
	private List<XJobNotificacao> jobNotificacoes;

	@OneToMany(mappedBy="usuarioParceiro")
	private List<XJobParceiro> jobParceiros;

	@OneToMany(mappedBy="usuarioAlteracao")
	private List<XJobParceiro> jobsParceirosAlteracao;

	@OneToMany(mappedBy="usuarioAbertura")
	private List<XJobProtocolo> jobProtocolosAbertura;

	@OneToMany(mappedBy="usuarioDestino")
	private List<XJobProtocolo> jobProtocolosDestino;

	@OneToMany(mappedBy="usuario")
	private List<XJobResponsavelInterno> jobResponsavelInternos;

	@OneToMany(mappedBy="usuarioAlteracao")
	private List<XJobResponsavelInterno> jobResponsavelInternosAlteracao;

	@OneToMany(mappedBy="usuario1")
	private List<XJobTarefa> jobTarefas1;

	@OneToMany(mappedBy="usuario2")
	private List<XJobTarefa> jobTarefas2;

	@OneToMany(mappedBy="usuario")
	private List<XJobTarefaApropriacaoHora> jobTarefaApropriacaoHoras;

	@OneToMany(mappedBy="usuarioAbertura")
	private List<XJobTarefaProtocolo> jobTarefaProtocolosAbertura;

	@OneToMany(mappedBy="usuarioDestino")
	private List<XJobTarefaProtocolo> jobTarefaProtocolosDestino;

	@OneToMany(mappedBy="usuario")
	private List<XOrcamento> orcamentos;

	@OneToMany(mappedBy="usuarioAprovacao")
	private List<XOrcamento> orcamentosAprovacao;

	@OneToMany(mappedBy="usuarioCoordenador")
	private List<XOrcamento> orcamentosCoordenador;

	@OneToMany(mappedBy="usuarioNaoAprovacao")
	private List<XOrcamento> orcamentosNaoAprovacao;

	@OneToMany(mappedBy="assinatura")
	private List<XOrcamento> orcamentosAssinatura;

	@OneToMany(mappedBy="usuario")
	private List<XOrcamentoConsumoHora> orcamentoConsumoHoras;

	@OneToMany(mappedBy="usuario")
	private List<XOrdemServico> ordemServicos;

	@OneToMany(mappedBy="usuarioAprovacao")
	private List<XOrdemServico> ordemServicos2;

	@OneToMany(mappedBy="usuarioDesaprovacao")
	private List<XOrdemServico> ordemServicos3;

	@OneToMany(mappedBy="usuario")
	private List<XOrdemServico> ordemServicos4;

	@OneToMany(mappedBy="usuarioAlteracaoQuantidade")
	private List<XProjeto> projetosAlteracaoQuantidade;

	@OneToMany(mappedBy="usuarioAtendimento")
	private List<XProjeto> projetosAtendimento;

	@OneToMany(mappedBy="usuarioAtivacao")
	private List<XProjeto> projetosAtivacao;

	@OneToMany(mappedBy="usuarioCadastro")
	private List<XProjeto> projetosCadastro;

	@OneToMany(mappedBy="usuarioCancelamento")
	private List<XProjeto> projetosCancelamento;

	@OneToMany(mappedBy="usuarioNaoEfetivacao")
	private List<XProjeto> projetosNaoEfetivacao;

	@OneToMany(mappedBy="usuarioPrimeiroContato")
	private List<XProjeto> projetosPrimeiroContato;

	@OneToMany(mappedBy="usuarioRealizacao")
	private List<XProjeto> projetosRealizacao;

	@OneToMany(mappedBy="usuario")
	private List<XProjetoEvento> projetosEvento;

	@OneToMany(mappedBy="usuario")
	private List<XProjetoHistorico> projetosHistorico;

	@OneToMany(mappedBy="usuario")
	private List<XProjetoItem> projetosItem;

	@OneToMany(mappedBy="usuarioCadastro")
	private List<XProspeccao> prospeccoesCadastro;

	@OneToMany(mappedBy="usuarioEfetivacao")
	private List<XProspeccao> prospeccoesEfetivacao;

	@OneToMany(mappedBy="usuarioNegacao")
	private List<XProspeccao> prospeccoesNegacao;

	@OneToMany(mappedBy="usuario")
	private List<XProspeccaoAcompanhamento> prospeccaoAcompanhamentos;

	@OneToMany(mappedBy="usuario")
	private List<XProspeccaoLembrete> prospeccaoLembretes;

	@OneToMany(mappedBy="usuario1")
	private List<XReclamacao> reclamacoes1;

	@OneToMany(mappedBy="usuario2")
	private List<XReclamacao> reclamacoes2;

	@OneToMany(mappedBy="usuario3")
	private List<XReclamacao> reclamacoes3;

	@OneToMany(mappedBy="usuario4")
	private List<XReclamacao> reclamacoes4;

	@OneToMany(mappedBy="usuario5")
	private List<XReclamacao> reclamacoes5;

	@OneToMany(mappedBy="usuario1")
	private List<XSolicitacaoCliente> solicitacoesClientes1;

	@OneToMany(mappedBy="usuario2")
	private List<XSolicitacaoCliente> solicitacoesClientes2;

	@OneToMany(mappedBy="usuario3")
	private List<XSolicitacaoCliente> solicitacoesClientes3;

	@OneToMany(mappedBy="usuario4")
	private List<XSolicitacaoCliente> solicitacoesClientes4;

	@OneToMany(mappedBy="usuario5")
	private List<XSolicitacaoCliente> solicitacoesClientes5;

	@OneToMany(mappedBy="usuario")
	private List<XSolicitacaoOrcamento> solicitacoesOrcamento;

	@OneToMany(mappedBy="usuario1")
	private List<XTarefaIndependente> tarefasIndependentes1;

	@OneToMany(mappedBy="usuario2")
	private List<XTarefaIndependente> tarefasIndependentes2;

	@OneToMany(mappedBy="usuario")
	private List<XTarefaIndependenteApropriacaoHora> tarefasIndependentesApropriacaoHoras;

	@OneToMany(mappedBy="usuario1")
	private List<XTarefaIndependenteProtocolo> tarefasIndependentesProtocolos1;

	@OneToMany(mappedBy="usuario2")
	private List<XTarefaIndependenteProtocolo> tarefasIndependentesProtocolos2;

	@OneToMany(mappedBy="usuario")
	private List<XTicketConsumo> ticketsConsumo;

	public XUsuario() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public byte[] getAssinatura() {
		return assinatura;
	}

	public void setAssinatura(byte[] assinatura) {
		this.assinatura = assinatura;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogon() {
		return logon;
	}

	public void setLogon(String logon) {
		this.logon = logon;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public byte[] getRubrica() {
		return rubrica;
	}

	public void setRubrica(byte[] rubrica) {
		this.rubrica = rubrica;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Integer getSetorid() {
		return setorid;
	}

	public void setSetorid(Integer setorid) {
		this.setorid = setorid;
	}

	public String getSmtphost() {
		return smtphost;
	}

	public void setSmtphost(String smtphost) {
		this.smtphost = smtphost;
	}

	public String getSmtpmailfrom() {
		return smtpmailfrom;
	}

	public void setSmtpmailfrom(String smtpmailfrom) {
		this.smtpmailfrom = smtpmailfrom;
	}

	public String getSmtppassword() {
		return smtppassword;
	}

	public void setSmtppassword(String smtppassword) {
		this.smtppassword = smtppassword;
	}

	public Integer getSmtpport() {
		return smtpport;
	}

	public void setSmtpport(Integer smtpport) {
		this.smtpport = smtpport;
	}

	public String getSmtpusername() {
		return smtpusername;
	}

	public void setSmtpusername(String smtpusername) {
		this.smtpusername = smtpusername;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Boolean getUsosocket() {
		return usosocket;
	}

	public void setUsosocket(Boolean usosocket) {
		this.usosocket = usosocket;
	}

	public List<XLocalAmbiente> getLocalAmbientes() {
		return localAmbientes;
	}

	public void setLocalAmbientes(List<XLocalAmbiente> localAmbientes) {
		this.localAmbientes = localAmbientes;
	}

	public List<XLocalHistoricoVisita> getLocalHistoricoVisitas1() {
		return localHistoricoVisitas1;
	}

	public void setLocalHistoricoVisitas1(List<XLocalHistoricoVisita> localHistoricoVisitas1) {
		this.localHistoricoVisitas1 = localHistoricoVisitas1;
	}

	public List<XLocalHistoricoVisita> getLocalHistoricoVisitas2() {
		return localHistoricoVisitas2;
	}

	public void setLocalHistoricoVisitas2(List<XLocalHistoricoVisita> localHistoricoVisitas2) {
		this.localHistoricoVisitas2 = localHistoricoVisitas2;
	}

	public List<XPessoaAdiantamento> getPessoaAdiantamentos() {
		return pessoaAdiantamentos;
	}

	public void setPessoaAdiantamentos(List<XPessoaAdiantamento> pessoaAdiantamentos) {
		this.pessoaAdiantamentos = pessoaAdiantamentos;
	}

	public List<XPessoaCargo> getPessoaCargos() {
		return pessoaCargos;
	}

	public void setPessoaCargos(List<XPessoaCargo> pessoaCargos) {
		this.pessoaCargos = pessoaCargos;
	}

	public List<XPessoaDependente> getPessoaDependentes() {
		return pessoaDependentes;
	}

	public void setPessoaDependentes(List<XPessoaDependente> pessoaDependentes) {
		this.pessoaDependentes = pessoaDependentes;
	}

	public List<XPessoaExame> getPessoaExames() {
		return pessoaExames;
	}

	public void setPessoaExames(List<XPessoaExame> pessoaExames) {
		this.pessoaExames = pessoaExames;
	}

	public List<XPessoaOcorrencia> getPessoaOcorrencias() {
		return pessoaOcorrencias;
	}

	public void setPessoaOcorrencias(List<XPessoaOcorrencia> pessoaOcorrencias) {
		this.pessoaOcorrencias = pessoaOcorrencias;
	}

	public List<XPessoaSalario> getPessoaSalarios() {
		return pessoaSalarios;
	}

	public void setPessoaSalarios(List<XPessoaSalario> pessoaSalarios) {
		this.pessoaSalarios = pessoaSalarios;
	}

	public XPessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(XPessoa pessoa) {
		this.pessoa = pessoa;
	}

	public XTipoUsuario getTipoUsuario1() {
		return tipoUsuario1;
	}

	public void setTipoUsuario1(XTipoUsuario tipoUsuario1) {
		this.tipoUsuario1 = tipoUsuario1;
	}

	public XTipoUsuario getTipoUsuario2() {
		return tipoUsuario2;
	}

	public void setTipoUsuario2(XTipoUsuario tipoUsuario2) {
		this.tipoUsuario2 = tipoUsuario2;
	}

	public List<XUsuarioGerenteComissao> getUsuarioGerenteComissaos() {
		return usuarioGerenteComissaos;
	}

	public void setUsuarioGerenteComissaos(List<XUsuarioGerenteComissao> usuarioGerenteComissaos) {
		this.usuarioGerenteComissaos = usuarioGerenteComissaos;
	}

	public List<XAgenda> getAgendas() {
		return agendas;
	}

	public void setAgendas(List<XAgenda> agendas) {
		this.agendas = agendas;
	}

	public List<XAgenda> getAgendas2() {
		return agendas2;
	}

	public void setAgendas2(List<XAgenda> agendas2) {
		this.agendas2 = agendas2;
	}

	public List<XAgenda> getAgendas3() {
		return agendas3;
	}

	public void setAgendas3(List<XAgenda> agendas3) {
		this.agendas3 = agendas3;
	}

	public List<XAgenda> getAgendas4() {
		return agendas4;
	}

	public void setAgendas4(List<XAgenda> agendas4) {
		this.agendas4 = agendas4;
	}

	public List<XAgendaParticipante> getAgendasParticipantesAlteradas() {
		return agendasParticipantesAlteradas;
	}

	public void setAgendasParticipantesAlteradas(List<XAgendaParticipante> agendasParticipantesAlteradas) {
		this.agendasParticipantesAlteradas = agendasParticipantesAlteradas;
	}

	public List<XAgendaParticipante> getAgendaParticipantes() {
		return agendaParticipantes;
	}

	public void setAgendaParticipantes(List<XAgendaParticipante> agendaParticipantes) {
		this.agendaParticipantes = agendaParticipantes;
	}

	public List<XAtaReuniao> getAtasReuniaoAgendamento() {
		return atasReuniaoAgendamento;
	}

	public void setAtasReuniaoAgendamento(List<XAtaReuniao> atasReuniaoAgendamento) {
		this.atasReuniaoAgendamento = atasReuniaoAgendamento;
	}

	public List<XAtaReuniao> getAtasReuniaoCadastro() {
		return atasReuniaoCadastro;
	}

	public void setAtasReuniaoCadastro(List<XAtaReuniao> atasReuniaoCadastro) {
		this.atasReuniaoCadastro = atasReuniaoCadastro;
	}

	public List<XAtaReuniao> getAtasReuniaoRealizacao() {
		return atasReuniaoRealizacao;
	}

	public void setAtasReuniaoRealizacao(List<XAtaReuniao> atasReuniaoRealizacao) {
		this.atasReuniaoRealizacao = atasReuniaoRealizacao;
	}

	public List<XAtaReuniao> getAtasReuniaoNaoRealizacao() {
		return atasReuniaoNaoRealizacao;
	}

	public void setAtasReuniaoNaoRealizacao(List<XAtaReuniao> atasReuniaoNaoRealizacao) {
		this.atasReuniaoNaoRealizacao = atasReuniaoNaoRealizacao;
	}

	public List<XContaPagar> getContasPagarBaixa() {
		return contasPagarBaixa;
	}

	public void setContasPagarBaixa(List<XContaPagar> contasPagarBaixa) {
		this.contasPagarBaixa = contasPagarBaixa;
	}

	public List<XContaPagar> getContasPagarCadastro() {
		return contasPagarCadastro;
	}

	public void setContasPagarCadastro(List<XContaPagar> contasPagarCadastro) {
		this.contasPagarCadastro = contasPagarCadastro;
	}

	public List<XContaReceber> getContasReceberBaixa() {
		return contasReceberBaixa;
	}

	public void setContasReceberBaixa(List<XContaReceber> contasReceberBaixa) {
		this.contasReceberBaixa = contasReceberBaixa;
	}

	public List<XContaReceber> getContasReceberCadastro() {
		return contasReceberCadastro;
	}

	public void setContasReceberCadastro(List<XContaReceber> contasReceberCadastro) {
		this.contasReceberCadastro = contasReceberCadastro;
	}

	public List<XCursoAluno> getCursosAlunosCadastro() {
		return cursosAlunosCadastro;
	}

	public void setCursosAlunosCadastro(List<XCursoAluno> cursosAlunosCadastro) {
		this.cursosAlunosCadastro = cursosAlunosCadastro;
	}

	public List<XCursoAluno> getCursosAlunosConfirmacao() {
		return cursosAlunosConfirmacao;
	}

	public void setCursosAlunosConfirmacao(List<XCursoAluno> cursosAlunosConfirmacao) {
		this.cursosAlunosConfirmacao = cursosAlunosConfirmacao;
	}

	public List<XCursoAluno> getCursosAlunosFaturamento() {
		return cursosAlunosFaturamento;
	}

	public void setCursosAlunosFaturamento(List<XCursoAluno> cursosAlunosFaturamento) {
		this.cursosAlunosFaturamento = cursosAlunosFaturamento;
	}

	public List<XFaturaComissao> getFaturasComissaoCadastro() {
		return faturasComissaoCadastro;
	}

	public void setFaturasComissaoCadastro(List<XFaturaComissao> faturasComissaoCadastro) {
		this.faturasComissaoCadastro = faturasComissaoCadastro;
	}

	public List<XFaturaComissao> getFaturasComissaoFechamento() {
		return faturasComissaoFechamento;
	}

	public void setFaturasComissaoFechamento(List<XFaturaComissao> faturasComissaoFechamento) {
		this.faturasComissaoFechamento = faturasComissaoFechamento;
	}

	public List<XUsuarioOperacao> getUsuariosOperacao() {
		return usuariosOperacao;
	}

	public void setUsuariosOperacao(List<XUsuarioOperacao> usuariosOperacao) {
		this.usuariosOperacao = usuariosOperacao;
	}

	public List<XBriefing> getBriefingsAprovado() {
		return briefingsAprovado;
	}

	public void setBriefingsAprovado(List<XBriefing> briefingsAprovado) {
		this.briefingsAprovado = briefingsAprovado;
	}

	public List<XBriefing> getBriefingsCadastro() {
		return briefingsCadastro;
	}

	public void setBriefingsCadastro(List<XBriefing> briefingsCadastro) {
		this.briefingsCadastro = briefingsCadastro;
	}

	public List<XBriefing> getMbriefingsCancelado() {
		return mbriefingsCancelado;
	}

	public void setMbriefingsCancelado(List<XBriefing> mbriefingsCancelado) {
		this.mbriefingsCancelado = mbriefingsCancelado;
	}

	public List<XBriefing> getMbriefingsDevolvidoAtendimento() {
		return mbriefingsDevolvidoAtendimento;
	}

	public void setMbriefingsDevolvidoAtendimento(List<XBriefing> mbriefingsDevolvidoAtendimento) {
		this.mbriefingsDevolvidoAtendimento = mbriefingsDevolvidoAtendimento;
	}

	public List<XBriefing> getMbriefingsEmAlteracao() {
		return mbriefingsEmAlteracao;
	}

	public void setMbriefingsEmAlteracao(List<XBriefing> mbriefingsEmAlteracao) {
		this.mbriefingsEmAlteracao = mbriefingsEmAlteracao;
	}

	public List<XBriefing> getMbriefingsEmCriacao() {
		return mbriefingsEmCriacao;
	}

	public void setMbriefingsEmCriacao(List<XBriefing> mbriefingsEmCriacao) {
		this.mbriefingsEmCriacao = mbriefingsEmCriacao;
	}

	public List<XBriefing> getMbriefingsEmFinalizacao() {
		return mbriefingsEmFinalizacao;
	}

	public void setMbriefingsEmFinalizacao(List<XBriefing> mbriefingsEmFinalizacao) {
		this.mbriefingsEmFinalizacao = mbriefingsEmFinalizacao;
	}

	public List<XBriefing> getMbriefingsEncerrado() {
		return mbriefingsEncerrado;
	}

	public void setMbriefingsEncerrado(List<XBriefing> mbriefingsEncerrado) {
		this.mbriefingsEncerrado = mbriefingsEncerrado;
	}

	public List<XBriefing> getMbriefingsEnvioCriacao() {
		return mbriefingsEnvioCriacao;
	}

	public void setMbriefingsEnvioCriacao(List<XBriefing> mbriefingsEnvioCriacao) {
		this.mbriefingsEnvioCriacao = mbriefingsEnvioCriacao;
	}

	public List<XBriefing> getMbriefingsNoCliente() {
		return mbriefingsNoCliente;
	}

	public void setMbriefingsNoCliente(List<XBriefing> mbriefingsNoCliente) {
		this.mbriefingsNoCliente = mbriefingsNoCliente;
	}

	public List<XCheque> getCheques() {
		return cheques;
	}

	public void setCheques(List<XCheque> cheques) {
		this.cheques = cheques;
	}

	public List<XContaCorrenteFinanceira> getContaCorrenteFinanceiras() {
		return contaCorrenteFinanceiras;
	}

	public void setContaCorrenteFinanceiras(List<XContaCorrenteFinanceira> contaCorrenteFinanceiras) {
		this.contaCorrenteFinanceiras = contaCorrenteFinanceiras;
	}

	public List<XGerenciamentoPerformance> getGerenciamentoPerformances() {
		return gerenciamentoPerformances;
	}

	public void setGerenciamentoPerformances(List<XGerenciamentoPerformance> gerenciamentoPerformances) {
		this.gerenciamentoPerformances = gerenciamentoPerformances;
	}

	public List<XJob> getJobs() {
		return jobs;
	}

	public void setJobs(List<XJob> jobs) {
		this.jobs = jobs;
	}

	public List<XJobHistoricoAlteracao> getJobsHistoricoAlteracoes1() {
		return jobsHistoricoAlteracoes1;
	}

	public void setJobsHistoricoAlteracoes1(List<XJobHistoricoAlteracao> jobsHistoricoAlteracoes1) {
		this.jobsHistoricoAlteracoes1 = jobsHistoricoAlteracoes1;
	}

	public List<XJobHistoricoAlteracao> getJobsHistoricoAlteracoes2() {
		return jobsHistoricoAlteracoes2;
	}

	public void setJobsHistoricoAlteracoes2(List<XJobHistoricoAlteracao> jobsHistoricoAlteracoes2) {
		this.jobsHistoricoAlteracoes2 = jobsHistoricoAlteracoes2;
	}

	public List<XJobNotificacao> getJobNotificacoes() {
		return jobNotificacoes;
	}

	public void setJobNotificacoes(List<XJobNotificacao> jobNotificacoes) {
		this.jobNotificacoes = jobNotificacoes;
	}

	public List<XJobParceiro> getJobParceiros() {
		return jobParceiros;
	}

	public void setJobParceiros(List<XJobParceiro> jobParceiros) {
		this.jobParceiros = jobParceiros;
	}

	public List<XJobParceiro> getJobsParceirosAlteracao() {
		return jobsParceirosAlteracao;
	}

	public void setJobsParceirosAlteracao(List<XJobParceiro> jobsParceirosAlteracao) {
		this.jobsParceirosAlteracao = jobsParceirosAlteracao;
	}

	public List<XJobProtocolo> getJobProtocolosAbertura() {
		return jobProtocolosAbertura;
	}

	public void setJobProtocolosAbertura(List<XJobProtocolo> jobProtocolosAbertura) {
		this.jobProtocolosAbertura = jobProtocolosAbertura;
	}

	public List<XJobProtocolo> getJobProtocolosDestino() {
		return jobProtocolosDestino;
	}

	public void setJobProtocolosDestino(List<XJobProtocolo> jobProtocolosDestino) {
		this.jobProtocolosDestino = jobProtocolosDestino;
	}

	public List<XJobResponsavelInterno> getJobResponsavelInternos() {
		return jobResponsavelInternos;
	}

	public void setJobResponsavelInternos(List<XJobResponsavelInterno> jobResponsavelInternos) {
		this.jobResponsavelInternos = jobResponsavelInternos;
	}

	public List<XJobResponsavelInterno> getJobResponsavelInternosAlteracao() {
		return jobResponsavelInternosAlteracao;
	}

	public void setJobResponsavelInternosAlteracao(List<XJobResponsavelInterno> jobResponsavelInternosAlteracao) {
		this.jobResponsavelInternosAlteracao = jobResponsavelInternosAlteracao;
	}

	public List<XJobTarefa> getJobTarefas1() {
		return jobTarefas1;
	}

	public void setJobTarefas1(List<XJobTarefa> jobTarefas1) {
		this.jobTarefas1 = jobTarefas1;
	}

	public List<XJobTarefa> getJobTarefas2() {
		return jobTarefas2;
	}

	public void setJobTarefas2(List<XJobTarefa> jobTarefas2) {
		this.jobTarefas2 = jobTarefas2;
	}

	public List<XJobTarefaApropriacaoHora> getJobTarefaApropriacaoHoras() {
		return jobTarefaApropriacaoHoras;
	}

	public void setJobTarefaApropriacaoHoras(List<XJobTarefaApropriacaoHora> jobTarefaApropriacaoHoras) {
		this.jobTarefaApropriacaoHoras = jobTarefaApropriacaoHoras;
	}

	public List<XJobTarefaProtocolo> getJobTarefaProtocolosAbertura() {
		return jobTarefaProtocolosAbertura;
	}

	public void setJobTarefaProtocolosAbertura(List<XJobTarefaProtocolo> jobTarefaProtocolosAbertura) {
		this.jobTarefaProtocolosAbertura = jobTarefaProtocolosAbertura;
	}

	public List<XJobTarefaProtocolo> getJobTarefaProtocolosDestino() {
		return jobTarefaProtocolosDestino;
	}

	public void setJobTarefaProtocolosDestino(List<XJobTarefaProtocolo> jobTarefaProtocolosDestino) {
		this.jobTarefaProtocolosDestino = jobTarefaProtocolosDestino;
	}

	public List<XOrcamento> getOrcamentos() {
		return orcamentos;
	}

	public void setOrcamentos(List<XOrcamento> orcamentos) {
		this.orcamentos = orcamentos;
	}

	public List<XOrcamento> getOrcamentosAprovacao() {
		return orcamentosAprovacao;
	}

	public void setOrcamentosAprovacao(List<XOrcamento> orcamentosAprovacao) {
		this.orcamentosAprovacao = orcamentosAprovacao;
	}

	public List<XOrcamento> getOrcamentosCoordenador() {
		return orcamentosCoordenador;
	}

	public void setOrcamentosCoordenador(List<XOrcamento> orcamentosCoordenador) {
		this.orcamentosCoordenador = orcamentosCoordenador;
	}

	public List<XOrcamento> getOrcamentosNaoAprovacao() {
		return orcamentosNaoAprovacao;
	}

	public void setOrcamentosNaoAprovacao(List<XOrcamento> orcamentosNaoAprovacao) {
		this.orcamentosNaoAprovacao = orcamentosNaoAprovacao;
	}

	public List<XOrcamento> getOrcamentosAssinatura() {
		return orcamentosAssinatura;
	}

	public void setOrcamentosAssinatura(List<XOrcamento> orcamentosAssinatura) {
		this.orcamentosAssinatura = orcamentosAssinatura;
	}

	public List<XOrcamentoConsumoHora> getOrcamentoConsumoHoras() {
		return orcamentoConsumoHoras;
	}

	public void setOrcamentoConsumoHoras(List<XOrcamentoConsumoHora> orcamentoConsumoHoras) {
		this.orcamentoConsumoHoras = orcamentoConsumoHoras;
	}

	public List<XOrdemServico> getOrdemServicos() {
		return ordemServicos;
	}

	public void setOrdemServicos(List<XOrdemServico> ordemServicos) {
		this.ordemServicos = ordemServicos;
	}

	public List<XOrdemServico> getOrdemServicos2() {
		return ordemServicos2;
	}

	public void setOrdemServicos2(List<XOrdemServico> ordemServicos2) {
		this.ordemServicos2 = ordemServicos2;
	}

	public List<XOrdemServico> getOrdemServicos3() {
		return ordemServicos3;
	}

	public void setOrdemServicos3(List<XOrdemServico> ordemServicos3) {
		this.ordemServicos3 = ordemServicos3;
	}

	public List<XOrdemServico> getOrdemServicos4() {
		return ordemServicos4;
	}

	public void setOrdemServicos4(List<XOrdemServico> ordemServicos4) {
		this.ordemServicos4 = ordemServicos4;
	}

	public List<XProjeto> getProjetosAlteracaoQuantidade() {
		return projetosAlteracaoQuantidade;
	}

	public void setProjetosAlteracaoQuantidade(List<XProjeto> projetosAlteracaoQuantidade) {
		this.projetosAlteracaoQuantidade = projetosAlteracaoQuantidade;
	}

	public List<XProjeto> getProjetosAtendimento() {
		return projetosAtendimento;
	}

	public void setProjetosAtendimento(List<XProjeto> projetosAtendimento) {
		this.projetosAtendimento = projetosAtendimento;
	}

	public List<XProjeto> getProjetosAtivacao() {
		return projetosAtivacao;
	}

	public void setProjetosAtivacao(List<XProjeto> projetosAtivacao) {
		this.projetosAtivacao = projetosAtivacao;
	}

	public List<XProjeto> getProjetosCadastro() {
		return projetosCadastro;
	}

	public void setProjetosCadastro(List<XProjeto> projetosCadastro) {
		this.projetosCadastro = projetosCadastro;
	}

	public List<XProjeto> getProjetosCancelamento() {
		return projetosCancelamento;
	}

	public void setProjetosCancelamento(List<XProjeto> projetosCancelamento) {
		this.projetosCancelamento = projetosCancelamento;
	}

	public List<XProjeto> getProjetosNaoEfetivacao() {
		return projetosNaoEfetivacao;
	}

	public void setProjetosNaoEfetivacao(List<XProjeto> projetosNaoEfetivacao) {
		this.projetosNaoEfetivacao = projetosNaoEfetivacao;
	}

	public List<XProjeto> getProjetosPrimeiroContato() {
		return projetosPrimeiroContato;
	}

	public void setProjetosPrimeiroContato(List<XProjeto> projetosPrimeiroContato) {
		this.projetosPrimeiroContato = projetosPrimeiroContato;
	}

	public List<XProjeto> getProjetosRealizacao() {
		return projetosRealizacao;
	}

	public void setProjetosRealizacao(List<XProjeto> projetosRealizacao) {
		this.projetosRealizacao = projetosRealizacao;
	}

	public List<XProjetoEvento> getProjetosEvento() {
		return projetosEvento;
	}

	public void setProjetosEvento(List<XProjetoEvento> projetosEvento) {
		this.projetosEvento = projetosEvento;
	}

	public List<XProjetoHistorico> getProjetosHistorico() {
		return projetosHistorico;
	}

	public void setProjetosHistorico(List<XProjetoHistorico> projetosHistorico) {
		this.projetosHistorico = projetosHistorico;
	}

	public List<XProjetoItem> getProjetosItem() {
		return projetosItem;
	}

	public void setProjetosItem(List<XProjetoItem> projetosItem) {
		this.projetosItem = projetosItem;
	}

	public List<XProspeccao> getProspeccoesCadastro() {
		return prospeccoesCadastro;
	}

	public void setProspeccoesCadastro(List<XProspeccao> prospeccoesCadastro) {
		this.prospeccoesCadastro = prospeccoesCadastro;
	}

	public List<XProspeccao> getProspeccoesEfetivacao() {
		return prospeccoesEfetivacao;
	}

	public void setProspeccoesEfetivacao(List<XProspeccao> prospeccoesEfetivacao) {
		this.prospeccoesEfetivacao = prospeccoesEfetivacao;
	}

	public List<XProspeccao> getProspeccoesNegacao() {
		return prospeccoesNegacao;
	}

	public void setProspeccoesNegacao(List<XProspeccao> prospeccoesNegacao) {
		this.prospeccoesNegacao = prospeccoesNegacao;
	}

	public List<XProspeccaoAcompanhamento> getProspeccaoAcompanhamentos() {
		return prospeccaoAcompanhamentos;
	}

	public void setProspeccaoAcompanhamentos(List<XProspeccaoAcompanhamento> prospeccaoAcompanhamentos) {
		this.prospeccaoAcompanhamentos = prospeccaoAcompanhamentos;
	}

	public List<XProspeccaoLembrete> getProspeccaoLembretes() {
		return prospeccaoLembretes;
	}

	public void setProspeccaoLembretes(List<XProspeccaoLembrete> prospeccaoLembretes) {
		this.prospeccaoLembretes = prospeccaoLembretes;
	}

	public List<XReclamacao> getReclamacoes1() {
		return reclamacoes1;
	}

	public void setReclamacoes1(List<XReclamacao> reclamacoes1) {
		this.reclamacoes1 = reclamacoes1;
	}

	public List<XReclamacao> getReclamacoes2() {
		return reclamacoes2;
	}

	public void setReclamacoes2(List<XReclamacao> reclamacoes2) {
		this.reclamacoes2 = reclamacoes2;
	}

	public List<XReclamacao> getReclamacoes3() {
		return reclamacoes3;
	}

	public void setReclamacoes3(List<XReclamacao> reclamacoes3) {
		this.reclamacoes3 = reclamacoes3;
	}

	public List<XReclamacao> getReclamacoes4() {
		return reclamacoes4;
	}

	public void setReclamacoes4(List<XReclamacao> reclamacoes4) {
		this.reclamacoes4 = reclamacoes4;
	}

	public List<XReclamacao> getReclamacoes5() {
		return reclamacoes5;
	}

	public void setReclamacoes5(List<XReclamacao> reclamacoes5) {
		this.reclamacoes5 = reclamacoes5;
	}

	public List<XSolicitacaoCliente> getSolicitacoesClientes1() {
		return solicitacoesClientes1;
	}

	public void setSolicitacoesClientes1(List<XSolicitacaoCliente> solicitacoesClientes1) {
		this.solicitacoesClientes1 = solicitacoesClientes1;
	}

	public List<XSolicitacaoCliente> getSolicitacoesClientes2() {
		return solicitacoesClientes2;
	}

	public void setSolicitacoesClientes2(List<XSolicitacaoCliente> solicitacoesClientes2) {
		this.solicitacoesClientes2 = solicitacoesClientes2;
	}

	public List<XSolicitacaoCliente> getSolicitacoesClientes3() {
		return solicitacoesClientes3;
	}

	public void setSolicitacoesClientes3(List<XSolicitacaoCliente> solicitacoesClientes3) {
		this.solicitacoesClientes3 = solicitacoesClientes3;
	}

	public List<XSolicitacaoCliente> getSolicitacoesClientes4() {
		return solicitacoesClientes4;
	}

	public void setSolicitacoesClientes4(List<XSolicitacaoCliente> solicitacoesClientes4) {
		this.solicitacoesClientes4 = solicitacoesClientes4;
	}

	public List<XSolicitacaoCliente> getSolicitacoesClientes5() {
		return solicitacoesClientes5;
	}

	public void setSolicitacoesClientes5(List<XSolicitacaoCliente> solicitacoesClientes5) {
		this.solicitacoesClientes5 = solicitacoesClientes5;
	}

	public List<XSolicitacaoOrcamento> getSolicitacoesOrcamento() {
		return solicitacoesOrcamento;
	}

	public void setSolicitacoesOrcamento(List<XSolicitacaoOrcamento> solicitacoesOrcamento) {
		this.solicitacoesOrcamento = solicitacoesOrcamento;
	}

	public List<XTarefaIndependente> getTarefasIndependentes1() {
		return tarefasIndependentes1;
	}

	public void setTarefasIndependentes1(List<XTarefaIndependente> tarefasIndependentes1) {
		this.tarefasIndependentes1 = tarefasIndependentes1;
	}

	public List<XTarefaIndependente> getTarefasIndependentes2() {
		return tarefasIndependentes2;
	}

	public void setTarefasIndependentes2(List<XTarefaIndependente> tarefasIndependentes2) {
		this.tarefasIndependentes2 = tarefasIndependentes2;
	}

	public List<XTarefaIndependenteApropriacaoHora> getTarefasIndependentesApropriacaoHoras() {
		return tarefasIndependentesApropriacaoHoras;
	}

	public void setTarefasIndependentesApropriacaoHoras(
			List<XTarefaIndependenteApropriacaoHora> tarefasIndependentesApropriacaoHoras) {
		this.tarefasIndependentesApropriacaoHoras = tarefasIndependentesApropriacaoHoras;
	}

	public List<XTarefaIndependenteProtocolo> getTarefasIndependentesProtocolos1() {
		return tarefasIndependentesProtocolos1;
	}

	public void setTarefasIndependentesProtocolos1(List<XTarefaIndependenteProtocolo> tarefasIndependentesProtocolos1) {
		this.tarefasIndependentesProtocolos1 = tarefasIndependentesProtocolos1;
	}

	public List<XTarefaIndependenteProtocolo> getTarefasIndependentesProtocolos2() {
		return tarefasIndependentesProtocolos2;
	}

	public void setTarefasIndependentesProtocolos2(List<XTarefaIndependenteProtocolo> tarefasIndependentesProtocolos2) {
		this.tarefasIndependentesProtocolos2 = tarefasIndependentesProtocolos2;
	}

	public List<XTicketConsumo> getTicketsConsumo() {
		return ticketsConsumo;
	}

	public void setTicketsConsumo(List<XTicketConsumo> ticketsConsumo) {
		this.ticketsConsumo = ticketsConsumo;
	}


}