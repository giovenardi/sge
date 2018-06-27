package br.com.lummi.sge.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "membro_comissao")
public class MembroComissao implements Entidade {

	private static final long serialVersionUID = 8417530984349315559L;

	@Id
	@SequenceGenerator(name = "membro_comissao_id_seq", sequenceName = "membro_comissao_id_seq", allocationSize = 1)
	@GeneratedValue(generator = "membro_comissao_id_seq")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "comissao_formatura_id")
	private ComissaoFormatura comissaoFormatura;

	@ManyToOne(optional = false)
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;

	@ManyToOne
	@JoinColumn(name = "funcao_comissao_id")
	private FuncaoComissao funcao;

	@Column(name = "email_principal", length = 80)
	private String emailPrincipal;

	@Column(name = "email_secundario", length = 80)
	private String emailSecundario;

	@Column(name = "telefone_fixo", length = 15)
	private String telefoneFixo;

	@Column(name = "celular_principal", length = 15)
	private String celularPrincipal;

	@Column(name = "celular_secundario", length = 15)
	private String celularSecundario;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ComissaoFormatura getComissaoFormatura() {
		return comissaoFormatura;
	}

	public void setComissaoFormatura(ComissaoFormatura comissaoFormatura) {
		this.comissaoFormatura = comissaoFormatura;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public FuncaoComissao getFuncao() {
		return funcao;
	}

	public void setFuncao(FuncaoComissao funcao) {
		this.funcao = funcao;
	}

	public String getEmailPrincipal() {
		return emailPrincipal;
	}

	public void setEmailPrincipal(String emailPrincipal) {
		this.emailPrincipal = emailPrincipal;
	}

	public String getEmailSecundario() {
		return emailSecundario;
	}

	public void setEmailSecundario(String emailSecundario) {
		this.emailSecundario = emailSecundario;
	}

	public String getTelefoneFixo() {
		return telefoneFixo;
	}

	public void setTelefoneFixo(String telefoneFixo) {
		this.telefoneFixo = telefoneFixo;
	}

	public String getCelularPrincipal() {
		return celularPrincipal;
	}

	public void setCelularPrincipal(String celularPrincipal) {
		this.celularPrincipal = celularPrincipal;
	}

	public String getCelularSecundario() {
		return celularSecundario;
	}

	public void setCelularSecundario(String celularSecundario) {
		this.celularSecundario = celularSecundario;
	}

}
