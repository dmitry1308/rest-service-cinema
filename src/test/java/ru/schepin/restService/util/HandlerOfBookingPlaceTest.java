package ru.schepin.restService.util;

import org.junit.Assert;
import org.junit.Test;

public class HandlerOfBookingPlaceTest {
    private HandlerOfBookingPlace handlerOfBookingPlace = new HandlerOfBookingPlace();


    @Test
    public void shouldReturnTrueWhenIdentifiedAllValues() {
        boolean actual = handlerOfBookingPlace.checkRowAndPlaceForTest("1", "2");
        Assert.assertTrue(actual);
    }

    @Test
    public void shouldReturnFalseWhenIdentifiedFirstValues() {
        boolean actual = handlerOfBookingPlace.checkRowAndPlaceForTest("1", "");
        Assert.assertFalse(actual);
    }

    @Test
    public void shouldReturnFalseWhenIdentifiedSecondValues() {
        boolean actual = handlerOfBookingPlace.checkRowAndPlaceForTest("", "2");
        Assert.assertFalse(actual);
    }

    @Test
    public void shouldReturnFalseWhenFirstValuesMore3AndLess1() {
        boolean actual1 = handlerOfBookingPlace.checkRowAndPlaceForTest("4", "2");
        boolean actual2 = handlerOfBookingPlace.checkRowAndPlaceForTest("0", "2");
        Assert.assertFalse(actual1);
        Assert.assertFalse(actual2);
    }

    @Test
    public void shouldReturnFalseWhenSecondValuesMore3AndLess1() {
        boolean actual1 = handlerOfBookingPlace.checkRowAndPlaceForTest("2", "4");
        boolean actual2 = handlerOfBookingPlace.checkRowAndPlaceForTest("1", "-1");
        Assert.assertFalse(actual1);
        Assert.assertFalse(actual2);
    }
}
