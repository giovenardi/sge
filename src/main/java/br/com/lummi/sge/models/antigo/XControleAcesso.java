package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the gcontroleacesso database table.
 * 
 */
@Entity
@Table(name="gcontroleacesso")
public class XControleAcesso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Integer itembotaoid;

	private Boolean permissao;

	private Integer tipousuarioid;

	public XControleAcesso() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getItembotaoid() {
		return this.itembotaoid;
	}

	public void setItembotaoid(Integer itembotaoid) {
		this.itembotaoid = itembotaoid;
	}

	public Boolean getPermissao() {
		return this.permissao;
	}

	public void setPermissao(Boolean permissao) {
		this.permissao = permissao;
	}

	public Integer getTipousuarioid() {
		return this.tipousuarioid;
	}

	public void setTipousuarioid(Integer tipousuarioid) {
		this.tipousuarioid = tipousuarioid;
	}

}