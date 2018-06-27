package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the mcontacorrentefinanceira database table.
 * 
 */
@Entity
@Table(name="mcontacorrentefinanceira")
public class XContaCorrenteFinanceira implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String codigo;

	private String codigocheque;

	private Boolean conciliado;

	private String controle;

	private Timestamp datacadastro;

	private Timestamp datahora;

	private String descricao;

	private String direcao;

	private String obs;

	private String origem;

	private BigDecimal valor;

	@ManyToOne
	@JoinColumn(name="contafinanceiraid")
	private XContaFinanceira contaFinanceira;

	@ManyToOne
	@JoinColumn(name="usuarioid")
	private XUsuario usuario;

	public XContaCorrenteFinanceira() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigocheque() {
		return this.codigocheque;
	}

	public void setCodigocheque(String codigocheque) {
		this.codigocheque = codigocheque;
	}

	public Boolean getConciliado() {
		return this.conciliado;
	}

	public void setConciliado(Boolean conciliado) {
		this.conciliado = conciliado;
	}

	public String getControle() {
		return this.controle;
	}

	public void setControle(String controle) {
		this.controle = controle;
	}

	public Timestamp getDatacadastro() {
		return this.datacadastro;
	}

	public void setDatacadastro(Timestamp datacadastro) {
		this.datacadastro = datacadastro;
	}

	public Timestamp getDatahora() {
		return this.datahora;
	}

	public void setDatahora(Timestamp datahora) {
		this.datahora = datahora;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDirecao() {
		return this.direcao;
	}

	public void setDirecao(String direcao) {
		this.direcao = direcao;
	}

	public String getObs() {
		return this.obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public String getOrigem() {
		return this.origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public XContaFinanceira getContaFinanceira() {
		return contaFinanceira;
	}

	public void setContaFinanceira(XContaFinanceira contaFinanceira) {
		this.contaFinanceira = contaFinanceira;
	}

	public XUsuario getUsuario() {
		return usuario;
	}

	public void setUsuario(XUsuario usuario) {
		this.usuario = usuario;
	}

}