package ru.schepin.restService.util;

import javax.servlet.http.HttpServletRequest;

public class Utils {
    public static   boolean requestIsValid(final HttpServletRequest req) {

        final String login = req.getParameter("login");
        final String password = req.getParameter("password");

        return login != null && login.length() > 0 &&
                password != null && password.length() > 0;
    }
}
