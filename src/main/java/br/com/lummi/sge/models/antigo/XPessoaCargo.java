package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the cpessoacargo database table.
 * 
 */
@Entity
@Table(name="cpessoacargo")
public class XPessoaCargo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Timestamp datahoracadastro;

	private String item;

	private String novocargo;

	//bi-directional many-to-one association to Cpessoa
	@ManyToOne
	@JoinColumn(name="funcionarioid")
	private XPessoa pessoa;

	//bi-directional many-to-one association to Cusuario
	@ManyToOne
	@JoinColumn(name="usuariocadastroid")
	private XUsuario usuario;

	public XPessoaCargo() {
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

	public String getItem() {
		return this.item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getNovocargo() {
		return this.novocargo;
	}

	public void setNovocargo(String novocargo) {
		this.novocargo = novocargo;
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