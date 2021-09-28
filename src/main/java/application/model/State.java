package application.model;

public enum State {

    // you can get ENUM by its number!!!
    // every ENUM has a number value!
    // I can refer in SQL with the index number of the ENUM!
    // so in MySQL the enums available at the following index numbers: 1, 2, 3, 4
    // BE careful IN JAVA ENUM and the indices starts with 0!!!

    STUDENT,// in MySQL the index of the first ENUM is: 1
    TEACHER, // index: 2
    STAFF, // index: 3
    UNKNOWN; // index: 4

    @Override
    public String toString() {
        return name().toLowerCase();
    }

    public static State find(String name) {
        for (State state : State.values()) {
            if (state.name().equalsIgnoreCase(name)) {
                return state;
            }
        }
        return State.valueOf(UNKNOWN.toString());
    }

    public int getMySQLIndexFromJavaIndex() {
        // ordinal() returns the ENUM index itself!
        return (ordinal() + 1);
    }
}
