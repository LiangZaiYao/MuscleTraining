package cn.edu.cqu.muscletraining;

import android.app.AlertDialog;
import android.app.TabActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;
import android.widget.ToggleButton;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.util.ArrayList;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        //获取上个activity传递来的数据
        if(!(getIntent().getExtras() == null)) {
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
        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("Muscle\nGraphy").setContent(R.id.tab1));;
        tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("My Plan").setContent(R.id.tab2));
        tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("Train\nDiary").setContent(R.id.tab3));
        tabHost.setCurrentTab(1);//设置默认选中的TAB

        tgbtnBody = (ToggleButton)findViewById(R.id.tbtnBody);
        bodypic = (ImageView)findViewById(R.id.ivBodyPic);
        bodypicpure = (ImageView)findViewById(R.id.ivBodyPicPure);
        listPlan = (ListView)findViewById(R.id.listPlan);
        btnNewDiary = (Button) findViewById(R.id.floatButton) ;
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
                        //Toast.makeText(getBaseContext(), "大腿("+redValue+","+greenValue+","+blueValue+")", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent();
                        intent.setClass(MainActivity.this, LegActivity.class);
                        startActivity(intent);
                    }
                    else if(redValue == 221 && greenValue == 0 && blueValue == 221) {
                        //Toast.makeText(getBaseContext(), "肱二头肌("+redValue+","+greenValue+","+blueValue+")", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent();
                        intent.setClass(MainActivity.this, BicipitalActivity.class);
                        startActivity(intent);
                    }
                    else if(redValue == 0 && greenValue == 255 && blueValue == 0) {
                        //Toast.makeText(getBaseContext(), "肩膀("+redValue+","+greenValue+","+blueValue+")", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent();
                        intent.setClass(MainActivity.this, TriangleActivity.class);
                        startActivity(intent);
                    }
                    else if(redValue == 255 && greenValue == 153 && blueValue == 0) {
                        //Toast.makeText(getBaseContext(), "背部("+redValue+","+greenValue+","+blueValue+")", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent();
                        intent.setClass(MainActivity.this, BackActivity.class);
                        startActivity(intent);
                    }
                    else if(redValue == 153 && greenValue == 153 && blueValue == 153) {
                        //Toast.makeText(getBaseContext(), "腰部("+redValue+","+greenValue+","+blueValue+")", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent();
                        intent.setClass(MainActivity.this, YaoActivity.class);
                        startActivity(intent);
                    }
                    else if(redValue == 136 && greenValue == 0 && blueValue == 255) {
                        //Toast.makeText(getBaseContext(), "臀部("+redValue+","+greenValue+","+blueValue+")", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent();
                        intent.setClass(MainActivity.this, AssActivity.class);
                        startActivity(intent);
                    }
                    else if(redValue == 0 && greenValue == 255 && blueValue == 255) {
                        //Toast.makeText(getBaseContext(), "肱三头肌("+redValue+","+greenValue+","+blueValue+")", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent();
                        intent.setClass(MainActivity.this, TriciptialActivity.class);
                        startActivity(intent);

                    }
                    else if(redValue == 0 && greenValue == 121 && blueValue == 121) {
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
        switch (planindex)
        {
            case 1:strArrayPlans = getResources().getStringArray(R.array.plan1);break;
            case 2:strArrayPlans = getResources().getStringArray(R.array.plan2);break;
            case 3:strArrayPlans = getResources().getStringArray(R.array.plan3);break;
            case 4:strArrayPlans = getResources().getStringArray(R.array.plan4);break;
        }
        planAdapter = new ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,strArrayPlans);
        listPlan.setAdapter(planAdapter);

        //Tab3
        listDiary=(ListView)findViewById(R.id.listDiary);
        listID = new ArrayList<>();
        LitePal.getDatabase();
        listData = DataSupport.select("*").find(Data.class);
        for (Data each : listData) {
            listID.add(each.getId_Item());
        }
        //为listView设置Adapter
        final MySimpleAdapter adapter = new MySimpleAdapter(this, R.layout.layout_listitem, listData);
        listDiary.setAdapter(adapter);

        listDiary.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(final AdapterView<?> parent, View view,
                                           final int position, long id) {
                //long press pop up this dialog to delete data
                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Delete ?");
                builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        DataSupport.deleteAll(Data.class, "id_Item =?", listID.get(position));
                        listData.remove(position);
                        listID.remove(position);
                        adapter.notifyDataSetChanged();
                        listDiary.setAdapter(adapter);
                    }
                });
                builder.show();
                return true;
            }
        });
        btnNewDiary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getBaseContext(), "touched!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, DiaryActivity.class);
                startActivity(intent);
            }
        });

    }

}

