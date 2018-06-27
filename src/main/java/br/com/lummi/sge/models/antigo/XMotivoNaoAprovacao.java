package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cmotivonaoaprovacao database table.
 * 
 */
@Entity
@Table(name="cmotivonaoaprovacao")
public class XMotivoNaoAprovacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String tipo;

	private String titulo;

	//bi-directional many-to-one association to Morcamento
	@OneToMany(mappedBy="motivoNaoAprovacao")
	private List<XOrcamento> orcamentos;

	public XMotivoNaoAprovacao() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<XOrcamento> getOrcamentos() {
		return this.orcamentos;
	}

	public void setOrcamentos(List<XOrcamento> orcamentos) {
		this.orcamentos = orcamentos;
	}

}