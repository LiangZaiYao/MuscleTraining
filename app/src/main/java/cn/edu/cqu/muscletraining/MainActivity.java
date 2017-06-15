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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.ToggleButton;

import java.util.List;

@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity {

    ToggleButton tgbtnBody;
    ImageView bodypic;
    ImageView bodypicpure;
    ListView listPlan;
    ArrayAdapter planAdapter;
    String[] strArrayPlans;
    int planindex;
    Button btnNewDiary;
    ListView listDiary;
    List<Data> listData;
    List<String> listID;
    ImageView breakfastPic;
    ImageView lunchPic;
    ImageView dinnerPic;
    int freshflag1 = 0;
    int freshflag2 = 0;
    int freshflag3 = 0;
    int breakfresh = 1;
    int lunchfresh = 1;
    int dinnerfresh = 1;
    Button freshBtn1;
    Button freshBtn2;
    Button freshBtn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        //获取上个activity传递来的数据
        if (!(getIntent().getExtras() == null)) {
            Bundle bundle = getIntent().getExtras();
            planindex = bundle.getInt("planIndex");
        }

        // 得到TabActivity中的TabHost对象
        TabHost tabHost = getTabHost();
        // 内容：采用布局文件中的布局
        LayoutInflater.from(this).inflate(R.layout.activity_main,
                tabHost.getTabContentView(), true);

        // 加上标签
        // 参数设置：新增的TabSpec的标签，标签中显示的字样
        // setContent设置内容对应的View资源标号
        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("Muscle\nGraphy").setContent(R.id.tab1));
        ;
        tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("My Plan").setContent(R.id.tab2));
        tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("Train\nDiet").setContent(R.id.tab3));
        tabHost.setCurrentTab(1);//设置默认选中的TAB

        tgbtnBody = (ToggleButton) findViewById(R.id.tbtnBody);
        bodypic = (ImageView) findViewById(R.id.ivBodyPic);
        bodypicpure = (ImageView) findViewById(R.id.ivBodyPicPure);
        listPlan = (ListView) findViewById(R.id.listPlan);
        breakfastPic = (ImageView)findViewById(R.id.ivBreakfast);
        lunchPic = (ImageView)findViewById(R.id.ivLunch);
        dinnerPic = (ImageView)findViewById(R.id.ivDinner);
        freshBtn1 = (Button)findViewById(R.id.freshBtn1);
        freshBtn2 = (Button)findViewById(R.id.freshBtn2);
        freshBtn3 = (Button)findViewById(R.id.freshBtn3);
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


        OnTouchListener imgListener = new OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    //Toast.makeText(getBaseContext(), "("+(int)event.getX()+","+(int)event.getY()+")", Toast.LENGTH_SHORT).show();
                    Bitmap bitmap = ((BitmapDrawable) bodypicpure.getDrawable()).getBitmap();
                    int pixel = bitmap.getPixel((int) event.getX(), (int) event.getY());
                    int redValue = Color.red(pixel);
                    int blueValue = Color.blue(pixel);
                    int greenValue = Color.green(pixel);
                    if (redValue == 255 && greenValue == 0 && blueValue == 0) {
                        //Toast.makeText(getBaseContext(), "胸部("+redValue+","+greenValue+","+blueValue+")", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent();
                        intent.setClass(MainActivity.this, ChestActivity.class);
                        startActivity(intent);
                    } else if (redValue == 255 && greenValue == 255 && blueValue == 0) {
                        //Toast.makeText(getBaseContext(), "腹部("+redValue+","+greenValue+","+blueValue+")", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent();
                        intent.setClass(MainActivity.this, AbdomenActivity.class);
                        startActivity(intent);
                    } else if (redValue == 0 && greenValue == 0 && blueValue == 255) {
                        //Toast.makeText(getBaseContext(), "大腿("+redValue+","+greenValue+","+blueValue+")", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent();
                        intent.setClass(MainActivity.this, LegActivity.class);
                        startActivity(intent);
                    } else if (redValue == 221 && greenValue == 0 && blueValue == 221) {
                        //Toast.makeText(getBaseContext(), "肱二头肌("+redValue+","+greenValue+","+blueValue+")", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent();
                        intent.setClass(MainActivity.this, BicipitalActivity.class);
                        startActivity(intent);
                    } else if (redValue == 0 && greenValue == 255 && blueValue == 0) {
                        //Toast.makeText(getBaseContext(), "肩膀("+redValue+","+greenValue+","+blueValue+")", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent();
                        intent.setClass(MainActivity.this, TriangleActivity.class);
                        startActivity(intent);
                    } else if (redValue == 255 && greenValue == 153 && blueValue == 0) {
                        //Toast.makeText(getBaseContext(), "背部("+redValue+","+greenValue+","+blueValue+")", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent();
                        intent.setClass(MainActivity.this, BackActivity.class);
                        startActivity(intent);
                    } else if (redValue == 153 && greenValue == 153 && blueValue == 153) {
                        //Toast.makeText(getBaseContext(), "腰部("+redValue+","+greenValue+","+blueValue+")", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent();
                        intent.setClass(MainActivity.this, YaoActivity.class);
                        startActivity(intent);
                    } else if (redValue == 136 && greenValue == 0 && blueValue == 255) {
                        //Toast.makeText(getBaseContext(), "臀部("+redValue+","+greenValue+","+blueValue+")", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent();
                        intent.setClass(MainActivity.this, AssActivity.class);
                        startActivity(intent);
                    } else if (redValue == 0 && greenValue == 255 && blueValue == 255) {
                        //Toast.makeText(getBaseContext(), "肱三头肌("+redValue+","+greenValue+","+blueValue+")", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent();
                        intent.setClass(MainActivity.this, TriciptialActivity.class);
                        startActivity(intent);

                    } else if (redValue == 0 && greenValue == 121 && blueValue == 121) {
                        //Toast.makeText(getBaseContext(), "小腿("+redValue+","+greenValue+","+blueValue+")", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent();
                        intent.setClass(MainActivity.this, ShankActivity.class);
                        startActivity(intent);
                    }
                }
                return false;
            }
        };
        findViewById(R.id.ivBodyPicPure).setOnTouchListener(imgListener);

        //填充ListPlan
        strArrayPlans = getResources().getStringArray(R.array.plan1);
        switch (planindex) {
            case 1:
                strArrayPlans = getResources().getStringArray(R.array.plan1);
                break;
            case 2:
                strArrayPlans = getResources().getStringArray(R.array.plan2);
                break;
            case 3:
                strArrayPlans = getResources().getStringArray(R.array.plan3);
                break;
            case 4:
                strArrayPlans = getResources().getStringArray(R.array.plan4);
                break;
        }
        planAdapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, strArrayPlans);
        listPlan.setAdapter(planAdapter);
    }
        //Tab3
    public void onFreshB(View v){
        if(freshflag1==0){freshBtn1.setBackgroundResource(R.drawable.fresh1);freshflag1 = 1;}
        else{freshBtn1.setBackgroundResource(R.drawable.fresh);freshflag1 = 0;}

        if(breakfresh==1){breakfastPic.setImageResource(R.drawable.b2);breakfresh=2;}
        else if (breakfresh==2){breakfastPic.setImageResource(R.drawable.b3);breakfresh=3;}
        else if (breakfresh==3){breakfastPic.setImageResource(R.drawable.b1);breakfresh=1;}
    }

    public void onFreshL(View v){
        if(freshflag2==0){freshBtn2.setBackgroundResource(R.drawable.fresh1);freshflag2 = 1;}
        else{freshBtn2.setBackgroundResource(R.drawable.fresh);freshflag2 = 0;}

        if(lunchfresh==1){lunchPic.setImageResource(R.drawable.l2);lunchfresh=2;}
        else if (lunchfresh==2){lunchPic.setImageResource(R.drawable.l3);lunchfresh=3;}
        else if (lunchfresh==3){lunchPic.setImageResource(R.drawable.l1);lunchfresh=1;}
    }
    public void onFreshD(View v){
        if(freshflag3==0){freshBtn3.setBackgroundResource(R.drawable.fresh1);freshflag3 = 1;}
        else{freshBtn3.setBackgroundResource(R.drawable.fresh);freshflag3 = 0;}

        if(dinnerfresh==1){dinnerPic.setImageResource(R.drawable.d2);dinnerfresh=2;}
        else if (dinnerfresh==2){dinnerPic.setImageResource(R.drawable.d3);dinnerfresh=3;}
        else if (dinnerfresh==3){dinnerPic.setImageResource(R.drawable.d1);dinnerfresh=1;}
    }

}

