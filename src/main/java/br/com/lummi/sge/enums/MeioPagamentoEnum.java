package br.com.lummi.sge.enums;

public enum MeioPagamentoEnum {
	BOLETO("Boleto Bancário");
	
	private String descricao;
	
	private MeioPagamentoEnum(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
