/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.edu.utn.frsf.ofa.jee7.ejemplos.dao;

import ar.edu.utn.frsf.ofa.jee7.ejemplos.dao.util.BaseProduccion;
import ar.edu.utn.frsf.ofa.jee7.ejemplos.dao.util.DaoJPA;
import ar.edu.utn.frsf.ofa.jee7.ejemplos.ecompras.model.DetallePedido;
import ar.edu.utn.frsf.ofa.jee7.ejemplos.ecompras.model.Pedido;
import ar.edu.utn.frsf.ofa.jee7.ejemplos.ecompras.model.Producto;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

/**
 *
 * @author Martin
 */

@Named("pedidoDaoJPA")
@RequestScoped
@DaoJPA
@Transactional
public class PedidoDAOJpa implements PedidoDAO{

    @Inject @BaseProduccion
    private EntityManager em;

    @Override
    public Pedido addProducto(Pedido ped,Producto p, int cantidad) {
        DetallePedido det = new DetallePedido();
        det.setCantidad(cantidad);
        det.setProducto(p);
        ped.addDetalle(det);
        return ped;
    }

    @Override
    public void confirmarCompra(Pedido ped) {
        this.em.persist(ped);
    }
    

    
}
