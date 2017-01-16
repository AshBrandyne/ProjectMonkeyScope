package com.projectmonkeyscope;

/**Profile Class
 * Holds month and day from user information entered in ProfileActivity
 * Finds AstrologicalSign based on the user's day and month of birth
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
     */
    private AstrologicalSign sign;

    /**
     * Default constructor for Profile class, sets birth month and day
     * Assigns AstroSign based on month and day
     *
     * @param month the birth month
     * @param day the birth day
     */
    public Profile(int month, int day) {
        this.month = month;
        this.day = day;
        //this.sign = static method to find AstroSign?
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
     */
    public AstrologicalSign getSign() { return sign; }

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
     * Given the birth month and day, set user's Astrological sign
     * This is saved to SharedPrefs and be the default sign for the user
     *
     * @param month the birth month
     * @param day the birth day
     */
    public void setSign(int month, int day) {
        //will use a static method in AstroSign to find a sign based on a date

    }



}
