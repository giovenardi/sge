/**
 * 
 */
package br.com.lummi.sge.enums;

/**
 * @author luizfernando
 */
public enum NivelEnum {
	SUPERIOR("Superior"),
	FUNDAMENTAL("Fundamental"),
	MEDIO("Médio"),
	INFANTIL("Infantil");

	private String descricao;

	private NivelEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
