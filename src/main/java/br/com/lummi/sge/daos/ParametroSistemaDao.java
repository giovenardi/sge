package br.com.lummi.sge.daos;

import org.hibernate.criterion.Restrictions;

import br.com.lummi.sge.enums.ChaveParametroEnum;
import br.com.lummi.sge.models.global.ParametroSistema;

public class ParametroSistemaDao extends GenericDao<ParametroSistema> {

	public ParametroSistema obterPorChave(ChaveParametroEnum chave) {
		return (ParametroSistema) getSession().createCriteria(ParametroSistema.class).add(Restrictions.eq("chave", chave.toString())).uniqueResult();
	}

}
