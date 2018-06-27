package br.com.lummi.sge.models.antigo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.lummi.sge.models.Entidade;


/**
 * The persistent class for the ccargo database table.
 * 
 */
@Entity
@Table(name="ccargo")
public class XCargo implements Entidade {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String nome;

	//bi-directional many-to-one association to Cpessoacontato
	@OneToMany(mappedBy="cargo")
	private List<XPessoaContato> pessoaContatos;

	public XCargo() {
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

	public List<XPessoaContato> getCpessoacontatos() {
		return this.pessoaContatos;
	}

	public void setCpessoacontatos(List<XPessoaContato> pessoaContatos) {
		this.pessoaContatos = pessoaContatos;
	}

}