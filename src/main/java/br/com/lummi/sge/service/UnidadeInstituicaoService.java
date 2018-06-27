package br.com.lummi.sge.service;

import java.util.List;

import javax.inject.Inject;

import br.com.lummi.sge.daos.GenericDao;
import br.com.lummi.sge.daos.UnidadeInstituicaoDao;
import br.com.lummi.sge.models.Instituicao;
import br.com.lummi.sge.models.UnidadeInstituicao;
import br.com.lummi.sge.models.transiente.ItemLog;

public class UnidadeInstituicaoService extends AbstractLogService<UnidadeInstituicao> {
	
	@Inject
	UnidadeInstituicaoDao dao;

	public List<UnidadeInstituicao> findByInstituicao(Instituicao instituicao) {
		return dao.findByInstituicao(instituicao);
	}

	@Override
	protected void preencherItensLog(List<ItemLog> itensLog, UnidadeInstituicao anterior, UnidadeInstituicao atual) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public GenericDao<UnidadeInstituicao> getDao() {
		return dao;
	}

}
