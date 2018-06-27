package br.com.lummi.sge.enums;

public enum FormaParcelamentoEnum {
	DECENDIAL("Decendial"),
	QUINZENAL("Quinzenal"),
	MENSAL("Mensal"),
	TRIMESTRAL("Trimestral"),
	SEMESTRAL("Semestral"),
	ANUAL("Anual");
	
	private String descricao;

	private FormaParcelamentoEnum(String descricao) {
		this.setDescricao(descricao);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
