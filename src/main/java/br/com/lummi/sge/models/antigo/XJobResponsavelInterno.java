package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the mjobresponsavelinterno database table.
 * 
 */
@Entity
@Table(name="mjobresponsavelinterno")
public class XJobResponsavelInterno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Timestamp datahoraalteracao;

	private String item;

	@ManyToOne
	@JoinColumn(name="usuarioalteracaoid")
	private XUsuario usuarioAlteracao;

	@ManyToOne
	@JoinColumn(name="usuarioid")
	private XUsuario usuario;

	@ManyToOne
	@JoinColumn(name="jobid")
	private XJob job;

	public XJobResponsavelInterno() {
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

	public XUsuario getUsuarioAlteracao() {
		return usuarioAlteracao;
	}

	public void setUsuarioAlteracao(XUsuario usuarioAlteracao) {
		this.usuarioAlteracao = usuarioAlteracao;
	}

	public XUsuario getUsuario() {
		return usuario;
	}

	public void setUsuario(XUsuario usuario) {
		this.usuario = usuario;
	}

	public XJob getJob() {
		return job;
	}

	public void setJob(XJob job) {
		this.job = job;
	}

}