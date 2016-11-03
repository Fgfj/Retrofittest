package testvh.yz.com.retrofittest.m;

import testvh.yz.com.retrofittest.CallbaclLister.LoginCallback;

/**
 * Created by yuzhou on 2016/9/29.
 */
public interface LoginModel {
    void login(String username, String password, LoginCallback listener);
}
