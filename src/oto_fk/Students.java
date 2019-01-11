package oto_fk;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Students {

    private IdCard card;
    private int sid;
    private String gender;
    private Date birthday;
    private String major;

    public Students(){

    }

    public Students(IdCard card, String gender, Date birthday, String major) {
        this.gender = gender;
        this.birthday = birthday;
        this.major = major;
        this.card = card;
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="pid", unique = true)
    public IdCard getCard() {
        return card;
    }

    public void setCard(IdCard card) {
        this.card = card;
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
