package br.com.lummi.sge.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the ccurso database table.
 * 
 */
@Entity
@Table(name="curso")
public class Curso implements Entidade {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="curso_id_seq", sequenceName="curso_id_seq", allocationSize=1)
	@GeneratedValue(generator="curso_id_seq")
	private Integer id;

	private String nome;

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

	public Curso() {
	}

}