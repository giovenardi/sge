package br.com.lummi.sge.service;

import java.util.List;

import javax.inject.Inject;

import br.com.lummi.sge.daos.GenericDao;
import br.com.lummi.sge.daos.ProjetoEventoDao;
import br.com.lummi.sge.exceptions.SgeException;
import br.com.lummi.sge.models.Projeto;
import br.com.lummi.sge.models.ProjetoEvento;
import br.com.lummi.sge.models.ProjetoFormaturaSuperior;
import br.com.lummi.sge.models.transiente.ItemLog;
import br.com.lummi.sge.utils.Mensagens;

public class ProjetoEventoService extends AbstractLogService<ProjetoEvento> {

	private static final String ESPACO = " ";

	@Inject
	ProjetoEventoDao dao;

	@Override
	public ProjetoEvento create(ProjetoEvento projetoEvento) {
		projetoEvento.setProjeto(dao.getEntityManager().find(Projeto.class, projetoEvento.getProjeto().getId()));
		return dao.save(projetoEvento);
	}

	public void delete(ProjetoEvento projetoEvento) {
		Integer idProjeto = projetoEvento.getProjeto().getId();
		dao.delete(projetoEvento);
		ProjetoFormaturaSuperior projeto = dao.getEntityManager().find(ProjetoFormaturaSuperior.class,
				idProjeto);
		projeto.getTurmas().remove(projetoEvento);
	}

	public List<ProjetoEvento> findByIdProjeto(Integer idProjeto) throws SgeException {
		List<ProjetoEvento> eventos = dao.findByIdProjeto(idProjeto);
		if (eventos.size() == 0) {
			throw new SgeException(Mensagens.MSG_NENHUM_REGISTRO);
		}
		return eventos;
	}

	@Override
	public GenericDao<ProjetoEvento> getDao() {
		return dao;
	}

	@Override
	protected void preencherItensLog(List<ItemLog> itensLog, ProjetoEvento anterior, ProjetoEvento atual) {

	}

	/**
	 * @param projetoEvento
	 * @return
	 */
	public boolean verificarEventoDuplicado(ProjetoEvento projetoEvento) {
		return dao.verificarEventoDuplicado(projetoEvento);
	}

}
