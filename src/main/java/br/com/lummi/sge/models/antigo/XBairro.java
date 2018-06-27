package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cbairro database table.
 * 
 */
@Entity
@Table(name="cbairro")
public class XBairro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String nome;

	//bi-directional many-to-one association to Clocal
	@OneToMany(mappedBy="bairro")
	private List<XLocal> locais;

	//bi-directional many-to-one association to Cpessoa
	@OneToMany(mappedBy="bairro")
	private List<XPessoa> pessoas1;

	//bi-directional many-to-one association to Cpessoa
	@OneToMany(mappedBy="bairroCobranca")
	private List<XPessoa> pessoas2;

	//bi-directional many-to-one association to Crecepcionista
	@OneToMany(mappedBy="bairro")
	private List<XRecepcionista> recepcionistas;

	//bi-directional many-to-one association to Gcurriculo
	@OneToMany(mappedBy="bairro")
	private List<XCurriculo> curriculos;

	public XBairro() {
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

	public List<XLocal> getLocais() {
		return this.locais;
	}

	public void setLocais(List<XLocal> locais) {
		this.locais = locais;
	}

	public List<XPessoa> getPessoas1() {
		return this.pessoas1;
	}

	public void setPessoas1(List<XPessoa> pessoas1) {
		this.pessoas1 = pessoas1;
	}

	public List<XPessoa> getPessoas2() {
		return this.pessoas2;
	}

	public void setPessoas2(List<XPessoa> pessoas2) {
		this.pessoas2 = pessoas2;
	}

	public List<XRecepcionista> getRecepcionistas() {
		return this.recepcionistas;
	}

	public void setRecepcionistas(List<XRecepcionista> recepcionistas) {
		this.recepcionistas = recepcionistas;
	}

	public List<XCurriculo> getCurriculos() {
		return curriculos;
	}

	public void setCurriculos(List<XCurriculo> curriculos) {
		this.curriculos = curriculos;
	}

}