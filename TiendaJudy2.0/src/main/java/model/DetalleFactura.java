/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author toursys
 */
@Entity
@Table(name = "DETALLE_FACTURA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleFactura.findAll", query = "SELECT d FROM DetalleFactura d")
    , @NamedQuery(name = "DetalleFactura.findByIdDetalleFactura", query = "SELECT d FROM DetalleFactura d WHERE d.idDetalleFactura = :idDetalleFactura")
    , @NamedQuery(name = "DetalleFactura.findByDescripcionProducto", query = "SELECT d FROM DetalleFactura d WHERE d.descripcionProducto = :descripcionProducto")
    , @NamedQuery(name = "DetalleFactura.findByCantidad", query = "SELECT d FROM DetalleFactura d WHERE d.cantidad = :cantidad")
    , @NamedQuery(name = "DetalleFactura.findByPrecio", query = "SELECT d FROM DetalleFactura d WHERE d.precio = :precio")
    , @NamedQuery(name = "DetalleFactura.findByTotal", query = "SELECT d FROM DetalleFactura d WHERE d.total = :total")})
public class DetalleFactura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_DETALLE_FACTURA")
    private Integer idDetalleFactura;
    @Size(max = 50)
    @Column(name = "DESCRIPCION_PRODUCTO")
    private String descripcionProducto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CANTIDAD")
    private Double cantidad;
    @Column(name = "PRECIO")
    private Double precio;
    @Column(name = "TOTAL")
    private Double total;
    @JoinColumn(name = "ID_ENCABEZADO_FACTURA", referencedColumnName = "ID_ENCABEZADO_FACTURA")
    @ManyToOne(fetch = FetchType.LAZY)
    private EncabezadoFactura idEncabezadoFactura;
    @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO")
    @ManyToOne(fetch = FetchType.LAZY)
    private Producto idProducto;

    public DetalleFactura() {
    }

    public DetalleFactura(Integer idDetalleFactura) {
        this.idDetalleFactura = idDetalleFactura;
    }

    public Integer getIdDetalleFactura() {
        return idDetalleFactura;
    }

    public void setIdDetalleFactura(Integer idDetalleFactura) {
        this.idDetalleFactura = idDetalleFactura;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public EncabezadoFactura getIdEncabezadoFactura() {
        return idEncabezadoFactura;
    }

    public void setIdEncabezadoFactura(EncabezadoFactura idEncabezadoFactura) {
        this.idEncabezadoFactura = idEncabezadoFactura;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleFactura != null ? idDetalleFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleFactura)) {
            return false;
        }
        DetalleFactura other = (DetalleFactura) object;
        if ((this.idDetalleFactura == null && other.idDetalleFactura != null) || (this.idDetalleFactura != null && !this.idDetalleFactura.equals(other.idDetalleFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.DetalleFactura[ idDetalleFactura=" + idDetalleFactura + " ]";
    }
    
}
