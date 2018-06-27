package br.com.lummi.sge.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="atendimento_comercial")
public class AtendimentoComercial implements Serializable {

	private static final long serialVersionUID = -2613605003168426912L;
	
	@Id
	private Integer id;
	
	@Column(name="ata")
	private String ata;

	@ManyToOne
	@JoinColumn(name="projeto_id")
	private Projeto projeto;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAta() {
		return ata;
	}

	public void setAta(String ata) {
		this.ata = ata;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}
	
	
}
