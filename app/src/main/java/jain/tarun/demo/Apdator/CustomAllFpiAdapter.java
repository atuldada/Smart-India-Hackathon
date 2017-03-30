package jain.tarun.demo.Apdator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import jain.tarun.demo.R;

/**
 * Created by User on 3/29/2017.
 */

public class CustomAllFpiAdapter extends BaseAdapter {
    LayoutInflater newinflator;
    Context context;
    String names[];
    String LOC[];
    public CustomAllFpiAdapter(Context context,String nam[],String locations[]){
        this.context=context;
        this.names=nam;
        this.LOC=locations;
        newinflator = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=newinflator.inflate(R.layout.all_fpi_nearby,null);
        TextView name=(TextView)convertView.findViewById(R.id.Fpi_name);
        TextView location=(TextView)convertView.findViewById(R.id.loca_fpi);
        name.setText(names[position]);
        location.setText(LOC[position]);

        return convertView;
    }
}
