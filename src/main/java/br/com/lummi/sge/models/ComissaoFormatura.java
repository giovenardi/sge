package br.com.lummi.sge.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "comissao_formatura")
public class ComissaoFormatura implements Entidade {

	private static final long serialVersionUID = -3812024206880418138L;

	@Id
	@SequenceGenerator(name = "comissao_formatura_id_seq",
			sequenceName = "comissao_formatura_id_seq",
			allocationSize = 1)
	@GeneratedValue(generator = "comissao_formatura_id_seq")
	private Integer id;

	@Column(name = "email", length = 80)
	private String email;

	@OneToMany(mappedBy = "comissaoFormatura")
	private List<MembroComissao> membros;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<MembroComissao> getMembros() {
		return membros;
	}

	public void setMembros(List<MembroComissao> membros) {
		this.membros = membros;
	}
}
