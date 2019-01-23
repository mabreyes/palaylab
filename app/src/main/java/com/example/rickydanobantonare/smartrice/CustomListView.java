package com.example.rickydanobantonare.smartrice;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListView extends ArrayAdapter<String> {
    private String[] name;
    private String[] desc;
    private Integer[] imgid;
    private Activity context;
    public CustomListView(Activity context, String[] name, String[] desc, Integer[] imgid) {
        super(context, R.layout.customlayout, name);

        this.context=context;
        this.name=name;
        this.desc=desc;
        this.imgid=imgid;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r=convertView;
            ViewHolder viewHolder=null;
            if(r==null){
                LayoutInflater layoutInflater=context.getLayoutInflater();
                r=layoutInflater.inflate(R.layout.customlayout,null,true);
                viewHolder=new ViewHolder(r);
                r.setTag(viewHolder);
            }else{
                viewHolder =(ViewHolder) r.getTag();
            }
                viewHolder.ivw.setImageResource(imgid[position]);
                viewHolder.tvw1.setText(name[position]);
                viewHolder.tvw2.setText(desc[position]);
                return r;
    }
    class ViewHolder{
        TextView tvw1;
        TextView tvw2;
        ImageView ivw;
        ViewHolder (View v){
            tvw1= (TextView) v.findViewById(R.id.tvname);
            tvw2=(TextView) v.findViewById(R.id.tvdescription);
            ivw=(ImageView)v.findViewById(R.id.imageView);
        }
    }
}
