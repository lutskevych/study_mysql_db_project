package dbmanager;

import com.mysql.jdbc.CallableStatement;
import data.ApartmentsTableRow;
import data.BasicTable;
import data.BasicTableRow;
import utils.ApartmentsFilter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.lang.String.format;

public class RequestsManager {
    PreparedStatement preparedStatement;
    Statement statement;
    CallableStatement callableStatement;
    ResultSet resultSet;
    ResultSetMetaData metaData;
    Connection connection = ConnectionManager.getConnection();

    public void createTable(BasicTable table) {
    }

    public void updateTable(BasicTable table) {
    }

    public void dropTable(BasicTable table) {
    }

    public BasicTable<ApartmentsTableRow> selectApartmentsWithParameters(ApartmentsFilter filter) {
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(
                    generateSelectQueryWithEqualsCondition("apartments", filter.getMap()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return generateResultTable(resultSet);
    }

    private String generateSelectQueryWithEqualsCondition(String tableName, Map<String, String> parameters) {
        Object[] columns = parameters.keySet().toArray();
        String query = format("SELECT * FROM %s WHERE %s = %s", tableName, columns[0], parameters.get(columns[0]));
        StringBuilder sb = new StringBuilder(query);
        if (columns.length > 1) {
            for (int i = 1; i < columns.length; i++) {
                sb.append(" AND ").append(columns[i]).append(" = ").append(parameters.get(columns[i]));
            }
        }
        return sb.append(";").toString();
    }

    private BasicTable<ApartmentsTableRow> generateResultTable(ResultSet resultSet) {
        ApartmentsTableRow row;
        List<String> headers = new ArrayList<String>();
        List<ApartmentsTableRow> rows = new ArrayList<ApartmentsTableRow>();
        try {
            metaData = resultSet.getMetaData();
            for (int i = 0; i < metaData.getColumnCount(); i++) {
                headers.add(metaData.getColumnName(i));
            }
            while (resultSet.next()) {
                row = new ApartmentsTableRow();
                row.setId(resultSet.getInt("id"));
                row.setDistrict(resultSet.getString("district"));
                row.setStreet(resultSet.getString("street"));
                row.setBuilding(resultSet.getString("building"));
                row.setFlat(resultSet.getInt("flat"));
                row.setSquare(resultSet.getFloat("square"));
                row.setRoomNumbers(resultSet.getInt("number_of_rooms"));
                row.setPrice(resultSet.getInt("price"));
                rows.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new BasicTable<ApartmentsTableRow>(headers, rows);
    }

}
