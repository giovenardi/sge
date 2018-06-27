package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cpessoaramoatividade database table.
 * 
 */
@Entity
@Table(name="cpessoaramoatividade")
public class XPessoaRamoAtividade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Integer referenciaid;

	//bi-directional many-to-one association to Cpessoa
	@ManyToOne
	@JoinColumn(name="pessoaid")
	private XPessoa pessoa;

	//bi-directional many-to-one association to Cramoatividade
	@ManyToOne
	@JoinColumn(name="ramoatividadeid")
	private XRamoAtividade ramoAtividade;

	public XPessoaRamoAtividade() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getReferenciaid() {
		return this.referenciaid;
	}

	public void setReferenciaid(Integer referenciaid) {
		this.referenciaid = referenciaid;
	}

	public XPessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(XPessoa pessoa) {
		this.pessoa = pessoa;
	}

	public XRamoAtividade getRamoAtividade() {
		return this.ramoAtividade;
	}

	public void setRamoAtividade(XRamoAtividade ramoAtividade) {
		this.ramoAtividade = ramoAtividade;
	}

}