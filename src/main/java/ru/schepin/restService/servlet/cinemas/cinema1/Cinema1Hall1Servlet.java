package ru.schepin.restService.servlet.cinemas.cinema1;

import ru.schepin.restService.dao.RowInHallDao;
import ru.schepin.restService.dao.RowInHallDaoImpl;
import ru.schepin.restService.model.RowInHall;
import ru.schepin.restService.util.OperationBooking;
import ru.schepin.restService.util.Urls;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class Cinema1Hall1Servlet extends HttpServlet {
    private RowInHallDao<RowInHall> rowInHallDao;
    private String row;
    private String place;

    @Override
    public void init() throws ServletException {
        Object rowInHallDao = getServletContext().getAttribute("rowInHallDao");
        if (!(rowInHallDao instanceof RowInHallDaoImpl)) {

            throw new IllegalStateException("You're repo does not initialize!");
        } else {
            this.rowInHallDao = (RowInHallDao<RowInHall>) rowInHallDao;
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

        List<RowInHall> rowInHall = rowInHallDao.getByAllRows();

        if (!checkRowAndPlace(row, place)) {
            drawPage(req, resp, rowInHall);
        } else {
            OperationBooking operationBooking = new OperationBooking(row, place, rowInHall);
            RowInHall rowInHallForBase = operationBooking.toBook();
            rowInHallDao.update(rowInHallForBase);
            drawPage(req, resp, rowInHall);
        }
    }

    private void drawPage(HttpServletRequest req, HttpServletResponse resp, List<RowInHall> rowInHall) throws ServletException, IOException {
        System.out.println("doPost is work!(Рендеринг страницы Cinema1Hall1Servlet)");
        req.setAttribute("rowInHall", rowInHall);
        req.getRequestDispatcher(Urls.cinemaHall1).forward(req, resp);
    }

    private boolean checkRowAndPlace(String row, String place) {
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
