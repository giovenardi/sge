package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cpessoainformacaofinanceira database table.
 * 
 */
@Entity
@Table(name="cpessoainformacaofinanceira")
public class XPessoaInformacaoFinanceira implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String descricao;

	//bi-directional many-to-one association to Cpessoa
	@ManyToOne
	@JoinColumn(name="pessoaid")
	private XPessoa pessoa;

	public XPessoaInformacaoFinanceira() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public XPessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(XPessoa pessoa) {
		this.pessoa = pessoa;
	}

}