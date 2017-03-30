package jain.tarun.demo;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import jain.tarun.demo.fragments.FpiNearbyViewPagerFragmentActivity;

public class MainActivity extends Activity implements View.OnClickListener{
    ImageButton drawer_menu,notify,search;
    DrawerLayout drawerLayout;
    FrameLayout framelay;
    View menu_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }

    private void initView() {
        drawer_menu=(ImageButton)findViewById(R.id.menu);
        drawer_menu.setOnClickListener(this);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer);
        menu_view=(View) findViewById(R.id.Menu_view);
        search=(ImageButton)findViewById(R.id.search);
        notify=(ImageButton)findViewById(R.id.notification);
        framelay=(FrameLayout)findViewById(R.id.frame_lay);
        framelay.setOnClickListener(this);
    }

    public void UpdateDemand(View view){

}
    public void onClick(View v) {
        if(v==drawer_menu){
            if(!drawerLayout.isDrawerOpen(menu_view))
                drawerLayout.openDrawer(Gravity.LEFT);
            else
                drawerLayout.closeDrawer(menu_view);
        }

        else if(v==framelay)
        {
            if(drawerLayout.isDrawerOpen(menu_view))
                drawerLayout.closeDrawer(menu_view);
        }



    }
    public void FPInearby(View view){
        Intent intent=new Intent(getApplicationContext(), FpiNearbyViewPagerFragmentActivity.class);
        startActivity(intent);
    }


}
