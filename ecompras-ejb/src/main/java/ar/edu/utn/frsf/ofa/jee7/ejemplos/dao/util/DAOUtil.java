/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.edu.utn.frsf.ofa.jee7.ejemplos.dao.util;

import javax.annotation.Resource;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
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
   
}
