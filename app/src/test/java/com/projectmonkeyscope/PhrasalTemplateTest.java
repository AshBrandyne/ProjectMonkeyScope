package com.projectmonkeyscope;

import android.annotation.TargetApi;
import android.icu.util.Calendar;
import android.util.Log;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Michael on 2017-01-28.
 */
public class PhrasalTemplateTest {
    @Test
    public void getTestPhrase() throws Exception {
        PhrasalTemplate phrasalTemplate = new PhrasalTemplate();
        assertNotEquals(phrasalTemplate.getTestPhrase(), phrasalTemplate.getTestPhrase());

        PhrasalTemplate phrasalTemplateSeeded0 = new PhrasalTemplate(0);
        PhrasalTemplate phrasalTemplateSeeded1 = new PhrasalTemplate(0);
        assertEquals(phrasalTemplateSeeded0.getTestPhrase(), phrasalTemplateSeeded1.getTestPhrase());
    }

    @Test
    @TargetApi(24)
    public void testSomeHoroscopes() throws Exception {
        /*AstrologicalSign aquarius = new AstrologicalSign("Aquarius", new MonthDay(1, 20), new MonthDay(2, 18));
        AstrologicalSign leo = new AstrologicalSign("Leo", new MonthDay(7, 23), new MonthDay(8, 22));
        Date date = new Date();
        Horoscope horoscope1 = new Horoscope(aquarius, date);
        Horoscope horoscope2 = new Horoscope(leo, date);
        assertNotEquals(horoscope1.toString(), horoscope1, horoscope2);*/
    }

    @Test
    public void testLoadTemplates() {
        String filename = "src\\Templates\\testTemplates.txt";
        PhrasalTemplate phrasalTemplate = new PhrasalTemplate();
        phrasalTemplate.loadTemplates(filename);
        assertFalse(phrasalTemplate.testGetNumTemplates()==0);
        assertTrue(phrasalTemplate.testGetNumTemplates()==3);
    }

    @Test
    public void testLoadTokens() {
        PhrasalTemplate phrasalTemplate = new PhrasalTemplate();
        phrasalTemplate.loadTemplates();
        phrasalTemplate.parseTokensFromTemplates();
        assertTrue(phrasalTemplate.testGetNumTokens()==4);
        assertTrue(phrasalTemplate.testGetTokenValues("NOUN") == 4);
        assertTrue(phrasalTemplate.testGetTokenValues("VERB") == 5);
    }

    @Test
    public void testHoroscope() {
        /*PhrasalTemplate phrasalTemplate = new PhrasalTemplate();
        phrasalTemplate.loadTemplates();
        phrasalTemplate.parseTokensFromTemplates();
        AstrologicalSign aquarius = new AstrologicalSign("Aquarius", new MonthDay(1, 20), new MonthDay(2, 18));
        Date date = new Date();
        Horoscope horoscope = new Horoscope(aquarius, date);
        assertNotEquals(horoscope.toString(), horoscope, horoscope);*/
    }
}