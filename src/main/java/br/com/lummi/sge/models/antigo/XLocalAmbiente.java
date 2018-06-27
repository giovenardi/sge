package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the clocalambiente database table.
 * 
 */
@Entity
@Table(name="clocalambiente")
public class XLocalAmbiente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Integer capacidade;

	private Timestamp datahoraultimaalteracao;

	private String descricaoresumida;

	private String item;

	private String nome;

	//bi-directional many-to-one association to Clocal
	@ManyToOne
	@JoinColumn(name="localid")
	private XLocal local;

	//bi-directional many-to-one association to Cusuario
	@ManyToOne
	@JoinColumn(name="usuarioultimaalteracao")
	private XUsuario usuario;

	public XLocalAmbiente() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCapacidade() {
		return this.capacidade;
	}

	public void setCapacidade(Integer capacidade) {
		this.capacidade = capacidade;
	}

	public Timestamp getDatahoraultimaalteracao() {
		return this.datahoraultimaalteracao;
	}

	public void setDatahoraultimaalteracao(Timestamp datahoraultimaalteracao) {
		this.datahoraultimaalteracao = datahoraultimaalteracao;
	}

	public String getDescricaoresumida() {
		return this.descricaoresumida;
	}

	public void setDescricaoresumida(String descricaoresumida) {
		this.descricaoresumida = descricaoresumida;
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

	public XLocal getLocal() {
		return this.local;
	}

	public void setLocal(XLocal local) {
		this.local = local;
	}

	public XUsuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(XUsuario usuario) {
		this.usuario = usuario;
	}

}