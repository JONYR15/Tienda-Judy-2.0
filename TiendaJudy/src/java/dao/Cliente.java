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
public class Cliente {
    private Integer IdCliente;
    private String Nombre;
    private String Apellido1;
    private String Apellido2;
    private String Telefono;
    private String Correo;
    
        public static Cliente obtenerCliente(Cliente varCliente){
            Cliente cliente = new Cliente();
            cliente.IdCliente = varCliente.IdCliente;
            cliente.Nombre = varCliente.Nombre;
            cliente.Apellido1 = varCliente.Apellido1;
            cliente.Apellido2 = varCliente.Apellido2;
            cliente.Telefono = varCliente.Telefono;
            cliente.Correo = varCliente.Correo;
            return cliente;
    }

    public Integer getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(Integer IdCliente) {
        this.IdCliente = IdCliente;
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
    
    
    
}
