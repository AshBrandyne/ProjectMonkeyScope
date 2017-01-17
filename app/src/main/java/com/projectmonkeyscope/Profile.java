package com.projectmonkeyscope;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**Profile Class
 * Holds month and day from user information entered in ProfileActivity
 * Use the createDate() method to transform month and day into java.util.Date
 * Saved to SharedPreferences in ProfileActivity
 *
 * Created by Ash-Lee on 2017-01-15.
 * @author Ash-Lee
 * @version 1.0.0 2017-01-15
 */

public class Profile {
    /**
     * The birth month (1-12)
     */
    private int month;
    /**
     * The birth day (1-31)
     */
    private int day;

    /**
     * The user's AstroSign, calculated by their birth date
     *
    private AstrologicalSign sign;*/ //TODO: Delete these sign bits?

    /**
     * Default constructor for Profile class, sets birth month and day
     *
     * @param month the birth month
     * @param day the birth day
     */
    public Profile(int month, int day) {
        this.month = month;
        this.day = day;
    }

    /**
     * Returns the user's month of birth as an int
     * @return the user's birth month (1-12)
     */
    public int getMonth() {
        return month;
    }

    /**
     * Returns the user's day of birth as an int
     * @return the user's birth day (1-31)
     */
    public int getDay() {
        return day;
    }

    /**
     * Returns the user's default Astrological sign based on their birth date
     * @return the user's saved AstroSign
     *
    public AstrologicalSign getSign() { return sign; } */

    /**
     * Sets the month of birth
     * @param month the birth month
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * Sets the day of birth
     * @param day the birth day
     */
    public void setDay(int day) {
        this.day = day;
    }

    /**
     * Given the birth month and day, transform into a Date Object
     * Returns as a formatted Date
     *
     * @param month the birth month
     * @param day the birth day
     */
    public Date createDate(int month, int day) {

        SimpleDateFormat format = new SimpleDateFormat("MM dd");
        Date date = null;

        //We can change the format to what would work best! For now it is ie:
        try {
            date = format.parse(month + " " + day);
            System.out.println("Test date: " + date);
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
        return date;
    }



}
