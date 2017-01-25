package com.projectmonkeyscope;

import android.text.format.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Michael on 2017-01-15.
 */

public class AstrologicalSign {

    /**
     * The name of the Astrological Sign
     */
    private String name;

    /**
     * The date the sign begins.
     */
    private MonthDay startDate;

    /**
     * The date the sign ends.
     */
    private MonthDay endDate;

    /**
     * Connstructor for Astrological Sign
     * @param name The name of astrological sign
     * @param startDate The date the sign begins
     * @param endDate The date the sign ends
     */
    public AstrologicalSign(String name, MonthDay startDate, MonthDay endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    /**
     * Returns the name of the Astrological Sign
     * @return The name of the Astrological Sign
     */
    public String toString() {
        return name;
    }

    /**
     * Returns an array containing the twelve astrological signs
     * @return An array containing the twelve astrological signs
     */
    public static AstrologicalSign[] getAllSigns() {

        AstrologicalSign[] signs = new AstrologicalSign[12];

        signs[0] = new AstrologicalSign("Aquarius",     new MonthDay(1, 20), new MonthDay(2, 18));
        signs[1] = new AstrologicalSign("Pisces",       new MonthDay(2, 19), new MonthDay(3, 20));
        signs[2] = new AstrologicalSign("Aries",        new MonthDay(3, 21), new MonthDay(4, 19));
        signs[3] = new AstrologicalSign("Taurus",       new MonthDay(4, 20), new MonthDay(5, 20));
        signs[4] = new AstrologicalSign("Gemini",       new MonthDay(5, 21), new MonthDay(6, 20));
        signs[5] = new AstrologicalSign("Cancer",       new MonthDay(6, 21), new MonthDay(7, 22));
        signs[6] = new AstrologicalSign("Leo",          new MonthDay(7, 23), new MonthDay(8, 22));
        signs[7] = new AstrologicalSign("Virgo",        new MonthDay(8, 23), new MonthDay(9, 22));
        signs[8] = new AstrologicalSign("Libra",        new MonthDay(9, 23), new MonthDay(10, 22));
        signs[9] = new AstrologicalSign("Scorpio",      new MonthDay(10, 23), new MonthDay(11, 21));
        signs[10] = new AstrologicalSign("Sagittarius", new MonthDay(11, 22), new MonthDay(12, 21));
        signs[11] = new AstrologicalSign("Capricorn",   new MonthDay(12, 22), new MonthDay(1, 19));

        return signs;
    }

    /**
     * Returns the astrological sign associated with a date
     * @param date The date you want to know the sign for
     * @return The astrological sign associated with the date
     */
    public static AstrologicalSign getAstrologicalSignForDate(MonthDay date) {
        return getAstrologicalSignForDate(date, AstrologicalSign.getAllSigns());
    }

    /**
     * Returns the astrological sign associated with a date
     * @param date The date you want to know the sign for
     * @param signs An array containing the signs you want to check the date for
     * @return The astrological sign associated with a date
     */
    public static AstrologicalSign getAstrologicalSignForDate(MonthDay date, AstrologicalSign[] signs) {

        for(int i = 0; i < signs.length; i++) {
            if (date.isEqual(signs[i].startDate) || date.isEqual(signs[i].endDate)) {
                return signs[i];
            }
            else if(date.isAfter(signs[i].startDate) && date.isBefore(signs[i].endDate)) {
                return signs[i];
            } else if (signs[i].startDate.isAfter(signs[i].endDate)) {
                if(date.isAfter(signs[i].startDate) || date.isBefore(signs[i].endDate)) {
                    return signs[i];
                }
            }
        }
        return null;
    }

    /**
     * Returns the astrological sign associated with a date
     * @param month The month you want to check
     * @param day The day of the month you want to check
     * @return The Astrological Sign associated with a date
     */
    public static AstrologicalSign getAstrologicalSignForDate(int month, int day) {
        MonthDay date = new MonthDay(month, day);
        return getAstrologicalSignForDate(date);
    }
}
