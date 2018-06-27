package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the mticketconsumo database table.
 * 
 */
@Entity
@Table(name="mticketconsumo")
public class XTicketConsumo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String controle;

	private Timestamp data;

	private Timestamp datacadastro;

	private String numero;

	private String situacao;

	private BigDecimal valortotal;

	//bi-directional many-to-one association to Ccentrocusto
	@ManyToOne
	@JoinColumn(name="centrocustoid")
	private XCentroCusto centroCusto;

	//bi-directional many-to-one association to Cpessoa
	@ManyToOne
	@JoinColumn(name="fornecedorid")
	private XPessoa pessoa;

	//bi-directional many-to-one association to Cusuario
	@ManyToOne
	@JoinColumn(name="usuarioid")
	private XUsuario usuario;

	//bi-directional many-to-one association to Morcamento
	@ManyToOne
	@JoinColumn(name="propostacomercialid")
	private XOrcamento orcamento;

	//bi-directional many-to-one association to Mticketconsumoitem
	@OneToMany(mappedBy="ticketConsumo")
	private List<XTicketConsumoItem> ticketConsumoItens;

	public XTicketConsumo() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getControle() {
		return this.controle;
	}

	public void setControle(String controle) {
		this.controle = controle;
	}

	public Timestamp getData() {
		return this.data;
	}

	public void setData(Timestamp data) {
		this.data = data;
	}

	public Timestamp getDatacadastro() {
		return this.datacadastro;
	}

	public void setDatacadastro(Timestamp datacadastro) {
		this.datacadastro = datacadastro;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getSituacao() {
		return this.situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public BigDecimal getValortotal() {
		return this.valortotal;
	}

	public void setValortotal(BigDecimal valortotal) {
		this.valortotal = valortotal;
	}

	public XCentroCusto getCentrocusto() {
		return this.centroCusto;
	}

	public void setCentroCusto(XCentroCusto centroCusto) {
		this.centroCusto = centroCusto;
	}

	public XPessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(XPessoa pessoa) {
		this.pessoa = pessoa;
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

	public List<XTicketConsumoItem> getTicketConsumoItens() {
		return this.ticketConsumoItens;
	}

	public void setMticketconsumoitems(List<XTicketConsumoItem> ticketConsumoItens) {
		this.ticketConsumoItens = ticketConsumoItens;
	}

}