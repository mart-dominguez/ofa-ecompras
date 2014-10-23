/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utn.frsf.ofa.jee7.ejemplos.dao;

import ar.edu.utn.frsf.ofa.jee7.ejemplos.dao.util.ConexionDB;
import ar.edu.utn.frsf.ofa.jee7.ejemplos.dao.util.JpaDAO;
import ar.edu.utn.frsf.ofa.jee7.ejemplos.dao.util.Log;
import ar.edu.utn.frsf.ofa.jee7.ejemplos.ecompras.model.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

/**
 *
 * @author Martin
 */
@RequestScoped
@JpaDAO
@Transactional(Transactional.TxType.REQUIRES_NEW)
public class ProductoDAOJpa implements ProductoDAO {

    @Inject @ConexionDB
    private EntityManager em;
    @Override
    public void addProducto(Producto prd) {
        em.persist(prd);
    }

    @Override
    public void actualizarProducto(Producto prd) {
        em.merge(prd);
    }

    @Override
    public void borrarProducto(int id) {
        Producto aux = em.find(Producto.class, id);
        em.remove(aux);
    }

    @Override
    public List<Producto> buscar() {
        List<Producto> aux = new ArrayList<Producto>();
        try{
        aux = em.createQuery("SELECT p FROM Producto p").getResultList();
        }catch(Exception e){
            e.printStackTrace();
        }
        return aux;
    }

    @Override
    public Producto buscar(int id) {
        return (Producto) em.createQuery("SELECT p FROM Producto p WHERE p.id = :pId").setParameter("pId", id).getSingleResult();
    }

    @Override
    public Producto buscar(String nombre) {
        return (Producto) em.createQuery("SELECT p FROM Producto p WHERE p.titulo = :tit").setParameter("tit", nombre).getSingleResult();
    }
    
}
