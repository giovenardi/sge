package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the mprojetohistorico database table.
 * 
 */
@Entity
@Table(name="mprojetohistorico")
public class XProjetoHistorico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Timestamp datahora;

	private Timestamp datahotaalteracao;

	private String detalhamento;

	private String item;

	private String tipo;

	private String titulo;

	@ManyToOne
	@JoinColumn(name="responsavelid")
	private XPessoa pessoa;

	@ManyToOne
	@JoinColumn(name="usuarioalteracaoid")
	private XUsuario usuario;

	@ManyToOne
	@JoinColumn(name="projetoid")
	private XProjeto projeto;

	public XProjetoHistorico() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getDatahora() {
		return this.datahora;
	}

	public void setDatahora(Timestamp datahora) {
		this.datahora = datahora;
	}

	public Timestamp getDatahotaalteracao() {
		return this.datahotaalteracao;
	}

	public void setDatahotaalteracao(Timestamp datahotaalteracao) {
		this.datahotaalteracao = datahotaalteracao;
	}

	public String getDetalhamento() {
		return this.detalhamento;
	}

	public void setDetalhamento(String detalhamento) {
		this.detalhamento = detalhamento;
	}

	public String getItem() {
		return this.item;
	}

	public void setItem(String item) {
		this.item = item;
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

	public XPessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(XPessoa pessoa) {
		this.pessoa = pessoa;
	}

	public XUsuario getUsuario() {
		return usuario;
	}

	public void setUsuario(XUsuario usuario) {
		this.usuario = usuario;
	}

	public XProjeto getProjeto() {
		return projeto;
	}

	public void setProjeto(XProjeto projeto) {
		this.projeto = projeto;
	}

}