package br.com.lummi.sge.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * The persistent class for the ccentrocusto database table.
 * 
 */
@Entity
@Table(name="centro_custo")
public class CentroCusto implements Entidade {

	private static final long serialVersionUID = -3229299337582004131L;

	@Id
	private Integer id;

	@Column(name="codigo")
	private String codigo;

	@Column(name="codigo_contabil")
	private String codigoContabil;

	@Column(name="conta_contabil")
	private String contaContabil;

	@Column(name="nome")
	private String nome;

	@Column(name="prefixo")
	private String prefixo;

	@ManyToOne
	@JoinColumn(name="pai_id")
	private CentroCusto pai;

	@OneToMany(mappedBy="pai")
	private List<CentroCusto> filhos;

	@Transient
	private String nomeCompleto; 

	public CentroCusto() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigoContabil() {
		return codigoContabil;
	}

	public void setCodigoContabil(String codigoContabil) {
		this.codigoContabil = codigoContabil;
	}

	public String getContaContabil() {
		return contaContabil;
	}

	public void setContaContabil(String contaContabil) {
		this.contaContabil = contaContabil;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPrefixo() {
		return prefixo;
	}

	public void setPrefixo(String prefixo) {
		this.prefixo = prefixo;
	}

	public String getNomeCompleto() {
		if (nomeCompleto == null) {
			if (prefixo != null) {
				nomeCompleto = prefixo + " - ";
			} else {
				nomeCompleto = "";
			}
			nomeCompleto += nome;
		}
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public CentroCusto getPai() {
		return pai;
	}

	public void setPai(CentroCusto pai) {
		this.pai = pai;
	}

	public List<CentroCusto> getFilhos() {
		return filhos;
	}

	public void setFilhos(List<CentroCusto> filhos) {
		this.filhos = filhos;
	}

}