/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managed;

import Dao.ClienteDAO;
import com.mycompany.tiendajudy2.model.Cliente;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author toursys
 */
@Named
@ViewScoped
public class ClienteManaged implements Serializable {

    @EJB
    private ClienteDAO clienteDAO;

    @EJB
    private Cliente cliente;

    private List<Cliente> clientes;

    public ClienteManaged() {
    }

    @PostConstruct
    public void init() {
        cliente = new Cliente();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getClientes() {
        if (clientes == null) {
            clientes = clienteDAO.obtenerClientes();
        }
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    public void crearCliente(){
        if (cliente!= null) {
            clienteDAO.createCliente(cliente);
        }
    }
    
    
    public void editarCliente(){
        if (cliente!=null) {
            clienteDAO.editarCliente(cliente);
        }
    }

}
