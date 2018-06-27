package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import java.sql.Time;
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
 * The persistent class for the magenda database table.
 * 
 */
@Entity
@Table(name="magenda")
public class XAgenda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String categoria;

	private String codigo;

	private String controle;

	@Temporal(TemporalType.TIMESTAMP)
	private Date data;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datahoraagendamento;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datahoraconfirmacao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datahoraefetivacao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datahoranaoocorrencia;

	private String descricao;

	private Time horainicio;

	private Time horatermino;

	private String localagenda;

	private String status;

	private String tipo;

	private String titulo;

	private String tratamento;

	@ManyToOne
	@JoinColumn(name="assuntoid")
	private XAssuntoAgenda assuntoAgenda;

	@ManyToOne
	@JoinColumn(name="salaid")
	private XSala sala;

	@ManyToOne
	@JoinColumn(name="usuarioagendamentoid")
	private XUsuario usuarioAgendamento;

	@ManyToOne
	@JoinColumn(name="usuarioconfirmacaoid")
	private XUsuario usuarioConfirmacao;

	@ManyToOne
	@JoinColumn(name="usuarioefetivacaoid")
	private XUsuario usuarioEfetivacao;

	@ManyToOne
	@JoinColumn(name="usuarionaoocorrenciaid")
	private XUsuario usuarioNaoOcorrencia;

	@ManyToOne
	@JoinColumn(name="atareuniaoid")
	private XAtaReuniao ataReuniao;

	@ManyToOne
	@JoinColumn(name="projetoid")
	private XProjeto projeto;

	@OneToMany(mappedBy="agenda")
	private List<XAgendaParticipanteExterno> agendaParticipantesExternos;

	@OneToMany(mappedBy="agenda")
	private List<XAgendaParticipante> agendaParticipantes;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getControle() {
		return controle;
	}

	public void setControle(String controle) {
		this.controle = controle;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getDatahoraagendamento() {
		return datahoraagendamento;
	}

	public void setDatahoraagendamento(Date datahoraagendamento) {
		this.datahoraagendamento = datahoraagendamento;
	}

	public Date getDatahoraconfirmacao() {
		return datahoraconfirmacao;
	}

	public void setDatahoraconfirmacao(Date datahoraconfirmacao) {
		this.datahoraconfirmacao = datahoraconfirmacao;
	}

	public Date getDatahoraefetivacao() {
		return datahoraefetivacao;
	}

	public void setDatahoraefetivacao(Date datahoraefetivacao) {
		this.datahoraefetivacao = datahoraefetivacao;
	}

	public Date getDatahoranaoocorrencia() {
		return datahoranaoocorrencia;
	}

	public void setDatahoranaoocorrencia(Date datahoranaoocorrencia) {
		this.datahoranaoocorrencia = datahoranaoocorrencia;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Time getHorainicio() {
		return horainicio;
	}

	public void setHorainicio(Time horainicio) {
		this.horainicio = horainicio;
	}

	public Time getHoratermino() {
		return horatermino;
	}

	public void setHoratermino(Time horatermino) {
		this.horatermino = horatermino;
	}

	public String getLocalagenda() {
		return localagenda;
	}

	public void setLocalagenda(String localagenda) {
		this.localagenda = localagenda;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTratamento() {
		return tratamento;
	}

	public void setTratamento(String tratamento) {
		this.tratamento = tratamento;
	}

	public XAssuntoAgenda getAssuntoAgenda() {
		return assuntoAgenda;
	}

	public void setAssuntoAgenda(XAssuntoAgenda assuntoAgenda) {
		this.assuntoAgenda = assuntoAgenda;
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

	public XUsuario getUsuarioConfirmacao() {
		return usuarioConfirmacao;
	}

	public void setUsuarioConfirmacao(XUsuario usuarioConfirmacao) {
		this.usuarioConfirmacao = usuarioConfirmacao;
	}

	public XUsuario getUsuarioEfetivacao() {
		return usuarioEfetivacao;
	}

	public void setUsuarioEfetivacao(XUsuario usuarioEfetivacao) {
		this.usuarioEfetivacao = usuarioEfetivacao;
	}

	public XUsuario getUsuarioNaoOcorrencia() {
		return usuarioNaoOcorrencia;
	}

	public void setUsuarioNaoOcorrencia(XUsuario usuarioNaoOcorrencia) {
		this.usuarioNaoOcorrencia = usuarioNaoOcorrencia;
	}

	public XAtaReuniao getAtaReuniao() {
		return ataReuniao;
	}

	public void setAtaReuniao(XAtaReuniao ataReuniao) {
		this.ataReuniao = ataReuniao;
	}

	public XProjeto getProjeto() {
		return projeto;
	}

	public void setProjeto(XProjeto projeto) {
		this.projeto = projeto;
	}

	public List<XAgendaParticipanteExterno> getAgendaParticipantesExternos() {
		return agendaParticipantesExternos;
	}

	public void setAgendaParticipantesExternos(List<XAgendaParticipanteExterno> agendaParticipantesExternos) {
		this.agendaParticipantesExternos = agendaParticipantesExternos;
	}

	public List<XAgendaParticipante> getAgendaParticipantes() {
		return agendaParticipantes;
	}

	public void setAgendaParticipantes(List<XAgendaParticipante> agendaParticipantes) {
		this.agendaParticipantes = agendaParticipantes;
	}

	public XAgenda() {
	}

}