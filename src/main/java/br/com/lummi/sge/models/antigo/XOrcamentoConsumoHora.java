package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the morcamentoconsumohoras database table.
 * 
 */
@Entity
@Table(name="morcamentoconsumohoras")
public class XOrcamentoConsumoHora implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Timestamp datahoraalteracao;

	private String item;

	private BigDecimal tempoefetivo;

	private BigDecimal tempoestimado;

	//bi-directional many-to-one association to Csetor
	@ManyToOne
	@JoinColumn(name="setorid")
	private XSetor setor;

	//bi-directional many-to-one association to Cusuario
	@ManyToOne
	@JoinColumn(name="usuarialteracaoid")
	private XUsuario usuario;

	//bi-directional many-to-one association to Morcamento
	@ManyToOne
	@JoinColumn(name="orcamentoid")
	private XOrcamento orcamento;

	public XOrcamentoConsumoHora() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getDatahoraalteracao() {
		return this.datahoraalteracao;
	}

	public void setDatahoraalteracao(Timestamp datahoraalteracao) {
		this.datahoraalteracao = datahoraalteracao;
	}

	public String getItem() {
		return this.item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public BigDecimal getTempoefetivo() {
		return this.tempoefetivo;
	}

	public void setTempoefetivo(BigDecimal tempoefetivo) {
		this.tempoefetivo = tempoefetivo;
	}

	public BigDecimal getTempoestimado() {
		return this.tempoestimado;
	}

	public void setTempoestimado(BigDecimal tempoestimado) {
		this.tempoestimado = tempoestimado;
	}

	public XSetor getSetor() {
		return this.setor;
	}

	public void setCsetor(XSetor setor) {
		this.setor = setor;
	}

	public XUsuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(XUsuario usuario) {
		this.usuario = usuario;
	}

	public XOrcamento getOrcamento() {
		return this.orcamento;
	}

	public void setOrcamento(XOrcamento orcamento) {
		this.orcamento = orcamento;
	}

}