package com.projectmonkeyscope;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Michael on 2017-01-15.
 */

public class AstrologicalSign {

    private String name;
    private Date startDate;
    private Date endDate;

    public AstrologicalSign(String name, Date startDate, Date endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String toString() {
        return name;
    }

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

    public static AstrologicalSign getAstrologicalSignForDate(Date date) {
        return new AstrologicalSign("Test sign", new Date(), new Date());
    }
}
