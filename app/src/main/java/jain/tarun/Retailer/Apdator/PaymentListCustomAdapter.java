package jain.tarun.Retailer.Apdator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import jain.tarun.Retailer.R;

/**
 * Created by User on 4/2/2017.
 */

public class PaymentListCustomAdapter extends BaseAdapter {

    LayoutInflater layoutInflater;
    Context context;
    String FpiName[];
    public PaymentListCustomAdapter(Context context, String FpiNAme[]){
        this.context=context;
        this.FpiName=FpiNAme;
        layoutInflater=LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return FpiName.length;
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
        convertView=layoutInflater.inflate(R.layout.payment_list_view_layout,null);
        TextView fpiName=(TextView)convertView.findViewById(R.id.fpiname);
        fpiName.setText(FpiName[position]);
        return convertView;
    }
}
