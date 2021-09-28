package application.database;

import application.model.Members;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.PreparedStatement;

public class HandleImageInMySQL {

    public InputStream readPic() {

        try {
            return new FileInputStream("src/main/resources/CsabaVadasz.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean addPhoto(Members members) {

        String query = "INSERT INTO Members(name, state, email, profile_picture) VALUES(?, ?, ?, ?);";

        InputStream value = readPic();

        try {
            PreparedStatement preparedStatement = new DataBaseEngine().connect().prepareStatement(query);
            preparedStatement.setString(1, "CsabaHope");
            preparedStatement.setString(2, String.valueOf("student"));
            preparedStatement.setString(3, "csabahope@progmatic.hu");
            preparedStatement.setBlob(4, value);

            preparedStatement.executeUpdate();
            preparedStatement.close();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
