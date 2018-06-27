package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the cpessoaconceito database table.
 * 
 */
@Entity
@Table(name="cpessoaconceito")
public class XPessoaConceito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Timestamp datacadastro;

	private String descricao;

	private String observacao;

	private String tipo;

	@ManyToOne
	@JoinColumn(name="conceitoid")
	private XConceito conceito;

	@ManyToOne
	@JoinColumn(name="pessoaid")
	private XPessoa pessoa;

	@ManyToOne
	@JoinColumn(name="ordemservicoid")
	private XOrdemServico ordemServico;

	public XPessoaConceito() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getDatacadastro() {
		return this.datacadastro;
	}

	public void setDatacadastro(Timestamp datacadastro) {
		this.datacadastro = datacadastro;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public XConceito getConceito() {
		return this.conceito;
	}

	public void setCconceito(XConceito conceito) {
		this.conceito = conceito;
	}

	public XPessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(XPessoa pessoa) {
		this.pessoa = pessoa;
	}

	public XOrdemServico getOrdemServico() {
		return ordemServico;
	}

	public void setOrdemServico(XOrdemServico ordemServico) {
		this.ordemServico = ordemServico;
	}

	public void setConceito(XConceito conceito) {
		this.conceito = conceito;
	}

}