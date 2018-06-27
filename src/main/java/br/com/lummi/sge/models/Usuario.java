package br.com.lummi.sge.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
@Entity
@Table(name = "usuario")
public class Usuario implements Entidade {

	private static final long serialVersionUID = -2262901380841528047L;

	@Id
	private Integer id;

	@Column(name = "assinatura")
	private byte[] assinatura;

	@Column(name = "rubrica")
	private byte[] rubrica;

	@Column(name = "login")
	private String login;

	@Column(name = "senha")
	private String senha;

	@Transient
	private String confSenha;

	@Column(name = "token")
	private String token;

	@Transient
	private Map<String, List<String>> permissoes;

	public Usuario() {
	}

	public void adicionarPermissao(String permissao) {
		String[] elementos = permissao.split("\\|");
		if (elementos.length > 2) {
			String modulo = elementos[1];
			if (!getPermissoes().containsKey(modulo)) {
				getPermissoes().put(modulo, new ArrayList<String>());
			}
			getPermissoes().get(modulo).add(permissao);
		}
	}

	public boolean temPermissao(String permissao) {
		String[] elementos = permissao.split("\\|");
		return elementos.length > 2 && getPermissoes().containsKey(elementos[1])
				&& getPermissoes().get(elementos[1]).contains(permissao);
	}

	public boolean acessaModulo(String modulo) {
		return getPermissoes().containsKey(modulo);
	}

	public void adicionarPermissoes(List<String> permissoes) {
		for (String permissao : permissoes) {
			adicionarPermissao(permissao);
		}
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

	public Map<String, List<String>> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(Map<String, List<String>> permissoes) {
		this.permissoes = permissoes;
	}

}