package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the cunidademedida database table.
 * 
 */
@Entity
@Table(name="cunidademedida")
public class XUnidadeMedida implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String nome;

	private String sigla;

	@OneToMany(mappedBy="unidadeMedida")
	private List<XNotaDebitoItem> notaDebitoItems;

	@OneToMany(mappedBy="unidadeMedida")
	private List<XNotaFiscalItem> notaFiscalItems;

	@OneToMany(mappedBy="unidadeMedida")
	private List<XOrcamentoItem> orcamentoItems;

	@OneToMany(mappedBy="unidadeMedida")
	private List<XProjetoItem> projetosItem;

	public XUnidadeMedida() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public List<XNotaDebitoItem> getNotaDebitoItems() {
		return notaDebitoItems;
	}

	public void setNotaDebitoItems(List<XNotaDebitoItem> notaDebitoItems) {
		this.notaDebitoItems = notaDebitoItems;
	}

	public List<XNotaFiscalItem> getNotaFiscalItems() {
		return notaFiscalItems;
	}

	public void setNotaFiscalItems(List<XNotaFiscalItem> notaFiscalItems) {
		this.notaFiscalItems = notaFiscalItems;
	}

	public List<XOrcamentoItem> getOrcamentoItems() {
		return orcamentoItems;
	}

	public void setOrcamentoItems(List<XOrcamentoItem> orcamentoItems) {
		this.orcamentoItems = orcamentoItems;
	}

	public List<XProjetoItem> getProjetosItem() {
		return projetosItem;
	}

	public void setProjetosItem(List<XProjetoItem> projetosItem) {
		this.projetosItem = projetosItem;
	}

}