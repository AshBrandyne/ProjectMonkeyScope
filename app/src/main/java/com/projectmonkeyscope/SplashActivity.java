package com.projectmonkeyscope;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Splash Activity opens when user first starts the app
 *
 * If a profile exists in SharedPreferences, sets Main Profile to this
 * and starts MainActivity
 * If no profile exists, starts ProfileActivity to create new profile
 */
public class SplashActivity extends AppCompatActivity {
    /**
     * Activity name for Log purposes
     */
    protected static final String ACTIVITY_NAME = "SplashActivity";
    /**
     * The logo to be animated when app first loads
     */
    ImageView splashImage;

    private SharedPreferences sharedPreferences;
    /**
     * Boolean flag set to true if profile exists in sharedPrefs
     */
    private boolean profileExists = false;
    /**
     * The view for onClickListener
     */
    private View view;

    /**
     * Static keys for SharedPrefs
     */
    public static final String DAY_KEY = "dayKey";
    public static final String MONTH_KEY = "monthKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        /* initializes sharedPrefs */
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        /* check to see if a profile exists in sharedPrefs
         * if it doesn't exist, it will be 0 by default */
        int day = sharedPreferences.getInt(DAY_KEY, 0);
        int month = sharedPreferences.getInt(MONTH_KEY, 0);

        /* if a real date exists, initialize Main Profile for the user */
        if (day > 0 && month > 0) {
            profileExists = true;

            Profile.mainProfile = new Profile(month, day);
        }

        /* initializes the logo and animates it */
        splashImage = (ImageView) findViewById(R.id.splash_image);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.splash_animation);
        splashImage.setAnimation(animation);

        view = (View) findViewById(R.id.activity_splash);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                splashImage.clearAnimation();
            }
        });

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                //nothing needed here
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent nextActivity = intentForNextUserActivity();

                finish();
                startActivity(nextActivity); //take user to Profile or Main Activity
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                //nothing needed here
            }
        });

        Log.i(ACTIVITY_NAME, "In onCreate()");
    }

    /**
     * Private helper method creates Intent to sent user to next Activity
     * Based on whether they have an active profile created
     * @return intent for next Activity
     */
    private Intent intentForNextUserActivity() {
        Intent nextActivity;

        if (profileExists) {
            //Profile exists, send to main activity
            nextActivity = new Intent(getApplicationContext(), MainActivity.class);
        } else {
            //Profile doesn't exist, send to profile activity to set up profile
            nextActivity = new Intent(getApplicationContext(), ProfileActivity.class);
        }

        return nextActivity;
    }
}
