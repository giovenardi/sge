package br.com.lummi.sge.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="captador_externo")
public class CaptadorExterno implements Entidade {

	private static final long serialVersionUID = -6199107240982824463L;

	@Id
	@SequenceGenerator(name="captador_externo_id_seq", sequenceName="captador_externo_id_seq", allocationSize=1)
	@GeneratedValue(generator="captador_externo_id_seq")
	private Integer id;

	private Double valor;
	
	@OneToOne
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

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	
}
