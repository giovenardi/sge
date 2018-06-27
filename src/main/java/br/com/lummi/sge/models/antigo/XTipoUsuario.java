package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ctipousuario database table.
 * 
 */
@Entity
@Table(name="ctipousuario")
public class XTipoUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Boolean ehacessosite;

	private String nome;

	//bi-directional many-to-one association to Cusuario
	@OneToMany(mappedBy="tipoUsuario1")
	private List<XUsuario> usuarios1;

	//bi-directional many-to-one association to Cusuario
	@OneToMany(mappedBy="tipoUsuario2")
	private List<XUsuario> usuarios2;

	public XTipoUsuario() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getEhacessosite() {
		return this.ehacessosite;
	}

	public void setEhacessosite(Boolean ehacessosite) {
		this.ehacessosite = ehacessosite;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<XUsuario> getUsuarios1() {
		return this.usuarios1;
	}

	public void setUsuarios1(List<XUsuario> usuarios1) {
		this.usuarios1 = usuarios1;
	}

	public List<XUsuario> getCusuarios2() {
		return this.usuarios2;
	}

	public void setUsuarios2(List<XUsuario> usuarios2) {
		this.usuarios2 = usuarios2;
	}

}