package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;


/**
 * The persistent class for the gconsultaagenda database table.
 * 
 */
//@Entity
@Table(name="gconsultaagenda")
public class XConsultaAgenda implements Serializable {
	private static final long serialVersionUID = 1L;

	private String categoria1;

	private String categoria2;

	private String categoria3;

	private String categoria4;

	private String categoria5;

	private String dia1;

	private String dia2;

	private String dia3;

	private String dia4;

	private String dia5;

	private Time hora;

	private Integer id;

	private Integer iddia1;

	private Integer iddia2;

	private Integer iddia3;

	private Integer iddia4;

	private Integer iddia5;

	public XConsultaAgenda() {
	}

	public String getCategoria1() {
		return this.categoria1;
	}

	public void setCategoria1(String categoria1) {
		this.categoria1 = categoria1;
	}

	public String getCategoria2() {
		return this.categoria2;
	}

	public void setCategoria2(String categoria2) {
		this.categoria2 = categoria2;
	}

	public String getCategoria3() {
		return this.categoria3;
	}

	public void setCategoria3(String categoria3) {
		this.categoria3 = categoria3;
	}

	public String getCategoria4() {
		return this.categoria4;
	}

	public void setCategoria4(String categoria4) {
		this.categoria4 = categoria4;
	}

	public String getCategoria5() {
		return this.categoria5;
	}

	public void setCategoria5(String categoria5) {
		this.categoria5 = categoria5;
	}

	public String getDia1() {
		return this.dia1;
	}

	public void setDia1(String dia1) {
		this.dia1 = dia1;
	}

	public String getDia2() {
		return this.dia2;
	}

	public void setDia2(String dia2) {
		this.dia2 = dia2;
	}

	public String getDia3() {
		return this.dia3;
	}

	public void setDia3(String dia3) {
		this.dia3 = dia3;
	}

	public String getDia4() {
		return this.dia4;
	}

	public void setDia4(String dia4) {
		this.dia4 = dia4;
	}

	public String getDia5() {
		return this.dia5;
	}

	public void setDia5(String dia5) {
		this.dia5 = dia5;
	}

	public Time getHora() {
		return this.hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIddia1() {
		return this.iddia1;
	}

	public void setIddia1(Integer iddia1) {
		this.iddia1 = iddia1;
	}

	public Integer getIddia2() {
		return this.iddia2;
	}

	public void setIddia2(Integer iddia2) {
		this.iddia2 = iddia2;
	}

	public Integer getIddia3() {
		return this.iddia3;
	}

	public void setIddia3(Integer iddia3) {
		this.iddia3 = iddia3;
	}

	public Integer getIddia4() {
		return this.iddia4;
	}

	public void setIddia4(Integer iddia4) {
		this.iddia4 = iddia4;
	}

	public Integer getIddia5() {
		return this.iddia5;
	}

	public void setIddia5(Integer iddia5) {
		this.iddia5 = iddia5;
	}

}