package br.com.lummi.sge.enums;

public enum StatusFormandoEnum {
	EM_ABERTO("Em Aberto"), EFETIVADO("Efetivado");

	private String descricao;

	private StatusFormandoEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
