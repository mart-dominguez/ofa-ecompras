/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.edu.utn.frsf.ofa.jee7.ejemplos.dao;

import ar.edu.utn.frsf.ofa.jee7.ejemplos.dao.util.ConexionDB;
import ar.edu.utn.frsf.ofa.jee7.ejemplos.dao.util.Log;
import ar.edu.utn.frsf.ofa.jee7.ejemplos.dao.util.MysqlDAO;
import ar.edu.utn.frsf.ofa.jee7.ejemplos.ecompras.model.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.sql.DataSource;

/**
 *
 * @author Administrador
 */
@RequestScoped
@MysqlDAO
@Log
public class ProductoDAOMysql implements ProductoDAO{
    @Inject @ConexionDB
    private DataSource ds;
    
    @Override
    public void addProducto(Producto prd) {
        Connection conn = null;
        try {
            conn = ds.getConnection();
            PreparedStatement pstm = conn.prepareStatement("INSERT INTO PRODUCTO ( TITULO, DESCRIPCION,PRECIO) VALUES (?,?,?) ");
            pstm.setString(1, prd.getTitulo());
            pstm.setString(2, prd.getDescripcion());
            pstm.setDouble(3, prd.getPrecio());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAOMysql.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
             try {
                 if(conn!=null)conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductoDAOMysql.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void actualizarProducto(Producto prd) {
 Connection conn = null;
        try {
            conn = ds.getConnection();
            PreparedStatement pstm = conn.prepareStatement("UPDATE PRODUCTO SET TITULO = ?, DESCRIPCION = ? ,PRECIO = ? WHERE  ID = ?");
            pstm.setString(1, prd.getTitulo());
            pstm.setString(2, prd.getDescripcion());
            pstm.setDouble(3, prd.getPrecio());
            pstm.setInt(4, prd.getId());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAOMysql.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
             try {
                 if(conn!=null)conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductoDAOMysql.class.getName()).log(Level.SEVERE, null, ex);
            }
        }    }

    @Override
    public void borrarProducto(int id) {
 Connection conn = null;
        try {
            conn = ds.getConnection();
            PreparedStatement pstm = conn.prepareStatement("DELETE FROM PRODUCTO WHERE ID = ?");
            pstm.setInt(1, id);
            pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAOMysql.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
             try {
                 if(conn!=null)conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductoDAOMysql.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public List<Producto> buscar() {
         Connection conn = null;
         List<Producto> listaResultado = new ArrayList<>();
        try {
            conn = ds.getConnection();
            PreparedStatement pstm = conn.prepareStatement("SELECT ID,TITULO,DESCRIPCION,PRECIO FROM PRODUCTO ");
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                Producto prdAux = new Producto();
                prdAux.setId(rs.getInt("ID"));
                prdAux.setTitulo(rs.getString("TITULO"));
                prdAux.setDescripcion(rs.getString("DESCRIPCION"));
                prdAux.setPrecio(rs.getDouble("PRECIO"));
                listaResultado.add(prdAux);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAOMysql.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
             try {
                 if(conn!=null)conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductoDAOMysql.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaResultado;
    }

    @Override
    public Producto buscar(int id) {
Connection conn = null;
         Producto prdResultado = null;
        try {
            conn = ds.getConnection();
            PreparedStatement pstm = conn.prepareStatement("SELECT ID,TITULO,DESCRIPCION,PRECIO FROM PRODUCTO WHERE ID = ?");
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                prdResultado = new Producto();
                prdResultado.setId(rs.getInt("ID"));
                prdResultado.setTitulo(rs.getString("TITULO"));
                prdResultado.setDescripcion(rs.getString("DESCRIPCION"));
                prdResultado.setPrecio(rs.getDouble("PRECIO"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAOMysql.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
             try {
                 if(conn!=null)conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductoDAOMysql.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return prdResultado;    
    }

    @Override
    public Producto buscar(String nombre) {
        Connection conn = null;
         List<Producto> listaResultado = new ArrayList<>();
        try {
            conn = ds.getConnection();
            PreparedStatement pstm = conn.prepareStatement("SELECT ID,TITULO,DESCRIPCION,PRECIO FROM PRODUCTO WHERE NOMBRE LIKE '%'");
            pstm.setString(1, nombre);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                Producto prdAux = new Producto();
                prdAux.setId(rs.getInt("ID"));
                prdAux.setTitulo(rs.getString("TITULO"));
                prdAux.setDescripcion(rs.getString("DESCRIPCION"));
                prdAux.setPrecio(rs.getDouble("PRECIO"));
                listaResultado.add(prdAux);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAOMysql.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
             try {
                 if(conn!=null)conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductoDAOMysql.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaResultado.get(0);    
    }
    
}
