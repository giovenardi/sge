package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the mprojetoeventos database table.
 * 
 */
@Entity
@Table(name="mprojetoeventos")
public class XProjetoEvento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Timestamp datahoraalteracao;

	private Time horainicio;

	private Time horatermino;

	private Timestamp inicio;

	private String item;

	private Timestamp termino;

	@ManyToOne
	@JoinColumn(name="eventoid")
	private XEvento evento;

	@ManyToOne
	@JoinColumn(name="usuarioalteracaoid")
	private XUsuario usuario;

	@ManyToOne
	@JoinColumn(name="projetoid")
	private XProjeto projeto;

	@OneToMany(mappedBy="projetoEvento")
	private List<XProjetoItem> projetoItens;

	public XProjetoEvento() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getDatahoraalteracao() {
		return this.datahoraalteracao;
	}

	public void setDatahoraalteracao(Timestamp datahoraalteracao) {
		this.datahoraalteracao = datahoraalteracao;
	}

	public Time getHorainicio() {
		return this.horainicio;
	}

	public void setHorainicio(Time horainicio) {
		this.horainicio = horainicio;
	}

	public Time getHoratermino() {
		return this.horatermino;
	}

	public void setHoratermino(Time horatermino) {
		this.horatermino = horatermino;
	}

	public Timestamp getInicio() {
		return this.inicio;
	}

	public void setInicio(Timestamp inicio) {
		this.inicio = inicio;
	}

	public String getItem() {
		return this.item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Timestamp getTermino() {
		return this.termino;
	}

	public void setTermino(Timestamp termino) {
		this.termino = termino;
	}

	public XEvento getEvento() {
		return evento;
	}

	public void setEvento(XEvento evento) {
		this.evento = evento;
	}

	public XUsuario getUsuario() {
		return usuario;
	}

	public void setUsuario(XUsuario usuario) {
		this.usuario = usuario;
	}

	public XProjeto getProjeto() {
		return projeto;
	}

	public void setProjeto(XProjeto projeto) {
		this.projeto = projeto;
	}

	public List<XProjetoItem> getProjetoItens() {
		return projetoItens;
	}

	public void setProjetoItens(List<XProjetoItem> projetoItens) {
		this.projetoItens = projetoItens;
	}

}