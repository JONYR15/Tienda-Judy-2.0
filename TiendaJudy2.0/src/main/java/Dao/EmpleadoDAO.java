/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import model.Empleado;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;


@Stateless
public class EmpleadoDAO extends AbstractFacade<Empleado> implements Serializable {

    @PersistenceContext
    private EntityManager em;

    public EmpleadoDAO() {
        super(Empleado.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public void createEmpleado(Empleado empleado) {
        try {
            super.persist(empleado);
        } catch (PersistenceException e) {
        }
    }

    public void editarEmpleado(Empleado empleado) {
        try {
            super.merge(empleado);
        } catch (PersistenceException e) {
        }
    }

    public void eliminarEmpleado(Empleado empleado) {
        try {
            super.remove(empleado);
        } catch (PersistenceException e) {
        }
    }

    public Empleado buscarEmpleado(Integer idEmpleado) {
        return super.find(idEmpleado);
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Empleado> obtenerEmpleados() {
        return super.findAll();
    }

}
