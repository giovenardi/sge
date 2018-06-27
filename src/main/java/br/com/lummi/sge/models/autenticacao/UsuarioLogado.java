package br.com.lummi.sge.models.autenticacao;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.lummi.sge.models.Usuario;

@SessionScoped
@Named("usuarioLogado")
public class UsuarioLogado implements Serializable {

	private static final long serialVersionUID = 5568516728082575659L;

	private Usuario usuario;
	private String ultimaFuncionalidade;

	public void logar(final Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean isLogado() {
		return usuario != null;
	}

	public void finalizarSessao() {
		usuario = null;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public String getUltimaFuncionalidade() {
		return ultimaFuncionalidade;
	}

	public void setUltimaFuncionalidade(String ultimaFuncionalidade) {
		this.ultimaFuncionalidade = ultimaFuncionalidade;
	}

}
