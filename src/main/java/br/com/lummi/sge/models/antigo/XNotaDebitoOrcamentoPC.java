package br.com.lummi.sge.models.antigo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * The persistent class for the mnotadebitoorcamentopc database table.
 * 
 */
@Entity
@Table(name="mnotadebitoorcamentopc")
public class XNotaDebitoOrcamentoPC implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@ManyToOne
	@JoinColumn(name="notadebitoid")
	private XNotaDebito notaDebito;

	@ManyToOne
	@JoinColumn(name="orcamentoid")
	private XOrcamento orcamento;

	public XNotaDebitoOrcamentoPC() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public XNotaDebito getNotaDebito() {
		return notaDebito;
	}

	public void setNotaDebito(XNotaDebito notaDebito) {
		this.notaDebito = notaDebito;
	}

	public XOrcamento getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(XOrcamento orcamento) {
		this.orcamento = orcamento;
	}

}