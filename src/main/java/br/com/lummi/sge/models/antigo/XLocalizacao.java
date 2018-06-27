package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the clocalizacao database table.
 * 
 */
@Entity
@Table(name="clocalizacao")
public class XLocalizacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String nome;

	@OneToMany(mappedBy="localizacao")
	private List<XProjetoCurso> projetoCursos;

	public XLocalizacao() {
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

	public List<XProjetoCurso> getProjetoCursos() {
		return projetoCursos;
	}

	public void setProjetoCursos(List<XProjetoCurso> projetoCursos) {
		this.projetoCursos = projetoCursos;
	}

}