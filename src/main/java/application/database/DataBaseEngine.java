package application.database;

import application.model.Courses;
import application.model.Members;
import application.model.State;
import application.model.Subjects;

import java.sql.*;
import java.util.*;

public class DataBaseEngine {

    // TODO refactor the name of database and table names into variables! -> cab be separate static class! as a helper or util
    // TODO use public static final variables in this case! if you change anything on code enough to modify at one certain place!
    // make a configuration file with all data's like ip, how to reach database, variables, etc. username, password ...
    // TODO stop code repetition!!!

    private final Connection CONNECTION;

    public DataBaseEngine() {
        // TODO
        CONNECTION = connect();
    }

    public boolean isConnected() {
        return (CONNECTION != null);
    }

    // I made it to package private to use it all over in this database package!

    Connection connect() {
        // here I connect to 1 database, not to mysql!!!
        // this connects to mysql jdbc:mysql://localhost:3306/
        // local host is the ip where the server is situated!
        String url = "jdbc:mysql://localhost:3306/" + System.getenv("DATABASE_PROJECT_NAME") +
                 "?" +
                "useUniCode=yes" +
                "&" +
                "characterEncoding=UTF-8";
        Properties properties = new Properties();
        properties.put("user", System.getenv("DATABASE_USER"));
        properties.put("password", System.getenv("DATABASE_PASSWORD"));

        try {
            return DriverManager.getConnection(url, properties);
        } catch (SQLException e) {
            e.printStackTrace(); // writes the whole problem!
        }
        return null;
    }

    /* I want to select all Members from Members TABLE! */

    public List<Members> listAllMembers() {
        String query = "SELECT * FROM " + DataBaseVariables.TABLE_MEMBERS + ";";

        List<Members> membersList = new ArrayList<>();

        try {
            // Statement statement = connect().createStatement();
            Statement statement = Objects.requireNonNull(connect()).createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            // from resultSet put the result into membersList!!!

            while (resultSet.next()) {
                // resultSet.getLong(1); // which column in DB
                long id = resultSet.getLong("ID"); // how it called in the DB!
                // resultSet.getString(2);
                String name = resultSet.getString("name");
                // resultSet.getString(3);
                String stateFromDataBase = resultSet.getString("state"); // ENUM!
                State state = State.find(stateFromDataBase);
                // resultSet.getString(4);
                String email = resultSet.getString("email");
                // resultSet.getBlob(5);
                // Blob profile_picture = resultSet.getBlob("profile_picture");
                // resultSet.getTimestamp(6);
                Timestamp reg_time = resultSet.getTimestamp("reg_time");

                Members member = new Members(id, name, state, email, reg_time);

                membersList.add(member);
            }
        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
        }

        return membersList;
    }

    public Members findMembersByName(String nameSearch) {
        String query = "SELECT * FROM " + DataBaseVariables.TABLE_MEMBERS + " WHERE name = " + nameSearch;
        // String query = "SELECT * FROM members WHERE name = 'e'; DROP DATABASE firstDBJava; --" // watch out drops the whole DB!!!

        Members result = null;

        try {
            // Statement statement = connect().createStatement();
            Statement statement = Objects.requireNonNull(connect()).createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            // from resultSet put the result into membersList!!!


            while (resultSet.next()) {
                // resultSet.getLong(1); // which column in DB
                long id = resultSet.getLong("ID"); // how it called in the DB!
                // resultSet.getString(2);
                String name = resultSet.getString("name");
                // resultSet.getString(3);
                String stateFromDataBase = resultSet.getString("state"); // ENUM!
                State state = State.find(stateFromDataBase);
                // resultSet.getString(4);
                String email = resultSet.getString("email");
                // resultSet.getBlob(5);
                // Blob profile_picture = resultSet.getBlob("profile_picture");
                // resultSet.getTimestamp(6);
                Timestamp reg_time = resultSet.getTimestamp("reg_time");

                result = new Members(id, name, state, email, reg_time);

            }
        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Members findMembersByNameAnotherWay(String nameSearch) {
        String query2 = "SELECT * FROM " + DataBaseVariables.TABLE_MEMBERS + " WHERE name = ?";
        // String query = "SELECT * FROM members WHERE name = 'e'; DROP DATABASE firstDBJava; --" // watch out drops the whole DB!!!

        Members result = null;

        try {
            // Statement statement = connect().createStatement();
            Statement statement = Objects.requireNonNull(connect()).createStatement();
            // PreparedStatement preparedStatement = connect().prepareStatement(query2);
            PreparedStatement preparedStatement = Objects.requireNonNull(connect()).prepareStatement(query2);
            preparedStatement.setString(1, nameSearch);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                // resultSet.getLong(1); // which column in DB
                long id = resultSet.getLong("ID"); // how it called in the DB!
                // resultSet.getString(2);
                String name = resultSet.getString("name");
                // resultSet.getString(3);
                String stateFromDataBase = resultSet.getString("state"); // ENUM!
                State state = State.find(stateFromDataBase);
                // resultSet.getString(4);
                String email = resultSet.getString("email");
                // resultSet.getBlob(5);
                // Blob profile_picture = resultSet.getBlob("profile_picture");
                // resultSet.getTimestamp(6);
                Timestamp reg_time = resultSet.getTimestamp("reg_time");

                result = new Members(id, name, state, email, reg_time);
            }
        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Subjects findSubjectsByName(String name) {
        String query = "SELECT * FROM " + DataBaseVariables.TABLE_SUBJECTS + " WHERE subject_name = ?";

        Subjects subjects = null;

        try {
            PreparedStatement preparedStatement = Objects.requireNonNull(connect()).prepareStatement(query);
            preparedStatement.setString(1, name);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                long ID = resultSet.getLong("ID");
                String subject_name = resultSet.getString("subject_name");
                long credit = resultSet.getLong("credit");
                long length_hour = resultSet.getLong("length_hour");

                subjects = new Subjects(ID, subject_name, credit, length_hour);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subjects;
    }

    public List<Courses> findMembersToCourses(long member_ID) {
        String query = "SELECT * FROM " + DataBaseVariables.TABLE_SUBJECTS + " WHERE subject_name = ?";

        List<Courses> coursesList = new ArrayList<>();

        try {
            
            PreparedStatement preparedStatement = Objects.requireNonNull(connect()).prepareStatement(query);
            preparedStatement.setLong(1, member_ID);

            System.out.println("member ID: " + member_ID);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String subject_name = resultSet.getString("subject_name");
                Subjects subjects = findSubjectsByName(subject_name);
                System.out.println(subjects);
                // this is empty in my case, find the correct relation!!!
                // TODO find the make the switchboard here! to represent the switch panel!
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return coursesList;
    }

    public Members findMemberByNameWithBuilder(String nameSearch) {
        String query = new QueryBuilder().select(Table.MEMBERS).where(Column.NAME, false).build();

        Members members = null;

        try {
            PreparedStatement preparedStatement = connect().prepareStatement(query);
            preparedStatement.setString(1, nameSearch);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                long id = resultSet.getLong("ID");
                String name = resultSet.getString("name");
                String stateFromDataBase = resultSet.getString("state");
                State state = State.find(stateFromDataBase);
                String email = resultSet.getString("email");
                Timestamp reg_time = resultSet.getTimestamp("reg_time");

                members = new Members(id, name, state, email, reg_time);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return members;
    }
}
