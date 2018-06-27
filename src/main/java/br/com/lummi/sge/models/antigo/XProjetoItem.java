package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the mprojetoitens database table.
 * 
 */
@Entity
@Table(name="mprojetoitens")
public class XProjetoItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String agrupador;

	private Timestamp datahoraalteracao;

	private String descricao;

	private String item;

	private String tipo;

	private String tipocobranca;

	private BigDecimal valortotal1;

	private BigDecimal valortotal2;

	private BigDecimal valortotal3;

	private BigDecimal valortotal4;

	private BigDecimal valorunitario;

	@ManyToOne
	@JoinColumn(name="itemorcamentoid")
	private XItemOrcamento itemOrcamento;

	@ManyToOne
	@JoinColumn(name="unidademedidaid")
	private XUnidadeMedida unidadeMedida;

	@ManyToOne
	@JoinColumn(name="usuarioalteracaoid")
	private XUsuario usuario;

	@ManyToOne
	@JoinColumn(name="projetoid")
	private XProjeto projeto;

	@ManyToOne
	@JoinColumn(name="projetoeventoid")
	private XProjetoEvento projetoEvento;

	public XProjetoItem() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAgrupador() {
		return this.agrupador;
	}

	public void setAgrupador(String agrupador) {
		this.agrupador = agrupador;
	}

	public Timestamp getDatahoraalteracao() {
		return this.datahoraalteracao;
	}

	public void setDatahoraalteracao(Timestamp datahoraalteracao) {
		this.datahoraalteracao = datahoraalteracao;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getItem() {
		return this.item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTipocobranca() {
		return this.tipocobranca;
	}

	public void setTipocobranca(String tipocobranca) {
		this.tipocobranca = tipocobranca;
	}

	public BigDecimal getValortotal1() {
		return this.valortotal1;
	}

	public void setValortotal1(BigDecimal valortotal1) {
		this.valortotal1 = valortotal1;
	}

	public BigDecimal getValortotal2() {
		return this.valortotal2;
	}

	public void setValortotal2(BigDecimal valortotal2) {
		this.valortotal2 = valortotal2;
	}

	public BigDecimal getValortotal3() {
		return this.valortotal3;
	}

	public void setValortotal3(BigDecimal valortotal3) {
		this.valortotal3 = valortotal3;
	}

	public BigDecimal getValortotal4() {
		return this.valortotal4;
	}

	public void setValortotal4(BigDecimal valortotal4) {
		this.valortotal4 = valortotal4;
	}

	public BigDecimal getValorunitario() {
		return this.valorunitario;
	}

	public void setValorunitario(BigDecimal valorunitario) {
		this.valorunitario = valorunitario;
	}

	public XItemOrcamento getItemOrcamento() {
		return itemOrcamento;
	}

	public void setItemOrcamento(XItemOrcamento itemOrcamento) {
		this.itemOrcamento = itemOrcamento;
	}

	public XUnidadeMedida getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(XUnidadeMedida unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
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

	public XProjetoEvento getProjetoEvento() {
		return projetoEvento;
	}

	public void setProjetoEvento(XProjetoEvento projetoEvento) {
		this.projetoEvento = projetoEvento;
	}


}