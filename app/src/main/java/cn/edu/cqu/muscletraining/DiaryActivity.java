package cn.edu.cqu.muscletraining;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.litepal.crud.DataSupport;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DiaryActivity extends AppCompatActivity {

    private String Id_item;
    EditText etDiaryText;
    TextView tvNowDate;
    Button btnConfirm;
    Data data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);

        Intent intent=getIntent();
        Id_item = intent.getStringExtra("Id_Item");
        etDiaryText=(EditText)findViewById(R.id.etDiaryText);
    }


    public void save(View v) {
        if (etDiaryText.getText().length() == 0) {
            Toast.makeText(getBaseContext(), "At Least Enter Something !", Toast.LENGTH_SHORT).show();
        } else {
            SimpleDateFormat formatter = new SimpleDateFormat("yy/MM/dd HH:mm     ");
            Date curDate = new Date(System.currentTimeMillis());//获取当前时间
            String str = formatter.format(curDate);

            SimpleDateFormat df = new SimpleDateFormat("yyMMddHHmm");
            Id_item = df.format(new Date());
            Data data = new Data();
            data.setStrText(etDiaryText.getText().toString());
            data.setStrDate(str);
            data.setId_Item(Id_item);

            data.save();

            Intent intent = new Intent();
            intent.setClass(DiaryActivity.this, MainActivity.class);
            finish();
            startActivity(intent);
        }
    }

    public void cancel(View v){
        finish();
    }

}
