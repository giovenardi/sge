package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the mordemservicoitem database table.
 * 
 */
@Entity
@Table(name="mordemservicoitem")
public class XOrdemServicoItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String descricao;

	private Integer diarias;

	private Timestamp entrega;

	private String historico;

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
	@JoinColumn(name="ordemservicoid")
	private XOrdemServico ordemServico;

	public XOrdemServicoItem() {
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

	public String getHistorico() {
		return this.historico;
	}

	public void setHistorico(String historico) {
		this.historico = historico;
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
		return itemOrcamento;
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

	public XOrdemServico getOrdemServico() {
		return ordemServico;
	}

	public void setOrdemServico(XOrdemServico ordemServico) {
		this.ordemServico = ordemServico;
	}

}