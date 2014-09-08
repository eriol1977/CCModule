/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fb.cc.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Francesco
 */
@Stateless
@Remote(CrudService.class)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class CrudServiceBean implements CrudService
{

    @PersistenceContext
    private EntityManager em;

    @Override
    public <T> T create(T t)
    {
        em.persist(t);
        em.flush();
        em.refresh(t);
        return t;
    }

    @Override
    public <T> T update(T t)
    {
        return em.merge(t);
    }

    @Override
    public <T> void delete(Class<T> type, Object id)
    {
        T reference = em.getReference(type, id);
        em.remove(reference);
    }

    @Override
    public <T> T find(Class<T> type, Object id)
    {
        return em.find(type, id);
    }

    @Override
    public List findByNamedQuery(String queryName)
    {
        return findByNamedQueryPaginated(queryName, 0, 0);
    }

    @Override
    public List findByNamedQuery(String queryName, Map<String, Object> parameters)
    {
        return findByNamedQueryPaginated(queryName, parameters, 0, 0);
    }

    @Override
    public List findByNamedQueryPaginated(String queryName, int firstResult, int resultLimit)
    {
        return findByNamedQueryPaginated(queryName, new HashMap<String, Object>(), firstResult, resultLimit);
    }

    @Override
    public List findByNamedQueryPaginated(String queryName, Map<String, Object> parameters, int firstResult, int resultLimit)
    {
        Query query = em.createNamedQuery(queryName);

        if (firstResult > 0) {
            query.setFirstResult(firstResult);
        }
        if (resultLimit > 0) {
            query.setMaxResults(resultLimit);
        }

        for (Map.Entry<String, Object> entry : parameters.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }

        return query.getResultList();
    }

    @Override
    public Integer countResultsOfNamedQuery(String queryName)
    {
        return countResultsOfNamedQuery(queryName, new HashMap<String, Object>());
    }

    @Override
    public Integer countResultsOfNamedQuery(String queryName, Map<String, Object> parameters)
    {
        Query query = em.createNamedQuery(queryName);
        for (Map.Entry<String, Object> entry : parameters.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
        return query.getResultList().size();
    }

}
