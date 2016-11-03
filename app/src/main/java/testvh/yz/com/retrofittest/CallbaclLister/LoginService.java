package testvh.yz.com.retrofittest.CallbaclLister;

import retrofit2.http.GET;
import rx.Observable;
import testvh.yz.com.retrofittest.Avd;

/**
 * Created by yuzhou on 2016/9/29.
 */
public interface LoginService {
    @GET("joke/content/list.from?key=52d4ebc7f765a59212a943a0f0b7f038&page=2&pagesize=10&sort=asc&time=1418745237")
    Observable<Avd> post();
}
