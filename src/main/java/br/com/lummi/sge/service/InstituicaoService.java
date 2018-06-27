package br.com.lummi.sge.service;

import java.text.MessageFormat;
import java.util.List;

import javax.inject.Inject;

import br.com.lummi.sge.daos.GenericDao;
import br.com.lummi.sge.daos.InstituicaoDao;
import br.com.lummi.sge.enums.TipoProjetoEnum;
import br.com.lummi.sge.exceptions.SgeValidationException;
import br.com.lummi.sge.models.Instituicao;
import br.com.lummi.sge.models.transiente.ItemLog;
import br.com.lummi.sge.utils.Mensagens;

public class InstituicaoService extends AbstractLogService<Instituicao> {
	
	@Inject
	InstituicaoDao dao;

	@Override
	protected void preencherItensLog(List<ItemLog> itensLog, Instituicao anterior, Instituicao atual) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public GenericDao<Instituicao> getDao() {
		return dao;
	}

	public void alterar(Instituicao instituicao) throws SgeValidationException {
		validarInstituicao(instituicao);
		update(instituicao);
	}

	public void novo(Instituicao instituicao) throws SgeValidationException {
		validarInstituicao(instituicao);
		create(instituicao);
	}

	private void validarInstituicao(Instituicao instituicao) throws SgeValidationException {
		if (instituicao.getNome() == null 
				|| instituicao.getNome().trim().length() == 0 
				|| instituicao.getNomeCompleto() == null 
				|| instituicao.getNomeCompleto().trim().length() == 0) {
			throw new SgeValidationException(Mensagens.MSG_CAMPOS_OBRIGATORIOS);
		}
		if (obterInstituicaoDuplicado(instituicao)) {
			throw new SgeValidationException(MessageFormat.format(Mensagens.MSG_NOME_DUPLICADO, "Instituição"));
		}
	}

	/**
	 * @param curso
	 * @return
	 */
	private boolean obterInstituicaoDuplicado(Instituicao instituicao) {
		return dao.temNomeDuplicado(instituicao);
	}

	/**
	 * @param tipo
	 * @return
	 */
	public List<Instituicao> listarPorTipo(TipoProjetoEnum tipo) {
		return dao.listarPorTipo(tipo);
	}

}
