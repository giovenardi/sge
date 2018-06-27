package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the csetor database table.
 * 
 */
@Entity
@Table(name="csetor")
public class XSetor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String nome;

	private String sigla;

	//bi-directional many-to-one association to Mjobtarefa
	@OneToMany(mappedBy="setor")
	private List<XJobTarefa> jobTarefas;

	//bi-directional many-to-one association to Morcamentoconsumohora
	@OneToMany(mappedBy="setor")
	private List<XOrcamentoConsumoHora> orcamentoConsumoHoras;

	//bi-directional many-to-one association to Mtarefaindependente
	@OneToMany(mappedBy="setor")
	private List<XTarefaIndependente> tarefasIndependentes;

	public XSetor() {
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

	public String getSigla() {
		return this.sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public List<XJobTarefa> getJobTarefas() {
		return this.jobTarefas;
	}

	public void setJobTarefas(List<XJobTarefa> jobTarefas) {
		this.jobTarefas = jobTarefas;
	}

	public List<XOrcamentoConsumoHora> getOrcamentoConsumoHoras() {
		return this.orcamentoConsumoHoras;
	}

	public void setMorcamentoconsumohoras(List<XOrcamentoConsumoHora> orcamentoConsumoHoras) {
		this.orcamentoConsumoHoras = orcamentoConsumoHoras;
	}

	public List<XTarefaIndependente> getTarefasIndependentes() {
		return this.tarefasIndependentes;
	}

	public void setTarefasIndependentes(List<XTarefaIndependente> tarefasIndependentes) {
		this.tarefasIndependentes = tarefasIndependentes;
	}

}