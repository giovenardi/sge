package br.com.lummi.sge.enums;

import java.util.Calendar;

public enum PeriodicidadePagamentoEnum {

	DECENDIAL("Decendial", Calendar.DATE, 10),
	QUINZENAL("Quinzenal", Calendar.DATE, 15),
	MENSAL("Mensal", Calendar.MONTH, 1),
	BIMESTRAL("Bimestral", Calendar.MONTH, 2),
	TRIMESTRAL("Trimestral", Calendar.MONTH, 3),
	SEMESTRAL("Semestral", Calendar.MONTH, 6),
	ANUAL("Anual", Calendar.YEAR, 1);
	
	private String descricao;
	private int campo;
	private int montante;

	private PeriodicidadePagamentoEnum(String descricao, int campo, int montante) {
		this.setDescricao(descricao);
		this.setCampo(campo);
		this.setMontante(montante);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getCampo() {
		return campo;
	}

	public void setCampo(int campo) {
		this.campo = campo;
	}

	public int getMontante() {
		return montante;
	}

	public void setMontante(int montante) {
		this.montante = montante;
	}
	
}
