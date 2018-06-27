package br.com.lummi.sge.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the ccargo database table.
 * 
 */
@Entity
@Table(name="setor")
public class Setor implements Entidade {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="setor_id_seq", sequenceName="setor_id_seq", allocationSize=1)
	@GeneratedValue(generator="setor_id_seq")
	private Integer id;

	@Column(name="nome", length=50)
	private String nome;

	@Column(name="sigla", length=10)
	private String sigla;

	public Setor() {
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

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

}