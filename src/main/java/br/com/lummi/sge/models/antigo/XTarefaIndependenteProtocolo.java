package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the mtarefaindependenteprotocolo database table.
 * 
 */
@Entity
@Table(name="mtarefaindependenteprotocolo")
public class XTarefaIndependenteProtocolo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Timestamp datacadastro;

	private Timestamp datarealizacao;

	private String descricao;

	private Boolean ehrealizado;

	private String tipo;

	//bi-directional many-to-one association to Cusuario
	@ManyToOne
	@JoinColumn(name="usuarioaberturaid")
	private XUsuario usuario1;

	//bi-directional many-to-one association to Cusuario
	@ManyToOne
	@JoinColumn(name="usuariodestinoid")
	private XUsuario usuario2;

	//bi-directional many-to-one association to Mtarefaindependente
	@ManyToOne
	@JoinColumn(name="tarefaindependenteid")
	private XTarefaIndependente tarefaIndependente;

	public XTarefaIndependenteProtocolo() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getDatacadastro() {
		return this.datacadastro;
	}

	public void setDatacadastro(Timestamp datacadastro) {
		this.datacadastro = datacadastro;
	}

	public Timestamp getDatarealizacao() {
		return this.datarealizacao;
	}

	public void setDatarealizacao(Timestamp datarealizacao) {
		this.datarealizacao = datarealizacao;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getEhrealizado() {
		return this.ehrealizado;
	}

	public void setEhrealizado(Boolean ehrealizado) {
		this.ehrealizado = ehrealizado;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public XUsuario getUsuario1() {
		return this.usuario1;
	}

	public void setUsuario(XUsuario usuario1) {
		this.usuario1 = usuario1;
	}

	public XUsuario getUsuario2() {
		return this.usuario2;
	}

	public void setUsuario2(XUsuario usuario2) {
		this.usuario2 = usuario2;
	}

	public XTarefaIndependente getTarefaIndependente() {
		return this.tarefaIndependente;
	}

	public void setTarefaIndependente(XTarefaIndependente tarefaIndependente) {
		this.tarefaIndependente = tarefaIndependente;
	}

}