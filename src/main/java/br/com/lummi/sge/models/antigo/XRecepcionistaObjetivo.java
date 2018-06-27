package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the crecepcionistaobjetivo database table.
 * 
 */
@Entity
@Table(name="crecepcionistaobjetivo")
public class XRecepcionistaObjetivo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	//bi-directional many-to-one association to Cobjetivo
	@ManyToOne
	@JoinColumn(name="objetivoid")
	private XObjetivo objetivo;

	//bi-directional many-to-one association to Crecepcionista
	@ManyToOne
	@JoinColumn(name="recepcionistaid")
	private XRecepcionista recepcionista;

	public XRecepcionistaObjetivo() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public XObjetivo getObjetivo() {
		return this.objetivo;
	}

	public void setObjetivo(XObjetivo objetivo) {
		this.objetivo = objetivo;
	}

	public XRecepcionista getRecepcionista() {
		return this.recepcionista;
	}

	public void setRecepcionista(XRecepcionista recepcionista) {
		this.recepcionista = recepcionista;
	}

}