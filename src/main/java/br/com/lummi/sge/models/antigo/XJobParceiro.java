package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the mjobparceiros database table.
 * 
 */
@Entity
@Table(name="mjobparceiros")
public class XJobParceiro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Timestamp datahoraalteracao;

	private String item;

	private String situacao;

	@ManyToOne
	@JoinColumn(name="usuarioalteracaoid")
	private XUsuario usuarioAlteracao;

	@ManyToOne
	@JoinColumn(name="usuarioparceiroid")
	private XUsuario usuarioParceiro;

	@ManyToOne
	@JoinColumn(name="jobid")
	private XJob job;

	public XJobParceiro() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getDatahoraalteracao() {
		return this.datahoraalteracao;
	}

	public void setDatahoraalteracao(Timestamp datahoraalteracao) {
		this.datahoraalteracao = datahoraalteracao;
	}

	public String getItem() {
		return this.item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getSituacao() {
		return this.situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public XUsuario getUsuarioAlteracao() {
		return usuarioAlteracao;
	}

	public void setUsuarioAlteracao(XUsuario usuarioAlteracao) {
		this.usuarioAlteracao = usuarioAlteracao;
	}

	public XUsuario getUsuarioParceiro() {
		return usuarioParceiro;
	}

	public void setUsuarioParceiro(XUsuario usuarioParceiro) {
		this.usuarioParceiro = usuarioParceiro;
	}

	public XJob getJob() {
		return job;
	}

	public void setJob(XJob job) {
		this.job = job;
	}

}