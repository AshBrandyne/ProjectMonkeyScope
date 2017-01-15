package com.projectmonkeyscope;

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

    /**
     * Constructor for Horoscope class.
     * @param sign The astrological sign for the horoscope.
     * @param date The date for the horoscope.
     */
    public Horoscope(AstrologicalSign sign, Date date) {
        this.sign = sign;
        this.date = date;
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
        return "Placeholder horoscope for " + sign + " on " + date;
    }
}
