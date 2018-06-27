package br.com.lummi.sge.daos;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import br.com.lummi.sge.models.Evento;

public class EventoDao extends GenericDao<Evento> {

	/**
	 * @param evento
	 * @return
	 */
	public boolean temNomeDuplicado(Evento evento) {
		Criteria criteria = getSession().createCriteria(Evento.class).add(Restrictions.eq("nome", evento.getNome()));
		if (evento.getId() != null) {
			criteria.add(Restrictions.ne("id", evento.getId()));
		}
		return ((Number) criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue() > 0;
	}

}