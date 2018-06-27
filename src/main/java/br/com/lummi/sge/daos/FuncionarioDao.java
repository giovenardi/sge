package br.com.lummi.sge.daos;

import java.util.List;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import br.com.lummi.sge.models.Funcionario;

public class FuncionarioDao extends GenericDao<Funcionario> {

	@SuppressWarnings("unchecked")
	@Override
	public List<Funcionario> findAll(String orderColumn) {
		return getSession()
				.createCriteria(Funcionario.class)
				.createAlias("pessoa", "pessoa")
				.addOrder(Order.asc("pessoa.nome"))
				.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Funcionario> getCaptadores() {
		return getSession().createCriteria(Funcionario.class)
				.createAlias("pessoa", "pessoa")
				.createAlias("cargo", "cargo")
				.add(Restrictions.eq("cargo.captador", true))
				.addOrder(Order.asc("pessoa.nome"))
				.list();
	}

	@SuppressWarnings("unchecked")
	public List<Funcionario> getVendedores() {
		return getSession().createCriteria(Funcionario.class)
				.createAlias("pessoa", "pessoa")
				.createAlias("cargo", "cargo")
				.add(Restrictions.eq("cargo.vendedor", true))
				.addOrder(Order.asc("pessoa.nome"))
				.list();
	}

	@SuppressWarnings("unchecked")
	public List<Funcionario> getGerentes() {
		return getSession().createCriteria(Funcionario.class)
				.createAlias("pessoa", "pessoa")
				.createAlias("cargo", "cargo")
				.add(Restrictions.eq("cargo.gerente", true))
				.addOrder(Order.asc("pessoa.nome"))
				.list();
	}

	/**
	 * @param id
	 * @return
	 */
	public Integer buscarPorIdPessoa(Integer id) {
		return ((Number)getSession().createCriteria(Funcionario.class)
				.createAlias("pessoa", "pessoa")
				.add(Restrictions.eq("pessoa.id", id))
				.setProjection(Projections.count("id"))
				.uniqueResult()).intValue();
	}

}
