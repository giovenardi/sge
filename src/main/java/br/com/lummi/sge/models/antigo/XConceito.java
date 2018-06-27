package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the cconceito database table.
 * 
 */
@Entity
@Table(name="cconceito")
public class XConceito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String nome;

	private BigDecimal nota;

	private String tratamento;

	@OneToMany(mappedBy="conceito")
	private List<XPessoa> pessoas;

	@OneToMany(mappedBy="conceito")
	private List<XPessoaConceito> pessoaConceitos;

	@OneToMany(mappedBy="conceito")
	private List<XGerenciamentoPerformance> gerenciamentoPerformances;

	public XConceito() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getNota() {
		return this.nota;
	}

	public void setNota(BigDecimal nota) {
		this.nota = nota;
	}

	public String getTratamento() {
		return this.tratamento;
	}

	public void setTratamento(String tratamento) {
		this.tratamento = tratamento;
	}

	public List<XPessoa> getPessoas() {
		return this.pessoas;
	}

	public void setPessoas(List<XPessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public List<XPessoaConceito> getPessoaConceitos() {
		return this.pessoaConceitos;
	}

	public void setPessoaConceitos(List<XPessoaConceito> pessoaConceitos) {
		this.pessoaConceitos = pessoaConceitos;
	}

	public List<XGerenciamentoPerformance> getGerenciamentoPerformances() {
		return gerenciamentoPerformances;
	}

	public void setGerenciamentoPerformances(List<XGerenciamentoPerformance> gerenciamentoPerformances) {
		this.gerenciamentoPerformances = gerenciamentoPerformances;
	}

}