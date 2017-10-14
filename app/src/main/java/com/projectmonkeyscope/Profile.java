package com.projectmonkeyscope;

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
    private MonthDay birthDate;
    /**
     * Static variable holds the main profile for use throughout the app
     */
    public static Profile mainProfile;


    /**
     * Initial constructor for Profile class
     * Sets MonthDay Object with birth month and day
     *
     * @param month the birth month
     * @param day the birth day
     */
    public Profile(int month, int day) {
        birthDate = new MonthDay(month, day);
    }

    /**
     * Constructor for Profile Class
     * @param birthDate The birth month and day
     */
    public Profile(MonthDay birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Returns the user's month of birth as an int
     * @return the user's birth month (1-12)
     */
    public int getMonth() {
        return birthDate.getMonth();
    }

    /**
     * Returns the user's day of birth as an int
     * @return the user's birth day (1-31)
     */
    public int getDay() {
        return birthDate.getDay();
    }

    /**
     * Sets the month of birth
     * @param month the birth month
     */
    public void setMonth(int month) {
        birthDate.setMonth(month);
    }

    /**
     * Sets the day of birth
     * @param day the birth day
     */
    public void setDay(int day) {
        birthDate.setDay(day);
    }

    @Override
    public String toString() {
        return "[ day: " + getDay() +
                " month: " + getMonth() +
                " ]";
    }

}
//End of Profile.java
