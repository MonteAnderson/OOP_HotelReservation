package com.hotelres;

import javax.swing.text.html.ListView;
import java.util.List;
import java.util.Map;

public class HotelListController {
    private Hotel model;
    private ListView view;

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
        return;
    }

    public boolean validateCriteria(Map<String, String> criteria) {
        return false;
    }
}
