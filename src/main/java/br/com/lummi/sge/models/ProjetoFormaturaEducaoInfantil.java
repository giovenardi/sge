package br.com.lummi.sge.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("FORMATURA_INFANTIL")
public class ProjetoFormaturaEducaoInfantil extends ProjetoFormatura {

	private static final long serialVersionUID = -1141350542542944927L;

}
