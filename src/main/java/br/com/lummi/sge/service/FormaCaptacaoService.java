package br.com.lummi.sge.service;

import java.util.List;

import javax.inject.Inject;

import br.com.lummi.sge.daos.FormaCaptacaoDao;
import br.com.lummi.sge.daos.GenericDao;
import br.com.lummi.sge.exceptions.SgeValidationException;
import br.com.lummi.sge.models.FormaCaptacao;
import br.com.lummi.sge.models.transiente.ItemLog;
import br.com.lummi.sge.utils.Mensagens;

public class FormaCaptacaoService extends AbstractLogService<FormaCaptacao> {

	@Inject
	FormaCaptacaoDao dao;
	
	@Override
	protected void preencherItensLog(List<ItemLog> itensLog, FormaCaptacao anterior, FormaCaptacao atual) {
		// TODO Auto-generated method stub
		
	}

	public void alterar(FormaCaptacao formaCaptacao) throws SgeValidationException {
		validarFormaCaptacao(formaCaptacao);
		update(formaCaptacao);
	}

	public void novo(FormaCaptacao formaCaptacao) throws SgeValidationException {
		validarFormaCaptacao(formaCaptacao);
		create(formaCaptacao);
	}

	private void validarFormaCaptacao(FormaCaptacao formaCaptacao) throws SgeValidationException {
		if (formaCaptacao.getNome() == null || formaCaptacao.getNome().trim().length() == 0) {
			throw new SgeValidationException(Mensagens.MSG_CAMPOS_OBRIGATORIOS);
		}
	}

	@Override
	public GenericDao<FormaCaptacao> getDao() {
		return dao;
	}

}
