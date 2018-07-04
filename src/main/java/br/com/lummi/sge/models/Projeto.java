package br.com.lummi.sge.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.lummi.sge.enums.StatusProjetoEnum;
import br.com.lummi.sge.enums.TipoProjetoEnum;

/**
 * The persistent class for the mprojeto database table.
 * 
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
@Table(name = "projeto")
public class Projeto implements Entidade {

	private static final long serialVersionUID = -5699589916469378250L;

	@Id
	@SequenceGenerator(name = "projeto_id_seq", sequenceName = "projeto_id_seq", allocationSize = 1)
	@GeneratedValue(generator = "projeto_id_seq")
	private Integer id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "tipo", updatable = false, insertable = false)
	@Enumerated(EnumType.STRING)
	private TipoProjetoEnum tipo;

	@Column(name = "data_criacao")
	@Temporal(TemporalType.DATE)
	private Date dataAtivacao;

	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private StatusProjetoEnum status;

	@Column(name = "taxa_administrativa")
	private Double taxaAdministrativa;

	@ManyToOne
	@JoinColumn(name = "contato_evento_id")
	private ContatoEvento contatoEvento;

	@ManyToOne
	@JoinColumn(name = "gerente_id")
	private Funcionario gerente;

	@OneToOne(targetEntity = Cerimonial.class, mappedBy = "projeto")
	private Cerimonial cerimonial;

	@OneToMany(mappedBy = "projeto")
	private List<AtendimentoComercial> atendimentos;

	@OneToMany(targetEntity = PlanoPagamento.class, mappedBy = "projeto")
	private List<PlanoPagamento> planosPagamento;

	@OneToMany(targetEntity = ProgramacaoFinanceiraProjeto.class, mappedBy = "projeto")
	private List<ProgramacaoFinanceiraProjeto> programacoesFinanceiras;

	@OneToMany(targetEntity = ProjetoEvento.class, mappedBy = "projeto")
	@OrderBy("inicio ASC")
	private List<ProjetoEvento> eventos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoProjetoEnum getTipo() {
		return tipo;
	}

	public void setTipo(TipoProjetoEnum tipo) {
		this.tipo = tipo;
	}

	public Date getDataAtivacao() {
		return dataAtivacao;
	}

	public void setDataAtivacao(Date dataAtivacao) {
		this.dataAtivacao = dataAtivacao;
	}

	public StatusProjetoEnum getStatus() {
		return status;
	}

	public void setStatus(StatusProjetoEnum status) {
		this.status = status;
	}

	public ContatoEvento getContatoEvento() {
		return contatoEvento;
	}

	public void setContatoEvento(ContatoEvento contatoEvento) {
		this.contatoEvento = contatoEvento;
	}

	public List<AtendimentoComercial> getAtendimentos() {
		return atendimentos;
	}

	public void setAtendimentos(List<AtendimentoComercial> atendimentos) {
		this.atendimentos = atendimentos;
	}

	public Funcionario getGerente() {
		return gerente;
	}

	public void setGerente(Funcionario gerente) {
		this.gerente = gerente;
	}

	public List<PlanoPagamento> getPlanosPagamento() {
		return planosPagamento;
	}

	public void setPlanosPagamento(List<PlanoPagamento> planosPagamento) {
		this.planosPagamento = planosPagamento;
	}

	public List<ProgramacaoFinanceiraProjeto> getProgramacoesFinanceiras() {
		return programacoesFinanceiras;
	}

	public void setProgramacoesFinanceiras(List<ProgramacaoFinanceiraProjeto> programacoesFinanceiras) {
		this.programacoesFinanceiras = programacoesFinanceiras;
	}

	public Cerimonial getCerimonial() {
		return cerimonial;
	}

	public void setCerimonial(Cerimonial cerimonial) {
		this.cerimonial = cerimonial;
	}

	public Double getTaxaAdministrativa() {
		return taxaAdministrativa;
	}

	public void setTaxaAdministrativa(Double taxaAdministrativa) {
		this.taxaAdministrativa = taxaAdministrativa;
	}

	public List<ProjetoEvento> getEventos() {
		return eventos;
	}

	public void setEventos(List<ProjetoEvento> eventos) {
		this.eventos = eventos;
	}

}