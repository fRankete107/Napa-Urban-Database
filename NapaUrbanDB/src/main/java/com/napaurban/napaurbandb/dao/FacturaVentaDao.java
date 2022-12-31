/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.napaurban.napaurbandb.dao;

import com.napaurban.napaurbandb.models.FacturaVenta;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 54113
 */
public class FacturaVentaDao {
    public void agregar(FacturaVenta fvta) {
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
                Logger.getLogger(FacturaVentaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String sql = "INSERT INTO `factura_venta`(`id-factura`, `id-cliente`, `nombre-producto`, `precio-unitario`, `cantidad`, `precio-final`, `id-tipo_de_pago`, `id-vendedora`) VALUES (NULL,'"+fvta.getIdCliente()+"','"+fvta.getNombreProducto()+"','"+fvta.getPrecioUnitario()+"','"+fvta.getCantidad()+"','"+fvta.getPrecioFinal()+"','"+fvta.getIdTipoDePago()+"','"+fvta.getIdVendedora()+"')";
            System.out.println(sql);
            Statement statement = conexion.createStatement();
            statement.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(FacturaVentaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
