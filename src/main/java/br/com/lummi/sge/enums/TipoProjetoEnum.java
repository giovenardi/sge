package br.com.lummi.sge.enums;

public enum TipoProjetoEnum {
	FORMATURA_SUPERIOR("Formatura Nível Superior"), 
	FORMATURA_MEDIO("Formatura Nível Médio"), 
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
