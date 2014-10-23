/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.edu.utn.frsf.ofa.jee7.ejemplos.dao.util;


import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

/**
 *
 * @author Administrador
 */
@Dependent
public class DAOUtil {

   @Produces @ConexionDB
   @Resource(lookup="jdbc/compras")
   private DataSource conexion;

   @Produces @ConexionDB
   @PersistenceContext(unitName = "compras_PU")
   private EntityManager em;
   
    @Produces   
    public Logger produceLog(InjectionPoint injectionPoint) {   
        return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());   
    }
    /**
     * @return the conexion
     */
    public DataSource getConexion() {
        return conexion;
    }

    /**
     * @param conexion the conexion to set
     */
    public void setConexion(DataSource conexion) {
        this.conexion = conexion;
    }

    /**
     * @return the em
     */
    public EntityManager getEm() {
        return em;
    }

    /**
     * @param em the em to set
     */
    public void setEm(EntityManager em) {
        this.em = em;
    }
   
}

