package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the husuariooperacao database table.
 * 
 */
@Entity
@Table(name="husuariooperacao")
public class XUsuarioOperacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Timestamp dataref;

	private String operacao;

	//bi-directional many-to-one association to Cusuario
	@ManyToOne
	@JoinColumn(name="usuarioid")
	private XUsuario usuario;

	public XUsuarioOperacao() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getDataref() {
		return this.dataref;
	}

	public void setDataref(Timestamp dataref) {
		this.dataref = dataref;
	}

	public String getOperacao() {
		return this.operacao;
	}

	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}

	public XUsuario getUsuario() {
		return usuario;
	}

	public void setUsuario(XUsuario usuario) {
		this.usuario = usuario;
	}

}