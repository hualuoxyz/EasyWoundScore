package cn.com.hualuox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class BreathRate extends AppCompatActivity {

    private RadioGroup brMenu;
    private int breathScore;
    private int sumScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breath_rate);

        brMenu = (RadioGroup)findViewById(R.id.br_menu);
        Button brBtn = (Button)findViewById(R.id.br_btn);
        sumScore = 0;
        breathScore = 0;

        brBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = brMenu.getCheckedRadioButtonId();
                if (id == -1)
                {
                    Toast.makeText(BreathRate.this,"请选择一个选项后继续！",Toast.LENGTH_SHORT).show();
                    breathScore = -1;
                }
                else
                {
                    switch(id)
                    {
                        case R.id.bp_1:breathScore = 3;break;
                        case R.id.bp_2:breathScore = 4;break;
                        case R.id.bp_3:breathScore = 2;break;
                        case R.id.bp_4:breathScore = 1;break;
                        case R.id.bp_5:breathScore = 0;break;
                    }
                    sumScore += breathScore;
                    Intent intent = new Intent(BreathRate.this,SystolicPressure.class);
                    intent.putExtra("sumScore",sumScore);
                    startActivity(intent);
                    BreathRate.this.finish();
                }
            }
        });

    }
}
