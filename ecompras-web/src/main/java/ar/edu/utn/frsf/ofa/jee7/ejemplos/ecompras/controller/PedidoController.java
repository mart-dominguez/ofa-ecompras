/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.edu.utn.frsf.ofa.jee7.ejemplos.ecompras.controller;

import ar.edu.utn.frsf.ofa.jee7.ejemplos.ecompras.model.DetallePedido;
import ar.edu.utn.frsf.ofa.jee7.ejemplos.ecompras.model.Pedido;
import ar.edu.utn.frsf.ofa.jee7.ejemplos.ecompras.model.Producto;
import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Administrador
 */
@Named("pediddoCtrl")
@SessionScoped
public class PedidoController implements Serializable{
    
    private Producto prd;
    private Pedido pedido;

    public String addToOrden(){
        this.inicializarPedido();         
        DetallePedido det = new DetallePedido();
        det.setCantidad(1);
        det.setPedido(getPedido());
        det.setProducto(getPrd());
        det.setMontoTotal(getPrd().getPrecio());
        return null;
    }
    
    private void inicializarPedido(){
        if(this.getPedido() == null) {
            this.setPedido(new Pedido());
            this.getPedido().setDetalle(new ArrayList<DetallePedido>());
        }
    }

    /**
     * @return the prd
     */
    public Producto getPrd() {
        return prd;
    }

    /**
     * @param prd the prd to set
     */
    public void setPrd(Producto prd) {
        this.prd = prd;
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
    
    
}
