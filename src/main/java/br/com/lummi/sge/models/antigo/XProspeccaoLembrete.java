package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the mprospeccaolembrete database table.
 * 
 */
@Entity
@Table(name="mprospeccaolembrete")
public class XProspeccaoLembrete implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Boolean ciente;

	private Timestamp data;

	private Timestamp datahora;

	private String descricao;

	private String item;

	private String titulo;

	@ManyToOne
	@JoinColumn(name="usuarioid")
	private XUsuario usuario;

	@ManyToOne
	@JoinColumn(name="prospeccaoid")
	private XProspeccao prospeccao;

	public XProspeccaoLembrete() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getCiente() {
		return this.ciente;
	}

	public void setCiente(Boolean ciente) {
		this.ciente = ciente;
	}

	public Timestamp getData() {
		return this.data;
	}

	public void setData(Timestamp data) {
		this.data = data;
	}

	public Timestamp getDatahora() {
		return this.datahora;
	}

	public void setDatahora(Timestamp datahora) {
		this.datahora = datahora;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getItem() {
		return this.item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public XUsuario getUsuario() {
		return usuario;
	}

	public void setUsuario(XUsuario usuario) {
		this.usuario = usuario;
	}

	public XProspeccao getProspeccao() {
		return prospeccao;
	}

	public void setProspeccao(XProspeccao prospeccao) {
		this.prospeccao = prospeccao;
	}

}