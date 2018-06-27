package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the gorcamentolancamentoavulsoprogramacao database table.
 * 
 */
@Entity
@Table(name="gorcamentolancamentoavulsoprogramacao")
public class XOrcamentoLancamentoAvulsoProgramacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Timestamp data;

	private Boolean notafiscal;

	private String observacao;

	private Integer parcela;

	private Integer usuarioid;

	private BigDecimal valor;

	@ManyToOne
	@JoinColumn(name="orcamentoid")
	private XOrcamento orcamento;

	public XOrcamentoLancamentoAvulsoProgramacao() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getData() {
		return this.data;
	}

	public void setData(Timestamp data) {
		this.data = data;
	}

	public Boolean getNotafiscal() {
		return this.notafiscal;
	}

	public void setNotafiscal(Boolean notafiscal) {
		this.notafiscal = notafiscal;
	}

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Integer getParcela() {
		return this.parcela;
	}

	public void setParcela(Integer parcela) {
		this.parcela = parcela;
	}

	public Integer getUsuarioid() {
		return this.usuarioid;
	}

	public void setUsuarioid(Integer usuarioid) {
		this.usuarioid = usuarioid;
	}

	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public XOrcamento getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(XOrcamento orcamento) {
		this.orcamento = orcamento;
	}

}