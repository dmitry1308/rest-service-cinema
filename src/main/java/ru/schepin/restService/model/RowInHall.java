package ru.schepin.restService.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class RowInHall {
    private int id;
    private int numberOfRow;
    private String place1;
    private String place2;
    private String place3;



    public RowInHall(int numberOfRow, String place1, String place2, String place3) {
        this.numberOfRow = numberOfRow;
        this.place1 = place1;
        this.place2 = place2;
        this.place3 = place3;
    }

    public RowInHall() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberOfRow() {
        return numberOfRow;
    }

    public void setNumberOfRow(int numberOfRow) {
        this.numberOfRow = numberOfRow;
    }

    public String getPlace1() {
        return place1;
    }

    public void setPlace1(String place1) {
        this.place1 = place1;
    }

    public String getPlace2() {
        return place2;
    }

    public void setPlace2(String place2) {
        this.place2 = place2;
    }

    public String getPlace3() {
        return place3;
    }

    public void setPlace3(String place3) {
        this.place3 = place3;
    }
}
