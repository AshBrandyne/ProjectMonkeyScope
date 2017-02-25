package com.projectmonkeyscope;

import android.content.Context;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Michael on 2017-01-15.
 */

public class Horoscope {

    /**
     * The astrological sign this horoscope is for.
     */
    private AstrologicalSign sign;

    /**
     * The date this horoscope is for.
     */
    private Date date;

    private Context context;

    /**
     * Constructor for Horoscope class.
     * @param sign The astrological sign for the horoscope.
     * @param date The date for the horoscope.
     */
    public Horoscope(AstrologicalSign sign, Date date, Context context) {
        this.sign = sign;
        this.date = date;
        this.context = context;
    }

    /**
     * Returns the date this horoscope is for.
     * @return The date this horoscope is for.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Returns the astrological sign this horoscope is for.
     * @return The astrological sign this horoscope is for.
     */
    public AstrologicalSign getAstrologicalSign() {
        return  sign;
    }

    /**
     * Gives the horoscope for this sign and date.
     * @return The horoscope for this sign and date.
     */
    public String toString() {
        PhrasalTemplate phrasalTemplate = new PhrasalTemplate(getSeed());
        phrasalTemplate.setContext(context);
        phrasalTemplate.loadTemplates();
        phrasalTemplate.parseTokensFromTemplates();
        return "Placeholder horoscope for " + sign + " on " + date + ": " + phrasalTemplate.getPhrase();
    }

    /**
     * Generates and returns a seed for this horoscope based on the date and astrological sign
     * @return A seed for the horoscope
     */
    private long getSeed() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.YEAR) + cal.get(Calendar.MONTH) * 10 + cal.get(Calendar.DATE) * 100 * sign.toString().hashCode();
    }

    /**
     * Gives the text of the horoscope
     * @return The horoscope for this sign and date.
     */
    public String getHoroscope() {
        return this.toString();
    }
}
