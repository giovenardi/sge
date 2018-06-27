package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the morcamentocomissao database table.
 * 
 */
@Entity
@Table(name="morcamentocomissao")
public class XOrcamentoComissao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String contapagarcodigo;

	private String item;

	private BigDecimal valorcomissao;

	private Timestamp vencimento;

	@ManyToOne
	@JoinColumn(name="centrocustoid")
	private XCentroCusto centroCusto;

	@ManyToOne
	@JoinColumn(name="pessoaid")
	private XPessoa pessoa;

	@ManyToOne
	@JoinColumn(name="orcamentoid")
	private XOrcamento orcamento;

	public XOrcamentoComissao() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContapagarcodigo() {
		return this.contapagarcodigo;
	}

	public void setContapagarcodigo(String contapagarcodigo) {
		this.contapagarcodigo = contapagarcodigo;
	}

	public String getItem() {
		return this.item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public BigDecimal getValorcomissao() {
		return this.valorcomissao;
	}

	public void setValorcomissao(BigDecimal valorcomissao) {
		this.valorcomissao = valorcomissao;
	}

	public Timestamp getVencimento() {
		return this.vencimento;
	}

	public void setVencimento(Timestamp vencimento) {
		this.vencimento = vencimento;
	}

	public XCentroCusto getCentroCusto() {
		return centroCusto;
	}

	public void setCentroCusto(XCentroCusto centroCusto) {
		this.centroCusto = centroCusto;
	}

	public XPessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(XPessoa pessoa) {
		this.pessoa = pessoa;
	}

	public XOrcamento getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(XOrcamento orcamento) {
		this.orcamento = orcamento;
	}

}