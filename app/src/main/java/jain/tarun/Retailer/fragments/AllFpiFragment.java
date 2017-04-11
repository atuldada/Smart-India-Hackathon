package jain.tarun.Retailer.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.geofire.GeoFire;
import com.firebase.geofire.GeoLocation;
import com.firebase.geofire.GeoQuery;
import com.firebase.geofire.GeoQueryEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import jain.tarun.Retailer.Apdator.CustomAllFpiAdapter;
import jain.tarun.Retailer.FpiInfo;
import jain.tarun.Retailer.R;

import static android.R.attr.defaultValue;

/**
 * Created by User on 3/29/2017.
 */

public class AllFpiFragment extends android.support.v4.app.Fragment{
    ListView listView;

    ArrayList<String>name=new ArrayList<>();
    ArrayList<String>loacation=new ArrayList<>();
    String latitude="28.45";
    String longitude="77.54";
    CustomAllFpiAdapter customAllFpiAdapter;
    ViewGroup rootview;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
//        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getActivity());
//         latitude = settings.getString("latitude", "");
//         longitude = settings.getString("longitude", "");

//System.out.println(latitude+","+longitude);

//        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("path/to/geofire");
//        GeoFire geoFire = new GeoFire(ref);
//        // geoFire.setLocation("firebase-hq", new GeoLocation(37.7853889, -122.4056973));
//
//        //making search query in nearby area
//        GeoQuery geoQuery = geoFire.queryAtLocation(new GeoLocation(Double.parseDouble(latitude), Double.parseDouble(longitude)), 1000);
//        final HashMap<String,GeoLocation> loc=new HashMap<>();
//
//        geoQuery.addGeoQueryEventListener(new GeoQueryEventListener() {
//            @Override
//            public void onKeyEntered(String key, GeoLocation location) {
////                System.out.println(String.format("Key %s entered the search area at [%f,%f]", key, location.latitude, location.longitude));
//                loc.put(key,location);
//                name[i]=key;
//                loactions[i]=key;
//                i++;
//            }
//
//            @Override
//            public void onKeyExited(String key) {
//                System.out.println(String.format("Key %s is no longer in the search area", key));
//            }
//
//            @Override
//            public void onKeyMoved(String key, GeoLocation location) {
//                System.out.println(String.format("Key %s moved within the search area to [%f,%f]", key, location.latitude, location.longitude));
//            }
//
//            @Override
//            public void onGeoQueryReady() {
//                System.out.println("All initial data has been loaded and events have been fired!");
//                System.out.println(String.format(loc.toString()));
//            }
//
//            @Override
//            public void onGeoQueryError(DatabaseError error) {
//                System.err.println("There was an error with this query: " + error);
//            }
//        });

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("path/to/geofire");
        GeoFire geoFire = new GeoFire(ref);
        // geoFire.setLocation("firebase-hq", new GeoLocation(37.7853889, -122.4056973));

        //making search query in nearby area

        GeoQuery geoQuery = geoFire.queryAtLocation(new GeoLocation(Double.parseDouble(latitude), Double.parseDouble(longitude)), 50);
        final HashMap<String,GeoLocation> loc=new HashMap<>();
        geoQuery.addGeoQueryEventListener(new GeoQueryEventListener() {
            @Override
            public void onKeyEntered(String key, GeoLocation location) {
//                System.out.println(String.format("Key %s entered the search area at [%f,%f]", key, location.latitude, location.longitude));
                loc.put(key,location);
                    name.add(key);
                    loacation.add(key);


            }

            @Override
            public void onKeyExited(String key) {
                System.out.println(String.format("Key %s is no longer in the search area", key));
            }

            @Override
            public void onKeyMoved(String key, GeoLocation location) {
                System.out.println(String.format("Key %s moved within the search area to [%f,%f]", key, location.latitude, location.longitude));
            }

            @Override
            public void onGeoQueryReady() {
                System.out.println("All initial data has been loaded and events have been fired!");
                System.out.println(String.format(loc.toString()));
                settingadapter();
            }

            @Override
            public void onGeoQueryError(DatabaseError error) {
                System.err.println("There was an error with this query: " + error);
            }
        });

        rootview = (ViewGroup) inflater.inflate(R.layout.list_view, container, false);
        listView=(ListView)rootview.findViewById(R.id.listview);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // When clicked, show a toast with the TextView text
                Toast.makeText(getActivity(), ((TextView) view).getText(),
                        Toast.LENGTH_SHORT).show();
                Intent in=new Intent (getContext(),FpiInfo.class);
                in.putExtra("FPI",((TextView) view).getText());
                startActivity(in);

            }
        });
        customAllFpiAdapter=new CustomAllFpiAdapter(getActivity(),name,loacation);


        return rootview;
    }


   public void settingadapter()
    {
        listView.setAdapter(customAllFpiAdapter);

    }

}



