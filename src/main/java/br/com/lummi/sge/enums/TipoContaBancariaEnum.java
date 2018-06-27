package br.com.lummi.sge.enums;

public enum TipoContaBancariaEnum {
	
	CONTA_CORRENTE("Conta Corrente"),
	CONTA_POUPANCA("Conta Poupança");
	
	private String descricao;

	private TipoContaBancariaEnum(String descricao) {
		this.setDescricao(descricao);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
