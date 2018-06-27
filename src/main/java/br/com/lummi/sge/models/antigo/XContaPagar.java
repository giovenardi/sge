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
 * The persistent class for the mcontapagar database table.
 * 
 */
@Entity
@Table(name="mcontapagar")
public class XContaPagar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private BigDecimal abatimentoBV;

	private BigDecimal acrescimos;

	@Temporal(TemporalType.DATE) 
	private Date chequeBomPara;

	private String chequeNominal;

	private String chequeNumero;

	private String codigo;

	@Temporal(TemporalType.DATE) 
	private Date competencia;

	private Boolean conciliado;

	private Boolean confirmacaoRecebimento;

	@ManyToOne
	@JoinColumn(name="contafinanceiraid")
	private XContaFinanceira contaFinanceira;

	@Temporal(TemporalType.DATE) 
	private Date dataBaixa;

	@Temporal(TemporalType.TIMESTAMP) 
	private Date dataCadastro;

	private BigDecimal desconto;

	private String documentoPagamento;

	private Boolean ehCienteFinanceiro;

	private Boolean ehComissao;

	private Boolean ehPagamentoAvulso;

	private Boolean ehRecibo;

	@Temporal(TemporalType.DATE) 
	private Date emissao;

	private String historico;

	private BigDecimal juros;

	private Boolean liberado;

	private String meioPagamento;

	private BigDecimal multa;

	private Boolean nf;

	private String nfPagamento;

	private String observacao;

	private String origem;

	@Temporal(TemporalType.DATE) 
	private Date pagamento;

	private Integer parcelaNumero;

	private Integer parcelaTotal;

	private Integer programacaoid;

	private Integer programacaotipo;

	private String referenciarecibo;

	private BigDecimal retencaocofins;

	private BigDecimal retencaocsll;

	private BigDecimal retencaoinss;

	private BigDecimal retencaoirpj;

	private BigDecimal retencaoiss;

	private BigDecimal retencaopis;

	private String tipodespesa;

	private String tipooperacao;

	private BigDecimal valor;

	@Temporal(TemporalType.DATE) 
	private Date vencimento;

	@ManyToOne
	@JoinColumn(name="areaid")
	private XArea carea;

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
	@JoinColumn(name="orcamentoid")
	private XOrcamento orcamento;

	@ManyToOne
	@JoinColumn(name="orcamentoitemid")
	private XOrcamentoItem orcamentoItem;

	@ManyToOne
	@JoinColumn(name="projetoid")
	private XProjeto projeto;

	@OneToMany(mappedBy="contaPagar")
	private List<XContaPagarRateio> contaPagarRateios;

	public XContaPagar() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getAbatimentoBV() {
		return abatimentoBV;
	}

	public void setAbatimentoBV(BigDecimal abatimentoBV) {
		this.abatimentoBV = abatimentoBV;
	}

	public BigDecimal getAcrescimos() {
		return acrescimos;
	}

	public void setAcrescimos(BigDecimal acrescimos) {
		this.acrescimos = acrescimos;
	}

	public Date getChequeBomPara() {
		return chequeBomPara;
	}

	public void setChequeBomPara(Date chequeBomPara) {
		this.chequeBomPara = chequeBomPara;
	}

	public String getChequeNominal() {
		return chequeNominal;
	}

	public void setChequeNominal(String chequeNominal) {
		this.chequeNominal = chequeNominal;
	}

	public String getChequeNumero() {
		return chequeNumero;
	}

	public void setChequeNumero(String chequeNumero) {
		this.chequeNumero = chequeNumero;
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

	public Boolean getConciliado() {
		return conciliado;
	}

	public void setConciliado(Boolean conciliado) {
		this.conciliado = conciliado;
	}

	public Boolean getConfirmacaoRecebimento() {
		return confirmacaoRecebimento;
	}

	public void setConfirmacaoRecebimento(Boolean confirmacaoRecebimento) {
		this.confirmacaoRecebimento = confirmacaoRecebimento;
	}

	public XContaFinanceira getContaFinanceira() {
		return contaFinanceira;
	}

	public void setContaFinanceira(XContaFinanceira contaFinanceira) {
		this.contaFinanceira = contaFinanceira;
	}

	public Date getDataBaixa() {
		return dataBaixa;
	}

	public void setDataBaixa(Date dataBaixa) {
		this.dataBaixa = dataBaixa;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	public String getDocumentoPagamento() {
		return documentoPagamento;
	}

	public void setDocumentoPagamento(String documentoPagamento) {
		this.documentoPagamento = documentoPagamento;
	}

	public Boolean getEhCienteFinanceiro() {
		return ehCienteFinanceiro;
	}

	public void setEhCienteFinanceiro(Boolean ehCienteFinanceiro) {
		this.ehCienteFinanceiro = ehCienteFinanceiro;
	}

	public Boolean getEhComissao() {
		return ehComissao;
	}

	public void setEhComissao(Boolean ehComissao) {
		this.ehComissao = ehComissao;
	}

	public Boolean getEhPagamentoAvulso() {
		return ehPagamentoAvulso;
	}

	public void setEhPagamentoAvulso(Boolean ehPagamentoAvulso) {
		this.ehPagamentoAvulso = ehPagamentoAvulso;
	}

	public Boolean getEhRecibo() {
		return ehRecibo;
	}

	public void setEhRecibo(Boolean ehRecibo) {
		this.ehRecibo = ehRecibo;
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

	public Boolean getLiberado() {
		return liberado;
	}

	public void setLiberado(Boolean liberado) {
		this.liberado = liberado;
	}

	public String getMeioPagamento() {
		return meioPagamento;
	}

	public void setMeioPagamento(String meioPagamento) {
		this.meioPagamento = meioPagamento;
	}

	public BigDecimal getMulta() {
		return multa;
	}

	public void setMulta(BigDecimal multa) {
		this.multa = multa;
	}

	public Boolean getNf() {
		return nf;
	}

	public void setNf(Boolean nf) {
		this.nf = nf;
	}

	public String getNfPagamento() {
		return nfPagamento;
	}

	public void setNfPagamento(String nfPagamento) {
		this.nfPagamento = nfPagamento;
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

	public Integer getParcelaNumero() {
		return parcelaNumero;
	}

	public void setParcelaNumero(Integer parcelaNumero) {
		this.parcelaNumero = parcelaNumero;
	}

	public Integer getParcelaTotal() {
		return parcelaTotal;
	}

	public void setParcelaTotal(Integer parcelaTotal) {
		this.parcelaTotal = parcelaTotal;
	}

	public Integer getProgramacaoid() {
		return programacaoid;
	}

	public void setProgramacaoid(Integer programacaoid) {
		this.programacaoid = programacaoid;
	}

	public Integer getProgramacaotipo() {
		return programacaotipo;
	}

	public void setProgramacaotipo(Integer programacaotipo) {
		this.programacaotipo = programacaotipo;
	}

	public String getReferenciarecibo() {
		return referenciarecibo;
	}

	public void setReferenciarecibo(String referenciarecibo) {
		this.referenciarecibo = referenciarecibo;
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

	public String getTipodespesa() {
		return tipodespesa;
	}

	public void setTipodespesa(String tipodespesa) {
		this.tipodespesa = tipodespesa;
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

	public Date getVencimento() {
		return vencimento;
	}

	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;
	}

	public XArea getCarea() {
		return carea;
	}

	public void setCarea(XArea carea) {
		this.carea = carea;
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

	public XOrcamento getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(XOrcamento orcamento) {
		this.orcamento = orcamento;
	}

	public XOrcamentoItem getOrcamentoItem() {
		return orcamentoItem;
	}

	public void setOrcamentoItem(XOrcamentoItem orcamentoItem) {
		this.orcamentoItem = orcamentoItem;
	}

	public XProjeto getProjeto() {
		return projeto;
	}

	public void setProjeto(XProjeto projeto) {
		this.projeto = projeto;
	}

	public List<XContaPagarRateio> getContaPagarRateios() {
		return contaPagarRateios;
	}

	public void setContaPagarRateios(List<XContaPagarRateio> contaPagarRateios) {
		this.contaPagarRateios = contaPagarRateios;
	}


}