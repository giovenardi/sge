package br.com.lummi.sge.service;

import java.util.List;

import javax.inject.Inject;

import br.com.lummi.sge.daos.FormaPagamentoDao;
import br.com.lummi.sge.daos.GenericDao;
import br.com.lummi.sge.exceptions.SgeException;
import br.com.lummi.sge.models.FormaPagamento;
import br.com.lummi.sge.models.transiente.ItemLog;
import br.com.lummi.sge.utils.Mensagens;

public class FormaPagamentoService extends AbstractLogService<FormaPagamento> {

	@Inject
	FormaPagamentoDao dao;
	
	@Override
	protected void preencherItensLog(List<ItemLog> itensLog, FormaPagamento anterior, FormaPagamento atual) {
		
	}

	@Override
	public GenericDao<FormaPagamento> getDao() {
		return dao;
	}

	public List<FormaPagamento> findByIdPlano(Integer idPlano) throws SgeException {
		List<FormaPagamento> formas = dao.findByIdPlano(idPlano);
		if (formas.size() == 0) {
			throw new SgeException(Mensagens.MSG_NENHUM_REGISTRO);
		}
		return formas;
	}

}
