/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utn.frsf.ofa.jee7.ejemplos.ecompras.controller;

import ar.edu.utn.frsf.ofa.jee7.ejemplos.dao.PedidoDAO;
import ar.edu.utn.frsf.ofa.jee7.ejemplos.dao.util.DaoJPA;
import ar.edu.utn.frsf.ofa.jee7.ejemplos.ecompras.model.Pedido;
import ar.edu.utn.frsf.ofa.jee7.ejemplos.ecompras.model.Producto;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Martin
 */
@Named("compraCtrl")
@SessionScoped
public class OrdenCompraController implements Serializable{
    private Pedido pedido;
    private Producto producto;   
    private int cantidad;
    
    @Inject @DaoJPA
    private PedidoDAO pedidoDao;
    
    public String hacerPedido(){
        return "pedido";
    }
    
    public String agregarProducto(){
        if(pedido == null) pedido = new Pedido();
        this.pedido = pedidoDao.addProducto(pedido, producto, cantidad);
        return null;
    }

    public String confirmarPedido(){
        pedidoDao.confirmarCompra(pedido);
        return null;
    }

    /**
     * @return the pedido
     */
    public Pedido getPedido() {
        return pedido;
    }

    /**
     * @param pedido the pedido to set
     */
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
    /**
     * @return the producto
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
