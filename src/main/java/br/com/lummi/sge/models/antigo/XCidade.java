package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the ccidade database table.
 * 
 */
@Entity
@Table(name="ccidade")
public class XCidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String estado;

	private String nome;

	@OneToMany(mappedBy="cidade")
	private List<XEmpresa> empresas;

	@OneToMany(mappedBy="cidade")
	private List<XLocal> locais;

	@OneToMany(mappedBy="cidade")
	private List<XPessoa> pessoas1;

	@OneToMany(mappedBy="cidadeCobranca")
	private List<XPessoa> pessoas2;

	@OneToMany(mappedBy="cidade")
	private List<XRecepcionista> recepcionistas;

	@OneToMany(mappedBy="cidade")
	private List<XCurriculo> gcurriculos;

	@OneToMany(mappedBy="cidadeSede")
	private List<XSistema> sistemas;

	@OneToMany(mappedBy="cidade")
	private List<XProspeccao> prospeccoes;

	public XCidade() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<XEmpresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<XEmpresa> empresas) {
		this.empresas = empresas;
	}

	public List<XLocal> getLocais() {
		return locais;
	}

	public void setLocais(List<XLocal> locais) {
		this.locais = locais;
	}

	public List<XPessoa> getPessoas1() {
		return pessoas1;
	}

	public void setPessoas1(List<XPessoa> pessoas1) {
		this.pessoas1 = pessoas1;
	}

	public List<XPessoa> getPessoas2() {
		return pessoas2;
	}

	public void setPessoas2(List<XPessoa> pessoas2) {
		this.pessoas2 = pessoas2;
	}

	public List<XRecepcionista> getRecepcionistas() {
		return recepcionistas;
	}

	public void setRecepcionistas(List<XRecepcionista> recepcionistas) {
		this.recepcionistas = recepcionistas;
	}

	public List<XCurriculo> getGcurriculos() {
		return gcurriculos;
	}

	public void setGcurriculos(List<XCurriculo> gcurriculos) {
		this.gcurriculos = gcurriculos;
	}

	public List<XSistema> getSistemas() {
		return sistemas;
	}

	public void setSistemas(List<XSistema> sistemas) {
		this.sistemas = sistemas;
	}

	public List<XProspeccao> getProspeccoes() {
		return prospeccoes;
	}

	public void setProspeccoes(List<XProspeccao> prospeccoes) {
		this.prospeccoes = prospeccoes;
	}

}