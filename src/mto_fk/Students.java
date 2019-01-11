package mto_fk;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Students {

    private int sid;
    private String name;
    private String gender;
    private Date birthday;
    private String major;
    private ClassRoom classRoom;

    public Students(){

    }

    public Students(String name, String gender, Date birthday, String major) {
        this.gender = gender;
        this.birthday = birthday;
        this.major = major;
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)    // ManyToOne的FetchType为EAGER, OneToMany的FetchType为LAZY
    @JoinColumn(name="cid")
    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }

    @Override
    public String toString() {
        return "Students{" +
                "sid=" + sid +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", major='" + major + '\'' +
                '}';
    }
}

