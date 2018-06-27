package br.com.lummi.sge.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "unidade_instituicao")
public class UnidadeInstituicao implements Entidade {

	private static final long serialVersionUID = 6595544715934660113L;

	@Id
	@SequenceGenerator(name = "unidade_instituicao_id_seq", sequenceName = "unidade_instituicao_id_seq", allocationSize = 1)
	@GeneratedValue(generator = "unidade_instituicao_id_seq")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "instituicao_id")
	private Instituicao instituicao;

	@Column(name = "nome", length = 100)
	private String nome;

	@ManyToOne
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;

	@OneToMany(targetEntity = Turma.class, mappedBy = "unidadeInstituicao")
	private List<Turma> turmas;

	@OneToMany(targetEntity = ContatoEvento.class, mappedBy = "unidadeInstituicao")
	private List<ContatoEvento> contatos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	public List<ContatoEvento> getContatos() {
		return contatos;
	}

	public void setContatos(List<ContatoEvento> contatos) {
		this.contatos = contatos;
	}

}
