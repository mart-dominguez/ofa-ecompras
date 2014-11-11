/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.edu.utn.frsf.ofa.jee7.ejemplos.ecompras.controller;

import ar.edu.utn.frsf.ofa.jee7.ejemplos.dao.PedidoDAO;
import ar.edu.utn.frsf.ofa.jee7.ejemplos.dao.util.Log;
import ar.edu.utn.frsf.ofa.jee7.ejemplos.ecompras.model.Cliente;
import ar.edu.utn.frsf.ofa.jee7.ejemplos.ecompras.model.DetallePedido;
import ar.edu.utn.frsf.ofa.jee7.ejemplos.ecompras.model.Pedido;
import ar.edu.utn.frsf.ofa.jee7.ejemplos.ecompras.model.Producto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
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
    private int idDetalleSeleccionado;
    private @Inject Cliente cli;
    
    @Inject  
    transient Logger log;

    @Inject
    private PedidoDAO pedidoDAO;
    
    public String comprar(){
        pedidoDAO.confirmarPedido(pedido);
        return "inicio";
    }
    
    public String addToOrden(){
        log.log(Level.INFO, "add to orden "+this.prd);
        this.inicializarPedido();         
        DetallePedido det = new DetallePedido();
        det.setCantidad(1);
        det.setPedido(getPedido());
        det.setProducto(getPrd());
        det.setMontoTotal(getPrd().getPrecio());
        this.pedido.getDetalle().add(det);
        return null;
    }
    
    public String unoMas(){
        DetallePedido pd = this.pedido.getDetalle().get(idDetalleSeleccionado);
        int x = pd.getCantidad() +1;
        pd.setCantidad(x);
        pd.setMontoTotal(x*pd.getProducto().getPrecio());
        return null;
    }
    
    public String unoMenos(){
        DetallePedido pd = this.pedido.getDetalle().get(idDetalleSeleccionado);
        int x = pd.getCantidad() -1;
        pd.setCantidad(x);
        pd.setMontoTotal(x*pd.getProducto().getPrecio());
        return null;
    }

    private void inicializarPedido(){
        if(this.getPedido() == null) {
            this.setPedido(new Pedido());
            this.pedido.setCliente(cli);
            this.pedido.setFechaPedido(new Date());
            Random r =new Random();
            this.pedido.setNro(r.nextInt(100000));
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

    /**
     * @return the idDetalleSeleccionado
     */
    public int getIdDetalleSeleccionado() {
        return idDetalleSeleccionado;
    }

    /**
     * @param idDetalleSeleccionado the idDetalleSeleccionado to set
     */
    public void setIdDetalleSeleccionado(int idDetalleSeleccionado) {
        this.idDetalleSeleccionado = idDetalleSeleccionado;
    }
    
    
}
