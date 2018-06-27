/**
 * 
 */
package br.com.lummi.sge.service;

import java.util.List;

import javax.inject.Inject;

import br.com.lummi.sge.daos.ComissaoFormaturaDao;
import br.com.lummi.sge.daos.GenericDao;
import br.com.lummi.sge.models.ComissaoFormatura;
import br.com.lummi.sge.models.transiente.ItemLog;

/**
 * @author luizfernando
 */
public class ComissaoFormaturaService extends AbstractLogService<ComissaoFormatura> {

	@Inject
	private ComissaoFormaturaDao dao;

	@Override
	protected void preencherItensLog(List<ItemLog> itensLog, ComissaoFormatura anterior, ComissaoFormatura atual) {
		// TODO Auto-generated method stub
	}

	@Override
	public GenericDao<ComissaoFormatura> getDao() {
		return dao;
	}

}
