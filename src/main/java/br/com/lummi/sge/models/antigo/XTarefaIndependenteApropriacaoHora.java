package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the mtarefaindependenteapropriacaohoras database table.
 * 
 */
@Entity
@Table(name="mtarefaindependenteapropriacaohoras")
public class XTarefaIndependenteApropriacaoHora implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Timestamp data;

	private Timestamp datahoracadastro;

	private String item;

	private Integer tempominutos;

	//bi-directional many-to-one association to Cusuario
	@ManyToOne
	@JoinColumn(name="usuariocadastroid")
	private XUsuario usuario;

	//bi-directional many-to-one association to Mtarefaindependente
	@ManyToOne
	@JoinColumn(name="tarefaid")
	private XTarefaIndependente tarefaIndependente;

	public XTarefaIndependenteApropriacaoHora() {
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
		return this.usuario;
	}

	public void setUsuario(XUsuario usuario) {
		this.usuario = usuario;
	}

	public XTarefaIndependente getTarefaIndependente() {
		return this.tarefaIndependente;
	}

	public void setTarefaIndependente(XTarefaIndependente tarefaIndependente) {
		this.tarefaIndependente = tarefaIndependente;
	}

}