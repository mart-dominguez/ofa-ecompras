/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utn.frsf.ofa.jee7.ejemplos.dao;

import ar.edu.utn.frsf.ofa.jee7.ejemplos.ecompras.model.Pedido;
import ar.edu.utn.frsf.ofa.jee7.ejemplos.ecompras.model.Producto;

/**
 *
 * @author Martin
 */
public interface PedidoDAO {

    public Pedido addProducto(Pedido ped,Producto p,int cantidad );
    public void confirmarCompra(Pedido ped );
    
}
