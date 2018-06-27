package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cpessoacontato database table.
 * 
 */
@Entity
@Table(name="cpessoacontato")
public class XPessoaContato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String email;

	private String nascimentoano;

	private String nascimentodia;

	private String nome;

	private String observacao;

	@Column(name="orkut_facebook")
	private String orkutFacebook;

	private Boolean principal;

	private Integer referenciacontatoid;

	private String sexo;

	private String telcelular;

	private String telcomercial;

	private String telresidencial;

	private String twitter;

	//bi-directional many-to-one association to Ccargo
	@ManyToOne
	@JoinColumn(name="cargoid")
	private XCargo cargo;

	//bi-directional many-to-one association to Cpessoa
	@ManyToOne
	@JoinColumn(name="pessoaid")
	private XPessoa pessoa;

	public XPessoaContato() {
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

	public String getNascimentoano() {
		return this.nascimentoano;
	}

	public void setNascimentoano(String nascimentoano) {
		this.nascimentoano = nascimentoano;
	}

	public String getNascimentodia() {
		return this.nascimentodia;
	}

	public void setNascimentodia(String nascimentodia) {
		this.nascimentodia = nascimentodia;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getOrkutFacebook() {
		return this.orkutFacebook;
	}

	public void setOrkutFacebook(String orkutFacebook) {
		this.orkutFacebook = orkutFacebook;
	}

	public Boolean getPrincipal() {
		return this.principal;
	}

	public void setPrincipal(Boolean principal) {
		this.principal = principal;
	}

	public Integer getReferenciacontatoid() {
		return this.referenciacontatoid;
	}

	public void setReferenciacontatoid(Integer referenciacontatoid) {
		this.referenciacontatoid = referenciacontatoid;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTelcelular() {
		return this.telcelular;
	}

	public void setTelcelular(String telcelular) {
		this.telcelular = telcelular;
	}

	public String getTelcomercial() {
		return this.telcomercial;
	}

	public void setTelcomercial(String telcomercial) {
		this.telcomercial = telcomercial;
	}

	public String getTelresidencial() {
		return this.telresidencial;
	}

	public void setTelresidencial(String telresidencial) {
		this.telresidencial = telresidencial;
	}

	public String getTwitter() {
		return this.twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public XCargo getCargo() {
		return this.cargo;
	}

	public void setCargo(XCargo cargo) {
		this.cargo = cargo;
	}

	public XPessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(XPessoa pessoa) {
		this.pessoa = pessoa;
	}

}