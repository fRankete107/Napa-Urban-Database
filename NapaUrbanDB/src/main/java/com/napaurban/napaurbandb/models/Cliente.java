/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.napaurban.napaurbandb.models;

/**
 *
 * @author 54113
 */
public class Cliente {
    private int idCliente;
    private String email;
    private int compras;
    private int gastado;
    
    public int getIdCliente(){
        return idCliente;
    }
    
    public void setIdCliente(int id){
        this.idCliente = id;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public int getCompras(){
        return compras;
    }
    
    public void setCompras(int c){
        this.compras = c;
    }
    
    public int getGastado(){
        return gastado;
    }
    
    public void setGastado(int g){
        this.gastado = g;
    }
}
