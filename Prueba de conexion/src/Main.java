import java.sql.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Connection myConn = null;
        PreparedStatement myStamt = null;
//        ResultSet myRes = null;
        try {
            myConn= DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
            System.out.println("Nos CONECTAMOS");
            String sql = "INSERT INTO employees (first_name, pa_surname) VALUES(?,?)";
            myStamt = myConn.prepareStatement(sql);
            myStamt.setString(1,"MOni");
            myStamt.setString(2,"Cano");

            int rowsAffected = myStamt.executeUpdate();
//            myRes = myStamt.executeQuery("SELECT * FROM employees");

            if (rowsAffected>0){
                System.out.println("Se ha insertado un empleado on exito");
            }

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Algo salio mal");
        }
    }
}