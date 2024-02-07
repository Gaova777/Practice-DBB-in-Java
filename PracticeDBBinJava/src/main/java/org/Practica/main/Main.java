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

            Employee employee = new Employee();
            employee.setId(4);
            employee.setFirst_name("Juan");
            employee.setPa_surname("Gutierrez");
            employee.setMa_surname("Gutierrez");
            employee.setEmail("Gutierrez@gu_gmail.om");
            employee.setSalary(50000F);
            repository.save(employee);

            System.out.println("\n---agregando empleado Juan-----");
            repository.findAll().forEach(System.out::println);
            //
//            System.out.println(repository.getById(1));
        }



    }
}
