/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managed;

import Dao.ProductoDAO;
import model.Producto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class ProductoManaged implements Serializable {

    @EJB
    private ProductoDAO productoDAO;

    @EJB
    private Producto producto;

    private List<Producto> productos;

    @EJB
    private Producto productoEditar;

    public ProductoManaged() {
    }

    @PostConstruct
    public void init() {
        producto = new Producto();
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Producto getProductoEditar() {
        String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        if (id != null || !"".equals(id)) {
            productoEditar = productoDAO.buscarProducto(Integer.parseInt(id));
        }
        return productoEditar;
    }

    public void setProductoEditar(Producto productoEditar) {
        this.productoEditar = productoEditar;
    }

    public List<Producto> getProductos() {
        if (productos == null) {
            productos = productoDAO.obtenerProductos();
        }
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public void crearProducto() {
        if (producto != null) {
            if (productoDAO.buscarProducto(producto.getIdProducto()) == null) {
                productoDAO.createProducto(producto);
            } else {

            }

        }
    }

    public void editarProducto() {
        if (productoEditar != null) {
            Producto pSinEditar = productoDAO.buscarProducto(productoEditar.getIdProducto());
            if (pSinEditar != null) {
                if (Objects.equals(pSinEditar.getNombre(), productoEditar.getNombre())
                        & Objects.equals(pSinEditar.getDescripcion(), productoEditar.getDescripcion())
                        & Objects.equals(pSinEditar.getTalla(), productoEditar.getTalla())
                        & Objects.equals(pSinEditar.getCantidad(), productoEditar.getCantidad())
                        & Objects.equals(pSinEditar.getPrecioCompra(), productoEditar.getPrecioCompra())
                        & Objects.equals(pSinEditar.getPrecioVenta(), productoEditar.getPrecioVenta())) {
                    FacesContext context = FacesContext.getCurrentInstance();
                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "AVISO", "El producto " + productoEditar.getNombre() + " no ha sufrido cambios "));
                } else {
                    productoDAO.editarProducto(productoEditar);

                    FacesContext context = FacesContext.getCurrentInstance();
                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "CORRECTO", "El producto " + productoEditar.getNombre() + " fue Editado correctamente: "));

                    productoEditar = new Producto();
                }
            }
        }
    }

}
