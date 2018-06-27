package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the ctipoexame database table.
 * 
 */
@Entity
@Table(name="ctipoexame")
public class XTipoExame implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String nome;

	@OneToMany(mappedBy="tipoExame")
	private List<XPessoaExame> pessoasExame;

	public XTipoExame() {
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

	public List<XPessoaExame> getPessoasExame() {
		return pessoasExame;
	}

	public void setPessoasExame(List<XPessoaExame> pessoasExame) {
		this.pessoasExame = pessoasExame;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}