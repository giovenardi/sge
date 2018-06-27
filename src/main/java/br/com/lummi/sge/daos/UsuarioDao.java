package br.com.lummi.sge.daos;

import org.hibernate.criterion.Restrictions;

import br.com.lummi.sge.models.Usuario;

public class UsuarioDao extends GenericDao<Usuario> {

	public Usuario findByLogin(String login) {
		return (Usuario) getSession()
					.createCriteria(Usuario.class)
					.add(Restrictions.eq("login", login))
					.uniqueResult();
	}

}
