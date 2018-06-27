package br.com.lummi.sge.models;

import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * The persistent class for the ccontabancaria database table.
 * 
 */
public class ContaBancaria implements Entidade {
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String agencia;

	private String codigo;

	private String conta;

	private String quemassina;

	private String titular;

	// bi-directional many-to-one association to Cbanco
	@ManyToOne
	@JoinColumn(name = "bancoid")
	private Banco banco;

	// bi-directional many-to-one association to Ccontafinanceira
	@OneToMany(mappedBy = "contaBancaria")
	private List<ContaFinanceira> contasFinanceiras;

	public ContaBancaria() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAgencia() {
		return this.agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getConta() {
		return this.conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public String getQuemassina() {
		return this.quemassina;
	}

	public void setQuemassina(String quemassina) {
		this.quemassina = quemassina;
	}

	public String getTitular() {
		return this.titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Banco getBanco() {
		return this.banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public List<ContaFinanceira> getContasFinanceiras() {
		return this.contasFinanceiras;
	}

	public void setContasFinanceiras(List<ContaFinanceira> contasFinanceiras) {
		this.contasFinanceiras = contasFinanceiras;
	}

}