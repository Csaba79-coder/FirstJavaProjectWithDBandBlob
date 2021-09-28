package application.model;

import java.sql.Timestamp;
import java.util.List;

public class Members {

    private long id;
    private String name;
    private State state;
    private String email;
    private byte[] profile_picture;
    private Timestamp reg_time;

    private List<Courses> coursesList;

    public Members() {
    }

    public Members(long id, String name, State state, String email, byte[] profile_picture, Timestamp reg_time) {
        this.id = id;
        this.name = name;
        this.state = state;
        this.email = email;
        this.profile_picture = profile_picture;
        this.reg_time = reg_time;
    }

    public Members(long id, String name, State state, String email, Timestamp reg_time) {
        this.id = id;
        this.name = name;
        this.state = state;
        this.email = email;
        this.reg_time = reg_time;
    }

    public Members(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getProfile_picture() {
        return profile_picture;
    }

    public void setProfile_picture(byte[] profile_picture) {
        this.profile_picture = profile_picture;
    }

    public Timestamp getReg_time() {
        return reg_time;
    }

    public void setReg_time(Timestamp reg_time) {
        this.reg_time = reg_time;
    }

    @Override
    public String toString() {
        return id + ": " + name + " " + state + " " + email + " " + reg_time;
    }
 }
