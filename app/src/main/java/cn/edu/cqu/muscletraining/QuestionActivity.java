package cn.edu.cqu.muscletraining;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class QuestionActivity extends AppCompatActivity {

    private RadioGroup rgGender;
    private RadioGroup rgGoal;
    private RadioButton rbMale;
    private RadioButton rbFemale;
    private RadioButton rbGain;
    private RadioButton rbLose;
    int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        final Button btn = (Button)findViewById(R.id.btnBegin);
        rgGender = (RadioGroup)findViewById(R.id.rgGender);
        rgGoal = (RadioGroup)findViewById(R.id.rgGoal);
        rbMale = (RadioButton)findViewById(R.id.rbMale);
        rbFemale = (RadioButton)findViewById(R.id.rbFemale);
        rbGain = (RadioButton)findViewById(R.id.rbGain);
        rbLose = (RadioButton)findViewById(R.id.rbLose);

        rbMale.setChecked(true);
        rbGain.setChecked(true);


        rgGender.getCheckedRadioButtonId();

        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
                int a = 0;
                int b = 10;
                int femaleID = rbFemale.getId();
                int LoseID = rbLose.getId();
                if(femaleID == rgGender.getCheckedRadioButtonId()){a=1;}//if is male
                if(LoseID == rgGoal.getCheckedRadioButtonId()){b=20;}//if to lose weight
                switch (a+b){
                    case 10: index = 1;break;//male gain
                    case 11: index = 3;break;//female gain
                    case 20: index = 2;break;//male lose
                    case 21: index = 4;break;//female lse
                }
                Intent intent = new Intent();
                intent.putExtra("planIndex",index);//传递结果数据
                intent.setClass(QuestionActivity.this, MainActivity.class);
                startActivity(intent);
                finish();//无法返回开始页面
            }
        });

    }
}
