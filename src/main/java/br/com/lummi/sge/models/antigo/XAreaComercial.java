package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the careacomercial database table.
 * 
 */
@Entity
@Table(name="careacomercial")
public class XAreaComercial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String nome;

	//bi-directional many-to-one association to Morcamento
	@OneToMany(mappedBy="areaComercial")
	private List<XOrcamento> orcamentos;

	public XAreaComercial() {
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

	public List<XOrcamento> getOrcamentos() {
		return this.orcamentos;
	}

	public void setOrcamentos(List<XOrcamento> orcamentos) {
		this.orcamentos = orcamentos;
	}

}