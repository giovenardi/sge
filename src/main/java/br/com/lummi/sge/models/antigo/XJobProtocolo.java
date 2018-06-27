package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the mjobprotocolo database table.
 * 
 */
@Entity
@Table(name="mjobprotocolo")
public class XJobProtocolo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Timestamp datacadastro;

	private Timestamp datarealizacao;

	private String descricao;

	private Boolean ehrealizado;

	private Integer jobid;

	@ManyToOne
	@JoinColumn(name="usuarioaberturaid")
	private XUsuario usuarioAbertura;

	@ManyToOne
	@JoinColumn(name="usuariodestinoid")
	private XUsuario usuarioDestino;

	public XJobProtocolo() {
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

	public Integer getJobid() {
		return this.jobid;
	}

	public void setJobid(Integer jobid) {
		this.jobid = jobid;
	}

	public XUsuario getUsuarioAbertura() {
		return usuarioAbertura;
	}

	public void setUsuarioAbertura(XUsuario usuarioAbertura) {
		this.usuarioAbertura = usuarioAbertura;
	}

	public XUsuario getUsuarioDestino() {
		return usuarioDestino;
	}

	public void setUsuarioDestino(XUsuario usuarioDestino) {
		this.usuarioDestino = usuarioDestino;
	}

}