package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;

import br.com.lummi.sge.models.ContaBancaria;

import java.util.List;


/**
 * The persistent class for the cbanco database table.
 * 
 */
@Entity
@Table(name="cbanco")
public class XBanco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name="conf_dataesquerda")
	private Integer confDataesquerda;

	@Column(name="conf_datatopo")
	private Integer confDatatopo;

	@Column(name="conf_extensoesquerda")
	private Integer confExtensoesquerda;

	@Column(name="conf_extensotopo")
	private Integer confExtensotopo;

	@Column(name="conf_margemdireita")
	private Integer confMargemdireita;

	@Column(name="conf_margemesquerda")
	private Integer confMargemesquerda;

	@Column(name="conf_margeminferior")
	private Integer confMargeminferior;

	@Column(name="conf_margemsuperior")
	private Integer confMargemsuperior;

	@Column(name="conf_nominalesquerda")
	private Integer confNominalesquerda;

	@Column(name="conf_nominaltopo")
	private Integer confNominaltopo;

	@Column(name="conf_valoresquerda")
	private Integer confValoresquerda;

	@Column(name="conf_valortopo")
	private Integer confValortopo;

	private String nome;

	private String numero;

	//bi-directional many-to-one association to Ccontabancaria
	@OneToMany(mappedBy="banco")
	private List<ContaBancaria> contasBancarias;

	//bi-directional many-to-one association to Gcurriculo
	@OneToMany(mappedBy="banco")
	private List<XCurriculo> curriculos;

	public XBanco() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getConfDataesquerda() {
		return this.confDataesquerda;
	}

	public void setConfDataesquerda(Integer confDataesquerda) {
		this.confDataesquerda = confDataesquerda;
	}

	public Integer getConfDatatopo() {
		return this.confDatatopo;
	}

	public void setConfDatatopo(Integer confDatatopo) {
		this.confDatatopo = confDatatopo;
	}

	public Integer getConfExtensoesquerda() {
		return this.confExtensoesquerda;
	}

	public void setConfExtensoesquerda(Integer confExtensoesquerda) {
		this.confExtensoesquerda = confExtensoesquerda;
	}

	public Integer getConfExtensotopo() {
		return this.confExtensotopo;
	}

	public void setConfExtensotopo(Integer confExtensotopo) {
		this.confExtensotopo = confExtensotopo;
	}

	public Integer getConfMargemdireita() {
		return this.confMargemdireita;
	}

	public void setConfMargemdireita(Integer confMargemdireita) {
		this.confMargemdireita = confMargemdireita;
	}

	public Integer getConfMargemesquerda() {
		return this.confMargemesquerda;
	}

	public void setConfMargemesquerda(Integer confMargemesquerda) {
		this.confMargemesquerda = confMargemesquerda;
	}

	public Integer getConfMargeminferior() {
		return this.confMargeminferior;
	}

	public void setConfMargeminferior(Integer confMargeminferior) {
		this.confMargeminferior = confMargeminferior;
	}

	public Integer getConfMargemsuperior() {
		return this.confMargemsuperior;
	}

	public void setConfMargemsuperior(Integer confMargemsuperior) {
		this.confMargemsuperior = confMargemsuperior;
	}

	public Integer getConfNominalesquerda() {
		return this.confNominalesquerda;
	}

	public void setConfNominalesquerda(Integer confNominalesquerda) {
		this.confNominalesquerda = confNominalesquerda;
	}

	public Integer getConfNominaltopo() {
		return this.confNominaltopo;
	}

	public void setConfNominaltopo(Integer confNominaltopo) {
		this.confNominaltopo = confNominaltopo;
	}

	public Integer getConfValoresquerda() {
		return this.confValoresquerda;
	}

	public void setConfValoresquerda(Integer confValoresquerda) {
		this.confValoresquerda = confValoresquerda;
	}

	public Integer getConfValortopo() {
		return this.confValortopo;
	}

	public void setConfValortopo(Integer confValortopo) {
		this.confValortopo = confValortopo;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public List<ContaBancaria> getContasBancarias() {
		return this.contasBancarias;
	}

	public void setCcontabancarias(List<ContaBancaria> contasBancarias) {
		this.contasBancarias = contasBancarias;
	}

	public List<XCurriculo> getCurriculos() {
		return curriculos;
	}

	public void setCurriculos(List<XCurriculo> curriculos) {
		this.curriculos = curriculos;
	}

	public void setContasBancarias(List<ContaBancaria> contasBancarias) {
		this.contasBancarias = contasBancarias;
	}


}