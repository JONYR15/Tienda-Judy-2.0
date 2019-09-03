/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import model.DetalleFactura;

/**
 *
 * @author toursys
 */
@Stateless
public class DetalleFacturaDAO extends AbstractFacade<DetalleFactura> implements Serializable {
    
    @PersistenceContext
    private EntityManager em;

    public DetalleFacturaDAO() {
        super(DetalleFactura.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public void createDetalleFactura(DetalleFactura encabezadoFactura) {
        try {
            super.persist(encabezadoFactura);
        } catch (PersistenceException e) {
        }
    }

    public void editarDetalleFactura(DetalleFactura encabezadoFactura) {
        try {
            super.merge(encabezadoFactura);
        } catch (PersistenceException e) {
        }
    }

    public void eliminarDetalleFactura(DetalleFactura encabezadoFactura) {
        try {
            super.remove(encabezadoFactura);
        } catch (PersistenceException e) {
        }
    }

    public DetalleFactura buscarDetalleFactura(Integer idDetalleFactura) {
        return super.find(idDetalleFactura);
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<DetalleFactura> obtenerDetalleFacturas() {
        return super.findAll();
    }
}
