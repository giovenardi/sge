package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mjobnotificacao database table.
 * 
 */
@Entity
@Table(name="mjobnotificacao")
public class XJobNotificacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Boolean ehciente;

	@ManyToOne
	@JoinColumn(name="responsavelid")
	private XUsuario usuario;

	@ManyToOne
	@JoinColumn(name="alteracaoid")
	private XJobHistoricoAlteracao jobHistoricoAlteracao;

	public XJobNotificacao() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getEhciente() {
		return this.ehciente;
	}

	public void setEhciente(Boolean ehciente) {
		this.ehciente = ehciente;
	}

	public XUsuario getUsuario() {
		return usuario;
	}

	public void setUsuario(XUsuario usuario) {
		this.usuario = usuario;
	}

	public XJobHistoricoAlteracao getJobHistoricoAlteracao() {
		return jobHistoricoAlteracao;
	}

	public void setJobHistoricoAlteracao(XJobHistoricoAlteracao jobHistoricoAlteracao) {
		this.jobHistoricoAlteracao = jobHistoricoAlteracao;
	}

}