package br.com.lummi.sge.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

import br.com.lummi.sge.enums.EstadoCivilEnum;
import br.com.lummi.sge.enums.SexoEnum;

/**
 * The persistent class for the cpessoa database table.
 * 
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("PF")
public class PessoaFisica extends Pessoa {
	private static final long serialVersionUID = 1L;

	@Column(name = "cpf")
	private String cpf;

	@Column(name = "rg")
	private String rg;

	@Column(name = "titulo_eleitor")
	private String tituloEleitor;

	@Column(name = "orgao_expedidor_rg")
	private String orgaoExpedidorRG;

	@Column(name = "sexo")
	@Enumerated(EnumType.STRING)
	private SexoEnum sexo;

	@Column(name = "data_nascimento")
	private Date dataNascimento;

	@Column(name = "estado_civil")
	@Enumerated(EnumType.STRING)
	private EstadoCivilEnum estadoCivil;

	@Column(name = "nome_mae")
	private String nomeMae;

	@Column(name = "nome_pai")
	private String nomePai;

	@Column(name = "foto")
	private byte[] foto;

	@OneToOne(targetEntity = Funcionario.class, mappedBy = "pessoa", optional = true, fetch = FetchType.LAZY)
	private Funcionario funcionario;

	@OneToOne(targetEntity = CaptadorExterno.class, mappedBy = "pessoa", optional = true)
	private CaptadorExterno captadorExterno;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getTituloEleitor() {
		return tituloEleitor;
	}

	public void setTituloEleitor(String tituloEleitor) {
		this.tituloEleitor = tituloEleitor;
	}

	public String getOrgaoExpedidorRG() {
		return orgaoExpedidorRG;
	}

	public void setOrgaoExpedidorRG(String orgaoExpedidorRG) {
		this.orgaoExpedidorRG = orgaoExpedidorRG;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public EstadoCivilEnum getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivilEnum estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public SexoEnum getSexo() {
		return sexo;
	}

	public void setSexo(SexoEnum sexo) {
		this.sexo = sexo;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public CaptadorExterno getCaptadorExterno() {
		return captadorExterno;
	}

	public void setCaptadorExterno(CaptadorExterno captadorExterno) {
		this.captadorExterno = captadorExterno;
	}

}