package br.com.lummi.sge.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


/**
 * The persistent class for the projeto database table.
 * 
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("FORMATURA_SUPERIOR")
public class ProjetoFormaturaSuperior extends ProjetoFormatura {

	private static final long serialVersionUID = 7277431292006633794L;
	
}