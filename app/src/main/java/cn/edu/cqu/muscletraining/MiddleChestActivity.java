package cn.edu.cqu.muscletraining;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MiddleChestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_middle_chest);
    }
    public void onClickBack(View v){
        MiddleChestActivity.this.finish();
    }
}
