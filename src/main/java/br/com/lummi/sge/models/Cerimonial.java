package br.com.lummi.sge.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.lummi.sge.enums.MeioPagamentoEnum;
import br.com.lummi.sge.enums.ResponsabilidadeFinanceiraEnum;

@Entity
@Table(name="cerimonial")
public class Cerimonial implements Entidade {

	private static final long serialVersionUID = 2841702982332983482L;

	@Id
	@SequenceGenerator(name="cerimonial_id_seq", sequenceName="cerimonial_id_seq", allocationSize=1)
	@GeneratedValue(generator="cerimonial_id_seq")
	private Integer id;
	
	@Column(name="valor", scale=10, precision=2)
	private BigDecimal valor;
	
	@Column(name="previsao_convidados")
	private Integer previsaoConvidados;
	
	@Column(name="valor_convidado_extra", scale=10, precision=2)
	private BigDecimal valorExcedenteCerimonial;
	
	@Column(name="responsabilidade_financeira")
	@Enumerated(EnumType.STRING)
	private ResponsabilidadeFinanceiraEnum responsabilidadeFinanceira;

	@Column(name="meio_pagamento")
	@Enumerated(EnumType.STRING)
	private MeioPagamentoEnum meioPagamento;

	@ManyToOne
	@JoinColumn(name="responsavel_pagamento_id")
	private Pessoa responsavelPagamento;
	
	@OneToOne(targetEntity=Projeto.class)
	@JoinColumn(name="projeto_id")
	private Projeto projeto;

	@OneToOne(targetEntity=FormaPagamento.class, mappedBy="cerimonial")
	private FormaPagamento formaPagamento;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Integer getPrevisaoConvidados() {
		return previsaoConvidados;
	}

	public void setPrevisaoConvidados(Integer previsaoConvidados) {
		this.previsaoConvidados = previsaoConvidados;
	}

	public ResponsabilidadeFinanceiraEnum getResponsabilidadeFinanceira() {
		return responsabilidadeFinanceira;
	}

	public void setResponsabilidadeFinanceira(ResponsabilidadeFinanceiraEnum responsabilidadeFinanceira) {
		this.responsabilidadeFinanceira = responsabilidadeFinanceira;
	}

	public Pessoa getResponsavelPagamento() {
		return responsavelPagamento;
	}

	public void setResponsavelPagamento(Pessoa responsavelPagamento) {
		this.responsavelPagamento = responsavelPagamento;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public MeioPagamentoEnum getMeioPagamento() {
		return meioPagamento;
	}

	public void setMeioPagamento(MeioPagamentoEnum meioPagamento) {
		this.meioPagamento = meioPagamento;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public BigDecimal getValorExcedenteCerimonial() {
		return valorExcedenteCerimonial;
	}

	public void setValorExcedenteCerimonial(BigDecimal valorExcedenteCerimonial) {
		this.valorExcedenteCerimonial = valorExcedenteCerimonial;
	}

	
}
