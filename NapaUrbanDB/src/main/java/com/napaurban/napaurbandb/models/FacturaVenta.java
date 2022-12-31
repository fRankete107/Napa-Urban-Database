/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.napaurban.napaurbandb.models;

/**
 *
 * @author 54113
 */
public class FacturaVenta {
    private int idFactura;
    private int idCliente;
    private String nombreProducto;
    private int precioUnitario;
    private int cantidad;
    private int precioFinal;
    private int idTipoDePago;
    private int idVendedora;
    
    public int getIdFactura() {
        return idFactura;
    }
    
    public void setIdFactura(int id) {
        this.idFactura = id;
    }
    
    public int getIdCliente() {
        return idCliente;
    }
    
    public void setIdCliente(int id){
        this.idCliente = id;
    }
    
    public String getNombreProducto() {
        return nombreProducto;
    }
    
    public void setNombreProducto(String nombre){
        this.nombreProducto = nombre;
    }
    
    public int getPrecioUnitario() {
        return precioUnitario;
    }
    
    public void setPrecioUnitario(int pu){
        this.precioUnitario = pu;
    }
    
    public int getCantidad() {
        return cantidad;
    }
    
    public void setCantidad(int c){
        this.cantidad = c;
    }
    
    public int getPrecioFinal(){
        return precioFinal;
    }
    
    public void setPrecioFinal(int pf){
        this.precioFinal = pf;
    }
    
    public int getIdTipoDePago(){
        return idTipoDePago;
    }
    
    public void setIdTipoDePago(int id) {
        this.idTipoDePago = id;
    }
    
    public int getIdVendedora(){
        return idVendedora;
    }
    
    public void setIdVendedora(int id){
        this.idVendedora = id;
    }
}
