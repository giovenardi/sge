package br.com.lummi.sge.filtros;

import java.io.Serializable;
import java.util.Date;

import br.com.lummi.sge.enums.AcaoEnum;
import br.com.lummi.sge.models.autenticacao.ZUsuario;

public class FiltroAuditoria implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ZUsuario usuario;
	private Integer idObjeto;
	private AcaoEnum acao;
	private Date dataHora;
	private String objectType;
	private Date dataInicio;
	private Date dataFim;

	public ZUsuario getUsuario() {
		return usuario;
	}
	public void setUsuario(ZUsuario usuario) {
		this.usuario = usuario;
	}
	public Integer getIdObjeto() {
		return idObjeto;
	}
	public void setIdObjeto(Integer idObjeto) {
		this.idObjeto = idObjeto;
	}
	public AcaoEnum getAcao() {
		return acao;
	}
	public void setAcao(AcaoEnum acao) {
		this.acao = acao;
	}
	public Date getDataHora() {
		return dataHora;
	}
	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}
	public String getObjectType() {
		return objectType;
	}
	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

}
