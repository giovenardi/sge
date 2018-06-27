package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the mcontareceber database table.
 * 
 */
@Entity
@Table(name="mcontareceber")
public class XContaReceber implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private BigDecimal acrescimos;

	private String categoria;

	private String codigo;

	@Temporal(TemporalType.DATE)
	private Date competencia;

	private Integer contafinanceiraid;

	@Temporal(TemporalType.DATE)
	private Date databaixa;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datacadastro;

	private BigDecimal desconto;

	private String descricaopagamento;

	private String documentopagamento;

	private Boolean ehboletogerado;

	private Boolean ehcientefinanceiro;

	@Temporal(TemporalType.DATE)
	private Date emissao;

	private String historico;

	private BigDecimal juros;

	private BigDecimal multa;

	private Boolean notafiscal;

	private String numeronotafiscal;

	private String observacao;

	private String origem;

	@Temporal(TemporalType.DATE)
	private Date pagamento;

	private Integer parcelanumero;

	private Integer parcelatotal;

	private String referencia;

	private BigDecimal retencaocofins;

	private BigDecimal retencaocsll;

	private BigDecimal retencaoinss;

	private BigDecimal retencaoirpj;

	private BigDecimal retencaoiss;

	private BigDecimal retencaopis;

	private BigDecimal taxaboleto;

	private String tipooperacao;

	private BigDecimal valor;

	private BigDecimal valortaxaboleto;

	@Temporal(TemporalType.DATE)
	private Date vencimento;

	@ManyToOne
	@JoinColumn(name="centrocustoid")
	private XCentroCusto centroCusto;

	@ManyToOne
	@JoinColumn(name="centroresultadoid")
	private XCentroResultado centroResultado;

	@ManyToOne
	@JoinColumn(name="empresaid")
	private XEmpresa empresa;

	@ManyToOne
	@JoinColumn(name="pessoaid")
	private XPessoa pessoa;

	@ManyToOne
	@JoinColumn(name="usuariobaixaid")
	private XUsuario usuarioBaixa;

	@ManyToOne
	@JoinColumn(name="usuariocadastroid")
	private XUsuario usuarioCadastro;

	@ManyToOne
	@JoinColumn(name="formapagamento")
	private XCadastroFormaPagamento cadastroFormaPagamento;

	@ManyToOne
	@JoinColumn(name="notadebitoid")
	private XNotaDebito notaDebito;

	@ManyToOne
	@JoinColumn(name="orcamentoid")
	private XOrcamento orcamento;

	@ManyToOne
	@JoinColumn(name="projetoid")
	private XProjeto projeto;

	@OneToMany(mappedBy="contaReceber")
	private List<XContaReceberRateio> contaReceberRateios;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getAcrescimos() {
		return acrescimos;
	}

	public void setAcrescimos(BigDecimal acrescimos) {
		this.acrescimos = acrescimos;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Date getCompetencia() {
		return competencia;
	}

	public void setCompetencia(Date competencia) {
		this.competencia = competencia;
	}

	public Integer getContafinanceiraid() {
		return contafinanceiraid;
	}

	public void setContafinanceiraid(Integer contafinanceiraid) {
		this.contafinanceiraid = contafinanceiraid;
	}

	public Date getDatabaixa() {
		return databaixa;
	}

	public void setDatabaixa(Date databaixa) {
		this.databaixa = databaixa;
	}

	public Date getDatacadastro() {
		return datacadastro;
	}

	public void setDatacadastro(Date datacadastro) {
		this.datacadastro = datacadastro;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	public String getDescricaopagamento() {
		return descricaopagamento;
	}

	public void setDescricaopagamento(String descricaopagamento) {
		this.descricaopagamento = descricaopagamento;
	}

	public String getDocumentopagamento() {
		return documentopagamento;
	}

	public void setDocumentopagamento(String documentopagamento) {
		this.documentopagamento = documentopagamento;
	}

	public Boolean getEhboletogerado() {
		return ehboletogerado;
	}

	public void setEhboletogerado(Boolean ehboletogerado) {
		this.ehboletogerado = ehboletogerado;
	}

	public Boolean getEhcientefinanceiro() {
		return ehcientefinanceiro;
	}

	public void setEhcientefinanceiro(Boolean ehcientefinanceiro) {
		this.ehcientefinanceiro = ehcientefinanceiro;
	}

	public Date getEmissao() {
		return emissao;
	}

	public void setEmissao(Date emissao) {
		this.emissao = emissao;
	}

	public String getHistorico() {
		return historico;
	}

	public void setHistorico(String historico) {
		this.historico = historico;
	}

	public BigDecimal getJuros() {
		return juros;
	}

	public void setJuros(BigDecimal juros) {
		this.juros = juros;
	}

	public BigDecimal getMulta() {
		return multa;
	}

	public void setMulta(BigDecimal multa) {
		this.multa = multa;
	}

	public Boolean getNotafiscal() {
		return notafiscal;
	}

	public void setNotafiscal(Boolean notafiscal) {
		this.notafiscal = notafiscal;
	}

	public String getNumeronotafiscal() {
		return numeronotafiscal;
	}

	public void setNumeronotafiscal(String numeronotafiscal) {
		this.numeronotafiscal = numeronotafiscal;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public Date getPagamento() {
		return pagamento;
	}

	public void setPagamento(Date pagamento) {
		this.pagamento = pagamento;
	}

	public Integer getParcelanumero() {
		return parcelanumero;
	}

	public void setParcelanumero(Integer parcelanumero) {
		this.parcelanumero = parcelanumero;
	}

	public Integer getParcelatotal() {
		return parcelatotal;
	}

	public void setParcelatotal(Integer parcelatotal) {
		this.parcelatotal = parcelatotal;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public BigDecimal getRetencaocofins() {
		return retencaocofins;
	}

	public void setRetencaocofins(BigDecimal retencaocofins) {
		this.retencaocofins = retencaocofins;
	}

	public BigDecimal getRetencaocsll() {
		return retencaocsll;
	}

	public void setRetencaocsll(BigDecimal retencaocsll) {
		this.retencaocsll = retencaocsll;
	}

	public BigDecimal getRetencaoinss() {
		return retencaoinss;
	}

	public void setRetencaoinss(BigDecimal retencaoinss) {
		this.retencaoinss = retencaoinss;
	}

	public BigDecimal getRetencaoirpj() {
		return retencaoirpj;
	}

	public void setRetencaoirpj(BigDecimal retencaoirpj) {
		this.retencaoirpj = retencaoirpj;
	}

	public BigDecimal getRetencaoiss() {
		return retencaoiss;
	}

	public void setRetencaoiss(BigDecimal retencaoiss) {
		this.retencaoiss = retencaoiss;
	}

	public BigDecimal getRetencaopis() {
		return retencaopis;
	}

	public void setRetencaopis(BigDecimal retencaopis) {
		this.retencaopis = retencaopis;
	}

	public BigDecimal getTaxaboleto() {
		return taxaboleto;
	}

	public void setTaxaboleto(BigDecimal taxaboleto) {
		this.taxaboleto = taxaboleto;
	}

	public String getTipooperacao() {
		return tipooperacao;
	}

	public void setTipooperacao(String tipooperacao) {
		this.tipooperacao = tipooperacao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getValortaxaboleto() {
		return valortaxaboleto;
	}

	public void setValortaxaboleto(BigDecimal valortaxaboleto) {
		this.valortaxaboleto = valortaxaboleto;
	}

	public Date getVencimento() {
		return vencimento;
	}

	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;
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

	public XEmpresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(XEmpresa empresa) {
		this.empresa = empresa;
	}

	public XPessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(XPessoa pessoa) {
		this.pessoa = pessoa;
	}

	public XUsuario getUsuarioBaixa() {
		return usuarioBaixa;
	}

	public void setUsuarioBaixa(XUsuario usuarioBaixa) {
		this.usuarioBaixa = usuarioBaixa;
	}

	public XUsuario getUsuarioCadastro() {
		return usuarioCadastro;
	}

	public void setUsuarioCadastro(XUsuario usuarioCadastro) {
		this.usuarioCadastro = usuarioCadastro;
	}

	public XCadastroFormaPagamento getCadastroFormaPagamento() {
		return cadastroFormaPagamento;
	}

	public void setCadastroFormaPagamento(XCadastroFormaPagamento cadastroFormaPagamento) {
		this.cadastroFormaPagamento = cadastroFormaPagamento;
	}

	public XNotaDebito getNotaDebito() {
		return notaDebito;
	}

	public void setNotaDebito(XNotaDebito notaDebito) {
		this.notaDebito = notaDebito;
	}

	public XOrcamento getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(XOrcamento orcamento) {
		this.orcamento = orcamento;
	}

	public XProjeto getProjeto() {
		return projeto;
	}

	public void setProjeto(XProjeto projeto) {
		this.projeto = projeto;
	}

	public List<XContaReceberRateio> getContaReceberRateios() {
		return contaReceberRateios;
	}

	public void setContaReceberRateios(List<XContaReceberRateio> contaReceberRateios) {
		this.contaReceberRateios = contaReceberRateios;
	}

	public XContaReceber() {
	}


}