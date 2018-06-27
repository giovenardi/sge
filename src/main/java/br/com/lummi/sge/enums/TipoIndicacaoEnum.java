package br.com.lummi.sge.enums;

public enum TipoIndicacaoEnum {
	INDICACAO_ASSISTENTE("Assistente Executivo de Vendas"), 
	INDICACAO_CAPTADOR_EXTERNO("Captador Externo"), 
	INDICACAO_CAPTADOR_FUNCIONARIO("Captador Funcionário"), 
	INDICACAO_PROJETO("Projeto"); 
	
	private String descricao;
	
	private TipoIndicacaoEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
