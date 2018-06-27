package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the gsistema database table.
 * 
 */
@Entity
@Table(name="gsistema")
public class XSistema implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private BigDecimal cartorio1;

	private BigDecimal cartorio2;

	private BigDecimal margemglobalpadraopc;

	private String notasimportantes;

	private String numeroinicialprojeto;

	private String observacaotecnica;

	private BigDecimal outrastaxa;

	private BigDecimal percentualmulta;

	private Integer prazopagamentonota;

	private Integer prazovencimentopadrao;

	private Integer qtdparcelalancmultiplo;

	private BigDecimal remuneracaopadrao;

	private BigDecimal taxajurosmes;

	private Integer tempopadraocontroleconexao;

	private BigDecimal valortaxaboleto;

	@ManyToOne
	@JoinColumn(name="centrocustoordemservicopadraoid")
	private XCentroCusto centroCusto1;

	@ManyToOne
	@JoinColumn(name="centrodecustoordemdeservicoid")
	private XCentroCusto centroCustoOrdemServico;

	@ManyToOne
	@JoinColumn(name="contapagarcentrocustoid")
	private XCentroCusto centroCustoContasPagar;

	@ManyToOne
	@JoinColumn(name="contarecebercentrocustoid")
	private XCentroCusto centroCustoContasReceber;

	@ManyToOne
	@JoinColumn(name="cidadesedeid")
	private XCidade cidadeSede;

	public XSistema() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getCartorio1() {
		return cartorio1;
	}

	public void setCartorio1(BigDecimal cartorio1) {
		this.cartorio1 = cartorio1;
	}

	public BigDecimal getCartorio2() {
		return cartorio2;
	}

	public void setCartorio2(BigDecimal cartorio2) {
		this.cartorio2 = cartorio2;
	}

	public BigDecimal getMargemglobalpadraopc() {
		return margemglobalpadraopc;
	}

	public void setMargemglobalpadraopc(BigDecimal margemglobalpadraopc) {
		this.margemglobalpadraopc = margemglobalpadraopc;
	}

	public String getNotasimportantes() {
		return notasimportantes;
	}

	public void setNotasimportantes(String notasimportantes) {
		this.notasimportantes = notasimportantes;
	}

	public String getNumeroinicialprojeto() {
		return numeroinicialprojeto;
	}

	public void setNumeroinicialprojeto(String numeroinicialprojeto) {
		this.numeroinicialprojeto = numeroinicialprojeto;
	}

	public String getObservacaotecnica() {
		return observacaotecnica;
	}

	public void setObservacaotecnica(String observacaotecnica) {
		this.observacaotecnica = observacaotecnica;
	}

	public BigDecimal getOutrastaxa() {
		return outrastaxa;
	}

	public void setOutrastaxa(BigDecimal outrastaxa) {
		this.outrastaxa = outrastaxa;
	}

	public BigDecimal getPercentualmulta() {
		return percentualmulta;
	}

	public void setPercentualmulta(BigDecimal percentualmulta) {
		this.percentualmulta = percentualmulta;
	}

	public Integer getPrazopagamentonota() {
		return prazopagamentonota;
	}

	public void setPrazopagamentonota(Integer prazopagamentonota) {
		this.prazopagamentonota = prazopagamentonota;
	}

	public Integer getPrazovencimentopadrao() {
		return prazovencimentopadrao;
	}

	public void setPrazovencimentopadrao(Integer prazovencimentopadrao) {
		this.prazovencimentopadrao = prazovencimentopadrao;
	}

	public Integer getQtdparcelalancmultiplo() {
		return qtdparcelalancmultiplo;
	}

	public void setQtdparcelalancmultiplo(Integer qtdparcelalancmultiplo) {
		this.qtdparcelalancmultiplo = qtdparcelalancmultiplo;
	}

	public BigDecimal getRemuneracaopadrao() {
		return remuneracaopadrao;
	}

	public void setRemuneracaopadrao(BigDecimal remuneracaopadrao) {
		this.remuneracaopadrao = remuneracaopadrao;
	}

	public BigDecimal getTaxajurosmes() {
		return taxajurosmes;
	}

	public void setTaxajurosmes(BigDecimal taxajurosmes) {
		this.taxajurosmes = taxajurosmes;
	}

	public Integer getTempopadraocontroleconexao() {
		return tempopadraocontroleconexao;
	}

	public void setTempopadraocontroleconexao(Integer tempopadraocontroleconexao) {
		this.tempopadraocontroleconexao = tempopadraocontroleconexao;
	}

	public BigDecimal getValortaxaboleto() {
		return valortaxaboleto;
	}

	public void setValortaxaboleto(BigDecimal valortaxaboleto) {
		this.valortaxaboleto = valortaxaboleto;
	}

	public XCentroCusto getCentroCusto1() {
		return centroCusto1;
	}

	public void setCentroCusto1(XCentroCusto centroCusto1) {
		this.centroCusto1 = centroCusto1;
	}

	public XCentroCusto getCentroCustoOrdemServico() {
		return centroCustoOrdemServico;
	}

	public void setCentroCustoOrdemServico(XCentroCusto centroCustoOrdemServico) {
		this.centroCustoOrdemServico = centroCustoOrdemServico;
	}

	public XCentroCusto getCentroCustoContasPagar() {
		return centroCustoContasPagar;
	}

	public void setCentroCustoContasPagar(XCentroCusto centroCustoContasPagar) {
		this.centroCustoContasPagar = centroCustoContasPagar;
	}

	public XCentroCusto getCentroCustoContasReceber() {
		return centroCustoContasReceber;
	}

	public void setCentroCustoContasReceber(XCentroCusto centroCustoContasReceber) {
		this.centroCustoContasReceber = centroCustoContasReceber;
	}

	public XCidade getCidadeSede() {
		return cidadeSede;
	}

	public void setCidadeSede(XCidade cidadeSede) {
		this.cidadeSede = cidadeSede;
	}

}