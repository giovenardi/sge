package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the mfaturacomissaoitem database table.
 * 
 */
@Entity
@Table(name="mfaturacomissaoitem")
public class XFaturaComissaoItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datahora;

	private String historico;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDatahora() {
		return datahora;
	}

	public void setDatahora(Date datahora) {
		this.datahora = datahora;
	}

	public String getHistorico() {
		return historico;
	}

	public void setHistorico(String historico) {
		this.historico = historico;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public BigDecimal getValortotal() {
		return valortotal;
	}

	public void setValortotal(BigDecimal valortotal) {
		this.valortotal = valortotal;
	}

	public XUsuarioGerenteComissao getUsuarioGerenteComissao() {
		return usuarioGerenteComissao;
	}

	public void setUsuarioGerenteComissao(XUsuarioGerenteComissao usuarioGerenteComissao) {
		this.usuarioGerenteComissao = usuarioGerenteComissao;
	}

	public XFaturaComissao getFaturaComissao() {
		return faturaComissao;
	}

	public void setFaturaComissao(XFaturaComissao faturaComissao) {
		this.faturaComissao = faturaComissao;
	}

	private String item;

	private BigDecimal valortotal;

	@ManyToOne
	@JoinColumn(name="pessoaid")
	private XUsuarioGerenteComissao usuarioGerenteComissao;

	@ManyToOne
	@JoinColumn(name="faturacomissaoid")
	private XFaturaComissao faturaComissao;

	public XFaturaComissaoItem() {
	}

}