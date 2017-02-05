package com.projectmonkeyscope;

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
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        /* Finds and initializes the XML elements */
        monkeyLogo = (ImageView) findViewById(R.id.logo);
        datePicker = (DatePicker) findViewById(R.id.date_picker);
        submitDateButton = (Button) findViewById(R.id.dob_button);

        /* initializes sharedPrefs */
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        submitDateButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* get day and month from DatePicker */
                int day = datePicker.getDayOfMonth();
                int month = datePicker.getMonth() + 1;

                saveDateToSharedPreferences(month, day); //save date to sharedPrefs

                Profile.mainProfile = new Profile(month, day); //initialize Main Profile for user

                /* create and fire intent to MainActivity */
                Intent mainIntent = new Intent(ProfileActivity.this, MainActivity.class);
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
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt(DAY_KEY, day);
        editor.putInt(MONTH_KEY, month);

        editor.commit();
    }

} //end of ProfileActivity.java
