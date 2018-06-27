package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the cpessoadependentes database table.
 * 
 */
@Entity
@Table(name="cpessoadependentes")
public class XPessoaDependente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Timestamp dataalteracao;

	private Timestamp datanascimento;

	private String item;

	private String nome;

	//bi-directional many-to-one association to Cpessoa
	@ManyToOne
	@JoinColumn(name="funcionarioid")
	private XPessoa pessoa;

	//bi-directional many-to-one association to Ctipodependente
	@ManyToOne
	@JoinColumn(name="tipoid")
	private XTipoDependente tipoDependente;

	//bi-directional many-to-one association to Cusuario
	@ManyToOne
	@JoinColumn(name="usuarioalteracaoid")
	private XUsuario usuario;

	public XPessoaDependente() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getDataalteracao() {
		return this.dataalteracao;
	}

	public void setDataalteracao(Timestamp dataalteracao) {
		this.dataalteracao = dataalteracao;
	}

	public Timestamp getDatanascimento() {
		return this.datanascimento;
	}

	public void setDatanascimento(Timestamp datanascimento) {
		this.datanascimento = datanascimento;
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

	public XPessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(XPessoa pessoa) {
		this.pessoa = pessoa;
	}

	public XTipoDependente getTipoDependente() {
		return this.tipoDependente;
	}

	public void setTipoDependente(XTipoDependente tipoDependente) {
		this.tipoDependente = tipoDependente;
	}

	public XUsuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(XUsuario usuario) {
		this.usuario = usuario;
	}

}