/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utn.frsf.ofa.jee7.ejemplos.dao;

import ar.edu.utn.frsf.ofa.jee7.ejemplos.ecompras.model.Producto;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.inject.Named;

/**
 *
 * @author martin
 */
@Named("productoDAO")
@ApplicationScoped
@Default
public class ProductoDAOMock implements ProductoDAO{

    private List<Producto> _dummyList;
    private int generadorID=0;
    
    @PostConstruct
    public void init(){
        this._dummyList = new ArrayList<>();
    }
    
    @Override
    public void actualizarProducto(Producto prd){
    Logger.getLogger("LOG_PRODUCTO").log(Level.INFO, "ID PRODUCTO: "+prd.getId());
    Logger.getLogger("LOG_PRODUCTO").log(Level.INFO, "ID PRODUCTO: "+this._dummyList);
        this._dummyList.remove(prd);        
    Logger.getLogger("LOG_PRODUCTO").log(Level.INFO, "ID PRODUCTO: "+this._dummyList);
        this._dummyList.add(prd);
    Logger.getLogger("LOG_PRODUCTO").log(Level.INFO, "ID PRODUCTO: "+this._dummyList);
    }

    @Override
    public void addProducto(Producto prd){
        prd.setId(++generadorID);
        this._dummyList.add(prd);
    }

    @Override
    public List<Producto> buscar() {
        return this._dummyList;
    }

    @Override
    public Producto buscar(int id) {
        Producto prdBuscado = new Producto();
        prdBuscado.setId(id);
        int indiceBuscado = this._dummyList.indexOf(prdBuscado);
        return this._dummyList.get(indiceBuscado);
    }

    @Override
    public Producto buscar(String nombre) {
        return this._dummyList.get(0);
    }

    @Override
    public void borrarProducto(int id) {
        Producto aux = new Producto();
        aux.setId(id);
        this._dummyList.remove(aux);
    }
}
