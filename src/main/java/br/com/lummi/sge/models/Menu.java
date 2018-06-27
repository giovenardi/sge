package br.com.lummi.sge.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


/**
 * The persistent class for the menu database table.
 * 
 */
@Entity
public class Menu implements Entidade {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String classe;

	private String nome;

	private Integer ordem;

	private String tipo;

	private String url;

	@ManyToOne
	@JoinColumn(name="pai")
	private Menu menuPai;

	@OneToMany(mappedBy="menuPai")
	private List<Menu> menusFilhos;

	public Menu() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClasse() {
		return this.classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getOrdem() {
		return this.ordem;
	}

	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Menu getMenuPai() {
		return menuPai;
	}

	public void setMenuPai(Menu menuPai) {
		this.menuPai = menuPai;
	}

	public List<Menu> getMenusFilhos() {
		return menusFilhos;
	}

	public void setMenusFilhos(List<Menu> menusFilhos) {
		this.menusFilhos = menusFilhos;
	}

}