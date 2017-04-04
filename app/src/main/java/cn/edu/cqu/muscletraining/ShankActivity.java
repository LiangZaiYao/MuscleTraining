package cn.edu.cqu.muscletraining;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ShankActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shank);
    }
    public void onClickBack(View v){
        ShankActivity.this.finish();
    }
}
