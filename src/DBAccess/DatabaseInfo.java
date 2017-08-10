package DBAccess;

public class DatabaseInfo {

    private static final String fullUrl = "jdbc:mysql://localhost:3306/dbtest";
    public static final String databasename = "dbtest";
    public static final String user = "root";
    public static final String pw = "";


    private static final String employeeID = "ID";
    private static final String employeeSalary = "employee_sal";
    private static final String employeeName = "name";

    public static String getEmployeeID() {
        return employeeID;
    }

    public static String getEmployeeSalary() {
        return employeeSalary;
    }

    public static String getEmployeeName() {
        return employeeName;
    }
}
