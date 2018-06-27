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
 * The persistent class for the mcursoaluno database table.
 * 
 */
@Entity
@Table(name="mcursoaluno")
public class XCursoAluno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datahoracadastro;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datahoraconfirmacao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datahorafaturamento;

	@Temporal(TemporalType.DATE)
	private Date dataprimeiraparcela;

	@Temporal(TemporalType.DATE)
	private Date dataultimaparcela;

	private Integer diapagamento;

	private String numero;

	private String numerohavaiana;

	private Integer qtdparcelas;

	@Temporal(TemporalType.DATE)
	private Date referenciafinanceira;

	private String sequencial;

	private String status;

	private String turno;

	private BigDecimal valorparcela;

	private BigDecimal valortaxaboleto;

	private BigDecimal valortotal;

	@ManyToOne
	@JoinColumn(name="centrocustoid")
	private XCentroCusto centroCusto;

	@ManyToOne
	@JoinColumn(name="centroresultadoid")
	private XCentroResultado centroResultado;

	@ManyToOne
	@JoinColumn(name="planopagamentoid")
	private XFormaPagamento formaPagamento;

	@ManyToOne
	@JoinColumn(name="alunoid")
	private XPessoa pessoa;

	@ManyToOne
	@JoinColumn(name="usuariocadastroid")
	private XUsuario usuarioCadastro;

	@ManyToOne
	@JoinColumn(name="usuarioconfirmacaoid")
	private XUsuario usuarioConfoirmacao;

	@ManyToOne
	@JoinColumn(name="usuariofaturamentoid")
	private XUsuario usuarioFaturamento;

	@ManyToOne
	@JoinColumn(name="projetoid")
	private XProjeto  projeto;

	@ManyToOne
	@JoinColumn(name="cursoid")
	private XProjetoCurso projetoCurso;

	@OneToMany(mappedBy="cursoAluno")
	private List<XCursoAlunoProgramacao> cursosAlunoProgramacao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDatahoracadastro() {
		return datahoracadastro;
	}

	public void setDatahoracadastro(Date datahoracadastro) {
		this.datahoracadastro = datahoracadastro;
	}

	public Date getDatahoraconfirmacao() {
		return datahoraconfirmacao;
	}

	public void setDatahoraconfirmacao(Date datahoraconfirmacao) {
		this.datahoraconfirmacao = datahoraconfirmacao;
	}

	public Date getDatahorafaturamento() {
		return datahorafaturamento;
	}

	public void setDatahorafaturamento(Date datahorafaturamento) {
		this.datahorafaturamento = datahorafaturamento;
	}

	public Date getDataprimeiraparcela() {
		return dataprimeiraparcela;
	}

	public void setDataprimeiraparcela(Date dataprimeiraparcela) {
		this.dataprimeiraparcela = dataprimeiraparcela;
	}

	public Date getDataultimaparcela() {
		return dataultimaparcela;
	}

	public void setDataultimaparcela(Date dataultimaparcela) {
		this.dataultimaparcela = dataultimaparcela;
	}

	public Integer getDiapagamento() {
		return diapagamento;
	}

	public void setDiapagamento(Integer diapagamento) {
		this.diapagamento = diapagamento;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNumerohavaiana() {
		return numerohavaiana;
	}

	public void setNumerohavaiana(String numerohavaiana) {
		this.numerohavaiana = numerohavaiana;
	}

	public Integer getQtdparcelas() {
		return qtdparcelas;
	}

	public void setQtdparcelas(Integer qtdparcelas) {
		this.qtdparcelas = qtdparcelas;
	}

	public Date getReferenciafinanceira() {
		return referenciafinanceira;
	}

	public void setReferenciafinanceira(Date referenciafinanceira) {
		this.referenciafinanceira = referenciafinanceira;
	}

	public String getSequencial() {
		return sequencial;
	}

	public void setSequencial(String sequencial) {
		this.sequencial = sequencial;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public BigDecimal getValorparcela() {
		return valorparcela;
	}

	public void setValorparcela(BigDecimal valorparcela) {
		this.valorparcela = valorparcela;
	}

	public BigDecimal getValortaxaboleto() {
		return valortaxaboleto;
	}

	public void setValortaxaboleto(BigDecimal valortaxaboleto) {
		this.valortaxaboleto = valortaxaboleto;
	}

	public BigDecimal getValortotal() {
		return valortotal;
	}

	public void setValortotal(BigDecimal valortotal) {
		this.valortotal = valortotal;
	}

	public XCentroCusto getCentroCusto() {
		return centroCusto;
	}

	public void setCentroCusto(XCentroCusto centroCusto) {
		this.centroCusto = centroCusto;
	}

	public XCentroResultado getCentroResultado() {
		return centroResultado;
	}

	public void setCentroResultado(XCentroResultado centroResultado) {
		this.centroResultado = centroResultado;
	}

	public XFormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(XFormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
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

	public XUsuario getUsuarioConfoirmacao() {
		return usuarioConfoirmacao;
	}

	public void setUsuarioConfoirmacao(XUsuario usuarioConfoirmacao) {
		this.usuarioConfoirmacao = usuarioConfoirmacao;
	}

	public XUsuario getUsuarioFaturamento() {
		return usuarioFaturamento;
	}

	public void setUsuarioFaturamento(XUsuario usuarioFaturamento) {
		this.usuarioFaturamento = usuarioFaturamento;
	}

	public XProjeto getProjeto() {
		return projeto;
	}

	public void setProjeto(XProjeto projeto) {
		this.projeto = projeto;
	}

	public XProjetoCurso getProjetoCurso() {
		return projetoCurso;
	}

	public void setProjetoCurso(XProjetoCurso projetoCurso) {
		this.projetoCurso = projetoCurso;
	}

	public List<XCursoAlunoProgramacao> getCursosAlunoProgramacao() {
		return cursosAlunoProgramacao;
	}

	public void setCursosAlunoProgramacao(List<XCursoAlunoProgramacao> cursosAlunoProgramacao) {
		this.cursosAlunoProgramacao = cursosAlunoProgramacao;
	}

	public XCursoAluno() {
	}

}