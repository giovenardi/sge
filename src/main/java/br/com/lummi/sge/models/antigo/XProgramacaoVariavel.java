package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the gprogramacaovariavel database table.
 * 
 */
@Entity
@Table(name="gprogramacaovariavel")
public class XProgramacaoVariavel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String ano;

	@Temporal(TemporalType.DATE)
	private Date dataref;

	private String descricao;

	private Integer diavencimento;

	private Integer item;

	private String mes;

	private BigDecimal valor;

	@ManyToOne
	@JoinColumn(name="centrocustoid")
	private XCentroCusto centroCusto;

	@ManyToOne
	@JoinColumn(name="fornecedorid")
	private XPessoa fornecedor;

	public XProgramacaoVariavel() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public Date getDataref() {
		return dataref;
	}

	public void setDataref(Date dataref) {
		this.dataref = dataref;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getDiavencimento() {
		return diavencimento;
	}

	public void setDiavencimento(Integer diavencimento) {
		this.diavencimento = diavencimento;
	}

	public Integer getItem() {
		return item;
	}

	public void setItem(Integer item) {
		this.item = item;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public XCentroCusto getCentroCusto() {
		return centroCusto;
	}

	public void setCentroCusto(XCentroCusto centroCusto) {
		this.centroCusto = centroCusto;
	}

	public XPessoa getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(XPessoa fornecedor) {
		this.fornecedor = fornecedor;
	}

}