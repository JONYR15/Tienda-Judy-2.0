/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managed;

import Dao.EncabezadoFacturaDAO;
import Dao.ProductoDAO;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import model.Cliente;
import model.DetalleFactura;
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

    private List<EncabezadoFactura> encabezadoFacturaList;

    public EncabezadoFacturaManaged() {
        encabezadoFactura = new EncabezadoFactura();
        detalleFactura = new DetalleFactura();
        producto = new Producto();
    }

    @PostConstruct
    public void init() {
    }

    public EncabezadoFactura getEncabezadoFactura() {
        return encabezadoFactura;
    }

    public void setEncabezadoFactura(EncabezadoFactura encabezadoFactura) {
        this.encabezadoFactura = encabezadoFactura;
    }

    public List<EncabezadoFactura> getEncabezadoFacturaList() {
        return encabezadoFacturaList;
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

    public void setProductoADetalle() {
        if (getProducto() != null) {
            detalleFactura = new DetalleFactura();
            detalleFactura.setDescripcionProducto(producto.getDescripcion());
            detalleFactura.setIdProducto(producto);
            detalleFactura.setPrecio(producto.getPrecioVenta());
            detalleFactura.setCantidad(1);
            detalleFactura.getTotal();
        }
    }

    public void agregarDetalle() {
        if (detalleFactura.getDescripcionProducto() != null) {
            encabezadoFactura.getDetalleFacturaList().add(detalleFactura);
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
