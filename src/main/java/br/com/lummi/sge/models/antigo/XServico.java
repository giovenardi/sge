package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cservico database table.
 * 
 */
@Entity
@Table(name="cservico")
public class XServico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String nome;

	public XServico() {
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