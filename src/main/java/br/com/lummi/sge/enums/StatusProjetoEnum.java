package br.com.lummi.sge.enums;

public enum StatusProjetoEnum {
	
	PRIMEIRO_ATENDIMENTO("Primeiro Atendimento"),
	EM_ATENDIMENTO("Em Atendimento"),
	ATIVO("Ativo"),
	PERDIDO("Perdido"), 
	CANCELADO("Cancelado"),
	EXECUTADO("Executado");
	
	private String descricao;

	private StatusProjetoEnum(String descricao) {
		this.setDescricao(descricao);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
