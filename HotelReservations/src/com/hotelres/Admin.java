package com.hotelres;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public class Admin {

    public void createAccount(String userName, String password){

    }

    public void updateUser(String userName, String query){

    }

    public void updateDatabase(String query) {

    }

    public List<Hotel> searchHotel(HotelListIterator hotelIter, String location) {
        List<Hotel> hotelList = new LinkedList<>();
        while (hotelIter.hasNext()) {
            Hotel nextHotel = hotelIter.next();
            if (Pattern.matches("(?i)^"+location+"[a-zA-z\\s]*", nextHotel.getLocation())) {
                hotelList.add(nextHotel);
            }
        }
        System.out.println(hotelList);
        return hotelList;
    }
}