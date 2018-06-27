package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the mcontareceberrateio database table.
 * 
 */
@Entity
@Table(name="mcontareceberrateio")
public class XContaReceberRateio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private BigDecimal valor;

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
	@JoinColumn(name="contaid")
	private XContaReceber contaReceber;

	public XContaReceberRateio() {
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

	public XContaReceber getContaReceber() {
		return contaReceber;
	}

	public void setContaReceber(XContaReceber contaReceber) {
		this.contaReceber = contaReceber;
	}


}