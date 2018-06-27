package br.com.lummi.sge.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the plano_pagamento database table.
 * 
 */
@Entity
@Table(name="plano_pagamento")
public class PlanoPagamento implements Entidade {

	private static final long serialVersionUID = 1457361582231971757L;

	@Id
	@SequenceGenerator(name="plano_pagamento_id_seq", sequenceName="plano_pagamento_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="plano_pagamento_id_seq")
	private Integer id;

	@OneToOne(targetEntity=Projeto.class)
	@JoinColumn(name="projeto_id")
	private Projeto projeto;

	@Column(name="nome", length=100)
	private String nome;

	@Column(name="valor", scale=12, precision=2)
	private Double valor;

	@Column(name="convidados")
	private Integer convidados;

	@Column(name="convites_luxo")
	private Integer convitesLuxo;

	@Column(name="convites_semi_luxo")
	private Integer convitesSemiLuxo;

	@Column(name="convites_simples")
	private Integer convitesSimples;

	@OneToMany(targetEntity=FormaPagamento.class, mappedBy="planoPagamento")
	private List<FormaPagamento> formasPagamento;
	
	public PlanoPagamento() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getConvidados() {
		return convidados;
	}

	public void setConvidados(Integer convidados) {
		this.convidados = convidados;
	}

	public Integer getConvitesLuxo() {
		return convitesLuxo;
	}

	public void setConvitesLuxo(Integer convitesLuxo) {
		this.convitesLuxo = convitesLuxo;
	}

	public Integer getConvitesSemiLuxo() {
		return convitesSemiLuxo;
	}

	public void setConvitesSemiLuxo(Integer convitesSemiLuxo) {
		this.convitesSemiLuxo = convitesSemiLuxo;
	}

	public Integer getConvitesSimples() {
		return convitesSimples;
	}

	public void setConvitesSimples(Integer convitesSimples) {
		this.convitesSimples = convitesSimples;
	}

	public List<FormaPagamento> getFormasPagamento() {
		return formasPagamento;
	}

	public void setFormasPagamento(List<FormaPagamento> formasPagamento) {
		this.formasPagamento = formasPagamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}