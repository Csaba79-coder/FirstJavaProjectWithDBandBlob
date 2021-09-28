package application.util;

import application.model.Members;

import java.sql.ResultSet;
import java.util.List;

public class Print {

    Members members = new Members();

    public Print() {
    }

    public void printString(String s) {
        System.out.println(s);
    }

    public void printList(List<Members> membersList) {
        for(Members member : membersList) {
            System.out.println(member);
        }
    }
}
