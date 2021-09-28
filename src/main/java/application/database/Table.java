package application.database;

public enum Table {

    MEMBERS(6),
    COURSES(4),
    SUBJECTS(4);

    public final int COLUMN_NUM;

    Table(int columnNum) {
        COLUMN_NUM = columnNum;
    }
}
