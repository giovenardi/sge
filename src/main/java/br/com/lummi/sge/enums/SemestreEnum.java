package br.com.lummi.sge.enums;

public enum SemestreEnum {
	ANUAL("Anual"),
	PRIMEIRO("1°"),
	SEGUNDO("2°");
	
	private String descricao;

	private SemestreEnum(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}

}
