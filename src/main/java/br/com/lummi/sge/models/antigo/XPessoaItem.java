package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cpessoaitem database table.
 * 
 */
@Entity
@Table(name="cpessoaitem")
public class XPessoaItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	//bi-directional many-to-one association to Citemorcamento
	@ManyToOne
	@JoinColumn(name="itemid")
	private XItemOrcamento itemOrcamento;

	//bi-directional many-to-one association to Cpessoa
	@ManyToOne
	@JoinColumn(name="pessoaid")
	private XPessoa pessoa;

	public XPessoaItem() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public XItemOrcamento getItemOrcamento() {
		return this.itemOrcamento;
	}

	public void setItemOrcamento(XItemOrcamento itemOrcamento) {
		this.itemOrcamento = itemOrcamento;
	}

	public XPessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(XPessoa pessoa) {
		this.pessoa = pessoa;
	}

}