package br.com.lummi.sge.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the cformacaptacao database table.
 * 
 */
@Entity
@Table(name="forma_captacao")
public class FormaCaptacao implements Entidade {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="forma_captacao_id_seq", sequenceName="forma_captacao_id_seq", allocationSize=1)
	@GeneratedValue(generator="forma_captacao_id_seq")
	private Integer id;

	private String nome;

	public FormaCaptacao() {
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

}