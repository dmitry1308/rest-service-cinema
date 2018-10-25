package ru.schepin.restService.servlet.cinemas.cinema1.halls;

import org.junit.Assert;
import org.junit.Test;
import ru.schepin.restService.model.RowInHall;

public class Cinema1Hall1ServletTest {





    @Test
    public void shouldReturnChangedEntityWhenCallMethodToBook() {
        Cinema1Hall1Servlet cinema1Hall1Servlet = new Cinema1Hall1Servlet();
        RowInHall rowInHall = new RowInHall(1, "Free", "Free", "Free");
        RowInHall expected = new RowInHall(1, "engaged", "Free", "Free");
        int place = 1;
        RowInHall actual = cinema1Hall1Servlet.toBookTest(place, rowInHall);
        Assert.assertEquals(expected, actual);
    }
}


