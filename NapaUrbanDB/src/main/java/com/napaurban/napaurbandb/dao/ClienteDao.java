/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.napaurban.napaurbandb.dao;

import com.napaurban.napaurbandb.models.Cliente;
import com.napaurban.napaurbandb.models.TipoDePago;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 54113
 */
public class ClienteDao {
    public void agregar(Cliente cliente) {
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
                Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String sql = "INSERT INTO `clientes`(`id-cliente`, `email`, `compras`, `gastado`) VALUES (NULL,'"+cliente.getEmail()+"', 0, 0)";
            System.out.println(sql);
            Statement statement = conexion.createStatement();
            statement.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int buscarPorEmail(String email) {
        String baseDeDatos = "napaurbandb";
        String usuario = "root";
        String password = "";
        String host = "localhost";
        String puerto = "3306";
        String driver = "com.mysql.jdbc.Driver";
        String conexionUrl = "jdbc:mysql://" + host + ":" + puerto + "/" + baseDeDatos + "?useSLL=false";
        Connection conexion = null;
        int id = -1;
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(conexionUrl, usuario, password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "SELECT `id-cliente` FROM `clientes` WHERE email='"+email+"'";
        System.out.println(sql);
        try {
            Statement statement = conexion.createStatement();
            ResultSet res = statement.executeQuery(sql);
            res.next(); 
            id = res.getInt(1);
            return id;
        } catch (Exception ex) {
            Cliente nCliente = new Cliente();
            nCliente.setEmail(email);
            this.agregar(nCliente);
            return id;
        }
    }
    
    public void sumarCompra(int id) {
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
                Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String sql = "UPDATE clientes SET compras = compras + 1  WHERE `id-cliente`="+id+"";
            System.out.println(sql);
            Statement statement = conexion.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sumarGasto(int id, int gasto) {
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
                Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String sql = "UPDATE clientes SET gastado = gastado + "+gasto+"  WHERE `id-cliente`="+id+"";
            System.out.println(sql);
            Statement statement = conexion.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
