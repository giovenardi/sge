package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the morcamento database table.
 * 
 */
@Entity
@Table(name="morcamento")
public class XOrcamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private BigDecimal basecalculoimposto;

	private String codigo;

	private BigDecimal cofins;

	private BigDecimal comissao;

	private BigDecimal ctsocial;

	private Timestamp data;

	private Timestamp datacadastro;

	private Timestamp datahoraaprovacao;

	private Timestamp datanaoaprovacao;

	private BigDecimal desconto;

	private String descricao;

	private BigDecimal despesaestimada;

	private String enderecoarquivo;

	private BigDecimal estalo;

	private String historico;

	private Timestamp horarioevento;

	private BigDecimal impostos;

	private Timestamp iniciodesmontagem;

	private Timestamp inicioevento;

	private Timestamp iniciomontagem;

	private BigDecimal inss;

	private BigDecimal irpj;

	private String justificativanaoaprovacao;

	private String localevento;

	private String nomeevento;

	private String observacao;

	private String obstecnica;

	private BigDecimal percentualmargemglobal;

	private BigDecimal percentualremuneracao;

	private BigDecimal pis;

	private Integer publicoestimado;

	private BigDecimal receitaestimada;

	private String referencia;

	private Timestamp referenciafinanceira;

	private BigDecimal remuneracao;

	private BigDecimal resultadoestimada;

	private Integer revisao;

	private BigDecimal simples;

	private BigDecimal ss;

	private String status;

	private BigDecimal subtotal;

	private Timestamp terminodesmontagem;

	private Timestamp terminoevento;

	private Timestamp terminomontagem;

	private String tipoorcamento;

	private BigDecimal total;

	private Timestamp validade;

	private BigDecimal valormargemglobal;

	@OneToMany(mappedBy="orcamento")
	private List<XUsuarioGerenteComissao> usuariosGerentesComissao;

	@OneToMany(mappedBy="orcamento")
	private List<XOrcamentoLancamentoAvulsoProgramacao> gorcamentolancamentoavulsoprogramacaos;

	@OneToMany(mappedBy="orcamento")
	private List<XContaPagar> contasPagar;

	@OneToMany(mappedBy="orcamento")
	private List<XContaPagarRateio> contaPagarRateios;

	@OneToMany(mappedBy="orcamento")
	private List<XContaReceber> contasReceber;

	@OneToMany(mappedBy="orcamento")
	private List<XNotaDebito> notasDebito;

	@OneToMany(mappedBy="orcamento")
	private List<XNotaDebitoOrcamentoPC> notasDebitoOrcamentoPC;

	@OneToMany(mappedBy="orcamento")
	private List<XNotaFiscal> notasFiscais;

	@ManyToOne
	@JoinColumn(name="areaid")
	private XAreaComercial areaComercial;

	@ManyToOne
	@JoinColumn(name="centrocustoid")
	private XCentroCusto centroCusto;

	@ManyToOne
	@JoinColumn(name="empresaid")
	private XEmpresa empresa;

	@ManyToOne
	@JoinColumn(name="localid")
	private XLocal local;

	@ManyToOne
	@JoinColumn(name="motivonaoaprovacaoid")
	private XMotivoNaoAprovacao motivoNaoAprovacao;

	@ManyToOne
	@JoinColumn(name="comissionadoid")
	private XPessoa comissionado;

	@ManyToOne
	@JoinColumn(name="pessoaid")
	private XPessoa pessoa;

	@ManyToOne
	@JoinColumn(name="produtoid")
	private XProduto produto;

	@ManyToOne
	@JoinColumn(name="regraimpostoid")
	private XRegraImposto regraImposto;

	@ManyToOne
	@JoinColumn(name="usuarioaprovacaoid")
	private XUsuario usuarioAprovacao;

	@ManyToOne
	@JoinColumn(name="usuariocoordenadorid")
	private XUsuario usuarioCoordenador;

	@ManyToOne
	@JoinColumn(name="usuarionaoaprovacaoid")
	private XUsuario usuarioNaoAprovacao;

	@ManyToOne
	@JoinColumn(name="assinaturaid")
	private XUsuario assinatura;

	@ManyToOne
	@JoinColumn(name="usuarioid")
	private XUsuario usuario;

	@ManyToOne
	@JoinColumn(name="formapagamentoid")
	private XCadastroFormaPagamento cadastrosFormaPagamento;

	@ManyToOne
	@JoinColumn(name="jobid")
	private XJob job;

	@OneToMany(mappedBy="orcamento")
	private List<XOrcamentoArquivo> orcamentosArquivo;

	@OneToMany(mappedBy="orcamento")
	private List<XOrcamentoAtividadeExtra> orcamentosAtividadeExtra;

	@OneToMany(mappedBy="orcamento")
	private List<XOrcamentoComissao> orcamentosComissao;

	@OneToMany(mappedBy="orcamento")
	private List<XOrcamentoConsumoHora> orcamentoConsumoHoras;

	@OneToMany(mappedBy="orcamento")
	private List<XOrcamentoEmailEnviado> orcamentoEmailsEnviados;

	@OneToMany(mappedBy="orcamento")
	private List<XOrcamentoItem> orcamentoItens;

	@OneToMany(mappedBy="orcamento")
	private List<XOrcamentoLayout> orcamentosLayout;

	@OneToMany(mappedBy="orcamento")
	private List<XOrcamentoPrevisaoDespesa> orcamentosPrevisaoDespesa;

	@OneToMany(mappedBy="orcamento")
	private List<XOrcamentoPrevisaoReceita> orcamentoPrevisaoReceitas;

	@OneToMany(mappedBy="orcamento")
	private List<XOrcamentoProgramacao> orcamentosProgramacao;

	@OneToMany(mappedBy="orcamento")
	private List<XOrcamentoPromotor> orcamentosPromotor;

	@OneToMany(mappedBy="orcamento")
	private List<XOrdemServico> ordemServicos;

	@OneToMany(mappedBy="orcamento")
	private List<XPesquisaSatisfacao> pesquisasSatisfacao;

	@OneToMany(mappedBy="orcamento")
	private List<XReclamacao> reclamacoes;

	@OneToMany(mappedBy="orcamento")
	private List<XReembolso> reembolsos;

	@OneToMany(mappedBy="orcamento")
	private List<XSolicitacaoOrcamento> solicitacoesOrcamento;

	@OneToMany(mappedBy="orcamento")
	private List<XTicketConsumo> ticketsConsumo;

	public XOrcamento() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getBasecalculoimposto() {
		return basecalculoimposto;
	}

	public void setBasecalculoimposto(BigDecimal basecalculoimposto) {
		this.basecalculoimposto = basecalculoimposto;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public BigDecimal getCofins() {
		return cofins;
	}

	public void setCofins(BigDecimal cofins) {
		this.cofins = cofins;
	}

	public BigDecimal getComissao() {
		return comissao;
	}

	public void setComissao(BigDecimal comissao) {
		this.comissao = comissao;
	}

	public BigDecimal getCtsocial() {
		return ctsocial;
	}

	public void setCtsocial(BigDecimal ctsocial) {
		this.ctsocial = ctsocial;
	}

	public Timestamp getData() {
		return data;
	}

	public void setData(Timestamp data) {
		this.data = data;
	}

	public Timestamp getDatacadastro() {
		return datacadastro;
	}

	public void setDatacadastro(Timestamp datacadastro) {
		this.datacadastro = datacadastro;
	}

	public Timestamp getDatahoraaprovacao() {
		return datahoraaprovacao;
	}

	public void setDatahoraaprovacao(Timestamp datahoraaprovacao) {
		this.datahoraaprovacao = datahoraaprovacao;
	}

	public Timestamp getDatanaoaprovacao() {
		return datanaoaprovacao;
	}

	public void setDatanaoaprovacao(Timestamp datanaoaprovacao) {
		this.datanaoaprovacao = datanaoaprovacao;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getDespesaestimada() {
		return despesaestimada;
	}

	public void setDespesaestimada(BigDecimal despesaestimada) {
		this.despesaestimada = despesaestimada;
	}

	public String getEnderecoarquivo() {
		return enderecoarquivo;
	}

	public void setEnderecoarquivo(String enderecoarquivo) {
		this.enderecoarquivo = enderecoarquivo;
	}

	public BigDecimal getEstalo() {
		return estalo;
	}

	public void setEstalo(BigDecimal estalo) {
		this.estalo = estalo;
	}

	public String getHistorico() {
		return historico;
	}

	public void setHistorico(String historico) {
		this.historico = historico;
	}

	public Timestamp getHorarioevento() {
		return horarioevento;
	}

	public void setHorarioevento(Timestamp horarioevento) {
		this.horarioevento = horarioevento;
	}

	public BigDecimal getImpostos() {
		return impostos;
	}

	public void setImpostos(BigDecimal impostos) {
		this.impostos = impostos;
	}

	public Timestamp getIniciodesmontagem() {
		return iniciodesmontagem;
	}

	public void setIniciodesmontagem(Timestamp iniciodesmontagem) {
		this.iniciodesmontagem = iniciodesmontagem;
	}

	public Timestamp getInicioevento() {
		return inicioevento;
	}

	public void setInicioevento(Timestamp inicioevento) {
		this.inicioevento = inicioevento;
	}

	public Timestamp getIniciomontagem() {
		return iniciomontagem;
	}

	public void setIniciomontagem(Timestamp iniciomontagem) {
		this.iniciomontagem = iniciomontagem;
	}

	public BigDecimal getInss() {
		return inss;
	}

	public void setInss(BigDecimal inss) {
		this.inss = inss;
	}

	public BigDecimal getIrpj() {
		return irpj;
	}

	public void setIrpj(BigDecimal irpj) {
		this.irpj = irpj;
	}

	public String getJustificativanaoaprovacao() {
		return justificativanaoaprovacao;
	}

	public void setJustificativanaoaprovacao(String justificativanaoaprovacao) {
		this.justificativanaoaprovacao = justificativanaoaprovacao;
	}

	public String getLocalevento() {
		return localevento;
	}

	public void setLocalevento(String localevento) {
		this.localevento = localevento;
	}

	public String getNomeevento() {
		return nomeevento;
	}

	public void setNomeevento(String nomeevento) {
		this.nomeevento = nomeevento;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getObstecnica() {
		return obstecnica;
	}

	public void setObstecnica(String obstecnica) {
		this.obstecnica = obstecnica;
	}

	public BigDecimal getPercentualmargemglobal() {
		return percentualmargemglobal;
	}

	public void setPercentualmargemglobal(BigDecimal percentualmargemglobal) {
		this.percentualmargemglobal = percentualmargemglobal;
	}

	public BigDecimal getPercentualremuneracao() {
		return percentualremuneracao;
	}

	public void setPercentualremuneracao(BigDecimal percentualremuneracao) {
		this.percentualremuneracao = percentualremuneracao;
	}

	public BigDecimal getPis() {
		return pis;
	}

	public void setPis(BigDecimal pis) {
		this.pis = pis;
	}

	public Integer getPublicoestimado() {
		return publicoestimado;
	}

	public void setPublicoestimado(Integer publicoestimado) {
		this.publicoestimado = publicoestimado;
	}

	public BigDecimal getReceitaestimada() {
		return receitaestimada;
	}

	public void setReceitaestimada(BigDecimal receitaestimada) {
		this.receitaestimada = receitaestimada;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public Timestamp getReferenciafinanceira() {
		return referenciafinanceira;
	}

	public void setReferenciafinanceira(Timestamp referenciafinanceira) {
		this.referenciafinanceira = referenciafinanceira;
	}

	public BigDecimal getRemuneracao() {
		return remuneracao;
	}

	public void setRemuneracao(BigDecimal remuneracao) {
		this.remuneracao = remuneracao;
	}

	public BigDecimal getResultadoestimada() {
		return resultadoestimada;
	}

	public void setResultadoestimada(BigDecimal resultadoestimada) {
		this.resultadoestimada = resultadoestimada;
	}

	public Integer getRevisao() {
		return revisao;
	}

	public void setRevisao(Integer revisao) {
		this.revisao = revisao;
	}

	public BigDecimal getSimples() {
		return simples;
	}

	public void setSimples(BigDecimal simples) {
		this.simples = simples;
	}

	public BigDecimal getSs() {
		return ss;
	}

	public void setSs(BigDecimal ss) {
		this.ss = ss;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public Timestamp getTerminodesmontagem() {
		return terminodesmontagem;
	}

	public void setTerminodesmontagem(Timestamp terminodesmontagem) {
		this.terminodesmontagem = terminodesmontagem;
	}

	public Timestamp getTerminoevento() {
		return terminoevento;
	}

	public void setTerminoevento(Timestamp terminoevento) {
		this.terminoevento = terminoevento;
	}

	public Timestamp getTerminomontagem() {
		return terminomontagem;
	}

	public void setTerminomontagem(Timestamp terminomontagem) {
		this.terminomontagem = terminomontagem;
	}

	public String getTipoorcamento() {
		return tipoorcamento;
	}

	public void setTipoorcamento(String tipoorcamento) {
		this.tipoorcamento = tipoorcamento;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public Timestamp getValidade() {
		return validade;
	}

	public void setValidade(Timestamp validade) {
		this.validade = validade;
	}

	public BigDecimal getValormargemglobal() {
		return valormargemglobal;
	}

	public void setValormargemglobal(BigDecimal valormargemglobal) {
		this.valormargemglobal = valormargemglobal;
	}

	public List<XUsuarioGerenteComissao> getUsuariosGerentesComissao() {
		return usuariosGerentesComissao;
	}

	public void setUsuariosGerentesComissao(List<XUsuarioGerenteComissao> usuariosGerentesComissao) {
		this.usuariosGerentesComissao = usuariosGerentesComissao;
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

	public List<XNotaDebito> getNotasDebito() {
		return notasDebito;
	}

	public void setNotasDebito(List<XNotaDebito> notasDebito) {
		this.notasDebito = notasDebito;
	}

	public List<XNotaDebitoOrcamentoPC> getNotasDebitoOrcamentoPC() {
		return notasDebitoOrcamentoPC;
	}

	public void setNotasDebitoOrcamentoPC(List<XNotaDebitoOrcamentoPC> notasDebitoOrcamentoPC) {
		this.notasDebitoOrcamentoPC = notasDebitoOrcamentoPC;
	}

	public List<XNotaFiscal> getNotasFiscais() {
		return notasFiscais;
	}

	public void setNotasFiscais(List<XNotaFiscal> notasFiscais) {
		this.notasFiscais = notasFiscais;
	}

	public XAreaComercial getAreaComercial() {
		return areaComercial;
	}

	public void setAreaComercial(XAreaComercial areaComercial) {
		this.areaComercial = areaComercial;
	}

	public XCentroCusto getCentroCusto() {
		return centroCusto;
	}

	public void setCentroCusto(XCentroCusto centroCusto) {
		this.centroCusto = centroCusto;
	}

	public XEmpresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(XEmpresa empresa) {
		this.empresa = empresa;
	}

	public XLocal getLocal() {
		return local;
	}

	public void setLocal(XLocal local) {
		this.local = local;
	}

	public XMotivoNaoAprovacao getMotivoNaoAprovacao() {
		return motivoNaoAprovacao;
	}

	public void setMotivoNaoAprovacao(XMotivoNaoAprovacao motivoNaoAprovacao) {
		this.motivoNaoAprovacao = motivoNaoAprovacao;
	}

	public XPessoa getComissionado() {
		return comissionado;
	}

	public void setComissionado(XPessoa comissionado) {
		this.comissionado = comissionado;
	}

	public XPessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(XPessoa pessoa) {
		this.pessoa = pessoa;
	}

	public XProduto getProduto() {
		return produto;
	}

	public void setProduto(XProduto produto) {
		this.produto = produto;
	}

	public XRegraImposto getRegraImposto() {
		return regraImposto;
	}

	public void setRegraImposto(XRegraImposto regraImposto) {
		this.regraImposto = regraImposto;
	}

	public XUsuario getUsuarioAprovacao() {
		return usuarioAprovacao;
	}

	public void setUsuarioAprovacao(XUsuario usuarioAprovacao) {
		this.usuarioAprovacao = usuarioAprovacao;
	}

	public XUsuario getUsuarioCoordenador() {
		return usuarioCoordenador;
	}

	public void setUsuarioCoordenador(XUsuario usuarioCoordenador) {
		this.usuarioCoordenador = usuarioCoordenador;
	}

	public XUsuario getUsuarioNaoAprovacao() {
		return usuarioNaoAprovacao;
	}

	public void setUsuarioNaoAprovacao(XUsuario usuarioNaoAprovacao) {
		this.usuarioNaoAprovacao = usuarioNaoAprovacao;
	}

	public XUsuario getAssinatura() {
		return assinatura;
	}

	public void setAssinatura(XUsuario assinatura) {
		this.assinatura = assinatura;
	}

	public XUsuario getUsuario() {
		return usuario;
	}

	public void setUsuario(XUsuario usuario) {
		this.usuario = usuario;
	}

	public XCadastroFormaPagamento getCadastrosFormaPagamento() {
		return cadastrosFormaPagamento;
	}

	public void setCadastrosFormaPagamento(XCadastroFormaPagamento cadastrosFormaPagamento) {
		this.cadastrosFormaPagamento = cadastrosFormaPagamento;
	}

	public List<XOrcamentoLancamentoAvulsoProgramacao> getGorcamentolancamentoavulsoprogramacaos() {
		return gorcamentolancamentoavulsoprogramacaos;
	}

	public void setGorcamentolancamentoavulsoprogramacaos(
			List<XOrcamentoLancamentoAvulsoProgramacao> gorcamentolancamentoavulsoprogramacaos) {
		this.gorcamentolancamentoavulsoprogramacaos = gorcamentolancamentoavulsoprogramacaos;
	}

	public XJob getJob() {
		return job;
	}

	public void setJob(XJob job) {
		this.job = job;
	}

	public List<XReembolso> getReembolsos() {
		return reembolsos;
	}

	public List<XOrcamentoArquivo> getOrcamentosArquivo() {
		return orcamentosArquivo;
	}

	public void setOrcamentosArquivo(List<XOrcamentoArquivo> orcamentosArquivo) {
		this.orcamentosArquivo = orcamentosArquivo;
	}

	public List<XOrcamentoAtividadeExtra> getOrcamentosAtividadeExtra() {
		return orcamentosAtividadeExtra;
	}

	public void setOrcamentosAtividadeExtra(List<XOrcamentoAtividadeExtra> orcamentosAtividadeExtra) {
		this.orcamentosAtividadeExtra = orcamentosAtividadeExtra;
	}

	public List<XOrcamentoComissao> getOrcamentosComissao() {
		return orcamentosComissao;
	}

	public void setOrcamentosComissao(List<XOrcamentoComissao> orcamentosComissao) {
		this.orcamentosComissao = orcamentosComissao;
	}

	public List<XOrcamentoConsumoHora> getOrcamentoConsumoHoras() {
		return orcamentoConsumoHoras;
	}

	public void setOrcamentoConsumoHoras(List<XOrcamentoConsumoHora> orcamentoConsumoHoras) {
		this.orcamentoConsumoHoras = orcamentoConsumoHoras;
	}

	public List<XOrcamentoEmailEnviado> getOrcamentoEmailsEnviados() {
		return orcamentoEmailsEnviados;
	}

	public void setOrcamentoEmailsEnviados(List<XOrcamentoEmailEnviado> orcamentoEmailsEnviados) {
		this.orcamentoEmailsEnviados = orcamentoEmailsEnviados;
	}

	public List<XOrcamentoItem> getOrcamentoItens() {
		return orcamentoItens;
	}

	public void setOrcamentoItens(List<XOrcamentoItem> orcamentoItens) {
		this.orcamentoItens = orcamentoItens;
	}

	public List<XOrcamentoLayout> getOrcamentosLayout() {
		return orcamentosLayout;
	}

	public void setOrcamentosLayout(List<XOrcamentoLayout> orcamentosLayout) {
		this.orcamentosLayout = orcamentosLayout;
	}

	public List<XOrcamentoPrevisaoDespesa> getOrcamentosPrevisaoDespesa() {
		return orcamentosPrevisaoDespesa;
	}

	public void setOrcamentosPrevisaoDespesa(List<XOrcamentoPrevisaoDespesa> orcamentosPrevisaoDespesa) {
		this.orcamentosPrevisaoDespesa = orcamentosPrevisaoDespesa;
	}

	public List<XOrcamentoPrevisaoReceita> getOrcamentoPrevisaoReceitas() {
		return orcamentoPrevisaoReceitas;
	}

	public void setOrcamentoPrevisaoReceitas(List<XOrcamentoPrevisaoReceita> orcamentoPrevisaoReceitas) {
		this.orcamentoPrevisaoReceitas = orcamentoPrevisaoReceitas;
	}

	public List<XOrcamentoProgramacao> getOrcamentosProgramacao() {
		return orcamentosProgramacao;
	}

	public void setOrcamentosProgramacao(List<XOrcamentoProgramacao> orcamentosProgramacao) {
		this.orcamentosProgramacao = orcamentosProgramacao;
	}

	public List<XOrcamentoPromotor> getOrcamentosPromotor() {
		return orcamentosPromotor;
	}

	public void setOrcamentosPromotor(List<XOrcamentoPromotor> orcamentosPromotor) {
		this.orcamentosPromotor = orcamentosPromotor;
	}

	public List<XOrdemServico> getOrdemServicos() {
		return ordemServicos;
	}

	public void setOrdemServicos(List<XOrdemServico> ordemServicos) {
		this.ordemServicos = ordemServicos;
	}

	public List<XPesquisaSatisfacao> getPesquisasSatisfacao() {
		return pesquisasSatisfacao;
	}

	public void setPesquisasSatisfacao(List<XPesquisaSatisfacao> pesquisasSatisfacao) {
		this.pesquisasSatisfacao = pesquisasSatisfacao;
	}

	public List<XReclamacao> getReclamacoes() {
		return reclamacoes;
	}

	public void setReclamacoes(List<XReclamacao> reclamacoes) {
		this.reclamacoes = reclamacoes;
	}

	public void setReembolsos(List<XReembolso> reembolsos) {
		this.reembolsos = reembolsos;
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