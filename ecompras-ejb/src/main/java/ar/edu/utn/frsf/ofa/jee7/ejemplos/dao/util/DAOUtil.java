/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.edu.utn.frsf.ofa.jee7.ejemplos.dao.util;

import javax.annotation.Resource;
import javax.enterprise.inject.Produces;
import javax.sql.DataSource;

/**
 *
 * @author Administrador
 */
public class DAOUtil {

   @Produces @ConexionDB
   @Resource(lookup="java:global/env/jdbc/CustomerDatasource")
   DataSource conexion;
   
}
