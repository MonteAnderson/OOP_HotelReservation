package com.hotelres;

import javax.swing.text.html.ListView;
import java.util.Map;

public class User {
    private Booking[] bookings;

    public User(Booking[] bookings) {
        this.bookings = bookings;
    }

    public Booking[] getBookings() {
        return bookings;
    }

    public void bookHotel(Hotel hotel) {

    }

    public void addBooking(Booking booking) {

    }

    public void cancelBooking(Booking booking) {

    }

    public Hotel[] searchHotel(String location) {
        return Hotel[];
    }
}