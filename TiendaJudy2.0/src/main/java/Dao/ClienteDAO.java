/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import com.mycompany.tiendajudy2.model.Cliente;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

/**
 *
 * @author toursys
 */
@Stateless
public class ClienteDAO extends AbstractFacade<Cliente> implements Serializable {

    @PersistenceContext
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public void createCliente(Cliente cliente) {
        try {
            super.persist(cliente);
        } catch (PersistenceException e) {
        }
    }

    public void editarCliente(Cliente cliente) {
        try {
            super.merge(cliente);
        } catch (PersistenceException e) {
        }
    }

    public void eliminarCliente(Cliente cliente) {
        try {
            super.remove(cliente);
        } catch (PersistenceException e) {
        }
    }
    
    public Cliente buscarCliente(Integer idCliente){
       return super.find(idCliente);
    }
    
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Cliente> obtenerClientes(){
        return em.createQuery("Select * FROM Cliente").getResultList();
    }

}
