package br.com.lummi.sge.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The persistent class for the cfuncaocomissaoformatura database table.
 * 
 */
@Entity
@Table(name="funcao_comissao")
public class FuncaoComissao implements Entidade {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String nome;

	public FuncaoComissao() {
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