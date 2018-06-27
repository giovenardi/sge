package br.com.lummi.sge.enums;

public enum EstadoCivilEnum {
	
	S("Solteiro(a)"),
	C("Casado(a)"),
	D("Divorciado(a)");
	
	private String descricao;
	
	private EstadoCivilEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
