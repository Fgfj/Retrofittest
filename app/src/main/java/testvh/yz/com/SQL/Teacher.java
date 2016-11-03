package testvh.yz.com.SQL;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by yuzhou on 2016/10/21.
 */
@Entity
public class Teacher {
    @Id
    private Long id;
    @Property(nameInDb = "TEACHERNAME")
    private String Teachername;
    @Property(nameInDb = "TEACHERNICKNAME")
    private String Teachernickename;
    public String getTeachernickename() {
        return this.Teachernickename;
    }
    public void setTeachernickename(String Teachernickename) {
        this.Teachernickename = Teachernickename;
    }
    public String getTeachername() {
        return this.Teachername;
    }
    public void setTeachername(String Teachername) {
        this.Teachername = Teachername;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Generated(hash = 1985033812)
    public Teacher(Long id, String Teachername, String Teachernickename) {
        this.id = id;
        this.Teachername = Teachername;
        this.Teachernickename = Teachernickename;
    }
    @Generated(hash = 1630413260)
    public Teacher() {
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", Teachername='" + Teachername + '\'' +
                ", Teachernickename='" + Teachernickename + '\'' +
                '}';
    }
}
