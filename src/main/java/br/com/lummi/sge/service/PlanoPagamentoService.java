package br.com.lummi.sge.service;

import java.util.List;

import javax.inject.Inject;

import br.com.lummi.sge.daos.GenericDao;
import br.com.lummi.sge.daos.PlanoPagamentoDao;
import br.com.lummi.sge.exceptions.SgeException;
import br.com.lummi.sge.models.PlanoPagamento;
import br.com.lummi.sge.models.transiente.ItemLog;
import br.com.lummi.sge.utils.Mensagens;

public class PlanoPagamentoService extends AbstractLogService<PlanoPagamento> {

	@Inject
	private PlanoPagamentoDao dao;

	@Override
	protected void preencherItensLog(List<ItemLog> itensLog, PlanoPagamento anterior, PlanoPagamento atual) {
		// TODO Auto-generated method stub
		
	}

	public List<PlanoPagamento> findByIdProjeto(Integer idProjeto) throws SgeException {
		List<PlanoPagamento> planos = dao.findByIdProjeto(idProjeto);
		if (planos.size() == 0) {
			throw new SgeException(Mensagens.MSG_NENHUM_REGISTRO);
		}
		return planos;
	}

	@Override
	public GenericDao<PlanoPagamento> getDao() {
		return dao;
	}
}
