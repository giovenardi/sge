package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the cregraimposto database table.
 * 
 */
@Entity
@Table(name="cregraimposto")
public class XRegraImposto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Boolean ativo;

	private BigDecimal cofins;

	private BigDecimal ctsocial;

	private BigDecimal fatorconversao;

	private BigDecimal fatorinss;

	private BigDecimal inss;

	private BigDecimal irpj;

	private BigDecimal iss;

	private String nome;

	private BigDecimal pis;

	private BigDecimal simples;

	//bi-directional many-to-one association to Mnotadebito
	@OneToMany(mappedBy="regraImposto")
	private List<XNotaDebito> notasDebito;

	//bi-directional many-to-one association to Mnotafiscal
	@OneToMany(mappedBy="regraImposto")
	private List<XNotaFiscal> notasFiscais;

	//bi-directional many-to-one association to Morcamento
	@OneToMany(mappedBy="regraImposto")
	private List<XOrcamento> orcamentos;

	public XRegraImposto() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getAtivo() {
		return this.ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public BigDecimal getCofins() {
		return this.cofins;
	}

	public void setCofins(BigDecimal cofins) {
		this.cofins = cofins;
	}

	public BigDecimal getCtsocial() {
		return this.ctsocial;
	}

	public void setCtsocial(BigDecimal ctsocial) {
		this.ctsocial = ctsocial;
	}

	public BigDecimal getFatorconversao() {
		return this.fatorconversao;
	}

	public void setFatorconversao(BigDecimal fatorconversao) {
		this.fatorconversao = fatorconversao;
	}

	public BigDecimal getFatorinss() {
		return this.fatorinss;
	}

	public void setFatorinss(BigDecimal fatorinss) {
		this.fatorinss = fatorinss;
	}

	public BigDecimal getInss() {
		return this.inss;
	}

	public void setInss(BigDecimal inss) {
		this.inss = inss;
	}

	public BigDecimal getIrpj() {
		return this.irpj;
	}

	public void setIrpj(BigDecimal irpj) {
		this.irpj = irpj;
	}

	public BigDecimal getIss() {
		return this.iss;
	}

	public void setIss(BigDecimal iss) {
		this.iss = iss;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPis() {
		return this.pis;
	}

	public void setPis(BigDecimal pis) {
		this.pis = pis;
	}

	public BigDecimal getSimples() {
		return this.simples;
	}

	public void setSimples(BigDecimal simples) {
		this.simples = simples;
	}

	public List<XNotaDebito> getNotasDebito() {
		return notasDebito;
	}

	public void setNotasDebito(List<XNotaDebito> notasDebito) {
		this.notasDebito = notasDebito;
	}

	public List<XNotaFiscal> getNotasFiscais() {
		return notasFiscais;
	}

	public void setNotasFiscais(List<XNotaFiscal> notasFiscais) {
		this.notasFiscais = notasFiscais;
	}

	public List<XOrcamento> getOrcamentos() {
		return this.orcamentos;
	}

	public void setOrcamentos(List<XOrcamento> orcamentos) {
		this.orcamentos = orcamentos;
	}

}