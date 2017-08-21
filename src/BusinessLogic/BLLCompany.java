package BusinessLogic;

import DBAccess.DBCompany;
import DBAccess.DBConnect;
import DBAccess.DatabaseInfo;
import DBAccess.DatabaseInfoApplicationManagement;
import Model.Company;
import javafx.scene.control.ListView;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BLLCompany {
    static DBConnect con;

    private static boolean connectionOpen(){
        con = DBConnect.getInstance();
        return con.connectToLocal(DatabaseInfoApplicationManagement.databasename, DatabaseInfo.user, DatabaseInfo.pw);
    }

    public static List<Company> getAllCompanies() throws SQLException{
        if (!connectionOpen())
            throw new SQLException("Could not open connection to database");

        List<Company> companies = DBCompany.getAllCompanies();
        con.closeConnection();
        return companies;
    }

    public static Map<String, Company> getCompaniesMap(){
        Map<String, Company> companyMap = new HashMap<>();
        try {
            List<Company> companies = getAllCompanies();
            for (Company c : companies) {
                companyMap.put(c.getName(), c);
            }
        } catch (SQLException sqlE){
            sqlE.printStackTrace();
        }
        return companyMap;


    }

}
