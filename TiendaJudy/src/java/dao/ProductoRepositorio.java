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
import utilitarios.TiendaJudyUtil;

/**
 *
 * @author Bernan Ureña Lopez
 */
public class ProductoRepositorio{
  
    public void crearProducto(Producto produc){
        Session session = null;
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory(); 
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(produc);
            session.getTransaction().commit();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            session.close();
        }
    }
         
    public List<Producto> leerProductos(){
        Session session = null;
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            Query query = session.createQuery("from Producto");
            List<Producto> list = query.list();
            session.getTransaction().commit();
            return list;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
        session.close();
        }    
        return null;  
    }
    
    
        public Producto leerProducto(String idProducto){
        Session session = null;
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            Query query = session.createQuery("from Producto where IdProducto = :idProductoParametro");
            query.setParameter("idProductoParametro", idProducto);
            List<Producto> list = query.list();
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
        
     public void actualizarProducto(Producto producto){
        Session session = null;
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(producto);
            session.getTransaction().commit();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            session.close();
        }
    }
        
    public void eliminarProducto (Producto producto){
        Session session = null;
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(producto);
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
