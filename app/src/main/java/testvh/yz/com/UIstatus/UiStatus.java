package testvh.yz.com.UIstatus;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import org.ayo.view.status.DefaultStatus;
import org.ayo.view.status.DefaultStatusProvider;
import org.ayo.view.status.StatusProvider;
import org.ayo.view.status.StatusUIManager;
import org.ayo.view.status.StatusUIcallBackListener;

import testvh.yz.com.retrofittest.R;

/**
 * UI切换
 */
public class UiStatus extends AppCompatActivity {
    StatusUIManager statusUIManager;
    View contentView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui_status);
        contentView = findViewById(R.id.view_content);
        initStatusUI();
        View btn_refresh = findViewById(R.id.btn_refresh);
        View btn_netoff = findViewById(R.id.btn_netoff);
        View btn_server_error = findViewById(R.id.btn_server_error);
        View btn_logic_fail = findViewById(R.id.btn_logic_fail);
        View btn_local_error = findViewById(R.id.btn_local_error);
        View btn_empty = findViewById(R.id.btn_empty);
        btn_refresh.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "正在加载...", Toast.LENGTH_SHORT).show();
                statusUIManager.show(DefaultStatus.STATUS_LOADING, new StatusUIcallBackListener.dothing() {
                    @Override
                    public void onclik() {
                        Toast.makeText(getActivity(), "点击...", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        btn_empty.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "数据为空", Toast.LENGTH_SHORT).show();
                statusUIManager.show(DefaultStatus.STATUS_EMPTY, new StatusUIcallBackListener.dothing() {
                    @Override
                    public void onclik() {
                        Toast.makeText(getActivity(), "点击...", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        btn_netoff.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "没网了", Toast.LENGTH_SHORT).show();
                statusUIManager.show(DefaultStatus.STATUS_NETOFF, new StatusUIcallBackListener.dothing() {
                    @Override
                    public void onclik() {
                        Toast.makeText(getActivity(), "点击...", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        btn_server_error.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "服务器出问题了", Toast.LENGTH_SHORT).show();
                statusUIManager.show(DefaultStatus.STATUS_SERVER_ERROR, new StatusUIcallBackListener.dothing() {
                    @Override
                    public void onclik() {
                        Toast.makeText(getActivity(), "点击...", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        btn_logic_fail.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "业务逻辑失败", Toast.LENGTH_SHORT).show();
                statusUIManager.show(DefaultStatus.STATUS_LOGIC_FAIL, new StatusUIcallBackListener.dothing() {
                    @Override
                    public void onclik() {
                        Toast.makeText(getActivity(), "点击...", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        btn_local_error.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "本地逻辑出错", Toast.LENGTH_SHORT).show();
                statusUIManager.show(DefaultStatus.STATUS_lOCAL_ERROR, new StatusUIcallBackListener.dothing() {
                    @Override
                    public void onclik() {
                        Toast.makeText(getActivity(), "点击...", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    private void initStatusUI() {
        statusUIManager = new StatusUIManager();

        statusUIManager.addStatusProvider(
                new DefaultStatusProvider.DefaultLoadingStatusView(
                        getActivity(),
                        DefaultStatus.STATUS_LOADING,
                        contentView,
                        new StatusProvider.OnStatusViewCreateCallback() {
                            @Override
                            public void onCreate(int status, View statusView) {

                            }
                        }));

        statusUIManager.addStatusProvider(
                new DefaultStatusProvider.DefaultEmptyStatusView(getActivity(),
                        DefaultStatus.STATUS_EMPTY,
                        contentView,
                        new StatusProvider.OnStatusViewCreateCallback() {
                            @Override
                            public void onCreate(int status, View statusView) {

                            }
                        }));

        statusUIManager.addStatusProvider(
                new DefaultStatusProvider.DefaultServerErrorStatusView(
                        getActivity(),
                        DefaultStatus.STATUS_SERVER_ERROR,
                        contentView,
                        new StatusProvider.OnStatusViewCreateCallback() {
                            @Override
                            public void onCreate(int status, View statusView) {

                            }
                        }));

        statusUIManager.addStatusProvider(
                new DefaultStatusProvider.DefaultLogicFailStatusView(getActivity(),
                        DefaultStatus.STATUS_LOGIC_FAIL,
                        contentView,
                        new StatusProvider.OnStatusViewCreateCallback() {
                            @Override
                            public void onCreate(int status, View statusView) {

                            }
                        }));

        statusUIManager.addStatusProvider(
                new DefaultStatusProvider.DefaultNetOffStatusView(
                        getActivity(),
                        DefaultStatus.STATUS_NETOFF,
                        contentView,
                        new StatusProvider.OnStatusViewCreateCallback() {
                            @Override
                            public void onCreate(int status, View statusView) {

                            }
                        }));

        statusUIManager.addStatusProvider(
                new DefaultStatusProvider.DefaultLocalErrorStatusView(
                        getActivity(),
                        DefaultStatus.STATUS_lOCAL_ERROR,
                        contentView,
                        new StatusProvider.OnStatusViewCreateCallback() {
                            @Override
                            public void onCreate(int status, View statusView) {

                            }
                        }));
    }
    public Context getActivity() {
        return this;
    }
}
