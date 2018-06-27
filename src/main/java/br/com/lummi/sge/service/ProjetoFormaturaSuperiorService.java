package br.com.lummi.sge.service;

import java.util.List;

import javax.inject.Inject;

import br.com.lummi.sge.daos.GenericDao;
import br.com.lummi.sge.daos.ProjetoFormaturaSuperiorDao;
import br.com.lummi.sge.models.ProjetoFormaturaSuperior;
import br.com.lummi.sge.models.transiente.ItemLog;

public class ProjetoFormaturaSuperiorService extends AbstractLogService<ProjetoFormaturaSuperior> {

	@Inject
	ProjetoFormaturaSuperiorDao dao;
	
	@Override
	protected void preencherItensLog(List<ItemLog> itensLog, ProjetoFormaturaSuperior anterior,
			ProjetoFormaturaSuperior atual) {
		
	}

	@Override
	public GenericDao<ProjetoFormaturaSuperior> getDao() {
		return dao;
	}

}
