package testvh.yz.com.InterFtest;

import android.content.Context;

/**
 * Created by yuzhou on 2016/10/17.
 */
public class Ctollrtinterface {
    private TestA testA;
    private Context context;

    public Ctollrtinterface(TestA testA, Context context) {
        this.testA = testA;
        this.context = context;
    }
    public void registper(){
        testA.changename("s");
    }
}
