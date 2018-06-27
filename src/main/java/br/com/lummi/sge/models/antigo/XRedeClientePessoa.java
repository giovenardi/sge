package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the credeclientepessoa database table.
 * 
 */
@Entity
@Table(name="credeclientepessoa")
public class XRedeClientePessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	//bi-directional many-to-one association to Cpessoa
	@ManyToOne
	@JoinColumn(name="clienteid")
	private XPessoa pessoa;

	//bi-directional many-to-one association to Credecliente
	@ManyToOne
	@JoinColumn(name="redeclienteid")
	private XRedeCliente redeCliente;

	public XRedeClientePessoa() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public XPessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(XPessoa pessoa) {
		this.pessoa = pessoa;
	}

	public XRedeCliente getRedeCliente() {
		return this.redeCliente;
	}

	public void setRedeCliente(XRedeCliente redeCliente) {
		this.redeCliente = redeCliente;
	}

}