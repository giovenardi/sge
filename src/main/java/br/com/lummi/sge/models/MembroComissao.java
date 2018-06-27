package br.com.lummi.sge.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="membro_comissao")
public class MembroComissao implements Entidade {

	private static final long serialVersionUID = 8417530984349315559L;

	@Id
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="comissao_formatura_id")
	private ComissaoFormatura comissaoFormatura;
	
	@Column(name="nome", length=100)
	private String nome;
	
	@Column(name="funcao_comissao_id")
	private FuncaoComissao funcao;
	
	@Column(name="email_principal", length=80)
	private String emailPrincipal;
	
	@Column(name="email_secundario", length=80)
	private String emailSecundario;
	
	@Column(name="telefone_fixo", length=15)
	private String telefoneFixo;
	
	@Column(name="celular_principal", length=15)
	private String celularPrincipal;
	
	@Column(name="celular_secundario", length=15)
	private String celularSecundario;

}
