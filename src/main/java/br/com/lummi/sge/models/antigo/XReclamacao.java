package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the mreclamacao database table.
 * 
 */
@Entity
@Table(name="mreclamacao")
public class XReclamacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String codigo;

	private Timestamp datahora;

	private Timestamp datahoraatendimentoid;

	private Timestamp datahoracadastro;

	private Timestamp datahoracancelamento;

	private Timestamp datahoraefetivacao;

	private String descricao;

	private String descritivo;

	private String emailconatato;

	private String nomecontato;

	private Timestamp previsaoretorno;

	private String resumo;

	private String status;

	private String telefonecontato;

	@ManyToOne
	@JoinColumn(name="empresaid")
	private XEmpresa empresa;

	@ManyToOne
	@JoinColumn(name="clienteid")
	private XPessoa pessoa;

	@ManyToOne
	@JoinColumn(name="tiporeclamacaoid")
	private XTipoReclamacao tipoReclamacao;

	@ManyToOne
	@JoinColumn(name="usuarioatendimentoid")
	private XUsuario usuario1;

	@ManyToOne
	@JoinColumn(name="usuariocadastroid")
	private XUsuario usuario2;

	@ManyToOne
	@JoinColumn(name="usuariocancelamentoid")
	private XUsuario usuario3;

	@ManyToOne
	@JoinColumn(name="usuarioefetivacaoid")
	private XUsuario usuario4;

	@ManyToOne
	@JoinColumn(name="usuarioresponsavelid")
	private XUsuario usuario5;

	@ManyToOne
	@JoinColumn(name="orcamentoid")
	private XOrcamento orcamento;

	@OneToMany(mappedBy="reclamacao")
	private List<XReclamacaoLink> reclamacaoLinks;

	public XReclamacao() {
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

	public Timestamp getDatahora() {
		return this.datahora;
	}

	public void setDatahora(Timestamp datahora) {
		this.datahora = datahora;
	}

	public Timestamp getDatahoraatendimentoid() {
		return this.datahoraatendimentoid;
	}

	public void setDatahoraatendimentoid(Timestamp datahoraatendimentoid) {
		this.datahoraatendimentoid = datahoraatendimentoid;
	}

	public Timestamp getDatahoracadastro() {
		return this.datahoracadastro;
	}

	public void setDatahoracadastro(Timestamp datahoracadastro) {
		this.datahoracadastro = datahoracadastro;
	}

	public Timestamp getDatahoracancelamento() {
		return this.datahoracancelamento;
	}

	public void setDatahoracancelamento(Timestamp datahoracancelamento) {
		this.datahoracancelamento = datahoracancelamento;
	}

	public Timestamp getDatahoraefetivacao() {
		return this.datahoraefetivacao;
	}

	public void setDatahoraefetivacao(Timestamp datahoraefetivacao) {
		this.datahoraefetivacao = datahoraefetivacao;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescritivo() {
		return this.descritivo;
	}

	public void setDescritivo(String descritivo) {
		this.descritivo = descritivo;
	}

	public String getEmailconatato() {
		return this.emailconatato;
	}

	public void setEmailconatato(String emailconatato) {
		this.emailconatato = emailconatato;
	}

	public String getNomecontato() {
		return this.nomecontato;
	}

	public void setNomecontato(String nomecontato) {
		this.nomecontato = nomecontato;
	}

	public Timestamp getPrevisaoretorno() {
		return this.previsaoretorno;
	}

	public void setPrevisaoretorno(Timestamp previsaoretorno) {
		this.previsaoretorno = previsaoretorno;
	}

	public String getResumo() {
		return this.resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTelefonecontato() {
		return this.telefonecontato;
	}

	public void setTelefonecontato(String telefonecontato) {
		this.telefonecontato = telefonecontato;
	}

	public XEmpresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(XEmpresa empresa) {
		this.empresa = empresa;
	}

	public XPessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(XPessoa pessoa) {
		this.pessoa = pessoa;
	}

	public XTipoReclamacao getTipoReclamacao() {
		return tipoReclamacao;
	}

	public void setTipoReclamacao(XTipoReclamacao tipoReclamacao) {
		this.tipoReclamacao = tipoReclamacao;
	}

	public XUsuario getUsuario1() {
		return this.usuario1;
	}

	public void setUsuario1(XUsuario usuario1) {
		this.usuario1 = usuario1;
	}

	public XUsuario getUsuario2() {
		return this.usuario2;
	}

	public void setUsuario2(XUsuario usuario2) {
		this.usuario2 = usuario2;
	}

	public XUsuario getUsuario3() {
		return this.usuario3;
	}

	public void setUsuario3(XUsuario usuario3) {
		this.usuario3 = usuario3;
	}

	public XUsuario getUsuario4() {
		return this.usuario4;
	}

	public void setUsuario4(XUsuario usuario4) {
		this.usuario4 = usuario4;
	}

	public XUsuario getUsuario5() {
		return this.usuario5;
	}

	public void setUsuario5(XUsuario usuario5) {
		this.usuario5 = usuario5;
	}

	public XOrcamento getOrcamento() {
		return this.orcamento;
	}

	public void setOrcamento(XOrcamento orcamento) {
		this.orcamento = orcamento;
	}

	public List<XReclamacaoLink> getReclamacaoLinks() {
		return this.reclamacaoLinks;
	}

	public void setReclamacaoLinks(List<XReclamacaoLink> reclamacaoLinks) {
		this.reclamacaoLinks = reclamacaoLinks;
	}

}