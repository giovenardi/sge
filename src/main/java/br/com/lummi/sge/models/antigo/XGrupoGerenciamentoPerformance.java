package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cgrupogerenciamentoperformance database table.
 * 
 */
@Entity
@Table(name="cgrupogerenciamentoperformance")
public class XGrupoGerenciamentoPerformance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String nome;

	private Integer ordem;

	//bi-directional many-to-one association to Citemgerenciamentoperformance
	@OneToMany(mappedBy="grupoGerenciamentoPerformance")
	private List<XItemGerenciamentoPerformance> itemGerenciamentoPerformances;

	public XGrupoGerenciamentoPerformance() {
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

	public List<XItemGerenciamentoPerformance> getItemGerenciamentoPerformances() {
		return itemGerenciamentoPerformances;
	}

	public void setItemGerenciamentoPerformances(List<XItemGerenciamentoPerformance> itemGerenciamentoPerformances) {
		this.itemGerenciamentoPerformances = itemGerenciamentoPerformances;
	}


}