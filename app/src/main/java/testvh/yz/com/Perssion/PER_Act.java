package testvh.yz.com.Perssion;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import testvh.yz.com.retrofittest.R;

public class PER_Act extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_per_);

    }

    public void testCall() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {

            // 是否需要给用户解释?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_CONTACTS)) {
                // 此处的方法最好做成异步的，而不要阻塞住当前进程，当用户看到解释作出反应后，再次申请权限
                Toast.makeText(PER_Act.this, "shouldShowRequestPermissionRationale", Toast.LENGTH_SHORT).show();
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.CALL_PHONE},
                        100);
            }
        } else {
            Toast.makeText(PER_Act.this, " 有权限call phone 进行操作", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 100) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(PER_Act.this, "有权限call phone", Toast.LENGTH_SHORT).show();
            } else {
                //用户不同意，向用户展示该权限作用
                if (!ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                    AlertDialog dialog = new AlertDialog.Builder(this)
                            .setMessage("该相册需要赋予访问电话的权限，不开启将无法正常工作！")
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
//                                    finish();
                                }
                            })
                            .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
//                                    finish();
                                }
                            }).create();
                    dialog.show();
                    return;
                }
            }
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    public void 打电话(View view) {
        testCall();
    }
}
