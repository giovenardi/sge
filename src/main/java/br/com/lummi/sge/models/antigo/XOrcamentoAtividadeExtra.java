package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the morcamentoatividadeextra database table.
 * 
 */
@Entity
@Table(name="morcamentoatividadeextra")
public class XOrcamentoAtividadeExtra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String atividade;

	private Timestamp datahora;

	private String descricao;

	private Boolean ehrealizado;

	private Integer item;

	//bi-directional many-to-one association to Morcamento
	@ManyToOne
	@JoinColumn(name="orcamentoid")
	private XOrcamento orcamento;

	public XOrcamentoAtividadeExtra() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAtividade() {
		return this.atividade;
	}

	public void setAtividade(String atividade) {
		this.atividade = atividade;
	}

	public Timestamp getDatahora() {
		return this.datahora;
	}

	public void setDatahora(Timestamp datahora) {
		this.datahora = datahora;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getEhrealizado() {
		return this.ehrealizado;
	}

	public void setEhrealizado(Boolean ehrealizado) {
		this.ehrealizado = ehrealizado;
	}

	public Integer getItem() {
		return this.item;
	}

	public void setItem(Integer item) {
		this.item = item;
	}

	public XOrcamento getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(XOrcamento orcamento) {
		this.orcamento = orcamento;
	}

}