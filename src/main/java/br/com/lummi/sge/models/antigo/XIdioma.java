package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cidioma database table.
 * 
 */
@Entity
@Table(name="cidioma")
public class XIdioma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String nome;

	@OneToMany(mappedBy="idioma1")
	private List<XRecepcionista> recepcionistas;

	@OneToMany(mappedBy="idioma2")
	private List<XRecepcionista> recepcionistas2;

	@OneToMany(mappedBy="idioma3")
	private List<XRecepcionista> recepcionistas3;

	@OneToMany(mappedBy="idioma")
	private List<XCurriculo> curriculos;

	@OneToMany(mappedBy="idioma2")
	private List<XCurriculo> curriculos2;

	@OneToMany(mappedBy="idioma3")
	private List<XCurriculo> curriculos3;

	public XIdioma() {
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

	public List<XRecepcionista> getRecepcionistas() {
		return recepcionistas;
	}

	public void setRecepcionistas(List<XRecepcionista> recepcionistas) {
		this.recepcionistas = recepcionistas;
	}

	public List<XRecepcionista> getRecepcionistas2() {
		return recepcionistas2;
	}

	public void setRecepcionistas2(List<XRecepcionista> recepcionistas2) {
		this.recepcionistas2 = recepcionistas2;
	}

	public List<XRecepcionista> getRecepcionistas3() {
		return recepcionistas3;
	}

	public void setRecepcionistas3(List<XRecepcionista> recepcionistas3) {
		this.recepcionistas3 = recepcionistas3;
	}

	public List<XCurriculo> getCurriculos() {
		return curriculos;
	}

	public void setCurriculos(List<XCurriculo> curriculos) {
		this.curriculos = curriculos;
	}

	public List<XCurriculo> getCurriculos2() {
		return curriculos2;
	}

	public void setCurriculos2(List<XCurriculo> curriculos2) {
		this.curriculos2 = curriculos2;
	}

	public List<XCurriculo> getCurriculos3() {
		return curriculos3;
	}

	public void setCurriculos3(List<XCurriculo> curriculos3) {
		this.curriculos3 = curriculos3;
	}

}