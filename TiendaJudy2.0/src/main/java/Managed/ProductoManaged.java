/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managed;

import Dao.ProductoDAO;
import model.Producto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;


@Named
@ViewScoped
public class ProductoManaged implements Serializable {

    @EJB
    private ProductoDAO productoDAO;

    @EJB
    private Producto producto;

    private List<Producto> productos;

    public ProductoManaged() {
    }

    @PostConstruct
    public void init() {
        producto = new Producto();
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<Producto> getProductos() {
        if (productos == null) {
            productos = productoDAO.obtenerProductos();
        }
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
    
    public void crearProducto(){
        if (producto!= null) {
            if (productoDAO.buscarProducto(producto.getIdProducto())==null) {
                productoDAO.createProducto(producto);  
            }else{
            
            }
            
        }
    }
    
    
    public void editarProducto(){
        if (producto!=null) {
            productoDAO.editarProducto(producto);
        }
    }

}
