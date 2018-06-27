package br.com.lummi.sge.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * The persistent class for the cusuario database table.
 * 
 */
@Entity
@Table(name="usuario")
public class Usuario implements Entidade {
	
	private static final long serialVersionUID = -2262901380841528047L;

	@Id
	private Integer id;

	@Column(name="assinatura")
	private byte[] assinatura;

	@Column(name="rubrica")
	private byte[] rubrica;

	@Column(name="login")
	private String login;

	@Column(name="senha")
	private String senha;

	@Transient
	private String confSenha;

	@Column(name="token")
	private String token;

	@ManyToOne
	@JoinColumn(name="funcionario_id")
	private Funcionario funcionario;

	public Usuario() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public byte[] getAssinatura() {
		return assinatura;
	}

	public void setAssinatura(byte[] assinatura) {
		this.assinatura = assinatura;
	}

	public byte[] getRubrica() {
		return rubrica;
	}

	public void setRubrica(byte[] rubrica) {
		this.rubrica = rubrica;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getConfSenha() {
		return confSenha;
	}

	public void setConfSenha(String confSenha) {
		this.confSenha = confSenha;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	
}