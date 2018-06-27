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
 * The persistent class for the mgerenciamentoperformance database table.
 * 
 */
@Entity
@Table(name="mgerenciamentoperformance")
public class XGerenciamentoPerformance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Date dataavaliazao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datacadastro;

	private String observacao;

	private String pontosadesenvolver;

	private String pontosfortes;

	private BigDecimal resultadoavaliacao;

	private BigDecimal resultadoavaliacaopercentual;

	private String status;

	@ManyToOne
	@JoinColumn(name="conceitoid")
	private XConceito conceito;

	@ManyToOne
	@JoinColumn(name="coordenadorid")
	private XPessoa pessoa;

	@ManyToOne
	@JoinColumn(name="fornecedorid")
	private XPessoa pessoa2;

	@ManyToOne
	@JoinColumn(name="usuariocadastroid")
	private XUsuario usuario;

	@ManyToOne
	@JoinColumn(name="ordemservicoid")
	private XOrdemServico ordemServico;

	@OneToMany(mappedBy="gerenciamentoPerformance")
	private List<XGerenciamentoPerformanceItem> gerenciamentoPerformanceItens;

	public XGerenciamentoPerformance() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getPontosadesenvolver() {
		return this.pontosadesenvolver;
	}

	public void setPontosadesenvolver(String pontosadesenvolver) {
		this.pontosadesenvolver = pontosadesenvolver;
	}

	public String getPontosfortes() {
		return this.pontosfortes;
	}

	public void setPontosfortes(String pontosfortes) {
		this.pontosfortes = pontosfortes;
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

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDataavaliazao() {
		return dataavaliazao;
	}

	public void setDataavaliazao(Date dataavaliazao) {
		this.dataavaliazao = dataavaliazao;
	}

	public Date getDatacadastro() {
		return datacadastro;
	}

	public void setDatacadastro(Date datacadastro) {
		this.datacadastro = datacadastro;
	}

	public XConceito getConceito() {
		return conceito;
	}

	public void setConceito(XConceito conceito) {
		this.conceito = conceito;
	}

	public XPessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(XPessoa pessoa) {
		this.pessoa = pessoa;
	}

	public XPessoa getPessoa2() {
		return pessoa2;
	}

	public void setPessoa2(XPessoa pessoa2) {
		this.pessoa2 = pessoa2;
	}

	public XUsuario getUsuario() {
		return usuario;
	}

	public void setUsuario(XUsuario usuario) {
		this.usuario = usuario;
	}

	public XOrdemServico getOrdemServico() {
		return ordemServico;
	}

	public void setOrdemServico(XOrdemServico ordemServico) {
		this.ordemServico = ordemServico;
	}

	public List<XGerenciamentoPerformanceItem> getGerenciamentoPerformanceItens() {
		return gerenciamentoPerformanceItens;
	}

	public void setGerenciamentoPerformanceItens(List<XGerenciamentoPerformanceItem> gerenciamentoPerformanceItens) {
		this.gerenciamentoPerformanceItens = gerenciamentoPerformanceItens;
	}

}