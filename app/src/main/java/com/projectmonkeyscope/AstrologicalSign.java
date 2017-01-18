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
    private Date startDate;

    /**
     * The date the sign ends.
     */
    private Date endDate;

    /**
     * Connstructor for Astrological Sign
     * @param name The name of astrological sign
     * @param startDate The date the sign begins
     * @param endDate The date the sign ends
     */
    public AstrologicalSign(String name, Date startDate, Date endDate) {
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

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        AstrologicalSign[] signs = new AstrologicalSign[12];

        try {
            signs[0] = new AstrologicalSign("Aquarius",     dateFormat.parse("2000-01-20"), dateFormat.parse("2000-02-18"));
            signs[1] = new AstrologicalSign("Pisces",       dateFormat.parse("2000-02-19"), dateFormat.parse("2000-03-20"));
            signs[2] = new AstrologicalSign("Aries",        dateFormat.parse("2000-03-21"), dateFormat.parse("2000-04-19"));
            signs[3] = new AstrologicalSign("Taurus",       dateFormat.parse("2000-04-20"), dateFormat.parse("2000-05-20"));
            signs[4] = new AstrologicalSign("Gemini",       dateFormat.parse("2000-05-21"), dateFormat.parse("2000-06-20"));
            signs[5] = new AstrologicalSign("Cancer",       dateFormat.parse("2000-06-21"), dateFormat.parse("2000-07-22"));
            signs[6] = new AstrologicalSign("Leo",          dateFormat.parse("2000-07-23"), dateFormat.parse("2000-08-22"));
            signs[7] = new AstrologicalSign("Virgo",        dateFormat.parse("2000-08-23"), dateFormat.parse("2000-09-22"));
            signs[8] = new AstrologicalSign("Libra",        dateFormat.parse("2000-09-23"), dateFormat.parse("2000-10-22"));
            signs[9] = new AstrologicalSign("Scorpio",      dateFormat.parse("2000-10-23"), dateFormat.parse("2000-11-21"));
            signs[10] = new AstrologicalSign("Sagittarius", dateFormat.parse("2000-11-22"), dateFormat.parse("2000-12-21"));
            signs[11] = new AstrologicalSign("Capricorn",   dateFormat.parse("2000-12-22"), dateFormat.parse("2001-01-19"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return signs;
    }

    /**
     * Returns the astrological sign associated with a date
     * @param date The date you want to know the sign for
     * @return The astrological sign associated with the date
     */
    public static AstrologicalSign getAstrologicalSignForDate(Date date) {
        return getAstrologicalSignForDate(date, AstrologicalSign.getAllSigns());
    }

    /**
     * Returns the astrological sign associated with a date
     * @param date The date you want to know the sign for
     * @param signs An array containing the signs you want to check the date for
     * @return The astrological sign associated with a date
     */
    public static AstrologicalSign getAstrologicalSignForDate(Date date, AstrologicalSign[] signs) {

        for(int i = 0; i < signs.length; i++) {
            if(date.after(signs[i].startDate) && date.before(signs[i].endDate)) {
                return signs[i];
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
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            String dateString = "2000-" + month + "-" + day;
            Date date = dateFormat.parse(dateString);
            return getAstrologicalSignForDate(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
