package testvh.yz.com.retrofittest.p;

import testvh.yz.com.retrofittest.CallbaclLister.LoginCallback;
import testvh.yz.com.retrofittest.m.ILoginModel;
import testvh.yz.com.retrofittest.v.LoginView;

/**
 * Created by yuzhou on 2016/9/29.
 */
public class LoginPersenter {
    private ILoginModel loginModel;
    private LoginView loginView;

    public LoginPersenter(LoginView loginView) {
        this.loginView = loginView;
        loginModel=new ILoginModel();
    }
    public void Login(String username, String password){
        loginModel.login(username, password, new LoginCallback() {
            @Override
            public void sucess(String s) {
                loginView.showtoast(s);
            }

            @Override
            public void error(String s) {

            }
        });
    }
}
