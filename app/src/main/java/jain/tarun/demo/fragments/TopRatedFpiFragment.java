package jain.tarun.demo.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import jain.tarun.demo.Apdator.CustomAllFpiAdapter;
import jain.tarun.demo.Apdator.CustomTopFpiAdapter;
import jain.tarun.demo.R;

/**
 * Created by User on 3/29/2017.
 */

public class TopRatedFpiFragment extends android.support.v4.app.Fragment {
    ListView listView;
    String Title[]={"Fpi 1","Fpi 2","Fpi 4","Fpi 5","Fpi 6","Fpi 7"};
    String Loc[]={"location 1","location 2","location 3","location 4","location 5","location 6"};
    String Matchpercent[]={"90%","80%","70%","60%","50%","40%"};
    String Gainpercent[]={"90%","80%","70%","60%","50%","40%"};
    CustomTopFpiAdapter customTopFpiAdapter;
    ViewGroup rootview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        rootview = (ViewGroup) inflater.inflate(R.layout.list_view, container, false);
        listView=(ListView)rootview.findViewById(R.id.listview);
        customTopFpiAdapter=new CustomTopFpiAdapter(getActivity(),Title,Loc,Matchpercent,Gainpercent);
        listView.setAdapter(customTopFpiAdapter);
        return rootview;
    }
}
