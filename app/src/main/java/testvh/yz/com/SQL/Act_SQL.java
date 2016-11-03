package testvh.yz.com.SQL;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import testvh.yz.com.retrofittest.R;

public class Act_SQL extends AppCompatActivity {


    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act__sql);
        textView = (TextView) findViewById(R.id.SQL_textview);
//        Toast.makeText(this,"插入300条稍等,查询1,2",Toast.LENGTH_LONG).show();
        setSQL();
    }
    //数据库操作
    private void setSQL() {
        DaoSession session = GreenDaoManager.getInstance().getSession();
        MESSAGEDao messageDao = session.getMESSAGEDao();
//        for(int i=0;i<300;i++){
//            messageDao.insert(new MESSAGE(null,"1","2","1发个2的" ,"1"));
//            messageDao.insert(new MESSAGE(null,"2","1","2发个1的" ,"2"));
//            messageDao.insert(new MESSAGE(null,"3","4","3发个4的" ,"1"));
//            messageDao.insert(new MESSAGE(null,"1","3","1发个3的" ,"2"));
//        }
        messageDao.insert(new MESSAGE(null, "5", "6", "5发个6的", "2"));
        List<MESSAGE> list = messageDao.queryBuilder()
                .where(MESSAGEDao.Properties.SendMessageuid.between("1","2"),MESSAGEDao.Properties.ReviceMessageuid.between("1","2")).build().list();
//                .where(MESSAGEDao.Properties.SendMessageuid.eq("1"),MESSAGEDao.Properties.ReviceMessageuid.eq("2")).build().list();
        for (int i = 0; i < list.size(); i++) {
            Log.d("google_lenve", "MESSAGE: " + list.get(i).toString());
            textView.append("1发给2，或者2发给1 的===="+list.get(i).toString()+"/n");
        }
//        StudentDao studentDao = session.getStudentDao();
//        TeacherDao teacherDao = session.getTeacherDao();
//
//        studentDao.insert(new Student(null,"yz","xj"));
//        studentDao.insert(new Student(null,"yz","xj"));
//        studentDao.insert(new Student(null,"yz","xj"));
//        teacherDao.insert(new Teacher(null,"tec2","tec2"));
//        teacherDao.insert(new Teacher(null,"tec3","tec3"));
//        List<Student> list = studentDao.queryBuilder()
//                .where(StudentDao.Properties.Id.between(1, 10)).build().list();
//        List<Teacher> listt = teacherDao.queryBuilder()
//                .where(TeacherDao.Properties.Id.between(1, 10)).build().list();
//        for (int i = 0; i < list.size(); i++) {
//            Log.d("google_lenve", "searchStudent: " + list.get(i).toString());
//        }
//        for (int i = 0; i < listt.size(); i++) {
//            Log.d("google_lenve", "searchTecher: " + listt.get(i).toString());
//        }
    }
}
