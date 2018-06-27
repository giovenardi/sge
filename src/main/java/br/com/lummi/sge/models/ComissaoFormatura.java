package br.com.lummi.sge.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="comissao_formatura")
public class ComissaoFormatura implements Entidade {

	private static final long serialVersionUID = -3812024206880418138L;

	@Id
	private Integer id;
	
	@Column(name="email", length=80)
	private String email;
	
	@OneToMany(mappedBy="comissaoFormatura")
	private List<MembroComissao> membros;
}
