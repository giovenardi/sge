package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cfuncaocomissaoformatura database table.
 * 
 */
@Entity
@Table(name="cfuncaocomissaoformatura")
public class XFuncaoComissaoFormatura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String nome;

	@OneToMany(mappedBy="funcaoComissaoFormatura")
	private List<XProjetoComissao> projetosComissao;

	public XFuncaoComissaoFormatura() {
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

	public List<XProjetoComissao> getProjetosComissao() {
		return projetosComissao;
	}

	public void setProjetosComissao(List<XProjetoComissao> projetosComissao) {
		this.projetosComissao = projetosComissao;
	}

}