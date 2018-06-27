package br.com.lummi.sge.service;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;

import br.com.lummi.sge.daos.AuditoriaDao;
import br.com.lummi.sge.enums.AcaoEnum;
import br.com.lummi.sge.filtros.FiltroAuditoria;
import br.com.lummi.sge.models.Entidade;
import br.com.lummi.sge.models.PaginatedList;
import br.com.lummi.sge.models.autenticacao.ZUsuario;
import br.com.lummi.sge.models.global.Auditoria;

public class AuditoriaService extends GenericCRUDService<Auditoria> {

	@Inject
	private AuditoriaDao dao;
	
	@Inject 
	HttpServletRequest request;

	@SuppressWarnings("rawtypes")
	public void gravarAuditoria(
			AcaoEnum acaoEnum, Date acaoDthora, String enderIp, 
			ZUsuario usuario,
			String valorAtual, String valorAnterior, 
			Class clazz, Integer id) {
		
		Boolean anteriorAtualDiferentes = (valorAnterior == null || valorAtual == null || !valorAtual.equals(valorAnterior));
		
		if( anteriorAtualDiferentes){
			Auditoria audit = new Auditoria();
			audit.setAcao(acaoEnum);
			audit.setCreatedAt(acaoDthora);
			audit.setIpOrigem(enderIp);
			audit.setObjectId(id);
			audit.setObjectType(clazz.getName());
			audit.setUsuario(usuario);
			audit.setEstadoAtual(valorAtual);
			audit.setEstadoAnterior(valorAnterior);
			dao.save(audit);
		}
		
	}

	public Auditoria consultarLog(FiltroAuditoria filtro) throws ClassNotFoundException {
		List<Auditoria> lista = dao.consultarLog(filtro);
		Auditoria aud = null;
		if (lista != null && lista.size() > 0) {
			aud = lista.get(0);
			preencherObjetos(aud);
		}
		
		return aud;

	}

	public Auditoria consultarLog(Integer idLog) throws ClassNotFoundException {
		Auditoria aud = dao.getById(idLog);
		preencherObjetos(aud);
		return aud;
	}

	@SuppressWarnings("unchecked")
	private void preencherObjetos(Auditoria aud) throws ClassNotFoundException {
		Class<Entidade> clazz = (Class<Entidade>) Class.forName(aud.getObjectType());
		Gson gson = new Gson();
		aud.setEntidadeAtual(gson.fromJson(aud.getEstadoAtual(), clazz));
		
		if (aud.getEstadoAnterior() != null) {
			aud.setEntidadeAnterior(gson.fromJson(aud.getEstadoAnterior(), clazz));
		}
	}

	@SuppressWarnings("rawtypes")
	public List<Auditoria> consultarHistorico(Class clazz, Integer idObjeto) {
		return dao.consultarHistorico(clazz.getName(), idObjeto);
	}
	
	@SuppressWarnings("rawtypes")
	public Auditoria getUltimaAcao(Class clazz, Integer idObjeto){
		return dao.getUltimaAcao(clazz.getName(), idObjeto);
	}

	
	public PaginatedList consultarHistorico(FiltroAuditoria filtro, int page) {
		return dao.consultarHistorico(filtro, page, 10);
	}
	
	public List<Auditoria> consultarHistoricoSemPaginacao(FiltroAuditoria filtro) {
		return dao.consultarHistoricoSemPaginacao(filtro);
	}

	public AuditoriaDao getDao() {
		return dao;
	}

}
