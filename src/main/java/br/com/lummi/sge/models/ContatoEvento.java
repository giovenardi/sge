package br.com.lummi.sge.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.lummi.sge.enums.NivelEnum;
import br.com.lummi.sge.enums.SemestreEnum;
import br.com.lummi.sge.enums.StatusEventoEnum;
import br.com.lummi.sge.enums.TipoIndicacaoEnum;
import br.com.lummi.sge.enums.TipoProjetoEnum;

/**
 * The persistent class for the contato_evento database table.
 * 
 */
@Entity
@Table(name = "contato_evento")
public class ContatoEvento implements Entidade {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "contato_evento_id_seq", sequenceName = "contato_evento_id_seq", allocationSize = 1)
	@GeneratedValue(generator = "contato_evento_id_seq")
	private Integer id;

	private String celular;

	@ManyToOne
	@JoinColumn(name = "curso_id")
	private Curso curso;

	private String email;

	@ManyToOne
	@JoinColumn(name = "forma_captacao_id")
	private FormaCaptacao formaCaptacao;

	@Column(name = "houve_indicacao")
	private boolean houveIndicacao;

	@ManyToOne
	@JoinColumn(name = "unidade_instituicao_id")
	private UnidadeInstituicao unidadeInstituicao;

	@Column(name = "modo_descoberta")
	private String modoDescoberta;

	@Column(name = "nome")
	private String nome;

	@Column(name = "nome_projeto")
	private String nomeProjeto;

	@Column(name = "semestre")
	@Enumerated(EnumType.ORDINAL)
	private SemestreEnum semestre;

	@Column(name = "ano")
	private Integer ano;

	@Column(name = "telefone")
	private String telefone;

	@Column(name = "numero_turma")
	private Integer numeroTurma;

	@ManyToOne
	@JoinColumn(name = "turno_id")
	private Turno turno;

	@Column(name = "tipo_indicacao")
	@Enumerated(EnumType.STRING)
	private TipoIndicacaoEnum tipoIndicacao;

	@Column(name = "tipo_projeto")
	@Enumerated(EnumType.STRING)
	private TipoProjetoEnum tipoProjeto;

	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private StatusEventoEnum status;

	@Column(name = "observacao")
	private String observacao;

	@Column(name = "nivel")
	@Enumerated(EnumType.STRING)
	private NivelEnum nivel;

	@ManyToOne
	@JoinColumn(name = "projeto_bonificacao_id")
	private Projeto projetoBonificacao;

	@ManyToOne
	@JoinColumn(name = "primeiro_contato_id")
	private Usuario primeiroContato;

	@ManyToOne
	@JoinColumn(name = "captador_bonificacao_id")
	private CaptadorExterno captadorBonificacao;

	@ManyToOne
	@JoinColumn(name = "funcionario_bonificacao_id")
	private Funcionario funcionarioBonificacao;

	@ManyToOne
	@JoinColumn(name = "funcionario_comissao_id")
	private Funcionario funcionarioComissao;

	@Transient
	private Funcionario gerente;

	@ManyToOne
	@JoinColumn(name = "vendedor_id")
	private Funcionario vendedor;

	public ContatoEvento() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCelular() {
		return this.celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean getHouveIndicacao() {
		return this.houveIndicacao;
	}

	public void setHouveIndicacao(boolean houveIndicacao) {
		this.houveIndicacao = houveIndicacao;
	}

	public String getModoDescoberta() {
		return this.modoDescoberta;
	}

	public void setModoDescoberta(String modoDescoberta) {
		this.modoDescoberta = modoDescoberta;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public FormaCaptacao getFormaCaptacao() {
		return formaCaptacao;
	}

	public void setFormaCaptacao(FormaCaptacao formaCaptacao) {
		this.formaCaptacao = formaCaptacao;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public TipoIndicacaoEnum getTipoIndicacao() {
		return this.tipoIndicacao;
	}

	public void setTipoIndicacao(TipoIndicacaoEnum tipoIndicacao) {
		this.tipoIndicacao = tipoIndicacao;
	}

	public TipoProjetoEnum getTipoProjeto() {
		return tipoProjeto;
	}

	public void setTipoProjeto(TipoProjetoEnum tipoProjeto) {
		this.tipoProjeto = tipoProjeto;
	}

	public SemestreEnum getSemestre() {
		return semestre;
	}

	public void setSemestre(SemestreEnum semestre) {
		this.semestre = semestre;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public StatusEventoEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEventoEnum status) {
		this.status = status;
	}

	public Projeto getProjetoBonificacao() {
		return projetoBonificacao;
	}

	public void setProjetoBonificacao(Projeto projetoBonificacao) {
		this.projetoBonificacao = projetoBonificacao;
	}

	public CaptadorExterno getCaptadorBonificacao() {
		return captadorBonificacao;
	}

	public void setCaptadorBonificacao(CaptadorExterno captadorBonificacao) {
		this.captadorBonificacao = captadorBonificacao;
	}

	public Funcionario getFuncionarioBonificacao() {
		return funcionarioBonificacao;
	}

	public void setFuncionarioBonificacao(Funcionario funcionarioBonificacao) {
		this.funcionarioBonificacao = funcionarioBonificacao;
	}

	public Funcionario getFuncionarioComissao() {
		return funcionarioComissao;
	}

	public void setFuncionarioComissao(Funcionario funcionarioComissao) {
		this.funcionarioComissao = funcionarioComissao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getNomeProjeto() {
		return nomeProjeto;
	}

	public void setNomeProjeto(String nomeProjeto) {
		this.nomeProjeto = nomeProjeto;
	}

	public Usuario getPrimeiroContato() {
		return primeiroContato;
	}

	public void setPrimeiroContato(Usuario primeiroContato) {
		this.primeiroContato = primeiroContato;
	}

	public Funcionario getVendedor() {
		return vendedor;
	}

	public void setVendedor(Funcionario vendedor) {
		this.vendedor = vendedor;
	}

	public Funcionario getGerente() {
		return gerente;
	}

	public void setGerente(Funcionario gerente) {
		this.gerente = gerente;
	}

	public UnidadeInstituicao getUnidadeInstituicao() {
		return unidadeInstituicao;
	}

	public void setUnidadeInstituicao(UnidadeInstituicao unidadeInstituicao) {
		this.unidadeInstituicao = unidadeInstituicao;
	}

	public Integer getNumeroTurma() {
		return numeroTurma;
	}

	public void setNumeroTurma(Integer numeroTurma) {
		this.numeroTurma = numeroTurma;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public NivelEnum getNivel() {
		return nivel;
	}

	public void setNivel(NivelEnum nivel) {
		this.nivel = nivel;
	}

}