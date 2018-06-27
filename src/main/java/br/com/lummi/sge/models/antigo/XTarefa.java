package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ctarefa database table.
 * 
 */
@Entity
@Table(name="ctarefa")
public class XTarefa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String codigo;

	private String nome;

	private Integer quantidadeartefinal;

	private Integer quantidadecriacao;

	private String tipo;

	//bi-directional many-to-one association to Mjobtarefa
	@OneToMany(mappedBy="tarefa")
	private List<XJobTarefa> jobTarefas;

	//bi-directional many-to-one association to Mtarefaindependente
	@OneToMany(mappedBy="tarefa")
	private List<XTarefaIndependente> tarefasIndependentes;

	public XTarefa() {
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

	public Integer getQuantidadeartefinal() {
		return this.quantidadeartefinal;
	}

	public void setQuantidadeartefinal(Integer quantidadeartefinal) {
		this.quantidadeartefinal = quantidadeartefinal;
	}

	public Integer getQuantidadecriacao() {
		return this.quantidadecriacao;
	}

	public void setQuantidadecriacao(Integer quantidadecriacao) {
		this.quantidadecriacao = quantidadecriacao;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<XJobTarefa> getJobtarefas() {
		return this.jobTarefas;
	}

	public void setJobtarefas(List<XJobTarefa> jobTarefas) {
		this.jobTarefas = jobTarefas;
	}

	public List<XTarefaIndependente> getTarefasIndependentes() {
		return this.tarefasIndependentes;
	}

	public void setTarefasIndependentes(List<XTarefaIndependente> tarefasIndependentes) {
		this.tarefasIndependentes = tarefasIndependentes;
	}

}