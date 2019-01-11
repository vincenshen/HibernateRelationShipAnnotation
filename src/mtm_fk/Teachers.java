package mtm_fk;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Teachers {

    @Id
    //@GeneratedValue(generator = "tid")
    //@GenericGenerator(name = "tid", strategy = "assigned")
    @Column(length = 4)
    private String tid;
    private String tname;

    public Teachers(){}

    public Teachers(String tid, String tname) {
        this.tid = tid;
        this.tname = tname;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }
}
