package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the mtarefaindependente database table.
 * 
 */
@Entity
@Table(name="mtarefaindependente")
public class XTarefaIndependente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String codigo;

	private String controle;

	private Timestamp datalancamento;

	private Timestamp datalimite;

	private Timestamp datarecebimento;

	private String descricao;

	private Boolean ehconcluidoaviso;

	private String enderecoarquivo;

	private String motivopausa;

	private String observacao;

	private Boolean pausa;

	private String prioridade;

	private String relatorioconclusao;

	private String status;

	private BigDecimal tempoexecucao;

	private String tipo;

	//bi-directional many-to-one association to Ccentroresultado
	@ManyToOne
	@JoinColumn(name="centroresultadoid")
	private XCentroResultado centroResultado;

	//bi-directional many-to-one association to Csetor
	@ManyToOne
	@JoinColumn(name="setorid")
	private XSetor setor;

	@ManyToOne
	@JoinColumn(name="tarefaid")
	private XTarefa tarefa;

	//bi-directional many-to-one association to Cusuario
	@ManyToOne
	@JoinColumn(name="usuariolancamentoid")
	private XUsuario usuario1;

	//bi-directional many-to-one association to Cusuario
	@ManyToOne
	@JoinColumn(name="usuarioresponsavelid")
	private XUsuario usuario2;

	//bi-directional many-to-one association to Mtarefaindependenteapropriacaohora
	@OneToMany(mappedBy="tarefaIndependente")
	private List<XTarefaIndependenteApropriacaoHora> tarefaIndependenteApropriacaoHoras;

	//bi-directional many-to-one association to Mtarefaindependentelinkcomplementar
	@OneToMany(mappedBy="tarefaIndependente")
	private List<XTarefaIndependenteLinkComplementar> tarefasIndependentesLinkComplementar;

	//bi-directional many-to-one association to Mtarefaindependenteprotocolo
	@OneToMany(mappedBy="tarefaIndependente")
	private List<XTarefaIndependenteProtocolo> tarefaIndependenteProtocolos;

	public XTarefaIndependente() {
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

	public String getControle() {
		return this.controle;
	}

	public void setControle(String controle) {
		this.controle = controle;
	}

	public Timestamp getDatalancamento() {
		return this.datalancamento;
	}

	public void setDatalancamento(Timestamp datalancamento) {
		this.datalancamento = datalancamento;
	}

	public Timestamp getDatalimite() {
		return this.datalimite;
	}

	public void setDatalimite(Timestamp datalimite) {
		this.datalimite = datalimite;
	}

	public Timestamp getDatarecebimento() {
		return this.datarecebimento;
	}

	public void setDatarecebimento(Timestamp datarecebimento) {
		this.datarecebimento = datarecebimento;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getEhconcluidoaviso() {
		return this.ehconcluidoaviso;
	}

	public void setEhconcluidoaviso(Boolean ehconcluidoaviso) {
		this.ehconcluidoaviso = ehconcluidoaviso;
	}

	public String getEnderecoarquivo() {
		return this.enderecoarquivo;
	}

	public void setEnderecoarquivo(String enderecoarquivo) {
		this.enderecoarquivo = enderecoarquivo;
	}

	public String getMotivopausa() {
		return this.motivopausa;
	}

	public void setMotivopausa(String motivopausa) {
		this.motivopausa = motivopausa;
	}

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Boolean getPausa() {
		return this.pausa;
	}

	public void setPausa(Boolean pausa) {
		this.pausa = pausa;
	}

	public String getPrioridade() {
		return this.prioridade;
	}

	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}

	public String getRelatorioconclusao() {
		return this.relatorioconclusao;
	}

	public void setRelatorioconclusao(String relatorioconclusao) {
		this.relatorioconclusao = relatorioconclusao;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getTempoexecucao() {
		return this.tempoexecucao;
	}

	public void setTempoexecucao(BigDecimal tempoexecucao) {
		this.tempoexecucao = tempoexecucao;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public XCentroResultado getCentroResultado() {
		return this.centroResultado;
	}

	public void setCentroResultado(XCentroResultado centroResultado) {
		this.centroResultado = centroResultado;
	}

	public XSetor getSetor() {
		return this.setor;
	}

	public void setSetor(XSetor setor) {
		this.setor = setor;
	}

	public XTarefa getTarefa() {
		return tarefa;
	}

	public void setTarefa(XTarefa tarefa) {
		this.tarefa = tarefa;
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

	public List<XTarefaIndependenteApropriacaoHora> getTarefaIndependenteApropriacaoHoras() {
		return this.tarefaIndependenteApropriacaoHoras;
	}

	public void setTarefaIndependenteApropriacaoHoras(List<XTarefaIndependenteApropriacaoHora> tarefaIndependenteApropriacaoHoras) {
		this.tarefaIndependenteApropriacaoHoras = tarefaIndependenteApropriacaoHoras;
	}

	public List<XTarefaIndependenteLinkComplementar> getTarefasIndependentesLinkComplementar() {
		return tarefasIndependentesLinkComplementar;
	}

	public void setTarefasIndependentesLinkComplementar(
			List<XTarefaIndependenteLinkComplementar> tarefasIndependentesLinkComplementar) {
		this.tarefasIndependentesLinkComplementar = tarefasIndependentesLinkComplementar;
	}

	public List<XTarefaIndependenteProtocolo> getTarefaIndependenteProtocolos() {
		return this.tarefaIndependenteProtocolos;
	}

	public void setTarefaIndependenteProtocolos(List<XTarefaIndependenteProtocolo> tarefaIndependenteProtocolos) {
		this.tarefaIndependenteProtocolos = tarefaIndependenteProtocolos;
	}

}