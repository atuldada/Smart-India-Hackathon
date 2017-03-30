package jain.tarun.demo.Apdator;

import android.app.Fragment;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Collections;
import java.util.List;

import jain.tarun.demo.Data.DataTopRatedFPI;
import jain.tarun.demo.R;

/**
 * Created by User on 3/29/2017.
 */

public class CustomTopFpiAdapter extends BaseAdapter {

    LayoutInflater Newinflator;
    Context context;
    String Title[];
    String Loc[];
    String Matchpercent[];
    String Gainpercent[];

    public CustomTopFpiAdapter(Context context,String T[],String L[],String M[],String G[]){
        this.context=context;
        this.Title=T;
        this.Loc=L;
        this.Matchpercent=M;
        this.Gainpercent=G;
        Newinflator= LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return Title.length;
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
        title.setText(Title[position]);
        location.setText(Loc[position]);
        machpercent.setText(Matchpercent[position]);
        gainpercent.setText(Gainpercent[position]);
        return convertView;
    }
}
