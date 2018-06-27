package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ctipodocumentofuncionario database table.
 * 
 */
@Entity
@Table(name="ctipodocumentofuncionario")
public class XTipoDocumentoFuncionario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String nome;

	@OneToMany(mappedBy="tipoDocumentoFuncionario")
	private List<XPessoaDocumentacao> pessoaDocumentacoes;

	public XTipoDocumentoFuncionario() {
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

	public List<XPessoaDocumentacao> getPessoaDocumentacoes() {
		return this.pessoaDocumentacoes;
	}

	public void setCpessoadocumentocaos(List<XPessoaDocumentacao> pessoaDocumentacoes) {
		this.pessoaDocumentacoes = pessoaDocumentacoes;
	}

}