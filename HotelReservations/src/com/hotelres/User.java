package com.hotelres;

import javax.swing.text.html.ListView;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class User {
    private List<Booking> bookings;

    public User(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void bookHotel(Hotel hotel) {

    }

    public void addBooking(Booking booking) {

    }

    public void cancelBooking(Booking booking) {

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