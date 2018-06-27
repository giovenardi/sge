package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the mcheque database table.
 * 
 */
@Entity
@Table(name="mcheque")
public class XCheque implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String assinadopor;

	private Timestamp bompara;

	private String codigo;

	private Timestamp datacadastro;

	private Timestamp emissao;

	private String nominal;

	private String numero;

	private String opcao;

	private String utilizadopara;

	private BigDecimal valor;

	@ManyToOne
	@JoinColumn(name="contafinanceiraid")
	private XContaFinanceira contaFinanceira;

	@ManyToOne
	@JoinColumn(name="usuarioid")
	private XUsuario usuario;

	public XCheque() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAssinadopor() {
		return this.assinadopor;
	}

	public void setAssinadopor(String assinadopor) {
		this.assinadopor = assinadopor;
	}

	public Timestamp getBompara() {
		return this.bompara;
	}

	public void setBompara(Timestamp bompara) {
		this.bompara = bompara;
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

	public String getNominal() {
		return this.nominal;
	}

	public void setNominal(String nominal) {
		this.nominal = nominal;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getOpcao() {
		return this.opcao;
	}

	public void setOpcao(String opcao) {
		this.opcao = opcao;
	}

	public String getUtilizadopara() {
		return this.utilizadopara;
	}

	public void setUtilizadopara(String utilizadopara) {
		this.utilizadopara = utilizadopara;
	}

	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public XContaFinanceira getContaFinanceira() {
		return contaFinanceira;
	}

	public void setContaFinanceira(XContaFinanceira contaFinanceira) {
		this.contaFinanceira = contaFinanceira;
	}

	public XUsuario getUsuario() {
		return usuario;
	}

	public void setUsuario(XUsuario usuario) {
		this.usuario = usuario;
	}

}