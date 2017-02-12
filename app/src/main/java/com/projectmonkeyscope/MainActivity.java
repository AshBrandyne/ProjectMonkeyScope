package com.projectmonkeyscope;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Calendar;
import java.util.Date;

import static com.projectmonkeyscope.R.layout.activity_main;

/**
 * A Horoscope is made, pass in Astrological sign and date
 * Call getHoroscope on a Horoscope to get the Horoscope
 */
public class MainActivity extends AppCompatActivity {
    /**
     * Activity name for Log purposes
     */
    protected static final String ACTIVITY_NAME = "MainActivity";

    TextView todayDateTV;
    ImageView monkeyOfTheDay;
    TextView horoscopeTV;
    ImageView theLogo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);
        //Edit toolbar (ActionBar)
        //ActionBar actionBar = getSupportActionBar();

        todayDateTV = (TextView) findViewById(R.id.today_date);
        monkeyOfTheDay = (ImageView) findViewById(R.id.monkey_of_the_day);
        horoscopeTV = (TextView) findViewById(R.id.the_horoscope);
        theLogo = (ImageView) findViewById(R.id.logo);

        /* Create Horoscope for today's date      */
        Horoscope todayHoroscope = createHoroscope();

        //Add horoscope to TextView
        horoscopeTV.setText(todayHoroscope.getHoroscope());


        Log.i(ACTIVITY_NAME, "In onCreate()" );

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /*The 3 buttons on the right side of the toolbar*/
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        String btnName = null;
        switch(itemId) {
            //case R.id.menu_settings:
               // btnName = "Settings";
               // break;
            case R.id.menu_compass:
                btnName = "Compass";
                break;
            //case R.id.menu_help:
              //  btnName = "Help";
               // break;
        }
        Toast.makeText(this, "Button " + btnName, Toast.LENGTH_SHORT).show();
        return true;
    }

    public Horoscope createHoroscope() {
        // Retrieves user's profile
        Profile userProfile = Profile.mainProfile;
        // Calculates users Astrological Sign
        AstrologicalSign userSign = AstrologicalSign.getAstrologicalSignForDate(
                userProfile.getMonth(),
                userProfile.getDay()
        );
        // Gets today's date
        Date todaysDate = Calendar.getInstance().getTime();

        //Retrieves a Horoscope for today's date
        return new Horoscope(userSign, todaysDate);
    }
}
