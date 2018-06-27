package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the cpessoahoraextra database table.
 * 
 */
@Entity
@Table(name="cpessoahoraextra")
public class XPessoaHoraExtra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String ano;

	private String encarregado;

	private BigDecimal horaextra;

	private String item;

	private String mes;

	//bi-directional many-to-one association to Cpessoa
	@ManyToOne
	@JoinColumn(name="funcionarioid")
	private XPessoa pessoa;

	public XPessoaHoraExtra() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAno() {
		return this.ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getEncarregado() {
		return this.encarregado;
	}

	public void setEncarregado(String encarregado) {
		this.encarregado = encarregado;
	}

	public BigDecimal getHoraextra() {
		return this.horaextra;
	}

	public void setHoraextra(BigDecimal horaextra) {
		this.horaextra = horaextra;
	}

	public String getItem() {
		return this.item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getMes() {
		return this.mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public XPessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(XPessoa pessoa) {
		this.pessoa = pessoa;
	}

}