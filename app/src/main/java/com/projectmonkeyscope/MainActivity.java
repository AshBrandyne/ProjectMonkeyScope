package com.projectmonkeyscope;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    /**
     * Activity name for Log purposes
     */
    protected static final String ACTIVITY_NAME = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Let's get the MAIN_PROFILE and see if it worked!
        Profile userProfile = Profile.MAIN_PROFILE;

        Log.i(ACTIVITY_NAME, "In onCreate() with key: " + userProfile.toString());

    }
}
