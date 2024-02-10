package org.Practica.main;

import org.Practica.model.Employee;
import org.Practica.repository.EmployeRepository;
import org.Practica.repository.Repository;
import org.Practica.util.DatabaseConnection;
import org.Practica.view.SwingApp;

import java.sql.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws SQLException {
        SwingApp app = new SwingApp();
        app.setVisible(true);
    }
}
