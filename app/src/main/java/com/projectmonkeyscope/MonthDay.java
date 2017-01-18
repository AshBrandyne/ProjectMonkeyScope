package com.projectmonkeyscope;

/**
 * Created by Michael on 2017-01-17.
 */

public class MonthDay {

    /**
     * The month. 1 = January, 12 = December, etc
     */
    private int month;

    /**
     * The day of the month.
     */
    private int day;

    /**
     * Default constructor for MonthDay
     */
    public MonthDay() {
        setMonth(1);
        setDay(1);
    }

    /**
     * Constructor for MonthDay
     * @param month The month. 1 = January, 12 = December, etc
     * @param day The day of the month
     */
    public MonthDay(int month, int day) {
        setMonth(month);
        setDay(day);
    }

    /**
     * Sets the month. 1 = January, 12 = December, etc
     * @param month The month.
     */
    public void setMonth(int month) {
        if(month < 1 || month > 12) {
            this.month = 1;
        } else {
            this.month = month;
        }
    }

    /**
     * Sets the day of the month
     * @param day The day of the month.
     */
    public void setDay(int day) {
        if(day < 1 || day > 31) {
            this.day = 1;
        } else {
            this.day = day;
        }

        if(month == 2 && this.day > 29) {
            this.day = 29;
        } else if((month==4 || month==6 || month==8 || month==11) && this.day > 30) {
            this.day = 30;
        }
    }

    /**
     * Gets the month
     * @return The month
     */
    public int getMonth() {
        return month;
    }

    /**
     * Gets the day of the month
     * @return The day of the month
     */
    public  int getDay() {
        return day;
    }

    /**
     * Returns true if this MonthDay is before other MonthDay
     * @param other The MonthDay to compare
     * @return True if this MonthDay is before other MonthDay
     */
    public boolean isBefore(MonthDay other) {
        if(month < other.month) {
            return true;
        } else if(month == other.month && day < other.day) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns true if this MonthDay is after other MonthDay
     * @param other The MonthDay to compare
     * @return True if this MonthDay is after other MonthDay
     */
    public boolean isAfter(MonthDay other) {
        if(month > other.month) {
            return true;
        } else if(month == other.month && day > other.day) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns true if this MonthDay is the same as other MonthDay
     * @param other The MonthDay to compare
     * @return True if this MonthDay is the same as other MonthDay
     */
    public boolean isEqual(MonthDay other) {
        if(month == other.month && day == other.day) {
            return true;
        } else {
            return false;
        }
    }
}
