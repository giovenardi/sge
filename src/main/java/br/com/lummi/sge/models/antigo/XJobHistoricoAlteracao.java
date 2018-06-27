package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the mjobhistoricoalteracao database table.
 * 
 */
@Entity
@Table(name="mjobhistoricoalteracao")
public class XJobHistoricoAlteracao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Timestamp datahora;

	private Timestamp datahoracadastro;

	private String detalhamento;

	private String guiareferencia;

	private String item;

	private String titulo;

	@ManyToOne
	@JoinColumn(name="usuariocadastroid")
	private XUsuario usuario1;

	@ManyToOne
	@JoinColumn(name="usuariodestinoid")
	private XUsuario usuario2;

	@ManyToOne
	@JoinColumn(name="jobid")
	private XJob mjob;

	@OneToMany(mappedBy="jobHistoricoAlteracao")
	private List<XJobNotificacao> jobsNotificacao;

	public XJobHistoricoAlteracao() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getDatahora() {
		return this.datahora;
	}

	public void setDatahora(Timestamp datahora) {
		this.datahora = datahora;
	}

	public Timestamp getDatahoracadastro() {
		return this.datahoracadastro;
	}

	public void setDatahoracadastro(Timestamp datahoracadastro) {
		this.datahoracadastro = datahoracadastro;
	}

	public String getDetalhamento() {
		return this.detalhamento;
	}

	public void setDetalhamento(String detalhamento) {
		this.detalhamento = detalhamento;
	}

	public String getGuiareferencia() {
		return this.guiareferencia;
	}

	public void setGuiareferencia(String guiareferencia) {
		this.guiareferencia = guiareferencia;
	}

	public String getItem() {
		return this.item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public XUsuario getUsuario1() {
		return usuario1;
	}

	public void setUsuario1(XUsuario usuario1) {
		this.usuario1 = usuario1;
	}

	public XUsuario getUsuario2() {
		return usuario2;
	}

	public void setUsuario2(XUsuario usuario2) {
		this.usuario2 = usuario2;
	}

	public XJob getMjob() {
		return mjob;
	}

	public void setMjob(XJob mjob) {
		this.mjob = mjob;
	}

	public List<XJobNotificacao> getJobsNotificacao() {
		return jobsNotificacao;
	}

	public void setJobsNotificacao(List<XJobNotificacao> jobsNotificacao) {
		this.jobsNotificacao = jobsNotificacao;
	}

}