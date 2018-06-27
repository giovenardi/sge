package br.com.lummi.sge.models.global;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.lummi.sge.models.Entidade;

public class ParametroSistema implements Entidade {

	private static final long serialVersionUID = 660437515337700568L;

	@Id
	private Integer id;

	@Column(name = "chave")
	private String chave;

	@Column(name = "valor")
	private String valor;

	@Column(name = "expressao")
	private String expressao;

	@Column(name = "created_at", insertable=false, updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	@Column(name = "modified_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getExpressao() {
		return expressao;
	}

	public void setExpressao(String expressao) {
		this.expressao = expressao;
	}
}
