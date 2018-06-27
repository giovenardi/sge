package br.com.lummi.sge.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipo")
@Entity
@Table(name="pessoa")
public class Pessoa implements Entidade {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="pessoa_id_seq", sequenceName="pessoa_id_seq", allocationSize=1)
	@GeneratedValue(generator="pessoa_id_seq")
	private Integer id;

	@ManyToOne(cascade={CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name="dado_bancario_id")
	private DadosBancarios dadosBancarios;

	@ManyToOne(cascade={CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name="endereco_id")
	private Endereco endereco;

	@Column(name="codigo")
	private String codigo;

	@Column(name="email_principal")
	private String emailPrincipal;

	@Column(name="email_secundario")
	private String emailSecundario;

	@Column(name="fax")
	private String fax;

	@Column(name="observacao")
	private String observacao;

	@Column(name="facebook")
	private String facebook;

	@Column(name="site")
	private String site;

	@Column(name="telefone_fixo")
	private String telefoneFixo;

	@Column(name="telefone_celular")
	private String telefoneCelular;

	@Column(name="id_nextel")
	private String idNextel;
	
	@Column(name="twitter")
	private String twitter;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public DadosBancarios getDadosBancarios() {
		return dadosBancarios;
	}

	public void setDadosBancarios(DadosBancarios dadosBancarios) {
		this.dadosBancarios = dadosBancarios;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getEmailPrincipal() {
		return emailPrincipal;
	}

	public void setEmailPrincipal(String emailPrincipal) {
		this.emailPrincipal = emailPrincipal;
	}

	public String getEmailSecundario() {
		return emailSecundario;
	}

	public void setEmailSecundario(String emailSecundario) {
		this.emailSecundario = emailSecundario;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getIdNextel() {
		return idNextel;
	}

	public void setIdNextel(String idNextel) {
		this.idNextel = idNextel;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getTelefoneFixo() {
		return telefoneFixo;
	}

	public void setTelefoneFixo(String telefoneFixo) {
		this.telefoneFixo = telefoneFixo;
	}

	public String getTelefoneCelular() {
		return telefoneCelular;
	}

	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}


}