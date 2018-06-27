package br.com.lummi.sge.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "evento")
public class Evento implements Entidade {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "evento_id_seq", sequenceName = "evento_id_seq", allocationSize = 1)
	@GeneratedValue(generator = "evento_id_seq")
	private Integer id;

	@Column(name = "nome", length = 250)
	private String nome;

	@OneToMany(targetEntity = ProjetoEvento.class, mappedBy = "evento")
	private List<ProjetoEvento> projetos;

	public Evento() {
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

	public List<ProjetoEvento> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<ProjetoEvento> projetos) {
		this.projetos = projetos;
	}

}