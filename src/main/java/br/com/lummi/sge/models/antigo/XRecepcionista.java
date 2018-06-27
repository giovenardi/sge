package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the crecepcionista database table.
 * 
 */
@Entity
@Table(name="crecepcionista")
public class XRecepcionista implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private BigDecimal altura;

	private Integer busto;

	private String cabelo;

	private Integer cintura;

	private byte[] composite;

	private Timestamp datanascimento;

	private Boolean disponivelfinaldesemana;

	private Boolean disponivelmanha;

	private Boolean disponivelnoite;

	private Boolean disponiveltarde;

	private Boolean disponivelviagem;

	private Boolean ehacoespromocionais;

	private Boolean ehacoespromocionaisdifer;

	private Boolean ehanimacaoeventos;

	private Boolean ehanimadortorcida;

	private Boolean ehaparelhoodontologico;

	private Boolean ehapoiooperacional;

	private Boolean ehartistaplastico;

	private Boolean ehartistarua;

	private Boolean ehassistenciaauditorio;

	private Boolean ehassistenciacerimonial;

	private Boolean ehassistentecerimonial;

	private Boolean ehator;

	private Boolean ehbarman;

	private Boolean ehblitspromocional;

	private Boolean ehblitz;

	private Boolean ehcaixa;

	private Boolean ehcoordenador;

	private Boolean ehcredenciamento;

	private Boolean ehdanca;

	private Boolean ehdancarina;

	private Boolean ehdeficiente;

	private Boolean ehdegustacao;

	private Boolean ehdegustacoes;

	private Boolean ehdemobar;

	private Boolean ehdemosupermercados;

	private Boolean ehdesfile;

	private Boolean ehdigitacao;

	private Boolean ehehflair;

	private Boolean ehesporte;

	private Boolean ehfilmagem;

	private Boolean ehfotobiquini;

	private Boolean ehfotocomum;

	private Boolean ehfotocomun;

	private Boolean ehfotoroupaintima;

	private Boolean ehfumante;

	private Boolean ehgarcon;

	private Boolean ehintervencaourbana;

	private Boolean ehlocutor;

	private Boolean ehmanobrista;

	private Boolean ehmascote;

	private Boolean ehpanfletagem;

	private Boolean ehpanfletagembar;

	private Boolean ehpanfletagemindoor;

	private Boolean ehpesquisaopiniao;

	private Boolean ehpiercingaparente;

	private Boolean ehpossuidrtartista;

	private Boolean ehpraticaesporte;

	private Boolean ehpromotor;

	private Boolean ehrecepcaocoqueteis;

	private Boolean ehrecepcaostands;

	private Boolean ehrecreacaocrianca;

	private Boolean ehrecreacaocriancas;

	private Boolean ehrepositorbuffet;

	private Boolean ehsecretaria;

	private Boolean ehsecretariacongresso;

	private Boolean ehseguranca;

	private Boolean ehsupervisoresporte;

	private Boolean ehsupervisoreventos;

	private Boolean ehsupervisormarktpromo;

	private Boolean ehsupervisormoda;

	private Boolean ehtatuagemaparente;

	private Boolean ehteamleaders;

	private Boolean ehterceiraidade;

	private Boolean ehveiculodisponiveltrabalho;

	private byte[] foto1;

	private byte[] foto2;

	private byte[] foto3;

	private Boolean idiomaespanhol;

	private Boolean idiomaespanholbasico;

	private Boolean idiomaespanholfluente;

	private Boolean idiomaespanholintermediario;

	private Boolean idiomaingles;

	private Boolean idiomainglesbasico;

	private Boolean idiomainglesfluente;

	private Boolean idiomainglesintermediario;

	private String manequimblusa;

	private String manequimcalca;

	private String numerocalcado;

	@Column(name="objetivo")
	private String descObjetivo;

	private String obsadicionais;

	private String olho;

	private String pele;

	private String perfil;

	private BigDecimal peso;

	private Integer quadril;

	private String sexo;

	private String tamanhocabelo;

	private Boolean temcarro;

	private String trabalhoanterioes;

	private Timestamp ultimaatualizacao;

	//bi-directional many-to-one association to Cbairro
	@ManyToOne
	@JoinColumn(name="bairroid")
	private XBairro bairro;

	//bi-directional many-to-one association to Ccidade
	@ManyToOne
	@JoinColumn(name="cidadeid")
	private XCidade cidade;

	//bi-directional many-to-one association to Cempresa
	@ManyToOne
	@JoinColumn(name="empresaid")
	private XEmpresa empresa;

	//bi-directional many-to-one association to Cfluenciaidioma
	@ManyToOne
	@JoinColumn(name="fluenciaid1")
	private XFluenciaIdioma fluenciaIdioma1;

	//bi-directional many-to-one association to Cfluenciaidioma
	@ManyToOne
	@JoinColumn(name="fluenciaid2")
	private XFluenciaIdioma fluenciaIdioma2;

	//bi-directional many-to-one association to Cfluenciaidioma
	@ManyToOne
	@JoinColumn(name="fluenciaid3")
	private XFluenciaIdioma fluenciaIdioma3;

	//bi-directional many-to-one association to Cformacao
	@ManyToOne
	@JoinColumn(name="formacaoid")
	private XFormacao formacao;

	//bi-directional many-to-one association to Cidioma
	@ManyToOne
	@JoinColumn(name="idiomaid1")
	private XIdioma idioma1;

	//bi-directional many-to-one association to Cidioma
	@ManyToOne
	@JoinColumn(name="idiomaid2")
	private XIdioma idioma2;

	//bi-directional many-to-one association to Cidioma
	@ManyToOne
	@JoinColumn(name="idiomaid3")
	private XIdioma idioma3;

	//bi-directional many-to-one association to Cobjetivo
	@ManyToOne
	@JoinColumn(name="objetivoid")
	private XObjetivo objetivo;

	//bi-directional many-to-one association to Cpessoa
	@ManyToOne
	@JoinColumn(name="pessoaid")
	private XPessoa pessoa;

	//bi-directional many-to-one association to Crecepcionistaobjetivo
	@OneToMany(mappedBy="recepcionista")
	private List<XRecepcionistaObjetivo> recepcionistaObjetivos;

	public XRecepcionista() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getAltura() {
		return this.altura;
	}

	public void setAltura(BigDecimal altura) {
		this.altura = altura;
	}

	public Integer getBusto() {
		return this.busto;
	}

	public void setBusto(Integer busto) {
		this.busto = busto;
	}

	public String getCabelo() {
		return this.cabelo;
	}

	public void setCabelo(String cabelo) {
		this.cabelo = cabelo;
	}

	public Integer getCintura() {
		return this.cintura;
	}

	public void setCintura(Integer cintura) {
		this.cintura = cintura;
	}

	public byte[] getComposite() {
		return this.composite;
	}

	public void setComposite(byte[] composite) {
		this.composite = composite;
	}

	public Timestamp getDatanascimento() {
		return this.datanascimento;
	}

	public void setDatanascimento(Timestamp datanascimento) {
		this.datanascimento = datanascimento;
	}

	public Boolean getDisponivelfinaldesemana() {
		return this.disponivelfinaldesemana;
	}

	public void setDisponivelfinaldesemana(Boolean disponivelfinaldesemana) {
		this.disponivelfinaldesemana = disponivelfinaldesemana;
	}

	public Boolean getDisponivelmanha() {
		return this.disponivelmanha;
	}

	public void setDisponivelmanha(Boolean disponivelmanha) {
		this.disponivelmanha = disponivelmanha;
	}

	public Boolean getDisponivelnoite() {
		return this.disponivelnoite;
	}

	public void setDisponivelnoite(Boolean disponivelnoite) {
		this.disponivelnoite = disponivelnoite;
	}

	public Boolean getDisponiveltarde() {
		return this.disponiveltarde;
	}

	public void setDisponiveltarde(Boolean disponiveltarde) {
		this.disponiveltarde = disponiveltarde;
	}

	public Boolean getDisponivelviagem() {
		return this.disponivelviagem;
	}

	public void setDisponivelviagem(Boolean disponivelviagem) {
		this.disponivelviagem = disponivelviagem;
	}

	public Boolean getEhacoespromocionais() {
		return this.ehacoespromocionais;
	}

	public void setEhacoespromocionais(Boolean ehacoespromocionais) {
		this.ehacoespromocionais = ehacoespromocionais;
	}

	public Boolean getEhacoespromocionaisdifer() {
		return this.ehacoespromocionaisdifer;
	}

	public void setEhacoespromocionaisdifer(Boolean ehacoespromocionaisdifer) {
		this.ehacoespromocionaisdifer = ehacoespromocionaisdifer;
	}

	public Boolean getEhanimacaoeventos() {
		return this.ehanimacaoeventos;
	}

	public void setEhanimacaoeventos(Boolean ehanimacaoeventos) {
		this.ehanimacaoeventos = ehanimacaoeventos;
	}

	public Boolean getEhanimadortorcida() {
		return this.ehanimadortorcida;
	}

	public void setEhanimadortorcida(Boolean ehanimadortorcida) {
		this.ehanimadortorcida = ehanimadortorcida;
	}

	public Boolean getEhaparelhoodontologico() {
		return this.ehaparelhoodontologico;
	}

	public void setEhaparelhoodontologico(Boolean ehaparelhoodontologico) {
		this.ehaparelhoodontologico = ehaparelhoodontologico;
	}

	public Boolean getEhapoiooperacional() {
		return this.ehapoiooperacional;
	}

	public void setEhapoiooperacional(Boolean ehapoiooperacional) {
		this.ehapoiooperacional = ehapoiooperacional;
	}

	public Boolean getEhartistaplastico() {
		return this.ehartistaplastico;
	}

	public void setEhartistaplastico(Boolean ehartistaplastico) {
		this.ehartistaplastico = ehartistaplastico;
	}

	public Boolean getEhartistarua() {
		return this.ehartistarua;
	}

	public void setEhartistarua(Boolean ehartistarua) {
		this.ehartistarua = ehartistarua;
	}

	public Boolean getEhassistenciaauditorio() {
		return this.ehassistenciaauditorio;
	}

	public void setEhassistenciaauditorio(Boolean ehassistenciaauditorio) {
		this.ehassistenciaauditorio = ehassistenciaauditorio;
	}

	public Boolean getEhassistenciacerimonial() {
		return this.ehassistenciacerimonial;
	}

	public void setEhassistenciacerimonial(Boolean ehassistenciacerimonial) {
		this.ehassistenciacerimonial = ehassistenciacerimonial;
	}

	public Boolean getEhassistentecerimonial() {
		return this.ehassistentecerimonial;
	}

	public void setEhassistentecerimonial(Boolean ehassistentecerimonial) {
		this.ehassistentecerimonial = ehassistentecerimonial;
	}

	public Boolean getEhator() {
		return this.ehator;
	}

	public void setEhator(Boolean ehator) {
		this.ehator = ehator;
	}

	public Boolean getEhbarman() {
		return this.ehbarman;
	}

	public void setEhbarman(Boolean ehbarman) {
		this.ehbarman = ehbarman;
	}

	public Boolean getEhblitspromocional() {
		return this.ehblitspromocional;
	}

	public void setEhblitspromocional(Boolean ehblitspromocional) {
		this.ehblitspromocional = ehblitspromocional;
	}

	public Boolean getEhblitz() {
		return this.ehblitz;
	}

	public void setEhblitz(Boolean ehblitz) {
		this.ehblitz = ehblitz;
	}

	public Boolean getEhcaixa() {
		return this.ehcaixa;
	}

	public void setEhcaixa(Boolean ehcaixa) {
		this.ehcaixa = ehcaixa;
	}

	public Boolean getEhcoordenador() {
		return this.ehcoordenador;
	}

	public void setEhcoordenador(Boolean ehcoordenador) {
		this.ehcoordenador = ehcoordenador;
	}

	public Boolean getEhcredenciamento() {
		return this.ehcredenciamento;
	}

	public void setEhcredenciamento(Boolean ehcredenciamento) {
		this.ehcredenciamento = ehcredenciamento;
	}

	public Boolean getEhdanca() {
		return this.ehdanca;
	}

	public void setEhdanca(Boolean ehdanca) {
		this.ehdanca = ehdanca;
	}

	public Boolean getEhdancarina() {
		return this.ehdancarina;
	}

	public void setEhdancarina(Boolean ehdancarina) {
		this.ehdancarina = ehdancarina;
	}

	public Boolean getEhdeficiente() {
		return this.ehdeficiente;
	}

	public void setEhdeficiente(Boolean ehdeficiente) {
		this.ehdeficiente = ehdeficiente;
	}

	public Boolean getEhdegustacao() {
		return this.ehdegustacao;
	}

	public void setEhdegustacao(Boolean ehdegustacao) {
		this.ehdegustacao = ehdegustacao;
	}

	public Boolean getEhdegustacoes() {
		return this.ehdegustacoes;
	}

	public void setEhdegustacoes(Boolean ehdegustacoes) {
		this.ehdegustacoes = ehdegustacoes;
	}

	public Boolean getEhdemobar() {
		return this.ehdemobar;
	}

	public void setEhdemobar(Boolean ehdemobar) {
		this.ehdemobar = ehdemobar;
	}

	public Boolean getEhdemosupermercados() {
		return this.ehdemosupermercados;
	}

	public void setEhdemosupermercados(Boolean ehdemosupermercados) {
		this.ehdemosupermercados = ehdemosupermercados;
	}

	public Boolean getEhdesfile() {
		return this.ehdesfile;
	}

	public void setEhdesfile(Boolean ehdesfile) {
		this.ehdesfile = ehdesfile;
	}

	public Boolean getEhdigitacao() {
		return this.ehdigitacao;
	}

	public void setEhdigitacao(Boolean ehdigitacao) {
		this.ehdigitacao = ehdigitacao;
	}

	public Boolean getEhehflair() {
		return this.ehehflair;
	}

	public void setEhehflair(Boolean ehehflair) {
		this.ehehflair = ehehflair;
	}

	public Boolean getEhesporte() {
		return this.ehesporte;
	}

	public void setEhesporte(Boolean ehesporte) {
		this.ehesporte = ehesporte;
	}

	public Boolean getEhfilmagem() {
		return this.ehfilmagem;
	}

	public void setEhfilmagem(Boolean ehfilmagem) {
		this.ehfilmagem = ehfilmagem;
	}

	public Boolean getEhfotobiquini() {
		return this.ehfotobiquini;
	}

	public void setEhfotobiquini(Boolean ehfotobiquini) {
		this.ehfotobiquini = ehfotobiquini;
	}

	public Boolean getEhfotocomum() {
		return this.ehfotocomum;
	}

	public void setEhfotocomum(Boolean ehfotocomum) {
		this.ehfotocomum = ehfotocomum;
	}

	public Boolean getEhfotocomun() {
		return this.ehfotocomun;
	}

	public void setEhfotocomun(Boolean ehfotocomun) {
		this.ehfotocomun = ehfotocomun;
	}

	public Boolean getEhfotoroupaintima() {
		return this.ehfotoroupaintima;
	}

	public void setEhfotoroupaintima(Boolean ehfotoroupaintima) {
		this.ehfotoroupaintima = ehfotoroupaintima;
	}

	public Boolean getEhfumante() {
		return this.ehfumante;
	}

	public void setEhfumante(Boolean ehfumante) {
		this.ehfumante = ehfumante;
	}

	public Boolean getEhgarcon() {
		return this.ehgarcon;
	}

	public void setEhgarcon(Boolean ehgarcon) {
		this.ehgarcon = ehgarcon;
	}

	public Boolean getEhintervencaourbana() {
		return this.ehintervencaourbana;
	}

	public void setEhintervencaourbana(Boolean ehintervencaourbana) {
		this.ehintervencaourbana = ehintervencaourbana;
	}

	public Boolean getEhlocutor() {
		return this.ehlocutor;
	}

	public void setEhlocutor(Boolean ehlocutor) {
		this.ehlocutor = ehlocutor;
	}

	public Boolean getEhmanobrista() {
		return this.ehmanobrista;
	}

	public void setEhmanobrista(Boolean ehmanobrista) {
		this.ehmanobrista = ehmanobrista;
	}

	public Boolean getEhmascote() {
		return this.ehmascote;
	}

	public void setEhmascote(Boolean ehmascote) {
		this.ehmascote = ehmascote;
	}

	public Boolean getEhpanfletagem() {
		return this.ehpanfletagem;
	}

	public void setEhpanfletagem(Boolean ehpanfletagem) {
		this.ehpanfletagem = ehpanfletagem;
	}

	public Boolean getEhpanfletagembar() {
		return this.ehpanfletagembar;
	}

	public void setEhpanfletagembar(Boolean ehpanfletagembar) {
		this.ehpanfletagembar = ehpanfletagembar;
	}

	public Boolean getEhpanfletagemindoor() {
		return this.ehpanfletagemindoor;
	}

	public void setEhpanfletagemindoor(Boolean ehpanfletagemindoor) {
		this.ehpanfletagemindoor = ehpanfletagemindoor;
	}

	public Boolean getEhpesquisaopiniao() {
		return this.ehpesquisaopiniao;
	}

	public void setEhpesquisaopiniao(Boolean ehpesquisaopiniao) {
		this.ehpesquisaopiniao = ehpesquisaopiniao;
	}

	public Boolean getEhpiercingaparente() {
		return this.ehpiercingaparente;
	}

	public void setEhpiercingaparente(Boolean ehpiercingaparente) {
		this.ehpiercingaparente = ehpiercingaparente;
	}

	public Boolean getEhpossuidrtartista() {
		return this.ehpossuidrtartista;
	}

	public void setEhpossuidrtartista(Boolean ehpossuidrtartista) {
		this.ehpossuidrtartista = ehpossuidrtartista;
	}

	public Boolean getEhpraticaesporte() {
		return this.ehpraticaesporte;
	}

	public void setEhpraticaesporte(Boolean ehpraticaesporte) {
		this.ehpraticaesporte = ehpraticaesporte;
	}

	public Boolean getEhpromotor() {
		return this.ehpromotor;
	}

	public void setEhpromotor(Boolean ehpromotor) {
		this.ehpromotor = ehpromotor;
	}

	public Boolean getEhrecepcaocoqueteis() {
		return this.ehrecepcaocoqueteis;
	}

	public void setEhrecepcaocoqueteis(Boolean ehrecepcaocoqueteis) {
		this.ehrecepcaocoqueteis = ehrecepcaocoqueteis;
	}

	public Boolean getEhrecepcaostands() {
		return this.ehrecepcaostands;
	}

	public void setEhrecepcaostands(Boolean ehrecepcaostands) {
		this.ehrecepcaostands = ehrecepcaostands;
	}

	public Boolean getEhrecreacaocrianca() {
		return this.ehrecreacaocrianca;
	}

	public void setEhrecreacaocrianca(Boolean ehrecreacaocrianca) {
		this.ehrecreacaocrianca = ehrecreacaocrianca;
	}

	public Boolean getEhrecreacaocriancas() {
		return this.ehrecreacaocriancas;
	}

	public void setEhrecreacaocriancas(Boolean ehrecreacaocriancas) {
		this.ehrecreacaocriancas = ehrecreacaocriancas;
	}

	public Boolean getEhrepositorbuffet() {
		return this.ehrepositorbuffet;
	}

	public void setEhrepositorbuffet(Boolean ehrepositorbuffet) {
		this.ehrepositorbuffet = ehrepositorbuffet;
	}

	public Boolean getEhsecretaria() {
		return this.ehsecretaria;
	}

	public void setEhsecretaria(Boolean ehsecretaria) {
		this.ehsecretaria = ehsecretaria;
	}

	public Boolean getEhsecretariacongresso() {
		return this.ehsecretariacongresso;
	}

	public void setEhsecretariacongresso(Boolean ehsecretariacongresso) {
		this.ehsecretariacongresso = ehsecretariacongresso;
	}

	public Boolean getEhseguranca() {
		return this.ehseguranca;
	}

	public void setEhseguranca(Boolean ehseguranca) {
		this.ehseguranca = ehseguranca;
	}

	public Boolean getEhsupervisoresporte() {
		return this.ehsupervisoresporte;
	}

	public void setEhsupervisoresporte(Boolean ehsupervisoresporte) {
		this.ehsupervisoresporte = ehsupervisoresporte;
	}

	public Boolean getEhsupervisoreventos() {
		return this.ehsupervisoreventos;
	}

	public void setEhsupervisoreventos(Boolean ehsupervisoreventos) {
		this.ehsupervisoreventos = ehsupervisoreventos;
	}

	public Boolean getEhsupervisormarktpromo() {
		return this.ehsupervisormarktpromo;
	}

	public void setEhsupervisormarktpromo(Boolean ehsupervisormarktpromo) {
		this.ehsupervisormarktpromo = ehsupervisormarktpromo;
	}

	public Boolean getEhsupervisormoda() {
		return this.ehsupervisormoda;
	}

	public void setEhsupervisormoda(Boolean ehsupervisormoda) {
		this.ehsupervisormoda = ehsupervisormoda;
	}

	public Boolean getEhtatuagemaparente() {
		return this.ehtatuagemaparente;
	}

	public void setEhtatuagemaparente(Boolean ehtatuagemaparente) {
		this.ehtatuagemaparente = ehtatuagemaparente;
	}

	public Boolean getEhteamleaders() {
		return this.ehteamleaders;
	}

	public void setEhteamleaders(Boolean ehteamleaders) {
		this.ehteamleaders = ehteamleaders;
	}

	public Boolean getEhterceiraidade() {
		return this.ehterceiraidade;
	}

	public void setEhterceiraidade(Boolean ehterceiraidade) {
		this.ehterceiraidade = ehterceiraidade;
	}

	public Boolean getEhveiculodisponiveltrabalho() {
		return this.ehveiculodisponiveltrabalho;
	}

	public void setEhveiculodisponiveltrabalho(Boolean ehveiculodisponiveltrabalho) {
		this.ehveiculodisponiveltrabalho = ehveiculodisponiveltrabalho;
	}

	public byte[] getFoto1() {
		return this.foto1;
	}

	public void setFoto1(byte[] foto1) {
		this.foto1 = foto1;
	}

	public byte[] getFoto2() {
		return this.foto2;
	}

	public void setFoto2(byte[] foto2) {
		this.foto2 = foto2;
	}

	public byte[] getFoto3() {
		return this.foto3;
	}

	public void setFoto3(byte[] foto3) {
		this.foto3 = foto3;
	}

	public Boolean getIdiomaespanhol() {
		return this.idiomaespanhol;
	}

	public void setIdiomaespanhol(Boolean idiomaespanhol) {
		this.idiomaespanhol = idiomaespanhol;
	}

	public Boolean getIdiomaespanholbasico() {
		return this.idiomaespanholbasico;
	}

	public void setIdiomaespanholbasico(Boolean idiomaespanholbasico) {
		this.idiomaespanholbasico = idiomaespanholbasico;
	}

	public Boolean getIdiomaespanholfluente() {
		return this.idiomaespanholfluente;
	}

	public void setIdiomaespanholfluente(Boolean idiomaespanholfluente) {
		this.idiomaespanholfluente = idiomaespanholfluente;
	}

	public Boolean getIdiomaespanholintermediario() {
		return this.idiomaespanholintermediario;
	}

	public void setIdiomaespanholintermediario(Boolean idiomaespanholintermediario) {
		this.idiomaespanholintermediario = idiomaespanholintermediario;
	}

	public Boolean getIdiomaingles() {
		return this.idiomaingles;
	}

	public void setIdiomaingles(Boolean idiomaingles) {
		this.idiomaingles = idiomaingles;
	}

	public Boolean getIdiomainglesbasico() {
		return this.idiomainglesbasico;
	}

	public void setIdiomainglesbasico(Boolean idiomainglesbasico) {
		this.idiomainglesbasico = idiomainglesbasico;
	}

	public Boolean getIdiomainglesfluente() {
		return this.idiomainglesfluente;
	}

	public void setIdiomainglesfluente(Boolean idiomainglesfluente) {
		this.idiomainglesfluente = idiomainglesfluente;
	}

	public Boolean getIdiomainglesintermediario() {
		return this.idiomainglesintermediario;
	}

	public void setIdiomainglesintermediario(Boolean idiomainglesintermediario) {
		this.idiomainglesintermediario = idiomainglesintermediario;
	}

	public String getManequimblusa() {
		return this.manequimblusa;
	}

	public void setManequimblusa(String manequimblusa) {
		this.manequimblusa = manequimblusa;
	}

	public String getManequimcalca() {
		return this.manequimcalca;
	}

	public void setManequimcalca(String manequimcalca) {
		this.manequimcalca = manequimcalca;
	}

	public String getNumerocalcado() {
		return this.numerocalcado;
	}

	public void setNumerocalcado(String numerocalcado) {
		this.numerocalcado = numerocalcado;
	}

	public String getDescObjetivo() {
		return this.descObjetivo;
	}

	public void setDescObjetivo(String descObjetivo) {
		this.descObjetivo = descObjetivo;
	}

	public String getObsadicionais() {
		return this.obsadicionais;
	}

	public void setObsadicionais(String obsadicionais) {
		this.obsadicionais = obsadicionais;
	}

	public String getOlho() {
		return this.olho;
	}

	public void setOlho(String olho) {
		this.olho = olho;
	}

	public String getPele() {
		return this.pele;
	}

	public void setPele(String pele) {
		this.pele = pele;
	}

	public String getPerfil() {
		return this.perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public BigDecimal getPeso() {
		return this.peso;
	}

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}

	public Integer getQuadril() {
		return this.quadril;
	}

	public void setQuadril(Integer quadril) {
		this.quadril = quadril;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTamanhocabelo() {
		return this.tamanhocabelo;
	}

	public void setTamanhocabelo(String tamanhocabelo) {
		this.tamanhocabelo = tamanhocabelo;
	}

	public Boolean getTemcarro() {
		return this.temcarro;
	}

	public void setTemcarro(Boolean temcarro) {
		this.temcarro = temcarro;
	}

	public String getTrabalhoanterioes() {
		return this.trabalhoanterioes;
	}

	public void setTrabalhoanterioes(String trabalhoanterioes) {
		this.trabalhoanterioes = trabalhoanterioes;
	}

	public Timestamp getUltimaatualizacao() {
		return this.ultimaatualizacao;
	}

	public void setUltimaatualizacao(Timestamp ultimaatualizacao) {
		this.ultimaatualizacao = ultimaatualizacao;
	}

	public XBairro getBairro() {
		return this.bairro;
	}

	public void setBairro(XBairro bairro) {
		this.bairro = bairro;
	}

	public XCidade getCidade() {
		return this.cidade;
	}

	public void setCidade(XCidade cidade) {
		this.cidade = cidade;
	}

	public XEmpresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(XEmpresa empresa) {
		this.empresa = empresa;
	}

	public XFluenciaIdioma getFluenciaIdioma1() {
		return this.fluenciaIdioma1;
	}

	public void setFluenciaIdioma1(XFluenciaIdioma fluenciaIdioma1) {
		this.fluenciaIdioma1 = fluenciaIdioma1;
	}

	public XFluenciaIdioma getFluenciaIdioma2() {
		return this.fluenciaIdioma2;
	}

	public void setFluenciaIdioma2(XFluenciaIdioma fluenciaIdioma2) {
		this.fluenciaIdioma2 = fluenciaIdioma2;
	}

	public XFluenciaIdioma getFluenciaIdioma3() {
		return this.fluenciaIdioma3;
	}

	public void setFluenciaIdioma3(XFluenciaIdioma fluenciaIdioma3) {
		this.fluenciaIdioma3 = fluenciaIdioma3;
	}

	public XFormacao getFormacao() {
		return this.formacao;
	}

	public void setFormacao(XFormacao formacao) {
		this.formacao = formacao;
	}

	public XIdioma getIdioma1() {
		return this.idioma1;
	}

	public void setIdioma1(XIdioma idioma1) {
		this.idioma1 = idioma1;
	}

	public XIdioma getIdioma2() {
		return this.idioma2;
	}

	public void setIdioma2(XIdioma idioma2) {
		this.idioma2 = idioma2;
	}

	public XIdioma getIdioma3() {
		return this.idioma3;
	}

	public void setIdioma3(XIdioma idioma3) {
		this.idioma3 = idioma3;
	}

	public XObjetivo getObjetivo() {
		return this.objetivo;
	}

	public void setObjetivo(XObjetivo objetivo) {
		this.objetivo = objetivo;
	}

	public XPessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(XPessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<XRecepcionistaObjetivo> getRecepcionistaObjetivos() {
		return this.recepcionistaObjetivos;
	}

	public void setCrecepcionistaobjetivos(List<XRecepcionistaObjetivo> recepcionistaObjetivos) {
		this.recepcionistaObjetivos = recepcionistaObjetivos;
	}

}