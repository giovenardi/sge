package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cassuntoagenda database table.
 * 
 */
@Entity
@Table(name="cassuntoagenda")
public class XAssuntoAgenda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String assunto;

	private String codigo;

	@OneToMany(mappedBy="assuntoAgenda")
	private List<XAgenda> agendas;

	public XAssuntoAgenda() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public List<XAgenda> getAgendas() {
		return agendas;
	}

	public void setAgendas(List<XAgenda> agendas) {
		this.agendas = agendas;
	}

}