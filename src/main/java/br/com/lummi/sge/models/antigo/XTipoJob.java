package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ctipojob database table.
 * 
 */
@Entity
@Table(name="ctipojob")
public class XTipoJob implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String nome;

	private String orientacao;

	@OneToMany(mappedBy="tipoJob")
	private List<XJob> jobs;

	public XTipoJob() {
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

	public String getOrientacao() {
		return this.orientacao;
	}

	public void setOrientacao(String orientacao) {
		this.orientacao = orientacao;
	}

	public List<XJob> getJobs() {
		return jobs;
	}

	public void setJobs(List<XJob> jobs) {
		this.jobs = jobs;
	}

}