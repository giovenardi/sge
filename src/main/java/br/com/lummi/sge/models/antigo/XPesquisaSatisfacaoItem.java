package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the mpesquisasatisfacaoitem database table.
 * 
 */
@Entity
@Table(name="mpesquisasatisfacaoitem")
public class XPesquisaSatisfacaoItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Boolean ehna;

	private String item;

	private BigDecimal nota;

	@ManyToOne
	@JoinColumn(name="itemfatorsatisfacaoid")
	private XItemFatorDesempenho itemFatorDesempenho;

	@ManyToOne
	@JoinColumn(name="satisfacaoid")
	private XPesquisaSatisfacao pesquisaSatisfacao;

	public XPesquisaSatisfacaoItem() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getEhna() {
		return this.ehna;
	}

	public void setEhna(Boolean ehna) {
		this.ehna = ehna;
	}

	public String getItem() {
		return this.item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public BigDecimal getNota() {
		return this.nota;
	}

	public void setNota(BigDecimal nota) {
		this.nota = nota;
	}

	public XItemFatorDesempenho getItemFatorDesempenho() {
		return itemFatorDesempenho;
	}

	public void setItemFatorDesempenho(XItemFatorDesempenho itemFatorDesempenho) {
		this.itemFatorDesempenho = itemFatorDesempenho;
	}

	public XPesquisaSatisfacao getPesquisaSatisfacao() {
		return pesquisaSatisfacao;
	}

	public void setPesquisaSatisfacao(XPesquisaSatisfacao pesquisaSatisfacao) {
		this.pesquisaSatisfacao = pesquisaSatisfacao;
	}

}