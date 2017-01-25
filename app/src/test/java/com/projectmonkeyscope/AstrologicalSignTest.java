package com.projectmonkeyscope;

import org.junit.Test;

import static junit.framework.TestCase.*;

/** Testing Astrological Date Class
 *
 * This test class helped us discover 1 bug.
 *
 * Created by Ash-Lee on 2017-01-23.
 */
public class AstrologicalSignTest {

    MonthDay boundaryDate1 = null;
    MonthDay boundaryDate2 = null;
    MonthDay midDate = null;


    @Test
    public void signAquarius_isCorrect() throws Exception {
        boundaryDate1 = new MonthDay(1, 20);
        boundaryDate2 = new MonthDay(2, 18);
        midDate = new MonthDay(2, 3);

        assertEquals("Start date for Aquarius", AstrologicalSign.getAstrologicalSignForDate(boundaryDate1).toString(), "Aquarius");
        assertEquals("End date for Aquarius", AstrologicalSign.getAstrologicalSignForDate(boundaryDate2).toString(), "Aquarius");
        assertEquals("Random Aquarius date", AstrologicalSign.getAstrologicalSignForDate(midDate).toString(), "Aquarius");
    }

    @Test
    public void signPisces_isCorrect() throws Exception {
        boundaryDate1 = new MonthDay(2, 19);
        boundaryDate2 = new MonthDay(3, 20);
        midDate = new MonthDay(3, 2);

        assertEquals("Start date for Pisces", AstrologicalSign.getAstrologicalSignForDate(boundaryDate1).toString(), "Pisces");
        assertEquals("End date for Pisces", AstrologicalSign.getAstrologicalSignForDate(boundaryDate2).toString(), "Pisces");
        assertEquals("Random Pisces date", AstrologicalSign.getAstrologicalSignForDate(midDate).toString(), "Pisces");
    }

    @Test
    public void signAries_isCorrect() throws Exception {
        boundaryDate1 = new MonthDay(3, 21);
        boundaryDate2 = new MonthDay(4, 19);
        midDate = new MonthDay(4, 2);

        assertEquals("Start date for Aries", AstrologicalSign.getAstrologicalSignForDate(boundaryDate1).toString(), "Aries");
        assertEquals("End date for Aries", AstrologicalSign.getAstrologicalSignForDate(boundaryDate2).toString(), "Aries");
        assertEquals("Random Aries date", AstrologicalSign.getAstrologicalSignForDate(midDate).toString(), "Aries");
    }

    @Test
    public void signTaurus_isCorrect() throws Exception {
        boundaryDate1 = new MonthDay(4, 20);
        boundaryDate2 = new MonthDay(5, 20);
        midDate = new MonthDay(5, 2);

        assertEquals("Start date for Taurus", AstrologicalSign.getAstrologicalSignForDate(boundaryDate1).toString(), "Taurus");
        assertEquals("End date for Taurus", AstrologicalSign.getAstrologicalSignForDate(boundaryDate2).toString(), "Taurus");
        assertEquals("Random Taurus date", AstrologicalSign.getAstrologicalSignForDate(midDate).toString(), "Taurus");
    }

    @Test
    public void signGemini_isCorrect() throws Exception {
        boundaryDate1 = new MonthDay(5, 21);
        boundaryDate2 = new MonthDay(6, 20);
        midDate = new MonthDay(6, 2);

        assertEquals("Start date for Gemini", AstrologicalSign.getAstrologicalSignForDate(boundaryDate1).toString(), "Gemini");
        assertEquals("End date for Gemini", AstrologicalSign.getAstrologicalSignForDate(boundaryDate2).toString(), "Gemini");
        assertEquals("Random Gemini date", AstrologicalSign.getAstrologicalSignForDate(midDate).toString(), "Gemini");
    }

    @Test
    public void signCancer_isCorrect() throws Exception {
        boundaryDate1 = new MonthDay(6, 21);
        boundaryDate2 = new MonthDay(7, 22);
        midDate = new MonthDay(7, 2);

        assertEquals("Start date for Cancer", AstrologicalSign.getAstrologicalSignForDate(boundaryDate1).toString(), "Cancer");
        assertEquals("End date for Cancer", AstrologicalSign.getAstrologicalSignForDate(boundaryDate2).toString(), "Cancer");
        assertEquals("Random Cancer date", AstrologicalSign.getAstrologicalSignForDate(midDate).toString(), "Cancer");
    }

