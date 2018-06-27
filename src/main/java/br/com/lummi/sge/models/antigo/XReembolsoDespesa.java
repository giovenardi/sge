package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the mreembolsodespesa database table.
 * 
 */
@Entity
@Table(name="mreembolsodespesa")
public class XReembolsoDespesa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Timestamp data;

	private String despesa;

	private String item;

	private BigDecimal valor;

	//bi-directional many-to-one association to Ccentrocusto
	@ManyToOne
	@JoinColumn(name="centrocustoid")
	private XCentroCusto centroCusto;

	//bi-directional many-to-one association to Ccentroresultado
	@ManyToOne
	@JoinColumn(name="centroresultadoid")
	private XCentroResultado centroResultado;

	//bi-directional many-to-one association to Mreembolso
	@ManyToOne
	@JoinColumn(name="reembolsoid")
	private XReembolso reembolso;

	public XReembolsoDespesa() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getData() {
		return this.data;
	}

	public void setData(Timestamp data) {
		this.data = data;
	}

	public String getDespesa() {
		return this.despesa;
	}

	public void setDespesa(String despesa) {
		this.despesa = despesa;
	}

	public String getItem() {
		return this.item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public XCentroCusto getCentroCusto() {
		return this.centroCusto;
	}

	public void setCentroCusto(XCentroCusto centroCusto) {
		this.centroCusto = centroCusto;
	}

	public XCentroResultado getCentroResultado() {
		return this.centroResultado;
	}

	public void setCentroResultado(XCentroResultado centroResultado) {
		this.centroResultado = centroResultado;
	}

	public XReembolso getReembolso() {
		return this.reembolso;
	}

	public void setReembolso(XReembolso reembolso) {
		this.reembolso = reembolso;
	}

}