package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the mnotafiscal database table.
 * 
 */
@Entity
@Table(name="mnotafiscal")
public class XNotaFiscal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private BigDecimal acresimo;

	private BigDecimal basecalculo;

	private String codigo;

	private BigDecimal desconto;

	@Temporal(TemporalType.DATE)
	private Date emissao;

	private BigDecimal imposto;

	private String numero;

	private String obs;

	private BigDecimal total;

	private BigDecimal valorbruto;

	@ManyToOne
	@JoinColumn(name="clienteid")
	private XPessoa pessoa;

	@ManyToOne
	@JoinColumn(name="regraimpostoid")
	private XRegraImposto regraImposto;

	@ManyToOne
	@JoinColumn(name="orcamentoid")
	private XOrcamento orcamento;

	@OneToMany(mappedBy="notaFiscal")
	private List<XNotaFiscalItem> notaFiscalItens;

	public XNotaFiscal() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getAcresimo() {
		return acresimo;
	}

	public void setAcresimo(BigDecimal acresimo) {
		this.acresimo = acresimo;
	}

	public BigDecimal getBasecalculo() {
		return basecalculo;
	}

	public void setBasecalculo(BigDecimal basecalculo) {
		this.basecalculo = basecalculo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	public Date getEmissao() {
		return emissao;
	}

	public void setEmissao(Date emissao) {
		this.emissao = emissao;
	}

	public BigDecimal getImposto() {
		return imposto;
	}

	public void setImposto(BigDecimal imposto) {
		this.imposto = imposto;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public BigDecimal getValorbruto() {
		return valorbruto;
	}

	public void setValorbruto(BigDecimal valorbruto) {
		this.valorbruto = valorbruto;
	}

	public XPessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(XPessoa pessoa) {
		this.pessoa = pessoa;
	}

	public XRegraImposto getRegraImposto() {
		return regraImposto;
	}

	public void setRegraImposto(XRegraImposto regraImposto) {
		this.regraImposto = regraImposto;
	}

	public XOrcamento getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(XOrcamento orcamento) {
		this.orcamento = orcamento;
	}

	public List<XNotaFiscalItem> getNotaFiscalItens() {
		return notaFiscalItens;
	}

	public void setNotaFiscalItens(List<XNotaFiscalItem> notaFiscalItens) {
		this.notaFiscalItens = notaFiscalItens;
	}

}