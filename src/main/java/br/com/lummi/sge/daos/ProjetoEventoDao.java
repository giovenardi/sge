package br.com.lummi.sge.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import br.com.lummi.sge.models.ProjetoEvento;

public class ProjetoEventoDao extends GenericDao<ProjetoEvento> {

	@SuppressWarnings("unchecked")
	public List<ProjetoEvento> findByIdProjeto(Integer idProjeto) {
		return getSession().createCriteria(ProjetoEvento.class)
				.createAlias("projeto", "projeto")
				.add(Restrictions.eq("projeto.id", idProjeto))
				.list();
	}

	/**
	 * @param projetoEvento
	 * @return
	 */
	public boolean verificarEventoDuplicado(ProjetoEvento projetoEvento) {
		Criteria criteria = getSession().createCriteria(ProjetoEvento.class)
				.createAlias("evento", "evento")
				.add(Restrictions.eq("evento.id", projetoEvento.getEvento().getId()))
				.createAlias("projeto", "projeto")
				.add(Restrictions.eq("projeto.id", projetoEvento.getProjeto().getId()));
		if (projetoEvento.getId() != null) {
			criteria.add(Restrictions.ne("id", projetoEvento.getId()));
		}
		return ((Number) criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue() > 0;
	}

}
