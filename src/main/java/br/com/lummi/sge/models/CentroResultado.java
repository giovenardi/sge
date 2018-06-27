package br.com.lummi.sge.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The persistent class for the ccentroresultado database table.
 * 
 */
@Entity
@Table(name="centro_resultado")
public class CentroResultado implements Entidade {

	private static final long serialVersionUID = 9045425383044912213L;

	@Id
	private Integer id;

	private String codigo;

	private String nome;

	public CentroResultado() {
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	
}