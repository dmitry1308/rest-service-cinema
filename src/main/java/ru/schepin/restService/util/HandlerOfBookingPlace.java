package ru.schepin.restService.util;

import ru.schepin.restService.model.NeededPlace;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HandlerOfBookingPlace {
    public NeededPlace process(HttpServletRequest req, HttpServletResponse resp) {
        String row = req.getParameter("row");
        String place = req.getParameter("place");

        if (checkRowAndPlace(row, place)) {
            return new NeededPlace(Integer.valueOf(row), Integer.valueOf(place));
        }
        return null;
    }


    private   boolean checkRowAndPlace(String row, String place) {
        int rowInt;
        int placeInt;

        if (row == null && place == null) {
            return false;
        }
        if (row.equals("")) {
            return false;
        }

        if (place.equals("")) {
            return false;
        }

        rowInt = Integer.valueOf(row);
        placeInt = Integer.valueOf(place);

        return (placeInt <= 3 && placeInt >= 1) && (rowInt <= 3 && rowInt >= 1);
    }

    public boolean checkRowAndPlaceForTest(String row, String place) {
        return checkRowAndPlace(row, place);
    }
}
