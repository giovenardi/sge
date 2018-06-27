package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the mjobtarefaapropriacaohoras database table.
 * 
 */
@Entity
@Table(name="mjobtarefaapropriacaohoras")
public class XJobTarefaApropriacaoHora implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Timestamp data;

	private Timestamp datahoracadastro;

	private String item;

	private Integer tempominutos;

	@ManyToOne
	@JoinColumn(name="usuariocadastroid")
	private XUsuario usuario;

	@ManyToOne
	@JoinColumn(name="tarefaid")
	private XJobTarefa jobTarefa;

	public XJobTarefaApropriacaoHora() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getData() {
		return this.data;
	}

	public void setData(Timestamp data) {
		this.data = data;
	}

	public Timestamp getDatahoracadastro() {
		return this.datahoracadastro;
	}

	public void setDatahoracadastro(Timestamp datahoracadastro) {
		this.datahoracadastro = datahoracadastro;
	}

	public String getItem() {
		return this.item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Integer getTempominutos() {
		return this.tempominutos;
	}

	public void setTempominutos(Integer tempominutos) {
		this.tempominutos = tempominutos;
	}

	public XUsuario getUsuario() {
		return usuario;
	}

	public void setUsuario(XUsuario usuario) {
		this.usuario = usuario;
	}

	public XJobTarefa getJobTarefa() {
		return jobTarefa;
	}

	public void setJobTarefa(XJobTarefa jobTarefa) {
		this.jobTarefa = jobTarefa;
	}

}