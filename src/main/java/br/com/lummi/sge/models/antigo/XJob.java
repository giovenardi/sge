package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the mjob database table.
 * 
 */
@Entity
@Table(name="mjob")
public class XJob implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Integer campanhaid;

	private String codigo;

	private String compressaodemanda;

	private String controle;

	private String cronogramaentrega;

	private Timestamp data;

	private Timestamp dataapresexterna;

	private Timestamp dataapresinterna;

	private Timestamp datacadastro;

	private Timestamp datacancelamento;

	private Timestamp datacliente;

	private Timestamp dataconclusao;

	private Timestamp dataenvioprojeto;

	private Timestamp dataexecucao;

	private Timestamp datafechamento;

	private Timestamp datanegacao;

	private String descricao;

	private Boolean ehcronograma;

	private Boolean ehnotasite;

	private Boolean ehplanejamento;

	private Boolean ehrelatorio;

	private String emailcontato;

	private String justificativa;

	private String motivocancelamento;

	private Integer motivocancelamentoid;

	private String motivonegacao;

	private Integer motivonegacaoid;

	private String motivopausa;

	private String nomecontato;

	private String objetivos;

	private String obs;

	private String orcamentoestimado;

	private Boolean pausa;

	private String permissaorestricao;

	private String posicaopagamento;

	private String publicoalvo;

	private String responsaveis;

	private String status;

	private String telefonecontato;

	private Integer usuariocadastroid;

	@ManyToOne
	@JoinColumn(name="clienteid")
	private XPessoa pessoa;

	@ManyToOne
	@JoinColumn(name="tipojobid")
	private XTipoJob tipoJob;

	@ManyToOne
	@JoinColumn(name="atendenteid")
	private XUsuario usuario;

	@OneToMany(mappedBy="mjob")
	private List<XJobHistoricoAlteracao> jobsHistoricoAlteracao;

	@OneToMany(mappedBy="job")
	private List<XJobLinkComplementar> jobsLinkComplementar;

	@OneToMany(mappedBy="job")
	private List<XJobParceiro> jobParceiros;

	@OneToMany(mappedBy="job")
	private List<XJobResponsavelInterno> jobResponsavelInternos;

	@OneToMany(mappedBy="job")
	private List<XJobTarefa> jobtarefas;

	@OneToMany(mappedBy="job")
	private List<XOrcamento> orcamentos;

	@OneToMany(mappedBy="job")
	private List<XProspeccao> prospeccoes;

	public XJob() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCampanhaid() {
		return this.campanhaid;
	}

	public void setCampanhaid(Integer campanhaid) {
		this.campanhaid = campanhaid;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCompressaodemanda() {
		return this.compressaodemanda;
	}

	public void setCompressaodemanda(String compressaodemanda) {
		this.compressaodemanda = compressaodemanda;
	}

	public String getControle() {
		return this.controle;
	}

	public void setControle(String controle) {
		this.controle = controle;
	}

	public String getCronogramaentrega() {
		return this.cronogramaentrega;
	}

	public void setCronogramaentrega(String cronogramaentrega) {
		this.cronogramaentrega = cronogramaentrega;
	}

	public Timestamp getData() {
		return this.data;
	}

	public void setData(Timestamp data) {
		this.data = data;
	}

	public Timestamp getDataapresexterna() {
		return this.dataapresexterna;
	}

	public void setDataapresexterna(Timestamp dataapresexterna) {
		this.dataapresexterna = dataapresexterna;
	}

	public Timestamp getDataapresinterna() {
		return this.dataapresinterna;
	}

	public void setDataapresinterna(Timestamp dataapresinterna) {
		this.dataapresinterna = dataapresinterna;
	}

	public Timestamp getDatacadastro() {
		return this.datacadastro;
	}

	public void setDatacadastro(Timestamp datacadastro) {
		this.datacadastro = datacadastro;
	}

	public Timestamp getDatacancelamento() {
		return this.datacancelamento;
	}

	public void setDatacancelamento(Timestamp datacancelamento) {
		this.datacancelamento = datacancelamento;
	}

	public Timestamp getDatacliente() {
		return this.datacliente;
	}

	public void setDatacliente(Timestamp datacliente) {
		this.datacliente = datacliente;
	}

	public Timestamp getDataconclusao() {
		return this.dataconclusao;
	}

	public void setDataconclusao(Timestamp dataconclusao) {
		this.dataconclusao = dataconclusao;
	}

	public Timestamp getDataenvioprojeto() {
		return this.dataenvioprojeto;
	}

	public void setDataenvioprojeto(Timestamp dataenvioprojeto) {
		this.dataenvioprojeto = dataenvioprojeto;
	}

	public Timestamp getDataexecucao() {
		return this.dataexecucao;
	}

	public void setDataexecucao(Timestamp dataexecucao) {
		this.dataexecucao = dataexecucao;
	}

	public Timestamp getDatafechamento() {
		return this.datafechamento;
	}

	public void setDatafechamento(Timestamp datafechamento) {
		this.datafechamento = datafechamento;
	}

	public Timestamp getDatanegacao() {
		return this.datanegacao;
	}

	public void setDatanegacao(Timestamp datanegacao) {
		this.datanegacao = datanegacao;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getEhcronograma() {
		return this.ehcronograma;
	}

	public void setEhcronograma(Boolean ehcronograma) {
		this.ehcronograma = ehcronograma;
	}

	public Boolean getEhnotasite() {
		return this.ehnotasite;
	}

	public void setEhnotasite(Boolean ehnotasite) {
		this.ehnotasite = ehnotasite;
	}

	public Boolean getEhplanejamento() {
		return this.ehplanejamento;
	}

	public void setEhplanejamento(Boolean ehplanejamento) {
		this.ehplanejamento = ehplanejamento;
	}

	public Boolean getEhrelatorio() {
		return this.ehrelatorio;
	}

	public void setEhrelatorio(Boolean ehrelatorio) {
		this.ehrelatorio = ehrelatorio;
	}

	public String getEmailcontato() {
		return this.emailcontato;
	}

	public void setEmailcontato(String emailcontato) {
		this.emailcontato = emailcontato;
	}

	public String getJustificativa() {
		return this.justificativa;
	}

	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}

	public String getMotivocancelamento() {
		return this.motivocancelamento;
	}

	public void setMotivocancelamento(String motivocancelamento) {
		this.motivocancelamento = motivocancelamento;
	}

	public Integer getMotivocancelamentoid() {
		return this.motivocancelamentoid;
	}

	public void setMotivocancelamentoid(Integer motivocancelamentoid) {
		this.motivocancelamentoid = motivocancelamentoid;
	}

	public String getMotivonegacao() {
		return this.motivonegacao;
	}

	public void setMotivonegacao(String motivonegacao) {
		this.motivonegacao = motivonegacao;
	}

	public Integer getMotivonegacaoid() {
		return this.motivonegacaoid;
	}

	public void setMotivonegacaoid(Integer motivonegacaoid) {
		this.motivonegacaoid = motivonegacaoid;
	}

	public String getMotivopausa() {
		return this.motivopausa;
	}

	public void setMotivopausa(String motivopausa) {
		this.motivopausa = motivopausa;
	}

	public String getNomecontato() {
		return this.nomecontato;
	}

	public void setNomecontato(String nomecontato) {
		this.nomecontato = nomecontato;
	}

	public String getObjetivos() {
		return this.objetivos;
	}

	public void setObjetivos(String objetivos) {
		this.objetivos = objetivos;
	}

	public String getObs() {
		return this.obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public String getOrcamentoestimado() {
		return this.orcamentoestimado;
	}

	public void setOrcamentoestimado(String orcamentoestimado) {
		this.orcamentoestimado = orcamentoestimado;
	}

	public Boolean getPausa() {
		return this.pausa;
	}

	public void setPausa(Boolean pausa) {
		this.pausa = pausa;
	}

	public String getPermissaorestricao() {
		return this.permissaorestricao;
	}

	public void setPermissaorestricao(String permissaorestricao) {
		this.permissaorestricao = permissaorestricao;
	}

	public String getPosicaopagamento() {
		return this.posicaopagamento;
	}

	public void setPosicaopagamento(String posicaopagamento) {
		this.posicaopagamento = posicaopagamento;
	}

	public String getPublicoalvo() {
		return this.publicoalvo;
	}

	public void setPublicoalvo(String publicoalvo) {
		this.publicoalvo = publicoalvo;
	}

	public String getResponsaveis() {
		return this.responsaveis;
	}

	public void setResponsaveis(String responsaveis) {
		this.responsaveis = responsaveis;
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

	public Integer getUsuariocadastroid() {
		return this.usuariocadastroid;
	}

	public void setUsuariocadastroid(Integer usuariocadastroid) {
		this.usuariocadastroid = usuariocadastroid;
	}

	public XPessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(XPessoa pessoa) {
		this.pessoa = pessoa;
	}

	public XTipoJob getTipoJob() {
		return tipoJob;
	}

	public void setTipoJob(XTipoJob tipoJob) {
		this.tipoJob = tipoJob;
	}

	public XUsuario getUsuario() {
		return usuario;
	}

	public void setUsuario(XUsuario usuario) {
		this.usuario = usuario;
	}

	public List<XJobHistoricoAlteracao> getJobsHistoricoAlteracao() {
		return jobsHistoricoAlteracao;
	}

	public void setJobsHistoricoAlteracao(List<XJobHistoricoAlteracao> jobsHistoricoAlteracao) {
		this.jobsHistoricoAlteracao = jobsHistoricoAlteracao;
	}

	public List<XJobLinkComplementar> getJobsLinkComplementar() {
		return jobsLinkComplementar;
	}

	public void setJobsLinkComplementar(List<XJobLinkComplementar> jobsLinkComplementar) {
		this.jobsLinkComplementar = jobsLinkComplementar;
	}

	public List<XJobParceiro> getJobParceiros() {
		return jobParceiros;
	}

	public void setJobParceiros(List<XJobParceiro> jobParceiros) {
		this.jobParceiros = jobParceiros;
	}

	public List<XJobResponsavelInterno> getJobResponsavelInternos() {
		return jobResponsavelInternos;
	}

	public void setJobResponsavelInternos(List<XJobResponsavelInterno> jobResponsavelInternos) {
		this.jobResponsavelInternos = jobResponsavelInternos;
	}

	public List<XJobTarefa> getJobtarefas() {
		return jobtarefas;
	}

	public void setJobtarefas(List<XJobTarefa> jobtarefas) {
		this.jobtarefas = jobtarefas;
	}

	public List<XOrcamento> getOrcamentos() {
		return orcamentos;
	}

	public void setOrcamentos(List<XOrcamento> orcamentos) {
		this.orcamentos = orcamentos;
	}

	public List<XProspeccao> getProspeccoes() {
		return prospeccoes;
	}

	public void setProspeccoes(List<XProspeccao> prospeccoes) {
		this.prospeccoes = prospeccoes;
	}

}