package ru.schepin.restService.util;

import ru.schepin.restService.model.RowInHall;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OperationBooking {
    private String row;
    private String place;
    private List<RowInHall> rowInHall;


    public OperationBooking(String row, String place, List<RowInHall> rowInHall) {
        this.row = row;
        this.place = place;
        this.rowInHall = rowInHall;
    }

    public RowInHall toBook() {

        int rowInt = Integer.valueOf(row);
        int placeInt = Integer.valueOf(place);

        Map<Integer, List<String>> placeMap = new HashMap<>();

        for (int i = 0; i < rowInHall.size(); i++) {
            ArrayList<String> places = new ArrayList<>();
            places.add(rowInHall.get(i).getPlace1());
            places.add(rowInHall.get(i).getPlace2());
            places.add(rowInHall.get(i).getPlace3());

            placeMap.put(rowInHall.get(i).getId(), places);
        }


        for (Map.Entry<Integer, List<String>> e : placeMap.entrySet()) {
            Integer key = e.getKey();
            if (key.equals(rowInt)) {
                return changeStatus(placeInt, key);
            }
        }
        return null;
    }

    private RowInHall changeStatus(int placeInt, Integer key) {
        RowInHall row = rowInHall.get(key-1);
        if (placeInt == 1) {
            row.setPlace1("engaged");
            return row;
        } else if (placeInt == 2) {
            row.setPlace2("engaged");
            return row;
        } else {
            row.setPlace3("engaged");
            return row;
        }
    }
}
