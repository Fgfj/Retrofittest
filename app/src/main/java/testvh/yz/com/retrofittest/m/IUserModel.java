package testvh.yz.com.retrofittest.m;

import testvh.yz.com.retrofittest.m.bean.UserBean;

/**
 * Created by yuzhou on 2016/9/29.
 */
public interface IUserModel {
    void setID (int id);
    void setFirstName (String firstName);
    void setLastName (String lastName);
    int getID();
    UserBean load (int id);//通过id读取user信息,返回一个UserBean
}
