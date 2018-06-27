package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the mbriefingrecurso database table.
 * 
 */
@Entity
@Table(name="mbriefingrecurso")
public class XBriefingRecurso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Timestamp datahora;

	private Boolean ehlayout;

	private Boolean ehtexto;

	private String especificacaotecninca;

	private Integer numeropecas;

	private String observacao;

	private String recurso;

	private String responsavelexterno;

	@Column(name="sim_nao")
	private String simNao;

	private String status;

	@ManyToOne
	@JoinColumn(name="criativoid")
	private XCriativo criativo;

	@ManyToOne
	@JoinColumn(name="briefingid")
	private XBriefing briefing;

	public XBriefingRecurso() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getDatahora() {
		return this.datahora;
	}

	public void setDatahora(Timestamp datahora) {
		this.datahora = datahora;
	}

	public Boolean getEhlayout() {
		return this.ehlayout;
	}

	public void setEhlayout(Boolean ehlayout) {
		this.ehlayout = ehlayout;
	}

	public Boolean getEhtexto() {
		return this.ehtexto;
	}

	public void setEhtexto(Boolean ehtexto) {
		this.ehtexto = ehtexto;
	}

	public String getEspecificacaotecninca() {
		return this.especificacaotecninca;
	}

	public void setEspecificacaotecninca(String especificacaotecninca) {
		this.especificacaotecninca = especificacaotecninca;
	}

	public Integer getNumeropecas() {
		return this.numeropecas;
	}

	public void setNumeropecas(Integer numeropecas) {
		this.numeropecas = numeropecas;
	}

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getRecurso() {
		return this.recurso;
	}

	public void setRecurso(String recurso) {
		this.recurso = recurso;
	}

	public String getResponsavelexterno() {
		return this.responsavelexterno;
	}

	public void setResponsavelexterno(String responsavelexterno) {
		this.responsavelexterno = responsavelexterno;
	}

	public String getSimNao() {
		return this.simNao;
	}

	public void setSimNao(String simNao) {
		this.simNao = simNao;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public XCriativo getCriativo() {
		return criativo;
	}

	public void setCriativo(XCriativo criativo) {
		this.criativo = criativo;
	}

	public XBriefing getBriefing() {
		return briefing;
	}

	public void setBriefing(XBriefing briefing) {
		this.briefing = briefing;
	}

}