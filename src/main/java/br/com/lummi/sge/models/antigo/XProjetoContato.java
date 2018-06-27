package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the mprojetocontato database table.
 * 
 */
@Entity
@Table(name="mprojetocontato")
public class XProjetoContato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String curso;

	private Timestamp data;

	private String email;

	private String instituicaoensino;

	private String item;

	private String nome;

	private String observacao;

	private String periodo;

	private Integer quantidadealunos;

	private Integer quantidadeinteressado;

	private String semestre;

	private String telefone;

	@ManyToOne
	@JoinColumn(name="formacontatoid")
	private XFormaContato formaContato;

	@ManyToOne
	@JoinColumn(name="projetoid")
	private XProjeto projeto;

	public XProjetoContato() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCurso() {
		return this.curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public Timestamp getData() {
		return this.data;
	}

	public void setData(Timestamp data) {
		this.data = data;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInstituicaoensino() {
		return this.instituicaoensino;
	}

	public void setInstituicaoensino(String instituicaoensino) {
		this.instituicaoensino = instituicaoensino;
	}

	public String getItem() {
		return this.item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getPeriodo() {
		return this.periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public Integer getQuantidadealunos() {
		return this.quantidadealunos;
	}

	public void setQuantidadealunos(Integer quantidadealunos) {
		this.quantidadealunos = quantidadealunos;
	}

	public Integer getQuantidadeinteressado() {
		return this.quantidadeinteressado;
	}

	public void setQuantidadeinteressado(Integer quantidadeinteressado) {
		this.quantidadeinteressado = quantidadeinteressado;
	}

	public String getSemestre() {
		return this.semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public XFormaContato getFormaContato() {
		return formaContato;
	}

	public void setFormaContato(XFormaContato formaContato) {
		this.formaContato = formaContato;
	}

	public XProjeto getProjeto() {
		return projeto;
	}

	public void setProjeto(XProjeto projeto) {
		this.projeto = projeto;
	}

}