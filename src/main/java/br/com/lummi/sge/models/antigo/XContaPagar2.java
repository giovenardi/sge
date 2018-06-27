package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the gcontapagar database table.
 * 
 */
@Entity
@Table(name="gcontapagar")
public class XContaPagar2 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Integer contapagar;

	private Timestamp data;

	private Integer usuarioid;

	private BigDecimal valor;

	private Timestamp vencimento;

	public XContaPagar2() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getContapagar() {
		return this.contapagar;
	}

	public void setContapagar(Integer contapagar) {
		this.contapagar = contapagar;
	}

	public Timestamp getData() {
		return this.data;
	}

	public void setData(Timestamp data) {
		this.data = data;
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