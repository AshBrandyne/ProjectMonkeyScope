package com.projectmonkeyscope;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    protected static final String ACTIVITY_NAME = "MainActivity";
    /**
     * Static keys for SharedPrefs
     */
    public static final String DAY_KEY = "dayKey";
    public static final String MONTH_KEY = "monthKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Test to see if int was sent in bundle
         */
        Bundle extras = getIntent().getExtras();
        int test=0;
        if (extras != null) {
            test = extras.getInt(DAY_KEY);
        }

        Log.i(ACTIVITY_NAME, "In onCreate() with key: " + test);

    }
}
