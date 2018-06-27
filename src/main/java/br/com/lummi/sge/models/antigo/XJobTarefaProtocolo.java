package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the mjobtarefaprotocolo database table.
 * 
 */
@Entity
@Table(name="mjobtarefaprotocolo")
public class XJobTarefaProtocolo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Timestamp datacadastro;

	private Timestamp datarealizacao;

	private String descricao;

	private Boolean ehrealizado;

	private String tipo;

	@ManyToOne
	@JoinColumn(name="usuarioaberturaid")
	private XUsuario usuarioAbertura;

	@ManyToOne
	@JoinColumn(name="usuariodestinoid")
	private XUsuario usuarioDestino;

	@ManyToOne
	@JoinColumn(name="tarefaid")
	private XJobTarefa jobTarefa;

	public XJobTarefaProtocolo() {
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

	public XJobTarefa getJobTarefa() {
		return jobTarefa;
	}

	public void setJobTarefa(XJobTarefa jobTarefa) {
		this.jobTarefa = jobTarefa;
	}

}