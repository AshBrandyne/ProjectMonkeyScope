package com.projectmonkeyscope;

import junit.framework.Assert;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static junit.framework.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Michael on 2017-07-30.
 */

public class SeedTest {
    @Test
    public void testYear() throws Exception {
        Horoscope horoscope;
        ArrayList<Long> seeds = new ArrayList<Long>();

        Calendar calendar = Calendar.getInstance();
        Date date;

        for(int i = 0; i < 365; i++) {
            date = calendar.getTime();
            horoscope = new Horoscope(AstrologicalSign.getAllSigns()[0], date, null);
            long seed = horoscope.getSeed();

            assertFalse("Seed already generated: " + seed, seeds.contains(seed));

            seeds.add(seed);

            calendar.add(Calendar.DAY_OF_YEAR, 1);
        }
    }

    @Test
    public void testYearAllSigns() throws Exception {
        Horoscope horoscope;
        ArrayList<Long> seeds = new ArrayList<Long>();

        Calendar calendar = Calendar.getInstance();
        Date date;

        for(int i = 0; i < 365; i++) {
            for(int j = 0; j < 12; j++) {
                date = calendar.getTime();
                horoscope = new Horoscope(AstrologicalSign.getAllSigns()[j], date, null);
                long seed = horoscope.getSeed();

                assertFalse("Seed already generated: " + seed, seeds.contains(seed));

                seeds.add(seed);
            }

            calendar.add(Calendar.DAY_OF_YEAR, 1);
        }
    }

    @Test
    public void testDecade() throws Exception {
        Horoscope horoscope;
        ArrayList<Long> seeds = new ArrayList<Long>();

        Calendar calendar = Calendar.getInstance();
        Date date;

        for(int i = 0; i < 3650; i++) {
            date = calendar.getTime();
            horoscope = new Horoscope(AstrologicalSign.getAllSigns()[0], date, null);
            long seed = horoscope.getSeed();

            assertFalse("Seed already generated: " + seed, seeds.contains(seed));

            seeds.add(seed);

            calendar.add(Calendar.DAY_OF_YEAR, 1);
        }
    }

    @Test
    public void testDecadeAllSigns() throws Exception {
        Horoscope horoscope;
        ArrayList<Long> seeds = new ArrayList<Long>();

        Calendar calendar = Calendar.getInstance();
        Date date;

        for(int i = 0; i < 3650; i++) {
            for(int j = 0; j < 12; j++) {
                date = calendar.getTime();
                horoscope = new Horoscope(AstrologicalSign.getAllSigns()[j], date, null);
                long seed = horoscope.getSeed();

                assertFalse("Seed already generated: " + seed, seeds.contains(seed));

                seeds.add(seed);
            }

            calendar.add(Calendar.DAY_OF_YEAR, 1);
        }
    }
}
