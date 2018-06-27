package br.com.lummi.sge.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.ibm.icu.text.SimpleDateFormat;

import br.com.lummi.sge.enums.FormaParcelamentoEnum;


@Entity
@Table(name="forma_pagamento")
public class FormaPagamento implements Entidade {
	
	private static final long serialVersionUID = 3359279187014934031L;

	@Id
	@SequenceGenerator(name="forma_pagamento_id_seq", sequenceName="forma_pagamento_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="forma_pagamento_id_seq")
	private Integer id;

	@Column(name="titulo", length=100)
	private String titulo;
	
	@Column(name="data_inicio")
	@Temporal(TemporalType.DATE)
	private Date dataInicio;
	
	@Transient
	private String dataInicioFormatada;
	
	@Column(name="parcelas", length=3)
	private Integer parcelas;

	@Column(name="forma_parcelamento")
	@Enumerated(EnumType.STRING)
	private FormaParcelamentoEnum formaParcelamento;
	
	@ManyToOne(targetEntity=PlanoPagamento.class)
	@JoinColumn(name="plano_pagamento_id")
	private PlanoPagamento planoPagamento;

	@OneToOne(targetEntity=Cerimonial.class)
	@JoinColumn(name="cerimonial_id")
	private Cerimonial cerimonial;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getParcelas() {
		return this.parcelas;
	}

	public void setParcelas(Integer parcelas) {
		this.parcelas = parcelas;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public PlanoPagamento getPlanoPagamento() {
		return planoPagamento;
	}

	public void setPlanoPagamento(PlanoPagamento planoPagamento) {
		this.planoPagamento = planoPagamento;
	}

	public FormaParcelamentoEnum getFormaParcelamento() {
		return formaParcelamento;
	}

	public void setFormaParcelamento(FormaParcelamentoEnum formaParcelamento) {
		this.formaParcelamento = formaParcelamento;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataInicioFormatada() {
		try {
			dataInicioFormatada = new SimpleDateFormat("dd/MM/yyyy").format(dataInicio);
		} catch (Exception e) {
		}
		return dataInicioFormatada;
	}

	public Cerimonial getCerimonial() {
		return cerimonial;
	}

	public void setCerimonial(Cerimonial cerimonial) {
		this.cerimonial = cerimonial;
	}

}