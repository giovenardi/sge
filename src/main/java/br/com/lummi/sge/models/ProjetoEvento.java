package br.com.lummi.sge.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the mprojeto database table.
 * 
 */
@Entity
@Table(name = "projeto_evento")
public class ProjetoEvento implements Entidade {

	private static final long serialVersionUID = 3773459410508856218L;

	@Id
	@SequenceGenerator(name = "projeto_evento_id_seq", sequenceName = "projeto_evento_id_seq", allocationSize = 1)
	@GeneratedValue(generator = "projeto_evento_id_seq")
	private Integer id;

	@Column(name = "inicio")
	@Temporal(TemporalType.TIMESTAMP)
	private Date inicio;

	@Column(name = "fim")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fim;

	@ManyToOne
	@JoinColumn(name = "evento_id")
	private Evento evento;

	@ManyToOne
	@JoinColumn(name = "projeto_id")
	private Projeto projeto;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFim() {
		return fim;
	}

	public void setFim(Date fim) {
		this.fim = fim;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

}