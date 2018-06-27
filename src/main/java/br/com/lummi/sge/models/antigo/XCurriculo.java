package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the gcurriculo database table.
 * 
 */
@Entity
@Table(name="gcurriculo")
public class XCurriculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private BigDecimal altura;

//	private String bairro;

	private Integer busto;

	private String cabelo;

	private String categoria;

	private String cep;

//	private String cidade;

	private Integer cintura;

	private String complemento;

	private byte[] composite;

	private String contaagencia;

	private String contaagenciadigito;

	private String contabanco;

	private String contadigito;

	private String contanumero;

	private String contatitular;

	private String cpf;

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

	private Boolean ehator;

	private Boolean ehbarman;

	private Boolean ehblitspromocional;

	private Boolean ehcoordenador;

	private Boolean ehdanca;

	private Boolean ehdancarina;

	private Boolean ehdeficiente;

	private Boolean ehdegustacao;

	private Boolean ehdemobar;

	private Boolean ehdemosupermercados;

	private Boolean ehdesfile;

	private Boolean ehesporte;

	private Boolean ehfilmagem;

	private Boolean ehfotobiquini;

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

	private Boolean ehparticipacaotreinamentosisters;

	private Boolean ehpesquisaopiniao;

	private Boolean ehpiercingaparente;

	private Boolean ehpossuidrtartista;

	private Boolean ehpossuimoto;

	private Boolean ehpossuioculos;

	private Boolean ehpraticaesporte;

	private Boolean ehpromotor;

	private Boolean ehrecepcaocoqueteis;

	private Boolean ehrecepcaostands;

	private Boolean ehrecreacaocrianca;

	private Boolean ehrepositorbuffet;

	private Boolean ehretirarcacheagencia;

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

	private String email;

	private String email2;

	private String endereco;

	private String facebook;

	private String fax;

	private String formacao;

	private Integer formacaoid;

	private byte[] foto;

	private byte[] foto1;

	private byte[] foto2;

	private byte[] foto3;

	private byte[] foto4;

	private String identidade;

	private String manequimblusa;

	private String manequimcalca;

	private String nextel;

	private String nome;

	private String numero;

	private String numerocalcado;

	private String obsadicionais;

	private String observacao;

	private String olho;

	private String orgexpedidorid;

	@Column(name="orkut_facebook")
	private String orkutFacebook;

	private String pele;

	private String perfil;

	private BigDecimal peso;

	private String pis;

	private String pontoreferencia;

	private Boolean qehaparelhoodontologico;

	private Integer quadril;

	private String sexo;

	private String site;

	private String status;

	private String tamanhocabelo;

	private String telefone1;

	private String telefone2;

	private String tipoconta;

	private String tituloeleitor;

	private String trabalhoanterioes;

	private String twitter;

	private String uf;

	@ManyToOne
	@JoinColumn(name="bairroid")
	private XBairro bairro;

	@ManyToOne
	@JoinColumn(name="bancoid")
	private XBanco banco;

	@ManyToOne
	@JoinColumn(name="cidadeid")
	private XCidade cidade;

	@ManyToOne
	@JoinColumn(name="fluenciaid1")
	private XFluenciaIdioma fluenciaIdioma;

	@ManyToOne
	@JoinColumn(name="fluenciaid2")
	private XFluenciaIdioma fluenciaIdioma2;

	@ManyToOne
	@JoinColumn(name="fluenciaid3")
	private XFluenciaIdioma fluenciaIdioma3;

	@ManyToOne
	@JoinColumn(name="idiomaid1")
	private XIdioma idioma;

	@ManyToOne
	@JoinColumn(name="idiomaid2")
	private XIdioma idioma2;

	@ManyToOne
	@JoinColumn(name="idiomaid3")
	private XIdioma idioma3;

	@OneToMany(mappedBy="curriculo")
	private List<XCurriculoObjetivo> curriculoObjetivos;

	public XCurriculo() {
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

	public String getCategoria() {
		return this.categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Integer getCintura() {
		return this.cintura;
	}

	public void setCintura(Integer cintura) {
		this.cintura = cintura;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public byte[] getComposite() {
		return this.composite;
	}

	public void setComposite(byte[] composite) {
		this.composite = composite;
	}

	public String getContaagencia() {
		return this.contaagencia;
	}

	public void setContaagencia(String contaagencia) {
		this.contaagencia = contaagencia;
	}

	public String getContaagenciadigito() {
		return this.contaagenciadigito;
	}

	public void setContaagenciadigito(String contaagenciadigito) {
		this.contaagenciadigito = contaagenciadigito;
	}

	public String getContabanco() {
		return this.contabanco;
	}

	public void setContabanco(String contabanco) {
		this.contabanco = contabanco;
	}

	public String getContadigito() {
		return this.contadigito;
	}

	public void setContadigito(String contadigito) {
		this.contadigito = contadigito;
	}

	public String getContanumero() {
		return this.contanumero;
	}

	public void setContanumero(String contanumero) {
		this.contanumero = contanumero;
	}

	public String getContatitular() {
		return this.contatitular;
	}

	public void setContatitular(String contatitular) {
		this.contatitular = contatitular;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public Boolean getEhcoordenador() {
		return this.ehcoordenador;
	}

	public void setEhcoordenador(Boolean ehcoordenador) {
		this.ehcoordenador = ehcoordenador;
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

	public Boolean getEhparticipacaotreinamentosisters() {
		return this.ehparticipacaotreinamentosisters;
	}

	public void setEhparticipacaotreinamentosisters(Boolean ehparticipacaotreinamentosisters) {
		this.ehparticipacaotreinamentosisters = ehparticipacaotreinamentosisters;
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

	public Boolean getEhpossuimoto() {
		return this.ehpossuimoto;
	}

	public void setEhpossuimoto(Boolean ehpossuimoto) {
		this.ehpossuimoto = ehpossuimoto;
	}

	public Boolean getEhpossuioculos() {
		return this.ehpossuioculos;
	}

	public void setEhpossuioculos(Boolean ehpossuioculos) {
		this.ehpossuioculos = ehpossuioculos;
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

	public Boolean getEhrepositorbuffet() {
		return this.ehrepositorbuffet;
	}

	public void setEhrepositorbuffet(Boolean ehrepositorbuffet) {
		this.ehrepositorbuffet = ehrepositorbuffet;
	}

	public Boolean getEhretirarcacheagencia() {
		return this.ehretirarcacheagencia;
	}

	public void setEhretirarcacheagencia(Boolean ehretirarcacheagencia) {
		this.ehretirarcacheagencia = ehretirarcacheagencia;
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

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail2() {
		return this.email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getFacebook() {
		return this.facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getFormacao() {
		return this.formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

	public Integer getFormacaoid() {
		return this.formacaoid;
	}

	public void setFormacaoid(Integer formacaoid) {
		this.formacaoid = formacaoid;
	}

	public byte[] getFoto() {
		return this.foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
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

	public byte[] getFoto4() {
		return this.foto4;
	}

	public void setFoto4(byte[] foto4) {
		this.foto4 = foto4;
	}

	public String getIdentidade() {
		return this.identidade;
	}

	public void setIdentidade(String identidade) {
		this.identidade = identidade;
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

	public String getNextel() {
		return this.nextel;
	}

	public void setNextel(String nextel) {
		this.nextel = nextel;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNumerocalcado() {
		return this.numerocalcado;
	}

	public void setNumerocalcado(String numerocalcado) {
		this.numerocalcado = numerocalcado;
	}

	public String getObsadicionais() {
		return this.obsadicionais;
	}

	public void setObsadicionais(String obsadicionais) {
		this.obsadicionais = obsadicionais;
	}

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getOlho() {
		return this.olho;
	}

	public void setOlho(String olho) {
		this.olho = olho;
	}

	public String getOrgexpedidorid() {
		return this.orgexpedidorid;
	}

	public void setOrgexpedidorid(String orgexpedidorid) {
		this.orgexpedidorid = orgexpedidorid;
	}

	public String getOrkutFacebook() {
		return this.orkutFacebook;
	}

	public void setOrkutFacebook(String orkutFacebook) {
		this.orkutFacebook = orkutFacebook;
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

	public String getPis() {
		return this.pis;
	}

	public void setPis(String pis) {
		this.pis = pis;
	}

	public String getPontoreferencia() {
		return this.pontoreferencia;
	}

	public void setPontoreferencia(String pontoreferencia) {
		this.pontoreferencia = pontoreferencia;
	}

	public Boolean getQehaparelhoodontologico() {
		return this.qehaparelhoodontologico;
	}

	public void setQehaparelhoodontologico(Boolean qehaparelhoodontologico) {
		this.qehaparelhoodontologico = qehaparelhoodontologico;
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

	public String getSite() {
		return this.site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTamanhocabelo() {
		return this.tamanhocabelo;
	}

	public void setTamanhocabelo(String tamanhocabelo) {
		this.tamanhocabelo = tamanhocabelo;
	}

	public String getTelefone1() {
		return this.telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return this.telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getTipoconta() {
		return this.tipoconta;
	}

	public void setTipoconta(String tipoconta) {
		this.tipoconta = tipoconta;
	}

	public String getTituloeleitor() {
		return this.tituloeleitor;
	}

	public void setTituloeleitor(String tituloeleitor) {
		this.tituloeleitor = tituloeleitor;
	}

	public String getTrabalhoanterioes() {
		return this.trabalhoanterioes;
	}

	public void setTrabalhoanterioes(String trabalhoanterioes) {
		this.trabalhoanterioes = trabalhoanterioes;
	}

	public String getTwitter() {
		return this.twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getUf() {
		return this.uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public XBairro getBairro() {
		return bairro;
	}

	public void setBairro(XBairro bairro) {
		this.bairro = bairro;
	}

	public XBanco getBanco() {
		return banco;
	}

	public void setBanco(XBanco banco) {
		this.banco = banco;
	}

	public XCidade getCidade() {
		return cidade;
	}

	public void setCidade(XCidade cidade) {
		this.cidade = cidade;
	}

	public XFluenciaIdioma getFluenciaIdioma() {
		return fluenciaIdioma;
	}

	public void setFluenciaIdioma(XFluenciaIdioma fluenciaIdioma) {
		this.fluenciaIdioma = fluenciaIdioma;
	}

	public XFluenciaIdioma getFluenciaIdioma2() {
		return fluenciaIdioma2;
	}

	public void setFluenciaIdioma2(XFluenciaIdioma fluenciaIdioma2) {
		this.fluenciaIdioma2 = fluenciaIdioma2;
	}

	public XFluenciaIdioma getFluenciaIdioma3() {
		return fluenciaIdioma3;
	}

	public void setFluenciaIdioma3(XFluenciaIdioma fluenciaIdioma3) {
		this.fluenciaIdioma3 = fluenciaIdioma3;
	}

	public XIdioma getIdioma() {
		return idioma;
	}

	public void setIdioma(XIdioma idioma) {
		this.idioma = idioma;
	}

	public XIdioma getIdioma2() {
		return idioma2;
	}

	public void setIdioma2(XIdioma idioma2) {
		this.idioma2 = idioma2;
	}

	public XIdioma getIdioma3() {
		return idioma3;
	}

	public void setIdioma3(XIdioma idioma3) {
		this.idioma3 = idioma3;
	}

	public List<XCurriculoObjetivo> getCurriculoObjetivos() {
		return curriculoObjetivos;
	}

	public void setCurriculoObjetivos(List<XCurriculoObjetivo> curriculoObjetivos) {
		this.curriculoObjetivos = curriculoObjetivos;
	}

}