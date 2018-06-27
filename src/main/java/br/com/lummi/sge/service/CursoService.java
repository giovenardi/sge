package br.com.lummi.sge.service;

import java.text.MessageFormat;
import java.util.List;

import javax.inject.Inject;

import br.com.lummi.sge.daos.CursoDao;
import br.com.lummi.sge.daos.GenericDao;
import br.com.lummi.sge.exceptions.SgeValidationException;
import br.com.lummi.sge.models.Curso;
import br.com.lummi.sge.models.transiente.ItemLog;
import br.com.lummi.sge.utils.Mensagens;

public class CursoService extends AbstractLogService<Curso> {

	@Inject
	CursoDao dao;

	@Override
	protected void preencherItensLog(List<ItemLog> itensLog, Curso anterior, Curso atual) {
		// TODO Auto-generated method stub

	}

	public void alterar(Curso curso) throws SgeValidationException {
		validarCurso(curso);
		update(curso);
	}

	public void novo(Curso curso) throws SgeValidationException {
		validarCurso(curso);
		create(curso);
	}

	private void validarCurso(Curso curso) throws SgeValidationException {
		if (curso.getNome() == null || curso.getNome().trim().length() == 0) {
			throw new SgeValidationException(Mensagens.MSG_CAMPOS_OBRIGATORIOS);
		}
		if (obterCursoDuplicado(curso)) {
			throw new SgeValidationException(MessageFormat.format(Mensagens.MSG_NOME_DUPLICADO, "Curso"));
		}
	}

	/**
	 * @param curso
	 * @return
	 */
	private boolean obterCursoDuplicado(Curso curso) {
		return dao.temNomeDuplicado(curso);
	}

	@Override
	public GenericDao<Curso> getDao() {
		return dao;
	}

}
