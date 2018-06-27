package br.com.lummi.sge.daos;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.hibernate.Session;

import br.com.lummi.sge.models.Entidade;

public class GenericDao<T extends Entidade> {

    @Inject
    private EntityManager entityManager;
	
    protected Class<T> entityClass;

    @SuppressWarnings("unchecked")
    public GenericDao() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass()
                .getGenericSuperclass();
        this.entityClass = ((Class<T>) genericSuperclass
                .getActualTypeArguments()[0]);
    }

    public T save(final T entity) {
    	try{
    		EntityManager em = getEntityManager();
    		em.persist(entity);
    		em.flush();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
        return entity;
    }

    public T getById(final Integer id) {
    	
    	T t = null;
    	
    	try{
    		EntityManager entityManager = getEntityManager();
        t = entityManager.find(getTypeClass(), id);
        
    	}catch(Exception e){
    		e.printStackTrace();
    	}
        
        return t;
    }

    public T update(T entity) {
		EntityManager entityManager = getEntityManager();
        entityManager.merge(entity);
        entityManager.flush();
        return entity;
    }

    public void delete(final T entity) {
		EntityManager entityManager = getEntityManager();
        entityManager.remove(entity);
    }

    @SuppressWarnings("unchecked")
    public List<T> findAll() {
		EntityManager entityManager = getEntityManager();
        return entityManager.createQuery(("FROM " + getTypeClass().getName())).getResultList();
    }

    private Class<T> getTypeClass() {
        return entityClass;
    }

	public Session getSession() {
		return (Session) getEntityManager().getDelegate();
	}

	public EntityManager getEntityManager() {
        return entityManager;
    }

}
