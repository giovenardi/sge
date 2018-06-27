package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the citemfatordesempenho database table.
 * 
 */
@Entity
@Table(name="citemfatordesempenho")
public class XItemFatorDesempenho implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String nome;

	private Integer ordem;

	private String status;

	@ManyToOne
	@JoinColumn(name="grupofatordesempenhoid")
	private XGrupoFatorDesempenho grupoFatorDesempenho;

	@OneToMany(mappedBy="itemFatorDesempenho")
	private List<XPesquisaSatisfacaoItem> pesquisasSatisfacaoItens;

	public XItemFatorDesempenho() {
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

	public List<XPesquisaSatisfacaoItem> getPesquisasSatisfacaoItens() {
		return pesquisasSatisfacaoItens;
	}

	public void setPesquisasSatisfacaoItens(List<XPesquisaSatisfacaoItem> pesquisasSatisfacaoItens) {
		this.pesquisasSatisfacaoItens = pesquisasSatisfacaoItens;
	}

	public XGrupoFatorDesempenho getGrupoFatorDesempenho() {
		return grupoFatorDesempenho;
	}

	public void setGrupoFatorDesempenho(XGrupoFatorDesempenho grupoFatorDesempenho) {
		this.grupoFatorDesempenho = grupoFatorDesempenho;
	}

}