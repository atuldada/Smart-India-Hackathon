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
 * Created by User on 3/29/2017.
 */

public class CustomTopFpiAdapter extends BaseAdapter {

    public LayoutInflater Newinflator;
    public Context context;
    public ArrayList<String> listItems=new ArrayList<>();
    public ArrayList<String> Loc=new ArrayList<>();
    public String Matchpercent[];
    public String Gainpercent[];

    public CustomTopFpiAdapter(Context context,ArrayList<String> listItems,ArrayList<String> Loc,String M[],String G[]){
        this.context=context;
        this.listItems=listItems;
        this.Loc=Loc;
        this.Matchpercent=M;
        this.Gainpercent=G;
        Newinflator= LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return (listItems.size() - 1 );
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
        convertView=Newinflator.inflate(R.layout.top_fpi_nearby,null);
        TextView title=(TextView)convertView.findViewById(R.id.title);
        TextView location=(TextView)convertView.findViewById(R.id.location_topFpi);
        TextView machpercent=(TextView)convertView.findViewById(R.id.Matchpercent);
        TextView gainpercent=(TextView)convertView.findViewById(R.id.Gainpercent);
        title.setText(listItems.get(position));
        location.setText(Loc.get(position));
        machpercent.setText(Matchpercent[position]);
        gainpercent.setText(Gainpercent[position]);
        return convertView;
    }
}
