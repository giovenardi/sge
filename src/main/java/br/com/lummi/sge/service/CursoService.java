package br.com.lummi.sge.service;

import java.util.List;

import javax.inject.Inject;

import br.com.lummi.sge.daos.CursoDao;
import br.com.lummi.sge.daos.GenericDao;
import br.com.lummi.sge.models.Curso;
import br.com.lummi.sge.models.PaginatedList;
import br.com.lummi.sge.models.Curso;
import br.com.lummi.sge.models.transiente.ItemLog;

public class CursoService extends AbstractLogService<Curso> {
	
	@Inject
	CursoDao dao;

	@Override
	protected void preencherItensLog(List<ItemLog> itensLog, Curso anterior, Curso atual) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public GenericDao<Curso> getDao() {
		return dao;
	}

	public PaginatedList findByFiltro(Curso curso, int page, int tamanho) {
		return dao.findByFiltro(curso, page, tamanho);
	}

}
