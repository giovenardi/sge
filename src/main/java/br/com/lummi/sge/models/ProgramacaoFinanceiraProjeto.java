package br.com.lummi.sge.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


/**
 * The persistent class for the cpessoa database table.
 * 
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("PROJETO")
public class ProgramacaoFinanceiraProjeto extends ProgramacaoFinanceira {
	
	private static final long serialVersionUID = 3306292652951314817L;

	@ManyToOne(targetEntity=Projeto.class)
	@JoinColumn(name="projeto_id")
	private Projeto projeto;
	
	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}
	
}