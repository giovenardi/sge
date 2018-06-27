package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the clocalhistoricovisita database table.
 * 
 */
@Entity
@Table(name="clocalhistoricovisita")
public class XLocalHistoricoVisita implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Timestamp datahora;

	private Timestamp datahoraultimaalteracao;

	private String detalhamento;

	private String item;

	private String titulo;

	//bi-directional many-to-one association to Clocal
	@ManyToOne
	@JoinColumn(name="localid")
	private XLocal local;

	//bi-directional many-to-one association to Cusuario
	@ManyToOne
	@JoinColumn(name="responsavelid")
	private XUsuario usuarioResponsavel;

	//bi-directional many-to-one association to Cusuario
	@ManyToOne
	@JoinColumn(name="usuarioultimaalteracaoid")
	private XUsuario usuarioUltimaAlteracao;

	public XLocalHistoricoVisita() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getDatahora() {
		return this.datahora;
	}

	public void setDatahora(Timestamp datahora) {
		this.datahora = datahora;
	}

	public Timestamp getDatahoraultimaalteracao() {
		return this.datahoraultimaalteracao;
	}

	public void setDatahoraultimaalteracao(Timestamp datahoraultimaalteracao) {
		this.datahoraultimaalteracao = datahoraultimaalteracao;
	}

	public String getDetalhamento() {
		return this.detalhamento;
	}

	public void setDetalhamento(String detalhamento) {
		this.detalhamento = detalhamento;
	}

	public String getItem() {
		return this.item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public XLocal getLocal() {
		return this.local;
	}

	public void setClocal(XLocal local) {
		this.local = local;
	}

	public XUsuario getUsuarioResponsavel() {
		return this.usuarioResponsavel;
	}

	public void setUsuarioResponsavel(XUsuario usuarioResponsavel) {
		this.usuarioResponsavel = usuarioResponsavel;
	}

	public XUsuario getUsuarioUltimaAlteracao() {
		return this.usuarioUltimaAlteracao;
	}

	public void setUsuarioUltimaAlteracao(XUsuario usuarioUltimaAlteracao) {
		this.usuarioUltimaAlteracao = usuarioUltimaAlteracao;
	}

}