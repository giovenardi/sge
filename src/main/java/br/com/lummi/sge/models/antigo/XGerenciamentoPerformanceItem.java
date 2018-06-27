package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the mgerenciamentoperformanceitem database table.
 * 
 */
@Entity
@Table(name="mgerenciamentoperformanceitem")
public class XGerenciamentoPerformanceItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Boolean ehna;

	private String item;

	private String justificativa;

	private BigDecimal nota;

	@ManyToOne
	@JoinColumn(name="itemgerenciamentoperformanceid")
	private XItemGerenciamentoPerformance gerenciamentoPerformance;

	@ManyToOne
	@JoinColumn(name="gerenciamentoperformanceid")
	private XGerenciamentoPerformance gerenciamentoPerformance2;

	public XGerenciamentoPerformanceItem() {
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

	public String getJustificativa() {
		return this.justificativa;
	}

	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}

	public BigDecimal getNota() {
		return this.nota;
	}

	public void setNota(BigDecimal nota) {
		this.nota = nota;
	}

	public XItemGerenciamentoPerformance getGerenciamentoPerformance() {
		return gerenciamentoPerformance;
	}

	public void setGerenciamentoPerformance(XItemGerenciamentoPerformance gerenciamentoPerformance) {
		this.gerenciamentoPerformance = gerenciamentoPerformance;
	}

	public XGerenciamentoPerformance getGerenciamentoPerformance2() {
		return gerenciamentoPerformance2;
	}

	public void setGerenciamentoPerformance2(XGerenciamentoPerformance gerenciamentoPerformance2) {
		this.gerenciamentoPerformance2 = gerenciamentoPerformance2;
	}


}