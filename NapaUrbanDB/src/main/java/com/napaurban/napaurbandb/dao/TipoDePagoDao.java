/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.napaurban.napaurbandb.dao;

import com.napaurban.napaurbandb.models.Proveedores;
import com.napaurban.napaurbandb.models.TipoDePago;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 54113
 */
public class TipoDePagoDao {
    public void agregar(TipoDePago tdp) {
        try {
            String baseDeDatos = "napaurbandb";
            String usuario = "root";
            String password = "";
            String host = "localhost";
            String puerto = "3306";
            String driver = "com.mysql.jdbc.Driver";
            String conexionUrl = "jdbc:mysql://" + host + ":" + puerto + "/" + baseDeDatos + "?useSLL=false";
            
            Connection conexion = null;
            
            try {
                Class.forName(driver);
                conexion = DriverManager.getConnection(conexionUrl, usuario, password);
            } catch (Exception ex) {
                Logger.getLogger(TipoDePagoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String sql = "INSERT INTO `tipo_de_pago`(`id`, `nombre`) VALUES (NULL,'"+tdp.getNombre()+"')";
            System.out.println(sql);
            Statement statement = conexion.createStatement();
            statement.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(TipoDePagoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<TipoDePago> listar() {
        List<TipoDePago> listado = new ArrayList<>();
        try {
            String baseDeDatos = "napaurbandb";
            String usuario = "root";
            String password = "";
            String host = "localhost";
            String puerto = "3306";
            String driver = "com.mysql.jdbc.Driver";
            String conexionUrl = "jdbc:mysql://" + host + ":" + puerto + "/" + baseDeDatos + "?useSLL=false";
            
            Connection conexion = null;
            
            try {
                Class.forName(driver);
                conexion = DriverManager.getConnection(conexionUrl, usuario, password);
            } catch (Exception ex) {
                Logger.getLogger(TipoDePagoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String sql = "SELECT * FROM `tipo_de_pago`";
            System.out.println(sql);
            Statement statement = conexion.createStatement();
            ResultSet resultado = statement.executeQuery(sql);
            
            while(resultado.next()) {
                TipoDePago tdp = new TipoDePago();
                tdp.setNombre(resultado.getString("nombre"));
                tdp.setIdTipoDePago(resultado.getInt("id"));
                listado.add(tdp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TipoDePagoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listado;
    }
    
    public int buscarIdPorNombre(String nombre) {
        try {
            String baseDeDatos = "napaurbandb";
            String usuario = "root";
            String password = "";
            String host = "localhost";
            String puerto = "3306";
            String driver = "com.mysql.jdbc.Driver";
            String conexionUrl = "jdbc:mysql://" + host + ":" + puerto + "/" + baseDeDatos + "?useSLL=false";
            
            Connection conexion = null;
            
            try {
                Class.forName(driver);
                conexion = DriverManager.getConnection(conexionUrl, usuario, password);
            } catch (Exception ex) {
                Logger.getLogger(TipoDePagoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String sql = "SELECT `id` FROM `tipo_de_pago` WHERE `nombre`='"+nombre+"'";
            System.out.println(sql);
            Statement statement = conexion.createStatement();
            ResultSet resultado = statement.executeQuery(sql);
            
            resultado.next();
            return resultado.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(TipoDePagoDao.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
}
