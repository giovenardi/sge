package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the mordemserivoprogramacao database table.
 * 
 */
@Entity
@Table(name="mordemserivoprogramacao")
public class XOrdemServicoProgramacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Timestamp data;

	private Integer parcela;

	private BigDecimal valor;

	@ManyToOne
	@JoinColumn(name="ordemservicoid")
	private XOrdemServico ordemServico;

	public XOrdemServicoProgramacao() {
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

	public Integer getParcela() {
		return this.parcela;
	}

	public void setParcela(Integer parcela) {
		this.parcela = parcela;
	}

	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

}