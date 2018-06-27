package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the clocalfotos database table.
 * 
 */
@Entity
@Table(name="clocalfotos")
public class XLocalFoto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Timestamp datafoto;

	private Timestamp datahoraultimaalteracao;

	private byte[] fotodefeito;

	private String item;

	private String titulo;

	private Integer usuarioultimaalteracao;

	//bi-directional many-to-one association to Clocal
	@ManyToOne
	@JoinColumn(name="localid")
	private XLocal local;

	public XLocalFoto() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getDatafoto() {
		return this.datafoto;
	}

	public void setDatafoto(Timestamp datafoto) {
		this.datafoto = datafoto;
	}

	public Timestamp getDatahoraultimaalteracao() {
		return this.datahoraultimaalteracao;
	}

	public void setDatahoraultimaalteracao(Timestamp datahoraultimaalteracao) {
		this.datahoraultimaalteracao = datahoraultimaalteracao;
	}

	public byte[] getFotodefeito() {
		return this.fotodefeito;
	}

	public void setFotodefeito(byte[] fotodefeito) {
		this.fotodefeito = fotodefeito;
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

	public Integer getUsuarioultimaalteracao() {
		return this.usuarioultimaalteracao;
	}

	public void setUsuarioultimaalteracao(Integer usuarioultimaalteracao) {
		this.usuarioultimaalteracao = usuarioultimaalteracao;
	}

	public XLocal getLocal() {
		return this.local;
	}

	public void setLocal(XLocal local) {
		this.local = local;
	}

}