package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the csala database table.
 * 
 */
@Entity
@Table(name="csala")
public class XSala implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Integer capacidade;

	private String nome;

	private Integer ordem;

	private String status;

	private Boolean visivelpainel;

	@OneToMany(mappedBy="sala")
	private List<XAgenda> agendas;

	@OneToMany(mappedBy="sala")
	private List<XAtaReuniao> atasReunioes;

	public XSala() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(Integer capacidade) {
		this.capacidade = capacidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getOrdem() {
		return ordem;
	}

	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Boolean getVisivelpainel() {
		return visivelpainel;
	}

	public void setVisivelpainel(Boolean visivelpainel) {
		this.visivelpainel = visivelpainel;
	}

	public List<XAgenda> getAgendas() {
		return agendas;
	}

	public void setAgendas(List<XAgenda> agendas) {
		this.agendas = agendas;
	}

	public List<XAtaReuniao> getAtasReunioes() {
		return atasReunioes;
	}

	public void setAtasReunioes(List<XAtaReuniao> atasReunioes) {
		this.atasReunioes = atasReunioes;
	}

}