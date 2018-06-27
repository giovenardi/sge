package br.com.lummi.sge.enums;

public enum AcaoEnum {
	Incluir("Inclusão"), 
	Editar("Edição"), 
	Excluir("Exclusão"),
	Carga("Carga de Dados");
	
	private String descricao;
	
	private AcaoEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
