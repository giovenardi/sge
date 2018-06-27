/**
 * 
 */
package br.com.lummi.sge.service;

import java.util.List;

import javax.inject.Inject;

import br.com.lummi.sge.daos.FuncaoComissaoDao;
import br.com.lummi.sge.daos.GenericDao;
import br.com.lummi.sge.models.FuncaoComissao;
import br.com.lummi.sge.models.transiente.ItemLog;

/**
 * @author luizfernando
 */
public class FuncaoComissaoService extends AbstractLogService<FuncaoComissao> {

	@Inject
	private FuncaoComissaoDao dao;

	@Override
	protected void preencherItensLog(List<ItemLog> itensLog, FuncaoComissao anterior,
			FuncaoComissao atual) {
		// TODO Auto-generated method stub

	}

	@Override
	public GenericDao<FuncaoComissao> getDao() {
		return dao;
	}

}
