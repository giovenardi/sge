package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cprevisaoanual database table.
 * 
 */
@Entity
@Table(name="cprevisaoanual")
public class XPrevisaoAnual implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Integer ano;

	private String codigo;

	private String descricao;

	//bi-directional many-to-one association to Cprevisaoanualitem
	@OneToMany(mappedBy="previsaoAnual")
	private List<XPrevisaoAnualItem> previsaoAnualItens;

	public XPrevisaoAnual() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAno() {
		return this.ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<XPrevisaoAnualItem> getPrevisaoAnualItens() {
		return this.previsaoAnualItens;
	}

	public void setPrevisaoAnualItens(List<XPrevisaoAnualItem> previsaoAnualItens) {
		this.previsaoAnualItens = previsaoAnualItens;
	}

}