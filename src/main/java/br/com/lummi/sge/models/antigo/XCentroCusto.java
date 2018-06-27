package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ccentrocusto database table.
 * 
 */
@Entity
@Table(name="ccentrocusto")
public class XCentroCusto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String categoria;

	private String codigo;

	private String codigoContabil;

	private String contaContabil;

	private String grupodre;

	private String nome;

	private String tipo;

	private String xxx;

	@OneToMany(mappedBy="centroCusto")
	private List<XProgramacaoFixa> programacoesFixas;

	@OneToMany(mappedBy="centroCusto")
	private List<XProgramacaoVariavel> programacoesVariaveis;

	@OneToMany(mappedBy="centroCusto1")
	private List<XSistema> sistemas;

	@OneToMany(mappedBy="centroCustoContasPagar")
	private List<XSistema> sistemas2;

	@OneToMany(mappedBy="centroCustoContasReceber")
	private List<XSistema> sistemas3;

	@OneToMany(mappedBy="centroCustoOrdemServico")
	private List<XSistema> sistemas4;

	@OneToMany(mappedBy="centroCusto")
	private List<XContaPagar> contasPagar;

	@OneToMany(mappedBy="centroCusto")
	private List<XContaPagarRateio> contaPagarRateios;

	@OneToMany(mappedBy="centroCusto")
	private List<XContaReceber> contasReceber;

	@OneToMany(mappedBy="centroCusto")
	private List<XContaReceberRateio> contaReceberRateios;

	@OneToMany(mappedBy="centroCusto")
	private List<XCursoAluno> cursoAlunos;

	@OneToMany(mappedBy="centroCusto")
	private List<XFaturaComissao> faturasComissao;

	@OneToMany(mappedBy="centroCusto")
	private List<XOrcamento> orcamentos;

	@OneToMany(mappedBy="centroCusto")
	private List<XOrcamentoComissao> orcamentosComissao;

	@OneToMany(mappedBy="centroCusto")
	private List<XOrcamentoPrevisaoDespesa> orcamentosPrevisaoDespesas;

	@OneToMany(mappedBy="centroCusto")
	private List<XOrcamentoPrevisaoReceita> orcamentosPrevisaoReceitas;

	@OneToMany(mappedBy="centroCusto")
	private List<XOrdemServico> ordensServico;

	@OneToMany(mappedBy="centroCusto")
	private List<XProjeto> projetos;

	@OneToMany(mappedBy="centroCusto")
	private List<XReembolso> reembolsos;

	@OneToMany(mappedBy="centroCusto")
	private List<XReembolsoDespesa> reembolsosDespesa;

	@OneToMany(mappedBy="centroCusto")
	private List<XSolicitacaoOrcamento> solicitacoesOrcamento;

	@OneToMany(mappedBy="centroCusto")
	private List<XTicketConsumo> ticketsConsumo;

	public XCentroCusto() {
	}

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

	public String getCodigoContabil() {
		return codigoContabil;
	}

	public void setCodigoContabil(String codigoContabil) {
		this.codigoContabil = codigoContabil;
	}

	public String getContaContabil() {
		return contaContabil;
	}

	public void setContaContabil(String contaContabil) {
		this.contaContabil = contaContabil;
	}

	public String getGrupodre() {
		return grupodre;
	}

	public void setGrupodre(String grupodre) {
		this.grupodre = grupodre;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getXxx() {
		return xxx;
	}

	public void setXxx(String xxx) {
		this.xxx = xxx;
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

	public List<XSistema> getSistemas() {
		return sistemas;
	}

	public void setSistemas(List<XSistema> sistemas) {
		this.sistemas = sistemas;
	}

	public List<XSistema> getSistemas2() {
		return sistemas2;
	}

	public void setSistemas2(List<XSistema> sistemas2) {
		this.sistemas2 = sistemas2;
	}

	public List<XSistema> getSistemas3() {
		return sistemas3;
	}

	public void setSistemas3(List<XSistema> sistemas3) {
		this.sistemas3 = sistemas3;
	}

	public List<XSistema> getSistemas4() {
		return sistemas4;
	}

	public void setSistemas4(List<XSistema> sistemas4) {
		this.sistemas4 = sistemas4;
	}

	public List<XContaPagar> getContasPagar() {
		return contasPagar;
	}

	public void setContasPagar(List<XContaPagar> contasPagar) {
		this.contasPagar = contasPagar;
	}

	public List<XContaPagarRateio> getContaPagarRateios() {
		return contaPagarRateios;
	}

	public void setContaPagarRateios(List<XContaPagarRateio> contaPagarRateios) {
		this.contaPagarRateios = contaPagarRateios;
	}

	public List<XContaReceber> getContasReceber() {
		return contasReceber;
	}

	public void setContasReceber(List<XContaReceber> contasReceber) {
		this.contasReceber = contasReceber;
	}

	public List<XContaReceberRateio> getContaReceberRateios() {
		return contaReceberRateios;
	}

	public void setContaReceberRateios(List<XContaReceberRateio> contaReceberRateios) {
		this.contaReceberRateios = contaReceberRateios;
	}

	public List<XCursoAluno> getCursoAlunos() {
		return cursoAlunos;
	}

	public void setCursoAlunos(List<XCursoAluno> cursoAlunos) {
		this.cursoAlunos = cursoAlunos;
	}

	public List<XFaturaComissao> getFaturasComissao() {
		return faturasComissao;
	}

	public void setFaturasComissao(List<XFaturaComissao> faturasComissao) {
		this.faturasComissao = faturasComissao;
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

	public List<XOrcamentoPrevisaoDespesa> getOrcamentosPrevisaoDespesas() {
		return orcamentosPrevisaoDespesas;
	}

	public void setOrcamentosPrevisaoDespesas(List<XOrcamentoPrevisaoDespesa> orcamentosPrevisaoDespesas) {
		this.orcamentosPrevisaoDespesas = orcamentosPrevisaoDespesas;
	}

	public List<XOrcamentoPrevisaoReceita> getOrcamentosPrevisaoReceitas() {
		return orcamentosPrevisaoReceitas;
	}

	public void setOrcamentosPrevisaoReceitas(List<XOrcamentoPrevisaoReceita> orcamentosPrevisaoReceitas) {
		this.orcamentosPrevisaoReceitas = orcamentosPrevisaoReceitas;
	}

	public List<XOrdemServico> getOrdensServico() {
		return ordensServico;
	}

	public void setOrdensServico(List<XOrdemServico> ordensServico) {
		this.ordensServico = ordensServico;
	}

	public List<XProjeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<XProjeto> projetos) {
		this.projetos = projetos;
	}

	public List<XReembolso> getReembolsos() {
		return reembolsos;
	}

	public void setReembolsos(List<XReembolso> reembolsos) {
		this.reembolsos = reembolsos;
	}

	public List<XReembolsoDespesa> getReembolsosDespesa() {
		return reembolsosDespesa;
	}

	public void setReembolsosDespesa(List<XReembolsoDespesa> reembolsosDespesa) {
		this.reembolsosDespesa = reembolsosDespesa;
	}

	public List<XSolicitacaoOrcamento> getSolicitacoesOrcamento() {
		return solicitacoesOrcamento;
	}

	public void setSolicitacoesOrcamento(List<XSolicitacaoOrcamento> solicitacoesOrcamento) {
		this.solicitacoesOrcamento = solicitacoesOrcamento;
	}

	public List<XTicketConsumo> getTicketsConsumo() {
		return ticketsConsumo;
	}

	public void setTicketsConsumo(List<XTicketConsumo> ticketsConsumo) {
		this.ticketsConsumo = ticketsConsumo;
	}


}