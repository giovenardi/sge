package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the cpessoaexames database table.
 * 
 */
@Entity
@Table(name="cpessoaexames")
public class XPessoaExame implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Timestamp dataalteracao;

	private Timestamp datarealizacao;

	private Timestamp datavencimento;

	private String item;

	@ManyToOne
	@JoinColumn(name="funcionarioid")
	private XPessoa pessoa;

	@ManyToOne
	@JoinColumn(name="tipoexameid")
	private XTipoExame tipoExame;

	public XTipoExame getTipoExame() {
		return tipoExame;
	}

	public void setTipoExame(XTipoExame tipoExame) {
		this.tipoExame = tipoExame;
	}

	@ManyToOne
	@JoinColumn(name="usuarioalteracaoid")
	private XUsuario usuario;

	public XPessoaExame() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getDataalteracao() {
		return this.dataalteracao;
	}

	public void setDataalteracao(Timestamp dataalteracao) {
		this.dataalteracao = dataalteracao;
	}

	public Timestamp getDatarealizacao() {
		return this.datarealizacao;
	}

	public void setDatarealizacao(Timestamp datarealizacao) {
		this.datarealizacao = datarealizacao;
	}

	public Timestamp getDatavencimento() {
		return this.datavencimento;
	}

	public void setDatavencimento(Timestamp datavencimento) {
		this.datavencimento = datavencimento;
	}

	public String getItem() {
		return this.item;
	}

	public void setItem(String item) {
		this.item = item;
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