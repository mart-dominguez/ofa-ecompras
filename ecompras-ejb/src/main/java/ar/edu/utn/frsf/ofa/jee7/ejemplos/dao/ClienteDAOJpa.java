/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utn.frsf.ofa.jee7.ejemplos.dao;

import ar.edu.utn.frsf.ofa.jee7.ejemplos.dao.util.ConexionDB;
import ar.edu.utn.frsf.ofa.jee7.ejemplos.dao.util.JpaDAO;
import ar.edu.utn.frsf.ofa.jee7.ejemplos.dao.util.Log;
import ar.edu.utn.frsf.ofa.jee7.ejemplos.ecompras.model.Cliente;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
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
@Log
public class ClienteDAOJpa implements ClienteDAO {

    @Inject @ConexionDB
    private EntityManager em;
    @Override
    public void addCliente(Cliente prd) {
        em.persist(prd);
    }

    @Override
    public void actualizarCliente(Cliente prd) {
        em.merge(prd);
    }

    @Override
    public void borrarCliente(int id) {
        Cliente aux = em.find(Cliente.class, id);
        em.remove(aux);
    }

    @Override
    public List<Cliente> buscar() {
        List<Cliente> aux = new ArrayList<Cliente>();
        try{
        aux = em.createQuery("SELECT p FROM Cliente p").getResultList();
        }catch(Exception e){
            e.printStackTrace();
        }
        return aux;
    }

    @Override
    public Cliente buscar(int id) {
        return (Cliente) em.createQuery("SELECT p FROM Cliente p WHERE p.id = :pId").setParameter("pId", id).getSingleResult();
    }

    @Override
    public Cliente buscar(String nombre) {
        return (Cliente) em.createQuery("SELECT p FROM Cliente p WHERE p.titulo = :tit").setParameter("tit", nombre).getSingleResult();
    }
    
    @Produces 
    public Cliente findAny(){
        Integer l = 0;
        try{
            l = ((Long) em.createQuery("SELECT COUNT(c) FROM Cliente c").getSingleResult()).intValue();
        }catch(Exception e){
            e.printStackTrace();
        }
        Random r = new Random();        
        int idAny = r.nextInt(l+1);
        return em.find(Cliente.class, idAny);
    }
}
