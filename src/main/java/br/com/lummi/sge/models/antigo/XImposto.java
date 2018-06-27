package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the gimpostos database table.
 * 
 */
@Entity
@Table(name="gimpostos")
public class XImposto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private BigDecimal cofins;

	private BigDecimal ctsocial;

	private BigDecimal fator;

	private BigDecimal irpj;

	private BigDecimal pis;

	private BigDecimal simples;

	private BigDecimal ss;

	public XImposto() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getCofins() {
		return this.cofins;
	}

	public void setCofins(BigDecimal cofins) {
		this.cofins = cofins;
	}

	public BigDecimal getCtsocial() {
		return this.ctsocial;
	}

	public void setCtsocial(BigDecimal ctsocial) {
		this.ctsocial = ctsocial;
	}

	public BigDecimal getFator() {
		return this.fator;
	}

	public void setFator(BigDecimal fator) {
		this.fator = fator;
	}

	public BigDecimal getIrpj() {
		return this.irpj;
	}

	public void setIrpj(BigDecimal irpj) {
		this.irpj = irpj;
	}

	public BigDecimal getPis() {
		return this.pis;
	}

	public void setPis(BigDecimal pis) {
		this.pis = pis;
	}

	public BigDecimal getSimples() {
		return this.simples;
	}

	public void setSimples(BigDecimal simples) {
		this.simples = simples;
	}

	public BigDecimal getSs() {
		return this.ss;
	}

	public void setSs(BigDecimal ss) {
		this.ss = ss;
	}

}