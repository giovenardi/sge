package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cproduto database table.
 * 
 */
@Entity
@Table(name="cproduto")
public class XProduto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String nome;

	//bi-directional many-to-one association to Morcamento
	@OneToMany(mappedBy="produto")
	private List<XOrcamento> orcamentos;

	public XProduto() {
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