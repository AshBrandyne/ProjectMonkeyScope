package com.projectmonkeyscope;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * ProfileActivity saves user's birth date and uses it to set default AstrologicalSign
 * GUI: This is the Profile screen which asks for the user's birthday date
 */
public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }
}
