package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the gatualizacaodivida database table.
 * 
 */
@Entity
@Table(name="gatualizacaodivida")
public class XAtualizacaoDivida implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal atraso;

	private BigDecimal cartorio1;

	private BigDecimal cartorio2;

	private String codigo;

	private String codigounico;

	private Timestamp emissao;

	private String historico;
	
	@Id
	private Integer id;

	private BigDecimal juros;

	private String origem;

	private BigDecimal outrastaxa;

	private BigDecimal taxajurosmes;

	private BigDecimal valoratualizado;

	private BigDecimal valortotal;

	private Timestamp vencimento;

	public XAtualizacaoDivida() {
	}

	public BigDecimal getAtraso() {
		return this.atraso;
	}

	public void setAtraso(BigDecimal atraso) {
		this.atraso = atraso;
	}

	public BigDecimal getCartorio1() {
		return this.cartorio1;
	}

	public void setCartorio1(BigDecimal cartorio1) {
		this.cartorio1 = cartorio1;
	}

	public BigDecimal getCartorio2() {
		return this.cartorio2;
	}

	public void setCartorio2(BigDecimal cartorio2) {
		this.cartorio2 = cartorio2;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigounico() {
		return this.codigounico;
	}

	public void setCodigounico(String codigounico) {
		this.codigounico = codigounico;
	}

	public Timestamp getEmissao() {
		return this.emissao;
	}

	public void setEmissao(Timestamp emissao) {
		this.emissao = emissao;
	}

	public String getHistorico() {
		return this.historico;
	}

	public void setHistorico(String historico) {
		this.historico = historico;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getJuros() {
		return this.juros;
	}

	public void setJuros(BigDecimal juros) {
		this.juros = juros;
	}

	public String getOrigem() {
		return this.origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public BigDecimal getOutrastaxa() {
		return this.outrastaxa;
	}

	public void setOutrastaxa(BigDecimal outrastaxa) {
		this.outrastaxa = outrastaxa;
	}

	public BigDecimal getTaxajurosmes() {
		return this.taxajurosmes;
	}

	public void setTaxajurosmes(BigDecimal taxajurosmes) {
		this.taxajurosmes = taxajurosmes;
	}

	public BigDecimal getValoratualizado() {
		return this.valoratualizado;
	}

	public void setValoratualizado(BigDecimal valoratualizado) {
		this.valoratualizado = valoratualizado;
	}

	public BigDecimal getValortotal() {
		return this.valortotal;
	}

	public void setValortotal(BigDecimal valortotal) {
		this.valortotal = valortotal;
	}

	public Timestamp getVencimento() {
		return this.vencimento;
	}

	public void setVencimento(Timestamp vencimento) {
		this.vencimento = vencimento;
	}

}