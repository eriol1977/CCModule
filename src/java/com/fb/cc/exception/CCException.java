/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fb.cc.exception;

import javax.ejb.ApplicationException;

/**
 *
 * @author Francesco
 */
@ApplicationException(rollback = true)
public class CCException extends Exception
{
    private String method;
    
    public CCException(final String msg, final String method)
    {
        super(msg);
        this.method = method;
    }

    public String getMethod()
    {
        return method;
    }
    
}
