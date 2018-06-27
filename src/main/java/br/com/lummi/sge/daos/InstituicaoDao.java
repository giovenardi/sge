package br.com.lummi.sge.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import br.com.lummi.sge.enums.TipoProjetoEnum;
import br.com.lummi.sge.models.Instituicao;

public class InstituicaoDao extends GenericDao<Instituicao> {

	/**
	 * @param cargo
	 * @return
	 */
	public boolean temNomeDuplicado(Instituicao instituicao) {
		Criteria criteria = getSession().createCriteria(Instituicao.class).add(
				Restrictions.or(
						Restrictions.eq("nome", instituicao.getNome()),
						Restrictions.eq("nomeCompleto", instituicao.getNome())));
		if (instituicao.getId() != null) {
			criteria.add(Restrictions.ne("id", instituicao.getId()));
		}
		return ((Number) criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue() > 0;
	}

	@SuppressWarnings("unchecked")
	public List<Instituicao> listarPorTipo(TipoProjetoEnum tipo) {
		Criteria criteria = getSession().createCriteria(Instituicao.class);
		switch (tipo) {
		case CURSO_FORMACAO:
			criteria.add(Restrictions.eq("cursosFormacao", true));
			break;
		case FORMATURA_INFANTIL:
			criteria.add(Restrictions.eq("educacaoInfantil", true));
			break;
		case FORMATURA_SUPERIOR:
			criteria.add(Restrictions.eq("ensinoSuperior", true));
			break;
		case FORMATURA_FUNDAMENTAL:
			criteria.add(Restrictions.eq("ensinoFundamental", true));
			break;
		case FORMATURA_MEDIO:
			criteria.add(Restrictions.eq("ensinoMedio", true));
			break;
		case FORMATURA_FUNDAMENTAL_MEDIO:
			criteria.add(
					Restrictions.or(Restrictions.eq("ensinoFundamental", true), Restrictions.eq("ensinoMedio", true)));
			break;
		default:
			criteria.add(Restrictions.eq("ensinoFundamentalMedio", true));
		}
		return criteria.list();
	}

}
