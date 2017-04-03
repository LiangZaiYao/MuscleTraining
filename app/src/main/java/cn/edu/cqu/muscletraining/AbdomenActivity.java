package cn.edu.cqu.muscletraining;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class AbdomenActivity extends AppCompatActivity {

    ImageView ivAbdomenPic;
    ImageView ivAbdomenPicPure;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abdomen);
        ivAbdomenPic = (ImageView)findViewById(R.id.ivAbdomenDetail);
        ivAbdomenPicPure = (ImageView)findViewById(R.id.ivAbdomenDetailPure);
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
                        //Toast.makeText(getBaseContext(), "Touch again to confirm", Toast.LENGTH_SHORT).show();
                    }
                    else if(redValue == 0 && greenValue == 255 && blueValue == 0) {
                        ivAbdomenPic.setImageResource(R.drawable.xieabdomen);
                        //Toast.makeText(getBaseContext(), "Touch again to confirm", Toast.LENGTH_SHORT).show();
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
