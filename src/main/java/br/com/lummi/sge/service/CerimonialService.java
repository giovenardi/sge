package br.com.lummi.sge.service;

import java.util.List;

import javax.inject.Inject;

import br.com.lummi.sge.daos.CerimonialDao;
import br.com.lummi.sge.daos.GenericDao;
import br.com.lummi.sge.models.Cerimonial;
import br.com.lummi.sge.models.transiente.ItemLog;

public class CerimonialService extends AbstractLogService<Cerimonial> {

	@Inject
	private CerimonialDao dao;

	@Override
	protected void preencherItensLog(List<ItemLog> itensLog, Cerimonial anterior, Cerimonial atual) {
	}

	@Override
	public GenericDao<Cerimonial> getDao() {
		return dao;
	}

}
