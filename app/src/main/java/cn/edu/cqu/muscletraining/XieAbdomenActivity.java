package cn.edu.cqu.muscletraining;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class XieAbdomenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xie_abdomen);
    }
    public void onClickBack(View v){
        XieAbdomenActivity.this.finish();
    }
}
