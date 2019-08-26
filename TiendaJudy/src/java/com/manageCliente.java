/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import dao.Cliente;
import dao.ClienteRepositorio;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Bernan Ureña Lopez
 */
@Named(value = "manageCliente")
@RequestScoped
public class manageCliente {

    private Cliente cliente;
    private ClienteRepositorio clienteRepositorio;
    private List<Cliente> clientes = new ArrayList<Cliente>();
    
    
    public manageCliente() {
    }
    
    @PostConstruct
    public void init(){
        cliente = new Cliente();
        clienteRepositorio=new ClienteRepositorio();
    }   

    public List<Cliente> getCientes() {
        return clientes;
    }
 
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
    public String guardarCliente(){
            clienteRepositorio.crearCliente(cliente);
            return "verClientes";
    }
}
