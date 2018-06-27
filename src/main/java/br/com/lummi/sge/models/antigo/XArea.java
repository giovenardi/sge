package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the carea database table.
 * 
 */
@Entity
@Table(name="carea")
public class XArea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String nome;

	private String sigla;

	@OneToMany(mappedBy="carea")
	private List<XContaPagar> contasPagar;

	@OneToMany(mappedBy="carea")
	private List<XContaPagarRateio> contaPagarRateios;

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

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public List<XContaPagar> getContasPagar() {
		return contasPagar;
	}

	public void setContasPagar(List<XContaPagar> contasPagar) {
		this.contasPagar = contasPagar;
	}

	public List<XContaPagarRateio> getContaPagarRateios() {
		return contaPagarRateios;
	}

	public void setContaPagarRateios(List<XContaPagarRateio> contaPagarRateios) {
		this.contaPagarRateios = contaPagarRateios;
	}

	public XArea() {
	}

}