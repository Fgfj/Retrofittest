package testvh.yz.com.retrofittest.m.bean;

/**
 * Created by yuzhou on 2016/9/29.
 */
public class UserBean {
    private String mFirstName ;
    private String mLastName ;

    public UserBean(String mFirstName, String mLastName) {
        this.mFirstName = mFirstName;
        this.mLastName = mLastName;
    }

    public String getmFirstName() {
        return mFirstName;
    }

    public void setmFirstName(String mFirstName) {
        this.mFirstName = mFirstName;
    }

    public String getmLastName() {
        return mLastName;
    }

    public void setmLastName(String mLastName) {
        this.mLastName = mLastName;
    }
}
