package br.com.lummi.sge.models.global;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import br.com.lummi.sge.enums.AcaoEnum;
import br.com.lummi.sge.models.Entidade;
import br.com.lummi.sge.models.autenticacao.ZUsuario;
import br.com.lummi.sge.models.transiente.ItemLog;


/**
 * The persistent class for the auditorias database table.
 * 
 */
public class Auditoria implements Entidade {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "auditorias_id_seq")
	@SequenceGenerator(name = "auditorias_id_seq", sequenceName = "global.auditorias_id_seq", allocationSize = 1)
	private Integer id;

	@Column(name="created_at", insertable=false, updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	@Column(name="estado_anterior")
	private String estadoAnterior;
	
	@Transient
	private Entidade entidadeAnterior;

	@Column(name="estado_atual")
	private String estadoAtual;

	@Transient
	private Entidade entidadeAtual;

	@Column(name="informacoes_extras")
	private String informacoesExtras;

	@Column(name="ip_origem")
	private String ipOrigem;

	@Column(name="object_id")
	private Integer objectId;

	@Column(name="object_type")
	private String objectType;
	
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private ZUsuario usuario;

	@Column(name="acao")
	@Enumerated(EnumType.ORDINAL)
	private AcaoEnum acao;

	@Transient
	private List<ItemLog> itensLog;

	public Auditoria() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getEstadoAnterior() {
		return this.estadoAnterior;
	}

	public void setEstadoAnterior(String estadoAnterior) {
		this.estadoAnterior = estadoAnterior;
	}

	public String getEstadoAtual() {
		return this.estadoAtual;
	}

	public void setEstadoAtual(String estadoAtual) {
		this.estadoAtual = estadoAtual;
	}

	public String getInformacoesExtras() {
		return this.informacoesExtras;
	}

	public void setInformacoesExtras(String informacoesExtras) {
		this.informacoesExtras = informacoesExtras;
	}

	public String getIpOrigem() {
		return this.ipOrigem;
	}

	public void setIpOrigem(String ipOrigem) {
		this.ipOrigem = ipOrigem;
	}

	public Integer getObjectId() {
		return this.objectId;
	}

	public void setObjectId(Integer objectId) {
		this.objectId = objectId;
	}

	public String getObjectType() {
		return this.objectType;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	public ZUsuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(ZUsuario usuario) {
		this.usuario = usuario;
	}

	public AcaoEnum getAcao() {
		return this.acao;
	}

	public void setAcao(AcaoEnum acao) {
		this.acao = acao;
	}

	public Entidade getEntidadeAnterior() {
		return entidadeAnterior;
	}

	public void setEntidadeAnterior(Entidade entidadeAnterior) {
		this.entidadeAnterior = entidadeAnterior;
	}

	public Entidade getEntidadeAtual() {
		return entidadeAtual;
	}

	public void setEntidadeAtual(Entidade entidadeAtual) {
		this.entidadeAtual = entidadeAtual;
	}

	public void setItensLog(List<ItemLog> itensLog) {
		this.itensLog = itensLog;
	}

	public List<ItemLog> getItensLog() {
		return this.itensLog;
	}

}