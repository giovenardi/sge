package br.com.lummi.sge.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("FORMATURA_MEDIO")
public class ProjetoFormaturaMedio extends ProjetoFormatura {

	private static final long serialVersionUID = -8694559803381792395L;

}
