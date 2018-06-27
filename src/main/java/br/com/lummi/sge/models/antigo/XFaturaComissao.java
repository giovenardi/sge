package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the mfaturacomissao database table.
 * 
 */
@Entity
@Table(name="mfaturacomissao")
public class XFaturaComissao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String codigo;

	private String contapagarreferencia;

	@Temporal(TemporalType.TIMESTAMP)
	private Date data;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datacadastro;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datafechamento;

	private String historico;

	private String observasao;

	private String status;

	private BigDecimal valortotal;

	@Temporal(TemporalType.DATE)
	@Column(name="venciemento")
	private Date vencimento;

	@ManyToOne
	@JoinColumn(name="centrocustoid")
	private XCentroCusto centroCusto;

	@ManyToOne
	@JoinColumn(name="empresaid")
	private XEmpresa empresa;

	@ManyToOne
	@JoinColumn(name="pessoaid")
	private XPessoa pessoa;

	@ManyToOne
	@JoinColumn(name="usuariocadastroid")
	private XUsuario usuarioCadastro;

	@ManyToOne
	@JoinColumn(name="usuariofechamentoid")
	private XUsuario usuarioFechamento;

	@OneToMany(mappedBy="faturaComissao")
	private List<XFaturaComissaoItem> faturaComissaoItems;

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

	public String getContapagarreferencia() {
		return contapagarreferencia;
	}

	public void setContapagarreferencia(String contapagarreferencia) {
		this.contapagarreferencia = contapagarreferencia;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getDatacadastro() {
		return datacadastro;
	}

	public void setDatacadastro(Date datacadastro) {
		this.datacadastro = datacadastro;
	}

	public Date getDatafechamento() {
		return datafechamento;
	}

	public void setDatafechamento(Date datafechamento) {
		this.datafechamento = datafechamento;
	}

	public String getHistorico() {
		return historico;
	}

	public void setHistorico(String historico) {
		this.historico = historico;
	}

	public String getObservasao() {
		return observasao;
	}

	public void setObservasao(String observasao) {
		this.observasao = observasao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getValortotal() {
		return valortotal;
	}

	public void setValortotal(BigDecimal valortotal) {
		this.valortotal = valortotal;
	}

	public Date getVencimento() {
		return vencimento;
	}

	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;
	}

	public XCentroCusto getCentroCusto() {
		return centroCusto;
	}

	public void setCentroCusto(XCentroCusto centroCusto) {
		this.centroCusto = centroCusto;
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

	public XUsuario getUsuarioCadastro() {
		return usuarioCadastro;
	}

	public void setUsuarioCadastro(XUsuario usuarioCadastro) {
		this.usuarioCadastro = usuarioCadastro;
	}

	public XUsuario getUsuarioFechamento() {
		return usuarioFechamento;
	}

	public void setUsuarioFechamento(XUsuario usuarioFechamento) {
		this.usuarioFechamento = usuarioFechamento;
	}

	public List<XFaturaComissaoItem> getFaturaComissaoItems() {
		return faturaComissaoItems;
	}

	public void setFaturaComissaoItems(List<XFaturaComissaoItem> faturaComissaoItems) {
		this.faturaComissaoItems = faturaComissaoItems;
	}

	public XFaturaComissao() {
	}

}