package cn.com.hualuox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Consciousness extends AppCompatActivity {

    private RadioGroup epmenu;
    private RadioGroup trmenu;
    private RadioGroup bmmenu;
    private int sumScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consciousness);

        epmenu = (RadioGroup)findViewById(R.id.ep_menu);
        trmenu = (RadioGroup)findViewById(R.id.tr_menu);
        bmmenu = (RadioGroup)findViewById(R.id.bm_menu);
        Button jgBtn = (Button)findViewById(R.id.jg_btn);
        sumScore = 0;

        Intent dataIntent = getIntent();
        sumScore = dataIntent.getIntExtra("sumScore",-2);

        jgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int epid = epmenu.getCheckedRadioButtonId();
                int trid = trmenu.getCheckedRadioButtonId();
                int bmid = bmmenu.getCheckedRadioButtonId();
                int sumcationScore = 0;
                int cationScore = 0;
                int epScore = 0;
                int trScore = 0;
                int bmScore = 0;

                if(epid == -1 || trid == -1 || bmid == -1)
                {
                    Toast.makeText(Consciousness.this,"请在每个项目中选择一个选项后继续！", Toast.LENGTH_SHORT).show();
                }
                else {
                    switch(epid)
                    {
                        case R.id.ep_1:epScore = 4;break;
                        case R.id.ep_2:epScore = 3;break;
                        case R.id.ep_3:epScore = 2;break;
                        case R.id.ep_4:epScore = 1;break;
                    }
                    switch(trid)
                    {
                        case R.id.tr_1:trScore = 5;break;
                        case R.id.tr_2:trScore = 4;break;
                        case R.id.tr_3:trScore = 3;break;
                        case R.id.tr_4:trScore = 2;break;
                        case R.id.tr_5:trScore = 1;break;
                    }
                    switch(bmid)
                    {
                        case R.id.bm_1:bmScore = 6;break;
                        case R.id.bm_2:bmScore = 5;break;
                        case R.id.bm_3:bmScore = 4;break;
                        case R.id.bm_4:bmScore = 3;break;
                        case R.id.bm_5:bmScore = 2;break;
                        case R.id.bm_6:bmScore = 1;break;
                    }
                    sumcationScore = epScore + trScore + bmScore;
                    if (sumcationScore <= 3)
                    {
                        cationScore = 0;
                    }
                    else if (sumcationScore<=5)
                    {
                        cationScore = 1;
                    }
                    else if(sumcationScore<=8)
                    {
                        cationScore = 2;
                    }
                    else if(sumcationScore<=12)
                    {
                        cationScore = 3;
                    }

                    else if(sumcationScore<=15)
                    {
                        cationScore = 4;
                    }
                    sumScore += cationScore;
                    Intent intent = new Intent(Consciousness.this,Results.class);
                    intent.putExtra("sumScore",sumScore);
                    startActivity(intent);
                    Consciousness.this.finish();
                }
            }
        });
    }
}
