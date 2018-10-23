package ru.schepin.restService.servlet.cinemas.cinema1;

import ru.schepin.restService.dao.RowInHallDao;
import ru.schepin.restService.dao.RowsInHallDaoImpl;
import ru.schepin.restService.model.RowInHall;
import ru.schepin.restService.util.Urls;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class Cinema1Hall1 extends HttpServlet {
    private RowInHallDao<RowInHall> rowInHallDao;

    @Override
    public void init() throws ServletException {
        Object rowInHallDao = getServletContext().getAttribute("rowInHallDao");
        if (!(rowInHallDao instanceof RowsInHallDaoImpl)) {

            throw new IllegalStateException("You're repo does not initialize!");
        } else {
            this.rowInHallDao = (RowInHallDao<RowInHall>) rowInHallDao;
        }

        System.out.println("*************SERVLET Cinema1Hall1  IS INIT************");
    }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        System.out.println("doGet is work!(Рендеринг страницы Cinema1Hall1)");
        req.getRequestDispatcher(Urls.cinemaHall1).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<RowInHall> rowInHalls = rowInHallDao.getByAllRows();
        System.out.println(rowInHalls);

        req.setAttribute("rowInHalls", rowInHalls);


        System.out.println("doPost is work!(Рендеринг страницы Cinema1Hall1)");
        req.getRequestDispatcher(Urls.cinemaHall1).forward(req, resp);
    }
}
