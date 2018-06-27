package br.com.lummi.sge.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the cinstituicao database table.
 * 
 */
@Entity
@Table(name = "instituicao")
public class Instituicao implements Entidade {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "instituicao_id_seq", sequenceName = "instituicao_id_seq", allocationSize = 1)
	@GeneratedValue(generator = "instituicao_id_seq")
	private Integer id;

	@Column(name = "nome", length = 50)
	private String nome;

	@Column(name = "nome_completo", length = 120)
	private String nomeCompleto;

	@OneToMany(mappedBy = "instituicao")
	private List<UnidadeInstituicao> unidades;

	@Column(name = "educacao_infantil")
	private boolean educacaoInfantil;

	@Column(name = "ensino_fundamental")
	private boolean ensinoFundamental;

	@Column(name = "ensino_medio")
	private boolean ensinoMedio;

	@Column(name = "ensino_superior")
	private boolean ensinoSuperior;

	@Column(name = "cursos_formacao")
	private boolean cursosFormacao;

	public Instituicao() {
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

	public List<UnidadeInstituicao> getUnidades() {
		return unidades;
	}

	public void setUnidades(List<UnidadeInstituicao> unidades) {
		this.unidades = unidades;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public boolean isEducacaoInfantil() {
		return educacaoInfantil;
	}

	public void setEducacaoInfantil(boolean educacaoInfantil) {
		this.educacaoInfantil = educacaoInfantil;
	}

	public boolean isEnsinoSuperior() {
		return ensinoSuperior;
	}

	public void setEnsinoSuperior(boolean ensinoSuperior) {
		this.ensinoSuperior = ensinoSuperior;
	}

	public boolean isCursosFormacao() {
		return cursosFormacao;
	}

	public void setCursosFormacao(boolean cursosFormacao) {
		this.cursosFormacao = cursosFormacao;
	}

	public boolean isEnsinoFundamental() {
		return ensinoFundamental;
	}

	public void setEnsinoFundamental(boolean ensinoFundamental) {
		this.ensinoFundamental = ensinoFundamental;
	}

	public boolean isEnsinoMedio() {
		return ensinoMedio;
	}

	public void setEnsinoMedio(boolean ensinoMedio) {
		this.ensinoMedio = ensinoMedio;
	}

}