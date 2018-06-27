package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the mticketconsumoitem database table.
 * 
 */
@Entity
@Table(name="mticketconsumoitem")
public class XTicketConsumoItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String descricao;

	private Integer item;

	private Integer quantidade;

	private BigDecimal valortotal;

	private BigDecimal valorunitario;

	//bi-directional many-to-one association to Mticketconsumo
	@ManyToOne
	@JoinColumn(name="ticketconsumoid")
	private XTicketConsumo ticketConsumo;

	public XTicketConsumoItem() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getItem() {
		return this.item;
	}

	public void setItem(Integer item) {
		this.item = item;
	}

	public Integer getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValortotal() {
		return this.valortotal;
	}

	public void setValortotal(BigDecimal valortotal) {
		this.valortotal = valortotal;
	}

	public BigDecimal getValorunitario() {
		return this.valorunitario;
	}

	public void setValorunitario(BigDecimal valorunitario) {
		this.valorunitario = valorunitario;
	}

	public XTicketConsumo getTicketConsumo() {
		return this.ticketConsumo;
	}

	public void setTicketConsumo(XTicketConsumo ticketConsumo) {
		this.ticketConsumo = ticketConsumo;
	}

}