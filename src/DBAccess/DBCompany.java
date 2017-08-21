package DBAccess;

import Model.Company;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBCompany {
    private DBCompany() {
    }


    public static Company getCompanyById(int id) {
        Company company = null;
        try {
            Connection con = DBConnect.getInstance().getCon();
            Statement statement = con.createStatement();
            final String query = "SELECT * FROM Company WHERE id = " + id;
            ResultSet res = statement.executeQuery(query);
            company = initialize(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return company;
    }

    private static Company initialize(ResultSet res) {
        Company company = null;
        try {
            if (res.next()) {
                res.first();
                company = getCompanyFromResultSet(res);
            }
        } catch (java.sql.SQLException sqe) {
            sqe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return company;
    }

    public static List<Company> getAllCompanies() {
        List<Company> companies = new ArrayList<Company>();

        try {
            Connection con = DBConnect.getInstance().getCon();
            Statement statement = con.createStatement();
            final String query = "SELECT * FROM Company";
            ResultSet res = statement.executeQuery(query);
            companies = initializeCompanies(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return companies;
    }

    private static List<Company> initializeCompanies(ResultSet res) {
        List<Company> companies = new ArrayList<Company>();
        try {
            while (res.next()) {
                Company comp = getCompanyFromResultSet(res);
                companies.add(comp);
            }
        } catch (java.sql.SQLException sqe) {
            sqe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return companies;
    }

    private static Company getCompanyFromResultSet(ResultSet res) throws java.sql.SQLException {
        return new Company(res.getInt(CompanyTableInfo.COLUMN_ID),
                res.getString(CompanyTableInfo.COLUMN_NAME),
                res.getString(CompanyTableInfo.COLUMN_ADDRESS),
                res.getString(CompanyTableInfo.COLUMN_BUSINESS_DOMAIN),
                res.getString(CompanyTableInfo.COLUMN_URL),
                res.getInt(CompanyTableInfo.COLUMN_RATING));
    }


    /*
    public <T> T getById(int id, String column){
        T emp = null;
        try {
            Connection con = DBConnect.getInstance().getCon();
            Statement statement = con.createStatement();
            final String query = "SELECT * FROM " + column + " WHERE ID = " + id;
            ResultSet res = statement.executeQuery(query);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    */
}
