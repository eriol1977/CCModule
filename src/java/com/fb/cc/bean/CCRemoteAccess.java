/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fb.cc.bean;

import com.fb.cc.entity.CC;
import com.fb.cc.exception.CCException;
import javax.ejb.Remote;

/**
 *
 * @author Francesco
 */
@Remote
public interface CCRemoteAccess
{

    CC selecionarContaCorrente(final Integer id);

    void incluirContaCorrente(CC conta) throws CCException, Exception;

    void efetuarTransferencia(CC origem, CC destino, Integer valor) throws CCException, Exception;
}
