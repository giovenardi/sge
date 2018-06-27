package br.com.lummi.sge.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * The persistent class for the ccontafinanceira database table.
 * 
 */
@Entity
@Table(name="conta_financeira")
public class ContaFinanceira implements Entidade {

	private static final long serialVersionUID = 176163270848496829L;

	@Id
	private Integer id;

	@Column(name="codigo")
	private String codigo;

	@Column(name="fluxo_caixa")
	private boolean fluxoCaixa;

	@Column(name="nome")
	private String nome;

	@ManyToOne
	@JoinColumn(name="dado_bancario_id")
	private DadosBancarios dadosBancarios;

	public ContaFinanceira() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isFluxoCaixa() {
		return fluxoCaixa;
	}

	public void setFluxoCaixa(boolean fluxoCaixa) {
		this.fluxoCaixa = fluxoCaixa;
	}


}