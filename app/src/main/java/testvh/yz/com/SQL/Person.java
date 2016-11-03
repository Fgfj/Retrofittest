package testvh.yz.com.SQL;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by yuzhou on 2016/10/21.
 */
@Entity
public class Person {
    @Id
    private Long id;
    @Property(nameInDb = "USERNAME")
    private String Personname;
    public String getPersonname() {
        return this.Personname;
    }
    public void setPersonname(String Personname) {
        this.Personname = Personname;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Generated(hash = 2067582551)
    public Person(Long id, String Personname) {
        this.id = id;
        this.Personname = Personname;
    }
    @Generated(hash = 1024547259)
    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", Personname='" + Personname + '\'' +
                '}';
    }
}
