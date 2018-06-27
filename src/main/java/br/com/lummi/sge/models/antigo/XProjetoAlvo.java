package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mprojetoalvo database table.
 * 
 */
@Entity
@Table(name="mprojetoalvo")
public class XProjetoAlvo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String email;

	private Boolean foiimportacao;

	private String item;

	private String nome;

	private String telefone1;

	private String telefone2;

	//bi-directional many-to-one association to Mprojeto
	@ManyToOne
	@JoinColumn(name="projetoid")
	private XProjeto projeto;

	public XProjetoAlvo() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getFoiimportacao() {
		return this.foiimportacao;
	}

	public void setFoiimportacao(Boolean foiimportacao) {
		this.foiimportacao = foiimportacao;
	}

	public String getItem() {
		return this.item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone1() {
		return this.telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return this.telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public XProjeto getProjeto() {
		return projeto;
	}

	public void setProjeto(XProjeto projeto) {
		this.projeto = projeto;
	}

}