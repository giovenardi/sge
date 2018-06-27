package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cgrupofatordesempenho database table.
 * 
 */
@Entity
@Table(name="cgrupofatordesempenho")
public class XGrupoFatorDesempenho implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String nome;

	private Integer ordem;

	//bi-directional many-to-one association to Citemfatordesempenho
	@OneToMany(mappedBy="grupoFatorDesempenho")
	private List<XItemFatorDesempenho> itensFatorDesempenho;

	public XGrupoFatorDesempenho() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getOrdem() {
		return this.ordem;
	}

	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}

	public List<XItemFatorDesempenho> getItensFatorDesempenho() {
		return this.itensFatorDesempenho;
	}

	public void setCitemfatordesempenhos(List<XItemFatorDesempenho> itensFatorDesempenho) {
		this.itensFatorDesempenho = itensFatorDesempenho;
	}

}