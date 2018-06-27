package br.com.lummi.sge.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.lummi.sge.models.antigo.XConceito;


/**
 * The persistent class for the cpessoa database table.
 * 
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("PJ")
public class PessoaJuridica extends Pessoa {
	private static final long serialVersionUID = 1L;

	@Column(name="cnpj")
	private String cnpj;

	private String contato;

	@Column(name="data_Abertura")
	@Temporal(TemporalType.DATE)
	private Date dataAbertura;

	@Column(name="inscricao_estadual")
	private String inscricaoEstadual;

	@Column(name="inscricao_municipal")
	private String inscricaoMunicipal;

	@Column(name="nome_fantasia")
	private String nomeFantasia;

	@Column(name="nome")
	private String razaoSocial;

	@ManyToOne
	@JoinColumn(name="conceito_id")
	private XConceito conceito;

	public PessoaJuridica() {
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getInscricaoMunicipal() {
		return inscricaoMunicipal;
	}

	public void setInscricaoMunicipal(String inscricaoMunicipal) {
		this.inscricaoMunicipal = inscricaoMunicipal;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public XConceito getConceito() {
		return conceito;
	}

	public void setConceito(XConceito conceito) {
		this.conceito = conceito;
	}


}