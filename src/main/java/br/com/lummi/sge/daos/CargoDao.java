package br.com.lummi.sge.daos;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import br.com.lummi.sge.models.Cargo;

public class CargoDao extends GenericDao<Cargo> {

	/**
	 * @param cargo
	 * @return
	 */
	public boolean temNomeDuplicado(Cargo cargo) {
		Criteria criteria = getSession().createCriteria(Cargo.class).add(Restrictions.eq("nome", cargo.getNome()));
		if (cargo.getId() != null) {
			criteria.add(Restrictions.ne("id", cargo.getId()));
		}
		return ((Number) criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue() > 0;
	}

}
