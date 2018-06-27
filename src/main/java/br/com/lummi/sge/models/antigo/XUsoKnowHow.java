package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the gusoknowhow database table.
 * 
 */
@Entity
@Table(name="gusoknowhow")
public class XUsoKnowHow implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Timestamp datatravaversao;

	private String versao;

	public XUsoKnowHow() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getDatatravaversao() {
		return this.datatravaversao;
	}

	public void setDatatravaversao(Timestamp datatravaversao) {
		this.datatravaversao = datatravaversao;
	}

	public String getVersao() {
		return this.versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}

}