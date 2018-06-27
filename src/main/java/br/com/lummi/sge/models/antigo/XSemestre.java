package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the csemestre database table.
 * 
 */
@Entity
@Table(name="csemestre")
public class XSemestre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String nome;

	@OneToMany(mappedBy="semestre")
	private List<XProjetoCurso> projetosCursos;

	public XSemestre() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<XProjetoCurso> getProjetosCursos() {
		return projetosCursos;
	}

	public void setProjetosCursos(List<XProjetoCurso> projetosCursos) {
		this.projetosCursos = projetosCursos;
	}

}