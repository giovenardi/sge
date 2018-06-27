package br.com.lummi.sge.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the cbanco database table.
 * 
 */
@Entity
@Table(name="banco")
public class Banco implements Entidade {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="banco_id_seq", sequenceName="banco_id_seq", allocationSize=1)
	@GeneratedValue(generator="banco_id_seq")
	private Integer id;

	@ManyToOne
	@JoinColumn(name="configuracao_cobranca_id")
	private ConfiguracaoCobranca configuracaoCobranca;

	private String nome;

	private String numero;

	public Banco() {
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

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public ConfiguracaoCobranca getConfiguracaoCobranca() {
		return configuracaoCobranca;
	}

	public void setConfiguracaoCobranca(ConfiguracaoCobranca configuracaoCobranca) {
		this.configuracaoCobranca = configuracaoCobranca;
	}

}