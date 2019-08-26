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
public class DetalleFacturaRepositorio {
    
    public void crearDetalle (DetalleFactura detalle){
        Session session = null;
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(detalle);
            session.getTransaction().commit();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            session.close();
        }
    }
         
    public List<DetalleFactura> leerDetalle(){
        Session session = null;
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            Query query = session.createQuery("from DetalleFactura");
            List<DetalleFactura> list = query.list();
            session.getTransaction().commit();
            return list;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
        session.close();
        }    
        return null;  
    }
    
    
        public DetalleFactura leerDetalleFactura(String idDetalleFactura){
        Session session = null;
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            Query query = session.createQuery("from DetalleFactura where idDetalleFactura = :idDetalleFacturaParametro");
            query.setParameter("idDetalleFacturaParametro", idDetalleFactura);
            List<DetalleFactura> list = query.list();
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
        
     public void actualizarDetalleFactura(DetalleFactura detalle){
        Session session = null;
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(detalle);
            session.getTransaction().commit();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            session.close();
        }
    }
        
    public void eliminarDetalle (DetalleFactura detalle){
        Session session = null;
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(detalle);
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
