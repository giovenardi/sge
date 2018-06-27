/**
 * 
 */
package br.com.lummi.sge.models.transiente;

/**
 * @author luizfernando
 */
public class Item {

	/**
	 * @param valor
	 * @param descricao
	 */
	public Item(String valor, String descricao) {
		super();
		this.valor = valor;
		this.descricao = descricao;
	}

	private String valor;
	private String descricao;

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
