package com.example.dell.eight808.Adapter;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dell.eight808.R;
import com.example.dell.eight808.User;

import java.util.List;

import static android.R.id.list;

/**
 * Created by DELL on 2017/8/8.
 */
public class MyAdapter extends BaseAdapter {
    FragmentActivity context; List<User> list;
    private ViewHolder holder;
    public MyAdapter(FragmentActivity context, List<User> list) {
        this.context=context;
        this.list=list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    if (convertView==null){
               convertView= View.inflate(context, R.layout.item,null);
               holder = new ViewHolder();
               holder.name=(TextView) convertView.findViewById(R.id.name);
               holder.six=(TextView) convertView.findViewById(R.id.sex);
               holder.phone=(TextView) convertView.findViewById(R.id.phone);
               convertView.setTag(holder);
           }else {
        holder = (ViewHolder) convertView.getTag();
    }
           holder.name.setText(list.get(position).getName());
           holder.six.setText(list.get(position).getSex());
           holder.phone.setText(list.get(position).getPhone());
           return convertView;
       }


    class ViewHolder{
        TextView name,six,phone;
    }

    public void   notify(List<User> list){
        this.list=list;

        notifyDataSetChanged();
    }

}
