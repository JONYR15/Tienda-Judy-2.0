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
public class Empleado {
    
    private Integer IdEmpleado;
    private String Nombre;
    private String Apellido1;
    private String Apellido2;
    private String  Telefono;
    private String Correo;
    private Integer Salario;

        public static Empleado obtenerEmpleado(Empleado varEmpleado){
            
            Empleado empleado = new Empleado();
            
            empleado.IdEmpleado = varEmpleado.IdEmpleado;
            empleado.Nombre = varEmpleado.Nombre;
            empleado.Apellido1 = varEmpleado.Apellido1;
            empleado.Apellido2 = varEmpleado.Apellido2;
            empleado.Telefono = varEmpleado.Telefono;
            empleado.Correo = varEmpleado.Correo;
            empleado.Salario = varEmpleado.Salario;
            
            return empleado;
    }
    
    public Integer getIdEmpleado() {
        return IdEmpleado;
    }

    public void setIdEmpleado(Integer IdEmpleado) {
        this.IdEmpleado = IdEmpleado;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido1() {
        return Apellido1;
    }

    public void setApellido1(String Apellido1) {
        this.Apellido1 = Apellido1;
    }

    public String getApellido2() {
        return Apellido2;
    }

    public void setApellido2(String Apellido2) {
        this.Apellido2 = Apellido2;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public Integer getSalario() {
        return Salario;
    }

    public void setSalario(Integer Salario) {
        this.Salario = Salario;
    }
    
    
    
}
