package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the mbriefing database table.
 * 
 */
@Entity
@Table(name="mbriefing")
public class XBriefing implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Timestamp aprovadodata;

	private String atividadeparalela;

	private String bancodados;

	private String callaction;

	private Timestamp canceladodata;

	private String codigo;

	private String como;

	private String concorrencia;

	private String condicao;

	private Timestamp data;

	private Timestamp dataapresentacao;

	private Timestamp datacadastro;

	private Timestamp dataentrada;

	private Timestamp datalimitearte;

	private String datamailing;

	private Timestamp devolvidoatendimentodata;

	private String distribuicao;

	private Boolean ehlayout;

	private Boolean ehtexto;

	private Timestamp emalteracaodata;

	private Timestamp emcriacaodata;

	private Timestamp emfinalizacaodata;

	private Timestamp encerradodata;

	private Timestamp enviocriacaodata;

	private String fdesejado;

	private String fimportante;

	private String fobrigatorio;

	private String formaapresentacao;

	private String household;

	private String layout;

	private String listagemdesejada;

	private String localevento;

	private String mailing;

	private String mercadoalvo;

	private String midia;

	private Timestamp noclientedata;

	private Integer numeropeca;

	private String objetivo;

	private String obrigatoriedade;

	private String observacao;

	private String onde;

	private String oque;

	private String parapj;

	private String porque;

	private String porte;

	private String producaografica;

	private String produto;

	private String programa;

	private String publico;

	private String quando;

	private String quebracontagem;

	private String quem;

	private String responsavel;

	private String responsavelcliente;

	private String segmentacao;

	private String status;

	private String texto;

	private String tipo;

	private String tipoacesso;

	@ManyToOne
	@JoinColumn(name="criativo1id")
	private XCriativo criativo;

	@ManyToOne
	@JoinColumn(name="criativo2id")
	private XCriativo criativo2;

	@ManyToOne
	@JoinColumn(name="clienteid")
	private XPessoa pessoa;

	@ManyToOne
	@JoinColumn(name="aprovadousuarioid")
	private XUsuario usuarioAprovado;

	@ManyToOne
	@JoinColumn(name="devolvidoatendimentousuarioid")
	private XUsuario usuarioDevolvidoAtendimento;

	@ManyToOne
	@JoinColumn(name="emalteracaousuarioid")
	private XUsuario usuarioEmAlteracao;

	@ManyToOne
	@JoinColumn(name="emcriacaousuarioid")
	private XUsuario usuarioEmCriacao;

	@ManyToOne
	@JoinColumn(name="emfinalizacaousuarioid")
	private XUsuario usuarioEmFinalizacao;

	@ManyToOne
	@JoinColumn(name="encerradousuarioid")
	private XUsuario usuarioEncerrado;

	@ManyToOne
	@JoinColumn(name="enviocriacaousuarioid")
	private XUsuario usuarioEnvioCriacao;

	@ManyToOne
	@JoinColumn(name="noclienteusuarioid")
	private XUsuario usuarioNoCliente;

	@ManyToOne
	@JoinColumn(name="usuariocadastroid")
	private XUsuario usuarioCadastro;

	@ManyToOne
	@JoinColumn(name="canceladousuarioid")
	private XUsuario usuarioCancelado;

	@OneToMany(mappedBy="briefing")
	private List<XBriefingRecurso> briefingRecursos;

	public XBriefing() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getAprovadodata() {
		return this.aprovadodata;
	}

	public void setAprovadodata(Timestamp aprovadodata) {
		this.aprovadodata = aprovadodata;
	}

	public String getAtividadeparalela() {
		return this.atividadeparalela;
	}

	public void setAtividadeparalela(String atividadeparalela) {
		this.atividadeparalela = atividadeparalela;
	}

	public String getBancodados() {
		return this.bancodados;
	}

	public void setBancodados(String bancodados) {
		this.bancodados = bancodados;
	}

	public String getCallaction() {
		return this.callaction;
	}

	public void setCallaction(String callaction) {
		this.callaction = callaction;
	}

	public Timestamp getCanceladodata() {
		return this.canceladodata;
	}

	public void setCanceladodata(Timestamp canceladodata) {
		this.canceladodata = canceladodata;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getComo() {
		return this.como;
	}

	public void setComo(String como) {
		this.como = como;
	}

	public String getConcorrencia() {
		return this.concorrencia;
	}

	public void setConcorrencia(String concorrencia) {
		this.concorrencia = concorrencia;
	}

	public String getCondicao() {
		return this.condicao;
	}

	public void setCondicao(String condicao) {
		this.condicao = condicao;
	}

	public Timestamp getData() {
		return this.data;
	}

	public void setData(Timestamp data) {
		this.data = data;
	}

	public Timestamp getDataapresentacao() {
		return this.dataapresentacao;
	}

	public void setDataapresentacao(Timestamp dataapresentacao) {
		this.dataapresentacao = dataapresentacao;
	}

	public Timestamp getDatacadastro() {
		return this.datacadastro;
	}

	public void setDatacadastro(Timestamp datacadastro) {
		this.datacadastro = datacadastro;
	}

	public Timestamp getDataentrada() {
		return this.dataentrada;
	}

	public void setDataentrada(Timestamp dataentrada) {
		this.dataentrada = dataentrada;
	}

	public Timestamp getDatalimitearte() {
		return this.datalimitearte;
	}

	public void setDatalimitearte(Timestamp datalimitearte) {
		this.datalimitearte = datalimitearte;
	}

	public String getDatamailing() {
		return this.datamailing;
	}

	public void setDatamailing(String datamailing) {
		this.datamailing = datamailing;
	}

	public Timestamp getDevolvidoatendimentodata() {
		return this.devolvidoatendimentodata;
	}

	public void setDevolvidoatendimentodata(Timestamp devolvidoatendimentodata) {
		this.devolvidoatendimentodata = devolvidoatendimentodata;
	}

	public String getDistribuicao() {
		return this.distribuicao;
	}

	public void setDistribuicao(String distribuicao) {
		this.distribuicao = distribuicao;
	}

	public Boolean getEhlayout() {
		return this.ehlayout;
	}

	public void setEhlayout(Boolean ehlayout) {
		this.ehlayout = ehlayout;
	}

	public Boolean getEhtexto() {
		return this.ehtexto;
	}

	public void setEhtexto(Boolean ehtexto) {
		this.ehtexto = ehtexto;
	}

	public Timestamp getEmalteracaodata() {
		return this.emalteracaodata;
	}

	public void setEmalteracaodata(Timestamp emalteracaodata) {
		this.emalteracaodata = emalteracaodata;
	}

	public Timestamp getEmcriacaodata() {
		return this.emcriacaodata;
	}

	public void setEmcriacaodata(Timestamp emcriacaodata) {
		this.emcriacaodata = emcriacaodata;
	}

	public Timestamp getEmfinalizacaodata() {
		return this.emfinalizacaodata;
	}

	public void setEmfinalizacaodata(Timestamp emfinalizacaodata) {
		this.emfinalizacaodata = emfinalizacaodata;
	}

	public Timestamp getEncerradodata() {
		return this.encerradodata;
	}

	public void setEncerradodata(Timestamp encerradodata) {
		this.encerradodata = encerradodata;
	}

	public Timestamp getEnviocriacaodata() {
		return this.enviocriacaodata;
	}

	public void setEnviocriacaodata(Timestamp enviocriacaodata) {
		this.enviocriacaodata = enviocriacaodata;
	}

	public String getFdesejado() {
		return this.fdesejado;
	}

	public void setFdesejado(String fdesejado) {
		this.fdesejado = fdesejado;
	}

	public String getFimportante() {
		return this.fimportante;
	}

	public void setFimportante(String fimportante) {
		this.fimportante = fimportante;
	}

	public String getFobrigatorio() {
		return this.fobrigatorio;
	}

	public void setFobrigatorio(String fobrigatorio) {
		this.fobrigatorio = fobrigatorio;
	}

	public String getFormaapresentacao() {
		return this.formaapresentacao;
	}

	public void setFormaapresentacao(String formaapresentacao) {
		this.formaapresentacao = formaapresentacao;
	}

	public String getHousehold() {
		return this.household;
	}

	public void setHousehold(String household) {
		this.household = household;
	}

	public String getLayout() {
		return this.layout;
	}

	public void setLayout(String layout) {
		this.layout = layout;
	}

	public String getListagemdesejada() {
		return this.listagemdesejada;
	}

	public void setListagemdesejada(String listagemdesejada) {
		this.listagemdesejada = listagemdesejada;
	}

	public String getLocalevento() {
		return this.localevento;
	}

	public void setLocalevento(String localevento) {
		this.localevento = localevento;
	}

	public String getMailing() {
		return this.mailing;
	}

	public void setMailing(String mailing) {
		this.mailing = mailing;
	}

	public String getMercadoalvo() {
		return this.mercadoalvo;
	}

	public void setMercadoalvo(String mercadoalvo) {
		this.mercadoalvo = mercadoalvo;
	}

	public String getMidia() {
		return this.midia;
	}

	public void setMidia(String midia) {
		this.midia = midia;
	}

	public Timestamp getNoclientedata() {
		return this.noclientedata;
	}

	public void setNoclientedata(Timestamp noclientedata) {
		this.noclientedata = noclientedata;
	}

	public Integer getNumeropeca() {
		return this.numeropeca;
	}

	public void setNumeropeca(Integer numeropeca) {
		this.numeropeca = numeropeca;
	}

	public String getObjetivo() {
		return this.objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public String getObrigatoriedade() {
		return this.obrigatoriedade;
	}

	public void setObrigatoriedade(String obrigatoriedade) {
		this.obrigatoriedade = obrigatoriedade;
	}

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getOnde() {
		return this.onde;
	}

	public void setOnde(String onde) {
		this.onde = onde;
	}

	public String getOque() {
		return this.oque;
	}

	public void setOque(String oque) {
		this.oque = oque;
	}

	public String getParapj() {
		return this.parapj;
	}

	public void setParapj(String parapj) {
		this.parapj = parapj;
	}

	public String getPorque() {
		return this.porque;
	}

	public void setPorque(String porque) {
		this.porque = porque;
	}

	public String getPorte() {
		return this.porte;
	}

	public void setPorte(String porte) {
		this.porte = porte;
	}

	public String getProducaografica() {
		return this.producaografica;
	}

	public void setProducaografica(String producaografica) {
		this.producaografica = producaografica;
	}

	public String getProduto() {
		return this.produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public String getPrograma() {
		return this.programa;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public String getPublico() {
		return this.publico;
	}

	public void setPublico(String publico) {
		this.publico = publico;
	}

	public String getQuando() {
		return this.quando;
	}

	public void setQuando(String quando) {
		this.quando = quando;
	}

	public String getQuebracontagem() {
		return this.quebracontagem;
	}

	public void setQuebracontagem(String quebracontagem) {
		this.quebracontagem = quebracontagem;
	}

	public String getQuem() {
		return this.quem;
	}

	public void setQuem(String quem) {
		this.quem = quem;
	}

	public String getResponsavel() {
		return this.responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public String getResponsavelcliente() {
		return this.responsavelcliente;
	}

	public void setResponsavelcliente(String responsavelcliente) {
		this.responsavelcliente = responsavelcliente;
	}

	public String getSegmentacao() {
		return this.segmentacao;
	}

	public void setSegmentacao(String segmentacao) {
		this.segmentacao = segmentacao;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTexto() {
		return this.texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTipoacesso() {
		return this.tipoacesso;
	}

	public void setTipoacesso(String tipoacesso) {
		this.tipoacesso = tipoacesso;
	}

	public XCriativo getCriativo() {
		return criativo;
	}

	public void setCriativo(XCriativo criativo) {
		this.criativo = criativo;
	}

	public XCriativo getCriativo2() {
		return criativo2;
	}

	public void setCriativo2(XCriativo criativo2) {
		this.criativo2 = criativo2;
	}

	public XPessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(XPessoa pessoa) {
		this.pessoa = pessoa;
	}

	public XUsuario getUsuarioAprovado() {
		return usuarioAprovado;
	}

	public void setUsuarioAprovado(XUsuario usuarioAprovado) {
		this.usuarioAprovado = usuarioAprovado;
	}

	public XUsuario getUsuarioDevolvidoAtendimento() {
		return usuarioDevolvidoAtendimento;
	}

	public void setUsuarioDevolvidoAtendimento(XUsuario usuarioDevolvidoAtendimento) {
		this.usuarioDevolvidoAtendimento = usuarioDevolvidoAtendimento;
	}

	public XUsuario getUsuarioEmAlteracao() {
		return usuarioEmAlteracao;
	}

	public void setUsuarioEmAlteracao(XUsuario usuarioEmAlteracao) {
		this.usuarioEmAlteracao = usuarioEmAlteracao;
	}

	public XUsuario getUsuarioEmCriacao() {
		return usuarioEmCriacao;
	}

	public void setUsuarioEmCriacao(XUsuario usuarioEmCriacao) {
		this.usuarioEmCriacao = usuarioEmCriacao;
	}

	public XUsuario getUsuarioEmFinalizacao() {
		return usuarioEmFinalizacao;
	}

	public void setUsuarioEmFinalizacao(XUsuario usuarioEmFinalizacao) {
		this.usuarioEmFinalizacao = usuarioEmFinalizacao;
	}

	public XUsuario getUsuarioEncerrado() {
		return usuarioEncerrado;
	}

	public void setUsuarioEncerrado(XUsuario usuarioEncerrado) {
		this.usuarioEncerrado = usuarioEncerrado;
	}

	public XUsuario getUsuarioEnvioCriacao() {
		return usuarioEnvioCriacao;
	}

	public void setUsuarioEnvioCriacao(XUsuario usuarioEnvioCriacao) {
		this.usuarioEnvioCriacao = usuarioEnvioCriacao;
	}

	public XUsuario getUsuarioNoCliente() {
		return usuarioNoCliente;
	}

	public void setUsuarioNoCliente(XUsuario usuarioNoCliente) {
		this.usuarioNoCliente = usuarioNoCliente;
	}

	public XUsuario getUsuarioCadastro() {
		return usuarioCadastro;
	}

	public void setUsuarioCadastro(XUsuario usuarioCadastro) {
		this.usuarioCadastro = usuarioCadastro;
	}

	public XUsuario getUsuarioCancelado() {
		return usuarioCancelado;
	}

	public void setUsuarioCancelado(XUsuario usuarioCancelado) {
		this.usuarioCancelado = usuarioCancelado;
	}

	public List<XBriefingRecurso> getBriefingRecursos() {
		return briefingRecursos;
	}

	public void setBriefingRecursos(List<XBriefingRecurso> briefingRecursos) {
		this.briefingRecursos = briefingRecursos;
	}

}