    @Test
    public void signLeo_isCorrect() throws Exception {
        boundaryDate1 = new MonthDay(7, 23);
        boundaryDate2 = new MonthDay(8, 22);
        midDate = new MonthDay(8, 2);

        assertEquals("Start date for Leo", AstrologicalSign.getAstrologicalSignForDate(boundaryDate1).toString(), "Leo");
        assertEquals("End date for Leo", AstrologicalSign.getAstrologicalSignForDate(boundaryDate2).toString(), "Leo");
        assertEquals("Random Leo date", AstrologicalSign.getAstrologicalSignForDate(midDate).toString(), "Leo");
    }

    @Test
    public void signVirgo_isCorrect() throws Exception {
        boundaryDate1 = new MonthDay(8, 23);
        boundaryDate2 = new MonthDay(9, 22);
        midDate = new MonthDay(9, 2);

        assertEquals("Start date for Virgo", AstrologicalSign.getAstrologicalSignForDate(boundaryDate1).toString(), "Virgo");
        assertEquals("End date for Virgo", AstrologicalSign.getAstrologicalSignForDate(boundaryDate2).toString(), "Virgo");
        assertEquals("Random Virgo date", AstrologicalSign.getAstrologicalSignForDate(midDate).toString(), "Virgo");
    }

    @Test
    public void signLibra_isCorrect() throws Exception {
        boundaryDate1 = new MonthDay(9, 23);
        boundaryDate2 = new MonthDay(10, 22);
        midDate = new MonthDay(10, 2);

        assertEquals("Start date for Libra", AstrologicalSign.getAstrologicalSignForDate(boundaryDate1).toString(), "Libra");
        assertEquals("End date for Libra", AstrologicalSign.getAstrologicalSignForDate(boundaryDate2).toString(), "Libra");
        assertEquals("Random Libra date", AstrologicalSign.getAstrologicalSignForDate(midDate).toString(), "Libra");
    }

    @Test
    public void signScorpio_isCorrect() throws Exception {
        boundaryDate1 = new MonthDay(10, 23);
        boundaryDate2 = new MonthDay(11, 21);
        midDate = new MonthDay(11, 12);

        assertEquals("Start date for Scorpio", AstrologicalSign.getAstrologicalSignForDate(boundaryDate1).toString(), "Scorpio");
        assertEquals("End date for Scorpio", AstrologicalSign.getAstrologicalSignForDate(boundaryDate2).toString(), "Scorpio");
        assertEquals("Random Scorpio date", AstrologicalSign.getAstrologicalSignForDate(midDate).toString(), "Scorpio");
    }

    @Test
    public void signSagittarius_isCorrect() throws Exception {
        boundaryDate1 = new MonthDay(11, 22);
        boundaryDate2 = new MonthDay(12, 21);
        midDate = new MonthDay(12, 2);

        assertEquals("Start date for Sagittarius", AstrologicalSign.getAstrologicalSignForDate(boundaryDate1).toString(), "Sagittarius");
        assertEquals("End date for Sagittarius", AstrologicalSign.getAstrologicalSignForDate(boundaryDate2).toString(), "Sagittarius");
        assertEquals("Random Sagittarius date", AstrologicalSign.getAstrologicalSignForDate(midDate).toString(), "Sagittarius");
    }

    @Test
    public void signCapricorn_isCorrect() throws Exception {
        boundaryDate1 = new MonthDay(12, 22);
        boundaryDate2 = new MonthDay(1, 19);
        midDate = new MonthDay(1, 1);

        assertEquals("Start date for Capricorn", AstrologicalSign.getAstrologicalSignForDate(boundaryDate1).toString(), "Capricorn");
        assertEquals("End date for Capricorn", AstrologicalSign.getAstrologicalSignForDate(boundaryDate2).toString(), "Capricorn");
        assertEquals("Random Capricorn date", AstrologicalSign.getAstrologicalSignForDate(midDate).toString(), "Capricorn");
    }
}