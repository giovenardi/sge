package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the citemgerenciamentoperformance database table.
 * 
 */
@Entity
@Table(name="citemgerenciamentoperformance")
public class XItemGerenciamentoPerformance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String nome;

	private Integer ordem;

	private String status;

	@ManyToOne
	@JoinColumn(name="grupogerenciamentoperformanceid")
	private XGrupoGerenciamentoPerformance grupoGerenciamentoPerformance;

	@OneToMany(mappedBy="gerenciamentoPerformance")
	private List<XGerenciamentoPerformanceItem> gerenciamentoPerformanceItens;

	public XItemGerenciamentoPerformance() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getOrdem() {
		return this.ordem;
	}

	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public XGrupoGerenciamentoPerformance getGrupoGerenciamentoPerformance() {
		return this.grupoGerenciamentoPerformance;
	}

	public void setGrupoGerenciamentoPerformance(XGrupoGerenciamentoPerformance grupoGerenciamentoPerformance) {
		this.grupoGerenciamentoPerformance = grupoGerenciamentoPerformance;
	}

	public List<XGerenciamentoPerformanceItem> getGerenciamentoPerformanceItens() {
		return gerenciamentoPerformanceItens;
	}

	public void setGerenciamentoPerformanceItens(List<XGerenciamentoPerformanceItem> gerenciamentoPerformanceItens) {
		this.gerenciamentoPerformanceItens = gerenciamentoPerformanceItens;
	}

}