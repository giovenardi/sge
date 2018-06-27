package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the credecliente database table.
 * 
 */
@Entity
@Table(name="credecliente")
public class XRedeCliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String nome;

	//bi-directional many-to-one association to Cpessoa
	@OneToMany(mappedBy="redeCliente")
	private List<XPessoa> pessoas;

	//bi-directional many-to-one association to Credeclientepessoa
	@OneToMany(mappedBy="redeCliente")
	private List<XRedeClientePessoa> redeClientePessoas;

	public XRedeCliente() {
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

	public List<XPessoa> getPessoas() {
		return this.pessoas;
	}

	public void setPessoas(List<XPessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public List<XRedeClientePessoa> getRedeClientePessoas() {
		return this.redeClientePessoas;
	}

	public void setRedeClientePessoas(List<XRedeClientePessoa> redeClientePessoas) {
		this.redeClientePessoas = redeClientePessoas;
	}

}