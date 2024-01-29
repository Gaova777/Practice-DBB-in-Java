import java.sql.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Connection myConn = null;
//        PreparedStatement myStamt = null;
        Statement myStamt = null;
        ResultSet myRes = null;
        try {
            myConn= DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
            System.out.println("Nos CONECTAMOS");

            myStamt = myConn.createStatement();

            int rowsAffected = myStamt.executeUpdate("UPDATE employees "+"set email='gaova7@gmail.com' "+"WHERE first_name='Juan'");

            myRes = myStamt.executeQuery("SELECT * FROM employees order by pa_surname");

            while (myRes.next()){
                System.out.println(myRes.getString("first_name")+", "+myRes.getString("email"));
            }

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Algo salio mal");
        }
    }
}