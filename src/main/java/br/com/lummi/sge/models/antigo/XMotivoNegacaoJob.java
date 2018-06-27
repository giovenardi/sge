package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cmotivonegacaojob database table.
 * 
 */
@Entity
@Table(name="cmotivonegacaojob")
public class XMotivoNegacaoJob implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String codigo;

	private String nome;

	private String tipo;

	public XMotivoNegacaoJob() {
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

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}