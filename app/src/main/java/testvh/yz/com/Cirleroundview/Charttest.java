package testvh.yz.com.Cirleroundview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import testvh.yz.com.retrofittest.R;

public class Charttest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charttest);
        ChartView chartView= (ChartView) findViewById(R.id.mychartview);
        List<PieData> list=new ArrayList<>();
        list.add(new PieData("sad",(float)0.3, Color.GREEN));
        list.add(new PieData("sad",(float)0.3, Color.BLACK));
        list.add(new PieData("sad",(float)0.4, Color.BLUE));
        chartView.setPieDataList(list);
        chartView.setOuterRadius(100);
        chartView.setTesttext("图表");
    }
}
