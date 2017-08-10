package DBAccess;

import Model.Employee;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBEmployee {

    public DBEmployee() {
    }

    public Employee getEmployee(int id){
        Employee emp = null;
        try {
            Connection con = DBConnect.getInstance().getCon();
            Statement statement = con.createStatement();
            final String query = "SELECT * FROM Employee WHERE ID = " + id;
            ResultSet res = statement.executeQuery(query);
            emp = initializeEmployee(res);
        } catch (Exception e){
            e.printStackTrace();
        }
        return emp;
    }

    private Employee initializeEmployee(ResultSet res){
        Employee emp = null;
        try {
            if (res.next()){
                res.first();
                emp = new Employee(res.getInt("ID"), res.getDouble("employee_sal"), res.getString("name"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return emp;
    }

    public List<Employee> getAllEmployee(){
        List<Employee> employees = new ArrayList<Employee>();
        try {
            Connection con = DBConnect.getInstance().getCon();
            Statement statement = con.createStatement();
            final String query = "SELECT * FROM Employee";
            ResultSet res = statement.executeQuery(query);
            employees = initializeEmployees(res);
        } catch (Exception e){
            e.printStackTrace();
        }
        return employees;
    }

    private List<Employee> initializeEmployees(ResultSet res){
        List<Employee> employees = new ArrayList<Employee>();
        try {
            while (res.next()){
                Employee emp = getEmployeeFromResultSet(res);
                employees.add(emp);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return employees;
    }

    private Employee getEmployeeFromResultSet(ResultSet res){
        Employee emp = null;
        try {
            emp = new Employee(
                            res.getInt(DatabaseInfo.getEmployeeID()),
                            res.getDouble(DatabaseInfo.getEmployeeSalary()),
                            res.getString(DatabaseInfo.getEmployeeName()));
        } catch (Exception e){
            e.printStackTrace();
        }
        return emp;
    }



}
