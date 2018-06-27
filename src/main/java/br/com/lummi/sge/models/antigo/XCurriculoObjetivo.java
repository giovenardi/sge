package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the gcurriculoobjetivo database table.
 * 
 */
@Entity
@Table(name="gcurriculoobjetivo")
public class XCurriculoObjetivo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@ManyToOne
	@JoinColumn(name="objetivoid")
	private XObjetivo objetivo;

	@ManyToOne
	@JoinColumn(name="curriculoid")
	private XCurriculo curriculo;

	public XCurriculoObjetivo() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public XObjetivo getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(XObjetivo objetivo) {
		this.objetivo = objetivo;
	}

	public XCurriculo getCurriculo() {
		return curriculo;
	}

	public void setCurriculo(XCurriculo curriculo) {
		this.curriculo = curriculo;
	}

}