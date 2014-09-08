/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fb.cc.bean;

import com.fb.cc.entity.CC;
import com.fb.cc.exception.CCException;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

/**
 *
 * @author Francesco
 */
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class CCRemoteAccessWithBMT implements CCRemoteAccess
{

    @PersistenceContext
    private EntityManager em;
    
    @Resource
    private UserTransaction ut;

    @Override
    public CC selecionarContaCorrente(Integer id)
    {
        return em.find(CC.class, id);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void incluirContaCorrente(CC conta) throws CCException, Exception
    {
        ut.begin();
        em.merge(conta);
        ut.commit();
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void efetuarTransferencia(CC origem, CC destino, Integer valor) throws CCException, Exception
    {
        ut.begin();
        try {
            origem.setSaldo(origem.getSaldo()-valor);
            em.merge(origem);
            destino.setSaldo(destino.getSaldo()+valor);
            em.merge(destino);
        } catch (Exception e) {
            ut.rollback();
            throw new CCException(e.getMessage(), "BMT");
        }
        ut.commit();
    }

}
