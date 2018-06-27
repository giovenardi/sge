package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the cpessoa database table.
 * 
 */
@Entity
@Table(name="cpessoa")
public class XPessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String callcenter;

	private String cargo;

	private String cbo;

	private String ccontanumero2;

	private String cep;

	@Transient
	private
	Integer codBB;
	@Column(name="cep_cob")
	private String cepCob;

	private String cnpj;

	private String codigo;

	private BigDecimal comissao;

	private String complemento;

	@Column(name="complemento_cob")
	private String complementoCob;

	private String contaagencia;

	private String contaagencia2;

	private String contabanco;

	private String contabanco2;

	private String contanumero;

	private String contatitular;

	private String contatitular2;

	private String contato;

	private String cpf;

	private Timestamp dataadmissao;

	private Date datanascimento;

	private Timestamp datareferenciaatual;

	private Boolean ehaluno;

	private Boolean ehativo;

	private Boolean ehcliente;

	private Boolean ehfornecedor;

	private Boolean ehfuncionario;

	private Boolean ehgerente;

	private Boolean ehpatrocianador;

	private Boolean ehrecepcionista;

	private Boolean ehremuneracaopadraofixada;

	private Boolean ehvendendor;

	private String email;

	private String email2;

	private String email3;

	private String endereco;

	@Column(name="endereco_cob")
	private String enderecoCob;

	private String enderecoarquivoservidor;

	private String estadocivil;

	private String fax;

	private String filiacaomae;

	private String filiacaopai;

	private byte[] foto;

	private String funcao;

	private String identidade;

	private String idnextel;

	private String inscricaoestadual;

	private String inscricaomunicipal;

	private String nome;

	private String numero;

	@Column(name="numero_cob")
	private String numeroCob;

	private String numeroctps;

	private String observacao;

	private String operacao;

	private String operacao2;

	private String orgexpedidorid;

	@Column(name="orkut_facebook")
	private String orkutFacebook;

	private String pis;

	private String pontoreferencia;

	@Column(name="pontoreferencia_cob")
	private String pontoreferenciaCob;

	private String razaosocial;

	private Integer referenciaclienteid;

	private Integer referenciafornecedorid;

	private BigDecimal salarioatual;

	private String seriectps;

	private String sigla;

	private String site;

	private String telefone1;

	private String telefone2;

	private Integer tipo;

	private String tipoconta;

	private String tipoconta2;

	private String tituloeleitor;

	private String twitter;

	private Timestamp vencimentocontrato;

	@OneToMany(mappedBy="pessoa")
	private List<XLocal> locais;

	@ManyToOne
	@JoinColumn(name="bairroid")
	private XBairro bairro;

	@ManyToOne
	@JoinColumn(name="bairroid_cob")
	private XBairro bairroCobranca;

	@ManyToOne
	@JoinColumn(name="cidadeid")
	private XCidade cidade;

	@ManyToOne
	@JoinColumn(name="cidadeid_cob")
	private XCidade cidadeCobranca;

	@ManyToOne
	@JoinColumn(name="conceitoid")
	private XConceito conceito;

	@ManyToOne
	@JoinColumn(name="redeclienteid")
	private XRedeCliente redeCliente;

	@OneToMany(mappedBy="pessoa")
	private List<XPessoaAdiantamento> pessoaAdiantamentos;

	@OneToMany(mappedBy="pessoa")
	private List<XPessoaCargo> pessoasCargo;

	@OneToMany(mappedBy="pessoa")
	private List<XPessoaConceito> pessoasConceito;

	@OneToMany(mappedBy="pessoa")
	private List<XPessoaContato> pessoasContato;

	@OneToMany(mappedBy="pessoa")
	private List<XPessoaDependente> pessoasDependente;

	@OneToMany(mappedBy="pessoa")
	private List<XPessoaDocumentacao> pessoasDocumentacao;

	@OneToMany(mappedBy="pessoa")
	private List<XPessoaExame> pessoasExame;

	@OneToMany(mappedBy="pessoa")
	private List<XPessoaFerias> pessoasFerias;

	@OneToMany(mappedBy="pessoa")
	private List<XPessoaGrupoItem> pessoasGrupoItems;

	@OneToMany(mappedBy="pessoa")
	private List<XPessoaHoraExtra> pessoaHorasExtras;

	@OneToMany(mappedBy="pessoa")
	private List<XPessoaInformacaoFinanceira> pessoasInformacaoFinanceira;

	@OneToMany(mappedBy="pessoa")
	private List<XPessoaItem> pessoaItens;

	@OneToMany(mappedBy="pessoa")
	private List<XPessoaOcorrencia> pessoasOcorrencias;

	@OneToMany(mappedBy="pessoa")
	private List<XPessoaPrecoItem> pessoasPrecoItem;

	@OneToMany(mappedBy="pessoa")
	private List<XPessoaRamoAtividade> pessoasRamoAtividade;

	@OneToMany(mappedBy="pessoa")
	private List<XPessoaRemuneracaoPadrao> pessoasRemuneracaoPadrao;

	@OneToMany(mappedBy="pessoa")
	private List<XPessoaSalario> pessoasSalario;

	@OneToMany(mappedBy="pessoa")
	private List<XRecepcionista> recepcionistas;

	@OneToMany(mappedBy="pessoa")
	private List<XRedeClientePessoa> redeClientePessoas;

	@OneToMany(mappedBy="pessoa")
	private List<XUsuario> usuarios;

	@OneToMany(mappedBy="pessoa")
	private List<XUsuarioGerenteComissao> usuariosGerentesComissao;

	@OneToMany(mappedBy="pessoa")
	private List<XProgramacaoFixa> programacoesFixas;

	@OneToMany(mappedBy="fornecedor")
	private List<XProgramacaoVariavel> programacoesVariaveis;

	@OneToMany(mappedBy="pessoa")
	private List<XPessoaHistorico> pessoaHistoricos;

	@OneToMany(mappedBy="aluno")
	private List<XAtaReuniaoParticipante> atasReuniaoParticipantes;

	@OneToMany(mappedBy="pessoa")
	private List<XBriefing> briefings;

	@OneToMany(mappedBy="pessoa")
	private List<XContaPagar> contasPagar;

	@OneToMany(mappedBy="fornecedor")
	private List<XContaPagarRateio> contasPagarRateios;

	@OneToMany(mappedBy="pessoa")
	private List<XContaReceber> contasReceber;

	@OneToMany(mappedBy="pessoa")
	private List<XCursoAluno> cursosAlunos;

	@OneToMany(mappedBy="pessoa")
	private List<XFaturaComissao> faturasComissao;

	@OneToMany(mappedBy="pessoa")
	private List<XGerenciamentoPerformance> gerenciamentoPerformances2;

	@OneToMany(mappedBy="pessoa2")
	private List<XGerenciamentoPerformance> gerenciamentoPerformances;

	@OneToMany(mappedBy="pessoa")
	private List<XJob> jobs;

	@OneToMany(mappedBy="pessoa")
	private List<XNotaDebito> notasDebito;

	@OneToMany(mappedBy="pessoa")
	private List<XNotaFiscal> notasFiscais;

	@OneToMany(mappedBy="comissionado")
	private List<XOrcamento> orcamentosComissionado;

	@OneToMany(mappedBy="pessoa")
	private List<XOrcamento> orcamentos;

	@OneToMany(mappedBy="pessoa")
	private List<XOrcamentoComissao> orcamentosComissao;

	@OneToMany(mappedBy="pessoa")
	private List<XOrcamentoPromotor> orcamentosPromotor;

	@OneToMany(mappedBy="cliente")
	private List<XOrdemServico> ordemServicosCliente;

	@OneToMany(mappedBy="fornecedor")
	private List<XOrdemServico> ordemServicosFornecedor;

	@OneToMany(mappedBy="terceiro")
	private List<XOrdemServico> ordemServicosTerceiro;

	@OneToMany(mappedBy="captador")
	private List<XProjeto> projetosCaptador;

	@OneToMany(mappedBy="clientePagador")
	private List<XProjeto> projetosClientePagador;

	@OneToMany(mappedBy="gerente")
	private List<XProjeto> projetosGerente;

	@OneToMany(mappedBy="vendedor")
	private List<XProjeto> projetosVendedor;

	@OneToMany(mappedBy="pessoa")
	private List<XProjetoComissao> projetosComissao;

	@OneToMany(mappedBy="pessoa")
	private List<XProjetoHistorico> projetosHistorico;

	@OneToMany(mappedBy="pessoa")
	private List<XProspeccao> prospeccoes;

	@OneToMany(mappedBy="pessoa")
	private List<XReclamacao> reclamacoes;

	@OneToMany(mappedBy="pessoa")
	private List<XReembolso> reembolsos;

	@OneToMany(mappedBy="pessoa")
	private List<XSolicitacaoCliente> solicitacoesClientes;

	@OneToMany(mappedBy="pessoa1")
	private List<XSolicitacaoOrcamento> solicitacoesOrcamento;

	//bi-directional many-to-one association to Msolicitacaoorcamento
	@OneToMany(mappedBy="pessoa2")
	private List<XSolicitacaoOrcamento> solicitacoesOrcamento2;

	//bi-directional many-to-one association to Mticketconsumo
	@OneToMany(mappedBy="pessoa")
	private List<XTicketConsumo> ticketsConsumo;

	@Transient
	private String codTurma;

	public XPessoa() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCallcenter() {
		return this.callcenter;
	}

	public void setCallcenter(String callcenter) {
		this.callcenter = callcenter;
	}

	public String getCargo() {
		return this.cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getCbo() {
		return this.cbo;
	}

	public void setCbo(String cbo) {
		this.cbo = cbo;
	}

	public String getCcontanumero2() {
		return this.ccontanumero2;
	}

	public void setCcontanumero2(String ccontanumero2) {
		this.ccontanumero2 = ccontanumero2;
	}

	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCepCob() {
		return this.cepCob;
	}

	public void setCepCob(String cepCob) {
		this.cepCob = cepCob;
	}

	public String getCnpj() {
		return this.cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public BigDecimal getComissao() {
		return this.comissao;
	}

	public void setComissao(BigDecimal comissao) {
		this.comissao = comissao;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getComplementoCob() {
		return this.complementoCob;
	}

	public void setComplementoCob(String complementoCob) {
		this.complementoCob = complementoCob;
	}

	public String getContaagencia() {
		return this.contaagencia;
	}

	public void setContaagencia(String contaagencia) {
		this.contaagencia = contaagencia;
	}

	public String getContaagencia2() {
		return this.contaagencia2;
	}

	public void setContaagencia2(String contaagencia2) {
		this.contaagencia2 = contaagencia2;
	}

	public String getContabanco() {
		return this.contabanco;
	}

	public void setContabanco(String contabanco) {
		this.contabanco = contabanco;
	}

	public String getContabanco2() {
		return this.contabanco2;
	}

	public void setContabanco2(String contabanco2) {
		this.contabanco2 = contabanco2;
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

	public String getContatitular2() {
		return this.contatitular2;
	}

	public void setContatitular2(String contatitular2) {
		this.contatitular2 = contatitular2;
	}

	public String getContato() {
		return this.contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Timestamp getDataadmissao() {
		return this.dataadmissao;
	}

	public void setDataadmissao(Timestamp dataadmissao) {
		this.dataadmissao = dataadmissao;
	}

	public Date getDatanascimento() {
		return this.datanascimento;
	}

	public void setDatanascimento(Date datanascimento) {
		this.datanascimento = datanascimento;
	}

	public Timestamp getDatareferenciaatual() {
		return this.datareferenciaatual;
	}

	public void setDatareferenciaatual(Timestamp datareferenciaatual) {
		this.datareferenciaatual = datareferenciaatual;
	}

	public Boolean getEhaluno() {
		return this.ehaluno;
	}

	public void setEhaluno(Boolean ehaluno) {
		this.ehaluno = ehaluno;
	}

	public Boolean getEhativo() {
		return this.ehativo;
	}

	public void setEhativo(Boolean ehativo) {
		this.ehativo = ehativo;
	}

	public Boolean getEhcliente() {
		return this.ehcliente;
	}

	public void setEhcliente(Boolean ehcliente) {
		this.ehcliente = ehcliente;
	}

	public Boolean getEhfornecedor() {
		return this.ehfornecedor;
	}

	public void setEhfornecedor(Boolean ehfornecedor) {
		this.ehfornecedor = ehfornecedor;
	}

	public Boolean getEhfuncionario() {
		return this.ehfuncionario;
	}

	public void setEhfuncionario(Boolean ehfuncionario) {
		this.ehfuncionario = ehfuncionario;
	}

	public Boolean getEhgerente() {
		return this.ehgerente;
	}

	public void setEhgerente(Boolean ehgerente) {
		this.ehgerente = ehgerente;
	}

	public Boolean getEhpatrocianador() {
		return this.ehpatrocianador;
	}

	public void setEhpatrocianador(Boolean ehpatrocianador) {
		this.ehpatrocianador = ehpatrocianador;
	}

	public Boolean getEhrecepcionista() {
		return this.ehrecepcionista;
	}

	public void setEhrecepcionista(Boolean ehrecepcionista) {
		this.ehrecepcionista = ehrecepcionista;
	}

	public Boolean getEhremuneracaopadraofixada() {
		return this.ehremuneracaopadraofixada;
	}

	public void setEhremuneracaopadraofixada(Boolean ehremuneracaopadraofixada) {
		this.ehremuneracaopadraofixada = ehremuneracaopadraofixada;
	}

	public Boolean getEhvendendor() {
		return this.ehvendendor;
	}

	public void setEhvendendor(Boolean ehvendendor) {
		this.ehvendendor = ehvendendor;
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

	public String getEmail3() {
		return this.email3;
	}

	public void setEmail3(String email3) {
		this.email3 = email3;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEnderecoCob() {
		return this.enderecoCob;
	}

	public void setEnderecoCob(String enderecoCob) {
		this.enderecoCob = enderecoCob;
	}

	public String getEnderecoarquivoservidor() {
		return this.enderecoarquivoservidor;
	}

	public void setEnderecoarquivoservidor(String enderecoarquivoservidor) {
		this.enderecoarquivoservidor = enderecoarquivoservidor;
	}

	public String getEstadocivil() {
		return this.estadocivil;
	}

	public void setEstadocivil(String estadocivil) {
		this.estadocivil = estadocivil;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getFiliacaomae() {
		return this.filiacaomae;
	}

	public void setFiliacaomae(String filiacaomae) {
		this.filiacaomae = filiacaomae;
	}

	public String getFiliacaopai() {
		return this.filiacaopai;
	}

	public void setFiliacaopai(String filiacaopai) {
		this.filiacaopai = filiacaopai;
	}

	public byte[] getFoto() {
		return this.foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public String getFuncao() {
		return this.funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public String getIdentidade() {
		return this.identidade;
	}

	public void setIdentidade(String identidade) {
		this.identidade = identidade;
	}

	public String getIdnextel() {
		return this.idnextel;
	}

	public void setIdnextel(String idnextel) {
		this.idnextel = idnextel;
	}

	public String getInscricaoestadual() {
		return this.inscricaoestadual;
	}

	public void setInscricaoestadual(String inscricaoestadual) {
		this.inscricaoestadual = inscricaoestadual;
	}

	public String getInscricaomunicipal() {
		return this.inscricaomunicipal;
	}

	public void setInscricaomunicipal(String inscricaomunicipal) {
		this.inscricaomunicipal = inscricaomunicipal;
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

	public String getNumeroCob() {
		return this.numeroCob;
	}

	public void setNumeroCob(String numeroCob) {
		this.numeroCob = numeroCob;
	}

	public String getNumeroctps() {
		return this.numeroctps;
	}

	public void setNumeroctps(String numeroctps) {
		this.numeroctps = numeroctps;
	}

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getOperacao() {
		return this.operacao;
	}

	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}

	public String getOperacao2() {
		return this.operacao2;
	}

	public void setOperacao2(String operacao2) {
		this.operacao2 = operacao2;
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

	public String getPontoreferenciaCob() {
		return this.pontoreferenciaCob;
	}

	public void setPontoreferenciaCob(String pontoreferenciaCob) {
		this.pontoreferenciaCob = pontoreferenciaCob;
	}

	public String getRazaosocial() {
		return this.razaosocial;
	}

	public void setRazaosocial(String razaosocial) {
		this.razaosocial = razaosocial;
	}

	public Integer getReferenciaclienteid() {
		return this.referenciaclienteid;
	}

	public void setReferenciaclienteid(Integer referenciaclienteid) {
		this.referenciaclienteid = referenciaclienteid;
	}

	public Integer getReferenciafornecedorid() {
		return this.referenciafornecedorid;
	}

	public void setReferenciafornecedorid(Integer referenciafornecedorid) {
		this.referenciafornecedorid = referenciafornecedorid;
	}

	public BigDecimal getSalarioatual() {
		return this.salarioatual;
	}

	public void setSalarioatual(BigDecimal salarioatual) {
		this.salarioatual = salarioatual;
	}

	public String getSeriectps() {
		return this.seriectps;
	}

	public void setSeriectps(String seriectps) {
		this.seriectps = seriectps;
	}

	public String getSigla() {
		return this.sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getSite() {
		return this.site;
	}

	public void setSite(String site) {
		this.site = site;
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

	public Integer getTipo() {
		return this.tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public String getTipoconta() {
		return this.tipoconta;
	}

	public void setTipoconta(String tipoconta) {
		this.tipoconta = tipoconta;
	}

	public String getTipoconta2() {
		return this.tipoconta2;
	}

	public void setTipoconta2(String tipoconta2) {
		this.tipoconta2 = tipoconta2;
	}

	public String getTituloeleitor() {
		return this.tituloeleitor;
	}

	public void setTituloeleitor(String tituloeleitor) {
		this.tituloeleitor = tituloeleitor;
	}

	public String getTwitter() {
		return this.twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public Timestamp getVencimentocontrato() {
		return this.vencimentocontrato;
	}

	public void setVencimentocontrato(Timestamp vencimentocontrato) {
		this.vencimentocontrato = vencimentocontrato;
	}

	public List<XLocal> getLocais() {
		return this.locais;
	}

	public void setLocals(List<XLocal> locais) {
		this.locais = locais;
	}

	public XBairro getBairro1() {
		return this.bairro;
	}

	public void setBairro(XBairro bairro) {
		this.bairro = bairro;
	}

	public XBairro getBairroCobranca() {
		return this.bairroCobranca;
	}

	public void setBairroCobranca(XBairro bairroCobranca) {
		this.bairroCobranca = bairroCobranca;
	}

	public XCidade getCidade() {
		return this.cidade;
	}

	public void setCidade(XCidade cidade) {
		this.cidade = cidade;
	}

	public XCidade getCidadeCobranca() {
		return this.cidadeCobranca;
	}

	public void setCidadeCobranca(XCidade cidadeCobranca) {
		this.cidadeCobranca = cidadeCobranca;
	}

	public XConceito getConceito() {
		return this.conceito;
	}

	public void setConceito(XConceito conceito) {
		this.conceito = conceito;
	}

	public XRedeCliente getRedeCliente() {
		return this.redeCliente;
	}

	public void setRedeCliente(XRedeCliente redeCliente) {
		this.redeCliente = redeCliente;
	}

	public List<XPessoaAdiantamento> getPessoaAdiantamentos() {
		return this.pessoaAdiantamentos;
	}

	public void setPessoaAdiantamentos(List<XPessoaAdiantamento> pessoaAdiantamentos) {
		this.pessoaAdiantamentos = pessoaAdiantamentos;
	}

	public List<XPessoaCargo> getPessoaCargos() {
		return this.pessoasCargo;
	}

	public void setPessoaCargos(List<XPessoaCargo> pessoasCargo) {
		this.pessoasCargo = pessoasCargo;
	}

	public List<XPessoaConceito> getPessoasConceito() {
		return this.pessoasConceito;
	}

	public void setPessoasConceito(List<XPessoaConceito> pessoasConceito) {
		this.pessoasConceito = pessoasConceito;
	}

	public List<XPessoaContato> getCpessoacontatos() {
		return this.pessoasContato;
	}

	public void setCpessoacontatos(List<XPessoaContato> pessoasContato) {
		this.pessoasContato = pessoasContato;
	}

	public List<XPessoaDependente> getPessoaDependentes() {
		return this.pessoasDependente;
	}

	public void setPessoasDependente(List<XPessoaDependente> pessoasDependente) {
		this.pessoasDependente = pessoasDependente;
	}

	public List<XPessoaDocumentacao> getPessoasDocumentacao() {
		return this.pessoasDocumentacao;
	}

	public void setPessoaDocumentacao(List<XPessoaDocumentacao> pessoasDocumentacao) {
		this.pessoasDocumentacao = pessoasDocumentacao;
	}

	public List<XPessoaExame> getPessoasExame() {
		return this.pessoasExame;
	}

	public void setPessoasExame(List<XPessoaExame> pessoasExame) {
		this.pessoasExame = pessoasExame;
	}

	public List<XPessoaFerias> getPessoasFerias() {
		return this.pessoasFerias;
	}

	public void setPessoasFerias(List<XPessoaFerias> pessoasFerias) {
		this.pessoasFerias = pessoasFerias;
	}

	public List<XPessoaGrupoItem> getPessoasGrupoItems() {
		return this.pessoasGrupoItems;
	}

	public void setPessoasGrupoItems(List<XPessoaGrupoItem> pessoasGrupoItems) {
		this.pessoasGrupoItems = pessoasGrupoItems;
	}

	public List<XPessoaHoraExtra> getPessoaHorasExtras() {
		return this.pessoaHorasExtras;
	}

	public void setPessoaHorasExtras(List<XPessoaHoraExtra> pessoaHorasExtras) {
		this.pessoaHorasExtras = pessoaHorasExtras;
	}

	public List<XPessoaInformacaoFinanceira> getPessoasInformacaoFinanceira() {
		return this.pessoasInformacaoFinanceira;
	}

	public void setPessoasInformacaoFinanceira(List<XPessoaInformacaoFinanceira> pessoasInformacaoFinanceira) {
		this.pessoasInformacaoFinanceira = pessoasInformacaoFinanceira;
	}

	public List<XPessoaItem> getPessoaItens() {
		return this.pessoaItens;
	}

	public void setCpessoaitems(List<XPessoaItem> pessoaItens) {
		this.pessoaItens = pessoaItens;
	}

	public List<XPessoaOcorrencia> getPessoaOcorrencias() {
		return this.pessoasOcorrencias;
	}

	public void setPessoaOcorrencias(List<XPessoaOcorrencia> pessoasOcorrencias) {
		this.pessoasOcorrencias = pessoasOcorrencias;
	}

	public List<XPessoaPrecoItem> getPessoaPrecoItens() {
		return this.pessoasPrecoItem;
	}

	public void setPessoaPrecoItens(List<XPessoaPrecoItem> pessoasPrecoItem) {
		this.pessoasPrecoItem = pessoasPrecoItem;
	}

	public List<XPessoaRamoAtividade> getPessoaRamoAtividades() {
		return this.pessoasRamoAtividade;
	}

	public void setPessoaRamoAtividades(List<XPessoaRamoAtividade> pessoasRamoAtividade) {
		this.pessoasRamoAtividade = pessoasRamoAtividade;
	}

	public List<XPessoaRemuneracaoPadrao> getPessoasRemuneracaoPadrao() {
		return this.pessoasRemuneracaoPadrao;
	}

	public void setPessoasRemuneracaoPadrao(List<XPessoaRemuneracaoPadrao> pessoasRemuneracaoPadrao) {
		this.pessoasRemuneracaoPadrao = pessoasRemuneracaoPadrao;
	}

	public List<XPessoaSalario> getPessoasSalario() {
		return this.pessoasSalario;
	}

	public void setPessoasSalario(List<XPessoaSalario> pessoasSalario) {
		this.pessoasSalario = pessoasSalario;
	}

	public List<XRecepcionista> getRecepcionistas() {
		return this.recepcionistas;
	}

	public void setRecepcionistas(List<XRecepcionista> recepcionistas) {
		this.recepcionistas = recepcionistas;
	}

	public List<XRedeClientePessoa> getRedeClientePessoas() {
		return this.redeClientePessoas;
	}

	public void setRedeClientePessoas(List<XRedeClientePessoa> redeClientePessoas) {
		this.redeClientePessoas = redeClientePessoas;
	}

	public List<XUsuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<XUsuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<XPessoaCargo> getPessoasCargo() {
		return pessoasCargo;
	}

	public void setPessoasCargo(List<XPessoaCargo> pessoasCargo) {
		this.pessoasCargo = pessoasCargo;
	}

	public List<XPessoaContato> getPessoasContato() {
		return pessoasContato;
	}

	public void setPessoasContato(List<XPessoaContato> pessoasContato) {
		this.pessoasContato = pessoasContato;
	}

	public List<XPessoaOcorrencia> getPessoasOcorrencias() {
		return pessoasOcorrencias;
	}

	public void setPessoasOcorrencias(List<XPessoaOcorrencia> pessoasOcorrencias) {
		this.pessoasOcorrencias = pessoasOcorrencias;
	}

	public List<XPessoaPrecoItem> getPessoasPrecoItem() {
		return pessoasPrecoItem;
	}

	public void setPessoasPrecoItem(List<XPessoaPrecoItem> pessoasPrecoItem) {
		this.pessoasPrecoItem = pessoasPrecoItem;
	}

	public List<XPessoaRamoAtividade> getPessoasRamoAtividade() {
		return pessoasRamoAtividade;
	}

	public void setPessoasRamoAtividade(List<XPessoaRamoAtividade> pessoasRamoAtividade) {
		this.pessoasRamoAtividade = pessoasRamoAtividade;
	}

	public List<XUsuarioGerenteComissao> getUsuariosGerentesComissao() {
		return usuariosGerentesComissao;
	}

	public void setUsuariosGerentesComissao(List<XUsuarioGerenteComissao> usuariosGerentesComissao) {
		this.usuariosGerentesComissao = usuariosGerentesComissao;
	}

	public List<XProgramacaoFixa> getProgramacoesFixas() {
		return programacoesFixas;
	}

	public void setProgramacoesFixas(List<XProgramacaoFixa> programacoesFixas) {
		this.programacoesFixas = programacoesFixas;
	}

	public List<XProgramacaoVariavel> getProgramacoesVariaveis() {
		return programacoesVariaveis;
	}

	public void setProgramacoesVariaveis(List<XProgramacaoVariavel> programacoesVariaveis) {
		this.programacoesVariaveis = programacoesVariaveis;
	}

	public List<XPessoaHistorico> getPessoaHistoricos() {
		return pessoaHistoricos;
	}

	public void setPessoaHistoricos(List<XPessoaHistorico> pessoaHistoricos) {
		this.pessoaHistoricos = pessoaHistoricos;
	}

	public List<XAtaReuniaoParticipante> getAtasReuniaoParticipantes() {
		return atasReuniaoParticipantes;
	}

	public void setAtasReuniaoParticipantes(List<XAtaReuniaoParticipante> atasReuniaoParticipantes) {
		this.atasReuniaoParticipantes = atasReuniaoParticipantes;
	}

	public List<XBriefing> getBriefings() {
		return briefings;
	}

	public void setBriefings(List<XBriefing> briefings) {
		this.briefings = briefings;
	}

	public List<XGerenciamentoPerformance> getGerenciamentoPerformances2() {
		return gerenciamentoPerformances2;
	}

	public void setGerenciamentoPerformances2(List<XGerenciamentoPerformance> gerenciamentoPerformances2) {
		this.gerenciamentoPerformances2 = gerenciamentoPerformances2;
	}

	public List<XGerenciamentoPerformance> getGerenciamentoPerformances() {
		return gerenciamentoPerformances;
	}

	public void setGerenciamentoPerformances(List<XGerenciamentoPerformance> gerenciamentoPerformances) {
		this.gerenciamentoPerformances = gerenciamentoPerformances;
	}

	public List<XJob> getJobs() {
		return jobs;
	}

	public void setJobs(List<XJob> jobs) {
		this.jobs = jobs;
	}

	public List<XContaPagar> getContasPagar() {
		return contasPagar;
	}

	public void setContasPagar(List<XContaPagar> contasPagar) {
		this.contasPagar = contasPagar;
	}

	public List<XContaPagarRateio> getContasPagarRateios() {
		return contasPagarRateios;
	}

	public void setContasPagarRateios(List<XContaPagarRateio> contasPagarRateios) {
		this.contasPagarRateios = contasPagarRateios;
	}

	public List<XContaReceber> getContasReceber() {
		return contasReceber;
	}

	public void setContasReceber(List<XContaReceber> contasReceber) {
		this.contasReceber = contasReceber;
	}

	public List<XCursoAluno> getCursosAlunos() {
		return cursosAlunos;
	}

	public void setCursosAlunos(List<XCursoAluno> cursosAlunos) {
		this.cursosAlunos = cursosAlunos;
	}

	public List<XFaturaComissao> getFaturasComissao() {
		return faturasComissao;
	}

	public void setFaturasComissao(List<XFaturaComissao> faturasComissao) {
		this.faturasComissao = faturasComissao;
	}

	public List<XNotaDebito> getNotasDebito() {
		return notasDebito;
	}

	public void setNotasDebito(List<XNotaDebito> notasDebito) {
		this.notasDebito = notasDebito;
	}

	public List<XNotaFiscal> getNotasFiscais() {
		return notasFiscais;
	}

	public void setNotasFiscais(List<XNotaFiscal> notasFiscais) {
		this.notasFiscais = notasFiscais;
	}

	public List<XOrcamento> getOrcamentosComissionado() {
		return orcamentosComissionado;
	}

	public void setOrcamentosComissionado(List<XOrcamento> orcamentosComissionado) {
		this.orcamentosComissionado = orcamentosComissionado;
	}

	public List<XOrcamento> getOrcamentos() {
		return orcamentos;
	}

	public void setOrcamentos(List<XOrcamento> orcamentos) {
		this.orcamentos = orcamentos;
	}

	public List<XOrcamentoComissao> getOrcamentosComissao() {
		return orcamentosComissao;
	}

	public void setOrcamentosComissao(List<XOrcamentoComissao> orcamentosComissao) {
		this.orcamentosComissao = orcamentosComissao;
	}

	public List<XOrcamentoPromotor> getOrcamentosPromotor() {
		return orcamentosPromotor;
	}

	public void setOrcamentosPromotor(List<XOrcamentoPromotor> orcamentosPromotor) {
		this.orcamentosPromotor = orcamentosPromotor;
	}

	public List<XOrdemServico> getOrdemServicosCliente() {
		return ordemServicosCliente;
	}

	public void setOrdemServicosCliente(List<XOrdemServico> ordemServicosCliente) {
		this.ordemServicosCliente = ordemServicosCliente;
	}

	public List<XOrdemServico> getOrdemServicosFornecedor() {
		return ordemServicosFornecedor;
	}

	public void setOrdemServicosFornecedor(List<XOrdemServico> ordemServicosFornecedor) {
		this.ordemServicosFornecedor = ordemServicosFornecedor;
	}

	public List<XOrdemServico> getOrdemServicosTerceiro() {
		return ordemServicosTerceiro;
	}

	public void setOrdemServicosTerceiro(List<XOrdemServico> ordemServicosTerceiro) {
		this.ordemServicosTerceiro = ordemServicosTerceiro;
	}

	public List<XProjeto> getProjetosCaptador() {
		return projetosCaptador;
	}

	public void setProjetosCaptador(List<XProjeto> projetosCaptador) {
		this.projetosCaptador = projetosCaptador;
	}

	public List<XProjeto> getProjetosClientePagador() {
		return projetosClientePagador;
	}

	public void setProjetosClientePagador(List<XProjeto> projetosClientePagador) {
		this.projetosClientePagador = projetosClientePagador;
	}

	public List<XProjeto> getProjetosGerente() {
		return projetosGerente;
	}

	public void setProjetosGerente(List<XProjeto> projetosGerente) {
		this.projetosGerente = projetosGerente;
	}

	public List<XProjeto> getProjetosVendedor() {
		return projetosVendedor;
	}

	public void setProjetosVendedor(List<XProjeto> projetosVendedor) {
		this.projetosVendedor = projetosVendedor;
	}

	public List<XReembolso> getReembolsos() {
		return reembolsos;
	}

	public void setReembolsos(List<XReembolso> reembolsos) {
		this.reembolsos = reembolsos;
	}

	public XBairro getBairro() {
		return bairro;
	}

	public List<XPessoaDependente> getPessoasDependente() {
		return pessoasDependente;
	}

	public void setLocais(List<XLocal> locais) {
		this.locais = locais;
	}

	public void setPessoasDocumentacao(List<XPessoaDocumentacao> pessoasDocumentacao) {
		this.pessoasDocumentacao = pessoasDocumentacao;
	}

	public void setPessoaItens(List<XPessoaItem> pessoaItens) {
		this.pessoaItens = pessoaItens;
	}

	public void setSolicitacoesOrcamento(List<XSolicitacaoOrcamento> solicitacoesOrcamento) {
		this.solicitacoesOrcamento = solicitacoesOrcamento;
	}

	public void setSolicitacoesOrcamento2(List<XSolicitacaoOrcamento> solicitacoesOrcamento2) {
		this.solicitacoesOrcamento2 = solicitacoesOrcamento2;
	}

	public List<XProjetoComissao> getProjetosComissao() {
		return projetosComissao;
	}

	public void setProjetosComissao(List<XProjetoComissao> projetosComissao) {
		this.projetosComissao = projetosComissao;
	}

	public List<XProjetoHistorico> getProjetosHistorico() {
		return projetosHistorico;
	}

	public void setProjetosHistorico(List<XProjetoHistorico> projetosHistorico) {
		this.projetosHistorico = projetosHistorico;
	}

	public List<XProspeccao> getProspeccoes() {
		return prospeccoes;
	}

	public void setProspeccoes(List<XProspeccao> prospeccoes) {
		this.prospeccoes = prospeccoes;
	}

	public List<XReclamacao> getReclamacoes() {
		return reclamacoes;
	}

	public void setReclamacoes(List<XReclamacao> reclamacoes) {
		this.reclamacoes = reclamacoes;
	}

	public List<XReembolso> getReembolso() {
		return this.reembolsos;
	}

	public void setReembolso(List<XReembolso> reembolsos) {
		this.reembolsos = reembolsos;
	}

	public List<XSolicitacaoCliente> getSolicitacoesClientes() {
		return this.solicitacoesClientes;
	}

	public void setSolicitacoesClientes(List<XSolicitacaoCliente> solicitacoesClientes) {
		this.solicitacoesClientes = solicitacoesClientes;
	}

	public List<XSolicitacaoOrcamento> getSolicitacoesOrcamento() {
		return this.solicitacoesOrcamento;
	}

	public void setSolicitacoesOrcamento1(List<XSolicitacaoOrcamento> solicitacoesOrcamento) {
		this.solicitacoesOrcamento = solicitacoesOrcamento;
	}

	public List<XSolicitacaoOrcamento> getSolicitacoesOrcamento2() {
		return this.solicitacoesOrcamento2;
	}

	public void setMsolicitacaoorcamentos2(List<XSolicitacaoOrcamento> solicitacoesOrcamento2) {
		this.solicitacoesOrcamento2 = solicitacoesOrcamento2;
	}

	public List<XTicketConsumo> getTicketsConsumo() {
		return this.ticketsConsumo;
	}

	public void setTicketsConsumo(List<XTicketConsumo> ticketsConsumo) {
		this.ticketsConsumo = ticketsConsumo;
	}

	public void setCodTurma(String codTurma) {
		this.codTurma = codTurma;
	}

	public String getCodTurma() {
		return this.codTurma;
	}

	public Integer getCodBB() {
		return codBB;
	}

	public void setCodBB(Integer codBB) {
		this.codBB = codBB;
	}

}