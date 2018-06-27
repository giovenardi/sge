package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the grecurso database table.
 * 
 */
@Entity
@Table(name="grecurso")
public class XRecurso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Integer criativoid;

	private Timestamp data;

	private Timestamp datahora;

	private String observacao;

	private String recurso;

	private String responsavelexterno;

	@Column(name="sim_nao")
	private String simNao;

	private String status;

	private Integer usuarioid;

	public XRecurso() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCriativoid() {
		return this.criativoid;
	}

	public void setCriativoid(Integer criativoid) {
		this.criativoid = criativoid;
	}

	public Timestamp getData() {
		return this.data;
	}

	public void setData(Timestamp data) {
		this.data = data;
	}

	public Timestamp getDatahora() {
		return this.datahora;
	}

	public void setDatahora(Timestamp datahora) {
		this.datahora = datahora;
	}

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getRecurso() {
		return this.recurso;
	}

	public void setRecurso(String recurso) {
		this.recurso = recurso;
	}

	public String getResponsavelexterno() {
		return this.responsavelexterno;
	}

	public void setResponsavelexterno(String responsavelexterno) {
		this.responsavelexterno = responsavelexterno;
	}

	public String getSimNao() {
		return this.simNao;
	}

	public void setSimNao(String simNao) {
		this.simNao = simNao;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getUsuarioid() {
		return this.usuarioid;
	}

	public void setUsuarioid(Integer usuarioid) {
		this.usuarioid = usuarioid;
	}

}