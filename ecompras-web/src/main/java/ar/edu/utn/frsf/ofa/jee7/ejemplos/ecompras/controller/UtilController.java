/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utn.frsf.ofa.jee7.ejemplos.ecompras.controller;

import ar.edu.utn.frsf.ofa.jee7.ejemplos.ecompras.model.Cliente;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;

/**
 *
 * @author Administrador
 */
@Dependent
public class UtilController {
    private static final Cliente _CLI = new Cliente(); 
    
    static {
        _CLI.setCuit(20123423);
        _CLI.setNombre("Martin");
        _CLI.setMail("mdominguez@mail.com");
    }
    
    @Produces 
    public Cliente getCliente(){
        return UtilController._CLI;
    }
}
