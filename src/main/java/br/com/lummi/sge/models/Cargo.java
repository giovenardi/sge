package br.com.lummi.sge.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the ccargo database table.
 * 
 */
@Entity
@Table(name="cargo")
public class Cargo implements Entidade {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="cargo_id_seq", sequenceName="cargo_id_seq", allocationSize=1)
	@GeneratedValue(generator="cargo_id_seq")
	private Integer id;

	private String nome;

	private boolean captador;

	private boolean vendedor;

	private boolean gerente;

	public Cargo() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isCaptador() {
		return captador;
	}

	public void setCaptador(boolean captador) {
		this.captador = captador;
	}

	public boolean isVendedor() {
		return vendedor;
	}

	public void setVendedor(boolean vendedor) {
		this.vendedor = vendedor;
	}

	public boolean isGerente() {
		return gerente;
	}

	public void setGerente(boolean gerente) {
		this.gerente = gerente;
	}

}