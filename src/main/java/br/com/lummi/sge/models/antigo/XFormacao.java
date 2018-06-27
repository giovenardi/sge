package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cformacao database table.
 * 
 */
@Entity
@Table(name="cformacao")
public class XFormacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String titulo;

	@OneToMany(mappedBy="formacao")
	private List<XRecepcionista> recepcionistas;

	public XFormacao() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<XRecepcionista> getRecepcionistas() {
		return recepcionistas;
	}

	public void setRecepcionistas(List<XRecepcionista> recepcionistas) {
		this.recepcionistas = recepcionistas;
	}

}