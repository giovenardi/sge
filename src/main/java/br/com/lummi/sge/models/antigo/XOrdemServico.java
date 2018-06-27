package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the mordemservico database table.
 * 
 */
@Entity
@Table(name="mordemservico")
public class XOrdemServico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String codigo;

	private Integer conceitoid;

	private Timestamp dataaprovacao;

	private Timestamp datacadastro;

	private Timestamp datadesaprovacao;

	private Timestamp dataliberacao;

	private Boolean ehliberacaoadministrativo;

	private Timestamp emissao;

	private String estado;

	private String faturapara;

	private String historico;

	private String meiopagamento;

	private Boolean nf;

	private String notasimportantes;

	private BigDecimal perbv;

	private BigDecimal retencaocofins;

	private BigDecimal retencaocsll;

	private BigDecimal retencaoinss;

	private BigDecimal retencaoirpj;

	private BigDecimal retencaoiss;

	private BigDecimal retencaopis;

	@Column(name="servico_condicaopagto")
	private String servicoCondicaopagto;

	@Column(name="servico_dataentrega")
	private Timestamp servicoDataentrega;

	@Column(name="servico_especificacao")
	private String servicoEspecificacao;

	@Column(name="servico_formapagto")
	private Integer servicoFormapagto;

	@Column(name="servico_localentrega")
	private String servicoLocalentrega;

	@Column(name="servico_nome")
	private String servicoNome;

	@Column(name="servico_valor")
	private BigDecimal servicoValor;

	@Column(name="servico_vencimento")
	private Timestamp servicoVencimento;

	private String tipo;

	private String tipopagamento;

	private BigDecimal valorbv;

	@OneToMany(mappedBy="ordemServico")
	private List<XPessoaConceito> pessoasConceitos;

	@OneToMany(mappedBy="ordemServico")
	private List<XGerenciamentoPerformance> gerenciamentoPerformances;

	@OneToMany(mappedBy="ordemServico")
	private List<XOrdemServicoProgramacao> ordensServicoProgramacao;

	@ManyToOne
	@JoinColumn(name="servico_centrocustoid")
	private XCentroCusto centroCusto;

	@ManyToOne
	@JoinColumn(name="empresaid")
	private XEmpresa empresa;

	@ManyToOne
	@JoinColumn(name="terceiroid")
	private XPessoa terceiro;

	@ManyToOne
	@JoinColumn(name="clienteid")
	private XPessoa cliente;

	@ManyToOne
	@JoinColumn(name="fornecedorid")
	private XPessoa fornecedor;

	@ManyToOne
	@JoinColumn(name="usuarioaprovacaoid")
	private XUsuario usuarioAprovacao;

	@ManyToOne
	@JoinColumn(name="usuariodesaprovacaoid")
	private XUsuario usuarioDesaprovacao;

	@ManyToOne
	@JoinColumn(name="usuarioliberacaocaoid")
	private XUsuario usuarioLiberacao;

	@ManyToOne
	@JoinColumn(name="usuarioid")
	private XUsuario usuario;

	@ManyToOne
	@JoinColumn(name="formapagamentoid")
	private XCadastroFormaPagamento cadastroFormaPagamento;

	@ManyToOne
	@JoinColumn(name="orcamentoid")
	private XOrcamento orcamento;

	@ManyToOne
	@JoinColumn(name="solicitacaoorcamentoid")
	private XSolicitacaoOrcamento solicitacaoOrcamento;

	@OneToMany(mappedBy="ordemServico")
	private List<XOrdemServicoItem> mordemservicoitems;

	public XOrdemServico() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Integer getConceitoid() {
		return this.conceitoid;
	}

	public void setConceitoid(Integer conceitoid) {
		this.conceitoid = conceitoid;
	}

	public Timestamp getDataaprovacao() {
		return this.dataaprovacao;
	}

	public void setDataaprovacao(Timestamp dataaprovacao) {
		this.dataaprovacao = dataaprovacao;
	}

	public Timestamp getDatacadastro() {
		return this.datacadastro;
	}

	public void setDatacadastro(Timestamp datacadastro) {
		this.datacadastro = datacadastro;
	}

	public Timestamp getDatadesaprovacao() {
		return this.datadesaprovacao;
	}

	public void setDatadesaprovacao(Timestamp datadesaprovacao) {
		this.datadesaprovacao = datadesaprovacao;
	}

	public Timestamp getDataliberacao() {
		return this.dataliberacao;
	}

	public void setDataliberacao(Timestamp dataliberacao) {
		this.dataliberacao = dataliberacao;
	}

	public Boolean getEhliberacaoadministrativo() {
		return this.ehliberacaoadministrativo;
	}

	public void setEhliberacaoadministrativo(Boolean ehliberacaoadministrativo) {
		this.ehliberacaoadministrativo = ehliberacaoadministrativo;
	}

	public Timestamp getEmissao() {
		return this.emissao;
	}

	public void setEmissao(Timestamp emissao) {
		this.emissao = emissao;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFaturapara() {
		return this.faturapara;
	}

	public void setFaturapara(String faturapara) {
		this.faturapara = faturapara;
	}

	public String getHistorico() {
		return this.historico;
	}

	public void setHistorico(String historico) {
		this.historico = historico;
	}

	public String getMeiopagamento() {
		return this.meiopagamento;
	}

	public void setMeiopagamento(String meiopagamento) {
		this.meiopagamento = meiopagamento;
	}

	public Boolean getNf() {
		return this.nf;
	}

	public void setNf(Boolean nf) {
		this.nf = nf;
	}

	public String getNotasimportantes() {
		return this.notasimportantes;
	}

	public void setNotasimportantes(String notasimportantes) {
		this.notasimportantes = notasimportantes;
	}

	public BigDecimal getPerbv() {
		return this.perbv;
	}

	public void setPerbv(BigDecimal perbv) {
		this.perbv = perbv;
	}

	public BigDecimal getRetencaocofins() {
		return this.retencaocofins;
	}

	public void setRetencaocofins(BigDecimal retencaocofins) {
		this.retencaocofins = retencaocofins;
	}

	public BigDecimal getRetencaocsll() {
		return this.retencaocsll;
	}

	public void setRetencaocsll(BigDecimal retencaocsll) {
		this.retencaocsll = retencaocsll;
	}

	public BigDecimal getRetencaoinss() {
		return this.retencaoinss;
	}

	public void setRetencaoinss(BigDecimal retencaoinss) {
		this.retencaoinss = retencaoinss;
	}

	public BigDecimal getRetencaoirpj() {
		return this.retencaoirpj;
	}

	public void setRetencaoirpj(BigDecimal retencaoirpj) {
		this.retencaoirpj = retencaoirpj;
	}

	public BigDecimal getRetencaoiss() {
		return this.retencaoiss;
	}

	public void setRetencaoiss(BigDecimal retencaoiss) {
		this.retencaoiss = retencaoiss;
	}

	public BigDecimal getRetencaopis() {
		return this.retencaopis;
	}

	public void setRetencaopis(BigDecimal retencaopis) {
		this.retencaopis = retencaopis;
	}

	public String getServicoCondicaopagto() {
		return this.servicoCondicaopagto;
	}

	public void setServicoCondicaopagto(String servicoCondicaopagto) {
		this.servicoCondicaopagto = servicoCondicaopagto;
	}

	public Timestamp getServicoDataentrega() {
		return this.servicoDataentrega;
	}

	public void setServicoDataentrega(Timestamp servicoDataentrega) {
		this.servicoDataentrega = servicoDataentrega;
	}

	public String getServicoEspecificacao() {
		return this.servicoEspecificacao;
	}

	public void setServicoEspecificacao(String servicoEspecificacao) {
		this.servicoEspecificacao = servicoEspecificacao;
	}

	public Integer getServicoFormapagto() {
		return this.servicoFormapagto;
	}

	public void setServicoFormapagto(Integer servicoFormapagto) {
		this.servicoFormapagto = servicoFormapagto;
	}

	public String getServicoLocalentrega() {
		return this.servicoLocalentrega;
	}

	public void setServicoLocalentrega(String servicoLocalentrega) {
		this.servicoLocalentrega = servicoLocalentrega;
	}

	public String getServicoNome() {
		return this.servicoNome;
	}

	public void setServicoNome(String servicoNome) {
		this.servicoNome = servicoNome;
	}

	public BigDecimal getServicoValor() {
		return this.servicoValor;
	}

	public void setServicoValor(BigDecimal servicoValor) {
		this.servicoValor = servicoValor;
	}

	public Timestamp getServicoVencimento() {
		return this.servicoVencimento;
	}

	public void setServicoVencimento(Timestamp servicoVencimento) {
		this.servicoVencimento = servicoVencimento;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTipopagamento() {
		return this.tipopagamento;
	}

	public void setTipopagamento(String tipopagamento) {
		this.tipopagamento = tipopagamento;
	}

	public BigDecimal getValorbv() {
		return this.valorbv;
	}

	public void setValorbv(BigDecimal valorbv) {
		this.valorbv = valorbv;
	}

	public List<XPessoaConceito> getPessoasConceitos() {
		return pessoasConceitos;
	}

	public void setPessoasConceitos(List<XPessoaConceito> pessoasConceitos) {
		this.pessoasConceitos = pessoasConceitos;
	}

	public List<XGerenciamentoPerformance> getGerenciamentoPerformances() {
		return gerenciamentoPerformances;
	}

	public void setGerenciamentoPerformances(List<XGerenciamentoPerformance> gerenciamentoPerformances) {
		this.gerenciamentoPerformances = gerenciamentoPerformances;
	}

	public List<XOrdemServicoProgramacao> getOrdensServicoProgramacao() {
		return ordensServicoProgramacao;
	}

	public void setOrdensServicoProgramacao(List<XOrdemServicoProgramacao> ordensServicoProgramacao) {
		this.ordensServicoProgramacao = ordensServicoProgramacao;
	}

	public XCentroCusto getCentroCusto() {
		return centroCusto;
	}

	public void setCentroCusto(XCentroCusto centroCusto) {
		this.centroCusto = centroCusto;
	}

	public XEmpresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(XEmpresa empresa) {
		this.empresa = empresa;
	}

	public XPessoa getTerceiro() {
		return terceiro;
	}

	public void setTerceiro(XPessoa terceiro) {
		this.terceiro = terceiro;
	}

	public XPessoa getCliente() {
		return cliente;
	}

	public void setCliente(XPessoa cliente) {
		this.cliente = cliente;
	}

	public XPessoa getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(XPessoa fornecedor) {
		this.fornecedor = fornecedor;
	}

	public XUsuario getUsuarioAprovacao() {
		return usuarioAprovacao;
	}

	public void setUsuarioAprovacao(XUsuario usuarioAprovacao) {
		this.usuarioAprovacao = usuarioAprovacao;
	}

	public XUsuario getUsuarioDesaprovacao() {
		return usuarioDesaprovacao;
	}

	public void setUsuarioDesaprovacao(XUsuario usuarioDesaprovacao) {
		this.usuarioDesaprovacao = usuarioDesaprovacao;
	}

	public XUsuario getUsuarioLiberacao() {
		return usuarioLiberacao;
	}

	public void setUsuarioLiberacao(XUsuario usuarioLiberacao) {
		this.usuarioLiberacao = usuarioLiberacao;
	}

	public XUsuario getUsuario() {
		return usuario;
	}

	public void setUsuario(XUsuario usuario) {
		this.usuario = usuario;
	}

	public XCadastroFormaPagamento getCadastroFormaPagamento() {
		return cadastroFormaPagamento;
	}

	public void setCadastroFormaPagamento(XCadastroFormaPagamento cadastroFormaPagamento) {
		this.cadastroFormaPagamento = cadastroFormaPagamento;
	}

	public XOrcamento getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(XOrcamento orcamento) {
		this.orcamento = orcamento;
	}

	public XSolicitacaoOrcamento getSolicitacaoOrcamento() {
		return solicitacaoOrcamento;
	}

	public void setSolicitacaoOrcamento(XSolicitacaoOrcamento solicitacaoOrcamento) {
		this.solicitacaoOrcamento = solicitacaoOrcamento;
	}

	public List<XOrdemServicoItem> getMordemservicoitems() {
		return mordemservicoitems;
	}

	public void setMordemservicoitems(List<XOrdemServicoItem> mordemservicoitems) {
		this.mordemservicoitems = mordemservicoitems;
	}

}