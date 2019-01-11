package mto_fk;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ClassRoom {

    @Id
    @GeneratedValue(generator = "cid")
    @GenericGenerator(name="cid", strategy="assigned")
    @Column(length=4)
    private String cid;
    private String cname;

    public ClassRoom(){

    }

    public ClassRoom(String cid, String cname) {
        this.cid = cid;
        this.cname = cname;
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
