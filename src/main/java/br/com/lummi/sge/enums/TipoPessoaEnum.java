package br.com.lummi.sge.enums;

public enum TipoPessoaEnum {
	
	PF("Pessoa Física"),
	PJ("Pessoa_Jurídica");
	
	private String descricao;

	private TipoPessoaEnum(String descricao) {
		this.setDescricao(descricao);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
