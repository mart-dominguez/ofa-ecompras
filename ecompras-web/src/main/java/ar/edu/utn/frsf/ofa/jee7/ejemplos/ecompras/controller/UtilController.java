/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utn.frsf.ofa.jee7.ejemplos.ecompras.controller;

import ar.edu.utn.frsf.ofa.jee7.ejemplos.ecompras.model.Cliente;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

/**
 *
 * @author Administrador
 */
public class UtilController {
    
    @Produces @ApplicationScoped 
    public Cliente getCliente(){
        Cliente cli = new Cliente();
        cli.setCuit(20123423);
        cli.setNombre("Martin");
        cli.setMail("mdominguez@mail.com");
        return cli;
    }
}
