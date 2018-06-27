package br.com.lummi.sge.service;

import java.util.List;

import javax.inject.Inject;

import br.com.lummi.sge.daos.GenericDao;
import br.com.lummi.sge.daos.UfDao;
import br.com.lummi.sge.models.Uf;
import br.com.lummi.sge.models.transiente.ItemLog;

public class UfService extends AbstractLogService<Uf> {

	@Inject
	private UfDao dao;
	
	@Override
	protected void preencherItensLog(List<ItemLog> itensLog, Uf anterior, Uf atual) {
		
	}

	@Override
	public GenericDao<Uf> getDao() {
		return dao;
	}

}
