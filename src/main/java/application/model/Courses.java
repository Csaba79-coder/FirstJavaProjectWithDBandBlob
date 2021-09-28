package application.model;

import java.util.List;

public class Courses {

    private long id;
    private String course_name;
    private boolean is_daytime;
    private int length_week;

    private List<Subjects> subjectsList;

    public Courses() {
    }

    public Courses(long id, String coures_name, boolean is_daytime, int legnth_week) {
        this.id = id;
        this.course_name = coures_name;
        this.is_daytime = is_daytime;
        this.length_week = legnth_week;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public boolean isIs_daytime() {
        return is_daytime;
    }

    public void setIs_daytime(boolean is_daytime) {
        this.is_daytime = is_daytime;
    }

    public int getLength_week() {
        return length_week;
    }

    public void setLength_week(int length_week) {
        this.length_week = length_week;
    }
}
