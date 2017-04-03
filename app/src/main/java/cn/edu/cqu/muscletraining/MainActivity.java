package cn.edu.cqu.muscletraining;

import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;
import android.widget.ToggleButton;

@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity {

    private String [] myStringArray = new String[5];

    ToggleButton tgbtnBody;
    ImageView bodypic;
    ImageView bodypicpure;
    ListView listPlan;
    ArrayAdapter planAdapter;
    String[] strArrayPlans;
    int planindex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        //获取上个activity传递来的数据
        Bundle bundle = getIntent().getExtras();
        planindex = bundle.getInt("planIndex");

        // 得到TabActivity中的TabHost对象
        TabHost tabHost = getTabHost();
        // 内容：采用布局文件中的布局
        LayoutInflater.from(this).inflate(R.layout.activity_main,
                tabHost.getTabContentView(), true);

        // 加上标签
        // 参数设置：新增的TabSpec的标签，标签中显示的字样
        // setContent设置内容对应的View资源标号
        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("Body\nGraphy").setContent(R.id.tab1));;
        tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("My Plan").setContent(R.id.tab2));
        tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("Society").setContent(R.id.tab3));

        tgbtnBody = (ToggleButton)findViewById(R.id.tbtnBody);
        bodypic = (ImageView)findViewById(R.id.ivBodyPic);
        bodypicpure = (ImageView)findViewById(R.id.ivBodyPicPure);
        listPlan = (ListView)findViewById(R.id.listPlan);

        tgbtnBody.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 当按钮第一次被点击时候响应的事件
                if (tgbtnBody.isChecked()) {
                    bodypicpure.setImageResource(R.drawable.backbodypuresmall);
                    bodypic.setImageResource(R.drawable.backbodysmall);
                }
                // 当按钮再次被点击时候响应的事件
                else {
                    bodypicpure.setImageResource(R.drawable.frontbodypuresmall);
                    bodypic.setImageResource(R.drawable.frontbodysmall);
                }
            }
        });


        OnTouchListener imgListener = new OnTouchListener(){
            public boolean onTouch(View v, MotionEvent event){
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    //Toast.makeText(getBaseContext(), "("+(int)event.getX()+","+(int)event.getY()+")", Toast.LENGTH_SHORT).show();
                    Bitmap bitmap = ((BitmapDrawable)bodypicpure.getDrawable()).getBitmap();
                    int pixel = bitmap.getPixel((int)event.getX(),(int)event.getY());
                    int redValue = Color.red(pixel);
                    int blueValue = Color.blue(pixel);
                    int greenValue = Color.green(pixel);
                    if(redValue == 255 && greenValue == 0 && blueValue == 0) {
                        //Toast.makeText(getBaseContext(), "胸部("+redValue+","+greenValue+","+blueValue+")", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent();
                        intent.setClass(MainActivity.this, ChestActivity.class);
                        startActivity(intent);
                    }
                    else if(redValue == 255 && greenValue == 255 && blueValue == 0) {
                        //Toast.makeText(getBaseContext(), "腹部("+redValue+","+greenValue+","+blueValue+")", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent();
                        intent.setClass(MainActivity.this, AbdomenActivity.class);
                        startActivity(intent);
                    }
                    else if(redValue == 0 && greenValue == 0 && blueValue == 255) {
                        Toast.makeText(getBaseContext(), "大腿("+redValue+","+greenValue+","+blueValue+")", Toast.LENGTH_SHORT).show();
                    }
                    else if(redValue == 221 && greenValue == 0 && blueValue == 221) {
                        Toast.makeText(getBaseContext(), "肱二头肌("+redValue+","+greenValue+","+blueValue+")", Toast.LENGTH_SHORT).show();
                    }
                    else if(redValue == 0 && greenValue == 255 && blueValue == 0) {
                        Toast.makeText(getBaseContext(), "肩膀("+redValue+","+greenValue+","+blueValue+")", Toast.LENGTH_SHORT).show();
                    }
                    else if(redValue == 255 && greenValue == 153 && blueValue == 0) {
                        //Toast.makeText(getBaseContext(), "背部("+redValue+","+greenValue+","+blueValue+")", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent();
                        intent.setClass(MainActivity.this, BackActivity.class);
                        startActivity(intent);
                    }
                    else if(redValue == 153 && greenValue == 153 && blueValue == 153) {
                        Toast.makeText(getBaseContext(), "腰部("+redValue+","+greenValue+","+blueValue+")", Toast.LENGTH_SHORT).show();
                    }
                    else if(redValue == 136 && greenValue == 0 && blueValue == 255) {
                        Toast.makeText(getBaseContext(), "臀部("+redValue+","+greenValue+","+blueValue+")", Toast.LENGTH_SHORT).show();
                    }
                    else if(redValue == 0 && greenValue == 255 && blueValue == 255) {
                        Toast.makeText(getBaseContext(), "肱三头肌("+redValue+","+greenValue+","+blueValue+")", Toast.LENGTH_SHORT).show();
                    }
                    else if(redValue == 0 && greenValue == 255 && blueValue == 255) {
                        Toast.makeText(getBaseContext(), "肱三头肌("+redValue+","+greenValue+","+blueValue+")", Toast.LENGTH_SHORT).show();
                    }
                    else if(redValue == 0 && greenValue == 121 && blueValue == 121) {
                        Toast.makeText(getBaseContext(), "小腿("+redValue+","+greenValue+","+blueValue+")", Toast.LENGTH_SHORT).show();
                    }
                }
                return false;
            }
        };
        findViewById(R.id.ivBodyPicPure).setOnTouchListener(imgListener);

        //填充ListPlan
        strArrayPlans = getResources().getStringArray(R.array.plan1);
        switch (planindex)
        {
            case 1:strArrayPlans = getResources().getStringArray(R.array.plan1);break;
            case 2:strArrayPlans = getResources().getStringArray(R.array.plan2);break;
            case 3:strArrayPlans = getResources().getStringArray(R.array.plan3);break;
            case 4:strArrayPlans = getResources().getStringArray(R.array.plan4);break;
        }
        planAdapter = new ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,strArrayPlans);
        listPlan.setAdapter(planAdapter);

    }

}

