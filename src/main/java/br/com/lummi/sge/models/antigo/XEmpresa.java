package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cempresa database table.
 * 
 */
@Entity
@Table(name="cempresa")
public class XEmpresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String cnpj;

	private String endereco;

	private String inscricaoestadual;

	private String linha1;

	private String linha2;

	private String linha3;

	private String linha4;

	private String linha5;

	private byte[] logo;

	private String municipio;

	private String nome;

	private String notadebitolinha1;

	private String notadebitolinha2;

	private String notadebitolinha3;

	private String notadebitolinha4;

	private String notadebitolinha5;

	private String razaosocial;

	//bi-directional many-to-one association to Ccidade
	@ManyToOne
	@JoinColumn(name="cidadeid")
	private XCidade cidade;

	@OneToMany(mappedBy="empresa")
	private List<XRecepcionista> recepcionistas;

	@OneToMany(mappedBy="empresa")
	private List<XProgramacaoFixa> programacaoFixas;

	@OneToMany(mappedBy="empresa")
	private List<XContaPagar> contasPagar;

	@OneToMany(mappedBy="empresa")
	private List<XContaPagarRateio> contasPagarRateios;

	@OneToMany(mappedBy="empresa")
	private List<XContaReceber> contasReceber;

	@OneToMany(mappedBy="empresa")
	private List<XContaReceberRateio> contasReceberRateios;

	@OneToMany(mappedBy="empresa")
	private List<XFaturaComissao> faturasComissao;

	@OneToMany(mappedBy="empresa")
	private List<XNotaDebito> notasDebito;

	@OneToMany(mappedBy="empresa")
	private List<XOrcamento> orcamentos;

	@OneToMany(mappedBy="empresa")
	private List<XOrdemServico> ordensServico;

	@OneToMany(mappedBy="empresa")
	private List<XPesquisaSatisfacao> pesquisasSatisfacao;

	@OneToMany(mappedBy="empresa")
	private List<XProjeto> projetos;

	@OneToMany(mappedBy="empresa")
	private List<XReclamacao> reclamacaos;

	@OneToMany(mappedBy="empresa")
	private List<XSolicitacaoCliente> solicitacoesClientes;

	@OneToMany(mappedBy="empresa")
	private List<XSolicitacaoOrcamento> solicitacoesOrcamento;

	public XEmpresa() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCnpj() {
		return this.cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getInscricaoestadual() {
		return this.inscricaoestadual;
	}

	public void setInscricaoestadual(String inscricaoestadual) {
		this.inscricaoestadual = inscricaoestadual;
	}

	public String getLinha1() {
		return this.linha1;
	}

	public void setLinha1(String linha1) {
		this.linha1 = linha1;
	}

	public String getLinha2() {
		return this.linha2;
	}

	public void setLinha2(String linha2) {
		this.linha2 = linha2;
	}

	public String getLinha3() {
		return this.linha3;
	}

	public void setLinha3(String linha3) {
		this.linha3 = linha3;
	}

	public String getLinha4() {
		return this.linha4;
	}

	public void setLinha4(String linha4) {
		this.linha4 = linha4;
	}

	public String getLinha5() {
		return this.linha5;
	}

	public void setLinha5(String linha5) {
		this.linha5 = linha5;
	}

	public byte[] getLogo() {
		return this.logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

	public String getMunicipio() {
		return this.municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNotadebitolinha1() {
		return this.notadebitolinha1;
	}

	public void setNotadebitolinha1(String notadebitolinha1) {
		this.notadebitolinha1 = notadebitolinha1;
	}

	public String getNotadebitolinha2() {
		return this.notadebitolinha2;
	}

	public void setNotadebitolinha2(String notadebitolinha2) {
		this.notadebitolinha2 = notadebitolinha2;
	}

	public String getNotadebitolinha3() {
		return this.notadebitolinha3;
	}

	public void setNotadebitolinha3(String notadebitolinha3) {
		this.notadebitolinha3 = notadebitolinha3;
	}

	public String getNotadebitolinha4() {
		return this.notadebitolinha4;
	}

	public void setNotadebitolinha4(String notadebitolinha4) {
		this.notadebitolinha4 = notadebitolinha4;
	}

	public String getNotadebitolinha5() {
		return this.notadebitolinha5;
	}

	public void setNotadebitolinha5(String notadebitolinha5) {
		this.notadebitolinha5 = notadebitolinha5;
	}

	public String getRazaosocial() {
		return this.razaosocial;
	}

	public void setRazaosocial(String razaosocial) {
		this.razaosocial = razaosocial;
	}

	public XCidade getCidade() {
		return this.cidade;
	}

	public void setCidade(XCidade cidade) {
		this.cidade = cidade;
	}

	public List<XOrcamento> getOrcamentos() {
		return this.orcamentos;
	}

	public void setOrcamentos(List<XOrcamento> orcamentos) {
		this.orcamentos = orcamentos;
	}

	public List<XOrdemServico> getOrdensServico() {
		return ordensServico;
	}

	public void setOrdensServico(List<XOrdemServico> ordensServico) {
		this.ordensServico = ordensServico;
	}

	public List<XPesquisaSatisfacao> getPesquisasSatisfacao() {
		return pesquisasSatisfacao;
	}

	public void setPesquisasSatisfacao(List<XPesquisaSatisfacao> pesquisasSatisfacao) {
		this.pesquisasSatisfacao = pesquisasSatisfacao;
	}

	public List<XRecepcionista> getRecepcionistas() {
		return recepcionistas;
	}

	public void setRecepcionistas(List<XRecepcionista> recepcionistas) {
		this.recepcionistas = recepcionistas;
	}

	public List<XProgramacaoFixa> getProgramacaoFixas() {
		return programacaoFixas;
	}

	public void setProgramacaoFixas(List<XProgramacaoFixa> programacaoFixas) {
		this.programacaoFixas = programacaoFixas;
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

	public List<XContaReceberRateio> getContasReceberRateios() {
		return contasReceberRateios;
	}

	public void setContasReceberRateios(List<XContaReceberRateio> contasReceberRateios) {
		this.contasReceberRateios = contasReceberRateios;
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

	public List<XProjeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<XProjeto> projetos) {
		this.projetos = projetos;
	}

	public List<XReclamacao> getReclamacaos() {
		return reclamacaos;
	}

	public void setReclamacaos(List<XReclamacao> reclamacaos) {
		this.reclamacaos = reclamacaos;
	}

	public List<XSolicitacaoCliente> getSolicitacoesClientes() {
		return solicitacoesClientes;
	}

	public void setSolicitacoesClientes(List<XSolicitacaoCliente> solicitacoesClientes) {
		this.solicitacoesClientes = solicitacoesClientes;
	}

	public List<XSolicitacaoOrcamento> getSolicitacoesOrcamento() {
		return solicitacoesOrcamento;
	}

	public void setSolicitacoesOrcamento(List<XSolicitacaoOrcamento> solicitacoesOrcamento) {
		this.solicitacoesOrcamento = solicitacoesOrcamento;
	}

}