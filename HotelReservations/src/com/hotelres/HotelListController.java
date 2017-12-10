package com.hotelres;

import javax.swing.text.html.ListView;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class HotelListController {
    private Hotel model;
    private ListView view;
    private String[] criterias = new String[] {"location","name","rooms"};

    HotelListController(Hotel model, ListView view) {
        this.model = model;
        this.view = view;
    }

    public void listController() {

    }

    public void updateView() {

    }

    public Hotel getHotel(Hotel hotel) {
        return hotel;
    }

    public List<Hotel> getHotels(Map<String, String> criteria) {
        if(validateCriteria(criteria)){

        }
        List<Hotel> hotelList = new LinkedList<>();
        return hotelList;
    }

    public boolean validateCriteria(Map<String, String> criteria) {
        boolean ret = true;
        for(String attr : getCriterias()){
            if(!criteria.containsKey(attr)){
                ret = false;
            }
        }
        return ret;

    }

    public String[] getCriterias(){
        return this.criterias;
    }
}
