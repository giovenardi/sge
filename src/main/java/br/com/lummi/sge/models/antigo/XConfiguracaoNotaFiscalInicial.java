package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the gconfiguracaonotafiscalinicial database table.
 * 
 */
@Entity
@Table(name="gconfiguracaonotafiscalinicial")
public class XConfiguracaoNotaFiscalInicial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Integer notafiscal;

	public XConfiguracaoNotaFiscalInicial() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNotafiscal() {
		return this.notafiscal;
	}

	public void setNotafiscal(Integer notafiscal) {
		this.notafiscal = notafiscal;
	}

}