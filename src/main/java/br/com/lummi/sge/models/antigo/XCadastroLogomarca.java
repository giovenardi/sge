package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the gcadastrologomarca database table.
 * 
 */
@Entity
@Table(name="gcadastrologomarca")
public class XCadastroLogomarca implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private byte[] logoprincipal;

	private byte[] logorelatorios;

	public XCadastroLogomarca() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public byte[] getLogoprincipal() {
		return this.logoprincipal;
	}

	public void setLogoprincipal(byte[] logoprincipal) {
		this.logoprincipal = logoprincipal;
	}

	public byte[] getLogorelatorios() {
		return this.logorelatorios;
	}

	public void setLogorelatorios(byte[] logorelatorios) {
		this.logorelatorios = logorelatorios;
	}

}