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
 * The persistent class for the mcursoalunoprogramacao database table.
 * 
 */
@Entity
@Table(name="mcursoalunoprogramacao")
public class XCursoAlunoProgramacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date data;

	private Boolean notafiscal;

	private String observacao;

	private Integer parcela;

	private String status;

	private BigDecimal valor;

	private BigDecimal valortaxaboleto;

	@ManyToOne
	@JoinColumn(name="alunocursoid")
	private XCursoAluno cursoAluno;

	public XCursoAlunoProgramacao() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Boolean getNotafiscal() {
		return notafiscal;
	}

	public void setNotafiscal(Boolean notafiscal) {
		this.notafiscal = notafiscal;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Integer getParcela() {
		return parcela;
	}

	public void setParcela(Integer parcela) {
		this.parcela = parcela;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getValortaxaboleto() {
		return valortaxaboleto;
	}

	public void setValortaxaboleto(BigDecimal valortaxaboleto) {
		this.valortaxaboleto = valortaxaboleto;
	}

	public XCursoAluno getCursoAluno() {
		return cursoAluno;
	}

	public void setCursoAluno(XCursoAluno cursoAluno) {
		this.cursoAluno = cursoAluno;
	}

}