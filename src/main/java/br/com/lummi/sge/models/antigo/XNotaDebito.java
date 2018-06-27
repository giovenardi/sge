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
 * The persistent class for the mnotadebito database table.
 * 
 */
@Entity
@Table(name="mnotadebito")
public class XNotaDebito implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private BigDecimal acresimo;

	private BigDecimal basecalculo;

	private String codigo;

	private String deducoeslegais;

	private BigDecimal desconto;

	private Boolean ehentrada;

	private Boolean ehremessa;

	private Boolean ehsubcontratacao;

	private Boolean ehusuariofinal;

	@Temporal(TemporalType.DATE)
	private Date emissao;

	private BigDecimal imposto;

	private String notafiscalsubcontratacao;

	private String numero;

	private String obs;

	private String origem;

	private BigDecimal total;

	private BigDecimal valorbruto;

	@OneToMany(mappedBy="notaDebito")
	private List<XContaReceber> contasReceber;

	@ManyToOne
	@JoinColumn(name="empresaid")
	private XEmpresa empresa;

	@ManyToOne
	@JoinColumn(name="clienteid")
	private XPessoa pessoa;

	@ManyToOne
	@JoinColumn(name="regraimpostoid")
	private XRegraImposto regraImposto;

	@ManyToOne
	@JoinColumn(name="orcamentoid")
	private XOrcamento orcamento;

	@OneToMany(mappedBy="notaDebito")
	private List<XNotaDebitoItem> notaDebitoItens;

	@OneToMany(mappedBy="notaDebito")
	private List<XNotaDebitoOrcamentoPC> notaDebitoOrcamentoPCs;

	public XNotaDebito() {
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

	public String getDeducoeslegais() {
		return deducoeslegais;
	}

	public void setDeducoeslegais(String deducoeslegais) {
		this.deducoeslegais = deducoeslegais;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	public Boolean getEhentrada() {
		return ehentrada;
	}

	public void setEhentrada(Boolean ehentrada) {
		this.ehentrada = ehentrada;
	}

	public Boolean getEhremessa() {
		return ehremessa;
	}

	public void setEhremessa(Boolean ehremessa) {
		this.ehremessa = ehremessa;
	}

	public Boolean getEhsubcontratacao() {
		return ehsubcontratacao;
	}

	public void setEhsubcontratacao(Boolean ehsubcontratacao) {
		this.ehsubcontratacao = ehsubcontratacao;
	}

	public Boolean getEhusuariofinal() {
		return ehusuariofinal;
	}

	public void setEhusuariofinal(Boolean ehusuariofinal) {
		this.ehusuariofinal = ehusuariofinal;
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

	public String getNotafiscalsubcontratacao() {
		return notafiscalsubcontratacao;
	}

	public void setNotafiscalsubcontratacao(String notafiscalsubcontratacao) {
		this.notafiscalsubcontratacao = notafiscalsubcontratacao;
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

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
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

	public List<XContaReceber> getContasReceber() {
		return contasReceber;
	}

	public void setContasReceber(List<XContaReceber> contasReceber) {
		this.contasReceber = contasReceber;
	}

	public XEmpresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(XEmpresa empresa) {
		this.empresa = empresa;
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

	public List<XNotaDebitoItem> getNotaDebitoItens() {
		return notaDebitoItens;
	}

	public void setNotaDebitoItens(List<XNotaDebitoItem> notaDebitoItens) {
		this.notaDebitoItens = notaDebitoItens;
	}

	public List<XNotaDebitoOrcamentoPC> getNotaDebitoOrcamentoPCs() {
		return notaDebitoOrcamentoPCs;
	}

	public void setNotaDebitoOrcamentoPCs(List<XNotaDebitoOrcamentoPC> notaDebitoOrcamentoPCs) {
		this.notaDebitoOrcamentoPCs = notaDebitoOrcamentoPCs;
	}

}