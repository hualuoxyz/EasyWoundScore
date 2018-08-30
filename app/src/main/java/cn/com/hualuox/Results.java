package cn.com.hualuox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Results extends AppCompatActivity {

    private TextView jf;
    private TextView ss;
    private Button restart;
    private Button exit;

    private int sumScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        jf = (TextView)findViewById(R.id.jf);
        ss = (TextView)findViewById(R.id.ss);
        restart = (Button)findViewById(R.id.restart);
        exit = (Button)findViewById(R.id.exit);
        sumScore = 0;

        Intent dataIntent = getIntent();
        sumScore = dataIntent.getIntExtra("sumScore",-2);

        String zspf = sumScore + "分";
        jf.setText(zspf);

        if(sumScore==12)
        {
            ss.setText("轻伤");
        }else if(sumScore>=10&&sumScore<=11)
        {
            ss.setText("中等伤");
        }else if(sumScore>=6&&sumScore<=9)
        {
            ss.setText("重伤");
        }else if(sumScore<=5)
        {
            ss.setText("危重伤");
        }

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Results.this,BreathRate.class);
                startActivity(intent);
                Results.this.finish();
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Results.this.finish();
            }
        });
    }
}
