/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package org.uv.programa05;

import org.hibernate.Session;

/**
 *
 * @author Itzel
 */
public class Programa05 {

    public static void main(String[] args) {
//        Session session = HibernateUtil.getSession();

        DAOEmpleado dao = new DAOEmpleado();
        Empleado empleado = new Empleado();
        empleado.setClave(5);
        empleado.setNombre("Rodrigo");
        empleado.setDireccion("Mariano Escobedo");
        empleado.setTelefono("27223");
        
//        dao.create(empleado);
//        dao.delete(empleado.getClave());
//        dao.update(empleado, empleado.getClave());
//        dao.findById(empleado.getClave());


    }
}
