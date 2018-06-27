package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the cpessoaocorrencia database table.
 * 
 */
@Entity
@Table(name="cpessoaocorrencia")
public class XPessoaOcorrencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Timestamp datahora;

	private Timestamp datahoracadastro;

	private String descricao;

	private String encarregado;

	private String item;

	private String linkarquivo;

	private String titulo;

	//bi-directional many-to-one association to Cpessoa
	@ManyToOne
	@JoinColumn(name="funcionarioid")
	private XPessoa pessoa;

	//bi-directional many-to-one association to Cusuario
	@ManyToOne
	@JoinColumn(name="usuariocadastroid")
	private XUsuario usuario;

	public XPessoaOcorrencia() {
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

	public Timestamp getDatahoracadastro() {
		return this.datahoracadastro;
	}

	public void setDatahoracadastro(Timestamp datahoracadastro) {
		this.datahoracadastro = datahoracadastro;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEncarregado() {
		return this.encarregado;
	}

	public void setEncarregado(String encarregado) {
		this.encarregado = encarregado;
	}

	public String getItem() {
		return this.item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getLinkarquivo() {
		return this.linkarquivo;
	}

	public void setLinkarquivo(String linkarquivo) {
		this.linkarquivo = linkarquivo;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public XPessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(XPessoa pessoa) {
		this.pessoa = pessoa;
	}

	public XUsuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(XUsuario usuario) {
		this.usuario = usuario;
	}

}