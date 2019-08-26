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
public class EncabezadoFactura {
    
    private Integer IdEncabezadoFactura;
    private Integer ValorVenta;
    private Integer Descuento;
    private Integer SubTotal;
    private Double  IVA;
    private Double  TotalVenta;
    private Integer IdCliente;
    private Integer IdEmpleado;

        public static EncabezadoFactura obtenerEncabezadoFactura(EncabezadoFactura varEncabezado){
            EncabezadoFactura encabezado = new EncabezadoFactura();
            
            encabezado.IdEncabezadoFactura = varEncabezado.IdEncabezadoFactura;
            encabezado.ValorVenta = varEncabezado.ValorVenta;
            encabezado.Descuento = varEncabezado.Descuento;
            encabezado.SubTotal = varEncabezado.SubTotal;
            encabezado.IVA = varEncabezado.IVA;
            encabezado.TotalVenta = varEncabezado.TotalVenta;
            encabezado.IdCliente = varEncabezado.IdCliente;
            encabezado.IdEmpleado = varEncabezado.IdEmpleado;
            return encabezado;
    }
    
    public Integer getIdEncabezadoFactura() {
        return IdEncabezadoFactura;
    }

    public void setIdEncabezadoFactura(Integer IdEncabezadoFactura) {
        this.IdEncabezadoFactura = IdEncabezadoFactura;
    }

    public Integer getValorVenta() {
        return ValorVenta;
    }

    public void setValorVenta(Integer ValorVenta) {
        this.ValorVenta = ValorVenta;
    }

    public Integer getDescuento() {
        return Descuento;
    }

    public void setDescuento(Integer Descuento) {
        this.Descuento = Descuento;
    }

    public Integer getSubTotal() {
        return SubTotal;
    }

    public void setSubTotal(Integer SubTotal) {
        this.SubTotal = SubTotal;
    }

    public Double getIVA() {
        return IVA;
    }

    public void setIVA(Double IVA) {
        this.IVA = IVA;
    }

    public Double getTotalVenta() {
        return TotalVenta;
    }

    public void setTotalVenta(Double TotalVenta) {
        this.TotalVenta = TotalVenta;
    }

    public Integer getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(Integer IdCliente) {
        this.IdCliente = IdCliente;
    }

    public Integer getIdEmpleado() {
        return IdEmpleado;
    }

    public void setIdEmpleado(Integer IdEmpleado) {
        this.IdEmpleado = IdEmpleado;
    }
    
    
    
}
