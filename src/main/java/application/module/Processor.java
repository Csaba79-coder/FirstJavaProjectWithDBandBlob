package application.module;

import application.database.DataBaseEngine;
import application.database.HandleImageInMySQL;
import application.database.ResultSetWithSchemas;
import application.database.TryWritingToDataBase;
import application.model.Courses;
import application.model.Members;
import application.model.State;
import application.model.Subjects;
// import application.tantus.ImportedPrint;
import application.tantus.EntryToTheProgram;
import application.util.Print;
import application.tantus.ImageExample;

import java.util.List;

public class Processor {

    public Processor() {
    }

    public void run() {

        new EntryToTheProgram().enterTheProgram();

        // connection for existing DataBase!

        DataBaseEngine dataBaseEngine = new DataBaseEngine(); // should connect

        Print print = new Print();

        System.out.println(dataBaseEngine.isConnected());
        // System.out.println(System.getenv()); // watch out! writes your password from environment!
        // System.out.println(System.getenv("DATABASE_USER")); // gives back the user!
        // System.out.println(System.getenv("DATABASE_PASSWORD")); // prints the password of the user!

        if (dataBaseEngine.isConnected()) {
            List<Members> membersList = dataBaseEngine.listAllMembers();
            System.out.println(membersList.toString());
        } else {
            System.out.print("There is no connection to database!");
        }

        if (dataBaseEngine.isConnected()) {
            Members members = dataBaseEngine.findMembersByName("'Csaba'"); // watch out double quotation mark!
            System.out.println(members);
        } else {
            System.out.println("There is no connection to database!");
        }
        if (dataBaseEngine.isConnected()) {
            Members members = dataBaseEngine.findMembersByNameAnotherWay("Csaba"); // watch out no need extra quotation mark!
            System.out.println(members);
        } else {
            System.out.println("There is no connection to database!");
        }

        if (dataBaseEngine.isConnected()) {
            Subjects subjects = dataBaseEngine.findSubjectsByName("Bootstrap");
            System.out.println(subjects);
        } else {
            System.out.println("There is no connection to database!");
        }

        if (dataBaseEngine.isConnected()) {
            List<Courses> coursesList = dataBaseEngine.findMembersToCourses(1);
            System.out.println(coursesList);
        } else {
            System.out.println("There is no connection to database!");
        }

        State state = State.STAFF;
        System.out.println("Checking index of staff: " + state.getMySQLIndexFromJavaIndex());

        new TryWritingToDataBase().tryAddANewMemberToDataBase();

        // here bellow you may find the new added person to Members!
        if (dataBaseEngine.isConnected()) {
            List<Members> membersList = dataBaseEngine.listAllMembers();
            System.out.println(membersList);
        }

        System.out.println("--------------------------------------------------");
        System.out.println("New query with the new way:");

        if (dataBaseEngine.isConnected()) {
            Members members = dataBaseEngine.findMemberByNameWithBuilder("Csaba");
            System.out.println(members);
        }

        if (dataBaseEngine.isConnected()) {
            boolean isSuccess = new HandleImageInMySQL().addPhoto(new Members());
            System.out.println("The picture upload was success: " + isSuccess);
        }

        if (dataBaseEngine.isConnected()) {
            List<Members> membersList = dataBaseEngine.listAllMembers();
            System.out.println(membersList);
        }

        // new MyJFrame().showJFrame();
        // new DisplayProfilePic().displayPhoto();
        new ImageExample().runPicWithGui();

        // ImportedPrint.print("I am so proud of this project, let\'s start refactor!");

        // for showing later in JFrame:
        // https://stackoverflow.com/questions/13307743/displaying-jtable-in-jframe

        boolean result = new ResultSetWithSchemas().getTable();
        System.out.println("Is not empty result with Resultset: " + result);
    }
}
