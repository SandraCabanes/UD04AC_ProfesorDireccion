/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import model.Direccion;
import model.Profesor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Sandra
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          //CREAMOS CONEXION
        //SessionFactory sessionFactory;
        //Configuration configuration = new Configuration();
        //configuration.configure();
        //sessionFactory = configuration.buildSessionFactory();
        SessionFactory factory = new Configuration().configure().buildSessionFactory(); 
        
        // CREAMOS UN OBJETO
        Direccion direccion=new Direccion(10, "Calle Reina",5, "Xàtiva", "Valencia" );
        Profesor profesor=new Profesor(11,"Jesus","Garcia","Perez");
        profesor.setDireccion(direccion);
        
        //CREAR UNA SESION
        Session session=factory.openSession();
        session.beginTransaction();
        
        //GUARDAR OBJETO
        session.save(profesor);
        
        Profesor profesor2=(Profesor) session.get(Profesor.class, 1);
        System.out.println(profesor2);
        
        
        //profesor.setNombre("Manola");
        //session.update(profesor);
        
        //session.saveOrUpdate(profesor);
        
        //CERRAR CONEXION
        session.getTransaction().commit();
        session.close();
        factory.close();
        
        
    }
    
}