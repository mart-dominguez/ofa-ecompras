/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.edu.utn.frsf.ofa.jee7.ejemplos.dao.util;


import ar.edu.utn.frsf.ofa.jee7.ejemplos.ecompras.model.Producto;
import java.util.Random;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

/**
 *
 * @author Administrador
 */
@Dependent
public class DAOUtil {
    private static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

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

    @Produces  @NombreProducto
    public String randomString() {
        Random rnd = new Random();
        int len = 10 + rnd.nextInt(40);
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        }
        return sb.toString();
    }

    @Produces  @PrecioProducto
    public Double precioAleatorio() {
        Random rnd = new Random();
        return rnd.nextDouble() * (10+rnd.nextInt(990));
    }

    /**
     *
     * @param precio
     * @param nom
     * @return
     */
    @Produces @NuevoProducto 
    public Producto crearProducto( @PrecioProducto Double precio,  @NombreProducto String nom){
        Producto p = new Producto();
        p.setTitulo(nom);
        p.setDescripcion(nom+" ** "+nom);
        p.setPrecio(precio);
        return p;
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

