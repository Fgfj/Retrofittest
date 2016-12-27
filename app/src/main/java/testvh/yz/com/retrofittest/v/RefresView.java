package testvh.yz.com.retrofittest.v;

/**
 * Created by yz on 2016/12/27.
 */
public interface RefresView {
    /**
     * 上啦刷新成功
     * @param s
     */
    void setdatapullSucess(String s);
    void setdatapullError(String s);
    void setdatadownSucess(String s);
    void setdatadownError(String s);
}
