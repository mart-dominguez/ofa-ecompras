/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.edu.utn.frsf.ofa.jee7.ejemplos.dao;

import ar.edu.utn.frsf.ofa.jee7.ejemplos.dao.util.ConexionDB;
import ar.edu.utn.frsf.ofa.jee7.ejemplos.dao.util.NuevoProducto;
import ar.edu.utn.frsf.ofa.jee7.ejemplos.ecompras.model.Producto;
import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author Administrador
 */
@Stateless
@Dependent
public class IniciarCliente {
    
    @Inject @NuevoProducto Producto prd;
    
    
    @Inject @ConexionDB
    private EntityManager em;
     
    public void crearProducto(){
        em.persist(prd);
    }

    public void crearProducto(Producto prd){
        em.persist(prd);
    }

}
