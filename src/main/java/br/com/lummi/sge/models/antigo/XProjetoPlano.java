package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the mprojetoplano database table.
 * 
 */
@Entity
@Table(name="mprojetoplano")
public class XProjetoPlano implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Integer convitesgraficosimple;

	private Integer convitesgraficosluxo;

	private String nome;

	private Integer qtdconvidados;

	private BigDecimal valororiginal;

	//bi-directional many-to-one association to Mprojeto
	@ManyToOne
	@JoinColumn(name="projetoid")
	private XProjeto projeto;

	public XProjetoPlano() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getConvitesgraficosimple() {
		return this.convitesgraficosimple;
	}

	public void setConvitesgraficosimple(Integer convitesgraficosimple) {
		this.convitesgraficosimple = convitesgraficosimple;
	}

	public Integer getConvitesgraficosluxo() {
		return this.convitesgraficosluxo;
	}

	public void setConvitesgraficosluxo(Integer convitesgraficosluxo) {
		this.convitesgraficosluxo = convitesgraficosluxo;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getQtdconvidados() {
		return this.qtdconvidados;
	}

	public void setQtdconvidados(Integer qtdconvidados) {
		this.qtdconvidados = qtdconvidados;
	}

	public BigDecimal getValororiginal() {
		return this.valororiginal;
	}

	public void setValororiginal(BigDecimal valororiginal) {
		this.valororiginal = valororiginal;
	}

	public XProjeto getProjeto() {
		return projeto;
	}

	public void setProjeto(XProjeto projeto) {
		this.projeto = projeto;
	}

}