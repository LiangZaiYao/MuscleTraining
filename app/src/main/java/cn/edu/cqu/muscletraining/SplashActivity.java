package cn.edu.cqu.muscletraining;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends Activity {
    private Handler mMainHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.setClass(getApplication(), QuestionActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            finish();
            startActivity(intent);
            // overridePendingTransition must be called AFTER finish() or startActivity, or it won't work.
        }
    };

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        getWindow().setBackgroundDrawableResource(R.drawable.splash);
        mMainHandler.sendEmptyMessageDelayed(0, 2000);
    }

    // much easier to handle key events
    @Override
    public void onBackPressed() {
    }
}
