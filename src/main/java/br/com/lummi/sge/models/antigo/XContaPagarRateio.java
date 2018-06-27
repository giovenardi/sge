package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * The persistent class for the mcontapagarrateio database table.
 * 
 */
@Entity
@Table(name="mcontapagarrateio")
public class XContaPagarRateio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private BigDecimal valor;

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
	@JoinColumn(name="orcamentoitemid")
	private XItemOrcamento itemOrcamento;

	@ManyToOne
	@JoinColumn(name="fornecedorid")
	private XPessoa fornecedor;

	@ManyToOne
	@JoinColumn(name="contaid")
	private XContaPagar contaPagar;

	@ManyToOne
	@JoinColumn(name="orcamentoid")
	private XOrcamento orcamento;

	public XContaPagarRateio() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
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

	public XItemOrcamento getItemOrcamento() {
		return itemOrcamento;
	}

	public void setItemOrcamento(XItemOrcamento itemOrcamento) {
		this.itemOrcamento = itemOrcamento;
	}

	public XPessoa getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(XPessoa fornecedor) {
		this.fornecedor = fornecedor;
	}

	public XContaPagar getContaPagar() {
		return contaPagar;
	}

	public void setContaPagar(XContaPagar contaPagar) {
		this.contaPagar = contaPagar;
	}

	public XOrcamento getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(XOrcamento orcamento) {
		this.orcamento = orcamento;
	}

}