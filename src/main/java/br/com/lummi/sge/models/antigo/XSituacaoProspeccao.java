package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the csituacaoprospeccao database table.
 * 
 */
@Entity
@Table(name="csituacaoprospeccao")
public class XSituacaoProspeccao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String nome;

	@OneToMany(mappedBy="situacaoProspeccao")
	private List<XProspeccaoAcompanhamento> prospeccaoAcompanhamentos;

	public XSituacaoProspeccao() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<XProspeccaoAcompanhamento> getProspeccaoAcompanhamentos() {
		return prospeccaoAcompanhamentos;
	}

	public void setProspeccaoAcompanhamentos(List<XProspeccaoAcompanhamento> prospeccaoAcompanhamentos) {
		this.prospeccaoAcompanhamentos = prospeccaoAcompanhamentos;
	}

}