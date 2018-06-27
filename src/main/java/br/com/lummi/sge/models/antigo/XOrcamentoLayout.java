package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the morcamentolayout database table.
 * 
 */
@Entity
@Table(name="morcamentolayout")
public class XOrcamentoLayout implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String acabamento;

	private String cores;

	@Column(name="formato_ab")
	private String formatoAb;

	@Column(name="formato_fe")
	private String formatoFe;

	private Integer peca;

	private BigDecimal quantidade;

	@ManyToOne
	@JoinColumn(name="orcamentoid")
	private XOrcamento orcamento;

	public XOrcamentoLayout() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAcabamento() {
		return this.acabamento;
	}

	public void setAcabamento(String acabamento) {
		this.acabamento = acabamento;
	}

	public String getCores() {
		return this.cores;
	}

	public void setCores(String cores) {
		this.cores = cores;
	}

	public String getFormatoAb() {
		return this.formatoAb;
	}

	public void setFormatoAb(String formatoAb) {
		this.formatoAb = formatoAb;
	}

	public String getFormatoFe() {
		return this.formatoFe;
	}

	public void setFormatoFe(String formatoFe) {
		this.formatoFe = formatoFe;
	}

	public Integer getPeca() {
		return this.peca;
	}

	public void setPeca(Integer peca) {
		this.peca = peca;
	}

	public BigDecimal getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	public XOrcamento getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(XOrcamento orcamento) {
		this.orcamento = orcamento;
	}

}