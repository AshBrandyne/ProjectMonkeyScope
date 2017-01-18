package com.projectmonkeyscope;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Spinner;


/**
 * ProfileActivity saves user's birth date and uses it to set default AstrologicalSign
 * GUI: This is the Profile screen which asks for the user's birthday date
 *custom spinner: http://stephenpengilley.blogspot.ca/2013/01/android-custom-spinner-tutorial.html
 */
public class ProfileActivity extends AppCompatActivity {
    ImageView monkeyLogo;
    Spinner monthSpinner;
    Spinner daySpinner;
    int[] days = {};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }
}
