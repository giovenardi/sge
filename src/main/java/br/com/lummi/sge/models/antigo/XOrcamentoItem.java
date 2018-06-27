package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the morcamentoitem database table.
 * 
 */
@Entity
@Table(name="morcamentoitem")
public class XOrcamentoItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String agrupador;

	private String categoria;

	private String descricao;

	private BigDecimal diarias;

	private Boolean ehhonorario;

	private Boolean ehinss;

	private Integer executor;

	private String faturapara;

	private BigDecimal honorario;

	private BigDecimal imposto;

	private String item;

	private BigDecimal percentualmargemglobal;

	private BigDecimal quantidade;

	private BigDecimal reducaocusto;

	private String tipo;

	private BigDecimal valormargemglobal;

	private BigDecimal valortotal;

	private BigDecimal valorunitario;

	@OneToMany(mappedBy="orcamentoItem")
	private List<XContaPagar> contasPagar;

	@ManyToOne
	@JoinColumn(name="itemorcamentoid")
	private XItemOrcamento itemOrcamento;

	@ManyToOne
	@JoinColumn(name="unidademedidaid")
	private XUnidadeMedida unidadeMedida;

	@ManyToOne
	@JoinColumn(name="orcamentoid")
	private XOrcamento orcamento;

	@OneToMany(mappedBy="orcamentoItem")
	private List<XOrdemServicoItem> ordemServicoItens;

	@OneToMany(mappedBy="orcamentoItem")
	private List<XSolicitacaoOrcamentoItem> solicitacoesOrcamentoItens;

	public XOrcamentoItem() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAgrupador() {
		return this.agrupador;
	}

	public void setAgrupador(String agrupador) {
		this.agrupador = agrupador;
	}

	public String getCategoria() {
		return this.categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getDiarias() {
		return this.diarias;
	}

	public void setDiarias(BigDecimal diarias) {
		this.diarias = diarias;
	}

	public Boolean getEhhonorario() {
		return this.ehhonorario;
	}

	public void setEhhonorario(Boolean ehhonorario) {
		this.ehhonorario = ehhonorario;
	}

	public Boolean getEhinss() {
		return this.ehinss;
	}

	public void setEhinss(Boolean ehinss) {
		this.ehinss = ehinss;
	}

	public Integer getExecutor() {
		return this.executor;
	}

	public void setExecutor(Integer executor) {
		this.executor = executor;
	}

	public String getFaturapara() {
		return this.faturapara;
	}

	public void setFaturapara(String faturapara) {
		this.faturapara = faturapara;
	}

	public BigDecimal getHonorario() {
		return this.honorario;
	}

	public void setHonorario(BigDecimal honorario) {
		this.honorario = honorario;
	}

	public BigDecimal getImposto() {
		return this.imposto;
	}

	public void setImposto(BigDecimal imposto) {
		this.imposto = imposto;
	}

	public String getItem() {
		return this.item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public BigDecimal getPercentualmargemglobal() {
		return this.percentualmargemglobal;
	}

	public void setPercentualmargemglobal(BigDecimal percentualmargemglobal) {
		this.percentualmargemglobal = percentualmargemglobal;
	}

	public BigDecimal getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getReducaocusto() {
		return this.reducaocusto;
	}

	public void setReducaocusto(BigDecimal reducaocusto) {
		this.reducaocusto = reducaocusto;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public BigDecimal getValormargemglobal() {
		return this.valormargemglobal;
	}

	public void setValormargemglobal(BigDecimal valormargemglobal) {
		this.valormargemglobal = valormargemglobal;
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

	public List<XContaPagar> getContasPagar() {
		return contasPagar;
	}

	public void setContasPagar(List<XContaPagar> contasPagar) {
		this.contasPagar = contasPagar;
	}

	public XItemOrcamento getItemOrcamento() {
		return itemOrcamento;
	}

	public void setItemOrcamento(XItemOrcamento itemOrcamento) {
		this.itemOrcamento = itemOrcamento;
	}

	public XUnidadeMedida getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(XUnidadeMedida unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public XOrcamento getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(XOrcamento orcamento) {
		this.orcamento = orcamento;
	}

	public List<XOrdemServicoItem> getOrdemServicoItens() {
		return ordemServicoItens;
	}

	public void setOrdemServicoItens(List<XOrdemServicoItem> ordemServicoItens) {
		this.ordemServicoItens = ordemServicoItens;
	}

	public List<XSolicitacaoOrcamentoItem> getSolicitacoesOrcamentoItens() {
		return solicitacoesOrcamentoItens;
	}

	public void setSolicitacoesOrcamentoItens(List<XSolicitacaoOrcamentoItem> solicitacoesOrcamentoItens) {
		this.solicitacoesOrcamentoItens = solicitacoesOrcamentoItens;
	}

}