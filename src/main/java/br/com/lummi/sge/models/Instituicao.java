package br.com.lummi.sge.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the cinstituicao database table.
 * 
 */
@Entity
@Table(name="instituicao")
public class Instituicao implements Entidade {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name="nome", length=50)
	private String nome;

	@Column(name="nome_completo", length=120)
	private String nomeCompleto;

	@OneToMany(mappedBy="instituicao")
	private List<UnidadeInstituicao> unidades;

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

}