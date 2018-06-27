package br.com.lummi.sge.enums;

public enum ResponsabilidadeFinanceiraEnum {
	EMPRESA("Empresa"),
	PROJETO("Projeto");
	
	private String descricao;

	private ResponsabilidadeFinanceiraEnum(String descricao) {
		this.setDescricao(descricao);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
