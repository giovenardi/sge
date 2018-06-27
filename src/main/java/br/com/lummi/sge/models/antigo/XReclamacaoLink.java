package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mreclamacaolink database table.
 * 
 */
@Entity
@Table(name="mreclamacaolink")
public class XReclamacaoLink implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String item;

	private String link;

	private String titulo;

	//bi-directional many-to-one association to Mreclamacao
	@ManyToOne
	@JoinColumn(name="reclamacaoid")
	private XReclamacao reclamacao;

	public XReclamacaoLink() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public XReclamacao getReclamacao() {
		return this.reclamacao;
	}

	public void setReclamacao(XReclamacao reclamacao) {
		this.reclamacao = reclamacao;
	}

}