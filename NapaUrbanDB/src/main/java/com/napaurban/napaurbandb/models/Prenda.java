/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.napaurban.napaurbandb.models;

/**
 *
 * @author 54113
 */
public class Prenda {
    private int id;
    private String nombre;
    private String tipo;
    private String color;
    private String talle;
    private int idProveedor;
    private int precioUnitario;
    private int precioOriginal;
    
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getTipo() {
        return this.tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String getColor() {
        return this.color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public String getTalle() {
        return this.talle;
    }
    
    public void setTalle(String talle) {
        this.talle = talle;
    }
    
    public int getIdProveedor () {
        return this.idProveedor;
    }
    
    public void setIdProveedor (int idProveedor) {
        this.idProveedor = idProveedor;
    }
    
    public int getPrecioUnitario () {
        return this.precioUnitario;
    }
    
    public void setPrecioUnitario (int precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
    
    public int getPrecioOriginal() {
        return precioOriginal;
    }
    
    public void setPrecioOriginal(int p) {
        this.precioOriginal = p;
    }
}
