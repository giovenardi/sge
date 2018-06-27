package br.com.lummi.sge.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@MappedSuperclass
public abstract class ProjetoFormatura extends Projeto {

	private static final long serialVersionUID = -5113365624868494406L;

	@Column(name = "numero")
	private Integer numero;

	@Column(name = "numero_convites_luxo")
	private Integer numeroConvitesLuxo;

	@Column(name = "numero_convites_semiluxo")
	private Integer numeroConvitesSemiluxo;

	@Column(name = "numero_convites_simples")
	private Integer numeroConvitesSimples;

	@Column(name = "numero_convites_online")
	private Integer numeroConvitesOnline;

	@Column(name = "meta_formandos")
	private Integer metaFormandos;

	@Column(name = "valor_ingresso_extra")
	private Double valorIngressoExtra;

	@Column(name = "limite_compra_ingresso_extra")
	private Date limiteCompraIngressoExtra;

	@Column(name = "valor_convite_extra")
	private Double valorConviteExtra;

	@Column(name = "limite_compra_convite_extra")
	private Date limiteCompraConviteExtra;

	@Column(name = "valor_porta_retrato_extra")
	private Double valorPortaRetratoExtra;

	@Column(name = "limite_compra_porta_retrato_extra")
	private Date limiteCompraPortaRetratoExtra;

	@Column(name = "valor_havaiana_extra")
	private Double valorHavaianaExtra;

	@Column(name = "limite_compra_havaiana_extra")
	private Date limiteCompraHavaianaExtra;

	@ManyToOne
	@JoinColumn(name = "comissao_formatura_id")
	private ComissaoFormatura comissaoFormatura;

	@ManyToOne
	@JoinColumn(name = "orcamento_id")
	private Orcamento orcamento;

	@OneToMany(mappedBy = "projeto")
	private List<Turma> turmas;

	@Transient
	private List<Formando> formandos;

	public ProjetoFormatura() {
		super();
	}

	public Integer getNumeroConvitesLuxo() {
		return numeroConvitesLuxo;
	}

	public void setNumeroConvitesLuxo(Integer numeroConvitesLuxo) {
		this.numeroConvitesLuxo = numeroConvitesLuxo;
	}

	public Integer getNumeroConvitesSemiluxo() {
		return numeroConvitesSemiluxo;
	}

	public void setNumeroConvitesSemiluxo(Integer numeroConvitesSemiluxo) {
		this.numeroConvitesSemiluxo = numeroConvitesSemiluxo;
	}

	public Integer getNumeroConvitesSimples() {
		return numeroConvitesSimples;
	}

	public void setNumeroConvitesSimples(Integer numeroConvitesSimples) {
		this.numeroConvitesSimples = numeroConvitesSimples;
	}

	public Integer getNumeroConvitesOnline() {
		return numeroConvitesOnline;
	}

	public void setNumeroConvitesOnline(Integer numeroConvitesOnline) {
		this.numeroConvitesOnline = numeroConvitesOnline;
	}

	public Integer getMetaFormandos() {
		return metaFormandos;
	}

	public void setMetaFormandos(Integer metaFormandos) {
		this.metaFormandos = metaFormandos;
	}

	public Double getValorIngressoExtra() {
		return valorIngressoExtra;
	}

	public void setValorIngressoExtra(Double valorIngressoExtra) {
		this.valorIngressoExtra = valorIngressoExtra;
	}

	public Date getLimiteCompraIngressoExtra() {
		return limiteCompraIngressoExtra;
	}

	public void setLimiteCompraIngressoExtra(Date limiteCompraIngressoExtra) {
		this.limiteCompraIngressoExtra = limiteCompraIngressoExtra;
	}

	public Double getValorConviteExtra() {
		return valorConviteExtra;
	}

	public void setValorConviteExtra(Double valorConviteExtra) {
		this.valorConviteExtra = valorConviteExtra;
	}

	public Date getLimiteCompraConviteExtra() {
		return limiteCompraConviteExtra;
	}

	public void setLimiteCompraConviteExtra(Date limiteCompraConviteExtra) {
		this.limiteCompraConviteExtra = limiteCompraConviteExtra;
	}

	public Double getValorPortaRetratoExtra() {
		return valorPortaRetratoExtra;
	}

	public void setValorPortaRetratoExtra(Double valorPortaRetratoExtra) {
		this.valorPortaRetratoExtra = valorPortaRetratoExtra;
	}

	public Date getLimiteCompraPortaRetratoExtra() {
		return limiteCompraPortaRetratoExtra;
	}

	public void setLimiteCompraPortaRetratoExtra(Date limiteCompraPortaRetratoExtra) {
		this.limiteCompraPortaRetratoExtra = limiteCompraPortaRetratoExtra;
	}

	public Double getValorHavaianaExtra() {
		return valorHavaianaExtra;
	}

	public void setValorHavaianaExtra(Double valorHavaianaExtra) {
		this.valorHavaianaExtra = valorHavaianaExtra;
	}

	public Date getLimiteCompraHavaianaExtra() {
		return limiteCompraHavaianaExtra;
	}

	public void setLimiteCompraHavaianaExtra(Date limiteCompraHavaianaExtra) {
		this.limiteCompraHavaianaExtra = limiteCompraHavaianaExtra;
	}

	public ComissaoFormatura getComissaoFormatura() {
		return comissaoFormatura;
	}

	public void setComissaoFormatura(ComissaoFormatura comissaoFormatura) {
		this.comissaoFormatura = comissaoFormatura;
	}

	public Orcamento getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(Orcamento orcamento) {
		this.orcamento = orcamento;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public List<Formando> getFormandos() {
		return formandos;
	}

	public void setFormandos(List<Formando> formandos) {
		this.formandos = formandos;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

}