package com.projectmonkeyscope;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Spinner;


/**
 * ProfileActivity saves user's date of birth to SharedPrefs for use in Profile
 * GUI: This is the Profile screen which asks for the user's birthday date
 *
 * custom spinner: http://stephenpengilley.blogspot.ca/2013/01/android-custom-spinner-tutorial.html
 */
public class ProfileActivity extends AppCompatActivity {
    /**
     * Activity name for Log purposes
     */
    protected static final String ACTIVITY_NAME = "ProfileActivity";
    /**
     * Static keys for SharedPrefs
     */
    public static final String DAY_KEY = "dayKey";
    public static final String MONTH_KEY = "monthKey";

    /**
     * Logo at top of Profile Activity
     */
    ImageView monkeyLogo;

    /**
     * Date picker for user to pick date of birth
     * TODO: Format DatePicker to look good
     */
    DatePicker datePicker;

    /**
     * Button for submitting date of birth
     */
    Button submitDateButton;

    /**
     * The Shared Preferences
     */
    SharedPreferences sharedPreferences;
    /**
     * Profile object holds user's birth date
     */
    //Profile userProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //Finds and initializes the XML elements
        monkeyLogo = (ImageView) findViewById(R.id.logo);
        datePicker = (DatePicker) findViewById(R.id.date_picker);
        submitDateButton = (Button) findViewById(R.id.dob_button);

        //initializes sharedPrefs with (Context)ProfileActivity.class
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        //When user clicks button, saves day and month to sharedPreferences
        submitDateButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get day and month from DatePicker
                int day = datePicker.getDayOfMonth();
                int month = datePicker.getMonth() + 1;

                //save date to sharedPrefs
                saveDateToSharedPreferences(month, day);

                //create new Profile object
                //userProfile = new Profile(month, day);

                //create and fire intent to MainActivity with month and day in bundle
                Intent mainIntent = new Intent(ProfileActivity.this, MainActivity.class);
                mainIntent.putExtra(MONTH_KEY, month);
                mainIntent.putExtra(DAY_KEY, day);
                startActivity(mainIntent);

            }
        });

        Log.i(ACTIVITY_NAME, "In onCreate()");
    }

    /**
     * Private helper method to save day and month to SharedPreferences
     * @param month user's month of birth
     * @param day user's day of birth
     */
    private void saveDateToSharedPreferences(int month, int day) {

        //commit day and month to sharedPrefs
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(DAY_KEY, day);
        editor.putInt(MONTH_KEY, month);
        editor.commit();
    }

} //end of ProfileActivity.java
