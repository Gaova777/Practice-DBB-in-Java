package org.Practica.main;

import org.Practica.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        /*Connection myConn = null;
//        PreparedStatement myStamt = null;
        Statement myStamt = null;
        ResultSet myRes = null;*/

//        String url="jdbc:mysql://localhost:3306/project";
//        String user="root";
//        String pass="";
        try(Connection myConn = DatabaseConnection.getInstance();
            Statement myStamt = myConn.createStatement();
            ResultSet myRes     = myStamt.executeQuery("SELECT * FROM employees order by pa_surname"); ) {

            System.out.println("Nos CONECTAMOS");


            while (myRes.next()){
                System.out.println(myRes.getString("first_name")+", "+myRes.getString("email"));
            }

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Algo salio mal");
        }
    }
}
