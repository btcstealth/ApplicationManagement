package TestDBAccess;

import DBAccess.DBConnect;
import DBAccess.DatabaseInfo;
import DBAccess.DatabaseInfoApplicationManagement;
import org.junit.Test;
import static org.junit.Assert.*;


public class DBConnectionTest {
    @Test
    public void testConnectToLocal(){
        DBConnect con = DBConnect.getInstance();
        final boolean isConnected = con.connectToLocal(DatabaseInfoApplicationManagement.databasename, DatabaseInfo.user, DatabaseInfo.pw);
        assertTrue(isConnected);
        con.closeConnection();
    }
}
