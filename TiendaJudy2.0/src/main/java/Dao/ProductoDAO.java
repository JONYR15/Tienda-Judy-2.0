/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import model.Producto;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;


@Stateless
public class ProductoDAO extends AbstractFacade<Producto> implements Serializable {

    @PersistenceContext
    private EntityManager em;

    public ProductoDAO() {
        super(Producto.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public void createProducto(Producto producto) {
        try {
            super.persist(producto);
        } catch (PersistenceException e) {
        }
    }

    public void editarProducto(Producto producto) {
        try {
            super.merge(producto);
        } catch (PersistenceException e) {
        }
    }

    public void eliminarProducto(Producto producto) {
        try {
            super.remove(producto);
        } catch (PersistenceException e) {
        }
    }

    public Producto buscarProducto(Integer idProducto) {
        return super.find(idProducto);
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Producto> obtenerProductos() {
        return super.findAll();
    }

}
