/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.edu.utn.frsf.ofa.jee7.ejemplos.dao;

import ar.edu.utn.frsf.ofa.jee7.ejemplos.dao.util.DAOUtil;
import ar.edu.utn.frsf.ofa.jee7.ejemplos.dao.util.JpaDAO;
import ar.edu.utn.frsf.ofa.jee7.ejemplos.ecompras.model.Cliente;
import ar.edu.utn.frsf.ofa.jee7.ejemplos.ecompras.model.Producto;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Administrador
 */
@Stateless
public class InicializadorEJB {
    
    @Inject @JpaDAO ProductoDAO emPrd;
    @Inject @JpaDAO ClienteDAO  emCli;

    @Inject DAOUtil util;
    
    @Inject Logger logerInit;
    
    public void crearProductos(int cant){
        logerInit.log(Level.INFO," CREAR PRODUCTOS "+cant);
        for(int i=0;i<cant;i++){
            Producto prd = new Producto();
            prd.setTitulo(util.randomString());
            prd.setDescripcion(util.randomString());
            prd.setPrecio(util.precioAleatorio());
            logerInit.log(Level.INFO," Dato prod"+prd.getDescripcion()+" * "+prd.getTitulo()+ " * "+prd.getPrecio());    
            emPrd.addProducto(prd);
        }
    }
    
    public void crearClientes(int cant){
         logerInit.log(Level.INFO," CREAR CLIENTES "+cant);
        for(int i=0;i<cant;i++){
            Cliente cli = new Cliente();
            cli.setNombre(util.randomString());
            cli.setMail("mdomingu@gmail.com");
            cli.setCuit(221231238);
            emCli.addCliente(cli);
        }
    }
}
