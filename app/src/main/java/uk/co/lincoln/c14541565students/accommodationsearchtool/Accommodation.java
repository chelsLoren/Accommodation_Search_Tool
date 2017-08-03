package uk.co.lincoln.c14541565students.accommodationsearchtool;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Chelsey on 10/03/2016.
 */
public class Accommodation {

    private String name;
    private ArrayList<Details> detailsList = new ArrayList<Details>();

    public Accommodation(String name, ArrayList<Details> detailsList) {
        this.name = name;
        this.detailsList = detailsList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Details> getDetailsList() {
        return detailsList;
    }

    public void setDetailsList(ArrayList<Details> detailsList) {
        this.detailsList = detailsList;
    }
}
