/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.programa05;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Itzel
 */
public class DAOEmpleado implements IDAOGeneral<Empleado, Long>{

    @Override
    public Empleado create(Empleado p) {
        Session session = HibernateUtil.getSession(); //para la conexion
        Transaction t = session.beginTransaction();
        
        session.save(p);
        Logger.getLogger(DAOEmpleado.class.getName()).log(Level.INFO, "Se creó Empleado...");
        
        t.commit(); //para que sea persistente la infor. en la bd
        session.close();
        return p;
    }

    @Override
    public boolean delete(Long id) {
        Session session = HibernateUtil.getSession();
        Transaction t = session.beginTransaction();
        boolean res = false;
        
        Empleado emp = findById(id); 
        if (emp == null){
            res = false; //para validar que primero exista 
        } else {
            session.delete(emp);
            Logger.getLogger(DAOEmpleado.class.getName()).log(Level.INFO, "Se borró Empleado...");
            res = true;
        }
        
        t.commit();
        session.close();
        return res;
    }

    @Override
    public Empleado update(Empleado p, Long id) {
        Session session = HibernateUtil.getSession();
        Transaction t = session.beginTransaction();
        
//        session.saveOrUpdate(p); //si no existe lo crea, sino le hace update
        
        Empleado emp = findById(id); 
        if (emp != null){
            session.update(emp);
            Logger.getLogger(DAOEmpleado.class.getName()).log(Level.INFO, "Se modificó Empleado...");
        }
        
        t.commit();
        session.close();
        return emp;
    }

    @Override
    public List<Empleado> findAll() {
        Session session = HibernateUtil.getSession(); 
        Transaction t = session.beginTransaction();
        
        List<Empleado> lista = null;
        lista = session.createQuery("from empleados").list(); //es HQL y no SQL para hacer consultas en hibernate
        
        t.commit();
        session.close();
        return lista;   
    }

    @Override
    public Empleado findById(Long id) {
        Session session = HibernateUtil.getSession();
        Transaction t = session.beginTransaction();
        
        Empleado emp = null;
        emp = session.get(Empleado.class, id); //Empleado.class es un objeto de clase Empleado
        
        t.commit();
        session.close();
        return emp;
    }
      
}
