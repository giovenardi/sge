package br.com.lummi.sge.service;

import java.util.List;

import javax.inject.Inject;

import br.com.lummi.sge.daos.GenericDao;
import br.com.lummi.sge.daos.UsuarioDao;
import br.com.lummi.sge.exceptions.SgeValidationException;
import br.com.lummi.sge.models.Usuario;
import br.com.lummi.sge.models.transiente.ItemLog;

public class UsuarioService extends AbstractLogService<Usuario> {

	@Inject
	private UsuarioDao dao;

	@Override
	protected void preencherItensLog(List<ItemLog> itensLog, Usuario anterior, Usuario atual) {
		
	}

	public Usuario entrar(String login, String senha) throws SgeValidationException {
		try {
			Usuario usuario = dao.findByLogin(login);
			if (usuario == null || !usuario.getSenha().equals(senha)) {
				throw new SgeValidationException("login inválido");
			}
			return usuario;
		} catch (Exception e) {
			throw new SgeValidationException("login inválido");
		}
	}

	@Override
	public GenericDao<Usuario> getDao() {
		return dao;
	}

}
