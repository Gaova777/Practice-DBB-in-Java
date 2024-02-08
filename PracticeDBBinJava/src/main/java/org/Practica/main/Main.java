package org.Practica.main;

import org.Practica.model.Employee;
import org.Practica.repository.EmployeRepository;
import org.Practica.repository.Repository;
import org.Practica.util.DatabaseConnection;

import java.sql.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws SQLException {
        /*Connection myConn = null;
//        PreparedStatement myStamt = null;
        Statement myStamt = null;
        ResultSet myRes = null;*/

//        String url="jdbc:mysql://localhost:3306/project";
//        String user="root";
//        String pass="";
        try(Connection myConn = DatabaseConnection.getInstance()){
            Repository<Employee> repository = new EmployeRepository();
//            repository.findAll().forEach(System.out::println);

            System.out.println("---listando los empleados----");
            repository.findAll().forEach(System.out::println);
            System.out.println("\n");

            System.out.println("----Eliminando empleado---");
            repository.delete(6);

            System.out.println("\n---listando again empleado -----");
            repository.findAll().forEach(System.out::println);
            //
//            System.out.println(repository.getById(1));
        }



    }
}
