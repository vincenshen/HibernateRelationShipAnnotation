package mtm_fk;


import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Students {

    private int sid;
    private String name;
    private String gender;
    private Date birthday;
    private String major;

    private Set<Teachers> teachers;  // 学生持有教师的集合

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

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    public Set<Teachers> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teachers> teachers) {
        this.teachers = teachers;
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


