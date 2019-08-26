/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import dao.Empleado;
import dao.EmpleadoRepositorio;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author Bernan Ureña Lopez
 */
@Named(value = "manageEmpleado")
@Dependent
public class manageEmpleado {

    
    private Empleado empleado;
    private EmpleadoRepositorio empleadoRepositorio;
    private List<Empleado> empleados = new ArrayList<Empleado>();
    
    
    /**
     * Creates a new instance of manageEmpleado
     */
    public manageEmpleado() {
    }
    
    @PostConstruct
    public void init(){
        empleado = new Empleado();
        empleadoRepositorio=new EmpleadoRepositorio();
    }   

    public List<Empleado> getEmpleados() {
        return empleados;
    }
 
    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    
    
    public String guardarEmpleado(){
            empleadoRepositorio.crearEmpleado(empleado);
            return "verEmpleados";
    }
    
}
