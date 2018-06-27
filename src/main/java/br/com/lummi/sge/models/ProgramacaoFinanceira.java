package br.com.lummi.sge.models;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.lummi.sge.enums.StatusProgramacaoEnum;


@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipo")
@Entity
@Table(name="programacao_financeira")
public abstract class ProgramacaoFinanceira implements Entidade {

	private static final long serialVersionUID = -4503117570321756569L;

	@Id
	@SequenceGenerator(name="programacao_financeira_id_seq", sequenceName="programacao_financeira_id_seq", allocationSize=1)
	@GeneratedValue(generator="programacao_financeira_id_seq")
	private Integer id;

	@Column(name="data_vencimento")
	@Temporal(TemporalType.DATE)
	private Date dataVencimento;

	@Column(name="numero_parcela")
	private Integer numeroParcela;

	@Column(name="observacao")
	private String observacao;

	@Column(name="status")
	@Enumerated(EnumType.STRING)
	private StatusProgramacaoEnum status;

	@Column(name="valor", precision=2, scale=12)
	private BigDecimal valor;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Integer getNumeroParcela() {
		return numeroParcela;
	}

	public void setNumeroParcela(Integer numeroParcela) {
		this.numeroParcela = numeroParcela;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public StatusProgramacaoEnum getStatus() {
		return status;
	}

	public void setStatus(StatusProgramacaoEnum status) {
		this.status = status;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

}