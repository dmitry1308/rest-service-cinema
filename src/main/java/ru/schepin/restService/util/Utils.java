package ru.schepin.restService.util;

import javax.servlet.http.HttpServletRequest;

public class Utils {
    public static boolean requestIsValid(final HttpServletRequest req) {

        final String login = req.getParameter("login");
        final String password = req.getParameter("password");

        return login != null && login.length() > 0 &&
                password != null && password.length() > 0;
    }


    public static boolean checkRowAndPlace(String row, String place) {
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
}
