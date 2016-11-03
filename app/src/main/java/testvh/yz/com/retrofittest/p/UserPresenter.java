package testvh.yz.com.retrofittest.p;

import testvh.yz.com.retrofittest.m.IUserModel;
import testvh.yz.com.retrofittest.m.UserModel;
import testvh.yz.com.retrofittest.m.bean.UserBean;
import testvh.yz.com.retrofittest.v.IUserView;

/**
 * Created by yuzhou on 2016/9/29.
 */
public class UserPresenter {
    private IUserView mUserView ;
    private IUserModel mUserModel ;

    public UserPresenter (IUserView view) {
        mUserView = view;
        mUserModel = new UserModel();
    }

    public void saveUser( int id , String firstName , String lastName) {
        mUserModel .setID (id );
        mUserModel .setFirstName (firstName );
        mUserModel .setLastName (lastName );
    }

    public void loadUser( int id ) {
        UserBean user = mUserModel .load (id );
        mUserView .setFirstName (user .getmFirstName());//通过调用IUserView的方法来更新显示
        mUserView .setLastName (user .getmLastName());
    }
}
