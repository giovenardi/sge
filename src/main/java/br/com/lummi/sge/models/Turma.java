package br.com.lummi.sge.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.lummi.sge.enums.NivelEnum;
import br.com.lummi.sge.enums.SemestreEnum;

@Entity
@Table(name = "turma")
public class Turma implements Entidade {

	private static final long serialVersionUID = 6159654660641980464L;

	@Id
	@SequenceGenerator(name = "turma_id_seq", sequenceName = "turma_id_seq", allocationSize = 1)
	@GeneratedValue(generator = "turma_id_seq")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "projeto_id")
	private Projeto projeto;

	@ManyToOne
	@JoinColumn(name = "unidade_instituicao_id")
	private UnidadeInstituicao unidadeInstituicao;

	@ManyToOne
	@JoinColumn(name = "curso_id")
	private Curso curso;

	@Column(name = "nivel")
	@Enumerated(EnumType.STRING)
	private NivelEnum nivel;

	@Column(name = "semestre")
	@Enumerated(EnumType.ORDINAL)
	private SemestreEnum semestre;

	@Column(name = "ano")
	private Integer ano;

	@ManyToOne
	@JoinColumn(name = "turno_id")
	private Turno turno;

	@Column(name = "numero")
	private Integer numero;

	@Column(name = "nome")
	private String nome;

	@OneToMany(targetEntity = Formando.class, mappedBy = "turma")
	private List<Formando> formandos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public UnidadeInstituicao getUnidadeInstituicao() {
		return unidadeInstituicao;
	}

	public void setUnidadeInstituicao(UnidadeInstituicao unidadeInstituicao) {
		this.unidadeInstituicao = unidadeInstituicao;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public SemestreEnum getSemestre() {
		return semestre;
	}

	public void setSemestre(SemestreEnum semestre) {
		this.semestre = semestre;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Formando> getFormandos() {
		return formandos;
	}

	public void setFormandos(List<Formando> formandos) {
		this.formandos = formandos;
	}

	public NivelEnum getNivel() {
		return nivel;
	}

	public void setNivel(NivelEnum nivel) {
		this.nivel = nivel;
	}

}
