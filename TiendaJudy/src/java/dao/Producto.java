/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author Bernan Ureña Lopez
 */
public class Producto {
    
    private Integer IdProducto;
    private String Nombre;
    private String Descripcion;
    private String Talla;
    private Integer Cantidad;
    private Integer PrecioCompra;
    private Integer PrecioVenta;
    
    public static Producto obtenerProducto(Producto varProduc){
        Producto producto = new Producto();
        producto.IdProducto = varProduc.IdProducto;
        producto.Nombre = varProduc.Nombre;
        producto.Descripcion = varProduc.Descripcion;
        producto.Cantidad = varProduc.Cantidad;
        producto.Talla = varProduc.Talla;
        producto.PrecioCompra = varProduc.PrecioCompra;
        producto.PrecioVenta = varProduc.PrecioVenta;
        return producto;
    }

    public Integer getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(Integer IdProducto) {
        this.IdProducto = IdProducto;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getTalla() {
        return Talla;
    }

    public void setTalla(String Talla) {
        this.Talla = Talla;
    }

    public Integer getCantidad() {
        return Cantidad;
    }

    public void setCantidad(Integer Cantidad) {
        this.Cantidad = Cantidad;
    }

    public Integer getPrecioCompra() {
        return PrecioCompra;
    }

    public void setPrecioCompra(Integer PrecioCompra) {
        this.PrecioCompra = PrecioCompra;
    }

    public Integer getPrecioVenta() {
        return PrecioVenta;
    }

    public void setPrecioVenta(Integer PrecioVenta) {
        this.PrecioVenta = PrecioVenta;
    }
    
    
}
