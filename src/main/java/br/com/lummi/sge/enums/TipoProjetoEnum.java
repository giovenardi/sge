package br.com.lummi.sge.enums;

public enum TipoProjetoEnum {
	FORMATURA_SUPERIOR("Formatura Nível Superior"),
	FORMATURA_FUNDAMENTAL("Formatura Nível Fundamental"),
	FORMATURA_MEDIO("Formatura Nível Médio"),
	FORMATURA_FUNDAMENTAL_MEDIO("Formatura Níveis Fundamental e Médio"),
	FORMATURA_INFANTIL("Formatura Infantil"),
	CURSO_FORMACAO("Curso de Formação"),
	CORPORATIVO("Evento Corporativo"),
	SOCIAL("Evento Social"),
	MARKETING("Evento de Marketing");

	private String descricao;

	private TipoProjetoEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
