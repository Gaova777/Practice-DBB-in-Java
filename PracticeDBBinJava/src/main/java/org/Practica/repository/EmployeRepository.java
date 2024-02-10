package org.Practica.repository;

import org.Practica.model.Employee;
import org.Practica.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeRepository implements Repository<Employee> {


    //    private Connection getConnection() throws SQLException {
//        return DatabaseConnection.getInstance();
//    }
   private Connection getConnection() throws  SQLException{
       return DatabaseConnection.getConnection();
   }


    @Override
    public List<Employee> findAll() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        try(Connection myConn = getConnection();
            Statement myStatement = myConn.createStatement();
            ResultSet myRes = myStatement.executeQuery("SELECT * FROM employees")){
            while(myRes.next()){
                Employee e = createEmployee(myRes);
                employees.add(e);
            }
        }
        return  employees;
    }



    @Override
    public Employee getById(Integer id) throws SQLException {
        Employee employee = null;
        try(Connection myConn = getConnection();
                PreparedStatement myStatement = myConn.prepareStatement("SELECT * FROM employees WHERE id = ?")){
            myStatement.setInt(1,id);
            try(ResultSet myRes = myStatement.executeQuery()) {
                if(myRes.next()){
                    employee = createEmployee(myRes);
                }
            }
        }
        return  employee;
    }

    @Override
    public void save(Employee employee) throws SQLException {
        String sql;
        if(employee.getId()!=null && employee.getId()>0){
            sql = "UPDATE employees SET first_name = ?, pa_surname=?,ma_surname=?, email=?, salary=?, curp=? WHERE id =?";
        }else{
            sql = "INSERT INTO employees (first_name, pa_surname,ma_surname,email,salary, curp) VALUES(?,?,?,?,?,?)";
        }


        try(Connection myConn = getConnection();
                PreparedStatement myStatement = myConn.prepareStatement(sql)){
            myStatement.setString(1,employee.getFirst_name());
            myStatement.setString(2,employee.getPa_surname());
            myStatement.setString(3,employee.getMa_surname());
            myStatement.setString(4,employee.getEmail());
            myStatement.setFloat(5,employee.getSalary());
            myStatement.setString(6,employee.getCurp());
           if(employee.getId()!=null && employee.getId()>0){
               myStatement.setInt(7,employee.getId());
           }
            myStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try(Connection myConn = getConnection();
                PreparedStatement myStatement = myConn.prepareStatement("DELETE FROM employees WHERE id =?")){
            myStatement.setInt(1,id);
            myStatement.executeUpdate();
        }
    }

    private Employee createEmployee(ResultSet myRes) throws SQLException {
        Employee e = new Employee();
        e.setId(myRes.getInt("id"));
        e.setFirst_name(myRes.getString("first_name"));
        e.setPa_surname(myRes.getString("pa_surname"));
        e.setMa_surname(myRes.getString("ma_surname"));
        e.setEmail(myRes.getString("email"));
        e.setSalary(myRes.getFloat("salary"));
        e.setCurp(myRes.getString("curp"));
       return e;
    }
}
