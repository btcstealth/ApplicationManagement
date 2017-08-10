package DBAccess;

import java.sql.*;

public class DBConnect {

    private static DBConnect instance = null;
    private Connection con;
    private static final String driver = "com.mysql.jdbc.Driver";

    private DBConnect() {
    }

    public static DBConnect getInstance(){
        if (instance == null)
            instance = new DBConnect();

        return instance;
    }


    private boolean connect(String url, String dbName, String _userName, String _password){
        try{
            Class.forName(driver).newInstance();
            con = DriverManager.getConnection(
                   url + dbName, _userName, _password); //investigate port

            System.out.println("Connected to: " + dbName);
            return true;
        } catch(SQLException se) {
            se.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean connectToLocal(String dbName, String _userName, String _password){
        return connect("jdbc:mysql://localhost:3306/", dbName, _userName, _password);
    }

    public void closeConnection(){
        try {
            con.close();
            System.out.println("Connection closed");
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    public Connection getCon() {
        return con;
    }
}
