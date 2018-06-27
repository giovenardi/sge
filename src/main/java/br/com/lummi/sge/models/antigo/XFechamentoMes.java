package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cfechamentomes database table.
 * 
 */
@Entity
@Table(name="cfechamentomes")
public class XFechamentoMes implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Integer ano;

	private Integer mes;

	public XFechamentoMes() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAno() {
		return this.ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Integer getMes() {
		return this.mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

}