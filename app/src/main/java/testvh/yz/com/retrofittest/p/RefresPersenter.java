package testvh.yz.com.retrofittest.p;

import testvh.yz.com.retrofittest.CallbaclLister.DownCallback;
import testvh.yz.com.retrofittest.CallbaclLister.PullCallback;
import testvh.yz.com.retrofittest.m.IRefresModle;
import testvh.yz.com.retrofittest.v.RefresView;

/**
 * Created by yz on 2016/12/27.
 */
public class RefresPersenter {
    RefresView refresView;
    IRefresModle iRefresModle;

    public RefresPersenter(RefresView refresView) {
        this.refresView = refresView;
        iRefresModle=new IRefresModle();
    }
    public void pull(){
        iRefresModle.pull(new PullCallback() {
            @Override
            public void sucess(String s) {
               refresView.setdatapullSucess(s);
            }

            @Override
            public void error(String s) {
                refresView.setdatapullError(s);
            }
        });
    }
    public void down(){
        iRefresModle.down(new DownCallback() {
            @Override
            public void sucess(String s) {
                refresView.setdatadownSucess(s);
            }

            @Override
            public void error(String s) {
                refresView.setdatadownError(s);
            }
        });
    }
}
