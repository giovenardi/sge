package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the msolicitacaoorcamento database table.
 * 
 */
@Entity
@Table(name="msolicitacaoorcamento")
public class XSolicitacaoOrcamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String codigo;

	private Timestamp datacadastro;

	private Timestamp emissao;

	private String enderecado;

	private String estado;

	private String faturapara;

	private String notasimportantes;

	private Timestamp prazodevolucao;

	@Column(name="servico_condicaopagto")
	private String servicoCondicaopagto;

	@Column(name="servico_dataentrega")
	private Timestamp servicoDataentrega;

	@Column(name="servico_especificacao")
	private String servicoEspecificacao;

	@Column(name="servico_formapagto")
	private Integer servicoFormapagto;

	@Column(name="servico_localentrega")
	private String servicoLocalentrega;

	@Column(name="servico_nome")
	private String servicoNome;

	@Column(name="servico_valor")
	private BigDecimal servicoValor;

	@Column(name="servico_vencimento")
	private Timestamp servicoVencimento;

	//bi-directional many-to-one association to Mordemservico
	@OneToMany(mappedBy="solicitacaoOrcamento")
	private List<XOrdemServico> ordensServico;

	//bi-directional many-to-one association to Ccentrocusto
	@ManyToOne
	@JoinColumn(name="servico_centrocustoid")
	private XCentroCusto centroCusto;

	//bi-directional many-to-one association to Cempresa
	@ManyToOne
	@JoinColumn(name="empresaid")
	private XEmpresa empresa;

	//bi-directional many-to-one association to Cpessoa
	@ManyToOne
	@JoinColumn(name="clienteid")
	private XPessoa pessoa1;

	//bi-directional many-to-one association to Cpessoa
	@ManyToOne
	@JoinColumn(name="fornecedorid")
	private XPessoa pessoa2;

	//bi-directional many-to-one association to Cusuario
	@ManyToOne
	@JoinColumn(name="usuarioid")
	private XUsuario usuario;

	@ManyToOne
	@JoinColumn(name="orcamentoid")
	private XOrcamento orcamento;

	@OneToMany(mappedBy="solicitacaoOrcamento")
	private List<XSolicitacaoOrcamentoItem> solicitacaoOrcamentoItens;

	public XSolicitacaoOrcamento() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Timestamp getDatacadastro() {
		return this.datacadastro;
	}

	public void setDatacadastro(Timestamp datacadastro) {
		this.datacadastro = datacadastro;
	}

	public Timestamp getEmissao() {
		return this.emissao;
	}

	public void setEmissao(Timestamp emissao) {
		this.emissao = emissao;
	}

	public String getEnderecado() {
		return this.enderecado;
	}

	public void setEnderecado(String enderecado) {
		this.enderecado = enderecado;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFaturapara() {
		return this.faturapara;
	}

	public void setFaturapara(String faturapara) {
		this.faturapara = faturapara;
	}

	public String getNotasimportantes() {
		return this.notasimportantes;
	}

	public void setNotasimportantes(String notasimportantes) {
		this.notasimportantes = notasimportantes;
	}

	public Timestamp getPrazodevolucao() {
		return this.prazodevolucao;
	}

	public void setPrazodevolucao(Timestamp prazodevolucao) {
		this.prazodevolucao = prazodevolucao;
	}

	public String getServicoCondicaopagto() {
		return this.servicoCondicaopagto;
	}

	public void setServicoCondicaopagto(String servicoCondicaopagto) {
		this.servicoCondicaopagto = servicoCondicaopagto;
	}

	public Timestamp getServicoDataentrega() {
		return this.servicoDataentrega;
	}

	public void setServicoDataentrega(Timestamp servicoDataentrega) {
		this.servicoDataentrega = servicoDataentrega;
	}

	public String getServicoEspecificacao() {
		return this.servicoEspecificacao;
	}

	public void setServicoEspecificacao(String servicoEspecificacao) {
		this.servicoEspecificacao = servicoEspecificacao;
	}

	public Integer getServicoFormapagto() {
		return this.servicoFormapagto;
	}

	public void setServicoFormapagto(Integer servicoFormapagto) {
		this.servicoFormapagto = servicoFormapagto;
	}

	public String getServicoLocalentrega() {
		return this.servicoLocalentrega;
	}

	public void setServicoLocalentrega(String servicoLocalentrega) {
		this.servicoLocalentrega = servicoLocalentrega;
	}

	public String getServicoNome() {
		return this.servicoNome;
	}

	public void setServicoNome(String servicoNome) {
		this.servicoNome = servicoNome;
	}

	public BigDecimal getServicoValor() {
		return this.servicoValor;
	}

	public void setServicoValor(BigDecimal servicoValor) {
		this.servicoValor = servicoValor;
	}

	public Timestamp getServicoVencimento() {
		return this.servicoVencimento;
	}

	public void setServicoVencimento(Timestamp servicoVencimento) {
		this.servicoVencimento = servicoVencimento;
	}

	public List<XOrdemServico> getOrdensServico() {
		return ordensServico;
	}

	public void setOrdensServico(List<XOrdemServico> ordensServico) {
		this.ordensServico = ordensServico;
	}

	public XCentroCusto getCentroCusto() {
		return this.centroCusto;
	}

	public void setCentroCusto(XCentroCusto centroCusto) {
		this.centroCusto = centroCusto;
	}

	public XEmpresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(XEmpresa empresa) {
		this.empresa = empresa;
	}

	public XPessoa getPessoa1() {
		return this.pessoa1;
	}

	public void setPessoa1(XPessoa pessoa1) {
		this.pessoa1 = pessoa1;
	}

	public XPessoa getPessoa2() {
		return this.pessoa2;
	}

	public void setPessoa2(XPessoa pessoa2) {
		this.pessoa2 = pessoa2;
	}

	public XUsuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(XUsuario usuario) {
		this.usuario = usuario;
	}

	public XOrcamento getOrcamento() {
		return this.orcamento;
	}

	public void setOrcamento(XOrcamento orcamento) {
		this.orcamento = orcamento;
	}

	public List<XSolicitacaoOrcamentoItem> getSolicitacaoOrcamentoItens() {
		return solicitacaoOrcamentoItens;
	}

	public void setSolicitacaoOrcamentoItens(List<XSolicitacaoOrcamentoItem> solicitacaoOrcamentoItens) {
		this.solicitacaoOrcamentoItens = solicitacaoOrcamentoItens;
	}

}