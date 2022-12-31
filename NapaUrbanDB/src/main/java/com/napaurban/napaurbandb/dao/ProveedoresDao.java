/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.napaurban.napaurbandb.dao;

import com.napaurban.napaurbandb.models.Proveedores;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author 54113
 */
public class ProveedoresDao {
    public void agregar(Proveedores proveedor) {
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
                Logger.getLogger(ProveedoresDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String sql = "INSERT INTO `proveedores`(`id-proveedor`, `nombre`) VALUES (NULL,'"+proveedor.getNombre()+"')";
            System.out.println(sql);
            Statement statement = conexion.createStatement();
            statement.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ProveedoresDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Proveedores> listar() {
        List<Proveedores> listado = new ArrayList<>();
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
                Logger.getLogger(ProveedoresDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String sql = "SELECT * FROM `proveedores`";
            System.out.println(sql);
            Statement statement = conexion.createStatement();
            ResultSet resultado = statement.executeQuery(sql);
            
            while(resultado.next()) {
                Proveedores prov = new Proveedores();
                prov.setId(resultado.getInt("id-proveedor"));
                prov.setNombre(resultado.getString("nombre"));
                listado.add(prov);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProveedoresDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listado;
    }
    
    public int buscarPorNombre(String nombre) {
        int id = 0;
        List<Proveedores> listado = new ArrayList<>();
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
                Logger.getLogger(ProveedoresDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String sql = "SELECT * FROM `proveedores`";
            System.out.println(sql);
            Statement statement = conexion.createStatement();
            ResultSet resultado = statement.executeQuery(sql);
            
            String[] nombres = new String[15];
            int i = 0;
            
            while(resultado.next()) {
                Proveedores prov = new Proveedores();
                prov.setId(resultado.getInt("id-proveedor"));
                prov.setNombre(resultado.getString("nombre"));
                nombres[i] = prov.getNombre();
                String nombre_ = prov.getNombre();
                if (nombre_ != null) {
                    if(nombre_.equals(nombre)) {
                        id = prov.getId();
                    }
                }
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProveedoresDao.class.getName()).log(Level.SEVERE, null, ex);
            id = -1;
            JOptionPane.showMessageDialog(null, "No se encontró ese nombre :(");
        }
        return id;
    }
    
    public String buscarPorId(int id) {
        String nombre = "error";
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
                Logger.getLogger(ProveedoresDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String sql = "SELECT `nombre` FROM `proveedores` WHERE `id-proveedor`="+id+"";
            System.out.println(sql);
            Statement statement = conexion.createStatement();
            ResultSet resultado = statement.executeQuery(sql);
            
            resultado.next();
            nombre = resultado.getString(1);
        } catch (SQLException ex) {
            Logger.getLogger(ProveedoresDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nombre;
    }
}
