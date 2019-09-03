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
import model.EncabezadoFactura;

/**
 *
 * @author toursys
 */
@Stateless
public class EncabezadoFacturaDAO extends AbstractFacade<EncabezadoFactura> implements Serializable {

    @PersistenceContext
    private EntityManager em;

    public EncabezadoFacturaDAO() {
        super(EncabezadoFactura.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public void createEncabezadoFactura(EncabezadoFactura encabezadoFactura) {
        try {
            super.persist(encabezadoFactura);
        } catch (PersistenceException e) {
        }
    }

    public void editarEncabezadoFactura(EncabezadoFactura encabezadoFactura) {
        try {
            super.merge(encabezadoFactura);
        } catch (PersistenceException e) {
        }
    }

    public void eliminarEncabezadoFactura(EncabezadoFactura encabezadoFactura) {
        try {
            super.remove(encabezadoFactura);
        } catch (PersistenceException e) {
        }
    }

    public EncabezadoFactura buscarEncabezadoFactura(Integer idEncabezadoFactura) {
        return super.find(idEncabezadoFactura);
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<EncabezadoFactura> obtenerEncabezadoFacturas() {
        return super.findAll();
    }

}
