package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ccriativo database table.
 * 
 */
@Entity
@Table(name="ccriativo")
public class XCriativo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String nome;

	@OneToMany(mappedBy="criativo")
	private List<XBriefing> briefings;

	@OneToMany(mappedBy="criativo2")
	private List<XBriefing> briefings2;

	@OneToMany(mappedBy="criativo")
	private List<XBriefingRecurso> briefingRecursos;

	public XCriativo() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<XBriefing> getBriefings() {
		return briefings;
	}

	public void setBriefings(List<XBriefing> briefings) {
		this.briefings = briefings;
	}

	public List<XBriefing> getBriefings2() {
		return briefings2;
	}

	public void setBriefings2(List<XBriefing> briefings2) {
		this.briefings2 = briefings2;
	}

	public List<XBriefingRecurso> getBriefingRecursos() {
		return briefingRecursos;
	}

	public void setBriefingRecursos(List<XBriefingRecurso> briefingRecursos) {
		this.briefingRecursos = briefingRecursos;
	}

}