/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.edu.utn.frsf.ofa.jee7.ejemplos.ecompras.controller;

import ar.edu.utn.frsf.ofa.jee7.ejemplos.dao.ProductoDAO;
import ar.edu.utn.frsf.ofa.jee7.ejemplos.dao.util.DaoJPA;
import ar.edu.utn.frsf.ofa.jee7.ejemplos.ecompras.model.Producto;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Administrador
 */
@Named("vtaCtrl")
@SessionScoped
public class VentasController implements Serializable{
    private double precioMinimo;
    private double precioMaximo;
    private String texto;
    
    @Inject @DaoJPA
    private ProductoDAO productoLogica; 
    
    private List<Producto> producto;
    
    @PostConstruct
    public void init(){
        System.out.println(" NUEVO "+System.currentTimeMillis());
        this.precioMaximo=999999.0;
        this.precioMinimo=0.0;
    }
    
    public String buscar(){
        this.producto = productoLogica.buscar(this.texto, this.precioMinimo, this.precioMaximo);
        return null;
    }

    /**
     * @return the precioMinimo
     */
    public double getPrecioMinimo() {
        return precioMinimo;
    }

    /**
     * @param precioMinimo the precioMinimo to set
     */
    public void setPrecioMinimo(double precioMinimo) {
        this.precioMinimo = precioMinimo;
    }

    /**
     * @return the precioMaximo
     */
    public double getPrecioMaximo() {
        return precioMaximo;
    }

    /**
     * @param precioMaximo the precioMaximo to set
     */
    public void setPrecioMaximo(double precioMaximo) {
        this.precioMaximo = precioMaximo;
    }

    /**
     * @return the texto
     */
    public String getTexto() {
        return texto;
    }

    /**
     * @param texto the texto to set
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }

    /**
     * @return the producto
     */
    public List<Producto> getProducto() {
        return producto;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(List<Producto> producto) {
        this.producto = producto;
    }
}
