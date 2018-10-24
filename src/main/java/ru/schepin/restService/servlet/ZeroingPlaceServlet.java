package ru.schepin.restService.servlet;

import ru.schepin.restService.dao.RowInHallDao;
import ru.schepin.restService.dao.RowInHallDaoImpl;
import ru.schepin.restService.model.RowInHall;
import ru.schepin.restService.util.Urls;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ZeroingPlaceServlet extends HttpServlet {

    private RowInHallDao<RowInHall, Integer> rowInHallDao;
    private Object Cinema1Hall1Servlet;

    @Override
    public void init() throws ServletException {
        Object rowInHallDao = getServletContext().getAttribute("rowInHallDao");
        if (!(rowInHallDao instanceof RowInHallDaoImpl)) {

            throw new IllegalStateException("You're repo does not initialize!");
        } else {
            this.rowInHallDao = (RowInHallDao<RowInHall, Integer>) rowInHallDao;
        }

        System.out.println("*************SERVLET Cinema1Hall1Servlet  IS INIT************");
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher(Urls.cinemaHall1).forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<RowInHall> rowInHall = rowInHallDao.getByAllRows();

        for (int i = 0; i < rowInHall.size(); i++) {
            rowInHall.get(i).setPlace1("free");
            rowInHall.get(i).setPlace2("free");
            rowInHall.get(i).setPlace3("free");
            rowInHallDao.update(rowInHall.get(i));
        }

        rowInHall = rowInHallDao.getByAllRows();
        req.setAttribute("rowInHall", rowInHall);
        req.getRequestDispatcher(Urls.cinemaHall1).forward(req, resp);
    }
}
