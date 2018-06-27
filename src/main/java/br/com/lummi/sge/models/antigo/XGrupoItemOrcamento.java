package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cgrupoitemorcamento database table.
 * 
 */
@Entity
@Table(name="cgrupoitemorcamento")
public class XGrupoItemOrcamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String nome;

	private Integer ordem;

	@OneToMany(mappedBy="grupoItemOrcamento")
	private List<XItemOrcamento> itensOrcamentos;

	@OneToMany(mappedBy="grupoItemOrcamento")
	private List<XPessoaGrupoItem> pessoasGrupoItems;

	public XGrupoItemOrcamento() {
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

	public List<XItemOrcamento> getItensOrcamentos() {
		return itensOrcamentos;
	}

	public void setItensOrcamentos(List<XItemOrcamento> itensOrcamentos) {
		this.itensOrcamentos = itensOrcamentos;
	}

	public List<XPessoaGrupoItem> getPessoasGrupoItems() {
		return pessoasGrupoItems;
	}

	public void setPessoasGrupoItems(List<XPessoaGrupoItem> pessoasGrupoItems) {
		this.pessoasGrupoItems = pessoasGrupoItems;
	}

}