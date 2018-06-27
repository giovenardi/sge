package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the cpessoasalario database table.
 * 
 */
@Entity
@Table(name="cpessoasalario")
public class XPessoaSalario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Timestamp datahoracadastro;

	private Timestamp datareferencia;

	private String item;

	private BigDecimal novosalario;

	//bi-directional many-to-one association to Cpessoa
	@ManyToOne
	@JoinColumn(name="funcionarioid")
	private XPessoa pessoa;

	//bi-directional many-to-one association to Cusuario
	@ManyToOne
	@JoinColumn(name="usuariocadastroid")
	private XUsuario usuario;

	public XPessoaSalario() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getDatahoracadastro() {
		return this.datahoracadastro;
	}

	public void setDatahoracadastro(Timestamp datahoracadastro) {
		this.datahoracadastro = datahoracadastro;
	}

	public Timestamp getDatareferencia() {
		return this.datareferencia;
	}

	public void setDatareferencia(Timestamp datareferencia) {
		this.datareferencia = datareferencia;
	}

	public String getItem() {
		return this.item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public BigDecimal getNovosalario() {
		return this.novosalario;
	}

	public void setNovosalario(BigDecimal novosalario) {
		this.novosalario = novosalario;
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