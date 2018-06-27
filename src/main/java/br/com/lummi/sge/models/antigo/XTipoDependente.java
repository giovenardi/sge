package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ctipodependentes database table.
 * 
 */
@Entity
@Table(name="ctipodependentes")
public class XTipoDependente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String nome;

	//bi-directional many-to-one association to Cpessoadependente
	@OneToMany(mappedBy="tipoDependente")
	private List<XPessoaDependente> pessoasDependentes;

	public XTipoDependente() {
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

	public List<XPessoaDependente> getPessoasDependentes() {
		return this.pessoasDependentes;
	}

	public void setPessoasDependentes(List<XPessoaDependente> pessoasDependentes) {
		this.pessoasDependentes = pessoasDependentes;
	}

}