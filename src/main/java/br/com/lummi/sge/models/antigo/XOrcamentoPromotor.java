package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the morcamentopromotor database table.
 * 
 */
@Entity
@Table(name="morcamentopromotor")
public class XOrcamentoPromotor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Timestamp datainicio;

	private Timestamp datatermino;

	private String descricao;

	private BigDecimal duracao;

	private String item;

	private BigDecimal valoradiantado;

	private BigDecimal valorliquido;

	private BigDecimal valortotal;

	private BigDecimal valorunitario;

	@ManyToOne
	@JoinColumn(name="pessoaid")
	private XPessoa pessoa;

	@ManyToOne
	@JoinColumn(name="orcamentoid")
	private XOrcamento orcamento;

	public XOrcamentoPromotor() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getDatainicio() {
		return this.datainicio;
	}

	public void setDatainicio(Timestamp datainicio) {
		this.datainicio = datainicio;
	}

	public Timestamp getDatatermino() {
		return this.datatermino;
	}

	public void setDatatermino(Timestamp datatermino) {
		this.datatermino = datatermino;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getDuracao() {
		return this.duracao;
	}

	public void setDuracao(BigDecimal duracao) {
		this.duracao = duracao;
	}

	public String getItem() {
		return this.item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public BigDecimal getValoradiantado() {
		return this.valoradiantado;
	}

	public void setValoradiantado(BigDecimal valoradiantado) {
		this.valoradiantado = valoradiantado;
	}

	public BigDecimal getValorliquido() {
		return this.valorliquido;
	}

	public void setValorliquido(BigDecimal valorliquido) {
		this.valorliquido = valorliquido;
	}

	public BigDecimal getValortotal() {
		return this.valortotal;
	}

	public void setValortotal(BigDecimal valortotal) {
		this.valortotal = valortotal;
	}

	public BigDecimal getValorunitario() {
		return this.valorunitario;
	}

	public void setValorunitario(BigDecimal valorunitario) {
		this.valorunitario = valorunitario;
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