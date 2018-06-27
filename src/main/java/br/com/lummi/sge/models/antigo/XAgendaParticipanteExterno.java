package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the magendaparticipanteexterno database table.
 * 
 */
@Entity
@Table(name="magendaparticipanteexterno")
public class XAgendaParticipanteExterno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String email;

	private String nome;

	private String telefone;

	@ManyToOne
	@JoinColumn(name="agendaid")
	private XAgenda agenda;

	public XAgendaParticipanteExterno() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public XAgenda getAgenda() {
		return agenda;
	}

	public void setAgenda(XAgenda agenda) {
		this.agenda = agenda;
	}

}