package ru.schepin.restService.servlet.cinemas.cinema1.halls;

import ru.schepin.restService.dao.RowInHallDao;
import ru.schepin.restService.dao.RowInHallDaoImpl;
import ru.schepin.restService.model.RowInHall;
import ru.schepin.restService.util.Urls;
import ru.schepin.restService.util.Utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class Cinema1Hall1Servlet extends HttpServlet {
    private RowInHallDao<RowInHall, Integer> rowInHallDao;
    private String row;
    private String place;

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
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        row = req.getParameter("row");
        place = req.getParameter("place");

        String zero = req.getParameter("zero");

        List<RowInHall> rowInHall = rowInHallDao.getByAllRows();

        if (!Utils.checkRowAndPlace(row, place)) {
            drawPage(req, resp, rowInHall);
        } else {
            int rowInt = Integer.valueOf(row);
            int placeInt = Integer.valueOf(place);
            RowInHall neededRow = rowInHallDao.getByKey(rowInt);
            RowInHall rowInHallForBase = toBook(placeInt, neededRow);
            rowInHallDao.update(rowInHallForBase);
            rowInHall = rowInHallDao.getByAllRows();
            drawPage(req, resp, rowInHall);
        }
    }

    private void drawPage(HttpServletRequest req, HttpServletResponse resp, List<RowInHall> rowInHall) throws ServletException, IOException {
        System.out.println("doPost is work!(Рендеринг страницы Cinema1Hall1Servlet)");
        req.setAttribute("rowInHall", rowInHall);
        req.getRequestDispatcher(Urls.cinemaHall1).forward(req, resp);
    }

    private RowInHall toBook(int placeInt, RowInHall neededRow) {
        if (placeInt == 1) {
            neededRow.setPlace1("engaged");
        } else if (placeInt == 2) {
            neededRow.setPlace2("engaged");
        } else {
            neededRow.setPlace3("engaged");
        }
        return neededRow;
    }
}
