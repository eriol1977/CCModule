/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fb.cc.bean;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Francesco
 */
public interface CrudService
{
    <T> T create(T t);
    
    <T> T update(T t);
    
    <T> void delete(Class<T> type, Object id);
    
    <T> T find(Class<T> type, Object id);
    
    List findByNamedQuery(String queryName);
    
    List findByNamedQuery(String queryName, Map<String, Object> parameters);
    
    List findByNamedQueryPaginated(String queryName, int firstResult, int resultLimit);
    
    List findByNamedQueryPaginated(String queryName, Map<String, Object> parameters, int firstResult, int resultLimit);
    
    Integer countResultsOfNamedQuery(String queryName);
    
    Integer countResultsOfNamedQuery(String queryName, Map<String, Object> parameters);
}
