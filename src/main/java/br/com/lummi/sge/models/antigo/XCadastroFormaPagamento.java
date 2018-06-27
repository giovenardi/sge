package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the gcadastroformapagamento database table.
 * 
 */
@Entity
@Table(name="gcadastroformapagamento")
public class XCadastroFormaPagamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String titulo;

	private String tratamento;

	@OneToMany(mappedBy="cadastroFormaPagamento")
	private List<XContaPagar> contasPagar;

	@OneToMany(mappedBy="cadastroFormaPagamento")
	private List<XContaReceber> contasReceber;

	@OneToMany(mappedBy="cadastrosFormaPagamento")
	private List<XOrcamento> orcamentos;

	@OneToMany(mappedBy="cadastroFormaPagamento")
	private List<XOrdemServico> ordensServico;

	public List<XOrdemServico> getOrdensServico() {
		return ordensServico;
	}

	public void setOrdensServico(List<XOrdemServico> ordensServico) {
		this.ordensServico = ordensServico;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTratamento() {
		return tratamento;
	}

	public void setTratamento(String tratamento) {
		this.tratamento = tratamento;
	}

	public List<XContaPagar> getContasPagar() {
		return contasPagar;
	}

	public void setContasPagar(List<XContaPagar> contasPagar) {
		this.contasPagar = contasPagar;
	}

	public List<XContaReceber> getContasReceber() {
		return contasReceber;
	}

	public void setContasReceber(List<XContaReceber> contasReceber) {
		this.contasReceber = contasReceber;
	}

	public List<XOrcamento> getOrcamentos() {
		return orcamentos;
	}

	public void setOrcamentos(List<XOrcamento> orcamentos) {
		this.orcamentos = orcamentos;
	}

	public XCadastroFormaPagamento() {
	}

}