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

public class AbdomenActivity extends AppCompatActivity {

    ImageView ivAbdomenPic;
    ImageView ivAbdomenPicPure;
    private int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abdomen);
        ivAbdomenPic = (ImageView)findViewById(R.id.ivAbdomenDetail);
        ivAbdomenPicPure = (ImageView)findViewById(R.id.ivAbdomenDetailPure);
        index = 0;

        View.OnTouchListener imgListener = new View.OnTouchListener(){
            public boolean onTouch(View v, MotionEvent event){
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    //Toast.makeText(getBaseContext(), "("+(int)event.getX()+","+(int)event.getY()+")", Toast.LENGTH_SHORT).show();
                    Bitmap bitmap = ((BitmapDrawable)ivAbdomenPicPure.getDrawable()).getBitmap();
                    int pixel = bitmap.getPixel((int)event.getX(),(int)event.getY());
                    int redValue = Color.red(pixel);
                    int blueValue = Color.blue(pixel);
                    int greenValue = Color.green(pixel);
                    if(redValue == 255 && greenValue == 0 && blueValue == 0) {
                        ivAbdomenPic.setImageResource(R.drawable.zhiabdomen);
                        if(index == 1)//confirm touch
                        {
                            Intent intent = new Intent();
                            intent.setClass(AbdomenActivity.this, ZhiAbdomenActivity.class);
                            startActivity(intent);
                        }
                        else {//first touch
                            index = 1;
                            Toast.makeText(getBaseContext(), "Touch again to confirm", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else if(redValue == 0 && greenValue == 255 && blueValue == 0) {
                        ivAbdomenPic.setImageResource(R.drawable.xieabdomen);
                        if(index == 2)
                        {
                            Intent intent = new Intent();
                            intent.setClass(AbdomenActivity.this, XieAbdomenActivity.class);
                            startActivity(intent);
                        }
                        else {
                            index = 2;
                            Toast.makeText(getBaseContext(), "Touch again to confirm", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                return false;
            }
        };
        ivAbdomenPicPure.setOnTouchListener(imgListener);

    }

    public void onClickBack(View v){
        AbdomenActivity.this.finish();
    }
}
