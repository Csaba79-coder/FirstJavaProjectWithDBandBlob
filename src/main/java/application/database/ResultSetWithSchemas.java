package application.database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultSetWithSchemas {

    public boolean getTable() {

        DatabaseMetaData dbmd = null;
        DataBaseEngine dataBaseEngine = new DataBaseEngine();
        Connection connection = dataBaseEngine.connect();

        try  {
            dbmd = connection.getMetaData();
        } catch (SQLException e) {
            System.out.println(e);

        }

        // resultset gives you a talbe
        ResultSet resultSet = null;
        try {
            resultSet = dbmd.getTables(null, "APP", Table.MEMBERS.name(), null);
            return true;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }
}
