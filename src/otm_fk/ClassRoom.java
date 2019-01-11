package otm_fk;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ClassRoom {

    @Id
    @GeneratedValue(generator = "cid")
    @GenericGenerator(name="cid", strategy="assigned")
    @Column(length=4)
    private String cid;
    private String cname;

    @OneToMany(cascade = {CascadeType.ALL}, fetch=FetchType.LAZY)
    @JoinColumn(name = "cid")
    private Set<Students> studentsSet;  // 一方持有多方的集合

    public ClassRoom(){

    }

    public ClassRoom(String cid, String cname) {
        this.cid = cid;
        this.cname = cname;
    }

    public Set<Students> getStudentsSet() {
        return studentsSet;
    }

    public void setStudentsSet(Set<Students> studentsSet) {
        this.studentsSet = studentsSet;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
