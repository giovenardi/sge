package br.com.lummi.sge.daos;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.ibm.icu.util.Calendar;

import br.com.lummi.sge.daos.helpers.QueryPaginator;
import br.com.lummi.sge.filtros.FiltroAuditoria;
import br.com.lummi.sge.models.PaginatedList;
import br.com.lummi.sge.models.global.Auditoria;
/**
 * 
 * @author luiz.giovenardi
 *
 */
public class AuditoriaDao extends GenericDao<Auditoria>{

	@Inject
	private QueryPaginator queryPaginator;
	
	@SuppressWarnings("unchecked")
	public List<Auditoria> consultarLog(FiltroAuditoria filtro) {
		Query query = getEntityManager().createQuery(
				new StringBuffer("from Auditoria a where a.usuario.id = :usuarioId ")
				.append("and a.acao = :acao ")
				.append("and a.objectId = :objetoId and a.createdAt = :dataHora").toString());
		query.setParameter("usuarioId", filtro.getUsuario().getId());
		query.setParameter("acao", filtro.getAcao());
		query.setParameter("objetoId", filtro.getIdObjeto());
		query.setParameter("dataHora", filtro.getDataHora());
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Auditoria> consultarHistorico(String nomeClasse, Integer idObjeto) {
		Query query = getEntityManager().createQuery(
				new StringBuffer("from Auditoria a where a.objectId = :objetoId and a.objectType = :nomeClasse order by createdAt DESC").toString());
		query.setParameter("objetoId", idObjeto);
		query.setParameter("nomeClasse", nomeClasse);
		return query.getResultList();
	}

	public Auditoria getUltimaAcao(String nomeClasse, Integer idObjeto) {
		Query query = getEntityManager().createQuery(
				new StringBuffer("from Auditoria a "
						+ " where a.objectId = :objetoId "
						+ "   and a.objectType = :nomeClasse "
						+ "   ORDER BY a.id DESC").toString());
		query.setParameter("objetoId", idObjeto);
		query.setParameter("nomeClasse", nomeClasse);
		Auditoria auditoria = null;
		try {
			auditoria = (Auditoria) query.setMaxResults(1).getSingleResult();	
		} catch (NoResultException e) {
			
		} 
		return  auditoria;
	}
	
	public PaginatedList consultarHistorico(FiltroAuditoria filtro,
			int page, int max) {
		Criteria criteria = obterCriteria(filtro);
        return queryPaginator.list(Auditoria.class, criteria, page, max, Order.desc("createdAt"));

	}

	@SuppressWarnings("unchecked")
	public List<Auditoria> consultarHistoricoSemPaginacao(FiltroAuditoria filtro) {
		Criteria criteria = obterCriteria(filtro);
        return criteria.addOrder(Order.desc("createdAt")).list();

	}

	private Criteria obterCriteria(FiltroAuditoria filtro) {
		Criteria criteria = getSession().createCriteria(Auditoria.class)
				.add(Restrictions.eq("objectType", filtro.getObjectType()))
				.add(Restrictions.eq("objectId", filtro.getIdObjeto()));
			if (filtro.getAcao() != null) {
				criteria.createAlias("acao", "acao").add(Restrictions.eq("acao.id", filtro.getAcao()));
			}
			if (filtro.getUsuario() != null && filtro.getUsuario().getNome() != null && !filtro.getUsuario().getNome().trim().isEmpty()) {
				criteria.createAlias("usuario", "usuario").add(Restrictions.ilike("usuario.nome", filtro.getUsuario().getNome()+"%"));
			}
			if (filtro.getDataInicio() != null) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(filtro.getDataInicio());
                calendar.set(Calendar.HOUR, 0);
                calendar.set(Calendar.MINUTE, 0);
                calendar.set(Calendar.SECOND, 0);
                calendar.set(Calendar.MILLISECOND, 0);
                criteria.add(Restrictions.ge("createdAt", calendar.getTime()));
			}
			if (filtro.getDataFim() != null) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(filtro.getDataFim());
                calendar.set(Calendar.HOUR, 23);
                calendar.set(Calendar.MINUTE, 59);
                calendar.set(Calendar.SECOND, 59);
                calendar.set(Calendar.MILLISECOND, 999);
                criteria.add(Restrictions.le("createdAt", calendar.getTime()));
			}
		return criteria;
	}
	
	
	
}
