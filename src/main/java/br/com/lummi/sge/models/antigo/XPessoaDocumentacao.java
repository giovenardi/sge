package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the cpessoadocumentocao database table.
 * 
 */
@Entity
@Table(name="cpessoadocumentocao")
public class XPessoaDocumentacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String item;

	private String linkarquivo;

	private String numero;

	private Timestamp validade;

	//bi-directional many-to-one association to Cpessoa
	@ManyToOne
	@JoinColumn(name="funcionarioid")
	private XPessoa pessoa;

	//bi-directional many-to-one association to Ctipodocumentofuncionario
	@ManyToOne
	@JoinColumn(name="tipodocumentoid")
	private XTipoDocumentoFuncionario tipoDocumentoFuncionario;

	public XPessoaDocumentacao() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Timestamp getValidade() {
		return this.validade;
	}

	public void setValidade(Timestamp validade) {
		this.validade = validade;
	}

	public XPessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(XPessoa pessoa) {
		this.pessoa = pessoa;
	}

	public XTipoDocumentoFuncionario getTipoDocumentoFuncionario() {
		return this.tipoDocumentoFuncionario;
	}

	public void setTipoDocumentoFuncionario(XTipoDocumentoFuncionario tipoDocumentoFuncionario) {
		this.tipoDocumentoFuncionario = tipoDocumentoFuncionario;
	}

}