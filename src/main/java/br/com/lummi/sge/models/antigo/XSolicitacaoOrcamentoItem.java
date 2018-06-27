package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the msolicitacaoorcamentoitem database table.
 * 
 */
@Entity
@Table(name="msolicitacaoorcamentoitem")
public class XSolicitacaoOrcamentoItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String descricao;

	private Integer diarias;

	private Timestamp entrega;

	private BigDecimal quantidade;

	private BigDecimal valortotal;

	private BigDecimal valorunitario;

	@ManyToOne
	@JoinColumn(name="itemorcamentoid")
	private XItemOrcamento itemOrcamento;

	@ManyToOne
	@JoinColumn(name="orcamentoitemid")
	private XOrcamentoItem orcamentoItem;

	@ManyToOne
	@JoinColumn(name="solicitacaoorcamentoid")
	private XSolicitacaoOrcamento solicitacaoOrcamento;

	public XSolicitacaoOrcamentoItem() {
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

	public Integer getDiarias() {
		return this.diarias;
	}

	public void setDiarias(Integer diarias) {
		this.diarias = diarias;
	}

	public Timestamp getEntrega() {
		return this.entrega;
	}

	public void setEntrega(Timestamp entrega) {
		this.entrega = entrega;
	}

	public BigDecimal getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValortotal() {
		return this.valortotal;
	}

	public void setValortotal(BigDecimal valortotal) {
		this.valortotal = valortotal;
	}

	public BigDecimal getValorunitario() {
		return this.valorunitario;
	}

	public void setValorunitario(BigDecimal valorunitario) {
		this.valorunitario = valorunitario;
	}

	public XItemOrcamento getItemOrcamento() {
		return this.itemOrcamento;
	}

	public void setItemOrcamento(XItemOrcamento itemOrcamento) {
		this.itemOrcamento = itemOrcamento;
	}

	public XOrcamentoItem getOrcamentoItem() {
		return orcamentoItem;
	}

	public void setOrcamentoItem(XOrcamentoItem orcamentoItem) {
		this.orcamentoItem = orcamentoItem;
	}

	public XSolicitacaoOrcamento getSolicitacaoOrcamento() {
		return this.solicitacaoOrcamento;
	}

	public void setSolicitacaoOrcamento(XSolicitacaoOrcamento solicitacaoOrcamento) {
		this.solicitacaoOrcamento = solicitacaoOrcamento;
	}

}