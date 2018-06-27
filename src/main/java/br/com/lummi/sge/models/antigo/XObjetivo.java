package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cobjetivo database table.
 * 
 */
@Entity
@Table(name="cobjetivo")
public class XObjetivo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String nome;

	@OneToMany(mappedBy="objetivo")
	private List<XRecepcionista> recepcionistas;

	@OneToMany(mappedBy="objetivo")
	private List<XRecepcionistaObjetivo> recepcionistaObjetivos;

	@OneToMany(mappedBy="objetivo")
	private List<XCurriculoObjetivo> curriculoObjetivos;

	public XObjetivo() {
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

	public List<XRecepcionista> getRecepcionista() {
		return this.recepcionistas;
	}

	public void setRecepcionista(List<XRecepcionista> recepcionistas) {
		this.recepcionistas = recepcionistas;
	}

	public List<XRecepcionistaObjetivo> getRecepcionistaObjetivos() {
		return this.recepcionistaObjetivos;
	}

	public void setRecepcionistaObjetivos(List<XRecepcionistaObjetivo> recepcionistaObjetivos) {
		this.recepcionistaObjetivos = recepcionistaObjetivos;
	}

}