package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the clocal database table.
 * 
 */
@Entity
@Table(name="clocal")
public class XLocal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String cep;

	private String codigo;

	private String complemento;

	private String endereco;

	private String nome;

	private String numero;

	private String pontoreferencia;

	@ManyToOne
	@JoinColumn(name="bairroid")
	private XBairro bairro;

	@ManyToOne
	@JoinColumn(name="cidadeid")
	private XCidade cidade;

	@ManyToOne
	@JoinColumn(name="pessoaid")
	private XPessoa pessoa;

	@OneToMany(mappedBy="local")
	private List<XLocalAmbiente> localAmbientes;

	@OneToMany(mappedBy="local")
	private List<XLocalFoto> locaisFotos;

	@OneToMany(mappedBy="local")
	private List<XLocalHistoricoVisita> locaisHistoricoVisitas;

	@OneToMany(mappedBy="local")
	private List<XOrcamento> orcamentos;

	public XLocal() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
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

	public String getPontoreferencia() {
		return this.pontoreferencia;
	}

	public void setPontoreferencia(String pontoreferencia) {
		this.pontoreferencia = pontoreferencia;
	}

	public XBairro getBairro() {
		return this.bairro;
	}

	public void setBairro(XBairro bairro) {
		this.bairro = bairro;
	}

	public XCidade getCidade() {
		return this.cidade;
	}

	public void setCidade(XCidade cidade) {
		this.cidade = cidade;
	}

	public List<XLocalAmbiente> getLocalAmbientes() {
		return this.localAmbientes;
	}

	public void setClocalambientes(List<XLocalAmbiente> localAmbientes) {
		this.localAmbientes = localAmbientes;
	}

	public XPessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(XPessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<XLocalFoto> getLocaisFotos() {
		return locaisFotos;
	}

	public void setLocaisFotos(List<XLocalFoto> locaisFotos) {
		this.locaisFotos = locaisFotos;
	}

	public List<XLocalHistoricoVisita> getLocaisHistoricoVisitas() {
		return locaisHistoricoVisitas;
	}

	public void setLocaisHistoricoVisitas(List<XLocalHistoricoVisita> locaisHistoricoVisitas) {
		this.locaisHistoricoVisitas = locaisHistoricoVisitas;
	}

	public void setLocalAmbientes(List<XLocalAmbiente> localAmbientes) {
		this.localAmbientes = localAmbientes;
	}

	public List<XOrcamento> getOrcamentos() {
		return this.orcamentos;
	}

	public void setOrcamentos(List<XOrcamento> orcamentos) {
		this.orcamentos = orcamentos;
	}

}