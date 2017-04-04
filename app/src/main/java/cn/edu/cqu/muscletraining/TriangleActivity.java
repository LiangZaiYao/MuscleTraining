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

public class TriangleActivity extends AppCompatActivity {

    ImageView ivTri;
    ImageView ivTriPure;
    private int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangle);

        ivTri = (ImageView)findViewById(R.id.ivTriangle);
        ivTriPure = (ImageView)findViewById(R.id.ivTrianglePure);
        index = 0;
        View.OnTouchListener imgListener = new View.OnTouchListener(){
            public boolean onTouch(View v, MotionEvent event){
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    //Toast.makeText(getBaseContext(), "("+(int)event.getX()+","+(int)event.getY()+")", Toast.LENGTH_SHORT).show();
                    Bitmap bitmap = ((BitmapDrawable)ivTriPure.getDrawable()).getBitmap();
                    int pixel = bitmap.getPixel((int)event.getX(),(int)event.getY());
                    int redValue = Color.red(pixel);
                    int blueValue = Color.blue(pixel);
                    int greenValue = Color.green(pixel);
                    if(redValue == 255 && greenValue == 0 && blueValue == 0) {
                        ivTri.setImageResource(R.drawable.trianglefront);
                        if(index == 1)
                        {
                            Intent intent = new Intent();
                            intent.setClass(TriangleActivity.this, TriangleFrontActivity.class);
                            startActivity(intent);
                        }
                        else {
                            index = 1;
                            Toast.makeText(getBaseContext(), "Touch again to confirm", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else if(redValue == 0 && greenValue == 255 && blueValue == 0) {
                        ivTri.setImageResource(R.drawable.trianglemiddle);
                        if(index == 2)
                        {
                            Intent intent = new Intent();
                            intent.setClass(TriangleActivity.this, TriangleMiddleActivity.class);
                            startActivity(intent);
                        }
                        else {
                            index = 2;
                            Toast.makeText(getBaseContext(), "Touch again to confirm", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else if(redValue == 0 && greenValue == 0 && blueValue == 255) {
                        ivTri.setImageResource(R.drawable.triangleback);
                        if(index == 3)
                        {
                            Intent intent = new Intent();
                            intent.setClass(TriangleActivity.this, TriangleBackActivity.class);
                            startActivity(intent);
                        }
                        else {
                            index = 3;
                            Toast.makeText(getBaseContext(), "Touch again to confirm", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else if(redValue == 255 && greenValue == 255 && blueValue == 0) {
                        ivTri.setImageResource(R.drawable.trianglexie);
                        if(index == 4)
                        {
                            Intent intent = new Intent();
                            intent.setClass(TriangleActivity.this, XiefangActivity.class);
                            startActivity(intent);
                        }
                        else {
                            index = 4;
                            Toast.makeText(getBaseContext(), "Touch again to confirm", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                return false;
            }
        };
        ivTriPure.setOnTouchListener(imgListener);
    }



    public void onClickBack(View v){
        TriangleActivity.this.finish();
    }
}
