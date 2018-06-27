package br.com.lummi.sge.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.lummi.sge.enums.StatusFormandoEnum;


@Entity
@Table(name="formando")
public class Formando implements Entidade {

	private static final long serialVersionUID = -5948931292623572547L;

	@Id
	@SequenceGenerator(name="formando_id_seq", sequenceName="formando_id_seq", allocationSize=1)
	@GeneratedValue(generator="formando_id_seq")
	private Integer id;

	@Column(name="numero_havaiana")
	private String numeroHavaiana;

	@ManyToOne(targetEntity=Pessoa.class, optional=false)
	@JoinColumn(name="pessoa_id")
	private Pessoa pessoa;

	@ManyToOne(targetEntity=Turma.class, optional=false)
	@JoinColumn(name="turma_id")
	private Turma turma;

	@OneToOne(targetEntity=FormaPagamento.class, optional=false)
	@JoinColumn(name="forma_pagamento_id")
	private FormaPagamento formaPagamento;

	@Column(name="sequencial")
	private Integer sequencial;

	@Column(name="status")
	@Enumerated(EnumType.STRING)
	private StatusFormandoEnum status;

	public Formando() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumeroHavaiana() {
		return this.numeroHavaiana;
	}

	public void setNumeroHavaiana(String numeroHavaiana) {
		this.numeroHavaiana = numeroHavaiana;
	}

	public Integer getSequencial() {
		return this.sequencial;
	}

	public void setSequencial(Integer sequencial) {
		this.sequencial = sequencial;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public StatusFormandoEnum getStatus() {
		return status;
	}

	public void setStatus(StatusFormandoEnum status) {
		this.status = status;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

}