package testvh.yz.com.RongyunIM;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import io.rong.imlib.model.Conversation;
import testvh.yz.com.retrofittest.R;

/**
 * 会话界面
 * Created by yz on 2016/11/4.
 */
public class ConversationActivity extends FragmentActivity {
    /**
     * 目标 Id
     */
    private String mTargetId;

    /**
     * 刚刚创建完讨论组后获得讨论组的id 为targetIds，需要根据 为targetIds 获取 targetId
     */
    private String mTargetIds;

    /**
     * 会话类型
     */
    private Conversation.ConversationType mConversationType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conversation);


    }
}
