package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the mprojetocurso database table.
 * 
 */
@Entity
@Table(name="mprojetocurso")
public class XProjetoCurso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String abreviatura;

	private String ano;

	private String item;

	private String nome;

	private String registrocurso;
	
	private String turma;
	
	@OneToMany(mappedBy="projetoCurso")
	private List<XAtaReuniao> atasReunioes;
	
	@OneToMany(mappedBy="projetoCurso")
	private List<XCursoAluno> cursosAlunos;
	
	@ManyToOne
	@JoinColumn(name="cursoid")
	private XCurso curso;
	
	@ManyToOne
	@JoinColumn(name="instituicaoid")
	private XInstituicao instituicao;
	
	@ManyToOne
	@JoinColumn(name="localizacaoid")
	private XLocalizacao localizacao;
	
	@ManyToOne
	@JoinColumn(name="semestreid")
	private XSemestre semestre;
	
	@ManyToOne
	@JoinColumn(name="turnoid")
	private XTurno turno;
	
	@ManyToOne
	@JoinColumn(name="projetoid")
	private XProjeto projeto;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAbreviatura() {
		return abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRegistrocurso() {
		return registrocurso;
	}

	public void setRegistrocurso(String registrocurso) {
		this.registrocurso = registrocurso;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public List<XAtaReuniao> getAtasReunioes() {
		return atasReunioes;
	}

	public void setAtasReunioes(List<XAtaReuniao> atasReunioes) {
		this.atasReunioes = atasReunioes;
	}

	public XCurso getCurso() {
		return curso;
	}

	public void setCurso(XCurso curso) {
		this.curso = curso;
	}

	public XInstituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(XInstituicao instituicao) {
		this.instituicao = instituicao;
	}

	public XLocalizacao getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(XLocalizacao localizacao) {
		this.localizacao = localizacao;
	}

	public XSemestre getSemestre() {
		return semestre;
	}

	public void setSemestre(XSemestre semestre) {
		this.semestre = semestre;
	}

	public XTurno getTurno() {
		return turno;
	}

	public void setTurno(XTurno turno) {
		this.turno = turno;
	}

	public XProjeto getProjeto() {
		return projeto;
	}

	public void setProjeto(XProjeto projeto) {
		this.projeto = projeto;
	}

	public XProjetoCurso() {
	}

}