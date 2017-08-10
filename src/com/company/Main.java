package com.company;

import DBAccess.*;
import Model.Company;
import Model.Employee;

import java.util.List;

public class Main {

    public static void exampleQuery(DBConnect con){
        //query it
        DBEmployee employeeQuery = new DBEmployee();
        List<Employee> employees = employeeQuery.getAllEmployee();

        employees.stream().forEach(e -> System.out.println("Employee ID: " + e.getID() + "\n" +
                "Name: " + e.getName() + "\n" +
                "Salary: " + e.getSalary()
        ));


        Employee e3 = employeeQuery.getEmployee(3);
        System.out.println(e3.getID() + " " + e3.getName() + " " + e3.getSalary());
    }




    public static void main(String[] args) {

        DBConnect con = DBConnect.getInstance();
        con.connectToLocal(DatabaseInfoApplicationManagement.databasename, DatabaseInfo.user, DatabaseInfo.pw);


        Company comp1 = DBCompany.getCompanyById(1);
        System.out.println(comp1.toString());
    }


}
