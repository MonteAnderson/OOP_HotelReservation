package com.hotelres;

import java.util.Map;
import java.util.List;

public class Hotel {
    private int id;
    private String location;
    private List<Booking> bookings;

    public int getId() {
        return id;
    }

    public List<Bookings> getBookings() {
        return bookings;
    }

    public String getLocation() {
        return location;
    }

    public void addBookings(Booking book) {}

    public Booking createBooking(int checkIn, int checkOut){}

    public void deleteBooking(Booking booking){}

    protected List<Hotel> search(Map<String, String> criteria){}

    private boolean verifyCard(int number, int cvv, String expire){}
}