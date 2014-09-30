/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.edu.utn.frsf.ofa.jee7.ejemplos.dao;

import ar.edu.utn.frsf.ofa.jee7.ejemplos.dao.util.BaseProduccion;
import ar.edu.utn.frsf.ofa.jee7.ejemplos.dao.util.DaoJPA;
import ar.edu.utn.frsf.ofa.jee7.ejemplos.ecompras.model.Producto;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

/**
 *
 * @author Martin
 */

@Named("productoDAOJpa")
@DaoJPA
@RequestScoped
@Default
public class ProductoDAOJpa implements ProductoDAO{

    @Inject @BaseProduccion
    private EntityManager em;
    
    @Override
    public void addProducto(Producto prd) {
        em.persist(prd);
    }

    @Override
    public List<Producto> buscar() {
        return em.createQuery("SELECT p FROM Producto p").getResultList();
    }

    @Override
    public Producto buscar(int id) {
        return em.find(Producto.class,id);
    }

    @Override
    public List<Producto> buscar(String nombre) {
        return em.createQuery("SELECT p FROM Producto p WHERE p.titulo like :p").setParameter("p", nombre).getResultList();
    }
    
}
