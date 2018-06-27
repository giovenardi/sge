package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the matareuniao database table.
 * 
 */
@Entity
@Table(name="matareuniao")
public class XAtaReuniao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String ata;

	private String codigo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datahora;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datahoraagendamento;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datahoracadastro;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datahoranaorarealizacao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datahorarealizacao;

	private String linkAtaImpressa;

	private String locall;

	private String pauta;

	private String status;

	private String tiporeuniao;

	@OneToMany(mappedBy="ataReuniao")
	private List<XAgenda> agendas;

	@ManyToOne
	@JoinColumn(name="assuntoid")
	private XAssunto assunto;

	@ManyToOne
	@JoinColumn(name="salaid")
	private XSala sala;

	@ManyToOne
	@JoinColumn(name="usuarioagendamentoid")
	private XUsuario usuarioAgendamento;

	@ManyToOne
	@JoinColumn(name="usuariocadastroid")
	private XUsuario usuarioCadastro;

	@ManyToOne
	@JoinColumn(name="usuarionaorarealizacaoid")
	private XUsuario usuarioNaoRealizacao;

	@ManyToOne
	@JoinColumn(name="usuariorarealizacaoid")
	private XUsuario usuarioraRealizacao;

	@ManyToOne
	@JoinColumn(name="projetoid")
	private XProjeto projeto;

	@ManyToOne
	@JoinColumn(name="registrocursoid")
	private XProjetoCurso projetoCurso;

	@OneToMany(mappedBy="ataReuniao")
	private List<XAtaReuniaoParticipante> ataReuniaoParticipantes;

	public XAtaReuniao() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAta() {
		return ata;
	}

	public void setAta(String ata) {
		this.ata = ata;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Date getDatahora() {
		return datahora;
	}

	public void setDatahora(Date datahora) {
		this.datahora = datahora;
	}

	public Date getDatahoraagendamento() {
		return datahoraagendamento;
	}

	public void setDatahoraagendamento(Date datahoraagendamento) {
		this.datahoraagendamento = datahoraagendamento;
	}

	public Date getDatahoracadastro() {
		return datahoracadastro;
	}

	public void setDatahoracadastro(Date datahoracadastro) {
		this.datahoracadastro = datahoracadastro;
	}

	public Date getDatahoranaorarealizacao() {
		return datahoranaorarealizacao;
	}

	public void setDatahoranaorarealizacao(Date datahoranaorarealizacao) {
		this.datahoranaorarealizacao = datahoranaorarealizacao;
	}

	public Date getDatahorarealizacao() {
		return datahorarealizacao;
	}

	public void setDatahorarealizacao(Date datahorarealizacao) {
		this.datahorarealizacao = datahorarealizacao;
	}

	public String getLinkAtaImpressa() {
		return linkAtaImpressa;
	}

	public void setLinkAtaImpressa(String linkAtaImpressa) {
		this.linkAtaImpressa = linkAtaImpressa;
	}

	public String getLocall() {
		return locall;
	}

	public void setLocall(String locall) {
		this.locall = locall;
	}

	public String getPauta() {
		return pauta;
	}

	public void setPauta(String pauta) {
		this.pauta = pauta;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTiporeuniao() {
		return tiporeuniao;
	}

	public void setTiporeuniao(String tiporeuniao) {
		this.tiporeuniao = tiporeuniao;
	}

	public List<XAgenda> getAgendas() {
		return agendas;
	}

	public void setAgendas(List<XAgenda> agendas) {
		this.agendas = agendas;
	}

	public XAssunto getAssunto() {
		return assunto;
	}

	public void setAssunto(XAssunto assunto) {
		this.assunto = assunto;
	}

	public XSala getSala() {
		return sala;
	}

	public void setSala(XSala sala) {
		this.sala = sala;
	}

	public XUsuario getUsuarioAgendamento() {
		return usuarioAgendamento;
	}

	public void setUsuarioAgendamento(XUsuario usuarioAgendamento) {
		this.usuarioAgendamento = usuarioAgendamento;
	}

	public XUsuario getUsuarioCadastro() {
		return usuarioCadastro;
	}

	public void setUsuarioCadastro(XUsuario usuarioCadastro) {
		this.usuarioCadastro = usuarioCadastro;
	}

	public XUsuario getUsuarioNaoRealizacao() {
		return usuarioNaoRealizacao;
	}

	public void setUsuarioNaoRealizacao(XUsuario usuarioNaoRealizacao) {
		this.usuarioNaoRealizacao = usuarioNaoRealizacao;
	}

	public XUsuario getUsuarioraRealizacao() {
		return usuarioraRealizacao;
	}

	public void setUsuarioraRealizacao(XUsuario usuarioraRealizacao) {
		this.usuarioraRealizacao = usuarioraRealizacao;
	}

	public XProjeto getProjeto() {
		return projeto;
	}

	public void setProjeto(XProjeto projeto) {
		this.projeto = projeto;
	}

	public XProjetoCurso getProjetoCurso() {
		return projetoCurso;
	}

	public void setProjetoCurso(XProjetoCurso projetoCurso) {
		this.projetoCurso = projetoCurso;
	}

	public List<XAtaReuniaoParticipante> getAtaReuniaoParticipantes() {
		return ataReuniaoParticipantes;
	}

	public void setAtaReuniaoParticipantes(List<XAtaReuniaoParticipante> ataReuniaoParticipantes) {
		this.ataReuniaoParticipantes = ataReuniaoParticipantes;
	}

}