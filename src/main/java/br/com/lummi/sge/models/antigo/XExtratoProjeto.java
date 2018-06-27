package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the mextratoprojeto database table.
 * 
 */
@Entity
@Table(name="mextratoprojeto")
public class XExtratoProjeto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String categoria;

	private String codigo;

	private Timestamp datahora;

	private String historico;

	private String operacao;

	private String origem;

	private BigDecimal valorcredito;

	private BigDecimal valordebito;

	@ManyToOne
	@JoinColumn(name="projetoid")
	private XProjeto projeto;

	public XExtratoProjeto() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategoria() {
		return this.categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Timestamp getDatahora() {
		return this.datahora;
	}

	public void setDatahora(Timestamp datahora) {
		this.datahora = datahora;
	}

	public String getHistorico() {
		return this.historico;
	}

	public void setHistorico(String historico) {
		this.historico = historico;
	}

	public String getOperacao() {
		return this.operacao;
	}

	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}

	public String getOrigem() {
		return this.origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public BigDecimal getValorcredito() {
		return this.valorcredito;
	}

	public void setValorcredito(BigDecimal valorcredito) {
		this.valorcredito = valorcredito;
	}

	public BigDecimal getValordebito() {
		return this.valordebito;
	}

	public void setValordebito(BigDecimal valordebito) {
		this.valordebito = valordebito;
	}

	public XProjeto getProjeto() {
		return projeto;
	}

	public void setProjeto(XProjeto projeto) {
		this.projeto = projeto;
	}

}