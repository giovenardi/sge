package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the citemorcamento database table.
 * 
 */
@Entity
@Table(name="citemorcamento")
public class XItemOrcamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String categoria;

	private String codigo;

	private String descricao;

	private Boolean ehativo;

	private Boolean ehrecursohumano;

	private String nome;

	private BigDecimal precoreferencia;

	private Integer referenciaid;

	@ManyToOne
	@JoinColumn(name="grupoitemorcamentoid")
	private XGrupoItemOrcamento grupoItemOrcamento;

	@OneToMany(mappedBy="itemOrcamento")
	private List<XPessoaItem> pessoasItens;

	@OneToMany(mappedBy="itemOrcamento")
	private List<XPessoaPrecoItem> pessoasPrecoItens;

	@OneToMany(mappedBy="itemOrcamento")
	private List<XContaPagarRateio> contasPagarRateios;

	@OneToMany(mappedBy="itemOrcamento")
	private List<XOrcamentoItem> orcamentoItens;

	@OneToMany(mappedBy="itemOrcamento")
	private List<XOrcamentoPrevisaoDespesa> orcamentosPrevisaoDespesas;

	@OneToMany(mappedBy="itemOrcamento")
	private List<XOrcamentoPrevisaoReceita> orcamentosPrevisaoReceitas;

	@OneToMany(mappedBy="itemOrcamento")
	private List<XOrdemServicoItem> ordemServicoItens;

	@OneToMany(mappedBy="itemOrcamento")
	private List<XProjetoItem> projetosItem;

	@OneToMany(mappedBy="itemOrcamento")
	private List<XSolicitacaoOrcamentoItem> solicitacoesOrcamentoItens;

	public XItemOrcamento() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategoria() {
		return this.categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getEhativo() {
		return this.ehativo;
	}

	public void setEhativo(Boolean ehativo) {
		this.ehativo = ehativo;
	}

	public Boolean getEhrecursohumano() {
		return this.ehrecursohumano;
	}

	public void setEhrecursohumano(Boolean ehrecursohumano) {
		this.ehrecursohumano = ehrecursohumano;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPrecoreferencia() {
		return this.precoreferencia;
	}

	public void setPrecoreferencia(BigDecimal precoreferencia) {
		this.precoreferencia = precoreferencia;
	}

	public Integer getReferenciaid() {
		return this.referenciaid;
	}

	public void setReferenciaid(Integer referenciaid) {
		this.referenciaid = referenciaid;
	}

	public XGrupoItemOrcamento getGrupoItemOrcamento() {
		return this.grupoItemOrcamento;
	}

	public List<XPessoaItem> getPessoasItens() {
		return pessoasItens;
	}

	public void setPessoasItens(List<XPessoaItem> pessoasItens) {
		this.pessoasItens = pessoasItens;
	}

	public List<XPessoaPrecoItem> getPessoasPrecoItens() {
		return pessoasPrecoItens;
	}

	public void setPessoasPrecoItens(List<XPessoaPrecoItem> pessoasPrecoItens) {
		this.pessoasPrecoItens = pessoasPrecoItens;
	}

	public List<XContaPagarRateio> getContasPagarRateios() {
		return contasPagarRateios;
	}

	public void setContasPagarRateios(List<XContaPagarRateio> contasPagarRateios) {
		this.contasPagarRateios = contasPagarRateios;
	}

	public List<XOrcamentoItem> getOrcamentoItens() {
		return orcamentoItens;
	}

	public void setOrcamentoItens(List<XOrcamentoItem> orcamentoItens) {
		this.orcamentoItens = orcamentoItens;
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

	public List<XOrdemServicoItem> getOrdemServicoItens() {
		return ordemServicoItens;
	}

	public void setOrdemServicoItens(List<XOrdemServicoItem> ordemServicoItens) {
		this.ordemServicoItens = ordemServicoItens;
	}

	public List<XProjetoItem> getProjetosItem() {
		return projetosItem;
	}

	public void setProjetosItem(List<XProjetoItem> projetosItem) {
		this.projetosItem = projetosItem;
	}

	public List<XSolicitacaoOrcamentoItem> getSolicitacoesOrcamentoItens() {
		return solicitacoesOrcamentoItens;
	}

	public void setSolicitacoesOrcamentoItens(List<XSolicitacaoOrcamentoItem> solicitacoesOrcamentoItens) {
		this.solicitacoesOrcamentoItens = solicitacoesOrcamentoItens;
	}

	public void setGrupoItemOrcamento(XGrupoItemOrcamento grupoItemOrcamento) {
		this.grupoItemOrcamento = grupoItemOrcamento;
	}

}