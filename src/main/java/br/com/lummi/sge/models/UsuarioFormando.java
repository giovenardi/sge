package br.com.lummi.sge.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("FORMANDO")
public class UsuarioFormando extends Usuario {
	
	private static final long serialVersionUID = -3563437807384656591L;
	
	@ManyToOne
	@JoinColumn(name="formando_id")
	private Formando formando;

	public UsuarioFormando() {
	}

	public Formando getFormando() {
		return formando;
	}

	public void setFormando(Formando formando) {
		this.formando = formando;
	}
	
}