package org.Practica.main;

import org.Practica.model.Employee;
import org.Practica.repository.EmployeRepository;
import org.Practica.repository.Repository;
import org.Practica.util.DatabaseConnection;
//import org.Practica.view.SwingApp;

import java.sql.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws SQLException {
//        SwingApp app = new SwingApp();
//        app.setVisible(true);
        try (Connection myConn = DatabaseConnection.getInstance()) {
            if (myConn.getAutoCommit()) {
                myConn.setAutoCommit(false);
            }

        try {
            Repository<Employee> repository = new EmployeRepository(myConn);

            System.out.println("-----Insertart un nuevo Empleado-----");
            Employee  employee = new Employee();
            employee.setFirst_name("America");
            employee.setPa_surname("Garcia");
            employee.setMa_surname("Garcia");
            employee.setEmail("am@m.com");
            employee.setSalary(3999F);
            employee.setCurp("AMEC234Y91JOLPSDET");
            repository.save(employee);
            myConn.commit();
        } catch (SQLException e) {
            myConn.rollback();//se regresa al ultimo estado de la base de datos en caso de problemas una buen excepcion
            throw new RuntimeException(e);
        }
        }

    }
}
