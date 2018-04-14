package dbmanager;

import com.mysql.jdbc.CallableStatement;
import data.ApartmentsTableRow;
import data.BasicTable;
import utils.ApartmentsFilter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.lang.String.format;

public class RequestsManager {
    PreparedStatement ps;
    CallableStatement cs;
    ResultSet rs;

    public void createTable(BasicTable table) {
    }

    public void updateTable(BasicTable table) {
    }

    public void dropTable(BasicTable table) {
    }

    public BasicTable<ApartmentsTableRow> getApartmentsWithParameters() {
        BasicTable<ApartmentsTableRow> apartmentsTable = new BasicTable<ApartmentsTableRow>();
        String query = "SELECT ";
        try {
            ps = ConnectionManager.getConnection().prepareStatement(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return apartmentsTable;
    }

    private String generateQuery(ApartmentsFilter filter) {
//        TODO add abstract Filter
        return null;
    }

}
