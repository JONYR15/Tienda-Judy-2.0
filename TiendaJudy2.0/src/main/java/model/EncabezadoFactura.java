/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "ENCABEZADO_FACTURA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EncabezadoFactura.findAll", query = "SELECT e FROM EncabezadoFactura e")
    , @NamedQuery(name = "EncabezadoFactura.findByIdEncabezadoFactura", query = "SELECT e FROM EncabezadoFactura e WHERE e.idEncabezadoFactura = :idEncabezadoFactura")
    , @NamedQuery(name = "EncabezadoFactura.findByValorVenta", query = "SELECT e FROM EncabezadoFactura e WHERE e.valorVenta = :valorVenta")
    , @NamedQuery(name = "EncabezadoFactura.findByDescuento", query = "SELECT e FROM EncabezadoFactura e WHERE e.descuento = :descuento")
    , @NamedQuery(name = "EncabezadoFactura.findBySubtotal", query = "SELECT e FROM EncabezadoFactura e WHERE e.subtotal = :subtotal")
    , @NamedQuery(name = "EncabezadoFactura.findByIva", query = "SELECT e FROM EncabezadoFactura e WHERE e.iva = :iva")
    , @NamedQuery(name = "EncabezadoFactura.findByTotalVenta", query = "SELECT e FROM EncabezadoFactura e WHERE e.totalVenta = :totalVenta")})
public class EncabezadoFactura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ENCABEZADO_FACTURA")
    private Integer idEncabezadoFactura;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALOR_VENTA")
    private Double valorVenta;
    @Column(name = "DESCUENTO")
    private Double descuento;
    @Column(name = "SUBTOTAL")
    private Double subtotal;
    @Column(name = "IVA")
    private Double iva;
    @Column(name = "TOTAL_VENTA")
    private Double totalVenta;
    @OneToMany(mappedBy = "idEncabezadoFactura", fetch = FetchType.LAZY)
    private List<DetalleFactura> detalleFacturaList;
    @JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID_CLIENTE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente idCliente;
    @JoinColumn(name = "ID_EMPLEADO", referencedColumnName = "ID_EMPLEADO")
    @ManyToOne(fetch = FetchType.LAZY)
    private Empleado idEmpleado;

    public EncabezadoFactura() {
    }

    public EncabezadoFactura(Integer idEncabezadoFactura) {
        this.idEncabezadoFactura = idEncabezadoFactura;
    }

    public Integer getIdEncabezadoFactura() {
        return idEncabezadoFactura;
    }

    public void setIdEncabezadoFactura(Integer idEncabezadoFactura) {
        this.idEncabezadoFactura = idEncabezadoFactura;
    }

    public Double getValorVenta() {
        return valorVenta;
    }

    public void setValorVenta(Double valorVenta) {
        this.valorVenta = valorVenta;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public Double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(Double totalVenta) {
        this.totalVenta = totalVenta;
    }

    @XmlTransient
    public List<DetalleFactura> getDetalleFacturaList() {
        return detalleFacturaList;
    }

    public void setDetalleFacturaList(List<DetalleFactura> detalleFacturaList) {
        this.detalleFacturaList = detalleFacturaList;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Empleado getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Empleado idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEncabezadoFactura != null ? idEncabezadoFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EncabezadoFactura)) {
            return false;
        }
        EncabezadoFactura other = (EncabezadoFactura) object;
        if ((this.idEncabezadoFactura == null && other.idEncabezadoFactura != null) || (this.idEncabezadoFactura != null && !this.idEncabezadoFactura.equals(other.idEncabezadoFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.EncabezadoFactura[ idEncabezadoFactura=" + idEncabezadoFactura + " ]";
    }
    
}
