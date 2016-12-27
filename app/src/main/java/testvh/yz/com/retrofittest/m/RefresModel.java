package testvh.yz.com.retrofittest.m;

import testvh.yz.com.retrofittest.CallbaclLister.DownCallback;
import testvh.yz.com.retrofittest.CallbaclLister.PullCallback;

/**
 * Created by yz on 2016/12/27.
 */
public interface RefresModel {
    void pull(PullCallback pullCallback);
    void down(DownCallback downCallback);
}
