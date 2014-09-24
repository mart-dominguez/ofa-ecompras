/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.edu.utn.frsf.ofa.jee7.ejemplos.ecompras.model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class Pedido {
    private int id;
    private int nro;
    private Date fechaPedido;
    private List<DetallePedido> detalle;
    private Cliente cliente;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nro
     */
    public int getNro() {
        return nro;
    }

    /**
     * @param nro the nro to set
     */
    public void setNro(int nro) {
        this.nro = nro;
    }

    /**
     * @return the fechaPedido
     */
    public Date getFechaPedido() {
        return fechaPedido;
    }

    /**
     * @param fechaPedido the fechaPedido to set
     */
    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    /**
     * @return the detalle
     */
    public List<DetallePedido> getDetalle() {
        return detalle;
    }

    /**
     * @param detalle the detalle to set
     */
    public void setDetalle(List<DetallePedido> detalle) {
        this.detalle = detalle;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
}
