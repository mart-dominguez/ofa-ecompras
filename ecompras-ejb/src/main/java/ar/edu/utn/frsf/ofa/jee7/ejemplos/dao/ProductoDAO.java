/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.edu.utn.frsf.ofa.jee7.ejemplos.dao;

import ar.edu.utn.frsf.ofa.jee7.ejemplos.ecompras.model.Producto;
import java.util.List;
/**
 *
 * @author Administrador
 */
public interface ProductoDAO {
    public void addProducto(Producto prd);
    public void actualizarProducto(Producto prd);
    public void borrarProducto(int id);
    public List<Producto> buscar();
    public Producto buscar(int id);
    public Producto buscar(String nombre);
}
