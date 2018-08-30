package cn.com.hualuox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SystolicPressure extends AppCompatActivity {

    private RadioGroup spMenu;
    private int sumScore;
    private int spScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_systolic_pressure);

        spMenu = (RadioGroup)findViewById(R.id.sp_menu);
        Button spBtn = (Button)findViewById(R.id.sp_btn);
        sumScore = 0;
        spScore = 0;

        Intent dataInten = getIntent();
        sumScore = dataInten.getIntExtra("sumScore",-2);

        spBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = spMenu.getCheckedRadioButtonId();
                if (id == -1)
                {
                    Toast.makeText(SystolicPressure.this,"请选择一个选项后继续！", Toast.LENGTH_SHORT).show();
                }
                else {
                    switch (id) {
                        case R.id.sp_1:
                            spScore = 4;
                            break;
                        case R.id.sp_2:
                            spScore = 3;
                            break;
                        case R.id.sp_3:
                            spScore = 2;
                            break;
                        case R.id.sp_4:
                            spScore = 1;
                            break;
                        case R.id.sp_5:
                            spScore = 0;
                            break;
                    }
                    sumScore += spScore;
                    Intent intent = new Intent(SystolicPressure.this, Consciousness.class);
                    intent.putExtra("sumScore", sumScore);
                    startActivity(intent);
                    SystolicPressure.this.finish();
                }
            }
        });
    }
}
