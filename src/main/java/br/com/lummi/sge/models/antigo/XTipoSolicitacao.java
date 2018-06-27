package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the ctiposolicitacao database table.
 * 
 */
@Entity
@Table(name="ctiposolicitacao")
public class XTipoSolicitacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String nome;

	@OneToMany(mappedBy="tipoSolicitacao")
	private List<XSolicitacaoCliente> solicitacoesCliente;

	public XTipoSolicitacao() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<XSolicitacaoCliente> getSolicitacoesCliente() {
		return solicitacoesCliente;
	}

	public void setSolicitacoesCliente(List<XSolicitacaoCliente> solicitacoesCliente) {
		this.solicitacoesCliente = solicitacoesCliente;
	}

}