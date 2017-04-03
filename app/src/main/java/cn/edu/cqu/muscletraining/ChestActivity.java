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

public class ChestActivity extends AppCompatActivity {

    ImageView ivChestPicPure;
    ImageView ivChestPic;
    private int index;//双重判定选择的肌肉
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest);

        ivChestPicPure = (ImageView)findViewById(R.id.ivChestDetailPure);
        ivChestPic = (ImageView)findViewById(R.id.ivChestDetail);
        index = 0;
        View.OnTouchListener imgListener = new View.OnTouchListener(){
            public boolean onTouch(View v, MotionEvent event){
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    //Toast.makeText(getBaseContext(), "("+(int)event.getX()+","+(int)event.getY()+")", Toast.LENGTH_SHORT).show();
                    Bitmap bitmap = ((BitmapDrawable)ivChestPicPure.getDrawable()).getBitmap();
                    int pixel = bitmap.getPixel((int)event.getX(),(int)event.getY());
                    int redValue = Color.red(pixel);
                    int blueValue = Color.blue(pixel);
                    int greenValue = Color.green(pixel);
                    if(redValue == 255 && greenValue == 0 && blueValue == 0) {
                        ivChestPic.setImageResource(R.drawable.upchest);
                        if(index == 1)
                        {
                            Intent intent = new Intent();
                            intent.setClass(ChestActivity.this, UpChestActivity.class);
                            startActivity(intent);
                        }
                        else {
                            index = 1;
                            Toast.makeText(getBaseContext(), "Touch again to confirm", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else if(redValue == 0 && greenValue == 255 && blueValue == 0) {
                        ivChestPic.setImageResource(R.drawable.middlechest);
                        if(index == 2)
                        {
                            Intent intent = new Intent();
                            intent.setClass(ChestActivity.this, MiddleChestActivity.class);
                            startActivity(intent);
                        }
                        else {
                            index = 2;
                            Toast.makeText(getBaseContext(), "Touch again to confirm", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else if(redValue == 0 && greenValue == 0 && blueValue == 255) {
                        ivChestPic.setImageResource(R.drawable.downchest);
                        if(index == 3)
                        {
                            Intent intent = new Intent();
                            intent.setClass(ChestActivity.this, DownChestActivity.class);
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
        ivChestPicPure.setOnTouchListener(imgListener);

    }

    public void onClickBack(View v){
        ChestActivity.this.finish();
    }
}
