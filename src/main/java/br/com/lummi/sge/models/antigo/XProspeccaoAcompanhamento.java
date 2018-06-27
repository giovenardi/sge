package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the mprospeccaoacompanhamento database table.
 * 
 */
@Entity
@Table(name="mprospeccaoacompanhamento")
public class XProspeccaoAcompanhamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Timestamp datacadastro;

	private Timestamp datahora;

	private String descricao;

	private String item;

	private String responsavel;

	private String tipo;

	@ManyToOne
	@JoinColumn(name="situacaoprospeccaoid")
	private XSituacaoProspeccao situacaoProspeccao;

	@ManyToOne
	@JoinColumn(name="usuariocadastroid")
	private XUsuario usuario;

	@ManyToOne
	@JoinColumn(name="prospeccaoid")
	private XProspeccao prospeccao;

	public XProspeccaoAcompanhamento() {
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

	public String getResponsavel() {
		return this.responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public XSituacaoProspeccao getSituacaoProspeccao() {
		return situacaoProspeccao;
	}

	public void setSituacaoProspeccao(XSituacaoProspeccao situacaoProspeccao) {
		this.situacaoProspeccao = situacaoProspeccao;
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