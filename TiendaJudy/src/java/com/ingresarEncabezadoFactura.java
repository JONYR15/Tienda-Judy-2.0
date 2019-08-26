/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import dao.EncabezadoFactura;
import dao.EncabezadoFacturaRepositorio;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Bernan Ureña Lopez
 */
@Named(value = "ingresarEncabezadoFactura")
@RequestScoped
public class ingresarEncabezadoFactura extends EncabezadoFactura{

    /**
     * Creates a new instance of ingresarEncabezadoFactura
     */
    public ingresarEncabezadoFactura() {
    }
    
            public String guardarEncabezadoFactura(){
            EncabezadoFacturaRepositorio encabezadoRepositorio = new EncabezadoFacturaRepositorio();
            EncabezadoFactura encabezado = EncabezadoFactura.obtenerEncabezadoFactura(this);
            encabezadoRepositorio.crearEncabezado(encabezado);
            return "verFactura";
    }
}
