package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the cpessoaferias database table.
 * 
 */
@Entity
@Table(name="cpessoaferias")
public class XPessoaFerias implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Integer duracao;

	private Timestamp inicio;

	private String item;

	private String observacao;

	private Timestamp proximovencimento;

	private Timestamp termino;

	//bi-directional many-to-one association to Cpessoa
	@ManyToOne
	@JoinColumn(name="funcionarioid")
	private XPessoa pessoa;

	public XPessoaFerias() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDuracao() {
		return this.duracao;
	}

	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}

	public Timestamp getInicio() {
		return this.inicio;
	}

	public void setInicio(Timestamp inicio) {
		this.inicio = inicio;
	}

	public String getItem() {
		return this.item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Timestamp getProximovencimento() {
		return this.proximovencimento;
	}

	public void setProximovencimento(Timestamp proximovencimento) {
		this.proximovencimento = proximovencimento;
	}

	public Timestamp getTermino() {
		return this.termino;
	}

	public void setTermino(Timestamp termino) {
		this.termino = termino;
	}

	public XPessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(XPessoa pessoa) {
		this.pessoa = pessoa;
	}

}