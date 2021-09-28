package application.model;

public class Subjects {

    private long id;
    private String subject_name;
    private long credit;
    private long length_hour;

    public Subjects() {
    }

    public Subjects(long id, String subject_name, long credit, long length_hour) {
        this.id = id;
        this.subject_name = subject_name;
        this.credit = credit;
        this.length_hour = length_hour;
    }

    public Subjects(String subject_name, long credit, long length_hour) {
        this.subject_name = subject_name;
        this.credit = credit;
        this.length_hour = length_hour;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public long getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public long getLength_hour() {
        return length_hour;
    }

    public void setLength_hour(int length_hour) {
        this.length_hour = length_hour;
    }

    @Override
    public String toString() {
        return id + ": " + subject_name + " " + credit + " " + length_hour;
    }
}
