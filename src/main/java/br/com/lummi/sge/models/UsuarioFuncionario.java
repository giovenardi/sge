package br.com.lummi.sge.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("FUNCIONARIO")
public class UsuarioFuncionario extends Usuario {
	
	private static final long serialVersionUID = -7192373484872004445L;
	
	@ManyToOne
	@JoinColumn(name="funcionario_id")
	private Funcionario funcionario;

	public UsuarioFuncionario() {
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	
}