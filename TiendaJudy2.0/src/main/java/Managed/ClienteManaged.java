/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managed;

import Dao.ClienteDAO;
import model.Cliente;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.apache.commons.lang3.StringUtils;

@Named
@ViewScoped
public class ClienteManaged implements Serializable {

    @EJB
    private ClienteDAO clienteDAO;

    @EJB
    private Cliente cliente;

    @EJB
    private Cliente clienteEditar;

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

    public Cliente getClienteEditar() {
        String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        if (!StringUtils.isEmpty(id)) {
            clienteEditar = clienteDAO.buscarCliente(Integer.parseInt(id));
        }
        return clienteEditar;
    }

    public void setClienteEditar(Cliente clienteEditar) {
        this.clienteEditar = clienteEditar;
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

    public void validarId() {
        if (cliente.getIdCliente() != null) {
            if (clienteDAO.buscarCliente(cliente.getIdCliente()) != null) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Ya existe un cliente con el ID: " + cliente.getIdCliente()));
            } else {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "CORRECTO", "ID disponible para usar"));
            }
        }
    }

    public void crearCliente() {
        if (cliente != null) {
            if (clienteDAO.buscarCliente(cliente.getIdCliente()) == null) {
                try {
                    clienteDAO.createCliente(cliente);
                    FacesContext contex = FacesContext.getCurrentInstance();
                    contex.getExternalContext().redirect("verClientes.xhtml");
                } catch (Exception e) {
                    FacesContext context = FacesContext.getCurrentInstance();
                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "No se pudo cargar la pagina"));
                }
                cliente = new Cliente();

            } else {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Ya existe un cliente con el ID: " + cliente.getIdCliente()));
            }
        }
    }

    public void editarCliente() {
        if (clienteEditar != null) {
            Cliente cSinEditar = clienteDAO.buscarCliente(clienteEditar.getIdCliente());

            if (cSinEditar != null) {
                if (Objects.equals(cSinEditar.getNombre(), clienteEditar.getNombre())
                        & Objects.equals(cSinEditar.getCorreo(), clienteEditar.getCorreo())
                        & Objects.equals(cSinEditar.getTelefono(), clienteEditar.getTelefono())) {
                    FacesContext context = FacesContext.getCurrentInstance();
                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "AVISO", "el cliente con el numero de cedula" + clienteEditar.getIdCliente() + " no ha sufrido cambios"));
                } else {

                    FacesContext context = FacesContext.getCurrentInstance();
                    try {
                        clienteDAO.editarCliente(clienteEditar);
                        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "CORRECTO", "El cliente con numero de cedula " + clienteEditar.getIdCliente() + " editado correctamente: "));
                        context.getExternalContext().redirect("verClientes.xhtml");
                    } catch (Exception e) {
                        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "AVISO", "El cliente " + clienteEditar.getIdCliente() + " no se ha editado correctamente: "));
                    }
                    clienteEditar = new Cliente();
                }
            }
        }
    }

    public void eliminarCliente() {
        if (clienteEditar != null) {
            try {
                Cliente clienteEliminar = clienteDAO.buscarCliente(clienteEditar.getIdCliente());
                clienteDAO.eliminarCliente(clienteEliminar);
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "AVISO!", "Cliente eliminado con exito"));
                context.getExternalContext().redirect("verClientes.xhtml");
            } catch (Exception e) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "No se pudo cargar la pagina"));
            }
        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "No se pudo eliminar el cliente"));
        }
    }

}
