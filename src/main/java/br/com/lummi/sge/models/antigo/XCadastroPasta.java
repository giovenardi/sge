package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the gcadastropasta database table.
 * 
 */
@Entity
@Table(name="gcadastropasta")
public class XCadastroPasta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String enderecopasta;

	public XCadastroPasta() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEnderecopasta() {
		return this.enderecopasta;
	}

	public void setEnderecopasta(String enderecopasta) {
		this.enderecopasta = enderecopasta;
	}

}