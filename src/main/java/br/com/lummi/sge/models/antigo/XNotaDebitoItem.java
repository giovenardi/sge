package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * The persistent class for the mnotadebitoitem database table.
 * 
 */
@Entity
@Table(name="mnotadebitoitem")
public class XNotaDebitoItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String descricao;

	private String item;

	private Integer quantidade;

	private BigDecimal valortotal;

	private BigDecimal valorunitario;

	@ManyToOne
	@JoinColumn(name="unidademedidaid")
	private XUnidadeMedida unidadeMedida;

	@ManyToOne
	@JoinColumn(name="notadebitoid")
	private XNotaDebito notaDebito;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValortotal() {
		return valortotal;
	}

	public void setValortotal(BigDecimal valortotal) {
		this.valortotal = valortotal;
	}

	public BigDecimal getValorunitario() {
		return valorunitario;
	}

	public void setValorunitario(BigDecimal valorunitario) {
		this.valorunitario = valorunitario;
	}

	public XUnidadeMedida getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(XUnidadeMedida unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public XNotaDebito getNotaDebito() {
		return notaDebito;
	}

	public void setNotaDebito(XNotaDebito notaDebito) {
		this.notaDebito = notaDebito;
	}

	public XNotaDebitoItem() {
	}

}