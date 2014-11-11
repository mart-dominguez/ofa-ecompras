/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utn.frsf.ofa.jee7.ejemplos.dao;

import ar.edu.utn.frsf.ofa.jee7.ejemplos.dao.util.ConexionDB;
import ar.edu.utn.frsf.ofa.jee7.ejemplos.dao.util.JpaDAO;
import ar.edu.utn.frsf.ofa.jee7.ejemplos.ecompras.model.Pedido;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

/**
 *
 * @author Martin
 */
@Stateless
@Default
public class PedidoDAOJpa implements PedidoDAO{

     @Inject @ConexionDB
    private EntityManager em;
     
    @Override
    public void confirmarPedido(Pedido p) {
        em.persist(p);
    }
    
}
