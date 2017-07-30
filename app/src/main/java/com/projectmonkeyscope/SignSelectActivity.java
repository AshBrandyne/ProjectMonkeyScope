package com.projectmonkeyscope;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class SignSelectActivity extends AppCompatActivity {
    /**
     * Declaring Buttons for each sign
     * Will change to ImageViews after designing layout
     */
    Button aquarius, pisces, aries, taurus, gemini, cancer, leo;
    Button virgo, libra, scorpio, sagittarius, capricorn;
    Button signs[] = new Button[12];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_select);

        //signs = {aquarius, }

    }

}
