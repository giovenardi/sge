package br.com.lummi.sge.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The persistent class for the morcamento database table.
 * 
 */
@Entity
@Table(name="orcamento")
public class Orcamento implements Entidade {

	private static final long serialVersionUID = 1989162230577624405L;

	@Id
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}