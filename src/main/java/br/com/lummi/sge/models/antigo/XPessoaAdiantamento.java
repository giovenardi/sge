package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the cpessoaadiantamento database table.
 * 
 */
@Entity
@Table(name="cpessoaadiantamento")
public class XPessoaAdiantamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Integer adiantamentoreferencia;

	private String codigo;

	private Timestamp datahora;

	private Boolean estornado;

	private String historico;

	private String operacao;

	private BigDecimal valor;

	//bi-directional many-to-one association to Cpessoa
	@ManyToOne
	@JoinColumn(name="pessoaid")
	private XPessoa pessoa;

	//bi-directional many-to-one association to Cusuario
	@ManyToOne
	@JoinColumn(name="usuarioid")
	private XUsuario usuario;

	public XPessoaAdiantamento() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAdiantamentoreferencia() {
		return this.adiantamentoreferencia;
	}

	public void setAdiantamentoreferencia(Integer adiantamentoreferencia) {
		this.adiantamentoreferencia = adiantamentoreferencia;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Timestamp getDatahora() {
		return this.datahora;
	}

	public void setDatahora(Timestamp datahora) {
		this.datahora = datahora;
	}

	public Boolean getEstornado() {
		return this.estornado;
	}

	public void setEstornado(Boolean estornado) {
		this.estornado = estornado;
	}

	public String getHistorico() {
		return this.historico;
	}

	public void setHistorico(String historico) {
		this.historico = historico;
	}

	public String getOperacao() {
		return this.operacao;
	}

	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}

	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public XPessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(XPessoa pessoa) {
		this.pessoa = pessoa;
	}

	public XUsuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(XUsuario usuario) {
		this.usuario = usuario;
	}

}