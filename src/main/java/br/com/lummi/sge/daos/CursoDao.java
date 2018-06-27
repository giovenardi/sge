package br.com.lummi.sge.daos;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import br.com.lummi.sge.models.Curso;

public class CursoDao extends GenericDao<Curso> {

	/**
	 * @param curso
	 * @return
	 */
	public boolean temNomeDuplicado(Curso curso) {
		Criteria criteria = getSession().createCriteria(Curso.class).add(Restrictions.eq("nome", curso.getNome()));
		if (curso.getId() != null) {
			criteria.add(Restrictions.ne("id", curso.getId()));
		}
		return ((Number) criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue() > 0;
	}

}
