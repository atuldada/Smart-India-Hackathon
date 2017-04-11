package jain.tarun.Retailer;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import static jain.tarun.Retailer.R.id.Licence;
import static jain.tarun.Retailer.R.id.UpadteItem;
import static jain.tarun.Retailer.R.id.company;
import static jain.tarun.Retailer.R.id.phone;
import static jain.tarun.Retailer.R.string.settings;

/**
 * Created by User on 4/1/2017.
 */

public class UpadteItemActivity extends Activity {
    EditText nameItem,availbaleQuant,itemRate;
    TextView update,gotoDash;
    String company="test";
    TextView unit;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_demand);
//        String SPINNERLIST[]={"grams","kg","pc","lt"};
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_dropdown_item_1line, SPINNERLIST);
//        MaterialBetterSpinner materialDesignSpinner = (MaterialBetterSpinner)
//                findViewById(R.id.android_material_design_spinner);
//        materialDesignSpinner.setAdapter(arrayAdapter);

        initView();
    }

    private void initView() {
        nameItem = (EditText) findViewById(R.id.input_ItemName);
        availbaleQuant = (EditText) findViewById(R.id.input_ItemQuantity);
        itemRate = (EditText) findViewById(R.id.input_ItemRate);
        update = (TextView) findViewById(R.id.input_update);
        gotoDash = (TextView) findViewById(R.id.GotoDash);
        unit = (TextView) findViewById(R.id.text);
//        Spinner sp=(Spinner)findViewById(R.id.android_material_design_spinner);
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        company = settings.getString("product", "");
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    DatabaseReference myRef2 = FirebaseDatabase.getInstance().getReference();
                    Product user2 = new Product(nameItem.getText().toString(), availbaleQuant.getText().toString(), itemRate.getText().toString(), unit.getText().toString());
                    myRef2.child("Retailer_update").child(nameItem.getText().toString()).setValue(user2);
                    Intent in = new Intent(UpadteItemActivity.this, MainActivity.class);
                    startActivity(in);
                } catch (DatabaseException r) {
                    System.out.println(r);
                }


            }
        }); //setOnClickListener
    }
}
