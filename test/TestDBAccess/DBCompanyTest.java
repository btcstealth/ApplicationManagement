package TestDBAccess;

import DBAccess.DBCompany;
import DBAccess.DBConnect;
import DBAccess.DatabaseInfo;
import DBAccess.DatabaseInfoApplicationManagement;
import Model.Company;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DBCompanyTest {

    @Test
    public void testSomething(){
        final boolean test = (1==1);
        assertTrue(test);
    }


    @Test
    public void testGetCompanyById(){
        //todo
    }

    @Test
    public void initialize(){
        //todo
    }

    @Test
    public void testGetAllCompanies(){
        DBConnect con = DBConnect.getInstance();
        con.connectToLocal(DatabaseInfoApplicationManagement.databasename, DatabaseInfo.user, DatabaseInfo.pw);

        final List<Company> companies = DBCompany.getAllCompanies();
        assertTrue(companies != null);
        assertTrue(!companies.isEmpty());
        con.closeConnection();
    }

}
