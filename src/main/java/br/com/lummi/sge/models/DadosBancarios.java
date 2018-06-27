package br.com.lummi.sge.models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.lummi.sge.enums.TipoContaBancariaEnum;


@Entity
@Table(name="dado_bancario")
public class DadosBancarios implements Entidade {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="dado_bancario_id_seq", sequenceName="dado_bancario_id_seq", allocationSize=1)
	@GeneratedValue(generator="dado_bancario_id_seq")
	private Integer id;

	@ManyToOne
	@JoinColumn(name="banco_id")
	private Banco banco;
	
	private String agencia;

	private String conta;
	
	@Enumerated(EnumType.STRING)
	private TipoContaBancariaEnum tipo;

	public DadosBancarios() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAgencia() {
		return this.agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getConta() {
		return this.conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public TipoContaBancariaEnum getTipo() {
		return tipo;
	}

	public void setTipo(TipoContaBancariaEnum tipo) {
		this.tipo = tipo;
	}

}