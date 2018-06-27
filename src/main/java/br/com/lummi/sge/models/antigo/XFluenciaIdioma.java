package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cfluenciaidioma database table.
 * 
 */
@Entity
@Table(name="cfluenciaidioma")
public class XFluenciaIdioma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String nome;

	//bi-directional many-to-one association to Crecepcionista
	@OneToMany(mappedBy="fluenciaIdioma1")
	private List<XRecepcionista> recepcionistas1;

	//bi-directional many-to-one association to Crecepcionista
	@OneToMany(mappedBy="fluenciaIdioma2")
	private List<XRecepcionista> recepcionistas2;

	//bi-directional many-to-one association to Crecepcionista
	@OneToMany(mappedBy="fluenciaIdioma3")
	private List<XRecepcionista> recepcionistas3;

	//bi-directional many-to-one association to Gcurriculo
	@OneToMany(mappedBy="fluenciaIdioma")
	private List<XCurriculo> curriculos;

	//bi-directional many-to-one association to Gcurriculo
	@OneToMany(mappedBy="fluenciaIdioma2")
	private List<XCurriculo> curriculos2;

	//bi-directional many-to-one association to Gcurriculo
	@OneToMany(mappedBy="fluenciaIdioma3")
	private List<XCurriculo> curriculos3;

	public XFluenciaIdioma() {
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

	public List<XRecepcionista> getRecepcionistas1() {
		return this.recepcionistas1;
	}

	public void setRecepcionistas1(List<XRecepcionista> recepcionistas1) {
		this.recepcionistas1 = recepcionistas1;
	}

	public List<XRecepcionista> getRecepcionistas2() {
		return this.recepcionistas2;
	}

	public void setRecepcionistas2(List<XRecepcionista> recepcionistas2) {
		this.recepcionistas2 = recepcionistas2;
	}

	public List<XRecepcionista> getRecepcionistas3() {
		return this.recepcionistas3;
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