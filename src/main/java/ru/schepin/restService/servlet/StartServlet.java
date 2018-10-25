package ru.schepin.restService.servlet;

import ru.schepin.restService.util.Urls;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StartServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        System.out.println("doGet is work!(Рендеринг страницы startPage)");
        req.getRequestDispatcher(Urls.index).forward(req, resp);
    }
}
