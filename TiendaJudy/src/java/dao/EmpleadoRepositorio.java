/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import utilitarios.HibernateUtil;

/**
 *
 * @author Bernan Ureña Lopez
 */
public class EmpleadoRepositorio {
    
        public void crearEmpleado(Empleado empleado){
        Session session = null;
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(empleado);
            session.getTransaction().commit();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            session.close();
        }
    }
         
    public List<Empleado> leerEmpleado(){
        Session session = null;
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            Query query = session.createQuery("from Empleado");
            List<Empleado> list = query.list();
            session.getTransaction().commit();
            return list;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
        session.close();
        }    
        return null;  
    }
    
    
        public Empleado leerEmpleado(String idEmpleado){
        Session session = null;
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            Query query = session.createQuery("from Empleado where IdEmpleado = :idEmpleadoParametro");
            query.setParameter("idEmpleadoParametro", idEmpleado);
            List<Empleado> list = query.list();
            session.getTransaction().commit();
            if(list.size() > 0)
                return list.get(0);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            session.close();
        }
        return null;
    }
        
     public void actualizarEmpleado(Empleado empleado){
        Session session = null;
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(empleado);
            session.getTransaction().commit();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            session.close();
        }
    }
        
    public void eliminarEmpleado (Empleado empleado){
        Session session = null;
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(empleado);
            session.getTransaction().commit();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            session.close();
        }
    }
    
}
