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
import utilitarios.HibernateUtil;

/**
 *
 * @author Bernan Ureña Lopez
 */
public class ClienteRepositorio {
    
    public void crearCliente (Cliente cliente){
        Session session = null;
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(cliente);
            session.getTransaction().commit();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            session.close();
        }
    }
         
    public List<Cliente> leerClientes(){
        Session session = null;
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            Query query = session.createQuery("from Cliente");
            List<Cliente> list = query.list();
            session.getTransaction().commit();
            return list;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
        session.close();
        }    
        return null;  
    }
    
    
        public Cliente leerCliente(String idCliente){
        Session session = null;
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            Query query = session.createQuery("from Cliente where IdCliente = :idClienteParametro");
            query.setParameter("idClienteParametro", idCliente);
            List<Cliente> list = query.list();
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
        
     public void actualizarCliente(Cliente cliente){
        Session session = null;
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(cliente);
            session.getTransaction().commit();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            session.close();
        }
    }
        
    public void eliminarCliente (Cliente cliente){
        Session session = null;
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(cliente);
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
