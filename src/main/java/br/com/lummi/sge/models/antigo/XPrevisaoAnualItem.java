package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the cprevisaoanualitem database table.
 * 
 */
@Entity
@Table(name="cprevisaoanualitem")
public class XPrevisaoAnualItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private BigDecimal abril;

	private BigDecimal agosto;

	private Integer centrocustoid;

	private BigDecimal dezembro;

	private BigDecimal fevereiro;

	private BigDecimal janeiro;

	private BigDecimal julho;

	private BigDecimal junho;

	private BigDecimal maio;

	private BigDecimal marco;

	private BigDecimal novembro;

	private BigDecimal outubro;

	private BigDecimal setembro;

	private BigDecimal valor;

	//bi-directional many-to-one association to Cprevisaoanual
	@ManyToOne
	@JoinColumn(name="previsaoanualid")
	private XPrevisaoAnual previsaoAnual;

	public XPrevisaoAnualItem() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getAbril() {
		return this.abril;
	}

	public void setAbril(BigDecimal abril) {
		this.abril = abril;
	}

	public BigDecimal getAgosto() {
		return this.agosto;
	}

	public void setAgosto(BigDecimal agosto) {
		this.agosto = agosto;
	}

	public Integer getCentrocustoid() {
		return this.centrocustoid;
	}

	public void setCentrocustoid(Integer centrocustoid) {
		this.centrocustoid = centrocustoid;
	}

	public BigDecimal getDezembro() {
		return this.dezembro;
	}

	public void setDezembro(BigDecimal dezembro) {
		this.dezembro = dezembro;
	}

	public BigDecimal getFevereiro() {
		return this.fevereiro;
	}

	public void setFevereiro(BigDecimal fevereiro) {
		this.fevereiro = fevereiro;
	}

	public BigDecimal getJaneiro() {
		return this.janeiro;
	}

	public void setJaneiro(BigDecimal janeiro) {
		this.janeiro = janeiro;
	}

	public BigDecimal getJulho() {
		return this.julho;
	}

	public void setJulho(BigDecimal julho) {
		this.julho = julho;
	}

	public BigDecimal getJunho() {
		return this.junho;
	}

	public void setJunho(BigDecimal junho) {
		this.junho = junho;
	}

	public BigDecimal getMaio() {
		return this.maio;
	}

	public void setMaio(BigDecimal maio) {
		this.maio = maio;
	}

	public BigDecimal getMarco() {
		return this.marco;
	}

	public void setMarco(BigDecimal marco) {
		this.marco = marco;
	}

	public BigDecimal getNovembro() {
		return this.novembro;
	}

	public void setNovembro(BigDecimal novembro) {
		this.novembro = novembro;
	}

	public BigDecimal getOutubro() {
		return this.outubro;
	}

	public void setOutubro(BigDecimal outubro) {
		this.outubro = outubro;
	}

	public BigDecimal getSetembro() {
		return this.setembro;
	}

	public void setSetembro(BigDecimal setembro) {
		this.setembro = setembro;
	}

	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public XPrevisaoAnual getPrevisaoAnual() {
		return this.previsaoAnual;
	}

	public void setPrevisaoAnual(XPrevisaoAnual previsaoAnual) {
		this.previsaoAnual = previsaoAnual;
	}

}