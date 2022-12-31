/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.napaurban.napaurbandb.dao;

import com.napaurban.napaurbandb.models.Cliente;
import com.napaurban.napaurbandb.models.Proveedores;
import com.napaurban.napaurbandb.models.Vendedora;
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
public class VendedoraDao {
    public void agregar(Vendedora vnd) {
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
                Logger.getLogger(VendedoraDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String sql = "INSERT INTO `vendedores`(`id-vendedora`, `nombre`, `ventas`,`dineroGenerado`) VALUES (NULL,'"+vnd.getNombre()+"',0,0)";
            System.out.println(sql);
            Statement statement = conexion.createStatement();
            statement.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(VendedoraDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void eliminar(int id) {
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
                Logger.getLogger(VendedoraDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String sql = "DELETE FROM vendedores WHERE `id-vendedora`="+id+"";
            System.out.println(sql);
            Statement statement = conexion.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(VendedoraDao.class.getName()).log(Level.SEVERE, null, ex);
    }}
    
    public List<Vendedora> listar() {
      List<Vendedora> listado= new ArrayList<>();
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
                Logger.getLogger(VendedoraDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String sql = "SELECT * FROM `vendedores`";
            System.out.println(sql);
            Statement statement = conexion.createStatement();
            ResultSet resultado = statement.executeQuery(sql);
            
            while(resultado.next()) {
                Vendedora vnd = new Vendedora();
                vnd.setId(resultado.getInt("id-vendedora"));
                vnd.setNombre(resultado.getString("nombre"));
                listado.add(vnd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VendedoraDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listado;
    }
    
    public int buscarPorNombre(String nombre) {
        int id = 0;
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
                Logger.getLogger(VendedoraDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String sql = "SELECT * FROM `vendedores`";
            System.out.println(sql);
            Statement statement = conexion.createStatement();
            ResultSet resultado = statement.executeQuery(sql);
            
            while(resultado.next()) {
                Vendedora vnd = new Vendedora();
                vnd.setId(resultado.getInt("id-vendedora"));
                vnd.setNombre(resultado.getString("nombre"));
                if (vnd.getNombre().equals(nombre)){
                    id = (int) vnd.getId();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(VendedoraDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
    public void SumarVentas(int id, int dineroGenerado) {
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
                Logger.getLogger(VendedoraDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String sql = "UPDATE vendedores SET ventas = ventas + 1 WHERE `id-vendedora`="+id+"";
            System.out.println(sql);
            Statement statement = conexion.createStatement();
            statement.executeUpdate(sql);
            
            sql = "UPDATE vendedores SET dineroGenerado = dineroGenerado + "+dineroGenerado+" WHERE `id-vendedora`="+id+"";
            System.out.println(sql);
            Statement statement2 = conexion.createStatement();
            statement2.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(VendedoraDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
