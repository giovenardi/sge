package br.com.lummi.sge.service;

import java.util.List;

import javax.inject.Inject;

import br.com.lummi.sge.daos.GenericDao;
import br.com.lummi.sge.daos.TurnoDao;
import br.com.lummi.sge.models.PaginatedList;
import br.com.lummi.sge.models.Turno;
import br.com.lummi.sge.models.transiente.ItemLog;

public class TurnoService extends AbstractLogService<Turno> {

	@Inject
	TurnoDao dao;
	
	@Override
	protected void preencherItensLog(List<ItemLog> itensLog, Turno anterior, Turno atual) {
		
	}

	@Override
	public GenericDao<Turno> getDao() {
		return dao;
	}

	public PaginatedList findByFiltro(Turno turno, int page, int tamanho) {
		return dao.findByFiltro(turno, page, tamanho);
	}

}
