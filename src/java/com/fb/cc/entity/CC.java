/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fb.cc.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Francesco
 */
@Entity
@NamedQueries({
    @NamedQuery(name=CC.FIND_ALL,
                query="SELECT c FROM CC c"),
    @NamedQuery(name=CC.FIND_WITH_SALDO_HIGHER_THAN,
                query="SELECT c FROM CC c WHERE c.saldo > :saldo"),
})
public class CC implements Serializable
{
    public static final String FIND_ALL = "CC.findAll";
    
    public static final String FIND_WITH_SALDO_HIGHER_THAN = "CC.findWithSaldoHigherThan";
    
    @Id
    private Integer id;
    
    private Integer saldo;
    
    public CC()
    {
        
    }

    public CC(Integer id, Integer saldo)
    {
        this.id = id;
        this.saldo = saldo;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getSaldo()
    {
        return saldo;
    }

    public void setSaldo(Integer saldo)
    {
        this.saldo = saldo;
    }

    @Override
    public String toString()
    {
        return "CC " + this.id + ": saldo " + this.saldo;
    }
    
}
