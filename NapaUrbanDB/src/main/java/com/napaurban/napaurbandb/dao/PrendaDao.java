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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author 54113
 */
public class PrendaDao {
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
                Logger.getLogger(PrendaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String sql = "INSERT INTO `stock`(`id-stock`, `nombre`, `tipo`, `color`, `talle`, `id-proveedor`, `precio_unitario`, `precio_original`) VALUES (NULL,'"+prenda.getNombre()+"','"+prenda.getTipo()+"','"+prenda.getColor()+"','"+prenda.getTalle()+"','"+prenda.getIdProveedor()+"','"+prenda.getPrecioUnitario()+"', '"+prenda.getPrecioOriginal()+"')";
            System.out.println(sql);
            Statement statement = conexion.createStatement();
            statement.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(PrendaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Prenda> listar(Prenda prenda) {
        List<Prenda> listado = new ArrayList<>();
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
                Logger.getLogger(PrendaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String sql = "SELECT * FROM `stock`";
            System.out.println(sql);
            Statement statement = conexion.createStatement();
            ResultSet resultado = statement.executeQuery(sql);
            
            while(resultado.next()) {
                Prenda prnd = new Prenda();
                prnd.setNombre(resultado.getString("nombre"));
                prnd.setTipo(resultado.getString("tipo"));
                prnd.setColor(resultado.getString("color"));
                prnd.setTalle(resultado.getString("talle"));
                prnd.setIdProveedor(resultado.getInt("id-proveedor"));
                prnd.setPrecioUnitario(resultado.getInt("precio_unitario"));
                prnd.setPrecioOriginal(resultado.getInt("precio_original"));
                listado.add(prnd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PrendaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listado;
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
                Logger.getLogger(PrendaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String sql = "DELETE FROM stock WHERE `id-stock`="+id+"";
            System.out.println(sql);
            Statement statement = conexion.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(PrendaDao.class.getName()).log(Level.SEVERE, null, ex);
    }}
    
    public Prenda buscarPorId (int id) {
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
                Logger.getLogger(PrendaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String sql = "SELECT * FROM `stock` WHERE `id-stock`="+id+"";
            System.out.println(sql);
            Statement statement = conexion.createStatement();
            ResultSet resultado = statement.executeQuery(sql);
            
            resultado.next();
            Prenda prnd = new Prenda();
            prnd.setId(resultado.getInt(1));
            prnd.setNombre(resultado.getString("nombre"));
            prnd.setTipo(resultado.getString("tipo"));
            prnd.setColor(resultado.getString("color"));
            prnd.setTalle(resultado.getString("talle"));
            prnd.setIdProveedor(resultado.getInt("id-proveedor"));
            prnd.setPrecioUnitario(resultado.getInt("precio_unitario"));
            prnd.setPrecioOriginal(resultado.getInt("precio_original"));
            return prnd;
        } catch (SQLException ex) {
            Logger.getLogger(PrendaDao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Ese ID no existe :(");
        }
        return null;
    }
    public int buscarPrecioUnitarioPorId(int id) {
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
                Logger.getLogger(PrendaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String sql = "SELECT `precio_unitario` FROM `stock` WHERE `id-stock`="+id+"";
            System.out.println(sql);
            Statement statement = conexion.createStatement();
            ResultSet resultado = statement.executeQuery(sql);
            
            resultado.next();
            int PU = resultado.getInt(1);
            return PU;
        } catch (SQLException ex) {
            Logger.getLogger(PrendaDao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Ese ID no existe :(");
        }
        return -1;
    }
    
    public String buscarNombrePorId(int id) {
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
                Logger.getLogger(PrendaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String sql = "SELECT `nombre` FROM `stock` WHERE `id-stock`="+id+"";
            System.out.println(sql);
            Statement statement = conexion.createStatement();
            ResultSet resultado = statement.executeQuery(sql);
            
            resultado.next();
            String nombre = resultado.getString(1);
            return nombre;
        } catch (SQLException ex) {
            Logger.getLogger(PrendaDao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Ese ID no existe :(");
        }
        return "error";
    }
    
    public Prenda buscarPorNombre (String nombre) {
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
                Logger.getLogger(PrendaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String sql = "SELECT * FROM `stock` WHERE `nombre`='"+nombre+"'";
            System.out.println(sql);
            Statement statement = conexion.createStatement();
            ResultSet resultado = statement.executeQuery(sql);
            
            resultado.next();
            Prenda prnd = new Prenda();
            prnd.setId(resultado.getInt(1));
            prnd.setNombre(resultado.getString("nombre"));
            prnd.setTipo(resultado.getString("tipo"));
            prnd.setColor(resultado.getString("color"));
            prnd.setTalle(resultado.getString("talle"));
            prnd.setIdProveedor(resultado.getInt("id-proveedor"));
            prnd.setPrecioUnitario(resultado.getInt("precio_unitario"));
            prnd.setPrecioOriginal(resultado.getInt("precio_original"));
            return prnd;
        } catch (SQLException ex) {
            Logger.getLogger(PrendaDao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Ese ID no existe :(");
        }
        return null;
    }
}
