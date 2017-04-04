package cn.edu.cqu.muscletraining;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class BeikuoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beikuo);
    }
    public void onClickBack(View v){
        BeikuoActivity.this.finish();
    }
}
