package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mtarefaindependentelinkcomplementar database table.
 * 
 */
@Entity
@Table(name="mtarefaindependentelinkcomplementar")
public class XTarefaIndependenteLinkComplementar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String descricao;

	private String item;

	private String link;

	@ManyToOne
	@JoinColumn(name="tarefaindependenteid")
	private XTarefaIndependente tarefaIndependente;

	public XTarefaIndependenteLinkComplementar() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getItem() {
		return this.item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public XTarefaIndependente getTarefaIndependente() {
		return this.tarefaIndependente;
	}

	public void setTarefaIndependente(XTarefaIndependente tarefaIndependente) {
		this.tarefaIndependente = tarefaIndependente;
	}

}