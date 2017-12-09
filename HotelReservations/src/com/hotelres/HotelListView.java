package com.hotelres;

import java.util.List;

public class HotelListView {
    public void displayInfo(List<Hotel> hotels) {
        for(Hotel h : hotels){
            System.out.println(h)
        }

    }
}
