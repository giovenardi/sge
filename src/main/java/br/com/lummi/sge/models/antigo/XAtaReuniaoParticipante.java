package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the matareuniaoparticipante database table.
 * 
 */
@Entity
@Table(name="matareuniaoparticipante")
public class XAtaReuniaoParticipante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String item;

	private String presenca;

	@ManyToOne
	@JoinColumn(name="alunoid")
	private XPessoa aluno;

	@ManyToOne
	@JoinColumn(name="atareuniaoid")
	private XAtaReuniao ataReuniao;

	public XAtaReuniaoParticipante() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getPresenca() {
		return presenca;
	}

	public void setPresenca(String presenca) {
		this.presenca = presenca;
	}

	public XPessoa getAluno() {
		return aluno;
	}

	public void setAluno(XPessoa aluno) {
		this.aluno = aluno;
	}

	public XAtaReuniao getAtaReuniao() {
		return ataReuniao;
	}

	public void setAtaReuniao(XAtaReuniao ataReuniao) {
		this.ataReuniao = ataReuniao;
	}

}