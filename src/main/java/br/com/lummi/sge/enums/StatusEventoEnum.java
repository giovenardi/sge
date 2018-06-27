package br.com.lummi.sge.enums;

public enum StatusEventoEnum {
	PRIMEIRO_CONTATO("Primeiro Contato"),
	CONFIRMAR_ATENDIMENTO("Confirmar Atendimento"),
	EM_ATENDIMENTO("Em Atendimento"),
	CONFIRMAR_ATIVACAO("Confirmar Ativação"),
	ATIVO("Ativo"),
	ENCERRADO("Encerrado"),
	CANCELADO("Cancelado");

	private String descricao;

	StatusEventoEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
