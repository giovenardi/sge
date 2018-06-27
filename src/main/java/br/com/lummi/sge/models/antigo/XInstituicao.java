package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cinstituicao database table.
 * 
 */
@Entity
@Table(name="cinstituicao")
public class XInstituicao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String nome;

	private String nomecompleto;

	private String sigla;

	@OneToMany(mappedBy="instituicao")
	private List<XProjetoCurso> projetosCursos;

	public XInstituicao() {
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

	public String getNomecompleto() {
		return this.nomecompleto;
	}

	public void setNomecompleto(String nomecompleto) {
		this.nomecompleto = nomecompleto;
	}

	public String getSigla() {
		return this.sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

}