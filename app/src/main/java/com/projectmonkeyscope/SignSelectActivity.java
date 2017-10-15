package com.projectmonkeyscope;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignSelectActivity extends AppCompatActivity {
    /**
     * Declaring Buttons for each sign
     * Will change to ImageViews after designing layout
     */
    Button aquarius, pisces, aries, taurus, gemini, cancer, leo,
           virgo, libra, scorpio, sagittarius, capricorn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_select);

        AstrologicalSign[] astrologicalSigns = AstrologicalSign.getAllSigns();

        aquarius = (Button) findViewById(R.id.aquarius);
        aquarius.setOnClickListener(new SignSelectClickListener(astrologicalSigns[0]));

        pisces = (Button) findViewById(R.id.pisces);
        pisces.setOnClickListener(new SignSelectClickListener(astrologicalSigns[1]));

        aries = (Button) findViewById(R.id.aries);
        aries.setOnClickListener(new SignSelectClickListener(astrologicalSigns[2]));

        taurus = (Button) findViewById(R.id.taurus);
        taurus.setOnClickListener(new SignSelectClickListener(astrologicalSigns[3]));

        gemini = (Button) findViewById(R.id.gemini);
        gemini.setOnClickListener(new SignSelectClickListener(astrologicalSigns[4]));

        cancer = (Button) findViewById(R.id.cancer);
        cancer.setOnClickListener(new SignSelectClickListener(astrologicalSigns[5]));

        leo = (Button) findViewById(R.id.leo);
        leo.setOnClickListener(new SignSelectClickListener(astrologicalSigns[6]));

        virgo = (Button) findViewById(R.id.virgo);
        virgo.setOnClickListener(new SignSelectClickListener(astrologicalSigns[7]));

        libra = (Button) findViewById(R.id.libra);
        libra.setOnClickListener(new SignSelectClickListener(astrologicalSigns[8]));

        scorpio = (Button) findViewById(R.id.scorpio);
        scorpio.setOnClickListener(new SignSelectClickListener(astrologicalSigns[9]));

        sagittarius = (Button) findViewById(R.id.sagittarius);
        sagittarius.setOnClickListener(new SignSelectClickListener(astrologicalSigns[10]));

        capricorn = (Button) findViewById(R.id.capricorn);
        capricorn.setOnClickListener(new SignSelectClickListener(astrologicalSigns[11]));
    }

    private class SignSelectClickListener implements View.OnClickListener {

        private AstrologicalSign sign;

        public SignSelectClickListener(AstrologicalSign sign) {
            this.sign = sign;
        }

        public void onClick(View v) {
            Profile.mainProfile = new Profile(sign.getStartDate()); //initialize Main Profile for user

            /* create and fire intent to MainActivity */
            Intent mainIntent = new Intent(SignSelectActivity.this, MainActivity.class);
            startActivity(mainIntent);
        }
    }
}
