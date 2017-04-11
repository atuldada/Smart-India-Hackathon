package jain.tarun.Retailer.Apdator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import jain.tarun.Retailer.R;

/**
 * Created by User on 4/2/2017.
 */

public class FpiInfoAdapter extends BaseAdapter {

    LayoutInflater layoutInflater;
    Context context;
    ArrayList<String> itemName;
    ArrayList<String> rate;

    public FpiInfoAdapter(Context context,ArrayList<String> item_name,ArrayList<String> RATE){
        this.context=context;
        this.itemName=item_name;
        this.rate=RATE;
        layoutInflater= LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return (itemName.size()-1);
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
        convertView=layoutInflater.inflate(R.layout.fpi_input_card_layout,null);
        TextView ItemNAme=(TextView)convertView.findViewById(R.id.Fpi_item_name);
        TextView RatE=(TextView)convertView.findViewById(R.id.rateOfProduct);
        ItemNAme.setText(itemName.get(position));
        RatE.setText(rate.get(position));
        return convertView;
    }
}
