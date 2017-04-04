package cn.edu.cqu.muscletraining;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by RedQueen on 2017/4/4.
 */


public class MySimpleAdapter extends ArrayAdapter<Data> {
    private List<Data> dataList;
    private Context context ;
    private int resourceId;

    public MySimpleAdapter(Context context, int resourceId, List<Data> data) {
        super(context, resourceId, data);
        this.context = context ;
        this.resourceId = resourceId;
        this.dataList = data;
        // TODO Auto-generated constructor stub
    }

    /* (non-Javadoc)
     * @see android.widget.SimpleAdapter#getView(int, android.view.View, android.view.ViewGroup)
     */
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View view= LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        Data data = dataList.get(position);
        TextView tv_description = (TextView)view.findViewById(R.id.tvDiary);
        tv_description.setText(data.getStrText());
        TextView tv_account = (TextView)view.findViewById(R.id.tvDate);
        tv_account.setText(data.getStrDate());
        return view;
    }
}
