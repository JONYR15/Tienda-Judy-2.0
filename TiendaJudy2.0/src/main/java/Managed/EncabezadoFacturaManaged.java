/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managed;

import Dao.ClienteDAO;
import Dao.EmpleadoDAO;
import Dao.EncabezadoFacturaDAO;
import Dao.ProductoDAO;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import model.Cliente;
import model.DetalleFactura;
import model.Empleado;
import model.EncabezadoFactura;
import model.Producto;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author toursys
 */
@Named
@ViewScoped
public class EncabezadoFacturaManaged implements Serializable {

    @EJB
    private EncabezadoFacturaDAO encabezadoFacturaDAO;

    @EJB
    private EncabezadoFactura encabezadoFactura;

    @EJB
    private DetalleFactura detalleFactura;

    @EJB
    private Producto producto;

    @EJB
    private ProductoDAO productoDAO;

    @EJB
    private ClienteDAO clienteDAO;

    @EJB
    private EmpleadoDAO empleadoDAO;

    private List<EncabezadoFactura> encabezadoFacturaList;

    public EncabezadoFacturaManaged() {
    }

    @PostConstruct
    public void init() {
        encabezadoFactura = new EncabezadoFactura();
        encabezadoFactura.setIdCliente(new Cliente());
        encabezadoFactura.setIdEmpleado(new Empleado());
        detalleFactura = new DetalleFactura();
        producto = new Producto();
    }

    public EncabezadoFactura getEncabezadoFactura() {
        return encabezadoFactura;
    }

    public void setEncabezadoFactura(EncabezadoFactura encabezadoFactura) {
        this.encabezadoFactura = encabezadoFactura;
    }

    public List<EncabezadoFactura> getEncabezadoFacturaList() {
        encabezadoFacturaList = encabezadoFacturaDAO.obtenerEncabezadoFacturas();
        return encabezadoFacturaList;
    }
    
     public void clienteSeleccionado(ValueChangeEvent event) {
        if (event != null) {
            encabezadoFactura.setIdCliente((Cliente) event.getNewValue());
        }
    }
     
      public void empleadoSeleccionado(ValueChangeEvent event) {
        if (event != null) {
            encabezadoFactura.setIdEmpleado((Empleado) event.getNewValue());
        }
    }

    public void setEncabezadoFacturaList(List<EncabezadoFactura> encabezadoFacturaList) {
        this.encabezadoFacturaList = encabezadoFacturaList;
    }

    public DetalleFactura getDetalleFactura() {
        return detalleFactura;
    }

    public void setDetalleFactura(DetalleFactura detalleFactura) {
        this.detalleFactura = detalleFactura;
    }

    public Producto getProducto() {
        String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        if (!StringUtils.isEmpty(id)) {
            producto = productoDAO.buscarProducto(Integer.parseInt(id));
        }
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<Cliente> getClientes() {
        return clienteDAO.obtenerClientes();
    }

    public List<Empleado> getEmpleados() {
        return empleadoDAO.obtenerEmpleados();
    }

    public void setProductoADetalle() {
        if (getProducto() != null && producto.getIdProducto() != null) {
            detalleFactura.setDescripcionProducto(producto.getDescripcion());
            detalleFactura.setIdProducto(producto);
            detalleFactura.setPrecio(producto.getPrecioVenta());
            detalleFactura.setCantidad(1);
            detalleFactura.setTotal(detalleFactura.getPrecio() * detalleFactura.getCantidad());
            detalleFactura.setIdEncabezadoFactura(encabezadoFactura);
        }
    }

    public void agregarDetalle() {
        if (encabezadoFactura.getDetalleFacturaList() == null) {
            encabezadoFactura.setDetalleFacturaList(new ArrayList<DetalleFactura>());
        }
        if (detalleFactura.getDescripcionProducto() != null) {
            Boolean existe = false;
            for (int i = 0; i < encabezadoFactura.getDetalleFacturaList().size(); i++) {
                if (encabezadoFactura.getDetalleFacturaList().get(i).getIdProducto().getIdProducto() == detalleFactura.getIdProducto().getIdProducto()) {
                    encabezadoFactura.getDetalleFacturaList().get(i).setCantidad(encabezadoFactura.getDetalleFacturaList().get(i).getCantidad() + detalleFactura.getCantidad());
                    encabezadoFactura.getDetalleFacturaList().get(i).setTotal(encabezadoFactura.getDetalleFacturaList().get(i).getPrecio() * encabezadoFactura.getDetalleFacturaList().get(i).getCantidad());
                    existe = true;
                }

            }
            if (!existe) {
                encabezadoFactura.getDetalleFacturaList().add(detalleFactura);
            }

        }
    }

    public void crearFactura() {
        if (encabezadoFactura != null) {
            if (encabezadoFacturaDAO.buscarEncabezadoFactura(encabezadoFactura.getIdEncabezadoFactura()) == null) {
                try {
                    encabezadoFacturaDAO.createEncabezadoFactura(encabezadoFactura);
                    FacesContext contex = FacesContext.getCurrentInstance();
                    contex.getExternalContext().redirect("verFacturas.xhtml");
                } catch (IOException e) {
                    FacesContext context = FacesContext.getCurrentInstance();
                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "No se pudo cargar la pagina"));
                }
                encabezadoFactura = new EncabezadoFactura();

            } else {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Ya existe una factura con el ID: " + encabezadoFactura.getIdEncabezadoFactura()));
            }
        }
    }

}
