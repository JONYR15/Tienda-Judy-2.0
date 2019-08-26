/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import dao.Producto;
import dao.ProductoRepositorio;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.jboss.weld.util.LazyValueHolder;
import utilitarios.HibernateUtil;

/**
 *
 * @author Bernan Ureña Lopez
 */
@Named(value = "manageProducto")
@RequestScoped
public class manageProducto implements Serializable{
    
    
    private Producto producto;
    private ProductoRepositorio productoRepositorio;
    private List<Producto> productos = new ArrayList<Producto>();
    

    /**
     * Creates a new instance of manageProducto
     */
    public manageProducto() {
    }
    
    @PostConstruct
    public void init(){
        producto = new Producto();
        productoRepositorio=new ProductoRepositorio();
    }   

    public List<Producto> getProductos() {
        return productos;
    }
 
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    
    public String guardarProducto(){
            productoRepositorio.crearProducto(producto);
            return "verProductos";
    }
    
    
}
