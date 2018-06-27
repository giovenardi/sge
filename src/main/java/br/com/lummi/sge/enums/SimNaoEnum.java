package br.com.lummi.sge.enums;

public enum SimNaoEnum {
	A("Sim"),
	N("Não");
	
	private String descricao;

	private SimNaoEnum(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}

}
