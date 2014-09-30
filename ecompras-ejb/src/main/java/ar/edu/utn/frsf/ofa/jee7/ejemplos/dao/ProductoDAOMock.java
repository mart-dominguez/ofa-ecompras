/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utn.frsf.ofa.jee7.ejemplos.dao;

import ar.edu.utn.frsf.ofa.jee7.ejemplos.ecompras.model.Producto;
import java.util.ArrayList;
import java.util.List;
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
    
    @PostConstruct
    public void init(){
        this._dummyList = new ArrayList<>();
    }
    
    @Override
    public void addProducto(Producto prd){
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
    public List<Producto> buscar(String nombre) {
        return this._dummyList;
    }
}
