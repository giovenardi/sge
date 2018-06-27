package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the cturno database table.
 * 
 */
@Entity
@Table(name="cturno")
public class XTurno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String nome;

	@OneToMany(mappedBy="turno")
	private List<XProjetoCurso> projetosCursos;

	public XTurno() {
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