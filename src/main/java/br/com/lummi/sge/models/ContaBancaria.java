package br.com.lummi.sge.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.lummi.sge.models.antigo.XBanco;
import br.com.lummi.sge.models.antigo.XContaFinanceira;


/**
 * The persistent class for the ccontabancaria database table.
 * 
 */
@Entity
@Table(name="ccontabancaria")
public class ContaBancaria implements Entidade {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String agencia;

	private String codigo;

	private String conta;

	private String quemassina;

	private String titular;

	//bi-directional many-to-one association to Cbanco
	@ManyToOne
	@JoinColumn(name="bancoid")
	private XBanco banco;

	//bi-directional many-to-one association to Ccontafinanceira
	@OneToMany(mappedBy="contaBancaria")
	private List<XContaFinanceira> contasFinanceiras;

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

	public XBanco getBanco() {
		return this.banco;
	}

	public void setBanco(XBanco banco) {
		this.banco = banco;
	}

	public List<XContaFinanceira> getContasFinanceiras() {
		return this.contasFinanceiras;
	}

	public void setContasFinanceiras(List<XContaFinanceira> contasFinanceiras) {
		this.contasFinanceiras = contasFinanceiras;
	}

}