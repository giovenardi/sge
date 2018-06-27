package br.com.lummi.sge.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The persistent class for the cbanco database table.
 * 
 */
@Entity
@Table(name="configuracao_cobranca")
public class ConfiguracaoCobranca implements Entidade {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name="conf_data_esquerda")
	private Integer confDataEsquerda;

	@Column(name="conf_data_topo")
	private Integer confDataTopo;

	@Column(name="conf_extenso_esquerda")
	private Integer confExtensoEsquerda;

	@Column(name="conf_extenso_topo")
	private Integer confExtensoTopo;

	@Column(name="conf_margem_direita")
	private Integer confMargemDireita;

	@Column(name="conf_margem_esquerda")
	private Integer confMargemEsquerda;

	@Column(name="conf_margem_inferior")
	private Integer confMargemInferior;

	@Column(name="conf_margem_superior")
	private Integer confMargemSuperior;

	@Column(name="conf_nominal_esquerda")
	private Integer confNominalEsquerda;

	@Column(name="conf_nominal_topo")
	private Integer confNominalTopo;

	@Column(name="conf_valor_esquerda")
	private Integer confValorEsquerda;

	@Column(name="conf_valor_topo")
	private Integer confValorTSopo;

	public ConfiguracaoCobranca() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getConfDataEsquerda() {
		return confDataEsquerda;
	}

	public void setConfDataEsquerda(Integer confDataEsquerda) {
		this.confDataEsquerda = confDataEsquerda;
	}

	public Integer getConfDataTopo() {
		return confDataTopo;
	}

	public void setConfDataTopo(Integer confDataTopo) {
		this.confDataTopo = confDataTopo;
	}

	public Integer getConfExtensoEsquerda() {
		return confExtensoEsquerda;
	}

	public void setConfExtensoEsquerda(Integer confExtensoEsquerda) {
		this.confExtensoEsquerda = confExtensoEsquerda;
	}

	public Integer getConfExtensoTopo() {
		return confExtensoTopo;
	}

	public void setConfExtensoTopo(Integer confExtensoTopo) {
		this.confExtensoTopo = confExtensoTopo;
	}

	public Integer getConfMargemDireita() {
		return confMargemDireita;
	}

	public void setConfMargemDireita(Integer confMargemDireita) {
		this.confMargemDireita = confMargemDireita;
	}

	public Integer getConfMargemEsquerda() {
		return confMargemEsquerda;
	}

	public void setConfMargemEsquerda(Integer confMargemEsquerda) {
		this.confMargemEsquerda = confMargemEsquerda;
	}

	public Integer getConfMargemInferior() {
		return confMargemInferior;
	}

	public void setConfMargemInferior(Integer confMargemInferior) {
		this.confMargemInferior = confMargemInferior;
	}

	public Integer getConfMargemSuperior() {
		return confMargemSuperior;
	}

	public void setConfMargemSuperior(Integer confMargemSuperior) {
		this.confMargemSuperior = confMargemSuperior;
	}

	public Integer getConfNominalEsquerda() {
		return confNominalEsquerda;
	}

	public void setConfNominalEsquerda(Integer confNominalEsquerda) {
		this.confNominalEsquerda = confNominalEsquerda;
	}

	public Integer getConfNominalTopo() {
		return confNominalTopo;
	}

	public void setConfNominalTopo(Integer confNominalTopo) {
		this.confNominalTopo = confNominalTopo;
	}

	public Integer getConfValorEsquerda() {
		return confValorEsquerda;
	}

	public void setConfValorEsquerda(Integer confValorEsquerda) {
		this.confValorEsquerda = confValorEsquerda;
	}

	public Integer getConfValorTSopo() {
		return confValorTSopo;
	}

	public void setConfValorTSopo(Integer confValorTSopo) {
		this.confValorTSopo = confValorTSopo;
	}


}