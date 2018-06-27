package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the mprospeccao database table.
 * 
 */
@Entity
@Table(name="mprospeccao")
public class XProspeccao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String breveresumo;

	private String codigo;

	private String conatoemail;

	private String contatonome;

	private String contatotelefone1;

	private String contatotelefone2;

	private Timestamp datacadastro;

	private Timestamp datahoraefetivacao;

	private Timestamp datahoranegacao;

	private Timestamp emissao;

	private String nomecliente;

	private String status;

	private String tipo;

	private Integer tipopessoa;

	@ManyToOne
	@JoinColumn(name="cidadeid")
	private XCidade cidade;

	@ManyToOne
	@JoinColumn(name="pessoaid")
	private XPessoa pessoa;

	@ManyToOne
	@JoinColumn(name="usuariocadastroid")
	private XUsuario usuarioCadastro;

	@ManyToOne
	@JoinColumn(name="usuarioefetivacaoid")
	private XUsuario usuarioEfetivacao;

	@ManyToOne
	@JoinColumn(name="usuarionegacaoid")
	private XUsuario usuarioNegacao;

	@ManyToOne
	@JoinColumn(name="jobid")
	private XJob job;

	@OneToMany(mappedBy="prospeccao")
	private List<XProspeccaoAcompanhamento> mprospeccaoacompanhamentos;

	@OneToMany(mappedBy="prospeccao")
	private List<XProspeccaoLembrete> prospeccaoLembretes;

	public XProspeccao() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBreveresumo() {
		return this.breveresumo;
	}

	public void setBreveresumo(String breveresumo) {
		this.breveresumo = breveresumo;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getConatoemail() {
		return this.conatoemail;
	}

	public void setConatoemail(String conatoemail) {
		this.conatoemail = conatoemail;
	}

	public String getContatonome() {
		return this.contatonome;
	}

	public void setContatonome(String contatonome) {
		this.contatonome = contatonome;
	}

	public String getContatotelefone1() {
		return this.contatotelefone1;
	}

	public void setContatotelefone1(String contatotelefone1) {
		this.contatotelefone1 = contatotelefone1;
	}

	public String getContatotelefone2() {
		return this.contatotelefone2;
	}

	public void setContatotelefone2(String contatotelefone2) {
		this.contatotelefone2 = contatotelefone2;
	}

	public Timestamp getDatacadastro() {
		return this.datacadastro;
	}

	public void setDatacadastro(Timestamp datacadastro) {
		this.datacadastro = datacadastro;
	}

	public Timestamp getDatahoraefetivacao() {
		return this.datahoraefetivacao;
	}

	public void setDatahoraefetivacao(Timestamp datahoraefetivacao) {
		this.datahoraefetivacao = datahoraefetivacao;
	}

	public Timestamp getDatahoranegacao() {
		return this.datahoranegacao;
	}

	public void setDatahoranegacao(Timestamp datahoranegacao) {
		this.datahoranegacao = datahoranegacao;
	}

	public Timestamp getEmissao() {
		return this.emissao;
	}

	public void setEmissao(Timestamp emissao) {
		this.emissao = emissao;
	}

	public String getNomecliente() {
		return this.nomecliente;
	}

	public void setNomecliente(String nomecliente) {
		this.nomecliente = nomecliente;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getTipopessoa() {
		return this.tipopessoa;
	}

	public void setTipopessoa(Integer tipopessoa) {
		this.tipopessoa = tipopessoa;
	}

	public XCidade getCidade() {
		return cidade;
	}

	public void setCidade(XCidade cidade) {
		this.cidade = cidade;
	}

	public XPessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(XPessoa pessoa) {
		this.pessoa = pessoa;
	}

	public XUsuario getUsuarioCadastro() {
		return usuarioCadastro;
	}

	public void setUsuarioCadastro(XUsuario usuarioCadastro) {
		this.usuarioCadastro = usuarioCadastro;
	}

	public XUsuario getUsuarioEfetivacao() {
		return usuarioEfetivacao;
	}

	public void setUsuarioEfetivacao(XUsuario usuarioEfetivacao) {
		this.usuarioEfetivacao = usuarioEfetivacao;
	}

	public XUsuario getUsuarioNegacao() {
		return usuarioNegacao;
	}

	public void setUsuarioNegacao(XUsuario usuarioNegacao) {
		this.usuarioNegacao = usuarioNegacao;
	}

	public XJob getJob() {
		return job;
	}

	public void setJob(XJob job) {
		this.job = job;
	}

	public List<XProspeccaoAcompanhamento> getMprospeccaoacompanhamentos() {
		return mprospeccaoacompanhamentos;
	}

	public void setMprospeccaoacompanhamentos(List<XProspeccaoAcompanhamento> mprospeccaoacompanhamentos) {
		this.mprospeccaoacompanhamentos = mprospeccaoacompanhamentos;
	}

	public List<XProspeccaoLembrete> getProspeccaoLembretes() {
		return prospeccaoLembretes;
	}

	public void setProspeccaoLembretes(List<XProspeccaoLembrete> prospeccaoLembretes) {
		this.prospeccaoLembretes = prospeccaoLembretes;
	}

}