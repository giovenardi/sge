package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cevento database table.
 * 
 */
@Entity
@Table(name="cevento")
public class XEvento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String nome;

	@OneToMany(mappedBy="evento")
	private List<XProjetoEvento> projetosEventos;

	public XEvento() {
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

	public List<XProjetoEvento> getProjetosEventos() {
		return projetosEventos;
	}

	public void setProjetosEventos(List<XProjetoEvento> projetosEventos) {
		this.projetosEventos = projetosEventos;
	}

}