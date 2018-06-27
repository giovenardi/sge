package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the gcontareceber database table.
 * 
 */
//@Entity
@Table(name="gcontareceber")
public class XContaReceber2 implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer contareceber;

	private Timestamp data;

	private Integer id;

	private Integer usuarioid;

	private BigDecimal valor;

	private Timestamp vencimento;

	public XContaReceber2() {
	}

	public Integer getContareceber() {
		return this.contareceber;
	}

	public void setContareceber(Integer contareceber) {
		this.contareceber = contareceber;
	}

	public Timestamp getData() {
		return this.data;
	}

	public void setData(Timestamp data) {
		this.data = data;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUsuarioid() {
		return this.usuarioid;
	}

	public void setUsuarioid(Integer usuarioid) {
		this.usuarioid = usuarioid;
	}

	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Timestamp getVencimento() {
		return this.vencimento;
	}

	public void setVencimento(Timestamp vencimento) {
		this.vencimento = vencimento;
	}

}