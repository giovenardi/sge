package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the mreembolso database table.
 * 
 */
@Entity
@Table(name="mreembolso")
public class XReembolso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String codigo;

	private Timestamp datacadastro;

	private Timestamp datahora;

	private String descricao;

	private Integer empresaid;

	private Timestamp limiteprestacaoconta;

	private String observacao;

	private String status;

	private Integer usuarioid;

	private BigDecimal valoradiantado;

	private BigDecimal valordiferenca;

	private BigDecimal valorgasto;

	private Timestamp vencimento;

	//bi-directional many-to-one association to Ccentrocusto
	@ManyToOne
	@JoinColumn(name="centrocustoid")
	private XCentroCusto centroCusto;

	//bi-directional many-to-one association to Ccentroresultado
	@ManyToOne
	@JoinColumn(name="centroresultadoid")
	private XCentroResultado centroResultado;

	//bi-directional many-to-one association to Cpessoa
	@ManyToOne
	@JoinColumn(name="pessoaid")
	private XPessoa pessoa;

	//bi-directional many-to-one association to Morcamento
	@ManyToOne
	@JoinColumn(name="orcamentoid")
	private XOrcamento orcamento;

	//bi-directional many-to-one association to Mreembolsodespesa
	@OneToMany(mappedBy="reembolso")
	private List<XReembolsoDespesa> reembolsosDespesa;

	public XReembolso() {
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

	public Timestamp getDatahora() {
		return this.datahora;
	}

	public void setDatahora(Timestamp datahora) {
		this.datahora = datahora;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getEmpresaid() {
		return this.empresaid;
	}

	public void setEmpresaid(Integer empresaid) {
		this.empresaid = empresaid;
	}

	public Timestamp getLimiteprestacaoconta() {
		return this.limiteprestacaoconta;
	}

	public void setLimiteprestacaoconta(Timestamp limiteprestacaoconta) {
		this.limiteprestacaoconta = limiteprestacaoconta;
	}

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getUsuarioid() {
		return this.usuarioid;
	}

	public void setUsuarioid(Integer usuarioid) {
		this.usuarioid = usuarioid;
	}

	public BigDecimal getValoradiantado() {
		return this.valoradiantado;
	}

	public void setValoradiantado(BigDecimal valoradiantado) {
		this.valoradiantado = valoradiantado;
	}

	public BigDecimal getValordiferenca() {
		return this.valordiferenca;
	}

	public void setValordiferenca(BigDecimal valordiferenca) {
		this.valordiferenca = valordiferenca;
	}

	public BigDecimal getValorgasto() {
		return this.valorgasto;
	}

	public void setValorgasto(BigDecimal valorgasto) {
		this.valorgasto = valorgasto;
	}

	public Timestamp getVencimento() {
		return this.vencimento;
	}

	public void setVencimento(Timestamp vencimento) {
		this.vencimento = vencimento;
	}

	public XCentroCusto getCentroCusto() {
		return this.centroCusto;
	}

	public void setCentroCusto(XCentroCusto centroCusto) {
		this.centroCusto = centroCusto;
	}

	public XCentroResultado getCentroResultado() {
		return this.centroResultado;
	}

	public void setCentroResultado(XCentroResultado centroResultado) {
		this.centroResultado = centroResultado;
	}

	public XPessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(XPessoa pessoa) {
		this.pessoa = pessoa;
	}

	public XOrcamento getOrcamento() {
		return this.orcamento;
	}

	public void setOrcamento(XOrcamento orcamento) {
		this.orcamento = orcamento;
	}

	public List<XReembolsoDespesa> getReembolsosDespesa() {
		return this.reembolsosDespesa;
	}

	public void setReembolsosDespesa(List<XReembolsoDespesa> reembolsosDespesa) {
		this.reembolsosDespesa = reembolsosDespesa;
	}

}