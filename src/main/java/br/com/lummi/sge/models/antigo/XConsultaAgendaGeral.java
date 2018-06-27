package br.com.lummi.sge.models.antigo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;


/**
 * The persistent class for the gconsultaagendageral database table.
 * 
 */
//@Entity
@Table(name="gconsultaagendageral")
public class XConsultaAgendaGeral implements Serializable {
	private static final long serialVersionUID = 1L;

	private String categoria1;

	private String categoria10;

	private String categoria2;

	private String categoria3;

	private String categoria4;

	private String categoria5;

	private String categoria6;

	private String categoria7;

	private String categoria8;

	private String categoria9;

	private String dia1;

	private String dia10;

	private String dia2;

	private String dia3;

	private String dia4;

	private String dia5;

	private String dia6;

	private String dia7;

	private String dia8;

	private String dia9;

	private String exibirdia1;

	private String exibirdia10;

	private String exibirdia2;

	private String exibirdia3;

	private String exibirdia4;

	private String exibirdia5;

	private String exibirdia6;

	private String exibirdia7;

	private String exibirdia8;

	private String exibirdia9;

	private Time hora;

	private Integer id;

	public XConsultaAgendaGeral() {
	}

	public String getCategoria1() {
		return this.categoria1;
	}

	public void setCategoria1(String categoria1) {
		this.categoria1 = categoria1;
	}

	public String getCategoria10() {
		return this.categoria10;
	}

	public void setCategoria10(String categoria10) {
		this.categoria10 = categoria10;
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

	public String getCategoria6() {
		return this.categoria6;
	}

	public void setCategoria6(String categoria6) {
		this.categoria6 = categoria6;
	}

	public String getCategoria7() {
		return this.categoria7;
	}

	public void setCategoria7(String categoria7) {
		this.categoria7 = categoria7;
	}

	public String getCategoria8() {
		return this.categoria8;
	}

	public void setCategoria8(String categoria8) {
		this.categoria8 = categoria8;
	}

	public String getCategoria9() {
		return this.categoria9;
	}

	public void setCategoria9(String categoria9) {
		this.categoria9 = categoria9;
	}

	public String getDia1() {
		return this.dia1;
	}

	public void setDia1(String dia1) {
		this.dia1 = dia1;
	}

	public String getDia10() {
		return this.dia10;
	}

	public void setDia10(String dia10) {
		this.dia10 = dia10;
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

	public String getDia6() {
		return this.dia6;
	}

	public void setDia6(String dia6) {
		this.dia6 = dia6;
	}

	public String getDia7() {
		return this.dia7;
	}

	public void setDia7(String dia7) {
		this.dia7 = dia7;
	}

	public String getDia8() {
		return this.dia8;
	}

	public void setDia8(String dia8) {
		this.dia8 = dia8;
	}

	public String getDia9() {
		return this.dia9;
	}

	public void setDia9(String dia9) {
		this.dia9 = dia9;
	}

	public String getExibirdia1() {
		return this.exibirdia1;
	}

	public void setExibirdia1(String exibirdia1) {
		this.exibirdia1 = exibirdia1;
	}

	public String getExibirdia10() {
		return this.exibirdia10;
	}

	public void setExibirdia10(String exibirdia10) {
		this.exibirdia10 = exibirdia10;
	}

	public String getExibirdia2() {
		return this.exibirdia2;
	}

	public void setExibirdia2(String exibirdia2) {
		this.exibirdia2 = exibirdia2;
	}

	public String getExibirdia3() {
		return this.exibirdia3;
	}

	public void setExibirdia3(String exibirdia3) {
		this.exibirdia3 = exibirdia3;
	}

	public String getExibirdia4() {
		return this.exibirdia4;
	}

	public void setExibirdia4(String exibirdia4) {
		this.exibirdia4 = exibirdia4;
	}

	public String getExibirdia5() {
		return this.exibirdia5;
	}

	public void setExibirdia5(String exibirdia5) {
		this.exibirdia5 = exibirdia5;
	}

	public String getExibirdia6() {
		return this.exibirdia6;
	}

	public void setExibirdia6(String exibirdia6) {
		this.exibirdia6 = exibirdia6;
	}

	public String getExibirdia7() {
		return this.exibirdia7;
	}

	public void setExibirdia7(String exibirdia7) {
		this.exibirdia7 = exibirdia7;
	}

	public String getExibirdia8() {
		return this.exibirdia8;
	}

	public void setExibirdia8(String exibirdia8) {
		this.exibirdia8 = exibirdia8;
	}

	public String getExibirdia9() {
		return this.exibirdia9;
	}

	public void setExibirdia9(String exibirdia9) {
		this.exibirdia9 = exibirdia9;
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

}