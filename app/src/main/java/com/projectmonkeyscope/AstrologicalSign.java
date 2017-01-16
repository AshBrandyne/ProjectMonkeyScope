package com.projectmonkeyscope;

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

        AstrologicalSign[] signs = new AstrologicalSign[12];

        signs[0] = new AstrologicalSign("Aquarius", new Date(), new Date());
        signs[1] = new AstrologicalSign("Pisces", new Date(), new Date());
        signs[2] = new AstrologicalSign("Aries", new Date(), new Date());
        signs[3] = new AstrologicalSign("Taurus", new Date(), new Date());
        signs[4] = new AstrologicalSign("Gemini", new Date(), new Date());
        signs[5] = new AstrologicalSign("Cancer", new Date(), new Date());
        signs[6] = new AstrologicalSign("Leo", new Date(), new Date());
        signs[7] = new AstrologicalSign("Virgo", new Date(), new Date());
        signs[8] = new AstrologicalSign("Libra", new Date(), new Date());
        signs[9] = new AstrologicalSign("Scorpio", new Date(), new Date());
        signs[10] = new AstrologicalSign("Sagittarius", new Date(), new Date());
        signs[11] = new AstrologicalSign("Capricorn", new Date(), new Date());

        return signs;
    }

    public static AstrologicalSign getAstrologicalSignForDate(Date date) {
        return new AstrologicalSign("Test sign", new Date(), new Date());
    }
}
