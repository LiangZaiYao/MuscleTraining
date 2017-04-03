package cn.edu.cqu.muscletraining;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class BackActivity extends AppCompatActivity {

    ImageView ivBackPic;
    ImageView IvBackPicPure;
    private int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back);

        ivBackPic = (ImageView)findViewById(R.id.ivBackDetail);
        IvBackPicPure = (ImageView)findViewById(R.id.ivBackDetailPure);
        index = 0;
        View.OnTouchListener imgListener = new View.OnTouchListener(){
            public boolean onTouch(View v, MotionEvent event){
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    //Toast.makeText(getBaseContext(), "("+(int)event.getX()+","+(int)event.getY()+")", Toast.LENGTH_SHORT).show();
                    Bitmap bitmap = ((BitmapDrawable)IvBackPicPure.getDrawable()).getBitmap();
                    int pixel = bitmap.getPixel((int)event.getX(),(int)event.getY());
                    int redValue = Color.red(pixel);
                    int blueValue = Color.blue(pixel);
                    int greenValue = Color.green(pixel);
                    if(redValue == 255 && greenValue == 0 && blueValue == 0) {
                        ivBackPic.setImageResource(R.drawable.xiefang);
                        if(index == 1)
                        {
                            Intent intent = new Intent();
                            //intent.setClass(BackActivity.this, XiefangActivity.class);
                            startActivity(intent);
                        }
                        else {
                            index = 1;
                            Toast.makeText(getBaseContext(), "Touch again to confirm", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else if(redValue == 0 && greenValue == 255 && blueValue == 0) {
                        ivBackPic.setImageResource(R.drawable.daxiaoyuan);
                        if(index == 2)
                        {
                            Intent intent = new Intent();
                            //intent.setClass(BackActivity.this, DaxiaoyuanActivity.class);
                            startActivity(intent);
                        }
                        else {
                            index = 2;
                            Toast.makeText(getBaseContext(), "Touch again to confirm", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else if(redValue == 0 && greenValue == 0 && blueValue == 255) {
                        ivBackPic.setImageResource(R.drawable.beikuo);
                        if(index == 3)
                        {
                            Intent intent = new Intent();
                            //intent.setClass(BackActivity.this, BeikuoActivity.class);
                            startActivity(intent);
                        }
                        else {
                            index = 3;
                            Toast.makeText(getBaseContext(), "Touch again to confirm", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                return false;
            }
        };
        IvBackPicPure.setOnTouchListener(imgListener);
    }

    public void onClickBack(View v){
        BackActivity.this.finish();
    }
}
