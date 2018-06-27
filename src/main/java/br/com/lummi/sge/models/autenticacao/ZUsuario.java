package br.com.lummi.sge.models.autenticacao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import br.com.lummi.sge.models.Entidade;

public class ZUsuario implements Entidade {

	private static final long serialVersionUID = -8362845895962100088L;

//	@Id
//	@GeneratedValue(generator="usuarios_id_seq")
//	@SequenceGenerator(name="usuarios_id_seq", sequenceName="global.usuarios_id_seq", allocationSize=1)
	private Integer id;

	private String email;

	private Long identidadedetran;

	@Column(name="login")
	private String nome;

	private String nomecompleto;

	@Transient
	private String matricula;
	
	@Transient
	private String senha;
	
	@Transient
	private String confSenha;
	
	@Transient
	private String token;
	
	@Column(name="ultimoAcesso")
	@Temporal(TemporalType.TIMESTAMP)
	private Date ultimoAcesso;

	@Column(name="cpf")
	private String cpf;

	@Transient
	private String acessoAnterior;
	
	@Transient
	private Map<String, List<String>> permissoes = new HashMap<String, List<String>>();

	@Column(name="modified_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;

	@Column(name="created_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	@Transient
	private String lotacao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getIdentidadedetran() {
		return identidadedetran;
	}

	public void setIdentidadedetran(Long identidadedetran) {
		this.identidadedetran = identidadedetran;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomecompleto() {
		return nomecompleto;
	}

	public void setNomecompleto(String nomecompleto) {
		this.nomecompleto = nomecompleto;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getUltimoAcesso() {
		return ultimoAcesso;
	}

	public void setUltimoAcesso(Date ultimoAcesso) {
		this.ultimoAcesso = ultimoAcesso;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getAcessoAnterior() {
		return acessoAnterior;
	}

	public void setAcessoAnterior(String acessoAnterior) {
		this.acessoAnterior = acessoAnterior;
	}

	public String getLotacao() {
		return lotacao;
	}

	public void setLotacao(String lotacao) {
		this.lotacao = lotacao;
	}
	
	public String getNomeCapitalized(){
		String nomeUsuario = nomecompleto.split(" ")[0].toLowerCase();
		return nomeUsuario.substring(0, 1).toUpperCase() + nomeUsuario.substring(1);
	}
	
	public String getNomeParaRelatorio(){
		return this.cpf + "-" + this.getNomeCapitalized();
	}
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public Map<String, List<String>> getPermissoes() {
		return permissoes;
	}

	public boolean temPermissao(String permissao) {
		String[] elementos = permissao.split("\\|");
		return elementos.length > 2 && getPermissoes().containsKey(elementos[1]) && getPermissoes().get(elementos[1]).contains(permissao);
	}

	public boolean acessaModulo(String modulo) {
		return getPermissoes().containsKey(modulo);
	}

	public void adicionarPermissoes(ArrayList<String> permissoes) {
		for (String permissao : permissoes) {
			adicionarPermissao(permissao);
		}
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

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

}