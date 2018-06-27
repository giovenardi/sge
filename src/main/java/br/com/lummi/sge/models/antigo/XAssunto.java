package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cassunto database table.
 * 
 */
@Entity
@Table(name="cassunto")
public class XAssunto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String nome;

	@OneToMany(mappedBy="assunto")
	private List<XAtaReuniao> atasReunioes;

	public XAssunto() {
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

	public List<XAtaReuniao> getAtasReunioes() {
		return atasReunioes;
	}

	public void setAtasReunioes(List<XAtaReuniao> atasReunioes) {
		this.atasReunioes = atasReunioes;
	}

}