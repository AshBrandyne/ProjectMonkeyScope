package com.projectmonkeyscope;

import java.io.Serializable;

/**Profile Class
 * Holds month and day from user information entered in ProfileActivity
 * Implements Serializable so it can be passed through Bundles
 *
 * Saved to SharedPreferences in ProfileActivity
 *
 * Created by Ash-Lee on 2017-01-15.
 * @author Ash-Lee
 * @version 1.2.0 2017-01-17
 */

public class Profile{
    /**
     * The birth month and day of the user as a MonthDay Object
     */
    private MonthDay monthDay;


    /**
     * Default constructor for Profile class
     * Sets MonthDay Object with birth month and day
     *
     * @param month the birth month
     * @param day the birth day
     */
    public Profile(int month, int day) {
        monthDay = new MonthDay(month, day);
    }

    /**
     * Returns the user's month of birth as an int
     * @return the user's birth month (1-12)
     */
    public int getMonth() {
        return monthDay.getMonth();
    }

    /**
     * Returns the user's day of birth as an int
     * @return the user's birth day (1-31)
     */
    public int getDay() {
        return monthDay.getDay();
    }

    /**
     * Sets the month of birth
     * @param month the birth month
     */
    public void setMonth(int month) {
        monthDay.setMonth(month);
    }

    /**
     * Sets the day of birth
     * @param day the birth day
     */
    public void setDay(int day) {
        monthDay.setDay(day);
    }

}
//End of Profile.java
