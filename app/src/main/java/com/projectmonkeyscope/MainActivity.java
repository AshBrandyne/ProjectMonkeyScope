package com.projectmonkeyscope;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import static com.projectmonkeyscope.R.layout.activity_main;

public class MainActivity extends AppCompatActivity {
    /**
     * Activity name for Log purposes
     */
    protected static final String ACTIVITY_NAME = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);
        //Edit toolbar (ActionBar)
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.menu);
        actionBar.setDisplayHomeAsUpEnabled(true);

        // Let's get the MAIN_PROFILE and see if it worked!
        Profile userProfile = Profile.mainProfile;

        Log.i(ACTIVITY_NAME, "In onCreate() with key: " + userProfile.toString());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /*The 3 buttons on the right side of the toolbar*/
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override//TODO: Make Navigation Drawer
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        String btnName = null;
        switch(itemId) {
            case R.id.menu_settings:
                btnName = "Settings";
                break;
            case R.id.menu_compass:
                btnName = "Compass";
                break;
            case R.id.menu_help:
                btnName = "Help";
                break;
        }
        Toast.makeText(this, "Button " + btnName, Toast.LENGTH_SHORT).show();
        return true;
    }
}
