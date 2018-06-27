package br.com.lummi.sge.service;

import javax.inject.Inject;

import br.com.lummi.sge.daos.ParametroSistemaDao;
import br.com.lummi.sge.enums.ChaveParametroEnum;
import br.com.lummi.sge.models.global.ParametroSistema;

/**
 * 
 * @author carloslima
 *
 */
public class ParametroSistemaService {

	@Inject
	private ParametroSistemaDao dao;
	
	public ParametroSistemaService(){
		
	}
	
	public ParametroSistema obterPorChave(ChaveParametroEnum chave) {
		return dao.obterPorChave(chave);
	}


}
