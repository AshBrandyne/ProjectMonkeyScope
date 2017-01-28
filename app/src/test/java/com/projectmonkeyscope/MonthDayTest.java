package com.projectmonkeyscope;

import com.projectmonkeyscope.MonthDay;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Michael on 2017-01-24.
 */
public class MonthDayTest {
    @Test
    public void setAndGetMonth() throws Exception {
        MonthDay monthDay = new MonthDay();
        monthDay.setMonth(1);
        assertTrue(monthDay.getMonth() == 1);
        monthDay.setMonth(0);
        assertFalse(monthDay.getMonth() == 0);
        monthDay.setMonth(-1);
        assertFalse(monthDay.getMonth() == -1);
        monthDay.setMonth(13);
        assertFalse(monthDay.getMonth() == 13);
        monthDay.setMonth(12);
        assertTrue(monthDay.getMonth() == 12);
    }

    @Test
    public void setAndGetDay() throws Exception {
        MonthDay monthDay = new MonthDay();
        monthDay.setMonth(1);
        monthDay.setDay(1);
        assertTrue(monthDay.getDay() == 1);
        monthDay.setDay(31);
        assertTrue(monthDay.getDay() == 31);
        monthDay.setDay(32);
        assertFalse(monthDay.getDay() == 32);
        monthDay.setDay(-1);
        assertFalse(monthDay.getDay() == -1);
        monthDay.setMonth(2);
        monthDay.setDay(31);
        assertFalse(monthDay.getDay() == 31);
    }

    @Test
    public void isBefore() throws Exception {
        MonthDay earlyDate = new MonthDay(1, 1);
        MonthDay laterDate = new MonthDay(12, 31);

        assertTrue(earlyDate.isBefore(laterDate));
        assertFalse(laterDate.isBefore(earlyDate));
        assertFalse(earlyDate.isBefore(earlyDate));
    }

    @Test
    public void isAfter() throws Exception {
        MonthDay earlyDate = new MonthDay(1, 1);
        MonthDay laterDate = new MonthDay(12, 31);

        assertTrue(laterDate.isAfter(earlyDate));
        assertFalse(earlyDate.isAfter(laterDate));
        assertFalse(laterDate.isAfter(laterDate));
    }

    @Test
    public void isEqual() throws Exception {
        MonthDay oneDay = new MonthDay(2, 1);
        MonthDay sameDay = new MonthDay(2, 1);
        MonthDay earlierDay = new MonthDay(1, 1);
        MonthDay laterDay = new MonthDay(12, 31);

        assertTrue(oneDay.isEqual(oneDay));
        assertTrue(oneDay.isEqual(sameDay));
        assertFalse(oneDay.isEqual(earlierDay));
        assertFalse(oneDay.isEqual(laterDay));
    }
}