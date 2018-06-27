package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.lummi.sge.models.FormaCaptacao;


/**
 * The persistent class for the mprojeto database table.
 * 
 */
@Entity
@Table(name="mprojeto")
public class XProjeto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String abreviatura;

	private String codigolummi;

	private Timestamp data;

	private Timestamp datahoraalteracaoorcamento;

	private Timestamp datahoraalteracaoquantidade;

	private Timestamp datahoraatendiento;

	private Timestamp datahoracadastro;

	private Timestamp datahoracancelamento;

	private Timestamp datahoranaoefetivacao;

	private Timestamp datahoraprimeirocontato;

	private Timestamp datahorarealizacao;

	private Timestamp datahorativacao;

	private Timestamp dataprimeiraparcela;

	private Timestamp dataultimaparcela;

	private String detalhamentonaoefetivacao;

	private Integer diapagamento;

	private Boolean ehcientevendedor;

	private String emailcomissaoformatura;

	private Integer formapagamentoid;

	private Integer limiteconvidade;

	private String linkconstratoassinado;

	private String linkcontratoserimonial;

	private String linkorcamentooriginal;

	private String linkplanilhavantagens;

	private Integer metaformandos;

	private String nome;

	private String numero;

	private Integer qtdparcelas;

	private Integer qtdparticipantes;

	private Integer quantidade1;

	private Integer quantidade2;

	private Integer quantidade3;

	private Integer quantidade4;

	private Timestamp referenciafinanceira;

	private String responsabailidadefinanceira;

	private String status;

	private String tipoprojeto;

	private BigDecimal valorconviteexcedente;

	private BigDecimal valorformando1;

	private BigDecimal valorformando2;

	private BigDecimal valorformando3;

	private BigDecimal valorformando4;

	private BigDecimal valorlummi;

	private BigDecimal valorparcela;

	private BigDecimal valortotal;

	@OneToMany(mappedBy="projeto")
	private List<XAgenda> agendas;

	@OneToMany(mappedBy="projeto")
	private List<XAtaReuniao> atasReunioes;

	@OneToMany(mappedBy="projeto")
	private List<XContaPagar> contasPagar;

	@OneToMany(mappedBy="projeto")
	private List<XContaReceber> contasReceber;

	@OneToMany(mappedBy="projeto")
	private List<XCursoAluno> cursosAlunos;

	@OneToMany(mappedBy="projeto")
	private List<XExtratoProjeto> extratosProjetos;

	@ManyToOne
	@JoinColumn(name="centrocustoid")
	private XCentroCusto centroCusto;

	@ManyToOne
	@JoinColumn(name="centroresultadoid")
	private XCentroResultado centroResultado;

	@ManyToOne
	@JoinColumn(name="contafinanceiraid")
	private XContaFinanceira contaFinanceira;

	@ManyToOne
	@JoinColumn(name="contafinanceirarecursocerimonialid")
	private XContaFinanceira contaFinanceiraRecursosCerimonial;

	@ManyToOne
	@JoinColumn(name="empresaid")
	private XEmpresa empresa;

	@ManyToOne
	@JoinColumn(name="formacaptacaoid")
	private FormaCaptacao captacao;

	@ManyToOne
	@JoinColumn(name="planopagamentoid")
	private XFormaPagamento formaPagamento;

	@ManyToOne
	@JoinColumn(name="motivonaoefetivacaoid")
	private XMotivoNaoEfetivacaoProjeto motivoNaoEfetivacaoProjeto;

	@ManyToOne
	@JoinColumn(name="capitadorid")
	private XPessoa captador;

	@ManyToOne
	@JoinColumn(name="clientepagadorid")
	private XPessoa clientePagador;

	@ManyToOne
	@JoinColumn(name="gerenteid")
	private XPessoa gerente;

	@ManyToOne
	@JoinColumn(name="vendedorid")
	private XPessoa vendedor;

	@ManyToOne
	@JoinColumn(name="usuarioalteracaoquantidadeid")
	private XUsuario usuarioAlteracaoQuantidade;

	@ManyToOne
	@JoinColumn(name="usuarioatendimentoid")
	private XUsuario usuarioAtendimento;

	@ManyToOne
	@JoinColumn(name="usuarioativacaoid")
	private XUsuario usuarioAtivacao;

	@ManyToOne
	@JoinColumn(name="usuariocadastroid")
	private XUsuario usuarioCadastro;

	@ManyToOne
	@JoinColumn(name="usuariocancelamentoid")
	private XUsuario usuarioCancelamento;

	@ManyToOne
	@JoinColumn(name="usuarionaoefetivacaoid")
	private XUsuario usuarioNaoEfetivacao;

	@ManyToOne
	@JoinColumn(name="usuarioprimeirocontatoid")
	private XUsuario usuarioPrimeiroContato;

	@ManyToOne
	@JoinColumn(name="usuariorealizacaoid")
	private XUsuario usuarioRealizacao;

	@OneToMany(mappedBy="projeto")
	private List<XProjetoAlvo> projetosAlvo;

	@OneToMany(mappedBy="projeto")
	private List<XProjetoComissao> projetosComissao;

	@OneToMany(mappedBy="projeto")
	private List<XProjetoContato> projetosContato;

	@OneToMany(mappedBy="projeto")
	private List<XProjetoCurso> projetosCursos;

	@OneToMany(mappedBy="projeto")
	private List<XProjetoEvento> projetosEvento;

	@OneToMany(mappedBy="projeto")
	private List<XProjetoHistorico> projetosHistorico;

	@OneToMany(mappedBy="projeto")
	private List<XProjetoItem> projetosItem;

	@OneToMany(mappedBy="projeto")
	private List<XProjetoLinkArquivo> projetosLinksArquivo;

	@OneToMany(mappedBy="projeto")
	private List<XProjetoPlano> projetosPlano;

	@OneToMany(mappedBy="projeto")
	private List<XProjetoProgramacao> projetosProgramacao;

	public XProjeto() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAbreviatura() {
		return abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	public String getCodigolummi() {
		return codigolummi;
	}

	public void setCodigolummi(String codigolummi) {
		this.codigolummi = codigolummi;
	}

	public Timestamp getData() {
		return data;
	}

	public void setData(Timestamp data) {
		this.data = data;
	}

	public Timestamp getDatahoraalteracaoorcamento() {
		return datahoraalteracaoorcamento;
	}

	public void setDatahoraalteracaoorcamento(Timestamp datahoraalteracaoorcamento) {
		this.datahoraalteracaoorcamento = datahoraalteracaoorcamento;
	}

	public Timestamp getDatahoraalteracaoquantidade() {
		return datahoraalteracaoquantidade;
	}

	public void setDatahoraalteracaoquantidade(Timestamp datahoraalteracaoquantidade) {
		this.datahoraalteracaoquantidade = datahoraalteracaoquantidade;
	}

	public Timestamp getDatahoraatendiento() {
		return datahoraatendiento;
	}

	public void setDatahoraatendiento(Timestamp datahoraatendiento) {
		this.datahoraatendiento = datahoraatendiento;
	}

	public Timestamp getDatahoracadastro() {
		return datahoracadastro;
	}

	public void setDatahoracadastro(Timestamp datahoracadastro) {
		this.datahoracadastro = datahoracadastro;
	}

	public Timestamp getDatahoracancelamento() {
		return datahoracancelamento;
	}

	public void setDatahoracancelamento(Timestamp datahoracancelamento) {
		this.datahoracancelamento = datahoracancelamento;
	}

	public Timestamp getDatahoranaoefetivacao() {
		return datahoranaoefetivacao;
	}

	public void setDatahoranaoefetivacao(Timestamp datahoranaoefetivacao) {
		this.datahoranaoefetivacao = datahoranaoefetivacao;
	}

	public Timestamp getDatahoraprimeirocontato() {
		return datahoraprimeirocontato;
	}

	public void setDatahoraprimeirocontato(Timestamp datahoraprimeirocontato) {
		this.datahoraprimeirocontato = datahoraprimeirocontato;
	}

	public Timestamp getDatahorarealizacao() {
		return datahorarealizacao;
	}

	public void setDatahorarealizacao(Timestamp datahorarealizacao) {
		this.datahorarealizacao = datahorarealizacao;
	}

	public Timestamp getDatahorativacao() {
		return datahorativacao;
	}

	public void setDatahorativacao(Timestamp datahorativacao) {
		this.datahorativacao = datahorativacao;
	}

	public Timestamp getDataprimeiraparcela() {
		return dataprimeiraparcela;
	}

	public void setDataprimeiraparcela(Timestamp dataprimeiraparcela) {
		this.dataprimeiraparcela = dataprimeiraparcela;
	}

	public Timestamp getDataultimaparcela() {
		return dataultimaparcela;
	}

	public void setDataultimaparcela(Timestamp dataultimaparcela) {
		this.dataultimaparcela = dataultimaparcela;
	}

	public String getDetalhamentonaoefetivacao() {
		return detalhamentonaoefetivacao;
	}

	public void setDetalhamentonaoefetivacao(String detalhamentonaoefetivacao) {
		this.detalhamentonaoefetivacao = detalhamentonaoefetivacao;
	}

	public Integer getDiapagamento() {
		return diapagamento;
	}

	public void setDiapagamento(Integer diapagamento) {
		this.diapagamento = diapagamento;
	}

	public Boolean getEhcientevendedor() {
		return ehcientevendedor;
	}

	public void setEhcientevendedor(Boolean ehcientevendedor) {
		this.ehcientevendedor = ehcientevendedor;
	}

	public String getEmailcomissaoformatura() {
		return emailcomissaoformatura;
	}

	public void setEmailcomissaoformatura(String emailcomissaoformatura) {
		this.emailcomissaoformatura = emailcomissaoformatura;
	}

	public Integer getFormapagamentoid() {
		return formapagamentoid;
	}

	public void setFormapagamentoid(Integer formapagamentoid) {
		this.formapagamentoid = formapagamentoid;
	}

	public Integer getLimiteconvidade() {
		return limiteconvidade;
	}

	public void setLimiteconvidade(Integer limiteconvidade) {
		this.limiteconvidade = limiteconvidade;
	}

	public String getLinkconstratoassinado() {
		return linkconstratoassinado;
	}

	public void setLinkconstratoassinado(String linkconstratoassinado) {
		this.linkconstratoassinado = linkconstratoassinado;
	}

	public String getLinkcontratoserimonial() {
		return linkcontratoserimonial;
	}

	public void setLinkcontratoserimonial(String linkcontratoserimonial) {
		this.linkcontratoserimonial = linkcontratoserimonial;
	}

	public String getLinkorcamentooriginal() {
		return linkorcamentooriginal;
	}

	public void setLinkorcamentooriginal(String linkorcamentooriginal) {
		this.linkorcamentooriginal = linkorcamentooriginal;
	}

	public String getLinkplanilhavantagens() {
		return linkplanilhavantagens;
	}

	public void setLinkplanilhavantagens(String linkplanilhavantagens) {
		this.linkplanilhavantagens = linkplanilhavantagens;
	}

	public Integer getMetaformandos() {
		return metaformandos;
	}

	public void setMetaformandos(Integer metaformandos) {
		this.metaformandos = metaformandos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Integer getQtdparcelas() {
		return qtdparcelas;
	}

	public void setQtdparcelas(Integer qtdparcelas) {
		this.qtdparcelas = qtdparcelas;
	}

	public Integer getQtdparticipantes() {
		return qtdparticipantes;
	}

	public void setQtdparticipantes(Integer qtdparticipantes) {
		this.qtdparticipantes = qtdparticipantes;
	}

	public Integer getQuantidade1() {
		return quantidade1;
	}

	public void setQuantidade1(Integer quantidade1) {
		this.quantidade1 = quantidade1;
	}

	public Integer getQuantidade2() {
		return quantidade2;
	}

	public void setQuantidade2(Integer quantidade2) {
		this.quantidade2 = quantidade2;
	}

	public Integer getQuantidade3() {
		return quantidade3;
	}

	public void setQuantidade3(Integer quantidade3) {
		this.quantidade3 = quantidade3;
	}

	public Integer getQuantidade4() {
		return quantidade4;
	}

	public void setQuantidade4(Integer quantidade4) {
		this.quantidade4 = quantidade4;
	}

	public Timestamp getReferenciafinanceira() {
		return referenciafinanceira;
	}

	public void setReferenciafinanceira(Timestamp referenciafinanceira) {
		this.referenciafinanceira = referenciafinanceira;
	}

	public String getResponsabailidadefinanceira() {
		return responsabailidadefinanceira;
	}

	public void setResponsabailidadefinanceira(String responsabailidadefinanceira) {
		this.responsabailidadefinanceira = responsabailidadefinanceira;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTipoprojeto() {
		return tipoprojeto;
	}

	public void setTipoprojeto(String tipoprojeto) {
		this.tipoprojeto = tipoprojeto;
	}

	public BigDecimal getValorconviteexcedente() {
		return valorconviteexcedente;
	}

	public void setValorconviteexcedente(BigDecimal valorconviteexcedente) {
		this.valorconviteexcedente = valorconviteexcedente;
	}

	public BigDecimal getValorformando1() {
		return valorformando1;
	}

	public void setValorformando1(BigDecimal valorformando1) {
		this.valorformando1 = valorformando1;
	}

	public BigDecimal getValorformando2() {
		return valorformando2;
	}

	public void setValorformando2(BigDecimal valorformando2) {
		this.valorformando2 = valorformando2;
	}

	public BigDecimal getValorformando3() {
		return valorformando3;
	}

	public void setValorformando3(BigDecimal valorformando3) {
		this.valorformando3 = valorformando3;
	}

	public BigDecimal getValorformando4() {
		return valorformando4;
	}

	public void setValorformando4(BigDecimal valorformando4) {
		this.valorformando4 = valorformando4;
	}

	public BigDecimal getValorlummi() {
		return valorlummi;
	}

	public void setValorlummi(BigDecimal valorlummi) {
		this.valorlummi = valorlummi;
	}

	public BigDecimal getValorparcela() {
		return valorparcela;
	}

	public void setValorparcela(BigDecimal valorparcela) {
		this.valorparcela = valorparcela;
	}

	public BigDecimal getValortotal() {
		return valortotal;
	}

	public void setValortotal(BigDecimal valortotal) {
		this.valortotal = valortotal;
	}

	public List<XAgenda> getAgendas() {
		return agendas;
	}

	public void setAgendas(List<XAgenda> agendas) {
		this.agendas = agendas;
	}

	public List<XAtaReuniao> getAtasReunioes() {
		return atasReunioes;
	}

	public void setAtasReunioes(List<XAtaReuniao> atasReunioes) {
		this.atasReunioes = atasReunioes;
	}

	public List<XContaPagar> getContasPagar() {
		return contasPagar;
	}

	public void setContasPagar(List<XContaPagar> contasPagar) {
		this.contasPagar = contasPagar;
	}

	public List<XContaReceber> getContasReceber() {
		return contasReceber;
	}

	public void setContasReceber(List<XContaReceber> contasReceber) {
		this.contasReceber = contasReceber;
	}

	public List<XCursoAluno> getCursosAlunos() {
		return cursosAlunos;
	}

	public void setCursosAlunos(List<XCursoAluno> cursosAlunos) {
		this.cursosAlunos = cursosAlunos;
	}

	public List<XExtratoProjeto> getExtratosProjetos() {
		return extratosProjetos;
	}

	public void setExtratosProjetos(List<XExtratoProjeto> extratosProjetos) {
		this.extratosProjetos = extratosProjetos;
	}

	public XCentroCusto getCentroCusto() {
		return centroCusto;
	}

	public void setCentroCusto(XCentroCusto centroCusto) {
		this.centroCusto = centroCusto;
	}

	public XCentroResultado getCentroResultado() {
		return centroResultado;
	}

	public void setCentroResultado(XCentroResultado centroResultado) {
		this.centroResultado = centroResultado;
	}

	public XContaFinanceira getContaFinanceira() {
		return contaFinanceira;
	}

	public void setContaFinanceira(XContaFinanceira contaFinanceira) {
		this.contaFinanceira = contaFinanceira;
	}

	public XContaFinanceira getContaFinanceiraRecursosCerimonial() {
		return contaFinanceiraRecursosCerimonial;
	}

	public void setContaFinanceiraRecursosCerimonial(XContaFinanceira contaFinanceiraRecursosCerimonial) {
		this.contaFinanceiraRecursosCerimonial = contaFinanceiraRecursosCerimonial;
	}

	public XEmpresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(XEmpresa empresa) {
		this.empresa = empresa;
	}

	public FormaCaptacao getCaptacao() {
		return captacao;
	}

	public void setCaptacao(FormaCaptacao captacao) {
		this.captacao = captacao;
	}

	public XFormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(XFormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public XMotivoNaoEfetivacaoProjeto getMotivoNaoEfetivacaoProjeto() {
		return motivoNaoEfetivacaoProjeto;
	}

	public void setMotivoNaoEfetivacaoProjeto(XMotivoNaoEfetivacaoProjeto motivoNaoEfetivacaoProjeto) {
		this.motivoNaoEfetivacaoProjeto = motivoNaoEfetivacaoProjeto;
	}

	public XPessoa getCaptador() {
		return captador;
	}

	public void setCaptador(XPessoa captador) {
		this.captador = captador;
	}

	public XPessoa getClientePagador() {
		return clientePagador;
	}

	public void setClientePagador(XPessoa clientePagador) {
		this.clientePagador = clientePagador;
	}

	public XPessoa getGerente() {
		return gerente;
	}

	public void setGerente(XPessoa gerente) {
		this.gerente = gerente;
	}

	public XPessoa getVendedor() {
		return vendedor;
	}

	public void setVendedor(XPessoa vendedor) {
		this.vendedor = vendedor;
	}

	public XUsuario getUsuarioAlteracaoQuantidade() {
		return usuarioAlteracaoQuantidade;
	}

	public void setUsuarioAlteracaoQuantidade(XUsuario usuarioAlteracaoQuantidade) {
		this.usuarioAlteracaoQuantidade = usuarioAlteracaoQuantidade;
	}

	public XUsuario getUsuarioAtendimento() {
		return usuarioAtendimento;
	}

	public void setUsuarioAtendimento(XUsuario usuarioAtendimento) {
		this.usuarioAtendimento = usuarioAtendimento;
	}

	public XUsuario getUsuarioAtivacao() {
		return usuarioAtivacao;
	}

	public void setUsuarioAtivacao(XUsuario usuarioAtivacao) {
		this.usuarioAtivacao = usuarioAtivacao;
	}

	public XUsuario getUsuarioCadastro() {
		return usuarioCadastro;
	}

	public void setUsuarioCadastro(XUsuario usuarioCadastro) {
		this.usuarioCadastro = usuarioCadastro;
	}

	public XUsuario getUsuarioCancelamento() {
		return usuarioCancelamento;
	}

	public void setUsuarioCancelamento(XUsuario usuarioCancelamento) {
		this.usuarioCancelamento = usuarioCancelamento;
	}

	public XUsuario getUsuarioNaoEfetivacao() {
		return usuarioNaoEfetivacao;
	}

	public void setUsuarioNaoEfetivacao(XUsuario usuarioNaoEfetivacao) {
		this.usuarioNaoEfetivacao = usuarioNaoEfetivacao;
	}

	public XUsuario getUsuarioPrimeiroContato() {
		return usuarioPrimeiroContato;
	}

	public void setUsuarioPrimeiroContato(XUsuario usuarioPrimeiroContato) {
		this.usuarioPrimeiroContato = usuarioPrimeiroContato;
	}

	public XUsuario getUsuarioRealizacao() {
		return usuarioRealizacao;
	}

	public void setUsuarioRealizacao(XUsuario usuarioRealizacao) {
		this.usuarioRealizacao = usuarioRealizacao;
	}

	public List<XProjetoAlvo> getProjetosAlvo() {
		return projetosAlvo;
	}

	public void setProjetosAlvo(List<XProjetoAlvo> projetosAlvo) {
		this.projetosAlvo = projetosAlvo;
	}

	public List<XProjetoComissao> getProjetosComissao() {
		return projetosComissao;
	}

	public void setProjetosComissao(List<XProjetoComissao> projetosComissao) {
		this.projetosComissao = projetosComissao;
	}

	public List<XProjetoContato> getProjetosContato() {
		return projetosContato;
	}

	public void setProjetosContato(List<XProjetoContato> projetosContato) {
		this.projetosContato = projetosContato;
	}

	public List<XProjetoCurso> getProjetosCursos() {
		return projetosCursos;
	}

	public void setProjetosCursos(List<XProjetoCurso> projetosCursos) {
		this.projetosCursos = projetosCursos;
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

	public List<XProjetoLinkArquivo> getProjetosLinksArquivo() {
		return projetosLinksArquivo;
	}

	public void setProjetosLinksArquivo(List<XProjetoLinkArquivo> projetosLinksArquivo) {
		this.projetosLinksArquivo = projetosLinksArquivo;
	}

	public List<XProjetoPlano> getProjetosPlano() {
		return projetosPlano;
	}

	public void setProjetosPlano(List<XProjetoPlano> projetosPlano) {
		this.projetosPlano = projetosPlano;
	}

	public List<XProjetoProgramacao> getProjetosProgramacao() {
		return projetosProgramacao;
	}

	public void setProjetosProgramacao(List<XProjetoProgramacao> projetosProgramacao) {
		this.projetosProgramacao = projetosProgramacao;
	}

}