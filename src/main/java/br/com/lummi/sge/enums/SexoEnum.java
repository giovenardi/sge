package br.com.lummi.sge.enums;

public enum SexoEnum {
	F("Feminino"),
	M("Masculino");
	
	private String descricao;
	
	private SexoEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}