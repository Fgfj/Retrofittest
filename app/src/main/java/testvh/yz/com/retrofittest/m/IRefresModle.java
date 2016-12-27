package testvh.yz.com.retrofittest.m;

import testvh.yz.com.retrofittest.CallbaclLister.DownCallback;
import testvh.yz.com.retrofittest.CallbaclLister.PullCallback;

/**
 * Created by yz on 2016/12/27.
 */
public class IRefresModle implements RefresModel {

    @Override
    public void pull(PullCallback pullCallback) {
        //进行下拉刷新具体操作

    }

    @Override
    public void down(DownCallback downCallback) {
        //进行上啦刷新具体操作
    }
}
