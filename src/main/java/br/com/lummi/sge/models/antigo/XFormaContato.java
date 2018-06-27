package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cformacontato database table.
 * 
 */
@Entity
@Table(name="cformacontato")
public class XFormaContato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String codigo;

	private String nome;

	@OneToMany(mappedBy="formaContato")
	private List<XProjetoContato> projetoContatos;

	public XFormaContato() {
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

	public List<XProjetoContato> getProjetoContatos() {
		return projetoContatos;
	}

	public void setProjetoContatos(List<XProjetoContato> projetoContatos) {
		this.projetoContatos = projetoContatos;
	}

}