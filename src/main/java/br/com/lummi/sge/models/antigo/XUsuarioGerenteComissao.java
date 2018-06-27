package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the cusuariogerentecomissao database table.
 * 
 */
@Entity
@Table(name="cusuariogerentecomissao")
public class XUsuarioGerenteComissao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String codigo;

	private Integer comissaoreferenciaid;

	private Timestamp datahora;

	private Boolean estornado;

	private String historico;

	private String operacao;

	private BigDecimal percentualcomissao;

	private String status;

	private BigDecimal valor;

	private BigDecimal valorproposta;

	private BigDecimal valorsubtotal;

	@ManyToOne
	@JoinColumn(name="pessoaid")
	private XPessoa pessoa;

	@ManyToOne
	@JoinColumn(name="usuarioid")
	private XUsuario usuario;

	@ManyToOne
	@JoinColumn(name="orcamentoid")
	private XOrcamento orcamento;

	@OneToMany(mappedBy="usuarioGerenteComissao")
	private List<XFaturaComissaoItem> faturaComissaoItens;

	public XUsuarioGerenteComissao() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Integer getComissaoreferenciaid() {
		return comissaoreferenciaid;
	}

	public void setComissaoreferenciaid(Integer comissaoreferenciaid) {
		this.comissaoreferenciaid = comissaoreferenciaid;
	}

	public Timestamp getDatahora() {
		return datahora;
	}

	public void setDatahora(Timestamp datahora) {
		this.datahora = datahora;
	}

	public Boolean getEstornado() {
		return estornado;
	}

	public void setEstornado(Boolean estornado) {
		this.estornado = estornado;
	}

	public String getHistorico() {
		return historico;
	}

	public void setHistorico(String historico) {
		this.historico = historico;
	}

	public String getOperacao() {
		return operacao;
	}

	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}

	public BigDecimal getPercentualcomissao() {
		return percentualcomissao;
	}

	public void setPercentualcomissao(BigDecimal percentualcomissao) {
		this.percentualcomissao = percentualcomissao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getValorproposta() {
		return valorproposta;
	}

	public void setValorproposta(BigDecimal valorproposta) {
		this.valorproposta = valorproposta;
	}

	public BigDecimal getValorsubtotal() {
		return valorsubtotal;
	}

	public void setValorsubtotal(BigDecimal valorsubtotal) {
		this.valorsubtotal = valorsubtotal;
	}

	public XPessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(XPessoa pessoa) {
		this.pessoa = pessoa;
	}

	public XUsuario getUsuario() {
		return usuario;
	}

	public void setUsuario(XUsuario usuario) {
		this.usuario = usuario;
	}

	public XOrcamento getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(XOrcamento orcamento) {
		this.orcamento = orcamento;
	}

	public List<XFaturaComissaoItem> getFaturaComissaoItens() {
		return faturaComissaoItens;
	}

	public void setFaturaComissaoItens(List<XFaturaComissaoItem> faturaComissaoItens) {
		this.faturaComissaoItens = faturaComissaoItens;
	}

}