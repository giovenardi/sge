package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the mpesquisasatisfacao database table.
 * 
 */
@Entity
@Table(name="mpesquisasatisfacao")
public class XPesquisaSatisfacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String area;

	private String contato;

	private String observacao;

	private BigDecimal resultadoavaliacao;

	private BigDecimal resultadoavaliacaopercentual;

	private String sugestaomelhoria;

	//bi-directional many-to-one association to Cempresa
	@ManyToOne
	@JoinColumn(name="empresaid")
	private XEmpresa empresa;

	//bi-directional many-to-one association to Morcamento
	@ManyToOne
	@JoinColumn(name="orcamentoid")
	private XOrcamento orcamento;

	@OneToMany(mappedBy="pesquisaSatisfacao")
	private List<XPesquisaSatisfacaoItem> pesquisasSatisfacaoItens;

	public XPesquisaSatisfacao() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getContato() {
		return this.contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public BigDecimal getResultadoavaliacao() {
		return this.resultadoavaliacao;
	}

	public void setResultadoavaliacao(BigDecimal resultadoavaliacao) {
		this.resultadoavaliacao = resultadoavaliacao;
	}

	public BigDecimal getResultadoavaliacaopercentual() {
		return this.resultadoavaliacaopercentual;
	}

	public void setResultadoavaliacaopercentual(BigDecimal resultadoavaliacaopercentual) {
		this.resultadoavaliacaopercentual = resultadoavaliacaopercentual;
	}

	public String getSugestaomelhoria() {
		return this.sugestaomelhoria;
	}

	public void setSugestaomelhoria(String sugestaomelhoria) {
		this.sugestaomelhoria = sugestaomelhoria;
	}

	public XEmpresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(XEmpresa empresa) {
		this.empresa = empresa;
	}

	public XOrcamento getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(XOrcamento orcamento) {
		this.orcamento = orcamento;
	}

	public List<XPesquisaSatisfacaoItem> getPesquisasSatisfacaoItens() {
		return pesquisasSatisfacaoItens;
	}

	public void setPesquisasSatisfacaoItens(List<XPesquisaSatisfacaoItem> pesquisasSatisfacaoItens) {
		this.pesquisasSatisfacaoItens = pesquisasSatisfacaoItens;
	}

}