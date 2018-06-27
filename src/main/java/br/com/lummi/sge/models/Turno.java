package br.com.lummi.sge.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the cturno database table.
 * 
 */
@Entity
@Table(name="turno")
public class Turno implements Entidade {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="turno_id_seq", sequenceName="turno_id_seq", allocationSize=1)
	@GeneratedValue(generator="turno_id_seq")
	private Integer id;

	private String nome;

	private String sigla;

	public Turno() {
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

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

}