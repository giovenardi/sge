package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mprojetocomissao database table.
 * 
 */
@Entity
@Table(name="mprojetocomissao")
public class XProjetoComissao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String item;

	//bi-directional many-to-one association to Cfuncaocomissaoformatura
	@ManyToOne
	@JoinColumn(name="funcaoid")
	private XFuncaoComissaoFormatura funcaoComissaoFormatura;

	//bi-directional many-to-one association to Cpessoa
	@ManyToOne
	@JoinColumn(name="alunoid")
	private XPessoa pessoa;

	//bi-directional many-to-one association to Mprojeto
	@ManyToOne
	@JoinColumn(name="projetoid")
	private XProjeto projeto;

	public XProjetoComissao() {
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

	public XFuncaoComissaoFormatura getFuncaoComissaoFormatura() {
		return funcaoComissaoFormatura;
	}

	public void setFuncaoComissaoFormatura(XFuncaoComissaoFormatura funcaoComissaoFormatura) {
		this.funcaoComissaoFormatura = funcaoComissaoFormatura;
	}

	public XPessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(XPessoa pessoa) {
		this.pessoa = pessoa;
	}

	public XProjeto getProjeto() {
		return projeto;
	}

	public void setProjeto(XProjeto projeto) {
		this.projeto = projeto;
	}

}