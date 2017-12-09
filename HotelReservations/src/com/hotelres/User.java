package com.hotelres;

import javax.swing.text.html.ListView;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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

    public List<Hotel> searchHotel(String location) {
        List<Hotel> hotelList = new LinkedList<>();
        return hotelList;
    }
}