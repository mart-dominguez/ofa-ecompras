/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utn.frsf.ofa.jee7.ejemplos.dao;

import ar.edu.utn.frsf.ofa.jee7.ejemplos.ecompras.model.Cliente;
import ar.edu.utn.frsf.ofa.jee7.ejemplos.ecompras.model.Pedido;
import ar.edu.utn.frsf.ofa.jee7.ejemplos.ecompras.model.Producto;
import java.util.List;

/**
 *
 * @author Martin
 */
public interface ClienteDAO {
   public void addCliente(Cliente cli);
    public void actualizarCliente(Cliente cli);
    public void borrarCliente(int id);
    public List<Cliente> buscar();
    public Cliente buscar(int id);
    public Cliente buscar(String nombre);}
