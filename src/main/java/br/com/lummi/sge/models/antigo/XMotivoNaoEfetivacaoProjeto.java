package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cmotivonaoefetivacaoprojeto database table.
 * 
 */
@Entity
@Table(name="cmotivonaoefetivacaoprojeto")
public class XMotivoNaoEfetivacaoProjeto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String nome;

	private String tipo;

	//bi-directional many-to-one association to Mprojeto
	@OneToMany(mappedBy="motivoNaoEfetivacaoProjeto")
	private List<XProjeto> projetos;

	public XMotivoNaoEfetivacaoProjeto() {
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

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<XProjeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<XProjeto> projetos) {
		this.projetos = projetos;
	}


}