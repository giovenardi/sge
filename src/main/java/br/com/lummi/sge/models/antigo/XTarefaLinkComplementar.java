package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mtarefalinkcomplementar database table.
 * 
 */
@Entity
@Table(name="mtarefalinkcomplementar")
public class XTarefaLinkComplementar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String descricao;

	private String item;

	private String link;

	//bi-directional many-to-one association to Mjobtarefa
	@ManyToOne
	@JoinColumn(name="jobtarefaid")
	private XJobTarefa jobTarefa;

	public XTarefaLinkComplementar() {
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

	public XJobTarefa getJobTarefa() {
		return this.jobTarefa;
	}

	public void setMjobtarefa(XJobTarefa jobTarefa) {
		this.jobTarefa = jobTarefa;
	}

}