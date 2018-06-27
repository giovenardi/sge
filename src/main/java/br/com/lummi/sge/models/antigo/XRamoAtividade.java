package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cramoatividade database table.
 * 
 */
@Entity
@Table(name="cramoatividade")
public class XRamoAtividade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String codigo;

	private String nome;

	private Integer referenciaid;

	//bi-directional many-to-one association to Cpessoaramoatividade
	@OneToMany(mappedBy="ramoAtividade")
	private List<XPessoaRamoAtividade> pessoaRamoAtividades;

	public XRamoAtividade() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getReferenciaid() {
		return this.referenciaid;
	}

	public void setReferenciaid(Integer referenciaid) {
		this.referenciaid = referenciaid;
	}

	public List<XPessoaRamoAtividade> getPessoaRamoAtividades() {
		return this.pessoaRamoAtividades;
	}

	public void setPessoaRamoAtividades(List<XPessoaRamoAtividade> pessoaRamoAtividades) {
		this.pessoaRamoAtividades = pessoaRamoAtividades;
	}

}