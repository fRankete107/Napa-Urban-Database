/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.napaurban.napaurbandb.dao;

import com.napaurban.napaurbandb.models.Prenda;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author 54113
 */
public class VendidoDao {
    public void agregar(Prenda prenda) {
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
                Logger.getLogger(VendidoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String sql = "INSERT INTO `vendido`(`id`, `nombre`, `tipo`, `color`, `talle`, `id-proveedor`, `precio_unitario`, `precio_original`) VALUES ("+prenda.getId()+",'"+prenda.getNombre()+"','"+prenda.getTipo()+"','"+prenda.getColor()+"','"+prenda.getTalle()+"','"+prenda.getIdProveedor()+"','"+prenda.getPrecioUnitario()+"', '"+prenda.getPrecioOriginal()+"')";
            System.out.println(sql);
            Statement statement = conexion.createStatement();
            statement.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(VendidoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String[] filtrarPorDia (String fecha, String primerDia) {
        String[] res = new String[2];
        Integer total = 0;
        Integer c = 0;
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
                Logger.getLogger(VendidoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String sql = "SELECT * FROM vendido WHERE fecha BETWEEN '"+primerDia+"' AND '"+fecha+"'";
            System.out.println(sql);
            Statement statement = conexion.createStatement();
            ResultSet resultado = statement.executeQuery(sql);
            
            while(resultado.next()) {
                total += resultado.getInt("precio_unitario");
                c++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(VendidoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        String totalStr = total.toString();
        String cStr = c.toString();
        res[0] = totalStr;
        res[1] = cStr;
        return res;
    }
    
    public void borrar(int id) {
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
                Logger.getLogger(VendidoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String sql = "DELETE FROM vendido WHERE id="+id+"";
            System.out.println(sql);
            Statement statement = conexion.createStatement();
            statement.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(VendidoDao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No encontramos esa prenda :(");
        }
    }
    public int buscarPorNombre(String nombre) {
        int res = -1;
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
                Logger.getLogger(VendidoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String sql = "SELECT `id` FROM vendido WHERE nombre='"+nombre+"'";
            System.out.println(sql);
            Statement statement = conexion.createStatement();
            ResultSet resultado = statement.executeQuery(sql);
            resultado.next();
            res = resultado.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(VendidoDao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se encontró esa prenda :(");
        }
        return res;
    }
    
    public Prenda buscarPorId(int id) {
        Prenda prnd = new Prenda();
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
                Logger.getLogger(VendidoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String sql = "SELECT * FROM vendido WHERE id="+id+"";
            System.out.println(sql);
            Statement statement = conexion.createStatement();
            ResultSet resultado = statement.executeQuery(sql);
            resultado.next();
            prnd.setId(resultado.getInt(1));
            prnd.setNombre(resultado.getString("nombre"));
            prnd.setTipo(resultado.getString("tipo"));
            prnd.setColor(resultado.getString("color"));
            prnd.setTalle(resultado.getString("talle"));
            prnd.setIdProveedor(resultado.getInt("id-proveedor"));
            prnd.setPrecioUnitario(resultado.getInt("precio_unitario"));
            prnd.setPrecioOriginal(resultado.getInt("precio_original"));
        } catch (SQLException ex) {
            Logger.getLogger(VendidoDao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se encontró esa prenda :(");
        }
    return prnd;
    }
}
