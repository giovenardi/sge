package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the ctiporeclamacao database table.
 * 
 */
@Entity
@Table(name="cevento")
public class XTipoReclamacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String nome;

	@OneToMany(mappedBy="tipoReclamacao")
	private List<XReclamacao> reclamacoes;

	public XTipoReclamacao() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<XReclamacao> getReclamacoes() {
		return reclamacoes;
	}

	public void setReclamacoes(List<XReclamacao> reclamacoes) {
		this.reclamacoes = reclamacoes;
	}

}