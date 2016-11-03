package testvh.yz.com.SQL;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by yuzhou on 2016/10/21.
 */
@Entity
public class MESSAGE {
    @Id
    private Long id;
    @Property(nameInDb = "SENDMESSAGEUID")
    private String SendMessageuid;
    @Property(nameInDb = "REVICEMESSAGEUID")
    private String reviceMessageuid;
    @Property(nameInDb = "MSG")
    private String msg;
    @Property(nameInDb = "POST")
    private String post;
    public String getPost() {
        return this.post;
    }
    public void setPost(String post) {
        this.post = post;
    }
    public String getMsg() {
        return this.msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public String getReviceMessageuid() {
        return this.reviceMessageuid;
    }
    public void setReviceMessageuid(String reviceMessageuid) {
        this.reviceMessageuid = reviceMessageuid;
    }
    public String getSendMessageuid() {
        return this.SendMessageuid;
    }
    public void setSendMessageuid(String SendMessageuid) {
        this.SendMessageuid = SendMessageuid;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Generated(hash = 975521277)
    public MESSAGE(Long id, String SendMessageuid, String reviceMessageuid,
            String msg, String post) {
        this.id = id;
        this.SendMessageuid = SendMessageuid;
        this.reviceMessageuid = reviceMessageuid;
        this.msg = msg;
        this.post = post;
    }
    @Generated(hash = 898851207)
    public MESSAGE() {
    }

    @Override
    public String toString() {
        return "MESSAGE{" +
                "id=" + id +
                ", SendMessageuid='" + SendMessageuid + '\'' +
                ", reviceMessageuid='" + reviceMessageuid + '\'' +
                ", msg='" + msg + '\'' +
                ", post='" + post + '\'' +
                '}';
    }
}
