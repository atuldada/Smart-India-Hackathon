package jain.tarun.demo.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import jain.tarun.demo.Apdator.CustomAllFpiAdapter;
import jain.tarun.demo.R;

/**
 * Created by User on 3/29/2017.
 */

public class AllFpiFragment extends android.support.v4.app.Fragment{
    ListView listView;
    String name[]={"Fpi 1","Fpi 2","Fpi 3"};
    String loactions[]={"location 1","Location 2","Location 3"};
    CustomAllFpiAdapter customAllFpiAdapter;
    ViewGroup rootview;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        rootview = (ViewGroup) inflater.inflate(R.layout.list_view, container, false);
        listView=(ListView)rootview.findViewById(R.id.listview);
        customAllFpiAdapter=new CustomAllFpiAdapter(getActivity(),name,loactions);
        listView.setAdapter(customAllFpiAdapter);
        return rootview;
    }
}

