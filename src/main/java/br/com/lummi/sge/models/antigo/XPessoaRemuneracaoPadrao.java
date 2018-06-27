package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the cpessoaremuneracaopadrao database table.
 * 
 */
@Entity
@Table(name="cpessoaremuneracaopadrao")
public class XPessoaRemuneracaoPadrao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String faixa;

	private BigDecimal percentual;

	private BigDecimal valorfinal;

	private BigDecimal valorinicial;

	//bi-directional many-to-one association to Cpessoa
	@ManyToOne
	@JoinColumn(name="pessoaid")
	private XPessoa pessoa;

	public XPessoaRemuneracaoPadrao() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFaixa() {
		return this.faixa;
	}

	public void setFaixa(String faixa) {
		this.faixa = faixa;
	}

	public BigDecimal getPercentual() {
		return this.percentual;
	}

	public void setPercentual(BigDecimal percentual) {
		this.percentual = percentual;
	}

	public BigDecimal getValorfinal() {
		return this.valorfinal;
	}

	public void setValorfinal(BigDecimal valorfinal) {
		this.valorfinal = valorfinal;
	}

	public BigDecimal getValorinicial() {
		return this.valorinicial;
	}

	public void setValorinicial(BigDecimal valorinicial) {
		this.valorinicial = valorinicial;
	}

	public XPessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(XPessoa pessoa) {
		this.pessoa = pessoa;
	}

}