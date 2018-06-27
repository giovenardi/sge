package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the morcamentoprevisaoreceita database table.
 * 
 */
@Entity
@Table(name="morcamentoprevisaoreceita")
public class XOrcamentoPrevisaoReceita implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private BigDecimal diarias;

	private String item;

	private BigDecimal quantidade;

	private BigDecimal valortotal;

	private BigDecimal valorunitario;

	//bi-directional many-to-one association to Ccentrocusto
	@ManyToOne
	@JoinColumn(name="centrocustoid")
	private XCentroCusto centroCusto;

	//bi-directional many-to-one association to Citemorcamento
	@ManyToOne
	@JoinColumn(name="itemorcamentoid")
	private XItemOrcamento itemOrcamento;

	//bi-directional many-to-one association to Morcamento
	@ManyToOne
	@JoinColumn(name="orcamentoid")
	private XOrcamento orcamento;

	public XOrcamentoPrevisaoReceita() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getDiarias() {
		return this.diarias;
	}

	public void setDiarias(BigDecimal diarias) {
		this.diarias = diarias;
	}

	public String getItem() {
		return this.item;
	}

	public void setItem(String item) {
		this.item = item;
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

	public XCentroCusto getCentroCusto() {
		return centroCusto;
	}

	public void setCentroCusto(XCentroCusto centroCusto) {
		this.centroCusto = centroCusto;
	}

	public XItemOrcamento getItemOrcamento() {
		return itemOrcamento;
	}

	public void setItemOrcamento(XItemOrcamento itemOrcamento) {
		this.itemOrcamento = itemOrcamento;
	}

	public XOrcamento getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(XOrcamento orcamento) {
		this.orcamento = orcamento;
	}

}