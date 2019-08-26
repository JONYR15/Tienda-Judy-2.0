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
public class DetalleFactura {
 
    private Integer IdDetalleFactura;
    private Integer IdEncabezadoFactura;
    private Integer IdProducto;
    private Integer Cantidad;

        public static DetalleFactura obtenerDetalle(DetalleFactura varDetalle){
            
            DetalleFactura detalle = new DetalleFactura();
            
            detalle.IdProducto = varDetalle.IdProducto;
            detalle.IdEncabezadoFactura = varDetalle.IdEncabezadoFactura;
            detalle.IdProducto = varDetalle.IdProducto;
            detalle.Cantidad = varDetalle.Cantidad;
            return detalle;
    }
    
    public Integer getIdDetalleFactura() {
        return IdDetalleFactura;
    }

    public void setIdDetalleFactura(Integer IdDetalleFactura) {
        this.IdDetalleFactura = IdDetalleFactura;
    }

    public Integer getIdEncabezadoFactura() {
        return IdEncabezadoFactura;
    }

    public void setIdEncabezadoFactura(Integer IdEncabezadoFactura) {
        this.IdEncabezadoFactura = IdEncabezadoFactura;
    }

    public Integer getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(Integer IdProducto) {
        this.IdProducto = IdProducto;
    }

    public Integer getCantidad() {
        return Cantidad;
    }

    public void setCantidad(Integer Cantidad) {
        this.Cantidad = Cantidad;
    }
    
    
}
