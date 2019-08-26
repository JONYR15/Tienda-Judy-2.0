/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import dao.DetalleFactura;
import dao.DetalleFacturaRepositorio;
import dao.EncabezadoFactura;
import dao.EncabezadoFacturaRepositorio;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Bernan Ureña Lopez
 */
@Named(value = "manageFactura")
@RequestScoped
public class manageFactura {

    private EncabezadoFactura encabezado;
    private EncabezadoFacturaRepositorio encabezadoRepositorio;
    private DetalleFactura detalle;
    private DetalleFacturaRepositorio detalleRepositorio;
    private List<EncabezadoFactura> encabezados = new ArrayList<EncabezadoFactura>();
    private List<DetalleFactura> detalles = new ArrayList<DetalleFactura>();
    
    public manageFactura() {
    }
    
    @PostConstruct
    public void init(){
        encabezado = new  EncabezadoFactura();
        detalle = new DetalleFactura();
        encabezadoRepositorio = new EncabezadoFacturaRepositorio();
        detalleRepositorio = new DetalleFacturaRepositorio();
    }   

    public List<EncabezadoFactura> getEncabezadoFacturas() {
        return encabezados;
    }
 
    public EncabezadoFactura getEncabezadoFactura() {
        return encabezado;
    }

    public List<DetalleFactura> getDetalleFacturas(){
        return detalles;
    }
    
    public DetalleFactura getDetalleFactura(){
        return detalle;
    }
    
    public void setEncabezado(EncabezadoFactura encabezado) {
        this.encabezado = encabezado;
    }
    
    public void setDetalle(DetalleFactura detalle){
        this.detalle = detalle;
    }
    
    public String guardarFactura(){
            encabezadoRepositorio.crearEncabezado(encabezado);
            detalleRepositorio.crearDetalle(detalle);
            return "verFacturas";
    }
    
}
