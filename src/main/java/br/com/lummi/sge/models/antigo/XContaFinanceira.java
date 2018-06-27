package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;

import br.com.lummi.sge.models.ContaBancaria;

import java.util.List;


/**
 * The persistent class for the ccontafinanceira database table.
 * 
 */
@Entity
@Table(name="Ccontafinanceira")
public class XContaFinanceira implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String codigo;

	private Boolean ehfluxocaixa;

	private String nome;

	private String tipo;

	@ManyToOne
	@JoinColumn(name="contabancariaid")
	private ContaBancaria contaBancaria;

	@OneToMany(mappedBy="contaFinanceira")
	private List<XCheque> cheques;

	@OneToMany(mappedBy="contaFinanceira")
	private List<XContaCorrenteFinanceira> contasCorrenteFinanceiras;

	@OneToMany(mappedBy="contaFinanceira")
	private List<XProjeto> projetos;

	@OneToMany(mappedBy="contaFinanceiraRecursosCerimonial")
	private List<XProjeto> projetosRecursosCerimonial;

	public XContaFinanceira() {
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

	public Boolean getEhfluxocaixa() {
		return ehfluxocaixa;
	}

	public void setEhfluxocaixa(Boolean ehfluxocaixa) {
		this.ehfluxocaixa = ehfluxocaixa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public ContaBancaria getContaBancaria() {
		return contaBancaria;
	}

	public void setContaBancaria(ContaBancaria contaBancaria) {
		this.contaBancaria = contaBancaria;
	}

	public List<XCheque> getCheques() {
		return cheques;
	}

	public void setCheques(List<XCheque> cheques) {
		this.cheques = cheques;
	}

	public List<XContaCorrenteFinanceira> getContasCorrenteFinanceiras() {
		return contasCorrenteFinanceiras;
	}

	public void setContasCorrenteFinanceiras(List<XContaCorrenteFinanceira> contasCorrenteFinanceiras) {
		this.contasCorrenteFinanceiras = contasCorrenteFinanceiras;
	}

	public List<XProjeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<XProjeto> projetos) {
		this.projetos = projetos;
	}

	public List<XProjeto> getProjetosRecursosCerimonial() {
		return projetosRecursosCerimonial;
	}

	public void setProjetosRecursosCerimonial(List<XProjeto> projetosRecursosCerimonial) {
		this.projetosRecursosCerimonial = projetosRecursosCerimonial;
	}


}