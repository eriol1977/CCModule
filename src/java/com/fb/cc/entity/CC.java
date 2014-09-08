/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fb.cc.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Francesco
 */
@Entity
public class CC implements Serializable
{
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
    
}
