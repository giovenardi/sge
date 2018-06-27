package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cpessoagrupoitem database table.
 * 
 */
@Entity
@Table(name="cpessoagrupoitem")
public class XPessoaGrupoItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	//bi-directional many-to-one association to Cgrupoitemorcamento
	@ManyToOne
	@JoinColumn(name="grupoitemid")
	private XGrupoItemOrcamento grupoItemOrcamento;

	//bi-directional many-to-one association to Cpessoa
	@ManyToOne
	@JoinColumn(name="pessoaid")
	private XPessoa pessoa;

	public XPessoaGrupoItem() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public XGrupoItemOrcamento getGrupoItemOrcamento() {
		return this.grupoItemOrcamento;
	}

	public void setGrupoItemOrcamento(XGrupoItemOrcamento grupoItemOrcamento) {
		this.grupoItemOrcamento = grupoItemOrcamento;
	}

	public XPessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(XPessoa pessoa) {
		this.pessoa = pessoa;
	}

}