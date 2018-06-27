package br.com.lummi.sge.service;

import java.text.MessageFormat;
import java.util.List;

import javax.inject.Inject;

import br.com.lummi.sge.daos.EventoDao;
import br.com.lummi.sge.daos.GenericDao;
import br.com.lummi.sge.exceptions.SgeValidationException;
import br.com.lummi.sge.models.Evento;
import br.com.lummi.sge.models.transiente.ItemLog;
import br.com.lummi.sge.utils.Mensagens;

public class EventoService extends AbstractLogService<Evento> {

	@Inject
	EventoDao dao;

	@Override
	protected void preencherItensLog(List<ItemLog> itensLog, Evento anterior, Evento atual) {

	}

	@Override
	public GenericDao<Evento> getDao() {
		return dao;
	}

	public void alterar(Evento evento) throws SgeValidationException {
		validarEvento(evento);
		update(evento);
	}

	private void validarEvento(Evento evento) throws SgeValidationException {
		if (evento.getNome() == null || evento.getNome().trim().length() == 0) {
			throw new SgeValidationException(Mensagens.MSG_CAMPOS_OBRIGATORIOS);
		}
		if (obterEventoDuplicado(evento)) {
			throw new SgeValidationException(MessageFormat.format(Mensagens.MSG_NOME_DUPLICADO, "Evento"));
		}
	}

	/**
	 * @param evento
	 * @return
	 */
	private boolean obterEventoDuplicado(Evento evento) {
		return dao.temNomeDuplicado(evento);
	}

	public void novo(Evento evento) throws SgeValidationException {
		validarEvento(evento);
		create(evento);
	}

}
