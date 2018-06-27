package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the cformapagamento database table.
 * 
 */
@Entity
@Table(name="cformapagamento")
public class XFormaPagamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String descricao;

	private Integer deslocamento;

	private Integer intervalo;

	private Integer parcelas;

	private BigDecimal percentual;

	private Boolean tementrada;

	private String titulo;

	//bi-directional many-to-one association to Mcursoaluno
	@OneToMany(mappedBy="formaPagamento")
	private List<XCursoAluno> cursosAlunos;

	//bi-directional many-to-one association to Mprojeto
	@OneToMany(mappedBy="formaPagamento")
	private List<XProjeto> projetos;

	public XFormaPagamento() {
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

	public Integer getDeslocamento() {
		return this.deslocamento;
	}

	public void setDeslocamento(Integer deslocamento) {
		this.deslocamento = deslocamento;
	}

	public Integer getIntervalo() {
		return this.intervalo;
	}

	public void setIntervalo(Integer intervalo) {
		this.intervalo = intervalo;
	}

	public Integer getParcelas() {
		return this.parcelas;
	}

	public void setParcelas(Integer parcelas) {
		this.parcelas = parcelas;
	}

	public BigDecimal getPercentual() {
		return this.percentual;
	}

	public void setPercentual(BigDecimal percentual) {
		this.percentual = percentual;
	}

	public Boolean getTementrada() {
		return this.tementrada;
	}

	public void setTementrada(Boolean tementrada) {
		this.tementrada = tementrada;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<XCursoAluno> getCursosAlunos() {
		return cursosAlunos;
	}

	public void setCursosAlunos(List<XCursoAluno> cursosAlunos) {
		this.cursosAlunos = cursosAlunos;
	}

	public List<XProjeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<XProjeto> projetos) {
		this.projetos = projetos;
	}

}