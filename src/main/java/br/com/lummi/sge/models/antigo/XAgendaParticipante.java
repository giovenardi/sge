package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the magendaparticipantes database table.
 * 
 */
@Entity
@Table(name="magendaparticipantes")
public class XAgendaParticipante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datahoraalteracao;

	private Boolean ehciente;

	private Boolean ehdono;

	private String item;

	@ManyToOne
	@JoinColumn(name="participanteid")
	private XUsuario participante;

	@ManyToOne
	@JoinColumn(name="usuarioalteracaoid")
	private XUsuario usuarioAlteracao;

	@ManyToOne
	@JoinColumn(name="agendaid")
	private XAgenda agenda;

	public XAgendaParticipante() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDatahoraalteracao() {
		return datahoraalteracao;
	}

	public void setDatahoraalteracao(Date datahoraalteracao) {
		this.datahoraalteracao = datahoraalteracao;
	}

	public Boolean getEhciente() {
		return ehciente;
	}

	public void setEhciente(Boolean ehciente) {
		this.ehciente = ehciente;
	}

	public Boolean getEhdono() {
		return ehdono;
	}

	public void setEhdono(Boolean ehdono) {
		this.ehdono = ehdono;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public XUsuario getParticipante() {
		return participante;
	}

	public void setParticipante(XUsuario participante) {
		this.participante = participante;
	}

	public XUsuario getUsuarioAlteracao() {
		return usuarioAlteracao;
	}

	public void setUsuarioAlteracao(XUsuario usuarioAlteracao) {
		this.usuarioAlteracao = usuarioAlteracao;
	}

	public XAgenda getAgenda() {
		return agenda;
	}

	public void setAgenda(XAgenda agenda) {
		this.agenda = agenda;
	}

}