package jain.tarun.Retailer;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import jain.tarun.Retailer.Apdator.FpiInfoAdapter;

/**
 * Created by User on 4/2/2017.
 */

public class FpiInfo extends Activity implements View.OnClickListener {
    ListView listView;
    ArrayList<String> ItemName=new ArrayList<String>();
    ArrayList<String> Rate=new ArrayList<String>();
    FpiInfoAdapter fpiInfoAdapter;
    TextView proceed;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fpi_info);
        proceed=(TextView)findViewById(R.id.proceed);
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FpiInfo.this, "Proceed after", Toast.LENGTH_SHORT).show();
            }
        });
        listView=(ListView)findViewById(R.id.list_item);
        ItemName.add("Channa");
        ItemName.add("Rice");
        ItemName.add("papad");
        ItemName.add("Butter");
        Rate.add("100");
        Rate.add("500");
        Rate.add("300");
        Rate.add("600");
        fpiInfoAdapter=new FpiInfoAdapter(getApplicationContext(),ItemName,Rate);
        listView.setAdapter(fpiInfoAdapter);
    }

    @Override
    public void onClick(View v) {

    }
}
