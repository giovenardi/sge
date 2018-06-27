package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the gitembotao database table.
 * 
 */
@Entity
@Table(name="gitembotao")
public class XItemBotao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String categoriatecnica;

	private Timestamp datacadastro;

	private String nome;

	private String referenciatecnica;

	private String tipo;

	public XItemBotao() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategoriatecnica() {
		return this.categoriatecnica;
	}

	public void setCategoriatecnica(String categoriatecnica) {
		this.categoriatecnica = categoriatecnica;
	}

	public Timestamp getDatacadastro() {
		return this.datacadastro;
	}

	public void setDatacadastro(Timestamp datacadastro) {
		this.datacadastro = datacadastro;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getReferenciatecnica() {
		return this.referenciatecnica;
	}

	public void setReferenciatecnica(String referenciatecnica) {
		this.referenciatecnica = referenciatecnica;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}