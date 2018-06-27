package br.com.lummi.sge.models;

import java.math.BigDecimal;

import javax.persistence.Column;
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
@DiscriminatorValue("FORMANDO")
public class ProgramacaoFinanceiraFormando extends ProgramacaoFinanceira {
	
	private static final long serialVersionUID = 3306292652951314817L;

	@ManyToOne(targetEntity=Formando.class)
	@JoinColumn(name="formando_id")
	private Formando formando;
	
	@Column(name="taxa_boleto", precision=2, scale=6)
	private BigDecimal taxaBoleto;

	public Formando getFormando() {
		return formando;
	}

	public void setFormando(Formando formando) {
		this.formando = formando;
	}

	public BigDecimal getTaxaBoleto() {
		return taxaBoleto;
	}

	public void setTaxaBoleto(BigDecimal taxaBoleto) {
		this.taxaBoleto = taxaBoleto;
	}
	
}