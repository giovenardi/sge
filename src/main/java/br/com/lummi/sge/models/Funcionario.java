package br.com.lummi.sge.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="funcionario")
public class Funcionario implements Entidade {

	private static final long serialVersionUID = -8867719893429926347L;

	@Id
	@SequenceGenerator(name="funcionario_id_seq", sequenceName="funcionario_id_seq", allocationSize=1)
	@GeneratedValue(generator="funcionario_id_seq")
	private Integer id;

	@Column(name="ctps")
	private String ctps;
	
	@Column(name="serie_ctps")
	private String serieCtps;
	
	@Column(name="matricula")
	private String matricula;
	
	@ManyToOne
	@JoinColumn(name="cargo_id")
	private Cargo cargo;
	
	@ManyToOne
	@JoinColumn(name="setor_id")
	private Setor setor;
	
	@OneToOne(optional=false)
	@JoinColumn(name="pessoa_id")
	private PessoaFisica pessoa;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PessoaFisica getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaFisica pessoa) {
		this.pessoa = pessoa;
	}

	public String getCtps() {
		return ctps;
	}

	public void setCtps(String ctps) {
		this.ctps = ctps;
	}

	public String getSerieCtps() {
		return serieCtps;
	}

	public void setSerieCtps(String serieCtps) {
		this.serieCtps = serieCtps;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}
	
}
