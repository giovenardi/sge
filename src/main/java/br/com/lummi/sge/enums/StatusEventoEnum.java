package br.com.lummi.sge.enums;

public enum StatusEventoEnum {
	
	A_ATRIBUIR("A Atribuir"),
	EM_COMPLEMENTACAO("Em Complementação"),
	ATRIBUIDO("Atribuído"),
	CANCELADO("Cancelado");
	
	private String descricao;
	
	StatusEventoEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	
}
