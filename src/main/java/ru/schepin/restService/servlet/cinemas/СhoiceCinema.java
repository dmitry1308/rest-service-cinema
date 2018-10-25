package ru.schepin.restService.servlet.cinemas;

import ru.schepin.restService.util.Urls;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class СhoiceCinema extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        System.out.println("doGet is work!(Рендеринг страницы)");
        req.getRequestDispatcher(Urls.choiceHallsInSinema1).forward(req, resp);
    }
}
