package br.com.lummi.sge.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="endereco")
public class Endereco implements Entidade {

	private static final long serialVersionUID = 608200126352504259L;

	@Id
	@SequenceGenerator(name="endereco_id_seq", sequenceName="endereco_id_seq", allocationSize=1)
	@GeneratedValue(generator="endereco_id_seq")
	private Integer id;
	
	@Column(name="cep", length=40)
	private String cep;
	
	@Column(name="logradouro", length=40)
	private String logradouro;
	
	@Column(name="bairro", length=40)
	private String bairro;
	
	@Column(name="numero", length=10)
	private String numero;
	
	@Column(name="complemento", length=40)
	private String complemento;
	
	@Column(name="cidade", length=40)
	private String cidade;
	
	@ManyToOne
	@JoinColumn(name="uf_id")
	private Uf uf;
	
	@Column(name="ponto_referencia")
	private String pontoReferencia;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Uf getUf() {
		return uf;
	}

	public void setUf(Uf uf) {
		this.uf = uf;
	}

	public String getPontoReferencia() {
		return pontoReferencia;
	}

	public void setPontoReferencia(String pontoReferencia) {
		this.pontoReferencia = pontoReferencia;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	
}
