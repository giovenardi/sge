package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ccentroresultado database table.
 * 
 */
@Entity
@Table(name="ccentroresultado")
public class XCentroResultado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String codigo;

	private String nome;

	private String xxx;

	@OneToMany(mappedBy="centroResultado")
	private List<XContaPagar> contasPagar;

	@OneToMany(mappedBy="centroResultado")
	private List<XContaPagarRateio> contaPagarRateios;

	@OneToMany(mappedBy="centroResultado")
	private List<XContaReceber> contasReceber;

	@OneToMany(mappedBy="centroResultado")
	private List<XContaReceberRateio> contaReceberRateios;

	@OneToMany(mappedBy="centroResultado")
	private List<XCursoAluno> cursoAlunos;

	@OneToMany(mappedBy="centroResultado")
	private List<XJobTarefa> jobTarefas;

	@OneToMany(mappedBy="centroResultado")
	private List<XProjeto> projetos;

	@OneToMany(mappedBy="centroResultado")
	private List<XReembolso> reembolsos;

	@OneToMany(mappedBy="centroResultado")
	private List<XReembolsoDespesa> reembolsosDespesa;

	@OneToMany(mappedBy="centroResultado")
	private List<XTarefaIndependente> tarefasIndependentes;

	public XCentroResultado() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getXxx() {
		return xxx;
	}

	public void setXxx(String xxx) {
		this.xxx = xxx;
	}

	public List<XContaPagar> getContasPagar() {
		return contasPagar;
	}

	public void setContasPagar(List<XContaPagar> contasPagar) {
		this.contasPagar = contasPagar;
	}

	public List<XContaPagarRateio> getContaPagarRateios() {
		return contaPagarRateios;
	}

	public void setContaPagarRateios(List<XContaPagarRateio> contaPagarRateios) {
		this.contaPagarRateios = contaPagarRateios;
	}

	public List<XContaReceber> getContasReceber() {
		return contasReceber;
	}

	public void setContasReceber(List<XContaReceber> contasReceber) {
		this.contasReceber = contasReceber;
	}

	public List<XContaReceberRateio> getContaReceberRateios() {
		return contaReceberRateios;
	}

	public void setContaReceberRateios(List<XContaReceberRateio> contaReceberRateios) {
		this.contaReceberRateios = contaReceberRateios;
	}

	public List<XCursoAluno> getCursoAlunos() {
		return cursoAlunos;
	}

	public void setCursoAlunos(List<XCursoAluno> cursoAlunos) {
		this.cursoAlunos = cursoAlunos;
	}

	public List<XJobTarefa> getJobTarefas() {
		return jobTarefas;
	}

	public void setJobTarefas(List<XJobTarefa> jobTarefas) {
		this.jobTarefas = jobTarefas;
	}

	public List<XProjeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<XProjeto> projetos) {
		this.projetos = projetos;
	}

	public List<XReembolso> getReembolsos() {
		return reembolsos;
	}

	public void setReembolsos(List<XReembolso> reembolsos) {
		this.reembolsos = reembolsos;
	}

	public List<XReembolsoDespesa> getReembolsosDespesa() {
		return reembolsosDespesa;
	}

	public void setReembolsosDespesa(List<XReembolsoDespesa> reembolsosDespesa) {
		this.reembolsosDespesa = reembolsosDespesa;
	}

	public List<XTarefaIndependente> getTarefasIndependentes() {
		return tarefasIndependentes;
	}

	public void setTarefasIndependentes(List<XTarefaIndependente> tarefasIndependentes) {
		this.tarefasIndependentes = tarefasIndependentes;
	}

}