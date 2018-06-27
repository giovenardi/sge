package br.com.lummi.sge.daos;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import br.com.lummi.sge.models.Formando;

public class FormandoDao extends GenericDao<Formando> {

	/**
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Formando> listarPorProjetoId(Integer id) {
		return getSession().createCriteria(Formando.class).createAlias("turma", "turma")
				.createAlias("turma.projeto", "projeto").add(Restrictions.eq("projeto.id", id)).list();

	}

}
