package application.database;

import application.model.Members;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.Objects;

public class WritingToDatabase {

    DataBaseEngine dataBaseEngine = new DataBaseEngine();

    // boolean just to know if it was successful! (it can be also void, but does not give back result!)

    public boolean addMembersToDataBase(Members members) {
        String query = "INSERT INTO " + DataBaseVariables.TABLE_MEMBERS + "(name, email) VALUES (?, ?);";

        try {
            PreparedStatement preparedStatement = Objects.requireNonNull(dataBaseEngine.connect()).prepareStatement(query);
            preparedStatement.setString(1, members.getName());
            preparedStatement.setString(2, members.getEmail());
            // preparedStatement.setInt(3, members.getState().getMySQLIndexFromJavaIndex()); // but 3rd question mark is needed! in this case!

            preparedStatement.executeUpdate();
            preparedStatement.close();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
