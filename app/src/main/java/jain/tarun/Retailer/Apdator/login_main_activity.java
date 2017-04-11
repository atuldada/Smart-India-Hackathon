package jain.tarun.Retailer.Apdator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import jain.tarun.Retailer.LoginActivity;
import jain.tarun.Retailer.R;

/**
 * Created by User on 4/2/2017.
 */

public class login_main_activity extends Activity {
    TextView signup;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main_activity);
        signup=(TextView) findViewById(R.id.initial_sign_up);

    }
    public void SIGN_UP(View view){
        Intent n=new Intent(getApplicationContext(),LoginActivity.class);
        startActivity(n);
    }
}
