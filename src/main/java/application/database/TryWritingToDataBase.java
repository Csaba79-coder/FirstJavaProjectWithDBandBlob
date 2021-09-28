package application.database;

import application.model.Members;

public class TryWritingToDataBase {

    DataBaseEngine dataBaseEngine = new DataBaseEngine();

    // it worked! Flóra was inserted as a new value and state ENUM was unknown as default!

    public void tryAddANewMemberToDataBase() {
        if (dataBaseEngine.isConnected()) {
            Members members = new Members("Flóra", "flora@flora.com");
            boolean success = new WritingToDatabase().addMembersToDataBase(members);
            System.out.println(success);
        } else {
            System.out.println("There is no connection to database!");
        }
    }
}
