/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.edu.utn.frsf.ofa.jee7.ejemplos.ecompras.controller;

import ar.edu.utn.frsf.ofa.jee7.ejemplos.dao.ProductoDAO;
import ar.edu.utn.frsf.ofa.jee7.ejemplos.ecompras.model.Producto;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Administrador
 */
@Named("prodcutoCtrl")
@ViewScoped
public class ProductoController implements Serializable{
    
    @Inject 
    private ProductoDAO productoLogica; 
    
    private Producto producto;
    
    @PostConstruct
    public void init(){
        System.out.println(" NUEVO "+System.currentTimeMillis());
    }
    
    public String nuevo(){
        this.setProducto(new Producto());
        return null;
    }
    
    public String guardar(){
        this.productoLogica.addProducto(producto);
        this.producto =null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se Guardo", "Se guardo el producto"));
        return null;
    }

    /**
     * @return the producto
     */
    public Producto getProducto() {
        return producto;
    }

    public List<Producto> getLista(){
        return this.productoLogica.buscar();
    }
    
    /**
     * @param producto the producto to set
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
