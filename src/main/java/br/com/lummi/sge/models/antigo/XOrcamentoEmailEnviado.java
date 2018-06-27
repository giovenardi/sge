package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the morcamentoemailenviado database table.
 * 
 */
@Entity
@Table(name="morcamentoemailenviado")
public class XOrcamentoEmailEnviado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Timestamp dataenvio;

	private String destinatario;

	private String item;

	private String remetente;

	private String titulo;

	@ManyToOne
	@JoinColumn(name="orcamentoid")
	private XOrcamento orcamento;

	public XOrcamentoEmailEnviado() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getDataenvio() {
		return this.dataenvio;
	}

	public void setDataenvio(Timestamp dataenvio) {
		this.dataenvio = dataenvio;
	}

	public String getDestinatario() {
		return this.destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public String getItem() {
		return this.item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getRemetente() {
		return this.remetente;
	}

	public void setRemetente(String remetente) {
		this.remetente = remetente;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public XOrcamento getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(XOrcamento orcamento) {
		this.orcamento = orcamento;
	}

}